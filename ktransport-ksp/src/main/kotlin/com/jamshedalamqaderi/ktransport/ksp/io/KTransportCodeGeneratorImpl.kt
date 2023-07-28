package com.jamshedalamqaderi.ktransport.ksp.io

import com.google.devtools.ksp.processing.KSPLogger
import com.jamshedalamqaderi.ktransport.ksp.interfaces.KTransportCodeGenerator
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class KTransportCodeGeneratorImpl(
    buildDir: String,
    private val logger: KSPLogger
) : KTransportCodeGenerator {
    private val baseDir = "$buildDir/generated/ktransport"
    private val jvmModuleDir = "$baseDir/jvm/jvmMain/kotlin/"
    private val commonModuleDir = "$baseDir/metadata/commonMain/kotlin/"

    override fun getJvmModuleDir(): File {
        return File(jvmModuleDir)
    }

    override fun getCommonModuleDir(): File {
        return File(commonModuleDir)
    }

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

    override fun cleanAll() {
        val deleteDir = File(baseDir)
        if (deleteDir.deleteRecursively()) {
            logger.warn("Cleaned all files and folders located at path: $deleteDir")
        } else {
            logger.error("Couldn't clean all files and folders from path: $deleteDir")
        }
    }

    private fun createNewFile(
        modulePath: String,
        packageName: String,
        fileName: String,
        extensionName: String
    ): OutputStream {
        val saveDir = File(modulePath, packageName.replace(".", "/"))
        logger.warn("File: ${saveDir.absolutePath}")
        if (!saveDir.exists()) {
            if (!saveDir.mkdirs()) {
                throw FileSystemException(saveDir, null, "Couldn't making the directory")
            }
        }
        return FileOutputStream(File(saveDir, "$fileName.$extensionName"))
    }
}
