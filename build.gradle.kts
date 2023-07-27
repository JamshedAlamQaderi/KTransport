plugins {
    kotlin("multiplatform") apply false
    kotlin("jvm") apply false
    kotlin("plugin.serialization") apply false

    id("com.google.protobuf") apply false
    id("io.github.timortel.kotlin-multiplatform-grpc-plugin") apply false
    id("org.jlleitschuh.gradle.ktlint")
    id("org.jetbrains.kotlinx.kover")
    id("com.vanniktech.maven.publish") apply false
}

val projectVersion: String? by project

allprojects {

    group = "com.jamshedalamqaderi.ktransport"

    version = projectVersion?.replaceFirst("v", "", ignoreCase = true) ?: "0.0.1-SNAPSHOT"

    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "org.jetbrains.kotlinx.kover")
}

tasks.register("publishToGradlePluginPortal") {
    dependsOn(gradle.includedBuild("gradle-plugin").task(":publishPlugins"))
}
