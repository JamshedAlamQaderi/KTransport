package com.jamshedalamqader.ktransport.example.client

import com.jamshedalamqader.ktransport.example.models.Task
import com.jamshedalamqaderi.ktransport.api.KTransport
import com.jamshedalamqaderi.ktransport.example.ksp.client.taskService
import kotlinx.coroutines.runBlocking

class ClientCall {
    init {
        runBlocking {
            KTransport.taskService.createTask(Task(12, "Jamshed"))
        }
    }
}