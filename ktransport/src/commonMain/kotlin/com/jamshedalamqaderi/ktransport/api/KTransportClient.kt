package com.jamshedalamqaderi.ktransport.api

import io.github.timortel.kotlin_multiplatform_grpc_lib.KMChannel

class KTransportClient {
    init {
        val channel = KMChannel.Builder
            .forAddress("localhost", 8080)
            .usePlaintext()
            .build()
    }
}