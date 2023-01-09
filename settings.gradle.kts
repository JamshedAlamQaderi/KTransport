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

        id("com.google.protobuf") version "0.8.18"
        id("io.github.timortel.kotlin-multiplatform-grpc-plugin") version "0.2.1"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        google()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "ktransport-project"

file("./grpc")
    .listFiles()
    ?.filter { it.isDirectory }
    ?.forEach { dir ->
        include(":${dir.name}")
        project(":${dir.name}").projectDir = dir.absoluteFile
    }
include(":ktransport")