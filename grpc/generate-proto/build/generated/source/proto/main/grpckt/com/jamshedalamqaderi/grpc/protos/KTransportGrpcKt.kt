package com.jamshedalamqaderi.grpc.protos

import com.jamshedalamqaderi.grpc.protos.KTransportServiceGrpc.getServiceDescriptor
import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.serverStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow

/**
 * Holder for Kotlin coroutine-based client and server APIs for
 * com.jamshedalamqaderi.grpc.protos.KTransportService.
 */
object KTransportServiceGrpcKt {
  const val SERVICE_NAME: String = KTransportServiceGrpc.SERVICE_NAME

  @JvmStatic
  val serviceDescriptor: ServiceDescriptor
    get() = KTransportServiceGrpc.getServiceDescriptor()

  val onRequestReceivedMethod: MethodDescriptor<KTransportModel, KTransportModel>
    @JvmStatic
    get() = KTransportServiceGrpc.getOnRequestReceivedMethod()

  val onStreamReceivedMethod: MethodDescriptor<KTransportModel, KTransportModel>
    @JvmStatic
    get() = KTransportServiceGrpc.getOnStreamReceivedMethod()

  /**
   * A stub for issuing RPCs to a(n) com.jamshedalamqaderi.grpc.protos.KTransportService service as
   * suspending coroutines.
   */
  @StubFor(KTransportServiceGrpc::class)
  class KTransportServiceCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT
  ) : AbstractCoroutineStub<KTransportServiceCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): KTransportServiceCoroutineStub =
        KTransportServiceCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun onRequestReceived(request: KTransportModel, headers: Metadata = Metadata()):
        KTransportModel = unaryRpc(
      channel,
      KTransportServiceGrpc.getOnRequestReceivedMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    fun onStreamReceived(request: KTransportModel, headers: Metadata = Metadata()):
        Flow<KTransportModel> = serverStreamingRpc(
      channel,
      KTransportServiceGrpc.getOnStreamReceivedMethod(),
      request,
      callOptions,
      headers
    )}

  /**
   * Skeletal implementation of the com.jamshedalamqaderi.grpc.protos.KTransportService service
   * based on Kotlin coroutines.
   */
  abstract class KTransportServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for
     * com.jamshedalamqaderi.grpc.protos.KTransportService.onRequestReceived.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun onRequestReceived(request: KTransportModel): KTransportModel = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.jamshedalamqaderi.grpc.protos.KTransportService.onRequestReceived is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * com.jamshedalamqaderi.grpc.protos.KTransportService.onStreamReceived.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open fun onStreamReceived(request: KTransportModel): Flow<KTransportModel> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.jamshedalamqaderi.grpc.protos.KTransportService.onStreamReceived is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = KTransportServiceGrpc.getOnRequestReceivedMethod(),
      implementation = ::onRequestReceived
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = KTransportServiceGrpc.getOnStreamReceivedMethod(),
      implementation = ::onStreamReceived
    )).build()
  }
}
