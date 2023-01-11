package com.jamshedalamqader.ktransport.example.client

import com.jamshedalamqaderi.ktransport.api.KTransportClientConfig

class ClientCall {
    init {
        KTransportClientConfig.set("127.0.0.1", 8080)
    }
}