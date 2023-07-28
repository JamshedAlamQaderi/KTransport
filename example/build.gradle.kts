plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
//    id("com.jamshedalamqaderi.ktransport.gradle-plugin") version "1.0.0"
    id("com.google.devtools.ksp")
}

//ktransport {
//    packageName = "com.jamshedalamqaderi.ktransport.example.ksp"
//}

ksp {
    arg(
        "buildDir",
        buildDir.absolutePath
    )
    arg("packageName", "com.jamshedalamqaderi.ktransport.example.ksp")
}

val kotlinxSerializationVersion: String by project
val coroutineVersion: String by project
val kotlinVersion: String by project

kotlin {
    jvm()
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
//                implementation(project(":ktransport"))
                implementation("com.jamshedalamqaderi.ktransport:ktransport:0.0.1-dev-18")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
            }
            kotlin.srcDir("${buildDir.absolutePath}/generated/ktransport/metadata/commonMain/kotlin")
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {}
            kotlin.srcDir("${buildDir.absolutePath}/generated/ktransport/jvm/jvmMain/kotlin")
        }
    }
}

dependencies {
//    add("kspJvm", project(":ktransport-ksp"))
    add("kspJvm", "com.jamshedalamqaderi.ktransport:ktransport-ksp:0.0.1-dev-18")
}
