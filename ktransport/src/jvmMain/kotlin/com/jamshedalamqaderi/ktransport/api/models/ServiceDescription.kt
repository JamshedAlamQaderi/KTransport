package com.jamshedalamqaderi.ktransport.api.models

import com.jamshedalamqaderi.ktransport.api.interfaces.BaseFunctionDescription

data class ServiceDescription(val instance: Any, val functions: List<BaseFunctionDescription<*>>)
