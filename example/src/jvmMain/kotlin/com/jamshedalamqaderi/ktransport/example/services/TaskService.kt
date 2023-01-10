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
    fun createTask(task: Task): Boolean {
        return true
    }

    @KTransportStream
    fun onTaskCreated(forTaskId: Int): Flow<Task> = flow {

    }
}