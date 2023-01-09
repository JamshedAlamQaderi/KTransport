package com.jamshedalamqaderi.grpc.protos

import kotlin.String
import kotlin.Unit

public expect class KMKTransportModelDSL() {
  public var reference: String?

  public var payload: String?

  public fun build(): KMKTransportModel
}

public inline fun kmKTransportModel(builderDsl: KMKTransportModelDSL.() -> Unit): KMKTransportModel
    = KMKTransportModelDSL().apply(builderDsl).build()
