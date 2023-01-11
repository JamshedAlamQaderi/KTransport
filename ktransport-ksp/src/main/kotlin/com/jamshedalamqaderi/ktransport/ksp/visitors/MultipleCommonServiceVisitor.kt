package com.jamshedalamqaderi.ktransport.ksp.visitors

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.jamshedalamqaderi.ktransport.api.KTransport
import com.jamshedalamqaderi.ktransport.ksp.ext.StringExt.toCamelCase
import com.jamshedalamqaderi.ktransport.ksp.interfaces.MultiServiceVisitor
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.PropertySpec

class MultipleCommonServiceVisitor(
    private val classes: List<KSClassDeclaration>,
    private val fileSpecBuilder: FileSpec.Builder,
    private val logger: KSPLogger,
) : MultiServiceVisitor() {

    init {
        classes.forEach {
            it.accept(this, Unit)
        }
    }

    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        val className = classDeclaration.simpleName.asString()
        val propertySpec = PropertySpec.builder(
            className.toCamelCase(),
            ClassName(fileSpecBuilder.packageName, className)
        )
            .receiver(KTransport::class)
            .getter(
                FunSpec.getterBuilder()
                    .addCode("return $className.INSTANCE")
                    .build()
            )
            .build()
        fileSpecBuilder.addProperty(propertySpec)
    }

    override fun commit() {
        // do nothing
    }
}