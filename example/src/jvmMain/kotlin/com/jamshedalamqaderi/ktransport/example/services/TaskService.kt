package com.jamshedalamqaderi.ktransport.example.services

import com.jamshedalamqader.ktransport.example.models.Task
import com.jamshedalamqaderi.ktransport.api.annotations.KTransportApi
import com.jamshedalamqaderi.ktransport.api.annotations.KTransportService
import com.jamshedalamqaderi.ktransport.api.annotations.KTransportStream
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@KTransportService
class TaskService {

    @KTransportApi
    fun createTask(task: Task): Task {
        println("Received task: $task")
        return Task(taskId = 232, "Hello, ${task.name}")
    }

    @KTransportStream
    fun onTaskCreated(forTaskId: Int): Flow<Task> = flow {
        repeat(10) {
            emit(Task(it, "Task name $it for taskId: $forTaskId"))
        }
    }
}