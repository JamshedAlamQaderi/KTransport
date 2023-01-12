package com.jamshedalamqaderi.ktransport.api.models

import com.jamshedalamqaderi.grpc.protos.KTransportModel
import com.jamshedalamqaderi.grpc.protos.kTransportModel
import com.jamshedalamqaderi.ktransport.api.enums.FunctionResponseType
import com.jamshedalamqaderi.ktransport.api.interfaces.BaseFunctionDescription
import kotlin.reflect.KFunction

data class ApiFunctionDescription<InputType, ReturnType>(
    val funQualifiedName: String,
    val funResponseType: FunctionResponseType,
    val functionRef: KFunction<ReturnType>,
    val inputConverter: (String) -> InputType,
    val returnTypeConverter: (ReturnType) -> String
) : BaseFunctionDescription<KTransportModel> {
    override fun compare(
        functionReference: String,
        functionResponseType: FunctionResponseType
    ): Boolean {
        return (
            funQualifiedName == functionReference &&
                functionResponseType == funResponseType
            )
    }

    override fun executeFunction(serviceInstance: Any, input: String): KTransportModel {
        val returnData = if (input == "Unit") {
            functionRef.call(serviceInstance)
        } else {
            functionRef.call(
                serviceInstance,
                inputConverter(input)
            )
        }
        return kTransportModel {
            reference = funQualifiedName
            payload = returnTypeConverter.invoke(returnData)
        }
    }
}
