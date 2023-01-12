package com.jamshedalamqaderi.ktransport.api.interfaces

import com.jamshedalamqaderi.ktransport.api.enums.FunctionResponseType

interface BaseFunctionDescription<ReturnType> {
    fun compare(functionReference: String, functionResponseType: FunctionResponseType): Boolean
    fun executeFunction(serviceInstance: Any, input: String): ReturnType
}
