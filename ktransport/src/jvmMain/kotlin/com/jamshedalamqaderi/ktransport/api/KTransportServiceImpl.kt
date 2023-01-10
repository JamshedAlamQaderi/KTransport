package com.jamshedalamqaderi.ktransport.api

import com.jamshedalamqaderi.grpc.protos.KTransportModel
import com.jamshedalamqaderi.grpc.protos.KTransportServiceGrpcKt
import com.jamshedalamqaderi.grpc.protos.kTransportModel
import kotlinx.coroutines.flow.flow

class KTransportServiceImpl : KTransportServiceGrpcKt.KTransportServiceCoroutineImplBase() {
    override suspend fun onRequestReceived(request: KTransportModel): KTransportModel {
        return kTransportModel {
            reference = ""
            payload = ""
        }
    }

    override fun onStreamReceived(request: KTransportModel): kotlinx.coroutines.flow.Flow<KTransportModel> = flow {

    }
}