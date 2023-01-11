package com.jamshedalamqaderi.ktransport.example


import com.jamshedalamqaderi.ktransport.api.KTransport
import com.jamshedalamqaderi.ktransport.api.KTransportServer
import com.jamshedalamqaderi.ktransport.example.ksp.server.services
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.reflect.KType
import kotlin.reflect.typeOf

fun main() {
    KTransportServer
        .createServer(16999, KTransport.services)
        .start()

}