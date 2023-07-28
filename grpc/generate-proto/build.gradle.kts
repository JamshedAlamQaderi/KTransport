import com.google.protobuf.gradle.builtins
import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.ofSourceSet
import com.google.protobuf.gradle.plugins
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    kotlin("jvm")
    id("com.google.protobuf")
    id("com.vanniktech.maven.publish")
}

val protobufVersion: String by project
val grpcVersion: String by project
val grpcKotlinVersion: String by project
val coroutineVersion: String by project

dependencies {
    protobuf(project(":protos"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
    api("com.google.protobuf:protobuf-kotlin:$protobufVersion")
    api("com.google.protobuf:protobuf-java-util:$protobufVersion")
    api("io.grpc:grpc-protobuf:$grpcVersion")
    api("io.grpc:grpc-stub:$grpcVersion")
    api("io.grpc:grpc-kotlin-stub:$grpcKotlinVersion")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:$grpcKotlinVersion:jdk7@jar"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc") {
                    option("lite")
                }
                id("grpckt") {
                    option("lite")
                }
            }

            it.builtins {
                id("kotlin") {
                    option("lite")
                }
            }
        }
    }
}

mavenPublishing {
    pom {
        name.set("KTransport Proto Generator")
        description.set("Proto Generator for KTransport gRPC Common")
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
