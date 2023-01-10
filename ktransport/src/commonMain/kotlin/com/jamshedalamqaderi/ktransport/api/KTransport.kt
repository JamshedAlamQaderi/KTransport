package com.jamshedalamqaderi.ktransport.api

class KTransport {
    companion object {
        fun setup(port: Int, webProxyPort: Int) {
            if (port == webProxyPort) {
                throw IllegalArgumentException("webProxyPort is same as server client port. Please use different port")
            }

        }
    }
}