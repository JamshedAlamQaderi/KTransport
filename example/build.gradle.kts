import com.jamshedalamqaderi.ktransport.plugin.KTransportDeps

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.jamshedalamqaderi.ktransport.gradle-plugin") version "1.0.3"
}

ktransport {
    packageName = "com.jamshedalamqaderi.ktransport.example.ksp"
}

val kotlinxSerializationVersion: String by project
val coroutineVersion: String by project
val kotlinVersion: String by project

kotlin {
    jvm {
        withJava()
    }
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(KTransportDeps.ktransport)
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {}
        }
    }
}
