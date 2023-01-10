package com.jamshedalamqaderi.ktransport.ksp.interfaces

import java.io.File
import java.io.OutputStream

interface KTransportCodeGenerator {

    fun getJvmModuleDir(): File
    fun getCommonModuleDir(): File
    fun createNewJvmModuleFile(
        packageName: String,
        fileName: String,
        extensionName: String = "kt"
    ): OutputStream

    fun createNewCommonModuleFile(
        packageName: String,
        fileName: String,
        extensionName: String = "kt"
    ): OutputStream

    fun cleanAll()
}