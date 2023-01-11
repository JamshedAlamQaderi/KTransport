package com.jamshedalamqaderi.ktransport.example

import kotlin.reflect.KType
import kotlin.reflect.full.createType
import kotlin.reflect.typeOf
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

fun main() {
//    KTransportServer
//        .createServer(16999, KTransport.services)
//        .start()

}

@Serializable
data class Model(val name: String)