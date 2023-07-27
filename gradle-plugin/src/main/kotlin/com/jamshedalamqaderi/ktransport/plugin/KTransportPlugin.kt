package com.jamshedalamqaderi.ktransport.plugin

import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create

class KTransportPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create<KTransportPluginExtension>("ktransport")
        extension.packageName.convention("ktransport")

        project.pluginManager.apply("com.google.devtools.ksp")

        project.afterEvaluate {
            project.configure<KspExtension> {
                arg(
                    "buildDir",
                    project.buildDir.absolutePath
                )
                arg("packageName", extension.packageName.get())
            }

            dependencies.add("kspJvm", KTransportDeps.ksp)
            val kotlinExtension =
                extensions.getByName("kotlin") as org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
            val kotlinSourceSets = kotlinExtension.sourceSets
            kotlinSourceSets.getByName("commonMain") {
                kotlin.srcDir(commonMainOutputDir(this@afterEvaluate))
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
}