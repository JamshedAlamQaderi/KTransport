plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
}

ksp {
    arg("packageName", "com.jamshedalamqaderi.ktransport.example.ksp")
}

val kotlinxSerializationVersion: String by project
val coroutineVersion: String by project

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
    }
}

dependencies {
    add("kspCommonMainMetadata", project(":ktransport-ksp"))
}




