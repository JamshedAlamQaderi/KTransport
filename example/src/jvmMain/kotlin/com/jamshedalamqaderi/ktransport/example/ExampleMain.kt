package com.jamshedalamqaderi.ktransport.example

import com.jamshedalamqaderi.ktransport.api.KTransport
import com.jamshedalamqaderi.ktransport.api.models.ServiceDescription

class ExampleMain {
    fun sayHello(name: String): String {
        return "Hello, $name"
    }
}

val KTransport.services
    get() = listOf(ServiceDescription)

fun main() {
    val exampleMain = ExampleMain()
    val services = KTransport.services
    services.forEach { function ->

        println(function.call(exampleMain, "Jamshed"))
    }
//    KTransportServer
//        .createServer(16999, listOf(TaskService()))
//        .start()
}