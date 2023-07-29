@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "1.1.0"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
    id("io.woong.buildconfig") version "0.1.1"
}
val projectVersion: String? by project

group = "com.jamshedalamqaderi"
version = projectVersion?.replaceFirst("v", "") ?: "0.0.1-SNAPSHOT"

pluginBundle {
    website = "https://jamshedalamqaderi.com"
    vcsUrl = "https://github.com/JamshedAlamQaderi/KTransport"
    tags = listOf(
        "grpc",
        "grpc-server",
        "grpc-client",
        "kotlin-multiplatform",
        "ktransport",
        "client-server",
        "ktransport-plugin"
    )
}

gradlePlugin {
    plugins {
        create("ktransport-plugin") {
            id = "com.jamshedalamqaderi.ktransport.gradle-plugin"
            implementationClass = "com.jamshedalamqaderi.ktransport.plugin.KTransportPlugin"
            displayName = "KTransport Plugin"
            description =
                "A plugin for ktransport library which generate client side code for grpc server"
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    implementation("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.8.0-1.0.8")
    implementation("com.facebook:ktfmt:0.41")
    testImplementation(gradleTestKit())
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

buildConfig {
    this.packageName = "com.jamshedalamqaderi.ktransport.plugin"
    field("kTransportVersion", project.version.toString())
}