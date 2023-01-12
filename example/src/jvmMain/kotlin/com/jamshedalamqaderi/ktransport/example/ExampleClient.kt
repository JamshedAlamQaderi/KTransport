package com.jamshedalamqaderi.ktransport.example

import com.jamshedalamqader.ktransport.example.models.Task
import com.jamshedalamqaderi.ktransport.api.KTransport
import com.jamshedalamqaderi.ktransport.example.ksp.client.taskService
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        KTransport.setConfig("localhost", 16999)
        val taskCreatedResponse = KTransport.taskService.createTask(Task(12, "Code a snake"))
        println("Task created response: $taskCreatedResponse")
        val idCreatedResponse = KTransport.taskService.createId()
        println("Id created response: $idCreatedResponse")
        KTransport.taskService.onTaskCreated(101).collect { task ->
            println("Task received through stream: $task")
        }
    }
}
