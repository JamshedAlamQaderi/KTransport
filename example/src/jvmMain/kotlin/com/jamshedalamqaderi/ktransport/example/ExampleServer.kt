package com.jamshedalamqaderi.ktransport.example

import com.jamshedalamqaderi.ktransport.api.KTransport
import com.jamshedalamqaderi.ktransport.api.KTransportServer
import com.jamshedalamqaderi.ktransport.example.ksp.server.services

fun main(args: Array<String>) {
    KTransportServer
        .createServer(16999, KTransport.services)
        .start()
}
