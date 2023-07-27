plugins {
    kotlin("jvm")
    id("com.vanniktech.maven.publish")
}

val kspVersion: String by project
val kotlinPoetVersion: String by project
val kotlinVersion: String by project

dependencies {
    implementation(project(":ktransport"))
    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
    implementation("com.squareup:kotlinpoet:$kotlinPoetVersion")
    implementation("com.squareup:kotlinpoet-ksp:$kotlinPoetVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    testImplementation(kotlin("test"))
}

mavenPublishing {
    pom {
        name.set("KTransport KSP")
        description.set("A code generator KSP plugin for KTransport")
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
    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.S01)
}
