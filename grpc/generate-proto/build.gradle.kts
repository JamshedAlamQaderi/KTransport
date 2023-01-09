import com.google.protobuf.gradle.*
import org.apache.tools.ant.taskdefs.condition.Os

plugins {
    kotlin("jvm")
    java
    id("com.google.protobuf")
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