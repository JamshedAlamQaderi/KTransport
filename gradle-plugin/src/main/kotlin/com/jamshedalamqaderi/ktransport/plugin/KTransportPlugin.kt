package com.jamshedalamqaderi.ktransport.plugin

import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create

class KTransportPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create<KTransportPluginExtension>("ktransport")

        if (!project.plugins.hasPlugin("com.google.devtools.ksp")) {
            project.pluginManager.apply("com.google.devtools.ksp")
        }

        project.afterEvaluate {
            project.configure<KspExtension> {
                arg(
                    "buildDir",
                    extension.outputBuildDir ?: project.buildDir.absolutePath
                )
                arg("packageName", extension.packageName ?: "ktransport")
            }

            dependencies.add("kspJvm", KTransportDeps.ksp)
            val kotlinExtension =
                extensions.getByName("kotlin") as org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
            val kotlinSourceSets = kotlinExtension.sourceSets
            kotlinSourceSets.getByName("commonMain") {
                kotlin.srcDir(commonMainOutputDir(this@afterEvaluate))
            }
            kotlinSourceSets.getByName("jvmMain") {
                kotlin.srcDir(jvmMainOutputDir(this@afterEvaluate))
            }
        }

        project.tasks.register("generateApi") {
            group = "KTransport"
            description = "Generate client code from KTransport services"
            dependsOn("kspKotlinJvm")
            dependsOn("formatGeneratedCode")
        }

        project.tasks.register("formatGeneratedCode") {
            group = "KTransport"
            description = "Format generated code by KTransport"
            doLast {
                com.facebook.ktfmt.cli.Main.main(
                    arrayOf(
                        "--kotlinlang-style",
                        "${project.buildDir}/generated/ktransport/"
                    )
                )
            }
        }
    }

    private fun commonMainOutputDir(project: Project): String {
        return "${project.buildDir}/generated/ktransport/metadata/commonMain/kotlin/"
    }

    private fun jvmMainOutputDir(project: Project): String {
        return "${project.buildDir}/generated/ktransport/jvm/jvmMain/kotlin/"
    }
}