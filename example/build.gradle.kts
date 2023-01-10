plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
}

ksp {
    arg("packageName", "com.jamshedalamqaderi.ktransport.example.ksp")
    arg("buildDir", buildDir.absolutePath)
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
            kotlin.srcDir(projectDir.resolve("build/generated/ktransport/metadata/commonMain/kotlin/"))
        }
        val jvmMain by getting{
            dependencies{
                implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
            }
            kotlin.srcDir(projectDir.resolve("build/generated/ktransport/jvm/jvmMain/kotlin/"))
        }
    }
}

dependencies {
    add("kspJvm", project(":ktransport-ksp"))
}




