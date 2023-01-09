// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: KTransport.proto

package com.jamshedalamqaderi.grpc.protos;

/**
 * Protobuf type {@code com.jamshedalamqaderi.grpc.protos.KTransportModel}
 */
public final class KTransportModel extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.jamshedalamqaderi.grpc.protos.KTransportModel)
    KTransportModelOrBuilder {
private static final long serialVersionUID = 0L;
  // Use KTransportModel.newBuilder() to construct.
  private KTransportModel(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private KTransportModel() {
    reference_ = "";
    payload_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new KTransportModel();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private KTransportModel(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            reference_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            payload_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.jamshedalamqaderi.grpc.protos.KTransport.internal_static_com_jamshedalamqaderi_grpc_protos_KTransportModel_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.jamshedalamqaderi.grpc.protos.KTransport.internal_static_com_jamshedalamqaderi_grpc_protos_KTransportModel_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.jamshedalamqaderi.grpc.protos.KTransportModel.class, com.jamshedalamqaderi.grpc.protos.KTransportModel.Builder.class);
  }

  public static final int REFERENCE_FIELD_NUMBER = 1;
  private volatile java.lang.Object reference_;
  /**
   * <code>string reference = 1;</code>
   * @return The reference.
   */
  @java.lang.Override
  public java.lang.String getReference() {
    java.lang.Object ref = reference_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      reference_ = s;
      return s;
    }
  }
  /**
   * <code>string reference = 1;</code>
   * @return The bytes for reference.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getReferenceBytes() {
    java.lang.Object ref = reference_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      reference_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PAYLOAD_FIELD_NUMBER = 2;
  private volatile java.lang.Object payload_;
  /**
   * <code>string payload = 2;</code>
   * @return The payload.
   */
  @java.lang.Override
  public java.lang.String getPayload() {
    java.lang.Object ref = payload_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      payload_ = s;
      return s;
    }
  }
  /**
   * <code>string payload = 2;</code>
   * @return The bytes for payload.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getPayloadBytes() {
    java.lang.Object ref = payload_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      payload_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(reference_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, reference_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(payload_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, payload_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(reference_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, reference_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(payload_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, payload_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.jamshedalamqaderi.grpc.protos.KTransportModel)) {
      return super.equals(obj);
    }
    com.jamshedalamqaderi.grpc.protos.KTransportModel other = (com.jamshedalamqaderi.grpc.protos.KTransportModel) obj;

    if (!getReference()
        .equals(other.getReference())) return false;
    if (!getPayload()
        .equals(other.getPayload())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + REFERENCE_FIELD_NUMBER;
    hash = (53 * hash) + getReference().hashCode();
    hash = (37 * hash) + PAYLOAD_FIELD_NUMBER;
    hash = (53 * hash) + getPayload().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.jamshedalamqaderi.grpc.protos.KTransportModel parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.jamshedalamqaderi.grpc.protos.KTransportModel parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.jamshedalamqaderi.grpc.protos.KTransportModel parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.jamshedalamqaderi.grpc.protos.KTransportModel parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.jamshedalamqaderi.grpc.protos.KTransportModel parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.jamshedalamqaderi.grpc.protos.KTransportModel parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.jamshedalamqaderi.grpc.protos.KTransportModel parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.jamshedalamqaderi.grpc.protos.KTransportModel parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.jamshedalamqaderi.grpc.protos.KTransportModel parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.jamshedalamqaderi.grpc.protos.KTransportModel parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.jamshedalamqaderi.grpc.protos.KTransportModel parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.jamshedalamqaderi.grpc.protos.KTransportModel parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.jamshedalamqaderi.grpc.protos.KTransportModel prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.jamshedalamqaderi.grpc.protos.KTransportModel}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.jamshedalamqaderi.grpc.protos.KTransportModel)
      com.jamshedalamqaderi.grpc.protos.KTransportModelOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.jamshedalamqaderi.grpc.protos.KTransport.internal_static_com_jamshedalamqaderi_grpc_protos_KTransportModel_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.jamshedalamqaderi.grpc.protos.KTransport.internal_static_com_jamshedalamqaderi_grpc_protos_KTransportModel_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.jamshedalamqaderi.grpc.protos.KTransportModel.class, com.jamshedalamqaderi.grpc.protos.KTransportModel.Builder.class);
    }

    // Construct using com.jamshedalamqaderi.grpc.protos.KTransportModel.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      reference_ = "";

      payload_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.jamshedalamqaderi.grpc.protos.KTransport.internal_static_com_jamshedalamqaderi_grpc_protos_KTransportModel_descriptor;
    }

    @java.lang.Override
    public com.jamshedalamqaderi.grpc.protos.KTransportModel getDefaultInstanceForType() {
      return com.jamshedalamqaderi.grpc.protos.KTransportModel.getDefaultInstance();
    }

    @java.lang.Override
    public com.jamshedalamqaderi.grpc.protos.KTransportModel build() {
      com.jamshedalamqaderi.grpc.protos.KTransportModel result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.jamshedalamqaderi.grpc.protos.KTransportModel buildPartial() {
      com.jamshedalamqaderi.grpc.protos.KTransportModel result = new com.jamshedalamqaderi.grpc.protos.KTransportModel(this);
      result.reference_ = reference_;
      result.payload_ = payload_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.jamshedalamqaderi.grpc.protos.KTransportModel) {
        return mergeFrom((com.jamshedalamqaderi.grpc.protos.KTransportModel)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.jamshedalamqaderi.grpc.protos.KTransportModel other) {
      if (other == com.jamshedalamqaderi.grpc.protos.KTransportModel.getDefaultInstance()) return this;
      if (!other.getReference().isEmpty()) {
        reference_ = other.reference_;
        onChanged();
      }
      if (!other.getPayload().isEmpty()) {
        payload_ = other.payload_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.jamshedalamqaderi.grpc.protos.KTransportModel parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.jamshedalamqaderi.grpc.protos.KTransportModel) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object reference_ = "";
    /**
     * <code>string reference = 1;</code>
     * @return The reference.
     */
    public java.lang.String getReference() {
      java.lang.Object ref = reference_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        reference_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string reference = 1;</code>
     * @return The bytes for reference.
     */
    public com.google.protobuf.ByteString
        getReferenceBytes() {
      java.lang.Object ref = reference_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        reference_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string reference = 1;</code>
     * @param value The reference to set.
     * @return This builder for chaining.
     */
    public Builder setReference(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      reference_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string reference = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearReference() {
      
      reference_ = getDefaultInstance().getReference();
      onChanged();
      return this;
    }
    /**
     * <code>string reference = 1;</code>
     * @param value The bytes for reference to set.
     * @return This builder for chaining.
     */
    public Builder setReferenceBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      reference_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object payload_ = "";
    /**
     * <code>string payload = 2;</code>
     * @return The payload.
     */
    public java.lang.String getPayload() {
      java.lang.Object ref = payload_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        payload_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string payload = 2;</code>
     * @return The bytes for payload.
     */
    public com.google.protobuf.ByteString
        getPayloadBytes() {
      java.lang.Object ref = payload_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        payload_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string payload = 2;</code>
     * @param value The payload to set.
     * @return This builder for chaining.
     */
    public Builder setPayload(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      payload_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string payload = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPayload() {
      
      payload_ = getDefaultInstance().getPayload();
      onChanged();
      return this;
    }
    /**
     * <code>string payload = 2;</code>
     * @param value The bytes for payload to set.
     * @return This builder for chaining.
     */
    public Builder setPayloadBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      payload_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.jamshedalamqaderi.grpc.protos.KTransportModel)
  }

  // @@protoc_insertion_point(class_scope:com.jamshedalamqaderi.grpc.protos.KTransportModel)
  private static final com.jamshedalamqaderi.grpc.protos.KTransportModel DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.jamshedalamqaderi.grpc.protos.KTransportModel();
  }

  public static com.jamshedalamqaderi.grpc.protos.KTransportModel getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<KTransportModel>
      PARSER = new com.google.protobuf.AbstractParser<KTransportModel>() {
    @java.lang.Override
    public KTransportModel parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new KTransportModel(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<KTransportModel> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<KTransportModel> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.jamshedalamqaderi.grpc.protos.KTransportModel getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

