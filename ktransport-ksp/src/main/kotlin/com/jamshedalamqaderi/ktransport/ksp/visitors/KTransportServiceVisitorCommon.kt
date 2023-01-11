package com.jamshedalamqaderi.ktransport.ksp.visitors

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.squareup.kotlinpoet.FileSpec

class KTransportServiceVisitorCommon(
    private val logger: KSPLogger,
    private val fileSpecBuilder: FileSpec.Builder
) : KSVisitorVoid() {
    init {

    }

    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {

    }

}