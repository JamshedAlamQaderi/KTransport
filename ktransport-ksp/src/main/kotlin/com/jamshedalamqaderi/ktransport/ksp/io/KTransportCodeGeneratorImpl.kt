package com.jamshedalamqaderi.ktransport.ksp.io

import com.jamshedalamqaderi.ktransport.ksp.interfaces.KTransportCodeGenerator
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class KTransportCodeGeneratorImpl : KTransportCodeGenerator {
    private val jvmModuleDir = "build/generated/ktransport/jvm/jvmMain/kotlin/"
    private val commonModuleDir = "build/generated/ktransport/metadata/commonMain/kotlin/"

    override fun createNewJvmModuleFile(
        packageName: String,
        fileName: String,
        extensionName: String
    ): OutputStream {
        return createNewFile(jvmModuleDir, packageName, fileName, extensionName)
    }

    override fun createNewCommonModuleFile(
        packageName: String,
        fileName: String,
        extensionName: String
    ): OutputStream {
        return createNewFile(commonModuleDir, packageName, fileName, extensionName)
    }

    private fun createNewFile(
        modulePath: String,
        packageName: String,
        fileName: String,
        extensionName: String
    ): OutputStream {
        val saveDir = File(modulePath, packageName.replace(".", "/"))
        if (!saveDir.exists()) {
            if (!saveDir.mkdirs()) {
                throw FileSystemException(saveDir, null, "Couldn't making the directory")
            }
        }
        return FileOutputStream(File(saveDir, "$fileName.$extensionName"))
    }
}