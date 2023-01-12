package com.jamshedalamqaderi.ktransport.example.services

import com.jamshedalamqader.ktransport.example.models.Response
import com.jamshedalamqader.ktransport.example.models.Task
import com.jamshedalamqaderi.ktransport.api.annotations.KTransportApi
import com.jamshedalamqaderi.ktransport.api.annotations.KTransportService
import com.jamshedalamqaderi.ktransport.api.annotations.KTransportStream
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@KTransportService
class TaskService {

    @KTransportApi
    fun createTask(task: Task): Response {
        return Response("Received task with id: ${task.taskId} and task name: ${task.name}")
    }

    @KTransportApi
    fun createId(): Response {
        return Response("ID has been created from an argument less function")
    }

    @KTransportStream
    fun onTaskCreated(forTaskId: Int): Flow<Task> = flow {
        repeat(10) {
            delay(5_000)
            emit(Task(it, "Task name $it for taskId: $forTaskId"))
        }
    }
}
