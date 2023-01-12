package com.jamshedalamqaderi.ktransport.api

import com.jamshedalamqaderi.grpc.protos.KMKTransportServiceStub
import io.github.timortel.kotlin_multiplatform_grpc_lib.KMChannel

class KTransportClientConfig private constructor() {
    private lateinit var channel: KMChannel

    companion object {
        private val instance = KTransportClientConfig()
        fun set(address: String, port: Int, usePlainText: Boolean = true) {
            instance.run {
                buildChannel(address, port, usePlainText)
            }
        }

        internal fun getConfig(): KTransportClientConfig {
            return instance
        }
    }

    fun buildChannel(address: String, port: Int, usePlainText: Boolean) {
        val channelBuilder = KMChannel.Builder
            .forAddress(address, port)
        if (usePlainText) {
            channelBuilder.usePlaintext()
        }
        channel = channelBuilder.build()
    }

    fun getChannel(): KMChannel {
        return channel
    }

    fun getClientStub(): KMKTransportServiceStub {
        return KMKTransportServiceStub(getChannel())
    }
}
