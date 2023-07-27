plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.jamshedalamqaderi.ktransport.gradle-plugin")
}

ktransport {
    packageName.set("com.jamshedalamqaderi.ktransport.example.ksp")
}

val kotlinxSerializationVersion: String by project
val coroutineVersion: String by project
val kotlinVersion: String by project

kotlin {
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":ktransport"))
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
