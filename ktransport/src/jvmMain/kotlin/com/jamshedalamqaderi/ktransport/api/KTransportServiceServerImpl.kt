package com.jamshedalamqaderi.ktransport.api

import com.jamshedalamqaderi.grpc.protos.KTransportModel
import com.jamshedalamqaderi.grpc.protos.KTransportServiceGrpcKt
import com.jamshedalamqaderi.grpc.protos.kTransportModel
import com.jamshedalamqaderi.ktransport.api.enums.FunctionResponseType
import com.jamshedalamqaderi.ktransport.api.exceptions.EmptyFunctionReferenceException
import com.jamshedalamqaderi.ktransport.api.exceptions.UnknownRequestException
import com.jamshedalamqaderi.ktransport.api.interfaces.BaseFunctionDescription
import com.jamshedalamqaderi.ktransport.api.models.ServiceDescription
import kotlinx.coroutines.flow.Flow

class KTransportServiceServerImpl(private val services: List<ServiceDescription>) :
    KTransportServiceGrpcKt.KTransportServiceCoroutineImplBase() {

    override suspend fun apiRequest(request: KTransportModel): KTransportModel {
        if (request.reference.isEmpty()) {
            throw EmptyFunctionReferenceException("Empty api function reference found")
        }
        val funInfo = findMatchingFunction(
            request.reference,
            FunctionResponseType.API
        ) ?: return kTransportModel { }
        return funInfo.second.executeFunction(funInfo.first, request.payload) as KTransportModel
    }

    override fun streamRequest(request: KTransportModel): Flow<KTransportModel> {
        if (request.reference.isEmpty()) {
            throw EmptyFunctionReferenceException("Empty stream function reference found")
        }
        val funInfo = findMatchingFunction(
            request.reference,
            FunctionResponseType.STREAM
        )
            ?: throw UnknownRequestException("Couldn't find any function reference matching with reference: ${request.reference}")
        return (funInfo.second as BaseFunctionDescription<Flow<KTransportModel>>)
            .executeFunction(funInfo.first, request.payload)
    }

    private fun findMatchingFunction(
        queryFunQualifiedName: String,
        functionResponseType: FunctionResponseType
    ): Pair<Any, BaseFunctionDescription<*>>? {
        for (service in services) {
            for (function in service.functions) {
                if (function.compare(queryFunQualifiedName, functionResponseType)) {
                    return Pair(service.instance, function)
                }
            }
        }
        return null
    }
}
