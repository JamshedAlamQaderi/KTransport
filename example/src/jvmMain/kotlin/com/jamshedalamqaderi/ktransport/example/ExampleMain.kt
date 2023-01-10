package com.jamshedalamqaderi.ktransport.example

import com.jamshedalamqaderi.ktransport.api.KTransport
import com.jamshedalamqaderi.ktransport.api.KTransportServer
import com.jamshedalamqaderi.ktransport.example.ksp.server.services
import kotlinx.serialization.Serializable

fun main() {
    KTransportServer
        .createServer(16999, KTransport.services)
        .start()
}

@Serializable
data class Model(val name: String)