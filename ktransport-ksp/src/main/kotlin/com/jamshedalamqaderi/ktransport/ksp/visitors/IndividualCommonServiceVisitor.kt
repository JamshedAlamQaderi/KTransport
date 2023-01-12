package com.jamshedalamqaderi.ktransport.ksp.visitors

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getDeclaredFunctions
import com.google.devtools.ksp.isAnnotationPresent
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSTypeReference
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.jamshedalamqaderi.ktransport.api.annotations.KTransportApi
import com.jamshedalamqaderi.ktransport.api.annotations.KTransportStream
import com.jamshedalamqaderi.ktransport.api.enums.FunctionResponseType
import com.jamshedalamqaderi.ktransport.ksp.ext.KSTypeReferenceExt.typeParamFormat
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.ksp.toTypeName

class IndividualCommonServiceVisitor(
    private val logger: KSPLogger,
    private val fileSpecBuilder: FileSpec.Builder
) : KSVisitorVoid() {
    private lateinit var typeSpecBuilder: TypeSpec.Builder

    init {
        fileSpecBuilder.addImport(
            "com.jamshedalamqaderi.ktransport.api",
            listOf("makeApiRequest", "makeStreamRequest")
        )
        fileSpecBuilder.addImport("kotlin.reflect", "typeOf")
    }

    @OptIn(KspExperimental::class)
    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {

        typeSpecBuilder = TypeSpec
            .classBuilder(classDeclaration.simpleName.asString())
            .primaryConstructor(
                FunSpec.constructorBuilder()
                    .addModifiers(KModifier.PRIVATE)
                    .build()
            )
            .addType(
                TypeSpec.companionObjectBuilder()
                    .addProperty(
                        PropertySpec.builder(
                            "INSTANCE",
                            ClassName(
                                "",
                                classDeclaration.simpleName.asString()
                            )
                        )
                            .initializer("${classDeclaration.simpleName.asString()}()")
                            .build()
                    )
                    .build()
            )

        classDeclaration.getDeclaredFunctions().filter {
            it.isAnnotationPresent(KTransportApi::class) ||
                it.isAnnotationPresent(KTransportStream::class)
        }.forEach {
            visitFunctionDeclaration(it, Unit)
        }
        fileSpecBuilder.addType(typeSpecBuilder.build())
    }

    override fun visitFunctionDeclaration(function: KSFunctionDeclaration, data: Unit) {
        val funSpec = FunSpec.builder(function.simpleName.asString())
            .returns(function.returnType?.toTypeName()!!)
            .addModifiers(KModifier.SUSPEND)
            .addCode("return ${generateRequestCodeBlock(function)}")
        if (function.parameters.isNotEmpty()) {
            val firstParam = function.parameters.first()
            funSpec.addParameter("${firstParam.name?.asString()}", firstParam.type.toTypeName())
        }
        typeSpecBuilder.addFunction(funSpec.build())
    }

    @OptIn(KspExperimental::class)
    private fun generateRequestCodeBlock(function: KSFunctionDeclaration): CodeBlock {
        val functionResponseType = if (function.isAnnotationPresent(KTransportStream::class)) {
            FunctionResponseType.STREAM
        } else {
            FunctionResponseType.API
        }
        val inputType = if (function.parameters.isEmpty()) {
            "Unit"
        } else {
            function.parameters.first().type.resolve().declaration.qualifiedName?.asString()
        }
        val returnType = function.returnType?.typeParamFormat()!!
        val inputValue = if (function.parameters.isEmpty()) {
            "Unit"
        } else {
            function.parameters.first().name?.asString()
        }
        return CodeBlock.builder()
            .add(if (functionResponseType == FunctionResponseType.STREAM) "makeStreamRequest" else "makeApiRequest")
            .add("<")
            .add("$inputType,")
            .add(returnType)
            .add(">")
            .add("(")
            .add("\"${function.qualifiedName?.asString()}\",")
            .add("$inputValue,")
            .add("typeOf<$inputType>(),")
            .add("typeOf<$returnType>(),")
            .add(")")
            .build()
    }

    private fun formatTypeWithParam(type: KSTypeReference): String {
        val returnType = type.resolve().declaration.qualifiedName?.asString()!!
        if (type.resolve().arguments.isNotEmpty()) {
            return "$returnType<${type.typeParamFormat()}>"
        }
        return returnType
    }
}
