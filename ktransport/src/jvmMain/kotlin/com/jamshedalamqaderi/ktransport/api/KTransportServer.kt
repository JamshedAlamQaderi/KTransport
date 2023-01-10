package com.jamshedalamqaderi.ktransport.api

import io.grpc.Server
import io.grpc.ServerBuilder

class KTransportServer private constructor(
    private val serverPort: Int,
    private val services: List<Any>
) {
    companion object {
        fun createServer(serverPort: Int, services: List<Any>): KTransportServer {
            return KTransportServer(serverPort, services)
        }
    }

    private val server: Server = ServerBuilder
        .forPort(serverPort)
        .addService(KTransportServiceImpl())
        .build()

    fun start() {
        server.start().awaitTermination()
    }

    fun stop() {
        server.shutdown()
    }
}