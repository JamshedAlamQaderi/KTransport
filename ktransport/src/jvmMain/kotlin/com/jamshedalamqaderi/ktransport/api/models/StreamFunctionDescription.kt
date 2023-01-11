package com.jamshedalamqaderi.ktransport.api.models

import com.jamshedalamqaderi.grpc.protos.KTransportModel
import com.jamshedalamqaderi.grpc.protos.kTransportModel
import com.jamshedalamqaderi.ktransport.api.enums.FunctionResponseType
import com.jamshedalamqaderi.ktransport.api.interfaces.BaseFunctionDescription
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.reflect.KFunction


data class StreamFunctionDescription<InputType, ReturnType>(
    val funQualifiedName: String,
    val funResponseType: FunctionResponseType,
    val functionRef: KFunction<Flow<ReturnType>>,
    val inputConverter: (String) -> InputType,
    val returnTypeConverter: (ReturnType) -> String
) : BaseFunctionDescription<Flow<KTransportModel>> {

    override fun compare(
        functionReference: String,
        functionResponseType: FunctionResponseType
    ): Boolean {
        return (funQualifiedName == functionReference
                && functionResponseType == funResponseType)
    }

    override fun executeFunction(serviceInstance: Any, input: String): Flow<KTransportModel> {

        val returnData = if (input == "Unit") {
            functionRef.call(serviceInstance)
        } else {
            functionRef.call(serviceInstance, inputConverter(input))
        }
        return returnData.map {
            kTransportModel {
                reference = funQualifiedName
                payload = returnTypeConverter.invoke(it)
            }
        }
    }

}
