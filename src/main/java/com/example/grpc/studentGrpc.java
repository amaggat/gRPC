package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: student.proto")
public final class studentGrpc {

  private studentGrpc() {}

  public static final String SERVICE_NAME = "student";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Student.StudentId,
      com.example.grpc.Student.StudentInfo> getSearchByIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchByID",
      requestType = com.example.grpc.Student.StudentId.class,
      responseType = com.example.grpc.Student.StudentInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Student.StudentId,
      com.example.grpc.Student.StudentInfo> getSearchByIDMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Student.StudentId, com.example.grpc.Student.StudentInfo> getSearchByIDMethod;
    if ((getSearchByIDMethod = studentGrpc.getSearchByIDMethod) == null) {
      synchronized (studentGrpc.class) {
        if ((getSearchByIDMethod = studentGrpc.getSearchByIDMethod) == null) {
          studentGrpc.getSearchByIDMethod = getSearchByIDMethod = 
              io.grpc.MethodDescriptor.<com.example.grpc.Student.StudentId, com.example.grpc.Student.StudentInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "student", "searchByID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Student.StudentId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Student.StudentInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new studentMethodDescriptorSupplier("searchByID"))
                  .build();
          }
        }
     }
     return getSearchByIDMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static studentStub newStub(io.grpc.Channel channel) {
    return new studentStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static studentBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new studentBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static studentFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new studentFutureStub(channel);
  }

  /**
   */
  public static abstract class studentImplBase implements io.grpc.BindableService {

    /**
     */
    public void searchByID(com.example.grpc.Student.StudentId request,
        io.grpc.stub.StreamObserver<com.example.grpc.Student.StudentInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchByIDMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSearchByIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Student.StudentId,
                com.example.grpc.Student.StudentInfo>(
                  this, METHODID_SEARCH_BY_ID)))
          .build();
    }
  }

  /**
   */
  public static final class studentStub extends io.grpc.stub.AbstractStub<studentStub> {
    private studentStub(io.grpc.Channel channel) {
      super(channel);
    }

    private studentStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected studentStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new studentStub(channel, callOptions);
    }

    /**
     */
    public void searchByID(com.example.grpc.Student.StudentId request,
        io.grpc.stub.StreamObserver<com.example.grpc.Student.StudentInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchByIDMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class studentBlockingStub extends io.grpc.stub.AbstractStub<studentBlockingStub> {
    private studentBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private studentBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected studentBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new studentBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.Student.StudentInfo searchByID(com.example.grpc.Student.StudentId request) {
      return blockingUnaryCall(
          getChannel(), getSearchByIDMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class studentFutureStub extends io.grpc.stub.AbstractStub<studentFutureStub> {
    private studentFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private studentFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected studentFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new studentFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.Student.StudentInfo> searchByID(
        com.example.grpc.Student.StudentId request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchByIDMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_BY_ID = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final studentImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(studentImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH_BY_ID:
          serviceImpl.searchByID((com.example.grpc.Student.StudentId) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Student.StudentInfo>) responseObserver);
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

  private static abstract class studentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    studentBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.Student.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("student");
    }
  }

  private static final class studentFileDescriptorSupplier
      extends studentBaseDescriptorSupplier {
    studentFileDescriptorSupplier() {}
  }

  private static final class studentMethodDescriptorSupplier
      extends studentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    studentMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (studentGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new studentFileDescriptorSupplier())
              .addMethod(getSearchByIDMethod())
              .build();
        }
      }
    }
    return result;
  }
}
