package com.jamshedalamqaderi.ktransport.api

import com.jamshedalamqaderi.grpc.protos.KMKTransportServiceStub
import com.jamshedalamqaderi.grpc.protos.kmKTransportModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.reflect.KType


suspend fun <I, R> makeApiRequest(
    reference: String,
    model: I,
    inputType: KType,
    returnType: KType
): R {
    val requestPayload = kmKTransportModel {
        this.reference = reference
        this.payload =
            if (model is Unit) "Unit" else Json.encodeToString(Json.serializersModule.serializer(inputType), model)
    }
    val serviceStub = getServiceStub()
    val response = serviceStub.apiRequest(requestPayload)
    return Json.decodeFromString(
        Json.serializersModule.serializer(returnType),
        response.payload
    ) as R
}

suspend fun <I, R> makeStreamRequest(
    reference: String,
    model: I,
    inputType: KType,
    returnType: KType
): Flow<R> {
    val requestPayload = kmKTransportModel {
        this.reference = reference
        this.payload =
            if (model is Unit) "Unit" else Json.encodeToString(Json.serializersModule.serializer(inputType), model)
    }
    val serviceStub = getServiceStub()
    return serviceStub.streamRequest(requestPayload).map {
        Json.decodeFromString(
            Json.serializersModule.serializer(returnType),
            it.payload
        ) as R
    }
}

private fun getServiceStub(): KMKTransportServiceStub {
    return KTransportClientConfig.getConfig().getClientStub()
}
