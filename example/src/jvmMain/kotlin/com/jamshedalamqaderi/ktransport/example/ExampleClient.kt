package com.jamshedalamqaderi.ktransport.example

import com.jamshedalamqader.ktransport.example.models.Task
import com.jamshedalamqaderi.ktransport.api.KTransport
import com.jamshedalamqaderi.ktransport.example.ksp.client.taskService
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        KTransport.setConfig("localhost", 16999)
        val response = KTransport.taskService.createTask(Task(12, "Jamshed"))
        println("Received client: $response")
    }
}