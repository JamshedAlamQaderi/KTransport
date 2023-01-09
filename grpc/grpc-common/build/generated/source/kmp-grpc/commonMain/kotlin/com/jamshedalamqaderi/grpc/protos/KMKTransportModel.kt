package com.jamshedalamqaderi.grpc.protos

import io.github.timortel.kotlin_multiplatform_grpc_lib.message.KMMessage
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public expect class KMKTransportModel : KMMessage {
  public val reference: String

  public val payload: String

  public override fun equals(other: Any?): Boolean

  public override fun hashCode(): Int
}
