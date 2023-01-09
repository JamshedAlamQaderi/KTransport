package com.jamshedalamqaderi.grpc.protos

import com.jamshedalamqaderi.grpc.protos.KMKTransportModel
import io.github.timortel.kotlin_multiplatform_grpc_lib.KMChannel
import io.github.timortel.kotlin_multiplatform_grpc_lib.KMMetadata
import io.github.timortel.kotlin_multiplatform_grpc_lib.stub.KMStub
import kotlinx.coroutines.flow.Flow

public expect class KMKTransportServiceStub private constructor() : KMStub<KMKTransportServiceStub>
    {
  public constructor(channel: KMChannel)

  public suspend fun onRequestReceived(request: KMKTransportModel, metadata: KMMetadata =
      KMMetadata()): KMKTransportModel

  public suspend fun onStreamReceived(request: KMKTransportModel, metadata: KMMetadata =
      KMMetadata()): Flow<KMKTransportModel>
}
