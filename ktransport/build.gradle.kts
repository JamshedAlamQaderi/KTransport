plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.vanniktech.maven.publish")
}

val kotlinxSerializationVersion: String by project
val grpcVersion: String by project
val coroutineVersion: String by project
val kotlinVersion: String by project

kotlin {
    jvm {
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        browser {
            webpackTask {}
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")
                implementation(project(":grpc-common"))
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation("io.grpc:grpc-netty-shaded:$grpcVersion")
                implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
            }
        }

        val jvmTest by getting {
            dependencies {
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(npm("google-protobuf", "^3.19.1"))
                implementation(npm("grpc-web", "^1.3.0"))
                implementation(npm("protobufjs", "^6.11.2"))
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}

mavenPublishing {
    pom {
        name.set("KTransport")
        description.set("KTransport is a simple multiplatform API library built on top of gRPC that handles requests and responses internally")
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