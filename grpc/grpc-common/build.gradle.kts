import io.github.timortel.kotlin_multiplatform_grpc_plugin.generate_mulitplatform_sources.GenerateMultiplatformSourcesTask

plugins {
    kotlin("multiplatform")
    id("io.github.timortel.kotlin-multiplatform-grpc-plugin")
    id("com.vanniktech.maven.publish")
}

val grpcMPLibVersion: String by project
val coroutineVersion: String by project

dependencies {
    commonMainApi("com.github.TimOrtel.GRPC-Kotlin-Multiplatform:grpc-multiplatform-lib:$grpcMPLibVersion")
}

kotlin {
    jvm()
    js(IR) {
        useCommonJs()
        browser()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("com.github.TimOrtel.GRPC-Kotlin-Multiplatform:grpc-multiplatform-lib:$grpcMPLibVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
            }
            kotlin.srcDir("${buildDir.absolutePath}/generated/source/kmp-grpc/commonMain/kotlin")
        }

        val jvmMain by getting {
            dependencies {
                api(project(":generate-proto"))
                api("com.github.TimOrtel.GRPC-Kotlin-Multiplatform:grpc-multiplatform-lib-jvm:$grpcMPLibVersion")
            }
            kotlin.srcDir("${buildDir.absolutePath}/generated/source/kmp-grpc/jvmMain/kotlin")
        }
        val jsMain by getting {
            dependencies {
                api("com.github.TimOrtel.GRPC-Kotlin-Multiplatform:grpc-multiplatform-lib-js:$grpcMPLibVersion")
            }
            kotlin.srcDir("${buildDir.absolutePath}/generated/source/kmp-grpc/jsMain/kotlin")
        }
    }
}
tasks.register<GenerateMultiplatformSourcesTask>("generateMPProtos") {
    protoSourceFolders.set(listOf(projectDir.resolve("../protos/src/main/proto")))
}

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    filter {
        exclude { projectDir.toURI().relativize(it.file.toURI()).path.contains("/generated/") }
    }
}

mavenPublishing {
    pom {
        name.set("KTransport GRPC Common")
        description.set("gRPC multiplatform supports for KTransport")
        inceptionYear.set("2023")
        url.set("https://github.com/JamshedAlamQaderi/KTransport")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("JamshedAlamQaderi")
                name.set("Jamshed Alam Qaderi")
                url.set("https://github.com/JamshedAlamQaderi")
            }
        }
        scm {
            url.set("https://github.com/JamshedAlamQaderi/KTransport")
            connection.set("scm:git:git://github.com/JamshedAlamQaderi/KTransport.git")
            developerConnection.set("scm:git:ssh://git@github.com/JamshedAlamQaderi/KTransport.git")
        }
    }
    signAllPublications()
    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.S01, true)
}
