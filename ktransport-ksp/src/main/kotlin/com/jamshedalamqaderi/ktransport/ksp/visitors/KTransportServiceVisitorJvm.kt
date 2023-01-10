package com.jamshedalamqaderi.ktransport.ksp.visitors

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getDeclaredFunctions
import com.google.devtools.ksp.isAnnotationPresent
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSTypeReference
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.jamshedalamqaderi.ktransport.api.KTransport
import com.jamshedalamqaderi.ktransport.api.annotations.KTransportApi
import com.jamshedalamqaderi.ktransport.api.annotations.KTransportStream
import com.jamshedalamqaderi.ktransport.api.enums.FunctionResponseType
import com.jamshedalamqaderi.ktransport.api.models.ApiFunctionDescription
import com.jamshedalamqaderi.ktransport.api.models.ServiceDescription
import com.jamshedalamqaderi.ktransport.api.models.StreamFunctionDescription
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.asTypeName

class KTransportServiceVisitorJvm(
    private val classes: List<KSClassDeclaration>,
    private val fileSpecBuilder: FileSpec.Builder,
    private val logger: KSPLogger,
) : KSVisitorVoid() {
    private val servicesListCodeBlockBuilder = CodeBlock.builder()
    private var singleServiceBuilder: CodeBlock.Builder? = null
    init {
        if (classes.isNotEmpty()) {
            fileSpecBuilder.addImport(
                "kotlinx.serialization",
                listOf("encodeToString", "decodeFromString")
            )
            fileSpecBuilder.addImport("kotlinx.serialization.json", listOf("Json"))
        }
        servicesListCodeBlockBuilder.addStatement("listOf(")
        classes.forEach {
            it.accept(this, Unit)
        }
        servicesListCodeBlockBuilder.addStatement(")")
    }

    @KspExperimental
    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        singleServiceBuilder = CodeBlock.builder()
        singleServiceBuilder?.addStatement(
            "%T(${classDeclaration.qualifiedName?.asString()}(),",
            ServiceDescription::class,
        )
        val ktransportFunctions = classDeclaration.getDeclaredFunctions().filter {
            it.isAnnotationPresent(KTransportApi::class)
                    || it.isAnnotationPresent(KTransportStream::class)
        }.toList()
        singleServiceBuilder?.addStatement("listOf(")
        ktransportFunctions.forEach {
            visitFunctionDeclaration(it, Unit)
        }
        singleServiceBuilder?.addStatement(")")

        singleServiceBuilder?.addStatement(")")
        servicesListCodeBlockBuilder.add(singleServiceBuilder?.build()!!)
    }

    @OptIn(KspExperimental::class)
    override fun visitFunctionDeclaration(
        function: KSFunctionDeclaration,
        data: Unit
    ) {
        val functionResponseType =
            if (function.isAnnotationPresent(KTransportApi::class)) {
                FunctionResponseType.API
            } else if (function.isAnnotationPresent(KTransportStream::class)) {
                FunctionResponseType.STREAM
            } else {
                null
            }
        if (functionResponseType == null) return

        singleServiceBuilder?.addStatement(
            "%T<",
            if (functionResponseType == FunctionResponseType.STREAM)
                StreamFunctionDescription::class
            else ApiFunctionDescription::class
        )
        if (function.parameters.isNotEmpty()) {
            singleServiceBuilder?.addStatement(
                "${
                    function.parameters
                        .first().type.resolve().declaration.qualifiedName?.asString()
                }"
            )
        } else {
            singleServiceBuilder?.addStatement("Unit")
        }
        singleServiceBuilder?.addStatement(",")
        singleServiceBuilder?.addStatement(
            retrieveTypedReturnType(function.returnType!!)
        )
        singleServiceBuilder?.addStatement(">(")
        singleServiceBuilder?.addStatement("%S,", function.qualifiedName?.asString())
        singleServiceBuilder?.addStatement("${FunctionResponseType::class.qualifiedName}.${functionResponseType.name},")
        singleServiceBuilder?.addStatement(
            "${
                function.parentDeclaration
                    ?.qualifiedName?.asString()
            }::${function.simpleName.asString()},"
        )
        singleServiceBuilder?.addStatement("Json.Default::decodeFromString,")
        singleServiceBuilder?.addStatement("Json.Default::encodeToString,")
        singleServiceBuilder?.addStatement("),")
    }

    fun buildCodeBlock() {
        addServicesVariable(servicesListCodeBlockBuilder.build())
    }

    private fun retrieveTypedReturnType(typeReference: KSTypeReference): String {
        if (typeReference.resolve().arguments.isEmpty()) {
            return "${typeReference.resolve().declaration.qualifiedName?.asString()}"
        } else {
            return "${
                typeReference.resolve().arguments.first()
                    .type?.resolve()?.declaration?.qualifiedName?.asString()
            }"
        }
    }

    private fun addServicesVariable(codeBlock: CodeBlock) {
        fileSpecBuilder.addProperty(
            PropertySpec.builder(
                "services",
                ClassName(
                    "kotlin.collections",
                    "List"
                ).parameterizedBy(ServiceDescription::class.asTypeName())
            )
                .receiver(KTransport::class)
                .getter(
                    FunSpec.getterBuilder()
                        .addStatement("return ${codeBlock.toString()}")
                        .build()
                )
                .build()
        )
    }
}