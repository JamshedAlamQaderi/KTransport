plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

val kotlinxSerializationVersion: String by project
val grpcVersion: String by project
val coroutineVersion: String by project
val kotlinVersion: String by project

kotlin {
    jvm {
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        browser {
            webpackTask {}
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
                implementation(project(":grpc-common"))
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation("io.grpc:grpc-netty-shaded:$grpcVersion")
                implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
            }
        }

        val jvmTest by getting {
            dependencies {
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(npm("google-protobuf", "^3.19.1"))
                implementation(npm("grpc-web", "^1.3.0"))
                implementation(npm("protobufjs", "^6.11.2"))
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}
