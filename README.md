![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android) ![JVM](https://img.shields.io/badge/JVM-007396?style=for-the-badge&logo=kotlin) ![JS](https://img.shields.io/badge/Kotlin/Js-F7DF1E?style=for-the-badge&logo=kotlin) ![Kotlin/Wasm](https://img.shields.io/badge/Kotlin%2FWASM-0095D5?&style=for-the-badge&logo=kotlin)
 
 # KTransport
 
 ![CI](https://github.com/JamshedAlamQaderi/KTransport/actions/workflows/ci.yaml/badge.svg) ![Analyse](https://github.com/JamshedAlamQaderi/KTransport/actions/workflows/analysis.yaml/badge.svg) ![Publish](https://github.com/JamshedAlamQaderi/KTransport/actions/workflows/publish.yaml/badge.svg) [![CodeFactor](https://www.codefactor.io/repository/github/jamshedalamqaderi/ktransport/badge)](https://www.codefactor.io/repository/github/jamshedalamqaderi/ktransport) [![Coverage](https://codecov.io/gh/JamshedAlamQaderi/KTransport/branch/main/graph/badge.svg?token=AAVO2UQXLP)](https://codecov.io/gh/JamshedAlamQaderi/KTransport)

KTransport is a Kotlin Multiplatform library built on top of gRPC, that enables you to easily create
cross-platform
communication between your apps and services.

## Features

- Easy to use API for creating gRPC services and clients in Kotlin.
- Support for both unary and server side streaming RPCs.
- Built on top of gRPC, ensuring compatibility with other platforms.

## Supported Platforms

- Android
- JVM
- JavaScript (JS)
- Wasm (Need to use tricks because of its experimental issues)

## Getting Started

### Installation

To use `KTransport` in your project, you need to add the following dependencies to
your `build.gradle.kts` file:

```kotlin


plugins {
    //....
    id("com.jamshedalamqaderi.ktransport.gradle-plugin") version < ktransport_version >
}

ktransport {
    packageName = "com.jamshedalamqaderi.ktransport.example.ksp"
}

kotlin {
    android()
    jvm()
    js(IR) {
        browser()
        binaries.executable()
    }
    wasm {
        browser()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                // KTransport
                implementation("com.jamshedalamqaderi.ktransport:ktransport:<ktransportVersion>")
                // Other dependencies
            }
        }
        val jsMain by getting {}
        // JsMain could be used for wasm platform
        val wasmMain by getting {
            dependsOn(jsMain)
        }
    }
}
```

### Usage

please check out the example project in the repository. Just clone the repo and
run `ExampleServer.kt` then run `ExampleClient.kt` using intellij. Do the same as `ExampleClient.kt`
for JS platform

The example dir include all the necessary setup dependencies and code

# Author

- `KTransport` was developed
  by [JamshedAlamQaderi](https://github.com/JamshedAlamQaderi/JamshedAlamQaderi)

# Contributing

We welcome contributions to Spintaxkt! If you have an idea for a new feature or bug fix, please open
an issue or pull request.

## Support

If you found KTransport useful and would like to support its development, you can donate via Patreon
by clicking on the button below:

[![Support via Patreon](https://c5.patreon.com/external/logo/become_a_patron_button.png)](https://patreon.com/JamshedAlamQaderi)

# Acknowledgements

- Thank you to the gRPC team for their amazing work on gRPC

# Roadmap

- Add native platforms
- 100% test coverage

# LICENSE

`KTransport` is licensed under the Apache License 2.0.

Copyright 2023 [Jamshed Alam Qaderi](https://github.com/JamshedAlamQaderi/JamshedAlamQaderi)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
