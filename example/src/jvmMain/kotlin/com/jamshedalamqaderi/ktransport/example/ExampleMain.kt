package com.jamshedalamqaderi.ktransport.example

import com.jamshedalamqaderi.ktransport.api.KTransportServer

fun main() {
    KTransportServer
        .createServer(16999, listOf())
        .start()
}