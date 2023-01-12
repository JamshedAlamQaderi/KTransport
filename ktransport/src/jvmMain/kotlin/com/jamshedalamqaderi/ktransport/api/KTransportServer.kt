package com.jamshedalamqaderi.ktransport.api

import com.jamshedalamqaderi.ktransport.api.models.ServiceDescription
import io.grpc.Server
import io.grpc.ServerBuilder

class KTransportServer private constructor(
    serverPort: Int,
    private val services: List<ServiceDescription>
) {
    companion object {
        fun createServer(serverPort: Int, services: List<ServiceDescription>): KTransportServer {
            return KTransportServer(serverPort, services)
        }
    }

    private val server: Server = ServerBuilder
        .forPort(serverPort)
        .addService(KTransportServiceServerImpl(services))
        .build()

    fun start() {
        server
            .start()
            .awaitTermination()
    }

    fun stop() {
        server.shutdown()
    }
}
