pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven(url = "https://jitpack.io")
    }

    plugins {
        kotlin("multiplatform") version extra["kotlinVersion"] as String
        kotlin("jvm") version extra["kotlinVersion"] as String
        kotlin("plugin.serialization") version extra["kotlinVersion"] as String
        id("com.android.library") version extra["agpVersion"] as String

        id("com.google.protobuf") version "0.8.18"
        id("io.github.timortel.kotlin-multiplatform-grpc-plugin") version "0.1.1"
        id("com.google.devtools.ksp") version extra["kspVersion"] as String
        id("org.jlleitschuh.gradle.ktlint") version extra["ktlintVersion"] as String
        id("org.jetbrains.kotlinx.kover") version extra["koverVersion"] as String
        id("com.vanniktech.maven.publish") version extra["publishVersion"] as String
    }
}

dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        google()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "ktransport-project"

include(":example")
includeBuild("./gradle-plugin")
include(":ktransport", ":ktransport-ksp")

file("./grpc")
    .listFiles()
    ?.filter { it.isDirectory }
    ?.forEach { dir ->
        include(":${dir.name}")
        project(":${dir.name}").projectDir = dir.absoluteFile
    }
