package com.jamshedalamqaderi.ktransport.ksp.visitors

import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.squareup.kotlinpoet.FileSpec

class KTransportServiceVisitorCommon(private val fileSpecBuilder: FileSpec.Builder) : KSVisitorVoid() {
}