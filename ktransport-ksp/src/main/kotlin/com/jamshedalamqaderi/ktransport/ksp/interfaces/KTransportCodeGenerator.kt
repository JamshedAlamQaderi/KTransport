package com.jamshedalamqaderi.ktransport.ksp.interfaces

import java.io.OutputStream

interface KTransportCodeGenerator {
    fun createNewJvmModuleFile(
        packageName: String,
        fileName: String,
        extensionName: String
    ): OutputStream

    fun createNewCommonModuleFile(
        packageName: String,
        fileName: String,
        extensionName: String
    ): OutputStream
}