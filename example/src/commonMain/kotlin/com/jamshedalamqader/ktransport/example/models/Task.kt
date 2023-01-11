package com.jamshedalamqader.ktransport.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Task(val taskId: Int? = null, val name: String)
