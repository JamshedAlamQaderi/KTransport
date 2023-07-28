plugins {
    `java-library`
    id("com.vanniktech.maven.publish")
}

java {
    sourceSets.getByName("main").resources.srcDir("src/main/proto")
}

mavenPublishing {
    pom {
        name.set("KTransport Protos")
        description.set("Proto files for KTransport")
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
