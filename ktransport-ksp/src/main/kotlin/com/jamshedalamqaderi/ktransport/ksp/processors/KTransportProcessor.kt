package com.jamshedalamqaderi.ktransport.ksp.processors

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.ClassKind
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.jamshedalamqaderi.ktransport.api.annotations.KTransportService
import com.jamshedalamqaderi.ktransport.ksp.interfaces.KTransportCodeGenerator
import com.jamshedalamqaderi.ktransport.ksp.models.KTransportOption
import com.jamshedalamqaderi.ktransport.ksp.visitors.KTransportServiceVisitorCommon
import com.squareup.kotlinpoet.FileSpec
import java.io.File

class KTransportProcessor(
    private val option: KTransportOption,
    private val logger: KSPLogger,
    private val codeGenerator: KTransportCodeGenerator,
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
        codeGenerator.cleanAll()

        val kTransportServiceSymbols = resolver.getSymbolsWithAnnotation(KTransportService::class.qualifiedName!!)
            .filterIsInstance<KSClassDeclaration>()
            .filter { it.classKind == ClassKind.CLASS }
            .toList()

        kTransportServiceSymbols.forEach { ksClassDeclaration ->
            visitAndSave(ksClassDeclaration, codeGenerator.getCommonModuleDir(), ::KTransportServiceVisitorCommon)
        }



        return emptyList()
    }

    private fun visitAndSave(
        ksClassDeclaration: KSClassDeclaration,
        outputDir: File,
        block: (FileSpec.Builder) -> KSVisitorVoid
    ) {
        val fileSpecBuilder = FileSpec.builder(option.packageName, ksClassDeclaration.simpleName.asString())
        val visitor = block(fileSpecBuilder)
        ksClassDeclaration.accept(visitor, Unit)
        val fileSpec = fileSpecBuilder.build()
        fileSpec.writeTo(outputDir)
    }
}