package com.jamshedalamqaderi.ktransport.api.models

import com.jamshedalamqaderi.ktransport.api.enums.FunctionResponseType
import kotlin.reflect.KFunction

data class FunctionDescription<InputType, ReturnType>(
    val funQualifiedName: String,
    val funResponseType: FunctionResponseType,
    val functionRef: KFunction<ReturnType>,
    val inputConverter: (String) -> InputType
)