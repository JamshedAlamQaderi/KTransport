plugins {
    kotlin("multiplatform")
    id("com.google.devtools.ksp")
}

ksp {
    arg("packageName", "com.jamshedalamqaderi.ktransport.example.ksp")
}

kotlin {
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":ktransport"))
            }
        }
    }
}

dependencies {
    add("kspCommonMainMetadata", project(":ktransport-ksp"))
}




