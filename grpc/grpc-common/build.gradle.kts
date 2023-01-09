plugins {
    kotlin("multiplatform")
    id("io.github.timortel.kotlin-multiplatform-grpc-plugin")
}

val grpcMPLibVersion: String by project
val coroutineVersion: String by project

grpcKotlinMultiplatform{
    protoSourceFolders.set(listOf(projectDir.resolve("../protos/src/main/proto")))
}

kotlin {
    jvm()
    js(IR) {
        useCommonJs()
        browser()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.github.TimOrtel.GRPC-Kotlin-Multiplatform:grpc-multiplatform-lib:$grpcMPLibVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
            }
            kotlin.srcDir(projectDir.resolve("build/generated/source/kmp-grpc/commonMain/kotlin").canonicalPath)
        }

        val jvmMain by getting {
            dependencies {
                implementation(project(":generate-proto"))
                implementation("com.github.TimOrtel.GRPC-Kotlin-Multiplatform:grpc-multiplatform-lib-jvm:$grpcMPLibVersion")
            }
            kotlin.srcDir(projectDir.resolve("build/generated/source/kmp-grpc/jvmMain/kotlin").canonicalPath)
        }
        val jsMain by getting {
            dependencies {
                implementation("com.github.TimOrtel.GRPC-Kotlin-Multiplatform:grpc-multiplatform-lib-js:$grpcMPLibVersion")
            }
            kotlin.srcDir(projectDir.resolve("build/generated/source/kmp-grpc/jsMain/kotlin").canonicalPath)
        }
    }
}