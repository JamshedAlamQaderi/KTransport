package com.jamshedalamqaderi.ktransport.ksp.processors

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.ClassKind
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.jamshedalamqaderi.ktransport.api.annotations.KTransportService
import com.jamshedalamqaderi.ktransport.ksp.interfaces.KTransportCodeGenerator
import com.jamshedalamqaderi.ktransport.ksp.models.KTransportOption
import com.jamshedalamqaderi.ktransport.ksp.visitors.KTransportServiceVisitor

class KTransportProcessor(
    private val option: KTransportOption,
    private val logger: KSPLogger,
    private val codeGenerator: KTransportCodeGenerator,
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val kTransportServiceSymbols = resolver.getSymbolsWithAnnotation(KTransportService::class.qualifiedName!!)
            .filterIsInstance<KSClassDeclaration>()
            .filter { it.classKind == ClassKind.CLASS }
            .toList()
        kTransportServiceSymbols.forEach { ksClassDeclaration ->
            val kTransportServiceVisitor = KTransportServiceVisitor()
            ksClassDeclaration.accept(kTransportServiceVisitor, Unit)
        }
        return emptyList()
    }
}