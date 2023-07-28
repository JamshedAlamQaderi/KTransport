import io.github.timortel.kotlin_multiplatform_grpc_plugin.generate_mulitplatform_sources.GenerateMultiplatformSourcesTask

plugins {
    kotlin("multiplatform")
    id("io.github.timortel.kotlin-multiplatform-grpc-plugin")
    id("com.android.library")
}

val grpcMPLibVersion: String by project
val coroutineVersion: String by project

dependencies {
    commonMainApi("com.github.TimOrtel.GRPC-Kotlin-Multiplatform:grpc-multiplatform-lib:$grpcMPLibVersion")
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("${project.projectDir}/src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
}

kotlin {
    android {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        publishLibraryVariants("release")
    }
    jvm()
    js(IR) {
        browser()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("com.github.TimOrtel.GRPC-Kotlin-Multiplatform:grpc-multiplatform-lib:$grpcMPLibVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
            }
            kotlin.srcDir("${buildDir.absolutePath}/generated/source/kmp-grpc/commonMain/kotlin")
        }

        val jvmMain by getting {
            dependencies {
                api(project(":generate-proto"))
                api("com.github.TimOrtel.GRPC-Kotlin-Multiplatform:grpc-multiplatform-lib-jvm:$grpcMPLibVersion")
            }
            kotlin.srcDir("${buildDir.absolutePath}/generated/source/kmp-grpc/jvmMain/kotlin")
        }
        val jsMain by getting {
            dependencies {
                api("com.github.TimOrtel.GRPC-Kotlin-Multiplatform:grpc-multiplatform-lib-js:$grpcMPLibVersion")
            }
            kotlin.srcDir("${buildDir.absolutePath}/generated/source/kmp-grpc/jsMain/kotlin")
        }
    }
}
tasks.register<GenerateMultiplatformSourcesTask>("generateMPProtos") {
    protoSourceFolders.set(listOf(projectDir.resolve("../protos/src/main/proto")))
}

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    filter {
        exclude { projectDir.toURI().relativize(it.file.toURI()).path.contains("/generated/") }
    }
}
