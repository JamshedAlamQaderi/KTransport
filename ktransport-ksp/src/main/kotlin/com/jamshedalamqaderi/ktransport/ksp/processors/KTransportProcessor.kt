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
import com.jamshedalamqaderi.ktransport.ksp.interfaces.MultiServiceVisitor
import com.jamshedalamqaderi.ktransport.ksp.models.KTransportOption
import com.jamshedalamqaderi.ktransport.ksp.visitors.IndividualCommonServiceVisitor
import com.jamshedalamqaderi.ktransport.ksp.visitors.MultipleCommonServiceVisitor
import com.jamshedalamqaderi.ktransport.ksp.visitors.MultipleJvmServiceVisitor
import com.squareup.kotlinpoet.FileSpec
import java.io.File

class KTransportProcessor(
    private val option: KTransportOption,
    private val logger: KSPLogger,
    private val codeGenerator: KTransportCodeGenerator,
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
//        codeGenerator.cleanAll()

        val kTransportServiceSymbols =
            resolver.getSymbolsWithAnnotation(KTransportService::class.qualifiedName!!)
                .filterIsInstance<KSClassDeclaration>()
                .filter { it.classKind == ClassKind.CLASS }
                .toList()

        kTransportServiceSymbols.forEach { ksClassDeclaration ->
            visitIndividualServices(
                ksClassDeclaration,
                codeGenerator.getCommonModuleDir(),
                ::IndividualCommonServiceVisitor
            )
        }
        visitMultipleServiceInOneVisitor(
            codeGenerator.getJvmModuleDir(),
            "server",
            "KTransportServerExt",
            kTransportServiceSymbols,
            ::MultipleJvmServiceVisitor
        )
        visitMultipleServiceInOneVisitor(
            codeGenerator.getCommonModuleDir(),
            "client",
            "KTransportClientExt",
            kTransportServiceSymbols,
            ::MultipleCommonServiceVisitor
        )
        return emptyList()
    }


    private fun visitIndividualServices(
        ksClassDeclaration: KSClassDeclaration,
        outputDir: File,
        block: (KSPLogger, FileSpec.Builder) -> KSVisitorVoid
    ) {
        val fileSpecBuilder =
            FileSpec.builder(
                option.packageName + ".client",
                ksClassDeclaration.simpleName.asString()
            )
        val visitor = block(logger, fileSpecBuilder)
        ksClassDeclaration.accept(visitor, Unit)
        val fileSpec = fileSpecBuilder.build()
        fileSpec.writeTo(outputDir)
    }

    private fun visitMultipleServiceInOneVisitor(
        outputDir: File,
        packageSuffix: String,
        filename: String,
        kTransportServiceSymbols: List<KSClassDeclaration>,
        block: (List<KSClassDeclaration>, FileSpec.Builder, KSPLogger) -> MultiServiceVisitor
    ) {
        val fileSpecBuilder = FileSpec.builder(
            option.packageName + ".$packageSuffix",
            filename
        )
        val visitor = block(
            kTransportServiceSymbols,
            fileSpecBuilder,
            logger
        )

        visitor.commit()
        val fileSpec = fileSpecBuilder.build()
        fileSpec.writeTo(outputDir)
    }
}