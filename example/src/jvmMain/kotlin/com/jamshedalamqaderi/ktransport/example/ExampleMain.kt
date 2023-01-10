package com.jamshedalamqaderi.ktransport.example

import com.jamshedalamqaderi.ktransport.api.KTransport
import com.jamshedalamqaderi.ktransport.api.KTransportServer
import com.jamshedalamqaderi.ktransport.api.enums.FunctionResponseType
import com.jamshedalamqaderi.ktransport.api.interfaces.BaseFunctionDescription
import com.jamshedalamqaderi.ktransport.api.models.ApiFunctionDescription
import com.jamshedalamqaderi.ktransport.api.models.ServiceDescription
import com.jamshedalamqaderi.ktransport.api.models.StreamFunctionDescription
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ExampleMain {
    fun sayHello(model: Model): Model {
        return Model("Hello, ${model.name}")
    }

    fun sayHelloMultiple(model: Model): Flow<Model> = flow {
        emit(Model("Hello, ${model.name}"))
    }
}

val KTransport.services
    get() = listOf(
        ServiceDescription(
            ExampleMain(), listOf<BaseFunctionDescription<*>>(
                ApiFunctionDescription<Model, Model>(
                    "${ExampleMain::class.qualifiedName}/${ExampleMain::sayHello.name}",
                    FunctionResponseType.API,
                    ExampleMain::sayHello,
                    Json.Default::decodeFromString,
                    Json.Default::encodeToString
                ),
                StreamFunctionDescription<Model, Model>(
                    "${ExampleMain::class.qualifiedName}/${ExampleMain::sayHelloMultiple.name}",
                    FunctionResponseType.STREAM,
                    ExampleMain::sayHelloMultiple,
                    Json.Default::decodeFromString,
                    Json.Default::encodeToString
                )
            )
        )
    )

fun main() {
    KTransportServer
        .createServer(16999, KTransport.services)
        .start()
}

@Serializable
data class Model(val name: String)