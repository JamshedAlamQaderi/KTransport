package com.jamshedalamqaderi.grpc.protos;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.46.0)",
    comments = "Source: KTransport.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class KTransportServiceGrpc {

  private KTransportServiceGrpc() {}

  public static final String SERVICE_NAME = "com.jamshedalamqaderi.grpc.protos.KTransportService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.jamshedalamqaderi.grpc.protos.KTransportModel,
      com.jamshedalamqaderi.grpc.protos.KTransportModel> getOnRequestReceivedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onRequestReceived",
      requestType = com.jamshedalamqaderi.grpc.protos.KTransportModel.class,
      responseType = com.jamshedalamqaderi.grpc.protos.KTransportModel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jamshedalamqaderi.grpc.protos.KTransportModel,
      com.jamshedalamqaderi.grpc.protos.KTransportModel> getOnRequestReceivedMethod() {
    io.grpc.MethodDescriptor<com.jamshedalamqaderi.grpc.protos.KTransportModel, com.jamshedalamqaderi.grpc.protos.KTransportModel> getOnRequestReceivedMethod;
    if ((getOnRequestReceivedMethod = KTransportServiceGrpc.getOnRequestReceivedMethod) == null) {
      synchronized (KTransportServiceGrpc.class) {
        if ((getOnRequestReceivedMethod = KTransportServiceGrpc.getOnRequestReceivedMethod) == null) {
          KTransportServiceGrpc.getOnRequestReceivedMethod = getOnRequestReceivedMethod =
              io.grpc.MethodDescriptor.<com.jamshedalamqaderi.grpc.protos.KTransportModel, com.jamshedalamqaderi.grpc.protos.KTransportModel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onRequestReceived"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.jamshedalamqaderi.grpc.protos.KTransportModel.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.jamshedalamqaderi.grpc.protos.KTransportModel.getDefaultInstance()))
              .build();
        }
      }
    }
    return getOnRequestReceivedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jamshedalamqaderi.grpc.protos.KTransportModel,
      com.jamshedalamqaderi.grpc.protos.KTransportModel> getOnStreamReceivedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onStreamReceived",
      requestType = com.jamshedalamqaderi.grpc.protos.KTransportModel.class,
      responseType = com.jamshedalamqaderi.grpc.protos.KTransportModel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.jamshedalamqaderi.grpc.protos.KTransportModel,
      com.jamshedalamqaderi.grpc.protos.KTransportModel> getOnStreamReceivedMethod() {
    io.grpc.MethodDescriptor<com.jamshedalamqaderi.grpc.protos.KTransportModel, com.jamshedalamqaderi.grpc.protos.KTransportModel> getOnStreamReceivedMethod;
    if ((getOnStreamReceivedMethod = KTransportServiceGrpc.getOnStreamReceivedMethod) == null) {
      synchronized (KTransportServiceGrpc.class) {
        if ((getOnStreamReceivedMethod = KTransportServiceGrpc.getOnStreamReceivedMethod) == null) {
          KTransportServiceGrpc.getOnStreamReceivedMethod = getOnStreamReceivedMethod =
              io.grpc.MethodDescriptor.<com.jamshedalamqaderi.grpc.protos.KTransportModel, com.jamshedalamqaderi.grpc.protos.KTransportModel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onStreamReceived"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.jamshedalamqaderi.grpc.protos.KTransportModel.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.jamshedalamqaderi.grpc.protos.KTransportModel.getDefaultInstance()))
              .build();
        }
      }
    }
    return getOnStreamReceivedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static KTransportServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KTransportServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KTransportServiceStub>() {
        @java.lang.Override
        public KTransportServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KTransportServiceStub(channel, callOptions);
        }
      };
    return KTransportServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KTransportServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KTransportServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KTransportServiceBlockingStub>() {
        @java.lang.Override
        public KTransportServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KTransportServiceBlockingStub(channel, callOptions);
        }
      };
    return KTransportServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static KTransportServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KTransportServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KTransportServiceFutureStub>() {
        @java.lang.Override
        public KTransportServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KTransportServiceFutureStub(channel, callOptions);
        }
      };
    return KTransportServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class KTransportServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void onRequestReceived(com.jamshedalamqaderi.grpc.protos.KTransportModel request,
        io.grpc.stub.StreamObserver<com.jamshedalamqaderi.grpc.protos.KTransportModel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnRequestReceivedMethod(), responseObserver);
    }

    /**
     */
    public void onStreamReceived(com.jamshedalamqaderi.grpc.protos.KTransportModel request,
        io.grpc.stub.StreamObserver<com.jamshedalamqaderi.grpc.protos.KTransportModel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnStreamReceivedMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOnRequestReceivedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.jamshedalamqaderi.grpc.protos.KTransportModel,
                com.jamshedalamqaderi.grpc.protos.KTransportModel>(
                  this, METHODID_ON_REQUEST_RECEIVED)))
          .addMethod(
            getOnStreamReceivedMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.jamshedalamqaderi.grpc.protos.KTransportModel,
                com.jamshedalamqaderi.grpc.protos.KTransportModel>(
                  this, METHODID_ON_STREAM_RECEIVED)))
          .build();
    }
  }

  /**
   */
  public static final class KTransportServiceStub extends io.grpc.stub.AbstractAsyncStub<KTransportServiceStub> {
    private KTransportServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KTransportServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KTransportServiceStub(channel, callOptions);
    }

    /**
     */
    public void onRequestReceived(com.jamshedalamqaderi.grpc.protos.KTransportModel request,
        io.grpc.stub.StreamObserver<com.jamshedalamqaderi.grpc.protos.KTransportModel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnRequestReceivedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onStreamReceived(com.jamshedalamqaderi.grpc.protos.KTransportModel request,
        io.grpc.stub.StreamObserver<com.jamshedalamqaderi.grpc.protos.KTransportModel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getOnStreamReceivedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class KTransportServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<KTransportServiceBlockingStub> {
    private KTransportServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KTransportServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KTransportServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.jamshedalamqaderi.grpc.protos.KTransportModel onRequestReceived(com.jamshedalamqaderi.grpc.protos.KTransportModel request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnRequestReceivedMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.jamshedalamqaderi.grpc.protos.KTransportModel> onStreamReceived(
        com.jamshedalamqaderi.grpc.protos.KTransportModel request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getOnStreamReceivedMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class KTransportServiceFutureStub extends io.grpc.stub.AbstractFutureStub<KTransportServiceFutureStub> {
    private KTransportServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KTransportServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KTransportServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jamshedalamqaderi.grpc.protos.KTransportModel> onRequestReceived(
        com.jamshedalamqaderi.grpc.protos.KTransportModel request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnRequestReceivedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ON_REQUEST_RECEIVED = 0;
  private static final int METHODID_ON_STREAM_RECEIVED = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final KTransportServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(KTransportServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ON_REQUEST_RECEIVED:
          serviceImpl.onRequestReceived((com.jamshedalamqaderi.grpc.protos.KTransportModel) request,
              (io.grpc.stub.StreamObserver<com.jamshedalamqaderi.grpc.protos.KTransportModel>) responseObserver);
          break;
        case METHODID_ON_STREAM_RECEIVED:
          serviceImpl.onStreamReceived((com.jamshedalamqaderi.grpc.protos.KTransportModel) request,
              (io.grpc.stub.StreamObserver<com.jamshedalamqaderi.grpc.protos.KTransportModel>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (KTransportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getOnRequestReceivedMethod())
              .addMethod(getOnStreamReceivedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
