/*******************************************************************************************************
 *
 * Osmformat.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
// source: src/main/protobuf/osmformat.proto

package gama.ext.libs.osmosis;

/**
 * The Class Osmformat.
 */
public final class Osmformat {
	
	/**
	 * Instantiates a new osmformat.
	 */
	private Osmformat() {}

	/**
	 * Register all extensions.
	 *
	 * @param registry the registry
	 */
	public static void registerAllExtensions(final com.google.protobuf.ExtensionRegistryLite registry) {}

	/**
	 * The Interface HeaderBlockOrBuilder.
	 */
	public interface HeaderBlockOrBuilder extends
			// @@protoc_insertion_point(interface_extends:OSMPBF.HeaderBlock)
			com.google.protobuf.MessageLiteOrBuilder {

		/**
		 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
		 *
		 * @return true, if successful
		 */
		boolean hasBbox();

		/**
		 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
		 *
		 * @return the bbox
		 */
		HeaderBBox getBbox();

		/**
		 * <pre>
		 * Additional tags to aid in parsing this dataset
		 * </pre>
		 * 
		 * <code>repeated string required_features = 4;</code>.
		 *
		 * @return the required features list
		 */
		java.util.List<java.lang.String> getRequiredFeaturesList();

		/**
		 * <pre>
		 * Additional tags to aid in parsing this dataset
		 * </pre>
		 * 
		 * <code>repeated string required_features = 4;</code>.
		 *
		 * @return the required features count
		 */
		int getRequiredFeaturesCount();

		/**
		 * <pre>
		 * Additional tags to aid in parsing this dataset
		 * </pre>
		 * 
		 * <code>repeated string required_features = 4;</code>.
		 *
		 * @param index the index
		 * @return the required features
		 */
		java.lang.String getRequiredFeatures(int index);

		/**
		 * <pre>
		 * Additional tags to aid in parsing this dataset
		 * </pre>
		 * 
		 * <code>repeated string required_features = 4;</code>.
		 *
		 * @param index the index
		 * @return the required features bytes
		 */
		com.google.protobuf.ByteString getRequiredFeaturesBytes(int index);

		/**
		 * <code>repeated string optional_features = 5;</code>.
		 *
		 * @return the optional features list
		 */
		java.util.List<java.lang.String> getOptionalFeaturesList();

		/**
		 * <code>repeated string optional_features = 5;</code>.
		 *
		 * @return the optional features count
		 */
		int getOptionalFeaturesCount();

		/**
		 * <code>repeated string optional_features = 5;</code>.
		 *
		 * @param index the index
		 * @return the optional features
		 */
		java.lang.String getOptionalFeatures(int index);

		/**
		 * <code>repeated string optional_features = 5;</code>.
		 *
		 * @param index the index
		 * @return the optional features bytes
		 */
		com.google.protobuf.ByteString getOptionalFeaturesBytes(int index);

		/**
		 * <code>optional string writingprogram = 16;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasWritingprogram();

		/**
		 * <code>optional string writingprogram = 16;</code>.
		 *
		 * @return the writingprogram
		 */
		java.lang.String getWritingprogram();

		/**
		 * <code>optional string writingprogram = 16;</code>.
		 *
		 * @return the writingprogram bytes
		 */
		com.google.protobuf.ByteString getWritingprogramBytes();

		/**
		 * <pre>
		 * From the bbox field.
		 * </pre>
		 * 
		 * <code>optional string source = 17;</code>
		 *
		 * @return true, if successful
		 */
		boolean hasSource();

		/**
		 * <pre>
		 * From the bbox field.
		 * </pre>
		 * 
		 * <code>optional string source = 17;</code>
		 *
		 * @return the source
		 */
		java.lang.String getSource();

		/**
		 * <pre>
		 * From the bbox field.
		 * </pre>
		 * 
		 * <code>optional string source = 17;</code>
		 *
		 * @return the source bytes
		 */
		com.google.protobuf.ByteString getSourceBytes();

		/**
		 * <pre>
		 * replication timestamp, expressed in seconds since the epoch,
		 * otherwise the same value as in the "timestamp=..." field
		 * in the state.txt file used by Osmosis
		 * </pre>
		 * 
		 * <code>optional int64 osmosis_replication_timestamp = 32;</code>
		 *
		 * @return true, if successful
		 */
		boolean hasOsmosisReplicationTimestamp();

		/**
		 * <pre>
		 * replication timestamp, expressed in seconds since the epoch,
		 * otherwise the same value as in the "timestamp=..." field
		 * in the state.txt file used by Osmosis
		 * </pre>
		 * 
		 * <code>optional int64 osmosis_replication_timestamp = 32;</code>
		 *
		 * @return the osmosis replication timestamp
		 */
		long getOsmosisReplicationTimestamp();

		/**
		 * <pre>
		 * replication sequence number (sequenceNumber in state.txt)
		 * </pre>
		 * 
		 * <code>optional int64 osmosis_replication_sequence_number = 33;</code>
		 *
		 * @return true, if successful
		 */
		boolean hasOsmosisReplicationSequenceNumber();

		/**
		 * <pre>
		 * replication sequence number (sequenceNumber in state.txt)
		 * </pre>
		 * 
		 * <code>optional int64 osmosis_replication_sequence_number = 33;</code>
		 *
		 * @return the osmosis replication sequence number
		 */
		long getOsmosisReplicationSequenceNumber();

		/**
		 * <pre>
		 * replication base URL (from Osmosis' configuration.txt file)
		 * </pre>
		 * 
		 * <code>optional string osmosis_replication_base_url = 34;</code>
		 *
		 * @return true, if successful
		 */
		boolean hasOsmosisReplicationBaseUrl();

		/**
		 * <pre>
		 * replication base URL (from Osmosis' configuration.txt file)
		 * </pre>
		 * 
		 * <code>optional string osmosis_replication_base_url = 34;</code>
		 *
		 * @return the osmosis replication base url
		 */
		java.lang.String getOsmosisReplicationBaseUrl();

		/**
		 * <pre>
		 * replication base URL (from Osmosis' configuration.txt file)
		 * </pre>
		 * 
		 * <code>optional string osmosis_replication_base_url = 34;</code>
		 *
		 * @return the osmosis replication base url bytes
		 */
		com.google.protobuf.ByteString getOsmosisReplicationBaseUrlBytes();
	}

	/**
	 * Protobuf type {@code OSMPBF.HeaderBlock}
	 */
	public static final class HeaderBlock
			extends com.google.protobuf.GeneratedMessageLite<HeaderBlock, HeaderBlock.Builder> implements
			// @@protoc_insertion_point(message_implements:OSMPBF.HeaderBlock)
			HeaderBlockOrBuilder {
		
		/**
		 * Instantiates a new header block.
		 */
		private HeaderBlock() {
			requiredFeatures_ = com.google.protobuf.GeneratedMessageLite.emptyProtobufList();
			optionalFeatures_ = com.google.protobuf.GeneratedMessageLite.emptyProtobufList();
			writingprogram_ = "";
			source_ = "";
			osmosisReplicationBaseUrl_ = "";
		}

		/** The bit field 0. */
		private int bitField0_;
		
		/** The Constant BBOX_FIELD_NUMBER. */
		public static final int BBOX_FIELD_NUMBER = 1;
		
		/** The bbox. */
		private HeaderBBox bbox_;

		/**
		 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
		 */
		@java.lang.Override
		public boolean hasBbox() {
			return (bitField0_ & 0x00000001) == 0x00000001;
		}

		/**
		 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
		 */
		@java.lang.Override
		public HeaderBBox getBbox() {
			return bbox_ == null ? HeaderBBox.getDefaultInstance() : bbox_;
		}

		/**
		 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
		 *
		 * @param value the new bbox
		 */
		private void setBbox(final HeaderBBox value) {
			if (value == null) { throw new NullPointerException(); }
			bbox_ = value;
			bitField0_ |= 0x00000001;
		}

		/**
		 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
		 *
		 * @param builderForValue the new bbox
		 */
		private void setBbox(final HeaderBBox.Builder builderForValue) {
			bbox_ = builderForValue.build();
			bitField0_ |= 0x00000001;
		}

		/**
		 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
		 *
		 * @param value the value
		 */
		private void mergeBbox(final HeaderBBox value) {
			if (value == null) { throw new NullPointerException(); }
			if (bbox_ != null && bbox_ != HeaderBBox.getDefaultInstance()) {
				bbox_ = HeaderBBox.newBuilder(bbox_).mergeFrom(value).buildPartial();
			} else {
				bbox_ = value;
			}
			bitField0_ |= 0x00000001;
		}

		/**
		 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
		 */
		private void clearBbox() {
			bbox_ = null;
			bitField0_ = bitField0_ & ~0x00000001;
		}

		/** The Constant REQUIRED_FEATURES_FIELD_NUMBER. */
		public static final int REQUIRED_FEATURES_FIELD_NUMBER = 4;
		
		/** The required features. */
		private com.google.protobuf.Internal.ProtobufList<java.lang.String> requiredFeatures_;

		/**
		 * <pre>
		 * Additional tags to aid in parsing this dataset
		 * </pre>
		 *
		 * <code>repeated string required_features = 4;</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.String> getRequiredFeaturesList() {
			return requiredFeatures_;
		}

		/**
		 * <pre>
		 * Additional tags to aid in parsing this dataset
		 * </pre>
		 *
		 * <code>repeated string required_features = 4;</code>
		 */
		@java.lang.Override
		public int getRequiredFeaturesCount() {
			return requiredFeatures_.size();
		}

		/**
		 * <pre>
		 * Additional tags to aid in parsing this dataset
		 * </pre>
		 *
		 * <code>repeated string required_features = 4;</code>
		 */
		@java.lang.Override
		public java.lang.String getRequiredFeatures(final int index) {
			return requiredFeatures_.get(index);
		}

		/**
		 * <pre>
		 * Additional tags to aid in parsing this dataset
		 * </pre>
		 *
		 * <code>repeated string required_features = 4;</code>
		 */
		@java.lang.Override
		public com.google.protobuf.ByteString getRequiredFeaturesBytes(final int index) {
			return com.google.protobuf.ByteString.copyFromUtf8(requiredFeatures_.get(index));
		}

		/**
		 * Ensure required features is mutable.
		 */
		private void ensureRequiredFeaturesIsMutable() {
			if (!requiredFeatures_.isModifiable()) {
				requiredFeatures_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(requiredFeatures_);
			}
		}

		/**
		 * <pre>
		 * Additional tags to aid in parsing this dataset
		 * </pre>
		 * 
		 * <code>repeated string required_features = 4;</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setRequiredFeatures(final int index, final java.lang.String value) {
			if (value == null) { throw new NullPointerException(); }
			ensureRequiredFeaturesIsMutable();
			requiredFeatures_.set(index, value);
		}

		/**
		 * <pre>
		 * Additional tags to aid in parsing this dataset
		 * </pre>
		 * 
		 * <code>repeated string required_features = 4;</code>.
		 *
		 * @param value the value
		 */
		private void addRequiredFeatures(final java.lang.String value) {
			if (value == null) { throw new NullPointerException(); }
			ensureRequiredFeaturesIsMutable();
			requiredFeatures_.add(value);
		}

		/**
		 * <pre>
		 * Additional tags to aid in parsing this dataset
		 * </pre>
		 * 
		 * <code>repeated string required_features = 4;</code>.
		 *
		 * @param values the values
		 */
		private void addAllRequiredFeatures(final java.lang.Iterable<java.lang.String> values) {
			ensureRequiredFeaturesIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, requiredFeatures_);
		}

		/**
		 * <pre>
		 * Additional tags to aid in parsing this dataset
		 * </pre>
		 * 
		 * <code>repeated string required_features = 4;</code>.
		 */
		private void clearRequiredFeatures() {
			requiredFeatures_ = com.google.protobuf.GeneratedMessageLite.emptyProtobufList();
		}

		/**
		 * <pre>
		 * Additional tags to aid in parsing this dataset
		 * </pre>
		 * 
		 * <code>repeated string required_features = 4;</code>.
		 *
		 * @param value the value
		 */
		private void addRequiredFeaturesBytes(final com.google.protobuf.ByteString value) {
			if (value == null) { throw new NullPointerException(); }
			ensureRequiredFeaturesIsMutable();
			requiredFeatures_.add(value.toStringUtf8());
		}

		/** The Constant OPTIONAL_FEATURES_FIELD_NUMBER. */
		public static final int OPTIONAL_FEATURES_FIELD_NUMBER = 5;
		
		/** The optional features. */
		private com.google.protobuf.Internal.ProtobufList<java.lang.String> optionalFeatures_;

		/**
		 * <code>repeated string optional_features = 5;</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.String> getOptionalFeaturesList() {
			return optionalFeatures_;
		}

		/**
		 * <code>repeated string optional_features = 5;</code>
		 */
		@java.lang.Override
		public int getOptionalFeaturesCount() {
			return optionalFeatures_.size();
		}

		/**
		 * <code>repeated string optional_features = 5;</code>
		 */
		@java.lang.Override
		public java.lang.String getOptionalFeatures(final int index) {
			return optionalFeatures_.get(index);
		}

		/**
		 * <code>repeated string optional_features = 5;</code>
		 */
		@java.lang.Override
		public com.google.protobuf.ByteString getOptionalFeaturesBytes(final int index) {
			return com.google.protobuf.ByteString.copyFromUtf8(optionalFeatures_.get(index));
		}

		/**
		 * Ensure optional features is mutable.
		 */
		private void ensureOptionalFeaturesIsMutable() {
			if (!optionalFeatures_.isModifiable()) {
				optionalFeatures_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(optionalFeatures_);
			}
		}

		/**
		 * <code>repeated string optional_features = 5;</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setOptionalFeatures(final int index, final java.lang.String value) {
			if (value == null) { throw new NullPointerException(); }
			ensureOptionalFeaturesIsMutable();
			optionalFeatures_.set(index, value);
		}

		/**
		 * <code>repeated string optional_features = 5;</code>.
		 *
		 * @param value the value
		 */
		private void addOptionalFeatures(final java.lang.String value) {
			if (value == null) { throw new NullPointerException(); }
			ensureOptionalFeaturesIsMutable();
			optionalFeatures_.add(value);
		}

		/**
		 * <code>repeated string optional_features = 5;</code>.
		 *
		 * @param values the values
		 */
		private void addAllOptionalFeatures(final java.lang.Iterable<java.lang.String> values) {
			ensureOptionalFeaturesIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, optionalFeatures_);
		}

		/**
		 * <code>repeated string optional_features = 5;</code>.
		 */
		private void clearOptionalFeatures() {
			optionalFeatures_ = com.google.protobuf.GeneratedMessageLite.emptyProtobufList();
		}

		/**
		 * <code>repeated string optional_features = 5;</code>.
		 *
		 * @param value the value
		 */
		private void addOptionalFeaturesBytes(final com.google.protobuf.ByteString value) {
			if (value == null) { throw new NullPointerException(); }
			ensureOptionalFeaturesIsMutable();
			optionalFeatures_.add(value.toStringUtf8());
		}

		/** The Constant WRITINGPROGRAM_FIELD_NUMBER. */
		public static final int WRITINGPROGRAM_FIELD_NUMBER = 16;
		
		/** The writingprogram. */
		private java.lang.String writingprogram_;

		/**
		 * <code>optional string writingprogram = 16;</code>
		 */
		@java.lang.Override
		public boolean hasWritingprogram() {
			return (bitField0_ & 0x00000002) == 0x00000002;
		}

		/**
		 * <code>optional string writingprogram = 16;</code>
		 */
		@java.lang.Override
		public java.lang.String getWritingprogram() {
			return writingprogram_;
		}

		/**
		 * <code>optional string writingprogram = 16;</code>
		 */
		@java.lang.Override
		public com.google.protobuf.ByteString getWritingprogramBytes() {
			return com.google.protobuf.ByteString.copyFromUtf8(writingprogram_);
		}

		/**
		 * <code>optional string writingprogram = 16;</code>.
		 *
		 * @param value the new writingprogram
		 */
		private void setWritingprogram(final java.lang.String value) {
			if (value == null) { throw new NullPointerException(); }
			bitField0_ |= 0x00000002;
			writingprogram_ = value;
		}

		/**
		 * <code>optional string writingprogram = 16;</code>.
		 */
		private void clearWritingprogram() {
			bitField0_ = bitField0_ & ~0x00000002;
			writingprogram_ = getDefaultInstance().getWritingprogram();
		}

		/**
		 * <code>optional string writingprogram = 16;</code>.
		 *
		 * @param value the new writingprogram bytes
		 */
		private void setWritingprogramBytes(final com.google.protobuf.ByteString value) {
			if (value == null) { throw new NullPointerException(); }
			bitField0_ |= 0x00000002;
			writingprogram_ = value.toStringUtf8();
		}

		/** The Constant SOURCE_FIELD_NUMBER. */
		public static final int SOURCE_FIELD_NUMBER = 17;
		
		/** The source. */
		private java.lang.String source_;

		/**
		 * <pre>
		 * From the bbox field.
		 * </pre>
		 *
		 * <code>optional string source = 17;</code>
		 */
		@java.lang.Override
		public boolean hasSource() {
			return (bitField0_ & 0x00000004) == 0x00000004;
		}

		/**
		 * <pre>
		 * From the bbox field.
		 * </pre>
		 *
		 * <code>optional string source = 17;</code>
		 */
		@java.lang.Override
		public java.lang.String getSource() {
			return source_;
		}

		/**
		 * <pre>
		 * From the bbox field.
		 * </pre>
		 *
		 * <code>optional string source = 17;</code>
		 */
		@java.lang.Override
		public com.google.protobuf.ByteString getSourceBytes() {
			return com.google.protobuf.ByteString.copyFromUtf8(source_);
		}

		/**
		 * <pre>
		 * From the bbox field.
		 * </pre>
		 * 
		 * <code>optional string source = 17;</code>
		 *
		 * @param value the new source
		 */
		private void setSource(final java.lang.String value) {
			if (value == null) { throw new NullPointerException(); }
			bitField0_ |= 0x00000004;
			source_ = value;
		}

		/**
		 * <pre>
		 * From the bbox field.
		 * </pre>
		 *
		 * <code>optional string source = 17;</code>
		 */
		private void clearSource() {
			bitField0_ = bitField0_ & ~0x00000004;
			source_ = getDefaultInstance().getSource();
		}

		/**
		 * <pre>
		 * From the bbox field.
		 * </pre>
		 * 
		 * <code>optional string source = 17;</code>
		 *
		 * @param value the new source bytes
		 */
		private void setSourceBytes(final com.google.protobuf.ByteString value) {
			if (value == null) { throw new NullPointerException(); }
			bitField0_ |= 0x00000004;
			source_ = value.toStringUtf8();
		}

		/** The Constant OSMOSIS_REPLICATION_TIMESTAMP_FIELD_NUMBER. */
		public static final int OSMOSIS_REPLICATION_TIMESTAMP_FIELD_NUMBER = 32;
		
		/** The osmosis replication timestamp. */
		private long osmosisReplicationTimestamp_;

		/**
		 * <pre>
		 * replication timestamp, expressed in seconds since the epoch,
		 * otherwise the same value as in the "timestamp=..." field
		 * in the state.txt file used by Osmosis
		 * </pre>
		 *
		 * <code>optional int64 osmosis_replication_timestamp = 32;</code>
		 */
		@java.lang.Override
		public boolean hasOsmosisReplicationTimestamp() {
			return (bitField0_ & 0x00000008) == 0x00000008;
		}

		/**
		 * <pre>
		 * replication timestamp, expressed in seconds since the epoch,
		 * otherwise the same value as in the "timestamp=..." field
		 * in the state.txt file used by Osmosis
		 * </pre>
		 *
		 * <code>optional int64 osmosis_replication_timestamp = 32;</code>
		 */
		@java.lang.Override
		public long getOsmosisReplicationTimestamp() {
			return osmosisReplicationTimestamp_;
		}

		/**
		 * <pre>
		 * replication timestamp, expressed in seconds since the epoch,
		 * otherwise the same value as in the "timestamp=..." field
		 * in the state.txt file used by Osmosis
		 * </pre>
		 * 
		 * <code>optional int64 osmosis_replication_timestamp = 32;</code>
		 *
		 * @param value the new osmosis replication timestamp
		 */
		private void setOsmosisReplicationTimestamp(final long value) {
			bitField0_ |= 0x00000008;
			osmosisReplicationTimestamp_ = value;
		}

		/**
		 * <pre>
		 * replication timestamp, expressed in seconds since the epoch,
		 * otherwise the same value as in the "timestamp=..." field
		 * in the state.txt file used by Osmosis
		 * </pre>
		 *
		 * <code>optional int64 osmosis_replication_timestamp = 32;</code>
		 */
		private void clearOsmosisReplicationTimestamp() {
			bitField0_ = bitField0_ & ~0x00000008;
			osmosisReplicationTimestamp_ = 0L;
		}

		/** The Constant OSMOSIS_REPLICATION_SEQUENCE_NUMBER_FIELD_NUMBER. */
		public static final int OSMOSIS_REPLICATION_SEQUENCE_NUMBER_FIELD_NUMBER = 33;
		
		/** The osmosis replication sequence number. */
		private long osmosisReplicationSequenceNumber_;

		/**
		 * <pre>
		 * replication sequence number (sequenceNumber in state.txt)
		 * </pre>
		 *
		 * <code>optional int64 osmosis_replication_sequence_number = 33;</code>
		 */
		@java.lang.Override
		public boolean hasOsmosisReplicationSequenceNumber() {
			return (bitField0_ & 0x00000010) == 0x00000010;
		}

		/**
		 * <pre>
		 * replication sequence number (sequenceNumber in state.txt)
		 * </pre>
		 *
		 * <code>optional int64 osmosis_replication_sequence_number = 33;</code>
		 */
		@java.lang.Override
		public long getOsmosisReplicationSequenceNumber() {
			return osmosisReplicationSequenceNumber_;
		}

		/**
		 * <pre>
		 * replication sequence number (sequenceNumber in state.txt)
		 * </pre>
		 * 
		 * <code>optional int64 osmosis_replication_sequence_number = 33;</code>
		 *
		 * @param value the new osmosis replication sequence number
		 */
		private void setOsmosisReplicationSequenceNumber(final long value) {
			bitField0_ |= 0x00000010;
			osmosisReplicationSequenceNumber_ = value;
		}

		/**
		 * <pre>
		 * replication sequence number (sequenceNumber in state.txt)
		 * </pre>
		 *
		 * <code>optional int64 osmosis_replication_sequence_number = 33;</code>
		 */
		private void clearOsmosisReplicationSequenceNumber() {
			bitField0_ = bitField0_ & ~0x00000010;
			osmosisReplicationSequenceNumber_ = 0L;
		}

		/** The Constant OSMOSIS_REPLICATION_BASE_URL_FIELD_NUMBER. */
		public static final int OSMOSIS_REPLICATION_BASE_URL_FIELD_NUMBER = 34;
		
		/** The osmosis replication base url. */
		private java.lang.String osmosisReplicationBaseUrl_;

		/**
		 * <pre>
		 * replication base URL (from Osmosis' configuration.txt file)
		 * </pre>
		 *
		 * <code>optional string osmosis_replication_base_url = 34;</code>
		 */
		@java.lang.Override
		public boolean hasOsmosisReplicationBaseUrl() {
			return (bitField0_ & 0x00000020) == 0x00000020;
		}

		/**
		 * <pre>
		 * replication base URL (from Osmosis' configuration.txt file)
		 * </pre>
		 *
		 * <code>optional string osmosis_replication_base_url = 34;</code>
		 */
		@java.lang.Override
		public java.lang.String getOsmosisReplicationBaseUrl() {
			return osmosisReplicationBaseUrl_;
		}

		/**
		 * <pre>
		 * replication base URL (from Osmosis' configuration.txt file)
		 * </pre>
		 *
		 * <code>optional string osmosis_replication_base_url = 34;</code>
		 */
		@java.lang.Override
		public com.google.protobuf.ByteString getOsmosisReplicationBaseUrlBytes() {
			return com.google.protobuf.ByteString.copyFromUtf8(osmosisReplicationBaseUrl_);
		}

		/**
		 * <pre>
		 * replication base URL (from Osmosis' configuration.txt file)
		 * </pre>
		 * 
		 * <code>optional string osmosis_replication_base_url = 34;</code>
		 *
		 * @param value the new osmosis replication base url
		 */
		private void setOsmosisReplicationBaseUrl(final java.lang.String value) {
			if (value == null) { throw new NullPointerException(); }
			bitField0_ |= 0x00000020;
			osmosisReplicationBaseUrl_ = value;
		}

		/**
		 * <pre>
		 * replication base URL (from Osmosis' configuration.txt file)
		 * </pre>
		 *
		 * <code>optional string osmosis_replication_base_url = 34;</code>
		 */
		private void clearOsmosisReplicationBaseUrl() {
			bitField0_ = bitField0_ & ~0x00000020;
			osmosisReplicationBaseUrl_ = getDefaultInstance().getOsmosisReplicationBaseUrl();
		}

		/**
		 * <pre>
		 * replication base URL (from Osmosis' configuration.txt file)
		 * </pre>
		 * 
		 * <code>optional string osmosis_replication_base_url = 34;</code>
		 *
		 * @param value the new osmosis replication base url bytes
		 */
		private void setOsmosisReplicationBaseUrlBytes(final com.google.protobuf.ByteString value) {
			if (value == null) { throw new NullPointerException(); }
			bitField0_ |= 0x00000020;
			osmosisReplicationBaseUrl_ = value.toStringUtf8();
		}

		@java.lang.Override
		public void writeTo(final com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				output.writeMessage(1, getBbox());
			}
			for (int i = 0; i < requiredFeatures_.size(); i++) {
				output.writeString(4, requiredFeatures_.get(i));
			}
			for (int i = 0; i < optionalFeatures_.size(); i++) {
				output.writeString(5, optionalFeatures_.get(i));
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				output.writeString(16, getWritingprogram());
			}
			if ((bitField0_ & 0x00000004) == 0x00000004) {
				output.writeString(17, getSource());
			}
			if ((bitField0_ & 0x00000008) == 0x00000008) {
				output.writeInt64(32, osmosisReplicationTimestamp_);
			}
			if ((bitField0_ & 0x00000010) == 0x00000010) {
				output.writeInt64(33, osmosisReplicationSequenceNumber_);
			}
			if ((bitField0_ & 0x00000020) == 0x00000020) {
				output.writeString(34, getOsmosisReplicationBaseUrl());
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSerializedSize;
			if (size != -1) { return size; }

			size = 0;
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, getBbox());
			}
			{
				int dataSize = 0;
				for (int i = 0; i < requiredFeatures_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeStringSizeNoTag(requiredFeatures_.get(i));
				}
				size += dataSize;
				size += 1 * getRequiredFeaturesList().size();
			}
			{
				int dataSize = 0;
				for (int i = 0; i < optionalFeatures_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeStringSizeNoTag(optionalFeatures_.get(i));
				}
				size += dataSize;
				size += 1 * getOptionalFeaturesList().size();
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				size += com.google.protobuf.CodedOutputStream.computeStringSize(16, getWritingprogram());
			}
			if ((bitField0_ & 0x00000004) == 0x00000004) {
				size += com.google.protobuf.CodedOutputStream.computeStringSize(17, getSource());
			}
			if ((bitField0_ & 0x00000008) == 0x00000008) {
				size += com.google.protobuf.CodedOutputStream.computeInt64Size(32, osmosisReplicationTimestamp_);
			}
			if ((bitField0_ & 0x00000010) == 0x00000010) {
				size += com.google.protobuf.CodedOutputStream.computeInt64Size(33, osmosisReplicationSequenceNumber_);
			}
			if ((bitField0_ & 0x00000020) == 0x00000020) {
				size += com.google.protobuf.CodedOutputStream.computeStringSize(34, getOsmosisReplicationBaseUrl());
			}
			size += unknownFields.getSerializedSize();
			memoizedSerializedSize = size;
			return size;
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the header block
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static HeaderBlock parseFrom(final java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the header block
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static HeaderBlock parseFrom(final java.nio.ByteBuffer data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the header block
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static HeaderBlock parseFrom(final com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the header block
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static HeaderBlock parseFrom(final com.google.protobuf.ByteString data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the header block
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static HeaderBlock parseFrom(final byte[] data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the header block
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static HeaderBlock parseFrom(final byte[] data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the header block
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static HeaderBlock parseFrom(final java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the header block
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static HeaderBlock parseFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @return the header block
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static HeaderBlock parseDelimitedFrom(final java.io.InputStream input) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the header block
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static HeaderBlock parseDelimitedFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the header block
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static HeaderBlock parseFrom(final com.google.protobuf.CodedInputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the header block
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static HeaderBlock parseFrom(final com.google.protobuf.CodedInputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * New builder.
		 *
		 * @return the builder
		 */
		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.newBuilder();
		}

		/**
		 * New builder.
		 *
		 * @param prototype the prototype
		 * @return the builder
		 */
		public static Builder newBuilder(final HeaderBlock prototype) {
			return DEFAULT_INSTANCE.newBuilder(prototype);
		}

		/**
		 * Protobuf type {@code OSMPBF.HeaderBlock}
		 */
		public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<HeaderBlock, Builder>
				implements
				// @@protoc_insertion_point(builder_implements:OSMPBF.HeaderBlock)
				HeaderBlockOrBuilder {
			
			/**
			 * Instantiates a new builder.
			 */
			// Construct using HeaderBlock.newBuilder()
			private Builder() {
				super(DEFAULT_INSTANCE);
			}

			/**
			 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
			 */
			@java.lang.Override
			public boolean hasBbox() {
				return instance.hasBbox();
			}

			/**
			 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
			 */
			@java.lang.Override
			public HeaderBBox getBbox() {
				return instance.getBbox();
			}

			/**
			 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setBbox(final HeaderBBox value) {
				copyOnWrite();
				instance.setBbox(value);
				return this;
			}

			/**
			 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
			 *
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder setBbox(final HeaderBBox.Builder builderForValue) {
				copyOnWrite();
				instance.setBbox(builderForValue);
				return this;
			}

			/**
			 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder mergeBbox(final HeaderBBox value) {
				copyOnWrite();
				instance.mergeBbox(value);
				return this;
			}

			/**
			 * <code>optional .OSMPBF.HeaderBBox bbox = 1;</code>
			 *
			 * @return the builder
			 */
			public Builder clearBbox() {
				copyOnWrite();
				instance.clearBbox();
				return this;
			}

			/**
			 * <pre>
			 * Additional tags to aid in parsing this dataset
			 * </pre>
			 *
			 * <code>repeated string required_features = 4;</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.String> getRequiredFeaturesList() {
				return java.util.Collections.unmodifiableList(instance.getRequiredFeaturesList());
			}

			/**
			 * <pre>
			 * Additional tags to aid in parsing this dataset
			 * </pre>
			 *
			 * <code>repeated string required_features = 4;</code>
			 */
			@java.lang.Override
			public int getRequiredFeaturesCount() {
				return instance.getRequiredFeaturesCount();
			}

			/**
			 * <pre>
			 * Additional tags to aid in parsing this dataset
			 * </pre>
			 *
			 * <code>repeated string required_features = 4;</code>
			 */
			@java.lang.Override
			public java.lang.String getRequiredFeatures(final int index) {
				return instance.getRequiredFeatures(index);
			}

			/**
			 * <pre>
			 * Additional tags to aid in parsing this dataset
			 * </pre>
			 *
			 * <code>repeated string required_features = 4;</code>
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getRequiredFeaturesBytes(final int index) {
				return instance.getRequiredFeaturesBytes(index);
			}

			/**
			 * <pre>
			 * Additional tags to aid in parsing this dataset
			 * </pre>
			 * 
			 * <code>repeated string required_features = 4;</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setRequiredFeatures(final int index, final java.lang.String value) {
				copyOnWrite();
				instance.setRequiredFeatures(index, value);
				return this;
			}

			/**
			 * <pre>
			 * Additional tags to aid in parsing this dataset
			 * </pre>
			 * 
			 * <code>repeated string required_features = 4;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addRequiredFeatures(final java.lang.String value) {
				copyOnWrite();
				instance.addRequiredFeatures(value);
				return this;
			}

			/**
			 * <pre>
			 * Additional tags to aid in parsing this dataset
			 * </pre>
			 * 
			 * <code>repeated string required_features = 4;</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllRequiredFeatures(final java.lang.Iterable<java.lang.String> values) {
				copyOnWrite();
				instance.addAllRequiredFeatures(values);
				return this;
			}

			/**
			 * <pre>
			 * Additional tags to aid in parsing this dataset
			 * </pre>
			 * 
			 * <code>repeated string required_features = 4;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearRequiredFeatures() {
				copyOnWrite();
				instance.clearRequiredFeatures();
				return this;
			}

			/**
			 * <pre>
			 * Additional tags to aid in parsing this dataset
			 * </pre>
			 * 
			 * <code>repeated string required_features = 4;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addRequiredFeaturesBytes(final com.google.protobuf.ByteString value) {
				copyOnWrite();
				instance.addRequiredFeaturesBytes(value);
				return this;
			}

			/**
			 * <code>repeated string optional_features = 5;</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.String> getOptionalFeaturesList() {
				return java.util.Collections.unmodifiableList(instance.getOptionalFeaturesList());
			}

			/**
			 * <code>repeated string optional_features = 5;</code>
			 */
			@java.lang.Override
			public int getOptionalFeaturesCount() {
				return instance.getOptionalFeaturesCount();
			}

			/**
			 * <code>repeated string optional_features = 5;</code>
			 */
			@java.lang.Override
			public java.lang.String getOptionalFeatures(final int index) {
				return instance.getOptionalFeatures(index);
			}

			/**
			 * <code>repeated string optional_features = 5;</code>
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getOptionalFeaturesBytes(final int index) {
				return instance.getOptionalFeaturesBytes(index);
			}

			/**
			 * <code>repeated string optional_features = 5;</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setOptionalFeatures(final int index, final java.lang.String value) {
				copyOnWrite();
				instance.setOptionalFeatures(index, value);
				return this;
			}

			/**
			 * <code>repeated string optional_features = 5;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addOptionalFeatures(final java.lang.String value) {
				copyOnWrite();
				instance.addOptionalFeatures(value);
				return this;
			}

			/**
			 * <code>repeated string optional_features = 5;</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllOptionalFeatures(final java.lang.Iterable<java.lang.String> values) {
				copyOnWrite();
				instance.addAllOptionalFeatures(values);
				return this;
			}

			/**
			 * <code>repeated string optional_features = 5;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearOptionalFeatures() {
				copyOnWrite();
				instance.clearOptionalFeatures();
				return this;
			}

			/**
			 * <code>repeated string optional_features = 5;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addOptionalFeaturesBytes(final com.google.protobuf.ByteString value) {
				copyOnWrite();
				instance.addOptionalFeaturesBytes(value);
				return this;
			}

			/**
			 * <code>optional string writingprogram = 16;</code>
			 */
			@java.lang.Override
			public boolean hasWritingprogram() {
				return instance.hasWritingprogram();
			}

			/**
			 * <code>optional string writingprogram = 16;</code>
			 */
			@java.lang.Override
			public java.lang.String getWritingprogram() {
				return instance.getWritingprogram();
			}

			/**
			 * <code>optional string writingprogram = 16;</code>
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getWritingprogramBytes() {
				return instance.getWritingprogramBytes();
			}

			/**
			 * <code>optional string writingprogram = 16;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setWritingprogram(final java.lang.String value) {
				copyOnWrite();
				instance.setWritingprogram(value);
				return this;
			}

			/**
			 * <code>optional string writingprogram = 16;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearWritingprogram() {
				copyOnWrite();
				instance.clearWritingprogram();
				return this;
			}

			/**
			 * <code>optional string writingprogram = 16;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setWritingprogramBytes(final com.google.protobuf.ByteString value) {
				copyOnWrite();
				instance.setWritingprogramBytes(value);
				return this;
			}

			/**
			 * <pre>
			 * From the bbox field.
			 * </pre>
			 *
			 * <code>optional string source = 17;</code>
			 */
			@java.lang.Override
			public boolean hasSource() {
				return instance.hasSource();
			}

			/**
			 * <pre>
			 * From the bbox field.
			 * </pre>
			 *
			 * <code>optional string source = 17;</code>
			 */
			@java.lang.Override
			public java.lang.String getSource() {
				return instance.getSource();
			}

			/**
			 * <pre>
			 * From the bbox field.
			 * </pre>
			 *
			 * <code>optional string source = 17;</code>
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getSourceBytes() {
				return instance.getSourceBytes();
			}

			/**
			 * <pre>
			 * From the bbox field.
			 * </pre>
			 * 
			 * <code>optional string source = 17;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setSource(final java.lang.String value) {
				copyOnWrite();
				instance.setSource(value);
				return this;
			}

			/**
			 * <pre>
			 * From the bbox field.
			 * </pre>
			 * 
			 * <code>optional string source = 17;</code>
			 *
			 * @return the builder
			 */
			public Builder clearSource() {
				copyOnWrite();
				instance.clearSource();
				return this;
			}

			/**
			 * <pre>
			 * From the bbox field.
			 * </pre>
			 * 
			 * <code>optional string source = 17;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setSourceBytes(final com.google.protobuf.ByteString value) {
				copyOnWrite();
				instance.setSourceBytes(value);
				return this;
			}

			/**
			 * <pre>
			 * replication timestamp, expressed in seconds since the epoch,
			 * otherwise the same value as in the "timestamp=..." field
			 * in the state.txt file used by Osmosis
			 * </pre>
			 *
			 * <code>optional int64 osmosis_replication_timestamp = 32;</code>
			 */
			@java.lang.Override
			public boolean hasOsmosisReplicationTimestamp() {
				return instance.hasOsmosisReplicationTimestamp();
			}

			/**
			 * <pre>
			 * replication timestamp, expressed in seconds since the epoch,
			 * otherwise the same value as in the "timestamp=..." field
			 * in the state.txt file used by Osmosis
			 * </pre>
			 *
			 * <code>optional int64 osmosis_replication_timestamp = 32;</code>
			 */
			@java.lang.Override
			public long getOsmosisReplicationTimestamp() {
				return instance.getOsmosisReplicationTimestamp();
			}

			/**
			 * <pre>
			 * replication timestamp, expressed in seconds since the epoch,
			 * otherwise the same value as in the "timestamp=..." field
			 * in the state.txt file used by Osmosis
			 * </pre>
			 * 
			 * <code>optional int64 osmosis_replication_timestamp = 32;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setOsmosisReplicationTimestamp(final long value) {
				copyOnWrite();
				instance.setOsmosisReplicationTimestamp(value);
				return this;
			}

			/**
			 * <pre>
			 * replication timestamp, expressed in seconds since the epoch,
			 * otherwise the same value as in the "timestamp=..." field
			 * in the state.txt file used by Osmosis
			 * </pre>
			 * 
			 * <code>optional int64 osmosis_replication_timestamp = 32;</code>
			 *
			 * @return the builder
			 */
			public Builder clearOsmosisReplicationTimestamp() {
				copyOnWrite();
				instance.clearOsmosisReplicationTimestamp();
				return this;
			}

			/**
			 * <pre>
			 * replication sequence number (sequenceNumber in state.txt)
			 * </pre>
			 *
			 * <code>optional int64 osmosis_replication_sequence_number = 33;</code>
			 */
			@java.lang.Override
			public boolean hasOsmosisReplicationSequenceNumber() {
				return instance.hasOsmosisReplicationSequenceNumber();
			}

			/**
			 * <pre>
			 * replication sequence number (sequenceNumber in state.txt)
			 * </pre>
			 *
			 * <code>optional int64 osmosis_replication_sequence_number = 33;</code>
			 */
			@java.lang.Override
			public long getOsmosisReplicationSequenceNumber() {
				return instance.getOsmosisReplicationSequenceNumber();
			}

			/**
			 * <pre>
			 * replication sequence number (sequenceNumber in state.txt)
			 * </pre>
			 * 
			 * <code>optional int64 osmosis_replication_sequence_number = 33;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setOsmosisReplicationSequenceNumber(final long value) {
				copyOnWrite();
				instance.setOsmosisReplicationSequenceNumber(value);
				return this;
			}

			/**
			 * <pre>
			 * replication sequence number (sequenceNumber in state.txt)
			 * </pre>
			 * 
			 * <code>optional int64 osmosis_replication_sequence_number = 33;</code>
			 *
			 * @return the builder
			 */
			public Builder clearOsmosisReplicationSequenceNumber() {
				copyOnWrite();
				instance.clearOsmosisReplicationSequenceNumber();
				return this;
			}

			/**
			 * <pre>
			 * replication base URL (from Osmosis' configuration.txt file)
			 * </pre>
			 *
			 * <code>optional string osmosis_replication_base_url = 34;</code>
			 */
			@java.lang.Override
			public boolean hasOsmosisReplicationBaseUrl() {
				return instance.hasOsmosisReplicationBaseUrl();
			}

			/**
			 * <pre>
			 * replication base URL (from Osmosis' configuration.txt file)
			 * </pre>
			 *
			 * <code>optional string osmosis_replication_base_url = 34;</code>
			 */
			@java.lang.Override
			public java.lang.String getOsmosisReplicationBaseUrl() {
				return instance.getOsmosisReplicationBaseUrl();
			}

			/**
			 * <pre>
			 * replication base URL (from Osmosis' configuration.txt file)
			 * </pre>
			 *
			 * <code>optional string osmosis_replication_base_url = 34;</code>
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getOsmosisReplicationBaseUrlBytes() {
				return instance.getOsmosisReplicationBaseUrlBytes();
			}

			/**
			 * <pre>
			 * replication base URL (from Osmosis' configuration.txt file)
			 * </pre>
			 * 
			 * <code>optional string osmosis_replication_base_url = 34;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setOsmosisReplicationBaseUrl(final java.lang.String value) {
				copyOnWrite();
				instance.setOsmosisReplicationBaseUrl(value);
				return this;
			}

			/**
			 * <pre>
			 * replication base URL (from Osmosis' configuration.txt file)
			 * </pre>
			 * 
			 * <code>optional string osmosis_replication_base_url = 34;</code>
			 *
			 * @return the builder
			 */
			public Builder clearOsmosisReplicationBaseUrl() {
				copyOnWrite();
				instance.clearOsmosisReplicationBaseUrl();
				return this;
			}

			/**
			 * <pre>
			 * replication base URL (from Osmosis' configuration.txt file)
			 * </pre>
			 * 
			 * <code>optional string osmosis_replication_base_url = 34;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setOsmosisReplicationBaseUrlBytes(final com.google.protobuf.ByteString value) {
				copyOnWrite();
				instance.setOsmosisReplicationBaseUrlBytes(value);
				return this;
			}

			// @@protoc_insertion_point(builder_scope:OSMPBF.HeaderBlock)
		}

		/** The memoized is initialized. */
		private byte memoizedIsInitialized = 2;

		@java.lang.Override
		@java.lang.SuppressWarnings ({ "unchecked", "fallthrough" })
		protected java.lang.Object dynamicMethod(final com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
				final java.lang.Object arg0, final java.lang.Object arg1) {
			switch (method) {
				case NEW_MUTABLE_INSTANCE: {
					return new HeaderBlock();
				}
				case NEW_BUILDER: {
					return new Builder();
				}
				case IS_INITIALIZED: {
					final byte isInitialized = memoizedIsInitialized;
					if (isInitialized == 1) { return DEFAULT_INSTANCE; }
					if (isInitialized == 0) { return null; }

					// final boolean shouldMemoize = ((Boolean) arg0).booleanValue();
					if (hasBbox() && !getBbox().isInitialized()) { return null; }
					return DEFAULT_INSTANCE;

				}
				case MAKE_IMMUTABLE: {
					requiredFeatures_.makeImmutable();
					optionalFeatures_.makeImmutable();
					return null;
				}
				case VISIT: {
					final Visitor visitor = (Visitor) arg0;
					final HeaderBlock other = (HeaderBlock) arg1;
					bbox_ = visitor.visitMessage(bbox_, other.bbox_);
					requiredFeatures_ = visitor.visitList(requiredFeatures_, other.requiredFeatures_);
					optionalFeatures_ = visitor.visitList(optionalFeatures_, other.optionalFeatures_);
					writingprogram_ = visitor.visitString(hasWritingprogram(), writingprogram_,
							other.hasWritingprogram(), other.writingprogram_);
					source_ = visitor.visitString(hasSource(), source_, other.hasSource(), other.source_);
					osmosisReplicationTimestamp_ =
							visitor.visitLong(hasOsmosisReplicationTimestamp(), osmosisReplicationTimestamp_,
									other.hasOsmosisReplicationTimestamp(), other.osmosisReplicationTimestamp_);
					osmosisReplicationSequenceNumber_ = visitor.visitLong(hasOsmosisReplicationSequenceNumber(),
							osmosisReplicationSequenceNumber_, other.hasOsmosisReplicationSequenceNumber(),
							other.osmosisReplicationSequenceNumber_);
					osmosisReplicationBaseUrl_ =
							visitor.visitString(hasOsmosisReplicationBaseUrl(), osmosisReplicationBaseUrl_,
									other.hasOsmosisReplicationBaseUrl(), other.osmosisReplicationBaseUrl_);
					if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
						bitField0_ |= other.bitField0_;
					}
					return this;
				}
				case MERGE_FROM_STREAM: {
					final com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
					final com.google.protobuf.ExtensionRegistryLite extensionRegistry =
							(com.google.protobuf.ExtensionRegistryLite) arg1;
					if (extensionRegistry == null) { throw new java.lang.NullPointerException(); }
					try {
						boolean done = false;
						while (!done) {
							final int tag = input.readTag();
							switch (tag) {
								case 0:
									done = true;
									break;
								case 10: {
									HeaderBBox.Builder subBuilder = null;
									if ((bitField0_ & 0x00000001) == 0x00000001) {
										subBuilder = bbox_.toBuilder();
									}
									bbox_ = input.readMessage(HeaderBBox.parser(), extensionRegistry);
									if (subBuilder != null) {
										subBuilder.mergeFrom(bbox_);
										bbox_ = subBuilder.buildPartial();
									}
									bitField0_ |= 0x00000001;
									break;
								}
								case 34: {
									final java.lang.String s = input.readString();
									if (!requiredFeatures_.isModifiable()) {
										requiredFeatures_ =
												com.google.protobuf.GeneratedMessageLite.mutableCopy(requiredFeatures_);
									}
									requiredFeatures_.add(s);
									break;
								}
								case 42: {
									final java.lang.String s = input.readString();
									if (!optionalFeatures_.isModifiable()) {
										optionalFeatures_ =
												com.google.protobuf.GeneratedMessageLite.mutableCopy(optionalFeatures_);
									}
									optionalFeatures_.add(s);
									break;
								}
								case 130: {
									final java.lang.String s = input.readString();
									bitField0_ |= 0x00000002;
									writingprogram_ = s;
									break;
								}
								case 138: {
									final java.lang.String s = input.readString();
									bitField0_ |= 0x00000004;
									source_ = s;
									break;
								}
								case 256: {
									bitField0_ |= 0x00000008;
									osmosisReplicationTimestamp_ = input.readInt64();
									break;
								}
								case 264: {
									bitField0_ |= 0x00000010;
									osmosisReplicationSequenceNumber_ = input.readInt64();
									break;
								}
								case 274: {
									final java.lang.String s = input.readString();
									bitField0_ |= 0x00000020;
									osmosisReplicationBaseUrl_ = s;
									break;
								}
								default: {
									if (!parseUnknownField(tag, input)) {
										done = true;
									}
									break;
								}
							}
						}
					} catch (final com.google.protobuf.InvalidProtocolBufferException e) {
						throw new RuntimeException(e.setUnfinishedMessage(this));
					} catch (final java.io.IOException e) {
						throw new RuntimeException(
								new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
										.setUnfinishedMessage(this));
					} finally {}
				}
				// fall through
				case GET_DEFAULT_INSTANCE: {
					return DEFAULT_INSTANCE;
				}
				case GET_PARSER: {
					com.google.protobuf.Parser<HeaderBlock> parser = PARSER;
					if (parser == null) {
						synchronized (HeaderBlock.class) {
							parser = PARSER;
							if (parser == null) {
								parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
								PARSER = parser;
							}
						}
					}
					return parser;
				}
				case GET_MEMOIZED_IS_INITIALIZED: {
					return memoizedIsInitialized;
				}
				case SET_MEMOIZED_IS_INITIALIZED: {
					memoizedIsInitialized = (byte) (arg0 == null ? 0 : 1);
					return null;
				}
			}
			throw new UnsupportedOperationException();
		}

		/** The Constant DEFAULT_INSTANCE. */
		// @@protoc_insertion_point(class_scope:OSMPBF.HeaderBlock)
		private static final HeaderBlock DEFAULT_INSTANCE;
		static {
			// New instances are implicitly immutable so no need to make
			// immutable.
			DEFAULT_INSTANCE = new HeaderBlock();
		}

		/**
		 * Gets the default instance.
		 *
		 * @return the default instance
		 */
		public static HeaderBlock getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		/** The parser. */
		private static volatile com.google.protobuf.Parser<HeaderBlock> PARSER;

		/**
		 * Parser.
		 *
		 * @return the com.google.protobuf. parser
		 */
		public static com.google.protobuf.Parser<HeaderBlock> parser() {
			return DEFAULT_INSTANCE.getParserForType();
		}
	}

	/**
	 * The Interface HeaderBBoxOrBuilder.
	 */
	public interface HeaderBBoxOrBuilder extends
			// @@protoc_insertion_point(interface_extends:OSMPBF.HeaderBBox)
			com.google.protobuf.MessageLiteOrBuilder {

		/**
		 * <code>required sint64 left = 1;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasLeft();

		/**
		 * <code>required sint64 left = 1;</code>.
		 *
		 * @return the left
		 */
		long getLeft();

		/**
		 * <code>required sint64 right = 2;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasRight();

		/**
		 * <code>required sint64 right = 2;</code>.
		 *
		 * @return the right
		 */
		long getRight();

		/**
		 * <code>required sint64 top = 3;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasTop();

		/**
		 * <code>required sint64 top = 3;</code>.
		 *
		 * @return the top
		 */
		long getTop();

		/**
		 * <code>required sint64 bottom = 4;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasBottom();

		/**
		 * <code>required sint64 bottom = 4;</code>.
		 *
		 * @return the bottom
		 */
		long getBottom();
	}

	/**
	 * Protobuf type {@code OSMPBF.HeaderBBox}
	 */
	public static final class HeaderBBox
			extends com.google.protobuf.GeneratedMessageLite<HeaderBBox, HeaderBBox.Builder> implements
			// @@protoc_insertion_point(message_implements:OSMPBF.HeaderBBox)
			HeaderBBoxOrBuilder {
		
		/**
		 * Instantiates a new header B box.
		 */
		private HeaderBBox() {}

		/** The bit field 0. */
		private int bitField0_;
		
		/** The Constant LEFT_FIELD_NUMBER. */
		public static final int LEFT_FIELD_NUMBER = 1;
		
		/** The left. */
		private long left_;

		/**
		 * <code>required sint64 left = 1;</code>
		 */
		@java.lang.Override
		public boolean hasLeft() {
			return (bitField0_ & 0x00000001) == 0x00000001;
		}

		/**
		 * <code>required sint64 left = 1;</code>
		 */
		@java.lang.Override
		public long getLeft() {
			return left_;
		}

		/**
		 * <code>required sint64 left = 1;</code>.
		 *
		 * @param value the new left
		 */
		private void setLeft(final long value) {
			bitField0_ |= 0x00000001;
			left_ = value;
		}

		/**
		 * <code>required sint64 left = 1;</code>.
		 */
		private void clearLeft() {
			bitField0_ = bitField0_ & ~0x00000001;
			left_ = 0L;
		}

		/** The Constant RIGHT_FIELD_NUMBER. */
		public static final int RIGHT_FIELD_NUMBER = 2;
		
		/** The right. */
		private long right_;

		/**
		 * <code>required sint64 right = 2;</code>
		 */
		@java.lang.Override
		public boolean hasRight() {
			return (bitField0_ & 0x00000002) == 0x00000002;
		}

		/**
		 * <code>required sint64 right = 2;</code>
		 */
		@java.lang.Override
		public long getRight() {
			return right_;
		}

		/**
		 * <code>required sint64 right = 2;</code>.
		 */
		private void clearRight() {
			bitField0_ = bitField0_ & ~0x00000002;
			right_ = 0L;
		}

		/** The Constant TOP_FIELD_NUMBER. */
		public static final int TOP_FIELD_NUMBER = 3;
		
		/** The top. */
		private long top_;

		/**
		 * <code>required sint64 top = 3;</code>
		 */
		@java.lang.Override
		public boolean hasTop() {
			return (bitField0_ & 0x00000004) == 0x00000004;
		}

		/**
		 * <code>required sint64 top = 3;</code>
		 */
		@java.lang.Override
		public long getTop() {
			return top_;
		}

		/**
		 * <code>required sint64 top = 3;</code>.
		 */
		private void clearTop() {
			bitField0_ = bitField0_ & ~0x00000004;
			top_ = 0L;
		}

		/** The Constant BOTTOM_FIELD_NUMBER. */
		public static final int BOTTOM_FIELD_NUMBER = 4;
		
		/** The bottom. */
		private long bottom_;

		/**
		 * <code>required sint64 bottom = 4;</code>
		 */
		@java.lang.Override
		public boolean hasBottom() {
			return (bitField0_ & 0x00000008) == 0x00000008;
		}

		/**
		 * <code>required sint64 bottom = 4;</code>
		 */
		@java.lang.Override
		public long getBottom() {
			return bottom_;
		}

		/**
		 * <code>required sint64 bottom = 4;</code>.
		 */
		private void clearBottom() {
			bitField0_ = bitField0_ & ~0x00000008;
			bottom_ = 0L;
		}

		@java.lang.Override
		public void writeTo(final com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				output.writeSInt64(1, left_);
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				output.writeSInt64(2, right_);
			}
			if ((bitField0_ & 0x00000004) == 0x00000004) {
				output.writeSInt64(3, top_);
			}
			if ((bitField0_ & 0x00000008) == 0x00000008) {
				output.writeSInt64(4, bottom_);
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSerializedSize;
			if (size != -1) { return size; }

			size = 0;
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				size += com.google.protobuf.CodedOutputStream.computeSInt64Size(1, left_);
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				size += com.google.protobuf.CodedOutputStream.computeSInt64Size(2, right_);
			}
			if ((bitField0_ & 0x00000004) == 0x00000004) {
				size += com.google.protobuf.CodedOutputStream.computeSInt64Size(3, top_);
			}
			if ((bitField0_ & 0x00000008) == 0x00000008) {
				size += com.google.protobuf.CodedOutputStream.computeSInt64Size(4, bottom_);
			}
			size += unknownFields.getSerializedSize();
			memoizedSerializedSize = size;
			return size;
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the header B box
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static HeaderBBox parseFrom(final java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the header B box
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static HeaderBBox parseFrom(final java.nio.ByteBuffer data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the header B box
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static HeaderBBox parseFrom(final com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the header B box
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static HeaderBBox parseFrom(final com.google.protobuf.ByteString data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the header B box
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static HeaderBBox parseFrom(final byte[] data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the header B box
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static HeaderBBox parseFrom(final byte[] data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the header B box
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static HeaderBBox parseFrom(final java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the header B box
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static HeaderBBox parseFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @return the header B box
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static HeaderBBox parseDelimitedFrom(final java.io.InputStream input) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the header B box
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static HeaderBBox parseDelimitedFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the header B box
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static HeaderBBox parseFrom(final com.google.protobuf.CodedInputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the header B box
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static HeaderBBox parseFrom(final com.google.protobuf.CodedInputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * New builder.
		 *
		 * @return the builder
		 */
		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.newBuilder();
		}

		/**
		 * New builder.
		 *
		 * @param prototype the prototype
		 * @return the builder
		 */
		public static Builder newBuilder(final HeaderBBox prototype) {
			return DEFAULT_INSTANCE.newBuilder(prototype);
		}

		/**
		 * Protobuf type {@code OSMPBF.HeaderBBox}
		 */
		public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<HeaderBBox, Builder>
				implements
				// @@protoc_insertion_point(builder_implements:OSMPBF.HeaderBBox)
				HeaderBBoxOrBuilder {
			
			/**
			 * Instantiates a new builder.
			 */
			// Construct using HeaderBBox.newBuilder()
			private Builder() {
				super(DEFAULT_INSTANCE);
			}

			/**
			 * <code>required sint64 left = 1;</code>
			 */
			@java.lang.Override
			public boolean hasLeft() {
				return instance.hasLeft();
			}

			/**
			 * <code>required sint64 left = 1;</code>
			 */
			@java.lang.Override
			public long getLeft() {
				return instance.getLeft();
			}

			/**
			 * <code>required sint64 left = 1;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setLeft(final long value) {
				copyOnWrite();
				instance.setLeft(value);
				return this;
			}

			/**
			 * <code>required sint64 left = 1;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearLeft() {
				copyOnWrite();
				instance.clearLeft();
				return this;
			}

			/**
			 * <code>required sint64 right = 2;</code>
			 */
			@java.lang.Override
			public boolean hasRight() {
				return instance.hasRight();
			}

			/**
			 * <code>required sint64 right = 2;</code>
			 */
			@java.lang.Override
			public long getRight() {
				return instance.getRight();
			}

			/**
			 * <code>required sint64 right = 2;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearRight() {
				copyOnWrite();
				instance.clearRight();
				return this;
			}

			/**
			 * <code>required sint64 top = 3;</code>
			 */
			@java.lang.Override
			public boolean hasTop() {
				return instance.hasTop();
			}

			/**
			 * <code>required sint64 top = 3;</code>
			 */
			@java.lang.Override
			public long getTop() {
				return instance.getTop();
			}

			/**
			 * <code>required sint64 top = 3;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearTop() {
				copyOnWrite();
				instance.clearTop();
				return this;
			}

			/**
			 * <code>required sint64 bottom = 4;</code>
			 */
			@java.lang.Override
			public boolean hasBottom() {
				return instance.hasBottom();
			}

			/**
			 * <code>required sint64 bottom = 4;</code>
			 */
			@java.lang.Override
			public long getBottom() {
				return instance.getBottom();
			}

			/**
			 * <code>required sint64 bottom = 4;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearBottom() {
				copyOnWrite();
				instance.clearBottom();
				return this;
			}

			// @@protoc_insertion_point(builder_scope:OSMPBF.HeaderBBox)
		}

		/** The memoized is initialized. */
		private byte memoizedIsInitialized = 2;

		@java.lang.Override
		@java.lang.SuppressWarnings ({ "unchecked", "fallthrough" })
		protected java.lang.Object dynamicMethod(final com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
				final java.lang.Object arg0, final java.lang.Object arg1) {
			switch (method) {
				case NEW_MUTABLE_INSTANCE: {
					return new HeaderBBox();
				}
				case NEW_BUILDER: {
					return new Builder();
				}
				case IS_INITIALIZED: {
					final byte isInitialized = memoizedIsInitialized;
					if (isInitialized == 1) { return DEFAULT_INSTANCE; }
					if (isInitialized == 0) { return null; }

					// final boolean shouldMemoize = ((Boolean) arg0).booleanValue();
					if (!hasLeft()) { return null; }
					if (!hasRight()) { return null; }
					if (!hasTop()) { return null; }
					if (!hasBottom()) { return null; }
					return DEFAULT_INSTANCE;

				}
				case MAKE_IMMUTABLE: {
					return null;
				}
				case VISIT: {
					final Visitor visitor = (Visitor) arg0;
					final HeaderBBox other = (HeaderBBox) arg1;
					left_ = visitor.visitLong(hasLeft(), left_, other.hasLeft(), other.left_);
					right_ = visitor.visitLong(hasRight(), right_, other.hasRight(), other.right_);
					top_ = visitor.visitLong(hasTop(), top_, other.hasTop(), other.top_);
					bottom_ = visitor.visitLong(hasBottom(), bottom_, other.hasBottom(), other.bottom_);
					if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
						bitField0_ |= other.bitField0_;
					}
					return this;
				}
				case MERGE_FROM_STREAM: {
					final com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
					final com.google.protobuf.ExtensionRegistryLite extensionRegistry =
							(com.google.protobuf.ExtensionRegistryLite) arg1;
					if (extensionRegistry == null) { throw new java.lang.NullPointerException(); }
					try {
						boolean done = false;
						while (!done) {
							final int tag = input.readTag();
							switch (tag) {
								case 0:
									done = true;
									break;
								case 8: {
									bitField0_ |= 0x00000001;
									left_ = input.readSInt64();
									break;
								}
								case 16: {
									bitField0_ |= 0x00000002;
									right_ = input.readSInt64();
									break;
								}
								case 24: {
									bitField0_ |= 0x00000004;
									top_ = input.readSInt64();
									break;
								}
								case 32: {
									bitField0_ |= 0x00000008;
									bottom_ = input.readSInt64();
									break;
								}
								default: {
									if (!parseUnknownField(tag, input)) {
										done = true;
									}
									break;
								}
							}
						}
					} catch (final com.google.protobuf.InvalidProtocolBufferException e) {
						throw new RuntimeException(e.setUnfinishedMessage(this));
					} catch (final java.io.IOException e) {
						throw new RuntimeException(
								new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
										.setUnfinishedMessage(this));
					} finally {}
				}
				// fall through
				case GET_DEFAULT_INSTANCE: {
					return DEFAULT_INSTANCE;
				}
				case GET_PARSER: {
					com.google.protobuf.Parser<HeaderBBox> parser = PARSER;
					if (parser == null) {
						synchronized (HeaderBBox.class) {
							parser = PARSER;
							if (parser == null) {
								parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
								PARSER = parser;
							}
						}
					}
					return parser;
				}
				case GET_MEMOIZED_IS_INITIALIZED: {
					return memoizedIsInitialized;
				}
				case SET_MEMOIZED_IS_INITIALIZED: {
					memoizedIsInitialized = (byte) (arg0 == null ? 0 : 1);
					return null;
				}
			}
			throw new UnsupportedOperationException();
		}

		/** The Constant DEFAULT_INSTANCE. */
		// @@protoc_insertion_point(class_scope:OSMPBF.HeaderBBox)
		private static final HeaderBBox DEFAULT_INSTANCE;
		static {
			// New instances are implicitly immutable so no need to make
			// immutable.
			DEFAULT_INSTANCE = new HeaderBBox();
		}

		/**
		 * Gets the default instance.
		 *
		 * @return the default instance
		 */
		public static HeaderBBox getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		/** The parser. */
		private static volatile com.google.protobuf.Parser<HeaderBBox> PARSER;

		/**
		 * Parser.
		 *
		 * @return the com.google.protobuf. parser
		 */
		public static com.google.protobuf.Parser<HeaderBBox> parser() {
			return DEFAULT_INSTANCE.getParserForType();
		}
	}

	/**
	 * The Interface PrimitiveBlockOrBuilder.
	 */
	public interface PrimitiveBlockOrBuilder extends
			// @@protoc_insertion_point(interface_extends:OSMPBF.PrimitiveBlock)
			com.google.protobuf.MessageLiteOrBuilder {

		/**
		 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
		 *
		 * @return true, if successful
		 */
		boolean hasStringtable();

		/**
		 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
		 *
		 * @return the stringtable
		 */
		StringTable getStringtable();

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 *
		 * @return the primitivegroup list
		 */
		java.util.List<PrimitiveGroup> getPrimitivegroupList();

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 *
		 * @param index the index
		 * @return the primitivegroup
		 */
		PrimitiveGroup getPrimitivegroup(int index);

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 *
		 * @return the primitivegroup count
		 */
		int getPrimitivegroupCount();

		/**
		 * <pre>
		 * Granularity, units of nanodegrees, used to store coordinates in this block
		 * </pre>
		 * 
		 * <code>optional int32 granularity = 17 [default = 100];</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasGranularity();

		/**
		 * <pre>
		 * Granularity, units of nanodegrees, used to store coordinates in this block
		 * </pre>
		 * 
		 * <code>optional int32 granularity = 17 [default = 100];</code>.
		 *
		 * @return the granularity
		 */
		int getGranularity();

		/**
		 * <pre>
		 * Offset value between the output coordinates coordinates and the granularity grid in unites of nanodegrees.
		 * </pre>
		 * 
		 * <code>optional int64 lat_offset = 19 [default = 0];</code>
		 *
		 * @return true, if successful
		 */
		boolean hasLatOffset();

		/**
		 * <pre>
		 * Offset value between the output coordinates coordinates and the granularity grid in unites of nanodegrees.
		 * </pre>
		 * 
		 * <code>optional int64 lat_offset = 19 [default = 0];</code>
		 *
		 * @return the lat offset
		 */
		long getLatOffset();

		/**
		 * <code>optional int64 lon_offset = 20 [default = 0];</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasLonOffset();

		/**
		 * <code>optional int64 lon_offset = 20 [default = 0];</code>.
		 *
		 * @return the lon offset
		 */
		long getLonOffset();

		/**
		 * <pre>
		 * Granularity of dates, normally represented in units of milliseconds since the 1970 epoch.
		 * </pre>
		 * 
		 * <code>optional int32 date_granularity = 18 [default = 1000];</code>
		 *
		 * @return true, if successful
		 */
		boolean hasDateGranularity();

		/**
		 * <pre>
		 * Granularity of dates, normally represented in units of milliseconds since the 1970 epoch.
		 * </pre>
		 * 
		 * <code>optional int32 date_granularity = 18 [default = 1000];</code>
		 *
		 * @return the date granularity
		 */
		int getDateGranularity();
	}

	/**
	 * Protobuf type {@code OSMPBF.PrimitiveBlock}
	 */
	public static final class PrimitiveBlock
			extends com.google.protobuf.GeneratedMessageLite<PrimitiveBlock, PrimitiveBlock.Builder> implements
			// @@protoc_insertion_point(message_implements:OSMPBF.PrimitiveBlock)
			PrimitiveBlockOrBuilder {
		
		/**
		 * Instantiates a new primitive block.
		 */
		private PrimitiveBlock() {
			primitivegroup_ = emptyProtobufList();
			granularity_ = 100;
			dateGranularity_ = 1000;
		}

		/** The bit field 0. */
		private int bitField0_;
		
		/** The Constant STRINGTABLE_FIELD_NUMBER. */
		public static final int STRINGTABLE_FIELD_NUMBER = 1;
		
		/** The stringtable. */
		private StringTable stringtable_;

		/**
		 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
		 */
		@java.lang.Override
		public boolean hasStringtable() {
			return (bitField0_ & 0x00000001) == 0x00000001;
		}

		/**
		 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
		 */
		@java.lang.Override
		public StringTable getStringtable() {
			return stringtable_ == null ? StringTable.getDefaultInstance() : stringtable_;
		}

		/**
		 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
		 *
		 * @param value the new stringtable
		 */
		private void setStringtable(final StringTable value) {
			if (value == null) { throw new NullPointerException(); }
			stringtable_ = value;
			bitField0_ |= 0x00000001;
		}

		/**
		 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
		 *
		 * @param builderForValue the new stringtable
		 */
		private void setStringtable(final StringTable.Builder builderForValue) {
			stringtable_ = builderForValue.build();
			bitField0_ |= 0x00000001;
		}

		/**
		 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
		 *
		 * @param value the value
		 */
		private void mergeStringtable(final StringTable value) {
			if (value == null) { throw new NullPointerException(); }
			if (stringtable_ != null && stringtable_ != StringTable.getDefaultInstance()) {
				stringtable_ = StringTable.newBuilder(stringtable_).mergeFrom(value).buildPartial();
			} else {
				stringtable_ = value;
			}
			bitField0_ |= 0x00000001;
		}

		/**
		 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
		 */
		private void clearStringtable() {
			stringtable_ = null;
			bitField0_ = bitField0_ & ~0x00000001;
		}

		/** The Constant PRIMITIVEGROUP_FIELD_NUMBER. */
		public static final int PRIMITIVEGROUP_FIELD_NUMBER = 2;
		
		/** The primitivegroup. */
		private com.google.protobuf.Internal.ProtobufList<PrimitiveGroup> primitivegroup_;

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 */
		@java.lang.Override
		public java.util.List<PrimitiveGroup> getPrimitivegroupList() {
			return primitivegroup_;
		}

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 *
		 * @return the primitivegroup or builder list
		 */
		public java.util.List<? extends PrimitiveGroupOrBuilder> getPrimitivegroupOrBuilderList() {
			return primitivegroup_;
		}

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 */
		@java.lang.Override
		public int getPrimitivegroupCount() {
			return primitivegroup_.size();
		}

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 */
		@java.lang.Override
		public PrimitiveGroup getPrimitivegroup(final int index) {
			return primitivegroup_.get(index);
		}

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 *
		 * @param index the index
		 * @return the primitivegroup or builder
		 */
		public PrimitiveGroupOrBuilder getPrimitivegroupOrBuilder(final int index) {
			return primitivegroup_.get(index);
		}

		/**
		 * Ensure primitivegroup is mutable.
		 */
		private void ensurePrimitivegroupIsMutable() {
			if (!primitivegroup_.isModifiable()) {
				primitivegroup_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(primitivegroup_);
			}
		}

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setPrimitivegroup(final int index, final PrimitiveGroup value) {
			if (value == null) { throw new NullPointerException(); }
			ensurePrimitivegroupIsMutable();
			primitivegroup_.set(index, value);
		}

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 *
		 * @param index the index
		 * @param builderForValue the builder for value
		 */
		private void setPrimitivegroup(final int index, final PrimitiveGroup.Builder builderForValue) {
			ensurePrimitivegroupIsMutable();
			primitivegroup_.set(index, builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 *
		 * @param value the value
		 */
		private void addPrimitivegroup(final PrimitiveGroup value) {
			if (value == null) { throw new NullPointerException(); }
			ensurePrimitivegroupIsMutable();
			primitivegroup_.add(value);
		}

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void addPrimitivegroup(final int index, final PrimitiveGroup value) {
			if (value == null) { throw new NullPointerException(); }
			ensurePrimitivegroupIsMutable();
			primitivegroup_.add(index, value);
		}

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 *
		 * @param builderForValue the builder for value
		 */
		private void addPrimitivegroup(final PrimitiveGroup.Builder builderForValue) {
			ensurePrimitivegroupIsMutable();
			primitivegroup_.add(builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 *
		 * @param index the index
		 * @param builderForValue the builder for value
		 */
		private void addPrimitivegroup(final int index, final PrimitiveGroup.Builder builderForValue) {
			ensurePrimitivegroupIsMutable();
			primitivegroup_.add(index, builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 *
		 * @param values the values
		 */
		private void addAllPrimitivegroup(final java.lang.Iterable<? extends PrimitiveGroup> values) {
			ensurePrimitivegroupIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, primitivegroup_);
		}

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 */
		private void clearPrimitivegroup() {
			primitivegroup_ = emptyProtobufList();
		}

		/**
		 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
		 *
		 * @param index the index
		 */
		private void removePrimitivegroup(final int index) {
			ensurePrimitivegroupIsMutable();
			primitivegroup_.remove(index);
		}

		/** The Constant GRANULARITY_FIELD_NUMBER. */
		public static final int GRANULARITY_FIELD_NUMBER = 17;
		
		/** The granularity. */
		private int granularity_;

		/**
		 * <pre>
		 * Granularity, units of nanodegrees, used to store coordinates in this block
		 * </pre>
		 *
		 * <code>optional int32 granularity = 17 [default = 100];</code>
		 */
		@java.lang.Override
		public boolean hasGranularity() {
			return (bitField0_ & 0x00000002) == 0x00000002;
		}

		/**
		 * <pre>
		 * Granularity, units of nanodegrees, used to store coordinates in this block
		 * </pre>
		 *
		 * <code>optional int32 granularity = 17 [default = 100];</code>
		 */
		@java.lang.Override
		public int getGranularity() {
			return granularity_;
		}

		/**
		 * <pre>
		 * Granularity, units of nanodegrees, used to store coordinates in this block
		 * </pre>
		 * 
		 * <code>optional int32 granularity = 17 [default = 100];</code>.
		 *
		 * @param value the new granularity
		 */
		private void setGranularity(final int value) {
			bitField0_ |= 0x00000002;
			granularity_ = value;
		}

		/**
		 * <pre>
		 * Granularity, units of nanodegrees, used to store coordinates in this block
		 * </pre>
		 * 
		 * <code>optional int32 granularity = 17 [default = 100];</code>.
		 */
		private void clearGranularity() {
			bitField0_ = bitField0_ & ~0x00000002;
			granularity_ = 100;
		}

		/** The Constant LAT_OFFSET_FIELD_NUMBER. */
		public static final int LAT_OFFSET_FIELD_NUMBER = 19;
		
		/** The lat offset. */
		private long latOffset_;

		/**
		 * <pre>
		 * Offset value between the output coordinates coordinates and the granularity grid in unites of nanodegrees.
		 * </pre>
		 *
		 * <code>optional int64 lat_offset = 19 [default = 0];</code>
		 */
		@java.lang.Override
		public boolean hasLatOffset() {
			return (bitField0_ & 0x00000004) == 0x00000004;
		}

		/**
		 * <pre>
		 * Offset value between the output coordinates coordinates and the granularity grid in unites of nanodegrees.
		 * </pre>
		 *
		 * <code>optional int64 lat_offset = 19 [default = 0];</code>
		 */
		@java.lang.Override
		public long getLatOffset() {
			return latOffset_;
		}

		/**
		 * <pre>
		 * Offset value between the output coordinates coordinates and the granularity grid in unites of nanodegrees.
		 * </pre>
		 * 
		 * <code>optional int64 lat_offset = 19 [default = 0];</code>
		 *
		 * @param value the new lat offset
		 */
		private void setLatOffset(final long value) {
			bitField0_ |= 0x00000004;
			latOffset_ = value;
		}

		/**
		 * <pre>
		 * Offset value between the output coordinates coordinates and the granularity grid in unites of nanodegrees.
		 * </pre>
		 *
		 * <code>optional int64 lat_offset = 19 [default = 0];</code>
		 */
		private void clearLatOffset() {
			bitField0_ = bitField0_ & ~0x00000004;
			latOffset_ = 0L;
		}

		/** The Constant LON_OFFSET_FIELD_NUMBER. */
		public static final int LON_OFFSET_FIELD_NUMBER = 20;
		
		/** The lon offset. */
		private long lonOffset_;

		/**
		 * <code>optional int64 lon_offset = 20 [default = 0];</code>
		 */
		@java.lang.Override
		public boolean hasLonOffset() {
			return (bitField0_ & 0x00000008) == 0x00000008;
		}

		/**
		 * <code>optional int64 lon_offset = 20 [default = 0];</code>
		 */
		@java.lang.Override
		public long getLonOffset() {
			return lonOffset_;
		}

		/**
		 * <code>optional int64 lon_offset = 20 [default = 0];</code>.
		 *
		 * @param value the new lon offset
		 */
		private void setLonOffset(final long value) {
			bitField0_ |= 0x00000008;
			lonOffset_ = value;
		}

		/**
		 * <code>optional int64 lon_offset = 20 [default = 0];</code>.
		 */
		private void clearLonOffset() {
			bitField0_ = bitField0_ & ~0x00000008;
			lonOffset_ = 0L;
		}

		/** The Constant DATE_GRANULARITY_FIELD_NUMBER. */
		public static final int DATE_GRANULARITY_FIELD_NUMBER = 18;
		
		/** The date granularity. */
		private int dateGranularity_;

		/**
		 * <pre>
		 * Granularity of dates, normally represented in units of milliseconds since the 1970 epoch.
		 * </pre>
		 *
		 * <code>optional int32 date_granularity = 18 [default = 1000];</code>
		 */
		@java.lang.Override
		public boolean hasDateGranularity() {
			return (bitField0_ & 0x00000010) == 0x00000010;
		}

		/**
		 * <pre>
		 * Granularity of dates, normally represented in units of milliseconds since the 1970 epoch.
		 * </pre>
		 *
		 * <code>optional int32 date_granularity = 18 [default = 1000];</code>
		 */
		@java.lang.Override
		public int getDateGranularity() {
			return dateGranularity_;
		}

		/**
		 * <pre>
		 * Granularity of dates, normally represented in units of milliseconds since the 1970 epoch.
		 * </pre>
		 * 
		 * <code>optional int32 date_granularity = 18 [default = 1000];</code>
		 *
		 * @param value the new date granularity
		 */
		private void setDateGranularity(final int value) {
			bitField0_ |= 0x00000010;
			dateGranularity_ = value;
		}

		/**
		 * <pre>
		 * Granularity of dates, normally represented in units of milliseconds since the 1970 epoch.
		 * </pre>
		 *
		 * <code>optional int32 date_granularity = 18 [default = 1000];</code>
		 */
		private void clearDateGranularity() {
			bitField0_ = bitField0_ & ~0x00000010;
			dateGranularity_ = 1000;
		}

		@java.lang.Override
		public void writeTo(final com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				output.writeMessage(1, getStringtable());
			}
			for (int i = 0; i < primitivegroup_.size(); i++) {
				output.writeMessage(2, primitivegroup_.get(i));
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				output.writeInt32(17, granularity_);
			}
			if ((bitField0_ & 0x00000010) == 0x00000010) {
				output.writeInt32(18, dateGranularity_);
			}
			if ((bitField0_ & 0x00000004) == 0x00000004) {
				output.writeInt64(19, latOffset_);
			}
			if ((bitField0_ & 0x00000008) == 0x00000008) {
				output.writeInt64(20, lonOffset_);
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSerializedSize;
			if (size != -1) { return size; }

			size = 0;
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, getStringtable());
			}
			for (int i = 0; i < primitivegroup_.size(); i++) {
				size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, primitivegroup_.get(i));
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				size += com.google.protobuf.CodedOutputStream.computeInt32Size(17, granularity_);
			}
			if ((bitField0_ & 0x00000010) == 0x00000010) {
				size += com.google.protobuf.CodedOutputStream.computeInt32Size(18, dateGranularity_);
			}
			if ((bitField0_ & 0x00000004) == 0x00000004) {
				size += com.google.protobuf.CodedOutputStream.computeInt64Size(19, latOffset_);
			}
			if ((bitField0_ & 0x00000008) == 0x00000008) {
				size += com.google.protobuf.CodedOutputStream.computeInt64Size(20, lonOffset_);
			}
			size += unknownFields.getSerializedSize();
			memoizedSerializedSize = size;
			return size;
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the primitive block
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static PrimitiveBlock parseFrom(final java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the primitive block
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static PrimitiveBlock parseFrom(final java.nio.ByteBuffer data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the primitive block
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static PrimitiveBlock parseFrom(final com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the primitive block
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static PrimitiveBlock parseFrom(final com.google.protobuf.ByteString data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the primitive block
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static PrimitiveBlock parseFrom(final byte[] data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the primitive block
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static PrimitiveBlock parseFrom(final byte[] data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the primitive block
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static PrimitiveBlock parseFrom(final java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the primitive block
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static PrimitiveBlock parseFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @return the primitive block
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static PrimitiveBlock parseDelimitedFrom(final java.io.InputStream input) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the primitive block
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static PrimitiveBlock parseDelimitedFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the primitive block
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static PrimitiveBlock parseFrom(final com.google.protobuf.CodedInputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the primitive block
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static PrimitiveBlock parseFrom(final com.google.protobuf.CodedInputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * New builder.
		 *
		 * @return the builder
		 */
		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.newBuilder();
		}

		/**
		 * New builder.
		 *
		 * @param prototype the prototype
		 * @return the builder
		 */
		public static Builder newBuilder(final PrimitiveBlock prototype) {
			return DEFAULT_INSTANCE.newBuilder(prototype);
		}

		/**
		 * Protobuf type {@code OSMPBF.PrimitiveBlock}
		 */
		public static final class Builder
				extends com.google.protobuf.GeneratedMessageLite.Builder<PrimitiveBlock, Builder> implements
				// @@protoc_insertion_point(builder_implements:OSMPBF.PrimitiveBlock)
				PrimitiveBlockOrBuilder {
			
			/**
			 * Instantiates a new builder.
			 */
			// Construct using PrimitiveBlock.newBuilder()
			private Builder() {
				super(DEFAULT_INSTANCE);
			}

			/**
			 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
			 */
			@java.lang.Override
			public boolean hasStringtable() {
				return instance.hasStringtable();
			}

			/**
			 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
			 */
			@java.lang.Override
			public StringTable getStringtable() {
				return instance.getStringtable();
			}

			/**
			 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setStringtable(final StringTable value) {
				copyOnWrite();
				instance.setStringtable(value);
				return this;
			}

			/**
			 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
			 *
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder setStringtable(final StringTable.Builder builderForValue) {
				copyOnWrite();
				instance.setStringtable(builderForValue);
				return this;
			}

			/**
			 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder mergeStringtable(final StringTable value) {
				copyOnWrite();
				instance.mergeStringtable(value);
				return this;
			}

			/**
			 * <code>required .OSMPBF.StringTable stringtable = 1;</code>
			 *
			 * @return the builder
			 */
			public Builder clearStringtable() {
				copyOnWrite();
				instance.clearStringtable();
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
			 */
			@java.lang.Override
			public java.util.List<PrimitiveGroup> getPrimitivegroupList() {
				return java.util.Collections.unmodifiableList(instance.getPrimitivegroupList());
			}

			/**
			 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
			 */
			@java.lang.Override
			public int getPrimitivegroupCount() {
				return instance.getPrimitivegroupCount();
			}

			/**
			 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
			 */
			@java.lang.Override
			public PrimitiveGroup getPrimitivegroup(final int index) {
				return instance.getPrimitivegroup(index);
			}

			/**
			 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setPrimitivegroup(final int index, final PrimitiveGroup value) {
				copyOnWrite();
				instance.setPrimitivegroup(index, value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
			 *
			 * @param index the index
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder setPrimitivegroup(final int index, final PrimitiveGroup.Builder builderForValue) {
				copyOnWrite();
				instance.setPrimitivegroup(index, builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addPrimitivegroup(final PrimitiveGroup value) {
				copyOnWrite();
				instance.addPrimitivegroup(value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder addPrimitivegroup(final int index, final PrimitiveGroup value) {
				copyOnWrite();
				instance.addPrimitivegroup(index, value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
			 *
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder addPrimitivegroup(final PrimitiveGroup.Builder builderForValue) {
				copyOnWrite();
				instance.addPrimitivegroup(builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
			 *
			 * @param index the index
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder addPrimitivegroup(final int index, final PrimitiveGroup.Builder builderForValue) {
				copyOnWrite();
				instance.addPrimitivegroup(index, builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllPrimitivegroup(final java.lang.Iterable<? extends PrimitiveGroup> values) {
				copyOnWrite();
				instance.addAllPrimitivegroup(values);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
			 *
			 * @return the builder
			 */
			public Builder clearPrimitivegroup() {
				copyOnWrite();
				instance.clearPrimitivegroup();
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.PrimitiveGroup primitivegroup = 2;</code>
			 *
			 * @param index the index
			 * @return the builder
			 */
			public Builder removePrimitivegroup(final int index) {
				copyOnWrite();
				instance.removePrimitivegroup(index);
				return this;
			}

			/**
			 * <pre>
			 * Granularity, units of nanodegrees, used to store coordinates in this block
			 * </pre>
			 *
			 * <code>optional int32 granularity = 17 [default = 100];</code>
			 */
			@java.lang.Override
			public boolean hasGranularity() {
				return instance.hasGranularity();
			}

			/**
			 * <pre>
			 * Granularity, units of nanodegrees, used to store coordinates in this block
			 * </pre>
			 *
			 * <code>optional int32 granularity = 17 [default = 100];</code>
			 */
			@java.lang.Override
			public int getGranularity() {
				return instance.getGranularity();
			}

			/**
			 * <pre>
			 * Granularity, units of nanodegrees, used to store coordinates in this block
			 * </pre>
			 * 
			 * <code>optional int32 granularity = 17 [default = 100];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setGranularity(final int value) {
				copyOnWrite();
				instance.setGranularity(value);
				return this;
			}

			/**
			 * <pre>
			 * Granularity, units of nanodegrees, used to store coordinates in this block
			 * </pre>
			 * 
			 * <code>optional int32 granularity = 17 [default = 100];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearGranularity() {
				copyOnWrite();
				instance.clearGranularity();
				return this;
			}

			/**
			 * <pre>
			 * Offset value between the output coordinates coordinates and the granularity grid in unites of nanodegrees.
			 * </pre>
			 *
			 * <code>optional int64 lat_offset = 19 [default = 0];</code>
			 */
			@java.lang.Override
			public boolean hasLatOffset() {
				return instance.hasLatOffset();
			}

			/**
			 * <pre>
			 * Offset value between the output coordinates coordinates and the granularity grid in unites of nanodegrees.
			 * </pre>
			 *
			 * <code>optional int64 lat_offset = 19 [default = 0];</code>
			 */
			@java.lang.Override
			public long getLatOffset() {
				return instance.getLatOffset();
			}

			/**
			 * <pre>
			 * Offset value between the output coordinates coordinates and the granularity grid in unites of nanodegrees.
			 * </pre>
			 * 
			 * <code>optional int64 lat_offset = 19 [default = 0];</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setLatOffset(final long value) {
				copyOnWrite();
				instance.setLatOffset(value);
				return this;
			}

			/**
			 * <pre>
			 * Offset value between the output coordinates coordinates and the granularity grid in unites of nanodegrees.
			 * </pre>
			 * 
			 * <code>optional int64 lat_offset = 19 [default = 0];</code>
			 *
			 * @return the builder
			 */
			public Builder clearLatOffset() {
				copyOnWrite();
				instance.clearLatOffset();
				return this;
			}

			/**
			 * <code>optional int64 lon_offset = 20 [default = 0];</code>
			 */
			@java.lang.Override
			public boolean hasLonOffset() {
				return instance.hasLonOffset();
			}

			/**
			 * <code>optional int64 lon_offset = 20 [default = 0];</code>
			 */
			@java.lang.Override
			public long getLonOffset() {
				return instance.getLonOffset();
			}

			/**
			 * <code>optional int64 lon_offset = 20 [default = 0];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setLonOffset(final long value) {
				copyOnWrite();
				instance.setLonOffset(value);
				return this;
			}

			/**
			 * <code>optional int64 lon_offset = 20 [default = 0];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearLonOffset() {
				copyOnWrite();
				instance.clearLonOffset();
				return this;
			}

			/**
			 * <pre>
			 * Granularity of dates, normally represented in units of milliseconds since the 1970 epoch.
			 * </pre>
			 *
			 * <code>optional int32 date_granularity = 18 [default = 1000];</code>
			 */
			@java.lang.Override
			public boolean hasDateGranularity() {
				return instance.hasDateGranularity();
			}

			/**
			 * <pre>
			 * Granularity of dates, normally represented in units of milliseconds since the 1970 epoch.
			 * </pre>
			 *
			 * <code>optional int32 date_granularity = 18 [default = 1000];</code>
			 */
			@java.lang.Override
			public int getDateGranularity() {
				return instance.getDateGranularity();
			}

			/**
			 * <pre>
			 * Granularity of dates, normally represented in units of milliseconds since the 1970 epoch.
			 * </pre>
			 * 
			 * <code>optional int32 date_granularity = 18 [default = 1000];</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setDateGranularity(final int value) {
				copyOnWrite();
				instance.setDateGranularity(value);
				return this;
			}

			/**
			 * <pre>
			 * Granularity of dates, normally represented in units of milliseconds since the 1970 epoch.
			 * </pre>
			 * 
			 * <code>optional int32 date_granularity = 18 [default = 1000];</code>
			 *
			 * @return the builder
			 */
			public Builder clearDateGranularity() {
				copyOnWrite();
				instance.clearDateGranularity();
				return this;
			}

			// @@protoc_insertion_point(builder_scope:OSMPBF.PrimitiveBlock)
		}

		/** The memoized is initialized. */
		private byte memoizedIsInitialized = 2;

		@java.lang.Override
		@java.lang.SuppressWarnings ({ "unchecked", "fallthrough" })
		protected java.lang.Object dynamicMethod(final com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
				final java.lang.Object arg0, final java.lang.Object arg1) {
			switch (method) {
				case NEW_MUTABLE_INSTANCE: {
					return new PrimitiveBlock();
				}
				case NEW_BUILDER: {
					return new Builder();
				}
				case IS_INITIALIZED: {
					final byte isInitialized = memoizedIsInitialized;
					if (isInitialized == 1) { return DEFAULT_INSTANCE; }
					if (isInitialized == 0) { return null; }

					if (!hasStringtable()) { return null; }
					for (int i = 0; i < getPrimitivegroupCount(); i++) {
						if (!getPrimitivegroup(i).isInitialized()) { return null; }
					}
					return DEFAULT_INSTANCE;

				}
				case MAKE_IMMUTABLE: {
					primitivegroup_.makeImmutable();
					return null;
				}
				case VISIT: {
					final Visitor visitor = (Visitor) arg0;
					final PrimitiveBlock other = (PrimitiveBlock) arg1;
					stringtable_ = visitor.visitMessage(stringtable_, other.stringtable_);
					primitivegroup_ = visitor.visitList(primitivegroup_, other.primitivegroup_);
					granularity_ = visitor.visitInt(hasGranularity(), granularity_, other.hasGranularity(),
							other.granularity_);
					latOffset_ = visitor.visitLong(hasLatOffset(), latOffset_, other.hasLatOffset(), other.latOffset_);
					lonOffset_ = visitor.visitLong(hasLonOffset(), lonOffset_, other.hasLonOffset(), other.lonOffset_);
					dateGranularity_ = visitor.visitInt(hasDateGranularity(), dateGranularity_,
							other.hasDateGranularity(), other.dateGranularity_);
					if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
						bitField0_ |= other.bitField0_;
					}
					return this;
				}
				case MERGE_FROM_STREAM: {
					final com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
					final com.google.protobuf.ExtensionRegistryLite extensionRegistry =
							(com.google.protobuf.ExtensionRegistryLite) arg1;
					if (extensionRegistry == null) { throw new java.lang.NullPointerException(); }
					try {
						boolean done = false;
						while (!done) {
							final int tag = input.readTag();
							switch (tag) {
								case 0:
									done = true;
									break;
								case 10: {
									StringTable.Builder subBuilder = null;
									if ((bitField0_ & 0x00000001) == 0x00000001) {
										subBuilder = stringtable_.toBuilder();
									}
									stringtable_ = input.readMessage(StringTable.parser(), extensionRegistry);
									if (subBuilder != null) {
										subBuilder.mergeFrom(stringtable_);
										stringtable_ = subBuilder.buildPartial();
									}
									bitField0_ |= 0x00000001;
									break;
								}
								case 18: {
									if (!primitivegroup_.isModifiable()) {
										primitivegroup_ =
												com.google.protobuf.GeneratedMessageLite.mutableCopy(primitivegroup_);
									}
									primitivegroup_.add(input.readMessage(PrimitiveGroup.parser(), extensionRegistry));
									break;
								}
								case 136: {
									bitField0_ |= 0x00000002;
									granularity_ = input.readInt32();
									break;
								}
								case 144: {
									bitField0_ |= 0x00000010;
									dateGranularity_ = input.readInt32();
									break;
								}
								case 152: {
									bitField0_ |= 0x00000004;
									latOffset_ = input.readInt64();
									break;
								}
								case 160: {
									bitField0_ |= 0x00000008;
									lonOffset_ = input.readInt64();
									break;
								}
								default: {
									if (!parseUnknownField(tag, input)) {
										done = true;
									}
									break;
								}
							}
						}
					} catch (final com.google.protobuf.InvalidProtocolBufferException e) {
						throw new RuntimeException(e.setUnfinishedMessage(this));
					} catch (final java.io.IOException e) {
						throw new RuntimeException(
								new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
										.setUnfinishedMessage(this));
					} finally {}
				}
				// fall through
				case GET_DEFAULT_INSTANCE: {
					return DEFAULT_INSTANCE;
				}
				case GET_PARSER: {
					com.google.protobuf.Parser<PrimitiveBlock> parser = PARSER;
					if (parser == null) {
						synchronized (PrimitiveBlock.class) {
							parser = PARSER;
							if (parser == null) {
								parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
								PARSER = parser;
							}
						}
					}
					return parser;
				}
				case GET_MEMOIZED_IS_INITIALIZED: {
					return memoizedIsInitialized;
				}
				case SET_MEMOIZED_IS_INITIALIZED: {
					memoizedIsInitialized = (byte) (arg0 == null ? 0 : 1);
					return null;
				}
			}
			throw new UnsupportedOperationException();
		}

		/** The Constant DEFAULT_INSTANCE. */
		// @@protoc_insertion_point(class_scope:OSMPBF.PrimitiveBlock)
		private static final PrimitiveBlock DEFAULT_INSTANCE;
		static {
			// New instances are implicitly immutable so no need to make
			// immutable.
			DEFAULT_INSTANCE = new PrimitiveBlock();
		}

		/**
		 * Gets the default instance.
		 *
		 * @return the default instance
		 */
		public static PrimitiveBlock getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		/** The parser. */
		private static volatile com.google.protobuf.Parser<PrimitiveBlock> PARSER;

		/**
		 * Parser.
		 *
		 * @return the com.google.protobuf. parser
		 */
		public static com.google.protobuf.Parser<PrimitiveBlock> parser() {
			return DEFAULT_INSTANCE.getParserForType();
		}
	}

	/**
	 * The Interface PrimitiveGroupOrBuilder.
	 */
	public interface PrimitiveGroupOrBuilder extends
			// @@protoc_insertion_point(interface_extends:OSMPBF.PrimitiveGroup)
			com.google.protobuf.MessageLiteOrBuilder {

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 *
		 * @return the nodes list
		 */
		java.util.List<Node> getNodesList();

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 *
		 * @param index the index
		 * @return the nodes
		 */
		Node getNodes(int index);

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 *
		 * @return the nodes count
		 */
		int getNodesCount();

		/**
		 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
		 *
		 * @return true, if successful
		 */
		boolean hasDense();

		/**
		 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
		 *
		 * @return the dense
		 */
		DenseNodes getDense();

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 *
		 * @return the ways list
		 */
		java.util.List<Way> getWaysList();

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 *
		 * @param index the index
		 * @return the ways
		 */
		Way getWays(int index);

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 *
		 * @return the ways count
		 */
		int getWaysCount();

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 *
		 * @return the relations list
		 */
		java.util.List<Relation> getRelationsList();

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 *
		 * @param index the index
		 * @return the relations
		 */
		Relation getRelations(int index);

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 *
		 * @return the relations count
		 */
		int getRelationsCount();

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 *
		 * @return the changesets list
		 */
		java.util.List<ChangeSet> getChangesetsList();

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 *
		 * @param index the index
		 * @return the changesets
		 */
		ChangeSet getChangesets(int index);

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 *
		 * @return the changesets count
		 */
		int getChangesetsCount();
	}

	/**
	 * <pre>
	 * Group of OSMPrimitives. All primitives in a group must be the same type.
	 * </pre>
	 *
	 * Protobuf type {@code OSMPBF.PrimitiveGroup}
	 */
	public static final class PrimitiveGroup
			extends com.google.protobuf.GeneratedMessageLite<PrimitiveGroup, PrimitiveGroup.Builder> implements
			// @@protoc_insertion_point(message_implements:OSMPBF.PrimitiveGroup)
			PrimitiveGroupOrBuilder {
		
		/**
		 * Instantiates a new primitive group.
		 */
		private PrimitiveGroup() {
			nodes_ = emptyProtobufList();
			ways_ = emptyProtobufList();
			relations_ = emptyProtobufList();
			changesets_ = emptyProtobufList();
		}

		/** The bit field 0. */
		private int bitField0_;
		
		/** The Constant NODES_FIELD_NUMBER. */
		public static final int NODES_FIELD_NUMBER = 1;
		
		/** The nodes. */
		private com.google.protobuf.Internal.ProtobufList<Node> nodes_;

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 */
		@java.lang.Override
		public java.util.List<Node> getNodesList() {
			return nodes_;
		}

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 *
		 * @return the nodes or builder list
		 */
		public java.util.List<? extends NodeOrBuilder> getNodesOrBuilderList() {
			return nodes_;
		}

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 */
		@java.lang.Override
		public int getNodesCount() {
			return nodes_.size();
		}

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 */
		@java.lang.Override
		public Node getNodes(final int index) {
			return nodes_.get(index);
		}

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 *
		 * @param index the index
		 * @return the nodes or builder
		 */
		public NodeOrBuilder getNodesOrBuilder(final int index) {
			return nodes_.get(index);
		}

		/**
		 * Ensure nodes is mutable.
		 */
		private void ensureNodesIsMutable() {
			if (!nodes_.isModifiable()) {
				nodes_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(nodes_);
			}
		}

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setNodes(final int index, final Node value) {
			if (value == null) { throw new NullPointerException(); }
			ensureNodesIsMutable();
			nodes_.set(index, value);
		}

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 *
		 * @param index the index
		 * @param builderForValue the builder for value
		 */
		private void setNodes(final int index, final Node.Builder builderForValue) {
			ensureNodesIsMutable();
			nodes_.set(index, builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 *
		 * @param value the value
		 */
		private void addNodes(final Node value) {
			if (value == null) { throw new NullPointerException(); }
			ensureNodesIsMutable();
			nodes_.add(value);
		}

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void addNodes(final int index, final Node value) {
			if (value == null) { throw new NullPointerException(); }
			ensureNodesIsMutable();
			nodes_.add(index, value);
		}

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 *
		 * @param builderForValue the builder for value
		 */
		private void addNodes(final Node.Builder builderForValue) {
			ensureNodesIsMutable();
			nodes_.add(builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 *
		 * @param index the index
		 * @param builderForValue the builder for value
		 */
		private void addNodes(final int index, final Node.Builder builderForValue) {
			ensureNodesIsMutable();
			nodes_.add(index, builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 *
		 * @param values the values
		 */
		private void addAllNodes(final java.lang.Iterable<? extends Node> values) {
			ensureNodesIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, nodes_);
		}

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 */
		private void clearNodes() {
			nodes_ = emptyProtobufList();
		}

		/**
		 * <code>repeated .OSMPBF.Node nodes = 1;</code>
		 *
		 * @param index the index
		 */
		private void removeNodes(final int index) {
			ensureNodesIsMutable();
			nodes_.remove(index);
		}

		/** The Constant DENSE_FIELD_NUMBER. */
		public static final int DENSE_FIELD_NUMBER = 2;
		
		/** The dense. */
		private DenseNodes dense_;

		/**
		 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
		 */
		@java.lang.Override
		public boolean hasDense() {
			return (bitField0_ & 0x00000001) == 0x00000001;
		}

		/**
		 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
		 */
		@java.lang.Override
		public DenseNodes getDense() {
			return dense_ == null ? DenseNodes.getDefaultInstance() : dense_;
		}

		/**
		 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
		 *
		 * @param value the new dense
		 */
		private void setDense(final DenseNodes value) {
			if (value == null) { throw new NullPointerException(); }
			dense_ = value;
			bitField0_ |= 0x00000001;
		}

		/**
		 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
		 *
		 * @param builderForValue the new dense
		 */
		private void setDense(final DenseNodes.Builder builderForValue) {
			dense_ = builderForValue.build();
			bitField0_ |= 0x00000001;
		}

		/**
		 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
		 *
		 * @param value the value
		 */
		private void mergeDense(final DenseNodes value) {
			if (value == null) { throw new NullPointerException(); }
			if (dense_ != null && dense_ != DenseNodes.getDefaultInstance()) {
				dense_ = DenseNodes.newBuilder(dense_).mergeFrom(value).buildPartial();
			} else {
				dense_ = value;
			}
			bitField0_ |= 0x00000001;
		}

		/**
		 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
		 */
		private void clearDense() {
			dense_ = null;
			bitField0_ = bitField0_ & ~0x00000001;
		}

		/** The Constant WAYS_FIELD_NUMBER. */
		public static final int WAYS_FIELD_NUMBER = 3;
		
		/** The ways. */
		private com.google.protobuf.Internal.ProtobufList<Way> ways_;

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 */
		@java.lang.Override
		public java.util.List<Way> getWaysList() {
			return ways_;
		}

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 *
		 * @return the ways or builder list
		 */
		public java.util.List<? extends WayOrBuilder> getWaysOrBuilderList() {
			return ways_;
		}

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 */
		@java.lang.Override
		public int getWaysCount() {
			return ways_.size();
		}

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 */
		@java.lang.Override
		public Way getWays(final int index) {
			return ways_.get(index);
		}

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 *
		 * @param index the index
		 * @return the ways or builder
		 */
		public WayOrBuilder getWaysOrBuilder(final int index) {
			return ways_.get(index);
		}

		/**
		 * Ensure ways is mutable.
		 */
		private void ensureWaysIsMutable() {
			if (!ways_.isModifiable()) {
				ways_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(ways_);
			}
		}

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setWays(final int index, final Way value) {
			if (value == null) { throw new NullPointerException(); }
			ensureWaysIsMutable();
			ways_.set(index, value);
		}

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 *
		 * @param index the index
		 * @param builderForValue the builder for value
		 */
		private void setWays(final int index, final Way.Builder builderForValue) {
			ensureWaysIsMutable();
			ways_.set(index, builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 *
		 * @param value the value
		 */
		private void addWays(final Way value) {
			if (value == null) { throw new NullPointerException(); }
			ensureWaysIsMutable();
			ways_.add(value);
		}

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void addWays(final int index, final Way value) {
			if (value == null) { throw new NullPointerException(); }
			ensureWaysIsMutable();
			ways_.add(index, value);
		}

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 *
		 * @param builderForValue the builder for value
		 */
		private void addWays(final Way.Builder builderForValue) {
			ensureWaysIsMutable();
			ways_.add(builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 *
		 * @param index the index
		 * @param builderForValue the builder for value
		 */
		private void addWays(final int index, final Way.Builder builderForValue) {
			ensureWaysIsMutable();
			ways_.add(index, builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 *
		 * @param values the values
		 */
		private void addAllWays(final java.lang.Iterable<? extends Way> values) {
			ensureWaysIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, ways_);
		}

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 */
		private void clearWays() {
			ways_ = emptyProtobufList();
		}

		/**
		 * <code>repeated .OSMPBF.Way ways = 3;</code>
		 *
		 * @param index the index
		 */
		private void removeWays(final int index) {
			ensureWaysIsMutable();
			ways_.remove(index);
		}

		/** The Constant RELATIONS_FIELD_NUMBER. */
		public static final int RELATIONS_FIELD_NUMBER = 4;
		
		/** The relations. */
		private com.google.protobuf.Internal.ProtobufList<Relation> relations_;

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 */
		@java.lang.Override
		public java.util.List<Relation> getRelationsList() {
			return relations_;
		}

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 *
		 * @return the relations or builder list
		 */
		public java.util.List<? extends RelationOrBuilder> getRelationsOrBuilderList() {
			return relations_;
		}

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 */
		@java.lang.Override
		public int getRelationsCount() {
			return relations_.size();
		}

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 */
		@java.lang.Override
		public Relation getRelations(final int index) {
			return relations_.get(index);
		}

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 *
		 * @param index the index
		 * @return the relations or builder
		 */
		public RelationOrBuilder getRelationsOrBuilder(final int index) {
			return relations_.get(index);
		}

		/**
		 * Ensure relations is mutable.
		 */
		private void ensureRelationsIsMutable() {
			if (!relations_.isModifiable()) {
				relations_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(relations_);
			}
		}

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setRelations(final int index, final Relation value) {
			if (value == null) { throw new NullPointerException(); }
			ensureRelationsIsMutable();
			relations_.set(index, value);
		}

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 *
		 * @param index the index
		 * @param builderForValue the builder for value
		 */
		private void setRelations(final int index, final Relation.Builder builderForValue) {
			ensureRelationsIsMutable();
			relations_.set(index, builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 *
		 * @param value the value
		 */
		private void addRelations(final Relation value) {
			if (value == null) { throw new NullPointerException(); }
			ensureRelationsIsMutable();
			relations_.add(value);
		}

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void addRelations(final int index, final Relation value) {
			if (value == null) { throw new NullPointerException(); }
			ensureRelationsIsMutable();
			relations_.add(index, value);
		}

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 *
		 * @param builderForValue the builder for value
		 */
		private void addRelations(final Relation.Builder builderForValue) {
			ensureRelationsIsMutable();
			relations_.add(builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 *
		 * @param index the index
		 * @param builderForValue the builder for value
		 */
		private void addRelations(final int index, final Relation.Builder builderForValue) {
			ensureRelationsIsMutable();
			relations_.add(index, builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 *
		 * @param values the values
		 */
		private void addAllRelations(final java.lang.Iterable<? extends Relation> values) {
			ensureRelationsIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, relations_);
		}

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 */
		private void clearRelations() {
			relations_ = emptyProtobufList();
		}

		/**
		 * <code>repeated .OSMPBF.Relation relations = 4;</code>
		 *
		 * @param index the index
		 */
		private void removeRelations(final int index) {
			ensureRelationsIsMutable();
			relations_.remove(index);
		}

		/** The Constant CHANGESETS_FIELD_NUMBER. */
		public static final int CHANGESETS_FIELD_NUMBER = 5;
		
		/** The changesets. */
		private com.google.protobuf.Internal.ProtobufList<ChangeSet> changesets_;

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 */
		@java.lang.Override
		public java.util.List<ChangeSet> getChangesetsList() {
			return changesets_;
		}

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 *
		 * @return the changesets or builder list
		 */
		public java.util.List<? extends ChangeSetOrBuilder> getChangesetsOrBuilderList() {
			return changesets_;
		}

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 */
		@java.lang.Override
		public int getChangesetsCount() {
			return changesets_.size();
		}

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 */
		@java.lang.Override
		public ChangeSet getChangesets(final int index) {
			return changesets_.get(index);
		}

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 *
		 * @param index the index
		 * @return the changesets or builder
		 */
		public ChangeSetOrBuilder getChangesetsOrBuilder(final int index) {
			return changesets_.get(index);
		}

		/**
		 * Ensure changesets is mutable.
		 */
		private void ensureChangesetsIsMutable() {
			if (!changesets_.isModifiable()) {
				changesets_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(changesets_);
			}
		}

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setChangesets(final int index, final ChangeSet value) {
			if (value == null) { throw new NullPointerException(); }
			ensureChangesetsIsMutable();
			changesets_.set(index, value);
		}

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 *
		 * @param index the index
		 * @param builderForValue the builder for value
		 */
		private void setChangesets(final int index, final ChangeSet.Builder builderForValue) {
			ensureChangesetsIsMutable();
			changesets_.set(index, builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 *
		 * @param value the value
		 */
		private void addChangesets(final ChangeSet value) {
			if (value == null) { throw new NullPointerException(); }
			ensureChangesetsIsMutable();
			changesets_.add(value);
		}

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void addChangesets(final int index, final ChangeSet value) {
			if (value == null) { throw new NullPointerException(); }
			ensureChangesetsIsMutable();
			changesets_.add(index, value);
		}

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 *
		 * @param builderForValue the builder for value
		 */
		private void addChangesets(final ChangeSet.Builder builderForValue) {
			ensureChangesetsIsMutable();
			changesets_.add(builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 *
		 * @param index the index
		 * @param builderForValue the builder for value
		 */
		private void addChangesets(final int index, final ChangeSet.Builder builderForValue) {
			ensureChangesetsIsMutable();
			changesets_.add(index, builderForValue.build());
		}

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 *
		 * @param values the values
		 */
		private void addAllChangesets(final java.lang.Iterable<? extends ChangeSet> values) {
			ensureChangesetsIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, changesets_);
		}

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 */
		private void clearChangesets() {
			changesets_ = emptyProtobufList();
		}

		/**
		 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
		 *
		 * @param index the index
		 */
		private void removeChangesets(final int index) {
			ensureChangesetsIsMutable();
			changesets_.remove(index);
		}

		@java.lang.Override
		public void writeTo(final com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
			for (int i = 0; i < nodes_.size(); i++) {
				output.writeMessage(1, nodes_.get(i));
			}
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				output.writeMessage(2, getDense());
			}
			for (int i = 0; i < ways_.size(); i++) {
				output.writeMessage(3, ways_.get(i));
			}
			for (int i = 0; i < relations_.size(); i++) {
				output.writeMessage(4, relations_.get(i));
			}
			for (int i = 0; i < changesets_.size(); i++) {
				output.writeMessage(5, changesets_.get(i));
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSerializedSize;
			if (size != -1) { return size; }

			size = 0;
			for (int i = 0; i < nodes_.size(); i++) {
				size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, nodes_.get(i));
			}
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getDense());
			}
			for (int i = 0; i < ways_.size(); i++) {
				size += com.google.protobuf.CodedOutputStream.computeMessageSize(3, ways_.get(i));
			}
			for (int i = 0; i < relations_.size(); i++) {
				size += com.google.protobuf.CodedOutputStream.computeMessageSize(4, relations_.get(i));
			}
			for (int i = 0; i < changesets_.size(); i++) {
				size += com.google.protobuf.CodedOutputStream.computeMessageSize(5, changesets_.get(i));
			}
			size += unknownFields.getSerializedSize();
			memoizedSerializedSize = size;
			return size;
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the primitive group
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static PrimitiveGroup parseFrom(final java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the primitive group
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static PrimitiveGroup parseFrom(final java.nio.ByteBuffer data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the primitive group
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static PrimitiveGroup parseFrom(final com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the primitive group
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static PrimitiveGroup parseFrom(final com.google.protobuf.ByteString data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the primitive group
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static PrimitiveGroup parseFrom(final byte[] data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the primitive group
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static PrimitiveGroup parseFrom(final byte[] data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the primitive group
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static PrimitiveGroup parseFrom(final java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the primitive group
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static PrimitiveGroup parseFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @return the primitive group
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static PrimitiveGroup parseDelimitedFrom(final java.io.InputStream input) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the primitive group
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static PrimitiveGroup parseDelimitedFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the primitive group
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static PrimitiveGroup parseFrom(final com.google.protobuf.CodedInputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the primitive group
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static PrimitiveGroup parseFrom(final com.google.protobuf.CodedInputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * New builder.
		 *
		 * @return the builder
		 */
		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.newBuilder();
		}

		/**
		 * New builder.
		 *
		 * @param prototype the prototype
		 * @return the builder
		 */
		public static Builder newBuilder(final PrimitiveGroup prototype) {
			return DEFAULT_INSTANCE.newBuilder(prototype);
		}

		/**
		 * <pre>
		 * Group of OSMPrimitives. All primitives in a group must be the same type.
		 * </pre>
		 *
		 * Protobuf type {@code OSMPBF.PrimitiveGroup}
		 */
		public static final class Builder
				extends com.google.protobuf.GeneratedMessageLite.Builder<PrimitiveGroup, Builder> implements
				// @@protoc_insertion_point(builder_implements:OSMPBF.PrimitiveGroup)
				PrimitiveGroupOrBuilder {
			
			/**
			 * Instantiates a new builder.
			 */
			// Construct using PrimitiveGroup.newBuilder()
			private Builder() {
				super(DEFAULT_INSTANCE);
			}

			/**
			 * <code>repeated .OSMPBF.Node nodes = 1;</code>
			 */
			@java.lang.Override
			public java.util.List<Node> getNodesList() {
				return java.util.Collections.unmodifiableList(instance.getNodesList());
			}

			/**
			 * <code>repeated .OSMPBF.Node nodes = 1;</code>
			 */
			@java.lang.Override
			public int getNodesCount() {
				return instance.getNodesCount();
			}

			/**
			 * <code>repeated .OSMPBF.Node nodes = 1;</code>
			 */
			@java.lang.Override
			public Node getNodes(final int index) {
				return instance.getNodes(index);
			}

			/**
			 * <code>repeated .OSMPBF.Node nodes = 1;</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setNodes(final int index, final Node value) {
				copyOnWrite();
				instance.setNodes(index, value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Node nodes = 1;</code>
			 *
			 * @param index the index
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder setNodes(final int index, final Node.Builder builderForValue) {
				copyOnWrite();
				instance.setNodes(index, builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Node nodes = 1;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addNodes(final Node value) {
				copyOnWrite();
				instance.addNodes(value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Node nodes = 1;</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder addNodes(final int index, final Node value) {
				copyOnWrite();
				instance.addNodes(index, value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Node nodes = 1;</code>
			 *
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder addNodes(final Node.Builder builderForValue) {
				copyOnWrite();
				instance.addNodes(builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Node nodes = 1;</code>
			 *
			 * @param index the index
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder addNodes(final int index, final Node.Builder builderForValue) {
				copyOnWrite();
				instance.addNodes(index, builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Node nodes = 1;</code>
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllNodes(final java.lang.Iterable<? extends Node> values) {
				copyOnWrite();
				instance.addAllNodes(values);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Node nodes = 1;</code>
			 *
			 * @return the builder
			 */
			public Builder clearNodes() {
				copyOnWrite();
				instance.clearNodes();
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Node nodes = 1;</code>
			 *
			 * @param index the index
			 * @return the builder
			 */
			public Builder removeNodes(final int index) {
				copyOnWrite();
				instance.removeNodes(index);
				return this;
			}

			/**
			 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
			 */
			@java.lang.Override
			public boolean hasDense() {
				return instance.hasDense();
			}

			/**
			 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
			 */
			@java.lang.Override
			public DenseNodes getDense() {
				return instance.getDense();
			}

			/**
			 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setDense(final DenseNodes value) {
				copyOnWrite();
				instance.setDense(value);
				return this;
			}

			/**
			 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
			 *
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder setDense(final DenseNodes.Builder builderForValue) {
				copyOnWrite();
				instance.setDense(builderForValue);
				return this;
			}

			/**
			 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder mergeDense(final DenseNodes value) {
				copyOnWrite();
				instance.mergeDense(value);
				return this;
			}

			/**
			 * <code>optional .OSMPBF.DenseNodes dense = 2;</code>
			 *
			 * @return the builder
			 */
			public Builder clearDense() {
				copyOnWrite();
				instance.clearDense();
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Way ways = 3;</code>
			 */
			@java.lang.Override
			public java.util.List<Way> getWaysList() {
				return java.util.Collections.unmodifiableList(instance.getWaysList());
			}

			/**
			 * <code>repeated .OSMPBF.Way ways = 3;</code>
			 */
			@java.lang.Override
			public int getWaysCount() {
				return instance.getWaysCount();
			}

			/**
			 * <code>repeated .OSMPBF.Way ways = 3;</code>
			 */
			@java.lang.Override
			public Way getWays(final int index) {
				return instance.getWays(index);
			}

			/**
			 * <code>repeated .OSMPBF.Way ways = 3;</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setWays(final int index, final Way value) {
				copyOnWrite();
				instance.setWays(index, value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Way ways = 3;</code>
			 *
			 * @param index the index
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder setWays(final int index, final Way.Builder builderForValue) {
				copyOnWrite();
				instance.setWays(index, builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Way ways = 3;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addWays(final Way value) {
				copyOnWrite();
				instance.addWays(value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Way ways = 3;</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder addWays(final int index, final Way value) {
				copyOnWrite();
				instance.addWays(index, value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Way ways = 3;</code>
			 *
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder addWays(final Way.Builder builderForValue) {
				copyOnWrite();
				instance.addWays(builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Way ways = 3;</code>
			 *
			 * @param index the index
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder addWays(final int index, final Way.Builder builderForValue) {
				copyOnWrite();
				instance.addWays(index, builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Way ways = 3;</code>
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllWays(final java.lang.Iterable<? extends Way> values) {
				copyOnWrite();
				instance.addAllWays(values);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Way ways = 3;</code>
			 *
			 * @return the builder
			 */
			public Builder clearWays() {
				copyOnWrite();
				instance.clearWays();
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Way ways = 3;</code>
			 *
			 * @param index the index
			 * @return the builder
			 */
			public Builder removeWays(final int index) {
				copyOnWrite();
				instance.removeWays(index);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Relation relations = 4;</code>
			 */
			@java.lang.Override
			public java.util.List<Relation> getRelationsList() {
				return java.util.Collections.unmodifiableList(instance.getRelationsList());
			}

			/**
			 * <code>repeated .OSMPBF.Relation relations = 4;</code>
			 */
			@java.lang.Override
			public int getRelationsCount() {
				return instance.getRelationsCount();
			}

			/**
			 * <code>repeated .OSMPBF.Relation relations = 4;</code>
			 */
			@java.lang.Override
			public Relation getRelations(final int index) {
				return instance.getRelations(index);
			}

			/**
			 * <code>repeated .OSMPBF.Relation relations = 4;</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setRelations(final int index, final Relation value) {
				copyOnWrite();
				instance.setRelations(index, value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Relation relations = 4;</code>
			 *
			 * @param index the index
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder setRelations(final int index, final Relation.Builder builderForValue) {
				copyOnWrite();
				instance.setRelations(index, builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Relation relations = 4;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addRelations(final Relation value) {
				copyOnWrite();
				instance.addRelations(value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Relation relations = 4;</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder addRelations(final int index, final Relation value) {
				copyOnWrite();
				instance.addRelations(index, value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Relation relations = 4;</code>
			 *
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder addRelations(final Relation.Builder builderForValue) {
				copyOnWrite();
				instance.addRelations(builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Relation relations = 4;</code>
			 *
			 * @param index the index
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder addRelations(final int index, final Relation.Builder builderForValue) {
				copyOnWrite();
				instance.addRelations(index, builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Relation relations = 4;</code>
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllRelations(final java.lang.Iterable<? extends Relation> values) {
				copyOnWrite();
				instance.addAllRelations(values);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Relation relations = 4;</code>
			 *
			 * @return the builder
			 */
			public Builder clearRelations() {
				copyOnWrite();
				instance.clearRelations();
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Relation relations = 4;</code>
			 *
			 * @param index the index
			 * @return the builder
			 */
			public Builder removeRelations(final int index) {
				copyOnWrite();
				instance.removeRelations(index);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
			 */
			@java.lang.Override
			public java.util.List<ChangeSet> getChangesetsList() {
				return java.util.Collections.unmodifiableList(instance.getChangesetsList());
			}

			/**
			 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
			 */
			@java.lang.Override
			public int getChangesetsCount() {
				return instance.getChangesetsCount();
			}

			/**
			 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
			 */
			@java.lang.Override
			public ChangeSet getChangesets(final int index) {
				return instance.getChangesets(index);
			}

			/**
			 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setChangesets(final int index, final ChangeSet value) {
				copyOnWrite();
				instance.setChangesets(index, value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
			 *
			 * @param index the index
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder setChangesets(final int index, final ChangeSet.Builder builderForValue) {
				copyOnWrite();
				instance.setChangesets(index, builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addChangesets(final ChangeSet value) {
				copyOnWrite();
				instance.addChangesets(value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder addChangesets(final int index, final ChangeSet value) {
				copyOnWrite();
				instance.addChangesets(index, value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
			 *
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder addChangesets(final ChangeSet.Builder builderForValue) {
				copyOnWrite();
				instance.addChangesets(builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
			 *
			 * @param index the index
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder addChangesets(final int index, final ChangeSet.Builder builderForValue) {
				copyOnWrite();
				instance.addChangesets(index, builderForValue);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllChangesets(final java.lang.Iterable<? extends ChangeSet> values) {
				copyOnWrite();
				instance.addAllChangesets(values);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
			 *
			 * @return the builder
			 */
			public Builder clearChangesets() {
				copyOnWrite();
				instance.clearChangesets();
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.ChangeSet changesets = 5;</code>
			 *
			 * @param index the index
			 * @return the builder
			 */
			public Builder removeChangesets(final int index) {
				copyOnWrite();
				instance.removeChangesets(index);
				return this;
			}

			// @@protoc_insertion_point(builder_scope:OSMPBF.PrimitiveGroup)
		}

		/** The memoized is initialized. */
		private byte memoizedIsInitialized = 2;

		@java.lang.Override
		@java.lang.SuppressWarnings ({ "unchecked", "fallthrough" })
		protected java.lang.Object dynamicMethod(final com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
				final java.lang.Object arg0, final java.lang.Object arg1) {
			switch (method) {
				case NEW_MUTABLE_INSTANCE: {
					return new PrimitiveGroup();
				}
				case NEW_BUILDER: {
					return new Builder();
				}
				case IS_INITIALIZED: {
					final byte isInitialized = memoizedIsInitialized;
					if (isInitialized == 1) { return DEFAULT_INSTANCE; }
					if (isInitialized == 0) { return null; }

					for (int i = 0; i < getNodesCount(); i++) {
						if (!getNodes(i).isInitialized()) { return null; }
					}
					for (int i = 0; i < getWaysCount(); i++) {
						if (!getWays(i).isInitialized()) { return null; }
					}
					for (int i = 0; i < getRelationsCount(); i++) {
						if (!getRelations(i).isInitialized()) { return null; }
					}
					for (int i = 0; i < getChangesetsCount(); i++) {
						if (!getChangesets(i).isInitialized()) { return null; }
					}
					return DEFAULT_INSTANCE;

				}
				case MAKE_IMMUTABLE: {
					nodes_.makeImmutable();
					ways_.makeImmutable();
					relations_.makeImmutable();
					changesets_.makeImmutable();
					return null;
				}
				case VISIT: {
					final Visitor visitor = (Visitor) arg0;
					final PrimitiveGroup other = (PrimitiveGroup) arg1;
					nodes_ = visitor.visitList(nodes_, other.nodes_);
					dense_ = visitor.visitMessage(dense_, other.dense_);
					ways_ = visitor.visitList(ways_, other.ways_);
					relations_ = visitor.visitList(relations_, other.relations_);
					changesets_ = visitor.visitList(changesets_, other.changesets_);
					if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
						bitField0_ |= other.bitField0_;
					}
					return this;
				}
				case MERGE_FROM_STREAM: {
					final com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
					final com.google.protobuf.ExtensionRegistryLite extensionRegistry =
							(com.google.protobuf.ExtensionRegistryLite) arg1;
					if (extensionRegistry == null) { throw new java.lang.NullPointerException(); }
					try {
						boolean done = false;
						while (!done) {
							final int tag = input.readTag();
							switch (tag) {
								case 0:
									done = true;
									break;
								case 10: {
									if (!nodes_.isModifiable()) {
										nodes_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(nodes_);
									}
									nodes_.add(input.readMessage(Node.parser(), extensionRegistry));
									break;
								}
								case 18: {
									DenseNodes.Builder subBuilder = null;
									if ((bitField0_ & 0x00000001) == 0x00000001) {
										subBuilder = dense_.toBuilder();
									}
									dense_ = input.readMessage(DenseNodes.parser(), extensionRegistry);
									if (subBuilder != null) {
										subBuilder.mergeFrom(dense_);
										dense_ = subBuilder.buildPartial();
									}
									bitField0_ |= 0x00000001;
									break;
								}
								case 26: {
									if (!ways_.isModifiable()) {
										ways_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(ways_);
									}
									ways_.add(input.readMessage(Way.parser(), extensionRegistry));
									break;
								}
								case 34: {
									if (!relations_.isModifiable()) {
										relations_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(relations_);
									}
									relations_.add(input.readMessage(Relation.parser(), extensionRegistry));
									break;
								}
								case 42: {
									if (!changesets_.isModifiable()) {
										changesets_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(changesets_);
									}
									changesets_.add(input.readMessage(ChangeSet.parser(), extensionRegistry));
									break;
								}
								default: {
									if (!parseUnknownField(tag, input)) {
										done = true;
									}
									break;
								}
							}
						}
					} catch (final com.google.protobuf.InvalidProtocolBufferException e) {
						throw new RuntimeException(e.setUnfinishedMessage(this));
					} catch (final java.io.IOException e) {
						throw new RuntimeException(
								new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
										.setUnfinishedMessage(this));
					} finally {}
				}
				// fall through
				case GET_DEFAULT_INSTANCE: {
					return DEFAULT_INSTANCE;
				}
				case GET_PARSER: {
					com.google.protobuf.Parser<PrimitiveGroup> parser = PARSER;
					if (parser == null) {
						synchronized (PrimitiveGroup.class) {
							parser = PARSER;
							if (parser == null) {
								parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
								PARSER = parser;
							}
						}
					}
					return parser;
				}
				case GET_MEMOIZED_IS_INITIALIZED: {
					return memoizedIsInitialized;
				}
				case SET_MEMOIZED_IS_INITIALIZED: {
					memoizedIsInitialized = (byte) (arg0 == null ? 0 : 1);
					return null;
				}
			}
			throw new UnsupportedOperationException();
		}

		/** The Constant DEFAULT_INSTANCE. */
		// @@protoc_insertion_point(class_scope:OSMPBF.PrimitiveGroup)
		private static final PrimitiveGroup DEFAULT_INSTANCE;
		static {
			// New instances are implicitly immutable so no need to make
			// immutable.
			DEFAULT_INSTANCE = new PrimitiveGroup();
		}

		/**
		 * Gets the default instance.
		 *
		 * @return the default instance
		 */
		public static PrimitiveGroup getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		/** The parser. */
		private static volatile com.google.protobuf.Parser<PrimitiveGroup> PARSER;

		/**
		 * Parser.
		 *
		 * @return the com.google.protobuf. parser
		 */
		public static com.google.protobuf.Parser<PrimitiveGroup> parser() {
			return DEFAULT_INSTANCE.getParserForType();
		}
	}

	/**
	 * The Interface StringTableOrBuilder.
	 */
	public interface StringTableOrBuilder extends
			// @@protoc_insertion_point(interface_extends:OSMPBF.StringTable)
			com.google.protobuf.MessageLiteOrBuilder {

		/**
		 * <code>repeated bytes s = 1;</code>.
		 *
		 * @return the s list
		 */
		java.util.List<com.google.protobuf.ByteString> getSList();

		/**
		 * <code>repeated bytes s = 1;</code>.
		 *
		 * @return the s count
		 */
		int getSCount();

		/**
		 * <code>repeated bytes s = 1;</code>.
		 *
		 * @param index the index
		 * @return the s
		 */
		com.google.protobuf.ByteString getS(int index);
	}

	/**
	 * <pre>
	 ** String table, contains the common strings in each block.
	 *Note that we reserve index '0' as a delimiter, so the entry at that
	 *index in the table is ALWAYS blank and unused.
	 * </pre>
	 *
	 * Protobuf type {@code OSMPBF.StringTable}
	 */
	public static final class StringTable
			extends com.google.protobuf.GeneratedMessageLite<StringTable, StringTable.Builder> implements
			// @@protoc_insertion_point(message_implements:OSMPBF.StringTable)
			StringTableOrBuilder {
		
		/**
		 * Instantiates a new string table.
		 */
		private StringTable() {
			s_ = emptyProtobufList();
		}

		/** The Constant S_FIELD_NUMBER. */
		public static final int S_FIELD_NUMBER = 1;
		
		/** The s. */
		private com.google.protobuf.Internal.ProtobufList<com.google.protobuf.ByteString> s_;

		/**
		 * <code>repeated bytes s = 1;</code>
		 */
		@java.lang.Override
		public java.util.List<com.google.protobuf.ByteString> getSList() {
			return s_;
		}

		/**
		 * <code>repeated bytes s = 1;</code>
		 */
		@java.lang.Override
		public int getSCount() {
			return s_.size();
		}

		/**
		 * <code>repeated bytes s = 1;</code>
		 */
		@java.lang.Override
		public com.google.protobuf.ByteString getS(final int index) {
			return s_.get(index);
		}

		/**
		 * Ensure S is mutable.
		 */
		private void ensureSIsMutable() {
			if (!s_.isModifiable()) {
				s_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(s_);
			}
		}

		/**
		 * <code>repeated bytes s = 1;</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setS(final int index, final com.google.protobuf.ByteString value) {
			if (value == null) { throw new NullPointerException(); }
			ensureSIsMutable();
			s_.set(index, value);
		}

		/**
		 * <code>repeated bytes s = 1;</code>.
		 *
		 * @param value the value
		 */
		private void addS(final com.google.protobuf.ByteString value) {
			if (value == null) { throw new NullPointerException(); }
			ensureSIsMutable();
			s_.add(value);
		}

		/**
		 * <code>repeated bytes s = 1;</code>.
		 *
		 * @param values the values
		 */
		private void addAllS(final java.lang.Iterable<? extends com.google.protobuf.ByteString> values) {
			ensureSIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, s_);
		}

		/**
		 * <code>repeated bytes s = 1;</code>.
		 */
		private void clearS() {
			s_ = emptyProtobufList();
		}

		@java.lang.Override
		public void writeTo(final com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
			for (int i = 0; i < s_.size(); i++) {
				output.writeBytes(1, s_.get(i));
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSerializedSize;
			if (size != -1) { return size; }

			size = 0;
			{
				int dataSize = 0;
				for (int i = 0; i < s_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeBytesSizeNoTag(s_.get(i));
				}
				size += dataSize;
				size += 1 * getSList().size();
			}
			size += unknownFields.getSerializedSize();
			memoizedSerializedSize = size;
			return size;
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the string table
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static StringTable parseFrom(final java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the string table
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static StringTable parseFrom(final java.nio.ByteBuffer data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the string table
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static StringTable parseFrom(final com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the string table
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static StringTable parseFrom(final com.google.protobuf.ByteString data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the string table
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static StringTable parseFrom(final byte[] data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the string table
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static StringTable parseFrom(final byte[] data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the string table
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static StringTable parseFrom(final java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the string table
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static StringTable parseFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @return the string table
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static StringTable parseDelimitedFrom(final java.io.InputStream input) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the string table
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static StringTable parseDelimitedFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the string table
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static StringTable parseFrom(final com.google.protobuf.CodedInputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the string table
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static StringTable parseFrom(final com.google.protobuf.CodedInputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * New builder.
		 *
		 * @return the builder
		 */
		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.newBuilder();
		}

		/**
		 * New builder.
		 *
		 * @param prototype the prototype
		 * @return the builder
		 */
		public static Builder newBuilder(final StringTable prototype) {
			return DEFAULT_INSTANCE.newBuilder(prototype);
		}

		/**
		 * <pre>
		 ** String table, contains the common strings in each block.
		 *Note that we reserve index '0' as a delimiter, so the entry at that
		 *index in the table is ALWAYS blank and unused.
		 * </pre>
		 *
		 * Protobuf type {@code OSMPBF.StringTable}
		 */
		public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<StringTable, Builder>
				implements
				// @@protoc_insertion_point(builder_implements:OSMPBF.StringTable)
				StringTableOrBuilder {
			
			/**
			 * Instantiates a new builder.
			 */
			// Construct using StringTable.newBuilder()
			private Builder() {
				super(DEFAULT_INSTANCE);
			}

			/**
			 * <code>repeated bytes s = 1;</code>
			 */
			@java.lang.Override
			public java.util.List<com.google.protobuf.ByteString> getSList() {
				return java.util.Collections.unmodifiableList(instance.getSList());
			}

			/**
			 * <code>repeated bytes s = 1;</code>
			 */
			@java.lang.Override
			public int getSCount() {
				return instance.getSCount();
			}

			/**
			 * <code>repeated bytes s = 1;</code>
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getS(final int index) {
				return instance.getS(index);
			}

			/**
			 * <code>repeated bytes s = 1;</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setS(final int index, final com.google.protobuf.ByteString value) {
				copyOnWrite();
				instance.setS(index, value);
				return this;
			}

			/**
			 * <code>repeated bytes s = 1;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addS(final com.google.protobuf.ByteString value) {
				copyOnWrite();
				instance.addS(value);
				return this;
			}

			/**
			 * <code>repeated bytes s = 1;</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllS(final java.lang.Iterable<? extends com.google.protobuf.ByteString> values) {
				copyOnWrite();
				instance.addAllS(values);
				return this;
			}

			/**
			 * <code>repeated bytes s = 1;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearS() {
				copyOnWrite();
				instance.clearS();
				return this;
			}

			// @@protoc_insertion_point(builder_scope:OSMPBF.StringTable)
		}

		@java.lang.Override
		@java.lang.SuppressWarnings ({ "unchecked", "fallthrough" })
		protected java.lang.Object dynamicMethod(final com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
				final java.lang.Object arg0, final java.lang.Object arg1) {
			switch (method) {
				case NEW_MUTABLE_INSTANCE: {
					return new StringTable();
				}
				case NEW_BUILDER: {
					return new Builder();
				}
				case IS_INITIALIZED: {
					return DEFAULT_INSTANCE;
				}
				case MAKE_IMMUTABLE: {
					s_.makeImmutable();
					return null;
				}
				case VISIT: {
					final Visitor visitor = (Visitor) arg0;
					final StringTable other = (StringTable) arg1;
					s_ = visitor.visitList(s_, other.s_);
					if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {}
					return this;
				}
				case MERGE_FROM_STREAM: {
					final com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
					final com.google.protobuf.ExtensionRegistryLite extensionRegistry =
							(com.google.protobuf.ExtensionRegistryLite) arg1;
					if (extensionRegistry == null) { throw new java.lang.NullPointerException(); }
					try {
						boolean done = false;
						while (!done) {
							final int tag = input.readTag();
							switch (tag) {
								case 0:
									done = true;
									break;
								case 10: {
									if (!s_.isModifiable()) {
										s_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(s_);
									}
									s_.add(input.readBytes());
									break;
								}
								default: {
									if (!parseUnknownField(tag, input)) {
										done = true;
									}
									break;
								}
							}
						}
					} catch (final com.google.protobuf.InvalidProtocolBufferException e) {
						throw new RuntimeException(e.setUnfinishedMessage(this));
					} catch (final java.io.IOException e) {
						throw new RuntimeException(
								new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
										.setUnfinishedMessage(this));
					} finally {}
				}
				// fall through
				case GET_DEFAULT_INSTANCE: {
					return DEFAULT_INSTANCE;
				}
				case GET_PARSER: {
					com.google.protobuf.Parser<StringTable> parser = PARSER;
					if (parser == null) {
						synchronized (StringTable.class) {
							parser = PARSER;
							if (parser == null) {
								parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
								PARSER = parser;
							}
						}
					}
					return parser;
				}
				case GET_MEMOIZED_IS_INITIALIZED: {
					return (byte) 1;
				}
				case SET_MEMOIZED_IS_INITIALIZED: {
					return null;
				}
			}
			throw new UnsupportedOperationException();
		}

		/** The Constant DEFAULT_INSTANCE. */
		// @@protoc_insertion_point(class_scope:OSMPBF.StringTable)
		private static final StringTable DEFAULT_INSTANCE;
		static {
			// New instances are implicitly immutable so no need to make
			// immutable.
			DEFAULT_INSTANCE = new StringTable();
		}

		/**
		 * Gets the default instance.
		 *
		 * @return the default instance
		 */
		public static StringTable getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		/** The parser. */
		private static volatile com.google.protobuf.Parser<StringTable> PARSER;

		/**
		 * Parser.
		 *
		 * @return the com.google.protobuf. parser
		 */
		public static com.google.protobuf.Parser<StringTable> parser() {
			return DEFAULT_INSTANCE.getParserForType();
		}
	}

	/**
	 * The Interface InfoOrBuilder.
	 */
	public interface InfoOrBuilder extends
			// @@protoc_insertion_point(interface_extends:OSMPBF.Info)
			com.google.protobuf.MessageLiteOrBuilder {

		/**
		 * <code>optional int32 version = 1 [default = -1];</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasVersion();

		/**
		 * <code>optional int32 version = 1 [default = -1];</code>.
		 *
		 * @return the version
		 */
		int getVersion();

		/**
		 * <code>optional int64 timestamp = 2;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasTimestamp();

		/**
		 * <code>optional int64 timestamp = 2;</code>.
		 *
		 * @return the timestamp
		 */
		long getTimestamp();

		/**
		 * <code>optional int64 changeset = 3;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasChangeset();

		/**
		 * <code>optional int64 changeset = 3;</code>.
		 *
		 * @return the changeset
		 */
		long getChangeset();

		/**
		 * <code>optional int32 uid = 4;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasUid();

		/**
		 * <code>optional int32 uid = 4;</code>.
		 *
		 * @return the uid
		 */
		int getUid();

		/**
		 * <pre>
		 * String IDs
		 * </pre>
		 * 
		 * <code>optional uint32 user_sid = 5;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasUserSid();

		/**
		 * <pre>
		 * String IDs
		 * </pre>
		 * 
		 * <code>optional uint32 user_sid = 5;</code>.
		 *
		 * @return the user sid
		 */
		int getUserSid();

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 * 
		 * <code>optional bool visible = 6;</code>
		 *
		 * @return true, if successful
		 */
		boolean hasVisible();

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 * 
		 * <code>optional bool visible = 6;</code>
		 *
		 * @return the visible
		 */
		boolean getVisible();
	}

	/**
	 * <pre>
	 * Optional metadata that may be included into each primitive.
	 * </pre>
	 *
	 * Protobuf type {@code OSMPBF.Info}
	 */
	public static final class Info extends com.google.protobuf.GeneratedMessageLite<Info, Info.Builder> implements
			// @@protoc_insertion_point(message_implements:OSMPBF.Info)
			InfoOrBuilder {
		
		/**
		 * Instantiates a new info.
		 */
		private Info() {
			version_ = -1;
		}

		/** The bit field 0. */
		private int bitField0_;
		
		/** The Constant VERSION_FIELD_NUMBER. */
		public static final int VERSION_FIELD_NUMBER = 1;
		
		/** The version. */
		private int version_;

		/**
		 * <code>optional int32 version = 1 [default = -1];</code>
		 */
		@java.lang.Override
		public boolean hasVersion() {
			return (bitField0_ & 0x00000001) == 0x00000001;
		}

		/**
		 * <code>optional int32 version = 1 [default = -1];</code>
		 */
		@java.lang.Override
		public int getVersion() {
			return version_;
		}

		/**
		 * <code>optional int32 version = 1 [default = -1];</code>.
		 *
		 * @param value the new version
		 */
		private void setVersion(final int value) {
			bitField0_ |= 0x00000001;
			version_ = value;
		}

		/**
		 * <code>optional int32 version = 1 [default = -1];</code>.
		 */
		private void clearVersion() {
			bitField0_ = bitField0_ & ~0x00000001;
			version_ = -1;
		}

		/** The Constant TIMESTAMP_FIELD_NUMBER. */
		public static final int TIMESTAMP_FIELD_NUMBER = 2;
		
		/** The timestamp. */
		private long timestamp_;

		/**
		 * <code>optional int64 timestamp = 2;</code>
		 */
		@java.lang.Override
		public boolean hasTimestamp() {
			return (bitField0_ & 0x00000002) == 0x00000002;
		}

		/**
		 * <code>optional int64 timestamp = 2;</code>
		 */
		@java.lang.Override
		public long getTimestamp() {
			return timestamp_;
		}

		/**
		 * <code>optional int64 timestamp = 2;</code>.
		 *
		 * @param value the new timestamp
		 */
		private void setTimestamp(final long value) {
			bitField0_ |= 0x00000002;
			timestamp_ = value;
		}

		/**
		 * <code>optional int64 timestamp = 2;</code>.
		 */
		private void clearTimestamp() {
			bitField0_ = bitField0_ & ~0x00000002;
			timestamp_ = 0L;
		}

		/** The Constant CHANGESET_FIELD_NUMBER. */
		public static final int CHANGESET_FIELD_NUMBER = 3;
		
		/** The changeset. */
		private long changeset_;

		/**
		 * <code>optional int64 changeset = 3;</code>
		 */
		@java.lang.Override
		public boolean hasChangeset() {
			return (bitField0_ & 0x00000004) == 0x00000004;
		}

		/**
		 * <code>optional int64 changeset = 3;</code>
		 */
		@java.lang.Override
		public long getChangeset() {
			return changeset_;
		}

		/**
		 * <code>optional int64 changeset = 3;</code>.
		 *
		 * @param value the new changeset
		 */
		private void setChangeset(final long value) {
			bitField0_ |= 0x00000004;
			changeset_ = value;
		}

		/**
		 * <code>optional int64 changeset = 3;</code>.
		 */
		private void clearChangeset() {
			bitField0_ = bitField0_ & ~0x00000004;
			changeset_ = 0L;
		}

		/** The Constant UID_FIELD_NUMBER. */
		public static final int UID_FIELD_NUMBER = 4;
		
		/** The uid. */
		private int uid_;

		/**
		 * <code>optional int32 uid = 4;</code>
		 */
		@java.lang.Override
		public boolean hasUid() {
			return (bitField0_ & 0x00000008) == 0x00000008;
		}

		/**
		 * <code>optional int32 uid = 4;</code>
		 */
		@java.lang.Override
		public int getUid() {
			return uid_;
		}

		/**
		 * <code>optional int32 uid = 4;</code>.
		 *
		 * @param value the new uid
		 */
		private void setUid(final int value) {
			bitField0_ |= 0x00000008;
			uid_ = value;
		}

		/**
		 * <code>optional int32 uid = 4;</code>.
		 */
		private void clearUid() {
			bitField0_ = bitField0_ & ~0x00000008;
			uid_ = 0;
		}

		/** The Constant USER_SID_FIELD_NUMBER. */
		public static final int USER_SID_FIELD_NUMBER = 5;
		
		/** The user sid. */
		private int userSid_;

		/**
		 * <pre>
		 * String IDs
		 * </pre>
		 *
		 * <code>optional uint32 user_sid = 5;</code>
		 */
		@java.lang.Override
		public boolean hasUserSid() {
			return (bitField0_ & 0x00000010) == 0x00000010;
		}

		/**
		 * <pre>
		 * String IDs
		 * </pre>
		 *
		 * <code>optional uint32 user_sid = 5;</code>
		 */
		@java.lang.Override
		public int getUserSid() {
			return userSid_;
		}

		/**
		 * <pre>
		 * String IDs
		 * </pre>
		 * 
		 * <code>optional uint32 user_sid = 5;</code>.
		 *
		 * @param value the new user sid
		 */
		private void setUserSid(final int value) {
			bitField0_ |= 0x00000010;
			userSid_ = value;
		}

		/**
		 * <pre>
		 * String IDs
		 * </pre>
		 * 
		 * <code>optional uint32 user_sid = 5;</code>.
		 */
		private void clearUserSid() {
			bitField0_ = bitField0_ & ~0x00000010;
			userSid_ = 0;
		}

		/** The Constant VISIBLE_FIELD_NUMBER. */
		public static final int VISIBLE_FIELD_NUMBER = 6;
		
		/** The visible. */
		private boolean visible_;

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 *
		 * <code>optional bool visible = 6;</code>
		 */
		@java.lang.Override
		public boolean hasVisible() {
			return (bitField0_ & 0x00000020) == 0x00000020;
		}

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 *
		 * <code>optional bool visible = 6;</code>
		 */
		@java.lang.Override
		public boolean getVisible() {
			return visible_;
		}

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 * 
		 * <code>optional bool visible = 6;</code>
		 *
		 * @param value the new visible
		 */
		private void setVisible(final boolean value) {
			bitField0_ |= 0x00000020;
			visible_ = value;
		}

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 *
		 * <code>optional bool visible = 6;</code>
		 */
		private void clearVisible() {
			bitField0_ = bitField0_ & ~0x00000020;
			visible_ = false;
		}

		@java.lang.Override
		public void writeTo(final com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				output.writeInt32(1, version_);
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				output.writeInt64(2, timestamp_);
			}
			if ((bitField0_ & 0x00000004) == 0x00000004) {
				output.writeInt64(3, changeset_);
			}
			if ((bitField0_ & 0x00000008) == 0x00000008) {
				output.writeInt32(4, uid_);
			}
			if ((bitField0_ & 0x00000010) == 0x00000010) {
				output.writeUInt32(5, userSid_);
			}
			if ((bitField0_ & 0x00000020) == 0x00000020) {
				output.writeBool(6, visible_);
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSerializedSize;
			if (size != -1) { return size; }

			size = 0;
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				size += com.google.protobuf.CodedOutputStream.computeInt32Size(1, version_);
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, timestamp_);
			}
			if ((bitField0_ & 0x00000004) == 0x00000004) {
				size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, changeset_);
			}
			if ((bitField0_ & 0x00000008) == 0x00000008) {
				size += com.google.protobuf.CodedOutputStream.computeInt32Size(4, uid_);
			}
			if ((bitField0_ & 0x00000010) == 0x00000010) {
				size += com.google.protobuf.CodedOutputStream.computeUInt32Size(5, userSid_);
			}
			if ((bitField0_ & 0x00000020) == 0x00000020) {
				size += com.google.protobuf.CodedOutputStream.computeBoolSize(6, visible_);
			}
			size += unknownFields.getSerializedSize();
			memoizedSerializedSize = size;
			return size;
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the info
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Info parseFrom(final java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the info
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Info parseFrom(final java.nio.ByteBuffer data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the info
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Info parseFrom(final com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the info
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Info parseFrom(final com.google.protobuf.ByteString data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the info
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Info parseFrom(final byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the info
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Info parseFrom(final byte[] data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the info
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Info parseFrom(final java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the info
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Info parseFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @return the info
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Info parseDelimitedFrom(final java.io.InputStream input) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the info
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Info parseDelimitedFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the info
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Info parseFrom(final com.google.protobuf.CodedInputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the info
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Info parseFrom(final com.google.protobuf.CodedInputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * New builder.
		 *
		 * @return the builder
		 */
		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.newBuilder();
		}

		/**
		 * New builder.
		 *
		 * @param prototype the prototype
		 * @return the builder
		 */
		public static Builder newBuilder(final Info prototype) {
			return DEFAULT_INSTANCE.newBuilder(prototype);
		}

		/**
		 * <pre>
		 * Optional metadata that may be included into each primitive.
		 * </pre>
		 *
		 * Protobuf type {@code OSMPBF.Info}
		 */
		public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<Info, Builder>
				implements
				// @@protoc_insertion_point(builder_implements:OSMPBF.Info)
				InfoOrBuilder {
			
			/**
			 * Instantiates a new builder.
			 */
			// Construct using Info.newBuilder()
			private Builder() {
				super(DEFAULT_INSTANCE);
			}

			/**
			 * <code>optional int32 version = 1 [default = -1];</code>
			 */
			@java.lang.Override
			public boolean hasVersion() {
				return instance.hasVersion();
			}

			/**
			 * <code>optional int32 version = 1 [default = -1];</code>
			 */
			@java.lang.Override
			public int getVersion() {
				return instance.getVersion();
			}

			/**
			 * <code>optional int32 version = 1 [default = -1];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setVersion(final int value) {
				copyOnWrite();
				instance.setVersion(value);
				return this;
			}

			/**
			 * <code>optional int32 version = 1 [default = -1];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearVersion() {
				copyOnWrite();
				instance.clearVersion();
				return this;
			}

			/**
			 * <code>optional int64 timestamp = 2;</code>
			 */
			@java.lang.Override
			public boolean hasTimestamp() {
				return instance.hasTimestamp();
			}

			/**
			 * <code>optional int64 timestamp = 2;</code>
			 */
			@java.lang.Override
			public long getTimestamp() {
				return instance.getTimestamp();
			}

			/**
			 * <code>optional int64 timestamp = 2;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setTimestamp(final long value) {
				copyOnWrite();
				instance.setTimestamp(value);
				return this;
			}

			/**
			 * <code>optional int64 timestamp = 2;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearTimestamp() {
				copyOnWrite();
				instance.clearTimestamp();
				return this;
			}

			/**
			 * <code>optional int64 changeset = 3;</code>
			 */
			@java.lang.Override
			public boolean hasChangeset() {
				return instance.hasChangeset();
			}

			/**
			 * <code>optional int64 changeset = 3;</code>
			 */
			@java.lang.Override
			public long getChangeset() {
				return instance.getChangeset();
			}

			/**
			 * <code>optional int64 changeset = 3;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setChangeset(final long value) {
				copyOnWrite();
				instance.setChangeset(value);
				return this;
			}

			/**
			 * <code>optional int64 changeset = 3;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearChangeset() {
				copyOnWrite();
				instance.clearChangeset();
				return this;
			}

			/**
			 * <code>optional int32 uid = 4;</code>
			 */
			@java.lang.Override
			public boolean hasUid() {
				return instance.hasUid();
			}

			/**
			 * <code>optional int32 uid = 4;</code>
			 */
			@java.lang.Override
			public int getUid() {
				return instance.getUid();
			}

			/**
			 * <code>optional int32 uid = 4;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setUid(final int value) {
				copyOnWrite();
				instance.setUid(value);
				return this;
			}

			/**
			 * <code>optional int32 uid = 4;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearUid() {
				copyOnWrite();
				instance.clearUid();
				return this;
			}

			/**
			 * <pre>
			 * String IDs
			 * </pre>
			 *
			 * <code>optional uint32 user_sid = 5;</code>
			 */
			@java.lang.Override
			public boolean hasUserSid() {
				return instance.hasUserSid();
			}

			/**
			 * <pre>
			 * String IDs
			 * </pre>
			 *
			 * <code>optional uint32 user_sid = 5;</code>
			 */
			@java.lang.Override
			public int getUserSid() {
				return instance.getUserSid();
			}

			/**
			 * <pre>
			 * String IDs
			 * </pre>
			 * 
			 * <code>optional uint32 user_sid = 5;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setUserSid(final int value) {
				copyOnWrite();
				instance.setUserSid(value);
				return this;
			}

			/**
			 * <pre>
			 * String IDs
			 * </pre>
			 * 
			 * <code>optional uint32 user_sid = 5;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearUserSid() {
				copyOnWrite();
				instance.clearUserSid();
				return this;
			}

			/**
			 * <pre>
			 * The visible flag is used to store history information. It indicates that
			 * the current object version has been created by a delete operation on the
			 * OSM API.
			 * When a writer sets this flag, it MUST add a required_features tag with
			 * value "HistoricalInformation" to the HeaderBlock.
			 * If this flag is not available for some object it MUST be assumed to be
			 * true if the file has the required_features tag "HistoricalInformation"
			 * set.
			 * </pre>
			 *
			 * <code>optional bool visible = 6;</code>
			 */
			@java.lang.Override
			public boolean hasVisible() {
				return instance.hasVisible();
			}

			/**
			 * <pre>
			 * The visible flag is used to store history information. It indicates that
			 * the current object version has been created by a delete operation on the
			 * OSM API.
			 * When a writer sets this flag, it MUST add a required_features tag with
			 * value "HistoricalInformation" to the HeaderBlock.
			 * If this flag is not available for some object it MUST be assumed to be
			 * true if the file has the required_features tag "HistoricalInformation"
			 * set.
			 * </pre>
			 *
			 * <code>optional bool visible = 6;</code>
			 */
			@java.lang.Override
			public boolean getVisible() {
				return instance.getVisible();
			}

			/**
			 * <pre>
			 * The visible flag is used to store history information. It indicates that
			 * the current object version has been created by a delete operation on the
			 * OSM API.
			 * When a writer sets this flag, it MUST add a required_features tag with
			 * value "HistoricalInformation" to the HeaderBlock.
			 * If this flag is not available for some object it MUST be assumed to be
			 * true if the file has the required_features tag "HistoricalInformation"
			 * set.
			 * </pre>
			 * 
			 * <code>optional bool visible = 6;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setVisible(final boolean value) {
				copyOnWrite();
				instance.setVisible(value);
				return this;
			}

			/**
			 * <pre>
			 * The visible flag is used to store history information. It indicates that
			 * the current object version has been created by a delete operation on the
			 * OSM API.
			 * When a writer sets this flag, it MUST add a required_features tag with
			 * value "HistoricalInformation" to the HeaderBlock.
			 * If this flag is not available for some object it MUST be assumed to be
			 * true if the file has the required_features tag "HistoricalInformation"
			 * set.
			 * </pre>
			 * 
			 * <code>optional bool visible = 6;</code>
			 *
			 * @return the builder
			 */
			public Builder clearVisible() {
				copyOnWrite();
				instance.clearVisible();
				return this;
			}

			// @@protoc_insertion_point(builder_scope:OSMPBF.Info)
		}

		@java.lang.Override
		@java.lang.SuppressWarnings ({ "unchecked", "fallthrough" })
		protected java.lang.Object dynamicMethod(final com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
				final java.lang.Object arg0, final java.lang.Object arg1) {
			switch (method) {
				case NEW_MUTABLE_INSTANCE: {
					return new Info();
				}
				case NEW_BUILDER: {
					return new Builder();
				}
				case IS_INITIALIZED: {
					return DEFAULT_INSTANCE;
				}
				case MAKE_IMMUTABLE: {
					return null;
				}
				case VISIT: {
					final Visitor visitor = (Visitor) arg0;
					final Info other = (Info) arg1;
					version_ = visitor.visitInt(hasVersion(), version_, other.hasVersion(), other.version_);
					timestamp_ = visitor.visitLong(hasTimestamp(), timestamp_, other.hasTimestamp(), other.timestamp_);
					changeset_ = visitor.visitLong(hasChangeset(), changeset_, other.hasChangeset(), other.changeset_);
					uid_ = visitor.visitInt(hasUid(), uid_, other.hasUid(), other.uid_);
					userSid_ = visitor.visitInt(hasUserSid(), userSid_, other.hasUserSid(), other.userSid_);
					visible_ = visitor.visitBoolean(hasVisible(), visible_, other.hasVisible(), other.visible_);
					if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
						bitField0_ |= other.bitField0_;
					}
					return this;
				}
				case MERGE_FROM_STREAM: {
					final com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
					final com.google.protobuf.ExtensionRegistryLite extensionRegistry =
							(com.google.protobuf.ExtensionRegistryLite) arg1;
					if (extensionRegistry == null) { throw new java.lang.NullPointerException(); }
					try {
						boolean done = false;
						while (!done) {
							final int tag = input.readTag();
							switch (tag) {
								case 0:
									done = true;
									break;
								case 8: {
									bitField0_ |= 0x00000001;
									version_ = input.readInt32();
									break;
								}
								case 16: {
									bitField0_ |= 0x00000002;
									timestamp_ = input.readInt64();
									break;
								}
								case 24: {
									bitField0_ |= 0x00000004;
									changeset_ = input.readInt64();
									break;
								}
								case 32: {
									bitField0_ |= 0x00000008;
									uid_ = input.readInt32();
									break;
								}
								case 40: {
									bitField0_ |= 0x00000010;
									userSid_ = input.readUInt32();
									break;
								}
								case 48: {
									bitField0_ |= 0x00000020;
									visible_ = input.readBool();
									break;
								}
								default: {
									if (!parseUnknownField(tag, input)) {
										done = true;
									}
									break;
								}
							}
						}
					} catch (final com.google.protobuf.InvalidProtocolBufferException e) {
						throw new RuntimeException(e.setUnfinishedMessage(this));
					} catch (final java.io.IOException e) {
						throw new RuntimeException(
								new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
										.setUnfinishedMessage(this));
					} finally {}
				}
				// fall through
				case GET_DEFAULT_INSTANCE: {
					return DEFAULT_INSTANCE;
				}
				case GET_PARSER: {
					com.google.protobuf.Parser<Info> parser = PARSER;
					if (parser == null) {
						synchronized (Info.class) {
							parser = PARSER;
							if (parser == null) {
								parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
								PARSER = parser;
							}
						}
					}
					return parser;
				}
				case GET_MEMOIZED_IS_INITIALIZED: {
					return (byte) 1;
				}
				case SET_MEMOIZED_IS_INITIALIZED: {
					return null;
				}
			}
			throw new UnsupportedOperationException();
		}

		/** The Constant DEFAULT_INSTANCE. */
		// @@protoc_insertion_point(class_scope:OSMPBF.Info)
		private static final Info DEFAULT_INSTANCE;
		static {
			// New instances are implicitly immutable so no need to make
			// immutable.
			DEFAULT_INSTANCE = new Info();
		}

		/**
		 * Gets the default instance.
		 *
		 * @return the default instance
		 */
		public static Info getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		/** The parser. */
		private static volatile com.google.protobuf.Parser<Info> PARSER;

		/**
		 * Parser.
		 *
		 * @return the com.google.protobuf. parser
		 */
		public static com.google.protobuf.Parser<Info> parser() {
			return DEFAULT_INSTANCE.getParserForType();
		}
	}

	/**
	 * The Interface DenseInfoOrBuilder.
	 */
	public interface DenseInfoOrBuilder extends
			// @@protoc_insertion_point(interface_extends:OSMPBF.DenseInfo)
			com.google.protobuf.MessageLiteOrBuilder {

		/**
		 * <code>repeated int32 version = 1 [packed = true];</code>.
		 *
		 * @return the version list
		 */
		java.util.List<java.lang.Integer> getVersionList();

		/**
		 * <code>repeated int32 version = 1 [packed = true];</code>.
		 *
		 * @return the version count
		 */
		int getVersionCount();

		/**
		 * <code>repeated int32 version = 1 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the version
		 */
		int getVersion(int index);

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 timestamp = 2 [packed = true];</code>.
		 *
		 * @return the timestamp list
		 */
		java.util.List<java.lang.Long> getTimestampList();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 timestamp = 2 [packed = true];</code>.
		 *
		 * @return the timestamp count
		 */
		int getTimestampCount();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 timestamp = 2 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the timestamp
		 */
		long getTimestamp(int index);

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 changeset = 3 [packed = true];</code>.
		 *
		 * @return the changeset list
		 */
		java.util.List<java.lang.Long> getChangesetList();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 changeset = 3 [packed = true];</code>.
		 *
		 * @return the changeset count
		 */
		int getChangesetCount();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 changeset = 3 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the changeset
		 */
		long getChangeset(int index);

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint32 uid = 4 [packed = true];</code>.
		 *
		 * @return the uid list
		 */
		java.util.List<java.lang.Integer> getUidList();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint32 uid = 4 [packed = true];</code>.
		 *
		 * @return the uid count
		 */
		int getUidCount();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint32 uid = 4 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the uid
		 */
		int getUid(int index);

		/**
		 * <pre>
		 * String IDs for usernames. DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
		 *
		 * @return the user sid list
		 */
		java.util.List<java.lang.Integer> getUserSidList();

		/**
		 * <pre>
		 * String IDs for usernames. DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
		 *
		 * @return the user sid count
		 */
		int getUserSidCount();

		/**
		 * <pre>
		 * String IDs for usernames. DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
		 *
		 * @param index the index
		 * @return the user sid
		 */
		int getUserSid(int index);

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 * 
		 * <code>repeated bool visible = 6 [packed = true];</code>
		 *
		 * @return the visible list
		 */
		java.util.List<java.lang.Boolean> getVisibleList();

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 * 
		 * <code>repeated bool visible = 6 [packed = true];</code>
		 *
		 * @return the visible count
		 */
		int getVisibleCount();

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 * 
		 * <code>repeated bool visible = 6 [packed = true];</code>
		 *
		 * @param index the index
		 * @return the visible
		 */
		boolean getVisible(int index);
	}

	/**
	 * <pre>
	 ** Optional metadata that may be included into each primitive. Special dense format used in DenseNodes.
	 * </pre>
	 *
	 * Protobuf type {@code OSMPBF.DenseInfo}
	 */
	public static final class DenseInfo extends com.google.protobuf.GeneratedMessageLite<DenseInfo, DenseInfo.Builder>
			implements
			// @@protoc_insertion_point(message_implements:OSMPBF.DenseInfo)
			DenseInfoOrBuilder {
		
		/**
		 * Instantiates a new dense info.
		 */
		private DenseInfo() {
			version_ = emptyIntList();
			timestamp_ = emptyLongList();
			changeset_ = emptyLongList();
			uid_ = emptyIntList();
			userSid_ = emptyIntList();
			visible_ = emptyBooleanList();
		}

		/** The Constant VERSION_FIELD_NUMBER. */
		public static final int VERSION_FIELD_NUMBER = 1;
		
		/** The version. */
		private com.google.protobuf.Internal.IntList version_;

		/**
		 * <code>repeated int32 version = 1 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Integer> getVersionList() {
			return version_;
		}

		/**
		 * <code>repeated int32 version = 1 [packed = true];</code>
		 */
		@java.lang.Override
		public int getVersionCount() {
			return version_.size();
		}

		/**
		 * <code>repeated int32 version = 1 [packed = true];</code>
		 */
		@java.lang.Override
		public int getVersion(final int index) {
			return version_.getInt(index);
		}

		/** The version memoized serialized size. */
		private int versionMemoizedSerializedSize = -1;

		/**
		 * Ensure version is mutable.
		 */
		private void ensureVersionIsMutable() {
			if (!version_.isModifiable()) {
				version_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(version_);
			}
		}

		/**
		 * <code>repeated int32 version = 1 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setVersion(final int index, final int value) {
			ensureVersionIsMutable();
			version_.setInt(index, value);
		}

		/**
		 * <code>repeated int32 version = 1 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addVersion(final int value) {
			ensureVersionIsMutable();
			version_.addInt(value);
		}

		/**
		 * <code>repeated int32 version = 1 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllVersion(final java.lang.Iterable<? extends java.lang.Integer> values) {
			ensureVersionIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, version_);
		}

		/**
		 * <code>repeated int32 version = 1 [packed = true];</code>.
		 */
		private void clearVersion() {
			version_ = emptyIntList();
		}

		/** The Constant TIMESTAMP_FIELD_NUMBER. */
		public static final int TIMESTAMP_FIELD_NUMBER = 2;
		
		/** The timestamp. */
		private com.google.protobuf.Internal.LongList timestamp_;

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 timestamp = 2 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Long> getTimestampList() {
			return timestamp_;
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 timestamp = 2 [packed = true];</code>
		 */
		@java.lang.Override
		public int getTimestampCount() {
			return timestamp_.size();
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 timestamp = 2 [packed = true];</code>
		 */
		@java.lang.Override
		public long getTimestamp(final int index) {
			return timestamp_.getLong(index);
		}

		/** The timestamp memoized serialized size. */
		private int timestampMemoizedSerializedSize = -1;

		/**
		 * Ensure timestamp is mutable.
		 */
		private void ensureTimestampIsMutable() {
			if (!timestamp_.isModifiable()) {
				timestamp_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(timestamp_);
			}
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 timestamp = 2 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setTimestamp(final int index, final long value) {
			ensureTimestampIsMutable();
			timestamp_.setLong(index, value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 timestamp = 2 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addTimestamp(final long value) {
			ensureTimestampIsMutable();
			timestamp_.addLong(value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 timestamp = 2 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllTimestamp(final java.lang.Iterable<? extends java.lang.Long> values) {
			ensureTimestampIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, timestamp_);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 timestamp = 2 [packed = true];</code>.
		 */
		private void clearTimestamp() {
			timestamp_ = emptyLongList();
		}

		/** The Constant CHANGESET_FIELD_NUMBER. */
		public static final int CHANGESET_FIELD_NUMBER = 3;
		
		/** The changeset. */
		private com.google.protobuf.Internal.LongList changeset_;

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 changeset = 3 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Long> getChangesetList() {
			return changeset_;
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 changeset = 3 [packed = true];</code>
		 */
		@java.lang.Override
		public int getChangesetCount() {
			return changeset_.size();
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 changeset = 3 [packed = true];</code>
		 */
		@java.lang.Override
		public long getChangeset(final int index) {
			return changeset_.getLong(index);
		}

		/** The changeset memoized serialized size. */
		private int changesetMemoizedSerializedSize = -1;

		/**
		 * Ensure changeset is mutable.
		 */
		private void ensureChangesetIsMutable() {
			if (!changeset_.isModifiable()) {
				changeset_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(changeset_);
			}
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 changeset = 3 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setChangeset(final int index, final long value) {
			ensureChangesetIsMutable();
			changeset_.setLong(index, value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 changeset = 3 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addChangeset(final long value) {
			ensureChangesetIsMutable();
			changeset_.addLong(value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 changeset = 3 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllChangeset(final java.lang.Iterable<? extends java.lang.Long> values) {
			ensureChangesetIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, changeset_);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 changeset = 3 [packed = true];</code>.
		 */
		private void clearChangeset() {
			changeset_ = emptyLongList();
		}

		/** The Constant UID_FIELD_NUMBER. */
		public static final int UID_FIELD_NUMBER = 4;
		
		/** The uid. */
		private com.google.protobuf.Internal.IntList uid_;

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint32 uid = 4 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Integer> getUidList() {
			return uid_;
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint32 uid = 4 [packed = true];</code>
		 */
		@java.lang.Override
		public int getUidCount() {
			return uid_.size();
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint32 uid = 4 [packed = true];</code>
		 */
		@java.lang.Override
		public int getUid(final int index) {
			return uid_.getInt(index);
		}

		/** The uid memoized serialized size. */
		private int uidMemoizedSerializedSize = -1;

		/**
		 * Ensure uid is mutable.
		 */
		private void ensureUidIsMutable() {
			if (!uid_.isModifiable()) {
				uid_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(uid_);
			}
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint32 uid = 4 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setUid(final int index, final int value) {
			ensureUidIsMutable();
			uid_.setInt(index, value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint32 uid = 4 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addUid(final int value) {
			ensureUidIsMutable();
			uid_.addInt(value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint32 uid = 4 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllUid(final java.lang.Iterable<? extends java.lang.Integer> values) {
			ensureUidIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, uid_);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint32 uid = 4 [packed = true];</code>.
		 */
		private void clearUid() {
			uid_ = emptyIntList();
		}

		/** The Constant USER_SID_FIELD_NUMBER. */
		public static final int USER_SID_FIELD_NUMBER = 5;
		
		/** The user sid. */
		private com.google.protobuf.Internal.IntList userSid_;

		/**
		 * <pre>
		 * String IDs for usernames. DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Integer> getUserSidList() {
			return userSid_;
		}

		/**
		 * <pre>
		 * String IDs for usernames. DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
		 */
		@java.lang.Override
		public int getUserSidCount() {
			return userSid_.size();
		}

		/**
		 * <pre>
		 * String IDs for usernames. DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
		 */
		@java.lang.Override
		public int getUserSid(final int index) {
			return userSid_.getInt(index);
		}

		/** The user sid memoized serialized size. */
		private int userSidMemoizedSerializedSize = -1;

		/**
		 * Ensure user sid is mutable.
		 */
		private void ensureUserSidIsMutable() {
			if (!userSid_.isModifiable()) {
				userSid_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(userSid_);
			}
		}

		/**
		 * <pre>
		 * String IDs for usernames. DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setUserSid(final int index, final int value) {
			ensureUserSidIsMutable();
			userSid_.setInt(index, value);
		}

		/**
		 * <pre>
		 * String IDs for usernames. DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
		 *
		 * @param value the value
		 */
		private void addUserSid(final int value) {
			ensureUserSidIsMutable();
			userSid_.addInt(value);
		}

		/**
		 * <pre>
		 * String IDs for usernames. DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
		 *
		 * @param values the values
		 */
		private void addAllUserSid(final java.lang.Iterable<? extends java.lang.Integer> values) {
			ensureUserSidIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, userSid_);
		}

		/**
		 * <pre>
		 * String IDs for usernames. DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
		 */
		private void clearUserSid() {
			userSid_ = emptyIntList();
		}

		/** The Constant VISIBLE_FIELD_NUMBER. */
		public static final int VISIBLE_FIELD_NUMBER = 6;
		
		/** The visible. */
		private com.google.protobuf.Internal.BooleanList visible_;

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 *
		 * <code>repeated bool visible = 6 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Boolean> getVisibleList() {
			return visible_;
		}

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 *
		 * <code>repeated bool visible = 6 [packed = true];</code>
		 */
		@java.lang.Override
		public int getVisibleCount() {
			return visible_.size();
		}

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 *
		 * <code>repeated bool visible = 6 [packed = true];</code>
		 */
		@java.lang.Override
		public boolean getVisible(final int index) {
			return visible_.getBoolean(index);
		}

		/** The visible memoized serialized size. */
		private int visibleMemoizedSerializedSize = -1;

		/**
		 * Ensure visible is mutable.
		 */
		private void ensureVisibleIsMutable() {
			if (!visible_.isModifiable()) {
				visible_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(visible_);
			}
		}

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 * 
		 * <code>repeated bool visible = 6 [packed = true];</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setVisible(final int index, final boolean value) {
			ensureVisibleIsMutable();
			visible_.setBoolean(index, value);
		}

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 * 
		 * <code>repeated bool visible = 6 [packed = true];</code>
		 *
		 * @param value the value
		 */
		private void addVisible(final boolean value) {
			ensureVisibleIsMutable();
			visible_.addBoolean(value);
		}

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 * 
		 * <code>repeated bool visible = 6 [packed = true];</code>
		 *
		 * @param values the values
		 */
		private void addAllVisible(final java.lang.Iterable<? extends java.lang.Boolean> values) {
			ensureVisibleIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, visible_);
		}

		/**
		 * <pre>
		 * The visible flag is used to store history information. It indicates that
		 * the current object version has been created by a delete operation on the
		 * OSM API.
		 * When a writer sets this flag, it MUST add a required_features tag with
		 * value "HistoricalInformation" to the HeaderBlock.
		 * If this flag is not available for some object it MUST be assumed to be
		 * true if the file has the required_features tag "HistoricalInformation"
		 * set.
		 * </pre>
		 *
		 * <code>repeated bool visible = 6 [packed = true];</code>
		 */
		private void clearVisible() {
			visible_ = emptyBooleanList();
		}

		@java.lang.Override
		public void writeTo(final com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
			getSerializedSize();
			if (getVersionList().size() > 0) {
				output.writeUInt32NoTag(10);
				output.writeUInt32NoTag(versionMemoizedSerializedSize);
			}
			for (int i = 0; i < version_.size(); i++) {
				output.writeInt32NoTag(version_.getInt(i));
			}
			if (getTimestampList().size() > 0) {
				output.writeUInt32NoTag(18);
				output.writeUInt32NoTag(timestampMemoizedSerializedSize);
			}
			for (int i = 0; i < timestamp_.size(); i++) {
				output.writeSInt64NoTag(timestamp_.getLong(i));
			}
			if (getChangesetList().size() > 0) {
				output.writeUInt32NoTag(26);
				output.writeUInt32NoTag(changesetMemoizedSerializedSize);
			}
			for (int i = 0; i < changeset_.size(); i++) {
				output.writeSInt64NoTag(changeset_.getLong(i));
			}
			if (getUidList().size() > 0) {
				output.writeUInt32NoTag(34);
				output.writeUInt32NoTag(uidMemoizedSerializedSize);
			}
			for (int i = 0; i < uid_.size(); i++) {
				output.writeSInt32NoTag(uid_.getInt(i));
			}
			if (getUserSidList().size() > 0) {
				output.writeUInt32NoTag(42);
				output.writeUInt32NoTag(userSidMemoizedSerializedSize);
			}
			for (int i = 0; i < userSid_.size(); i++) {
				output.writeSInt32NoTag(userSid_.getInt(i));
			}
			if (getVisibleList().size() > 0) {
				output.writeUInt32NoTag(50);
				output.writeUInt32NoTag(visibleMemoizedSerializedSize);
			}
			for (int i = 0; i < visible_.size(); i++) {
				output.writeBoolNoTag(visible_.getBoolean(i));
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSerializedSize;
			if (size != -1) { return size; }

			size = 0;
			{
				int dataSize = 0;
				for (int i = 0; i < version_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(version_.getInt(i));
				}
				size += dataSize;
				if (!getVersionList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				versionMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				for (int i = 0; i < timestamp_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeSInt64SizeNoTag(timestamp_.getLong(i));
				}
				size += dataSize;
				if (!getTimestampList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				timestampMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				for (int i = 0; i < changeset_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeSInt64SizeNoTag(changeset_.getLong(i));
				}
				size += dataSize;
				if (!getChangesetList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				changesetMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				for (int i = 0; i < uid_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeSInt32SizeNoTag(uid_.getInt(i));
				}
				size += dataSize;
				if (!getUidList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				uidMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				for (int i = 0; i < userSid_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeSInt32SizeNoTag(userSid_.getInt(i));
				}
				size += dataSize;
				if (!getUserSidList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				userSidMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				dataSize = 1 * getVisibleList().size();
				size += dataSize;
				if (!getVisibleList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				visibleMemoizedSerializedSize = dataSize;
			}
			size += unknownFields.getSerializedSize();
			memoizedSerializedSize = size;
			return size;
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the dense info
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static DenseInfo parseFrom(final java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the dense info
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static DenseInfo parseFrom(final java.nio.ByteBuffer data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the dense info
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static DenseInfo parseFrom(final com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the dense info
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static DenseInfo parseFrom(final com.google.protobuf.ByteString data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the dense info
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static DenseInfo parseFrom(final byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the dense info
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static DenseInfo parseFrom(final byte[] data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the dense info
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static DenseInfo parseFrom(final java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the dense info
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static DenseInfo parseFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @return the dense info
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static DenseInfo parseDelimitedFrom(final java.io.InputStream input) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the dense info
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static DenseInfo parseDelimitedFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the dense info
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static DenseInfo parseFrom(final com.google.protobuf.CodedInputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the dense info
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static DenseInfo parseFrom(final com.google.protobuf.CodedInputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * New builder.
		 *
		 * @return the builder
		 */
		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.newBuilder();
		}

		/**
		 * New builder.
		 *
		 * @param prototype the prototype
		 * @return the builder
		 */
		public static Builder newBuilder(final DenseInfo prototype) {
			return DEFAULT_INSTANCE.newBuilder(prototype);
		}

		/**
		 * <pre>
		 ** Optional metadata that may be included into each primitive. Special dense format used in DenseNodes.
		 * </pre>
		 *
		 * Protobuf type {@code OSMPBF.DenseInfo}
		 */
		public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<DenseInfo, Builder>
				implements
				// @@protoc_insertion_point(builder_implements:OSMPBF.DenseInfo)
				DenseInfoOrBuilder {
			
			/**
			 * Instantiates a new builder.
			 */
			// Construct using DenseInfo.newBuilder()
			private Builder() {
				super(DEFAULT_INSTANCE);
			}

			/**
			 * <code>repeated int32 version = 1 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Integer> getVersionList() {
				return java.util.Collections.unmodifiableList(instance.getVersionList());
			}

			/**
			 * <code>repeated int32 version = 1 [packed = true];</code>
			 */
			@java.lang.Override
			public int getVersionCount() {
				return instance.getVersionCount();
			}

			/**
			 * <code>repeated int32 version = 1 [packed = true];</code>
			 */
			@java.lang.Override
			public int getVersion(final int index) {
				return instance.getVersion(index);
			}

			/**
			 * <code>repeated int32 version = 1 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setVersion(final int index, final int value) {
				copyOnWrite();
				instance.setVersion(index, value);
				return this;
			}

			/**
			 * <code>repeated int32 version = 1 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addVersion(final int value) {
				copyOnWrite();
				instance.addVersion(value);
				return this;
			}

			/**
			 * <code>repeated int32 version = 1 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllVersion(final java.lang.Iterable<? extends java.lang.Integer> values) {
				copyOnWrite();
				instance.addAllVersion(values);
				return this;
			}

			/**
			 * <code>repeated int32 version = 1 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearVersion() {
				copyOnWrite();
				instance.clearVersion();
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 timestamp = 2 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Long> getTimestampList() {
				return java.util.Collections.unmodifiableList(instance.getTimestampList());
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 timestamp = 2 [packed = true];</code>
			 */
			@java.lang.Override
			public int getTimestampCount() {
				return instance.getTimestampCount();
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 timestamp = 2 [packed = true];</code>
			 */
			@java.lang.Override
			public long getTimestamp(final int index) {
				return instance.getTimestamp(index);
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 timestamp = 2 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setTimestamp(final int index, final long value) {
				copyOnWrite();
				instance.setTimestamp(index, value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 timestamp = 2 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addTimestamp(final long value) {
				copyOnWrite();
				instance.addTimestamp(value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 timestamp = 2 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllTimestamp(final java.lang.Iterable<? extends java.lang.Long> values) {
				copyOnWrite();
				instance.addAllTimestamp(values);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 timestamp = 2 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearTimestamp() {
				copyOnWrite();
				instance.clearTimestamp();
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 changeset = 3 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Long> getChangesetList() {
				return java.util.Collections.unmodifiableList(instance.getChangesetList());
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 changeset = 3 [packed = true];</code>
			 */
			@java.lang.Override
			public int getChangesetCount() {
				return instance.getChangesetCount();
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 changeset = 3 [packed = true];</code>
			 */
			@java.lang.Override
			public long getChangeset(final int index) {
				return instance.getChangeset(index);
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 changeset = 3 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setChangeset(final int index, final long value) {
				copyOnWrite();
				instance.setChangeset(index, value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 changeset = 3 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addChangeset(final long value) {
				copyOnWrite();
				instance.addChangeset(value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 changeset = 3 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllChangeset(final java.lang.Iterable<? extends java.lang.Long> values) {
				copyOnWrite();
				instance.addAllChangeset(values);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 changeset = 3 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearChangeset() {
				copyOnWrite();
				instance.clearChangeset();
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint32 uid = 4 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Integer> getUidList() {
				return java.util.Collections.unmodifiableList(instance.getUidList());
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint32 uid = 4 [packed = true];</code>
			 */
			@java.lang.Override
			public int getUidCount() {
				return instance.getUidCount();
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint32 uid = 4 [packed = true];</code>
			 */
			@java.lang.Override
			public int getUid(final int index) {
				return instance.getUid(index);
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint32 uid = 4 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setUid(final int index, final int value) {
				copyOnWrite();
				instance.setUid(index, value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint32 uid = 4 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addUid(final int value) {
				copyOnWrite();
				instance.addUid(value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint32 uid = 4 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllUid(final java.lang.Iterable<? extends java.lang.Integer> values) {
				copyOnWrite();
				instance.addAllUid(values);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint32 uid = 4 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearUid() {
				copyOnWrite();
				instance.clearUid();
				return this;
			}

			/**
			 * <pre>
			 * String IDs for usernames. DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Integer> getUserSidList() {
				return java.util.Collections.unmodifiableList(instance.getUserSidList());
			}

			/**
			 * <pre>
			 * String IDs for usernames. DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
			 */
			@java.lang.Override
			public int getUserSidCount() {
				return instance.getUserSidCount();
			}

			/**
			 * <pre>
			 * String IDs for usernames. DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
			 */
			@java.lang.Override
			public int getUserSid(final int index) {
				return instance.getUserSid(index);
			}

			/**
			 * <pre>
			 * String IDs for usernames. DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setUserSid(final int index, final int value) {
				copyOnWrite();
				instance.setUserSid(index, value);
				return this;
			}

			/**
			 * <pre>
			 * String IDs for usernames. DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addUserSid(final int value) {
				copyOnWrite();
				instance.addUserSid(value);
				return this;
			}

			/**
			 * <pre>
			 * String IDs for usernames. DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllUserSid(final java.lang.Iterable<? extends java.lang.Integer> values) {
				copyOnWrite();
				instance.addAllUserSid(values);
				return this;
			}

			/**
			 * <pre>
			 * String IDs for usernames. DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint32 user_sid = 5 [packed = true];</code>
			 *
			 * @return the builder
			 */
			public Builder clearUserSid() {
				copyOnWrite();
				instance.clearUserSid();
				return this;
			}

			/**
			 * <pre>
			 * The visible flag is used to store history information. It indicates that
			 * the current object version has been created by a delete operation on the
			 * OSM API.
			 * When a writer sets this flag, it MUST add a required_features tag with
			 * value "HistoricalInformation" to the HeaderBlock.
			 * If this flag is not available for some object it MUST be assumed to be
			 * true if the file has the required_features tag "HistoricalInformation"
			 * set.
			 * </pre>
			 *
			 * <code>repeated bool visible = 6 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Boolean> getVisibleList() {
				return java.util.Collections.unmodifiableList(instance.getVisibleList());
			}

			/**
			 * <pre>
			 * The visible flag is used to store history information. It indicates that
			 * the current object version has been created by a delete operation on the
			 * OSM API.
			 * When a writer sets this flag, it MUST add a required_features tag with
			 * value "HistoricalInformation" to the HeaderBlock.
			 * If this flag is not available for some object it MUST be assumed to be
			 * true if the file has the required_features tag "HistoricalInformation"
			 * set.
			 * </pre>
			 *
			 * <code>repeated bool visible = 6 [packed = true];</code>
			 */
			@java.lang.Override
			public int getVisibleCount() {
				return instance.getVisibleCount();
			}

			/**
			 * <pre>
			 * The visible flag is used to store history information. It indicates that
			 * the current object version has been created by a delete operation on the
			 * OSM API.
			 * When a writer sets this flag, it MUST add a required_features tag with
			 * value "HistoricalInformation" to the HeaderBlock.
			 * If this flag is not available for some object it MUST be assumed to be
			 * true if the file has the required_features tag "HistoricalInformation"
			 * set.
			 * </pre>
			 *
			 * <code>repeated bool visible = 6 [packed = true];</code>
			 */
			@java.lang.Override
			public boolean getVisible(final int index) {
				return instance.getVisible(index);
			}

			/**
			 * <pre>
			 * The visible flag is used to store history information. It indicates that
			 * the current object version has been created by a delete operation on the
			 * OSM API.
			 * When a writer sets this flag, it MUST add a required_features tag with
			 * value "HistoricalInformation" to the HeaderBlock.
			 * If this flag is not available for some object it MUST be assumed to be
			 * true if the file has the required_features tag "HistoricalInformation"
			 * set.
			 * </pre>
			 * 
			 * <code>repeated bool visible = 6 [packed = true];</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setVisible(final int index, final boolean value) {
				copyOnWrite();
				instance.setVisible(index, value);
				return this;
			}

			/**
			 * <pre>
			 * The visible flag is used to store history information. It indicates that
			 * the current object version has been created by a delete operation on the
			 * OSM API.
			 * When a writer sets this flag, it MUST add a required_features tag with
			 * value "HistoricalInformation" to the HeaderBlock.
			 * If this flag is not available for some object it MUST be assumed to be
			 * true if the file has the required_features tag "HistoricalInformation"
			 * set.
			 * </pre>
			 * 
			 * <code>repeated bool visible = 6 [packed = true];</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addVisible(final boolean value) {
				copyOnWrite();
				instance.addVisible(value);
				return this;
			}

			/**
			 * <pre>
			 * The visible flag is used to store history information. It indicates that
			 * the current object version has been created by a delete operation on the
			 * OSM API.
			 * When a writer sets this flag, it MUST add a required_features tag with
			 * value "HistoricalInformation" to the HeaderBlock.
			 * If this flag is not available for some object it MUST be assumed to be
			 * true if the file has the required_features tag "HistoricalInformation"
			 * set.
			 * </pre>
			 * 
			 * <code>repeated bool visible = 6 [packed = true];</code>
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllVisible(final java.lang.Iterable<? extends java.lang.Boolean> values) {
				copyOnWrite();
				instance.addAllVisible(values);
				return this;
			}

			/**
			 * <pre>
			 * The visible flag is used to store history information. It indicates that
			 * the current object version has been created by a delete operation on the
			 * OSM API.
			 * When a writer sets this flag, it MUST add a required_features tag with
			 * value "HistoricalInformation" to the HeaderBlock.
			 * If this flag is not available for some object it MUST be assumed to be
			 * true if the file has the required_features tag "HistoricalInformation"
			 * set.
			 * </pre>
			 * 
			 * <code>repeated bool visible = 6 [packed = true];</code>
			 *
			 * @return the builder
			 */
			public Builder clearVisible() {
				copyOnWrite();
				instance.clearVisible();
				return this;
			}

			// @@protoc_insertion_point(builder_scope:OSMPBF.DenseInfo)
		}

		@java.lang.Override
		@java.lang.SuppressWarnings ({ "unchecked", "fallthrough" })
		protected java.lang.Object dynamicMethod(final com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
				final java.lang.Object arg0, final java.lang.Object arg1) {
			switch (method) {
				case NEW_MUTABLE_INSTANCE: {
					return new DenseInfo();
				}
				case NEW_BUILDER: {
					return new Builder();
				}
				case IS_INITIALIZED: {
					return DEFAULT_INSTANCE;
				}
				case MAKE_IMMUTABLE: {
					version_.makeImmutable();
					timestamp_.makeImmutable();
					changeset_.makeImmutable();
					uid_.makeImmutable();
					userSid_.makeImmutable();
					visible_.makeImmutable();
					return null;
				}
				case VISIT: {
					final Visitor visitor = (Visitor) arg0;
					final DenseInfo other = (DenseInfo) arg1;
					version_ = visitor.visitIntList(version_, other.version_);
					timestamp_ = visitor.visitLongList(timestamp_, other.timestamp_);
					changeset_ = visitor.visitLongList(changeset_, other.changeset_);
					uid_ = visitor.visitIntList(uid_, other.uid_);
					userSid_ = visitor.visitIntList(userSid_, other.userSid_);
					visible_ = visitor.visitBooleanList(visible_, other.visible_);
					if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {}
					return this;
				}
				case MERGE_FROM_STREAM: {
					final com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
					final com.google.protobuf.ExtensionRegistryLite extensionRegistry =
							(com.google.protobuf.ExtensionRegistryLite) arg1;
					if (extensionRegistry == null) { throw new java.lang.NullPointerException(); }
					try {
						boolean done = false;
						while (!done) {
							final int tag = input.readTag();
							switch (tag) {
								case 0:
									done = true;
									break;
								case 8: {
									if (!version_.isModifiable()) {
										version_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(version_);
									}
									version_.addInt(input.readInt32());
									break;
								}
								case 10: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!version_.isModifiable() && input.getBytesUntilLimit() > 0) {
										version_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(version_);
									}
									while (input.getBytesUntilLimit() > 0) {
										version_.addInt(input.readInt32());
									}
									input.popLimit(limit);
									break;
								}
								case 16: {
									if (!timestamp_.isModifiable()) {
										timestamp_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(timestamp_);
									}
									timestamp_.addLong(input.readSInt64());
									break;
								}
								case 18: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!timestamp_.isModifiable() && input.getBytesUntilLimit() > 0) {
										timestamp_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(timestamp_);
									}
									while (input.getBytesUntilLimit() > 0) {
										timestamp_.addLong(input.readSInt64());
									}
									input.popLimit(limit);
									break;
								}
								case 24: {
									if (!changeset_.isModifiable()) {
										changeset_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(changeset_);
									}
									changeset_.addLong(input.readSInt64());
									break;
								}
								case 26: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!changeset_.isModifiable() && input.getBytesUntilLimit() > 0) {
										changeset_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(changeset_);
									}
									while (input.getBytesUntilLimit() > 0) {
										changeset_.addLong(input.readSInt64());
									}
									input.popLimit(limit);
									break;
								}
								case 32: {
									if (!uid_.isModifiable()) {
										uid_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(uid_);
									}
									uid_.addInt(input.readSInt32());
									break;
								}
								case 34: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!uid_.isModifiable() && input.getBytesUntilLimit() > 0) {
										uid_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(uid_);
									}
									while (input.getBytesUntilLimit() > 0) {
										uid_.addInt(input.readSInt32());
									}
									input.popLimit(limit);
									break;
								}
								case 40: {
									if (!userSid_.isModifiable()) {
										userSid_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(userSid_);
									}
									userSid_.addInt(input.readSInt32());
									break;
								}
								case 42: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!userSid_.isModifiable() && input.getBytesUntilLimit() > 0) {
										userSid_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(userSid_);
									}
									while (input.getBytesUntilLimit() > 0) {
										userSid_.addInt(input.readSInt32());
									}
									input.popLimit(limit);
									break;
								}
								case 48: {
									if (!visible_.isModifiable()) {
										visible_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(visible_);
									}
									visible_.addBoolean(input.readBool());
									break;
								}
								case 50: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!visible_.isModifiable() && input.getBytesUntilLimit() > 0) {
										final int currentSize = visible_.size();
										visible_ = visible_.mutableCopyWithCapacity(currentSize + length / 1);
									}
									while (input.getBytesUntilLimit() > 0) {
										visible_.addBoolean(input.readBool());
									}
									input.popLimit(limit);
									break;
								}
								default: {
									if (!parseUnknownField(tag, input)) {
										done = true;
									}
									break;
								}
							}
						}
					} catch (final com.google.protobuf.InvalidProtocolBufferException e) {
						throw new RuntimeException(e.setUnfinishedMessage(this));
					} catch (final java.io.IOException e) {
						throw new RuntimeException(
								new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
										.setUnfinishedMessage(this));
					} finally {}
				}
				// fall through
				case GET_DEFAULT_INSTANCE: {
					return DEFAULT_INSTANCE;
				}
				case GET_PARSER: {
					com.google.protobuf.Parser<DenseInfo> parser = PARSER;
					if (parser == null) {
						synchronized (DenseInfo.class) {
							parser = PARSER;
							if (parser == null) {
								parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
								PARSER = parser;
							}
						}
					}
					return parser;
				}
				case GET_MEMOIZED_IS_INITIALIZED: {
					return (byte) 1;
				}
				case SET_MEMOIZED_IS_INITIALIZED: {
					return null;
				}
			}
			throw new UnsupportedOperationException();
		}

		/** The Constant DEFAULT_INSTANCE. */
		// @@protoc_insertion_point(class_scope:OSMPBF.DenseInfo)
		private static final DenseInfo DEFAULT_INSTANCE;
		static {
			// New instances are implicitly immutable so no need to make
			// immutable.
			DEFAULT_INSTANCE = new DenseInfo();
		}

		/**
		 * Gets the default instance.
		 *
		 * @return the default instance
		 */
		public static DenseInfo getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		/** The parser. */
		private static volatile com.google.protobuf.Parser<DenseInfo> PARSER;

		/**
		 * Parser.
		 *
		 * @return the com.google.protobuf. parser
		 */
		public static com.google.protobuf.Parser<DenseInfo> parser() {
			return DEFAULT_INSTANCE.getParserForType();
		}
	}

	/**
	 * The Interface ChangeSetOrBuilder.
	 */
	public interface ChangeSetOrBuilder extends
			// @@protoc_insertion_point(interface_extends:OSMPBF.ChangeSet)
			com.google.protobuf.MessageLiteOrBuilder {

		/**
		 * <pre>
		 * 
		 *   // Parallel arrays.
		 *   repeated uint32 keys = 2 [packed = true]; // String IDs.
		 *   repeated uint32 vals = 3 [packed = true]; // String IDs.
		 *   optional Info info = 4;
		 * </pre>
		 * 
		 * <code>required int64 id = 1;</code>
		 *
		 * @return true, if successful
		 */
		boolean hasId();

		/**
		 * <pre>
		 * 
		 *   // Parallel arrays.
		 *   repeated uint32 keys = 2 [packed = true]; // String IDs.
		 *   repeated uint32 vals = 3 [packed = true]; // String IDs.
		 *   optional Info info = 4;
		 * </pre>
		 * 
		 * <code>required int64 id = 1;</code>
		 *
		 * @return the id
		 */
		long getId();
	}

	/**
	 * <pre>
	 * THIS IS STUB DESIGN FOR CHANGESETS. NOT USED RIGHT NOW.
	 * TODO:    REMOVE THIS?
	 * </pre>
	 *
	 * Protobuf type {@code OSMPBF.ChangeSet}
	 */
	public static final class ChangeSet extends com.google.protobuf.GeneratedMessageLite<ChangeSet, ChangeSet.Builder>
			implements
			// @@protoc_insertion_point(message_implements:OSMPBF.ChangeSet)
			ChangeSetOrBuilder {
		
		/**
		 * Instantiates a new change set.
		 */
		private ChangeSet() {}

		/** The bit field 0. */
		private int bitField0_;
		
		/** The Constant ID_FIELD_NUMBER. */
		public static final int ID_FIELD_NUMBER = 1;
		
		/** The id. */
		private long id_;

		/**
		 * <pre>
		 *
		 *   // Parallel arrays.
		 *   repeated uint32 keys = 2 [packed = true]; // String IDs.
		 *   repeated uint32 vals = 3 [packed = true]; // String IDs.
		 *   optional Info info = 4;
		 * </pre>
		 *
		 * <code>required int64 id = 1;</code>
		 */
		@java.lang.Override
		public boolean hasId() {
			return (bitField0_ & 0x00000001) == 0x00000001;
		}

		/**
		 * <pre>
		 *
		 *   // Parallel arrays.
		 *   repeated uint32 keys = 2 [packed = true]; // String IDs.
		 *   repeated uint32 vals = 3 [packed = true]; // String IDs.
		 *   optional Info info = 4;
		 * </pre>
		 *
		 * <code>required int64 id = 1;</code>
		 */
		@java.lang.Override
		public long getId() {
			return id_;
		}

		/**
		 * <pre>
		 * 
		 *   // Parallel arrays.
		 *   repeated uint32 keys = 2 [packed = true]; // String IDs.
		 *   repeated uint32 vals = 3 [packed = true]; // String IDs.
		 *   optional Info info = 4;
		 * </pre>
		 * 
		 * <code>required int64 id = 1;</code>
		 *
		 * @param value the new id
		 */
		private void setId(final long value) {
			bitField0_ |= 0x00000001;
			id_ = value;
		}

		/**
		 * <pre>
		 *
		 *   // Parallel arrays.
		 *   repeated uint32 keys = 2 [packed = true]; // String IDs.
		 *   repeated uint32 vals = 3 [packed = true]; // String IDs.
		 *   optional Info info = 4;
		 * </pre>
		 *
		 * <code>required int64 id = 1;</code>
		 */
		private void clearId() {
			bitField0_ = bitField0_ & ~0x00000001;
			id_ = 0L;
		}

		@java.lang.Override
		public void writeTo(final com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				output.writeInt64(1, id_);
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSerializedSize;
			if (size != -1) { return size; }

			size = 0;
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, id_);
			}
			size += unknownFields.getSerializedSize();
			memoizedSerializedSize = size;
			return size;
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the change set
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static ChangeSet parseFrom(final java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the change set
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static ChangeSet parseFrom(final java.nio.ByteBuffer data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the change set
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static ChangeSet parseFrom(final com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the change set
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static ChangeSet parseFrom(final com.google.protobuf.ByteString data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the change set
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static ChangeSet parseFrom(final byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the change set
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static ChangeSet parseFrom(final byte[] data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the change set
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static ChangeSet parseFrom(final java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the change set
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static ChangeSet parseFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @return the change set
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static ChangeSet parseDelimitedFrom(final java.io.InputStream input) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the change set
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static ChangeSet parseDelimitedFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the change set
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static ChangeSet parseFrom(final com.google.protobuf.CodedInputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the change set
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static ChangeSet parseFrom(final com.google.protobuf.CodedInputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * New builder.
		 *
		 * @return the builder
		 */
		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.newBuilder();
		}

		/**
		 * New builder.
		 *
		 * @param prototype the prototype
		 * @return the builder
		 */
		public static Builder newBuilder(final ChangeSet prototype) {
			return DEFAULT_INSTANCE.newBuilder(prototype);
		}

		/**
		 * <pre>
		 * THIS IS STUB DESIGN FOR CHANGESETS. NOT USED RIGHT NOW.
		 * TODO:    REMOVE THIS?
		 * </pre>
		 *
		 * Protobuf type {@code OSMPBF.ChangeSet}
		 */
		public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<ChangeSet, Builder>
				implements
				// @@protoc_insertion_point(builder_implements:OSMPBF.ChangeSet)
				ChangeSetOrBuilder {
			
			/**
			 * Instantiates a new builder.
			 */
			// Construct using ChangeSet.newBuilder()
			private Builder() {
				super(DEFAULT_INSTANCE);
			}

			/**
			 * <pre>
			 *
			 *   // Parallel arrays.
			 *   repeated uint32 keys = 2 [packed = true]; // String IDs.
			 *   repeated uint32 vals = 3 [packed = true]; // String IDs.
			 *   optional Info info = 4;
			 * </pre>
			 *
			 * <code>required int64 id = 1;</code>
			 */
			@java.lang.Override
			public boolean hasId() {
				return instance.hasId();
			}

			/**
			 * <pre>
			 *
			 *   // Parallel arrays.
			 *   repeated uint32 keys = 2 [packed = true]; // String IDs.
			 *   repeated uint32 vals = 3 [packed = true]; // String IDs.
			 *   optional Info info = 4;
			 * </pre>
			 *
			 * <code>required int64 id = 1;</code>
			 */
			@java.lang.Override
			public long getId() {
				return instance.getId();
			}

			/**
			 * <pre>
			 * 
			 *   // Parallel arrays.
			 *   repeated uint32 keys = 2 [packed = true]; // String IDs.
			 *   repeated uint32 vals = 3 [packed = true]; // String IDs.
			 *   optional Info info = 4;
			 * </pre>
			 * 
			 * <code>required int64 id = 1;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setId(final long value) {
				copyOnWrite();
				instance.setId(value);
				return this;
			}

			/**
			 * <pre>
			 * 
			 *   // Parallel arrays.
			 *   repeated uint32 keys = 2 [packed = true]; // String IDs.
			 *   repeated uint32 vals = 3 [packed = true]; // String IDs.
			 *   optional Info info = 4;
			 * </pre>
			 * 
			 * <code>required int64 id = 1;</code>
			 *
			 * @return the builder
			 */
			public Builder clearId() {
				copyOnWrite();
				instance.clearId();
				return this;
			}

			// @@protoc_insertion_point(builder_scope:OSMPBF.ChangeSet)
		}

		/** The memoized is initialized. */
		private byte memoizedIsInitialized = 2;

		@java.lang.Override
		@java.lang.SuppressWarnings ({ "unchecked", "fallthrough" })
		protected java.lang.Object dynamicMethod(final com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
				final java.lang.Object arg0, final java.lang.Object arg1) {
			switch (method) {
				case NEW_MUTABLE_INSTANCE: {
					return new ChangeSet();
				}
				case NEW_BUILDER: {
					return new Builder();
				}
				case IS_INITIALIZED: {
					final byte isInitialized = memoizedIsInitialized;
					if (isInitialized == 1) { return DEFAULT_INSTANCE; }
					if (isInitialized == 0) { return null; }

					if (!hasId()) { return null; }
					return DEFAULT_INSTANCE;

				}
				case MAKE_IMMUTABLE: {
					return null;
				}
				case VISIT: {
					final Visitor visitor = (Visitor) arg0;
					final ChangeSet other = (ChangeSet) arg1;
					id_ = visitor.visitLong(hasId(), id_, other.hasId(), other.id_);
					if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
						bitField0_ |= other.bitField0_;
					}
					return this;
				}
				case MERGE_FROM_STREAM: {
					final com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
					final com.google.protobuf.ExtensionRegistryLite extensionRegistry =
							(com.google.protobuf.ExtensionRegistryLite) arg1;
					if (extensionRegistry == null) { throw new java.lang.NullPointerException(); }
					try {
						boolean done = false;
						while (!done) {
							final int tag = input.readTag();
							switch (tag) {
								case 0:
									done = true;
									break;
								case 8: {
									bitField0_ |= 0x00000001;
									id_ = input.readInt64();
									break;
								}
								default: {
									if (!parseUnknownField(tag, input)) {
										done = true;
									}
									break;
								}
							}
						}
					} catch (final com.google.protobuf.InvalidProtocolBufferException e) {
						throw new RuntimeException(e.setUnfinishedMessage(this));
					} catch (final java.io.IOException e) {
						throw new RuntimeException(
								new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
										.setUnfinishedMessage(this));
					} finally {}
				}
				// fall through
				case GET_DEFAULT_INSTANCE: {
					return DEFAULT_INSTANCE;
				}
				case GET_PARSER: {
					com.google.protobuf.Parser<ChangeSet> parser = PARSER;
					if (parser == null) {
						synchronized (ChangeSet.class) {
							parser = PARSER;
							if (parser == null) {
								parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
								PARSER = parser;
							}
						}
					}
					return parser;
				}
				case GET_MEMOIZED_IS_INITIALIZED: {
					return memoizedIsInitialized;
				}
				case SET_MEMOIZED_IS_INITIALIZED: {
					memoizedIsInitialized = (byte) (arg0 == null ? 0 : 1);
					return null;
				}
			}
			throw new UnsupportedOperationException();
		}

		/** The Constant DEFAULT_INSTANCE. */
		// @@protoc_insertion_point(class_scope:OSMPBF.ChangeSet)
		private static final ChangeSet DEFAULT_INSTANCE;
		static {
			// New instances are implicitly immutable so no need to make
			// immutable.
			DEFAULT_INSTANCE = new ChangeSet();
		}

		/**
		 * Gets the default instance.
		 *
		 * @return the default instance
		 */
		public static ChangeSet getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		/** The parser. */
		private static volatile com.google.protobuf.Parser<ChangeSet> PARSER;

		/**
		 * Parser.
		 *
		 * @return the com.google.protobuf. parser
		 */
		public static com.google.protobuf.Parser<ChangeSet> parser() {
			return DEFAULT_INSTANCE.getParserForType();
		}
	}

	/**
	 * The Interface NodeOrBuilder.
	 */
	public interface NodeOrBuilder extends
			// @@protoc_insertion_point(interface_extends:OSMPBF.Node)
			com.google.protobuf.MessageLiteOrBuilder {

		/**
		 * <code>required sint64 id = 1;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasId();

		/**
		 * <code>required sint64 id = 1;</code>.
		 *
		 * @return the id
		 */
		long getId();

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @return the keys list
		 */
		java.util.List<java.lang.Integer> getKeysList();

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @return the keys count
		 */
		int getKeysCount();

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @param index the index
		 * @return the keys
		 */
		int getKeys(int index);

		/**
		 * <pre>
		 * String IDs.
		 * </pre>
		 * 
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 *
		 * @return the vals list
		 */
		java.util.List<java.lang.Integer> getValsList();

		/**
		 * <pre>
		 * String IDs.
		 * </pre>
		 * 
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 *
		 * @return the vals count
		 */
		int getValsCount();

		/**
		 * <pre>
		 * String IDs.
		 * </pre>
		 * 
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 *
		 * @param index the index
		 * @return the vals
		 */
		int getVals(int index);

		/**
		 * <pre>
		 * May be omitted in omitmeta
		 * </pre>
		 * 
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @return true, if successful
		 */
		boolean hasInfo();

		/**
		 * <pre>
		 * May be omitted in omitmeta
		 * </pre>
		 * 
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @return the info
		 */
		Info getInfo();

		/**
		 * <code>required sint64 lat = 8;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasLat();

		/**
		 * <code>required sint64 lat = 8;</code>.
		 *
		 * @return the lat
		 */
		long getLat();

		/**
		 * <code>required sint64 lon = 9;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasLon();

		/**
		 * <code>required sint64 lon = 9;</code>.
		 *
		 * @return the lon
		 */
		long getLon();
	}

	/**
	 * Protobuf type {@code OSMPBF.Node}
	 */
	public static final class Node extends com.google.protobuf.GeneratedMessageLite<Node, Node.Builder> implements
			// @@protoc_insertion_point(message_implements:OSMPBF.Node)
			NodeOrBuilder {
		
		/**
		 * Instantiates a new node.
		 */
		private Node() {
			keys_ = emptyIntList();
			vals_ = emptyIntList();
		}

		/** The bit field 0. */
		private int bitField0_;
		
		/** The Constant ID_FIELD_NUMBER. */
		public static final int ID_FIELD_NUMBER = 1;
		
		/** The id. */
		private long id_;

		/**
		 * <code>required sint64 id = 1;</code>
		 */
		@java.lang.Override
		public boolean hasId() {
			return (bitField0_ & 0x00000001) == 0x00000001;
		}

		/**
		 * <code>required sint64 id = 1;</code>
		 */
		@java.lang.Override
		public long getId() {
			return id_;
		}

		/**
		 * <code>required sint64 id = 1;</code>.
		 *
		 * @param value the new id
		 */
		private void setId(final long value) {
			bitField0_ |= 0x00000001;
			id_ = value;
		}

		/**
		 * <code>required sint64 id = 1;</code>.
		 */
		private void clearId() {
			bitField0_ = bitField0_ & ~0x00000001;
			id_ = 0L;
		}

		/** The Constant KEYS_FIELD_NUMBER. */
		public static final int KEYS_FIELD_NUMBER = 2;
		
		/** The keys. */
		private com.google.protobuf.Internal.IntList keys_;

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 *
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Integer> getKeysList() {
			return keys_;
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 *
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 */
		@java.lang.Override
		public int getKeysCount() {
			return keys_.size();
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 *
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 */
		@java.lang.Override
		public int getKeys(final int index) {
			return keys_.getInt(index);
		}

		/** The keys memoized serialized size. */
		private int keysMemoizedSerializedSize = -1;

		/**
		 * Ensure keys is mutable.
		 */
		private void ensureKeysIsMutable() {
			if (!keys_.isModifiable()) {
				keys_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(keys_);
			}
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setKeys(final int index, final int value) {
			ensureKeysIsMutable();
			keys_.setInt(index, value);
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @param value the value
		 */
		private void addKeys(final int value) {
			ensureKeysIsMutable();
			keys_.addInt(value);
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @param values the values
		 */
		private void addAllKeys(final java.lang.Iterable<? extends java.lang.Integer> values) {
			ensureKeysIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, keys_);
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 *
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 */
		private void clearKeys() {
			keys_ = emptyIntList();
		}

		/** The Constant VALS_FIELD_NUMBER. */
		public static final int VALS_FIELD_NUMBER = 3;
		
		/** The vals. */
		private com.google.protobuf.Internal.IntList vals_;

		/**
		 * <pre>
		 * String IDs.
		 * </pre>
		 *
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Integer> getValsList() {
			return vals_;
		}

		/**
		 * <pre>
		 * String IDs.
		 * </pre>
		 *
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 */
		@java.lang.Override
		public int getValsCount() {
			return vals_.size();
		}

		/**
		 * <pre>
		 * String IDs.
		 * </pre>
		 *
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 */
		@java.lang.Override
		public int getVals(final int index) {
			return vals_.getInt(index);
		}

		/** The vals memoized serialized size. */
		private int valsMemoizedSerializedSize = -1;

		/**
		 * Ensure vals is mutable.
		 */
		private void ensureValsIsMutable() {
			if (!vals_.isModifiable()) {
				vals_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(vals_);
			}
		}

		/**
		 * <pre>
		 * String IDs.
		 * </pre>
		 * 
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setVals(final int index, final int value) {
			ensureValsIsMutable();
			vals_.setInt(index, value);
		}

		/**
		 * <pre>
		 * String IDs.
		 * </pre>
		 * 
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 *
		 * @param value the value
		 */
		private void addVals(final int value) {
			ensureValsIsMutable();
			vals_.addInt(value);
		}

		/**
		 * <pre>
		 * String IDs.
		 * </pre>
		 * 
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 *
		 * @param values the values
		 */
		private void addAllVals(final java.lang.Iterable<? extends java.lang.Integer> values) {
			ensureValsIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, vals_);
		}

		/**
		 * <pre>
		 * String IDs.
		 * </pre>
		 *
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 */
		private void clearVals() {
			vals_ = emptyIntList();
		}

		/** The Constant INFO_FIELD_NUMBER. */
		public static final int INFO_FIELD_NUMBER = 4;
		
		/** The info. */
		private Info info_;

		/**
		 * <pre>
		 * May be omitted in omitmeta
		 * </pre>
		 *
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 */
		@java.lang.Override
		public boolean hasInfo() {
			return (bitField0_ & 0x00000002) == 0x00000002;
		}

		/**
		 * <pre>
		 * May be omitted in omitmeta
		 * </pre>
		 *
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 */
		@java.lang.Override
		public Info getInfo() {
			return info_ == null ? Info.getDefaultInstance() : info_;
		}

		/**
		 * <pre>
		 * May be omitted in omitmeta
		 * </pre>
		 * 
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @param value the new info
		 */
		private void setInfo(final Info value) {
			if (value == null) { throw new NullPointerException(); }
			info_ = value;
			bitField0_ |= 0x00000002;
		}

		/**
		 * <pre>
		 * May be omitted in omitmeta
		 * </pre>
		 * 
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @param builderForValue the new info
		 */
		private void setInfo(final Info.Builder builderForValue) {
			info_ = builderForValue.build();
			bitField0_ |= 0x00000002;
		}

		/**
		 * <pre>
		 * May be omitted in omitmeta
		 * </pre>
		 * 
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @param value the value
		 */
		private void mergeInfo(final Info value) {
			if (value == null) { throw new NullPointerException(); }
			if (info_ != null && info_ != Info.getDefaultInstance()) {
				info_ = Info.newBuilder(info_).mergeFrom(value).buildPartial();
			} else {
				info_ = value;
			}
			bitField0_ |= 0x00000002;
		}

		/**
		 * <pre>
		 * May be omitted in omitmeta
		 * </pre>
		 *
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 */
		private void clearInfo() {
			info_ = null;
			bitField0_ = bitField0_ & ~0x00000002;
		}

		/** The Constant LAT_FIELD_NUMBER. */
		public static final int LAT_FIELD_NUMBER = 8;
		
		/** The lat. */
		private long lat_;

		/**
		 * <code>required sint64 lat = 8;</code>
		 */
		@java.lang.Override
		public boolean hasLat() {
			return (bitField0_ & 0x00000004) == 0x00000004;
		}

		/**
		 * <code>required sint64 lat = 8;</code>
		 */
		@java.lang.Override
		public long getLat() {
			return lat_;
		}

		/**
		 * <code>required sint64 lat = 8;</code>.
		 *
		 * @param value the new lat
		 */
		private void setLat(final long value) {
			bitField0_ |= 0x00000004;
			lat_ = value;
		}

		/**
		 * <code>required sint64 lat = 8;</code>.
		 */
		private void clearLat() {
			bitField0_ = bitField0_ & ~0x00000004;
			lat_ = 0L;
		}

		/** The Constant LON_FIELD_NUMBER. */
		public static final int LON_FIELD_NUMBER = 9;
		
		/** The lon. */
		private long lon_;

		/**
		 * <code>required sint64 lon = 9;</code>
		 */
		@java.lang.Override
		public boolean hasLon() {
			return (bitField0_ & 0x00000008) == 0x00000008;
		}

		/**
		 * <code>required sint64 lon = 9;</code>
		 */
		@java.lang.Override
		public long getLon() {
			return lon_;
		}

		/**
		 * <code>required sint64 lon = 9;</code>.
		 *
		 * @param value the new lon
		 */
		private void setLon(final long value) {
			bitField0_ |= 0x00000008;
			lon_ = value;
		}

		/**
		 * <code>required sint64 lon = 9;</code>.
		 */
		private void clearLon() {
			bitField0_ = bitField0_ & ~0x00000008;
			lon_ = 0L;
		}

		@java.lang.Override
		public void writeTo(final com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
			getSerializedSize();
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				output.writeSInt64(1, id_);
			}
			if (getKeysList().size() > 0) {
				output.writeUInt32NoTag(18);
				output.writeUInt32NoTag(keysMemoizedSerializedSize);
			}
			for (int i = 0; i < keys_.size(); i++) {
				output.writeUInt32NoTag(keys_.getInt(i));
			}
			if (getValsList().size() > 0) {
				output.writeUInt32NoTag(26);
				output.writeUInt32NoTag(valsMemoizedSerializedSize);
			}
			for (int i = 0; i < vals_.size(); i++) {
				output.writeUInt32NoTag(vals_.getInt(i));
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				output.writeMessage(4, getInfo());
			}
			if ((bitField0_ & 0x00000004) == 0x00000004) {
				output.writeSInt64(8, lat_);
			}
			if ((bitField0_ & 0x00000008) == 0x00000008) {
				output.writeSInt64(9, lon_);
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSerializedSize;
			if (size != -1) { return size; }

			size = 0;
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				size += com.google.protobuf.CodedOutputStream.computeSInt64Size(1, id_);
			}
			{
				int dataSize = 0;
				for (int i = 0; i < keys_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(keys_.getInt(i));
				}
				size += dataSize;
				if (!getKeysList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				keysMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				for (int i = 0; i < vals_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(vals_.getInt(i));
				}
				size += dataSize;
				if (!getValsList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				valsMemoizedSerializedSize = dataSize;
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				size += com.google.protobuf.CodedOutputStream.computeMessageSize(4, getInfo());
			}
			if ((bitField0_ & 0x00000004) == 0x00000004) {
				size += com.google.protobuf.CodedOutputStream.computeSInt64Size(8, lat_);
			}
			if ((bitField0_ & 0x00000008) == 0x00000008) {
				size += com.google.protobuf.CodedOutputStream.computeSInt64Size(9, lon_);
			}
			size += unknownFields.getSerializedSize();
			memoizedSerializedSize = size;
			return size;
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the node
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Node parseFrom(final java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the node
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Node parseFrom(final java.nio.ByteBuffer data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the node
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Node parseFrom(final com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the node
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Node parseFrom(final com.google.protobuf.ByteString data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the node
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Node parseFrom(final byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the node
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Node parseFrom(final byte[] data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the node
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Node parseFrom(final java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the node
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Node parseFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @return the node
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Node parseDelimitedFrom(final java.io.InputStream input) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the node
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Node parseDelimitedFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the node
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Node parseFrom(final com.google.protobuf.CodedInputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the node
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Node parseFrom(final com.google.protobuf.CodedInputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * New builder.
		 *
		 * @return the builder
		 */
		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.newBuilder();
		}

		/**
		 * New builder.
		 *
		 * @param prototype the prototype
		 * @return the builder
		 */
		public static Builder newBuilder(final Node prototype) {
			return DEFAULT_INSTANCE.newBuilder(prototype);
		}

		/**
		 * Protobuf type {@code OSMPBF.Node}
		 */
		public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<Node, Builder>
				implements
				// @@protoc_insertion_point(builder_implements:OSMPBF.Node)
				NodeOrBuilder {
			
			/**
			 * Instantiates a new builder.
			 */
			// Construct using Node.newBuilder()
			private Builder() {
				super(DEFAULT_INSTANCE);
			}

			/**
			 * <code>required sint64 id = 1;</code>
			 */
			@java.lang.Override
			public boolean hasId() {
				return instance.hasId();
			}

			/**
			 * <code>required sint64 id = 1;</code>
			 */
			@java.lang.Override
			public long getId() {
				return instance.getId();
			}

			/**
			 * <code>required sint64 id = 1;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setId(final long value) {
				copyOnWrite();
				instance.setId(value);
				return this;
			}

			/**
			 * <code>required sint64 id = 1;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearId() {
				copyOnWrite();
				instance.clearId();
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 *
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Integer> getKeysList() {
				return java.util.Collections.unmodifiableList(instance.getKeysList());
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 *
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 */
			@java.lang.Override
			public int getKeysCount() {
				return instance.getKeysCount();
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 *
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 */
			@java.lang.Override
			public int getKeys(final int index) {
				return instance.getKeys(index);
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 * 
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setKeys(final int index, final int value) {
				copyOnWrite();
				instance.setKeys(index, value);
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 * 
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addKeys(final int value) {
				copyOnWrite();
				instance.addKeys(value);
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 * 
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllKeys(final java.lang.Iterable<? extends java.lang.Integer> values) {
				copyOnWrite();
				instance.addAllKeys(values);
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 * 
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 *
			 * @return the builder
			 */
			public Builder clearKeys() {
				copyOnWrite();
				instance.clearKeys();
				return this;
			}

			/**
			 * <pre>
			 * String IDs.
			 * </pre>
			 *
			 * <code>repeated uint32 vals = 3 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Integer> getValsList() {
				return java.util.Collections.unmodifiableList(instance.getValsList());
			}

			/**
			 * <pre>
			 * String IDs.
			 * </pre>
			 *
			 * <code>repeated uint32 vals = 3 [packed = true];</code>
			 */
			@java.lang.Override
			public int getValsCount() {
				return instance.getValsCount();
			}

			/**
			 * <pre>
			 * String IDs.
			 * </pre>
			 *
			 * <code>repeated uint32 vals = 3 [packed = true];</code>
			 */
			@java.lang.Override
			public int getVals(final int index) {
				return instance.getVals(index);
			}

			/**
			 * <pre>
			 * String IDs.
			 * </pre>
			 * 
			 * <code>repeated uint32 vals = 3 [packed = true];</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setVals(final int index, final int value) {
				copyOnWrite();
				instance.setVals(index, value);
				return this;
			}

			/**
			 * <pre>
			 * String IDs.
			 * </pre>
			 * 
			 * <code>repeated uint32 vals = 3 [packed = true];</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addVals(final int value) {
				copyOnWrite();
				instance.addVals(value);
				return this;
			}

			/**
			 * <pre>
			 * String IDs.
			 * </pre>
			 * 
			 * <code>repeated uint32 vals = 3 [packed = true];</code>
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllVals(final java.lang.Iterable<? extends java.lang.Integer> values) {
				copyOnWrite();
				instance.addAllVals(values);
				return this;
			}

			/**
			 * <pre>
			 * String IDs.
			 * </pre>
			 * 
			 * <code>repeated uint32 vals = 3 [packed = true];</code>
			 *
			 * @return the builder
			 */
			public Builder clearVals() {
				copyOnWrite();
				instance.clearVals();
				return this;
			}

			/**
			 * <pre>
			 * May be omitted in omitmeta
			 * </pre>
			 *
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 */
			@java.lang.Override
			public boolean hasInfo() {
				return instance.hasInfo();
			}

			/**
			 * <pre>
			 * May be omitted in omitmeta
			 * </pre>
			 *
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 */
			@java.lang.Override
			public Info getInfo() {
				return instance.getInfo();
			}

			/**
			 * <pre>
			 * May be omitted in omitmeta
			 * </pre>
			 * 
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setInfo(final Info value) {
				copyOnWrite();
				instance.setInfo(value);
				return this;
			}

			/**
			 * <pre>
			 * May be omitted in omitmeta
			 * </pre>
			 * 
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 *
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder setInfo(final Info.Builder builderForValue) {
				copyOnWrite();
				instance.setInfo(builderForValue);
				return this;
			}

			/**
			 * <pre>
			 * May be omitted in omitmeta
			 * </pre>
			 * 
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder mergeInfo(final Info value) {
				copyOnWrite();
				instance.mergeInfo(value);
				return this;
			}

			/**
			 * <pre>
			 * May be omitted in omitmeta
			 * </pre>
			 * 
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 *
			 * @return the builder
			 */
			public Builder clearInfo() {
				copyOnWrite();
				instance.clearInfo();
				return this;
			}

			/**
			 * <code>required sint64 lat = 8;</code>
			 */
			@java.lang.Override
			public boolean hasLat() {
				return instance.hasLat();
			}

			/**
			 * <code>required sint64 lat = 8;</code>
			 */
			@java.lang.Override
			public long getLat() {
				return instance.getLat();
			}

			/**
			 * <code>required sint64 lat = 8;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setLat(final long value) {
				copyOnWrite();
				instance.setLat(value);
				return this;
			}

			/**
			 * <code>required sint64 lat = 8;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearLat() {
				copyOnWrite();
				instance.clearLat();
				return this;
			}

			/**
			 * <code>required sint64 lon = 9;</code>
			 */
			@java.lang.Override
			public boolean hasLon() {
				return instance.hasLon();
			}

			/**
			 * <code>required sint64 lon = 9;</code>
			 */
			@java.lang.Override
			public long getLon() {
				return instance.getLon();
			}

			/**
			 * <code>required sint64 lon = 9;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setLon(final long value) {
				copyOnWrite();
				instance.setLon(value);
				return this;
			}

			/**
			 * <code>required sint64 lon = 9;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearLon() {
				copyOnWrite();
				instance.clearLon();
				return this;
			}

			// @@protoc_insertion_point(builder_scope:OSMPBF.Node)
		}

		/** The memoized is initialized. */
		private byte memoizedIsInitialized = 2;

		@java.lang.Override
		@java.lang.SuppressWarnings ({ "unchecked", "fallthrough" })
		protected java.lang.Object dynamicMethod(final com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
				final java.lang.Object arg0, final java.lang.Object arg1) {
			switch (method) {
				case NEW_MUTABLE_INSTANCE: {
					return new Node();
				}
				case NEW_BUILDER: {
					return new Builder();
				}
				case IS_INITIALIZED: {
					final byte isInitialized = memoizedIsInitialized;
					if (isInitialized == 1) { return DEFAULT_INSTANCE; }
					if (isInitialized == 0) { return null; }

					if (!hasId()) { return null; }
					if (!hasLat()) { return null; }
					if (!hasLon()) { return null; }
					return DEFAULT_INSTANCE;

				}
				case MAKE_IMMUTABLE: {
					keys_.makeImmutable();
					vals_.makeImmutable();
					return null;
				}
				case VISIT: {
					final Visitor visitor = (Visitor) arg0;
					final Node other = (Node) arg1;
					id_ = visitor.visitLong(hasId(), id_, other.hasId(), other.id_);
					keys_ = visitor.visitIntList(keys_, other.keys_);
					vals_ = visitor.visitIntList(vals_, other.vals_);
					info_ = visitor.visitMessage(info_, other.info_);
					lat_ = visitor.visitLong(hasLat(), lat_, other.hasLat(), other.lat_);
					lon_ = visitor.visitLong(hasLon(), lon_, other.hasLon(), other.lon_);
					if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
						bitField0_ |= other.bitField0_;
					}
					return this;
				}
				case MERGE_FROM_STREAM: {
					final com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
					final com.google.protobuf.ExtensionRegistryLite extensionRegistry =
							(com.google.protobuf.ExtensionRegistryLite) arg1;
					if (extensionRegistry == null) { throw new java.lang.NullPointerException(); }
					try {
						boolean done = false;
						while (!done) {
							final int tag = input.readTag();
							switch (tag) {
								case 0:
									done = true;
									break;
								case 8: {
									bitField0_ |= 0x00000001;
									id_ = input.readSInt64();
									break;
								}
								case 16: {
									if (!keys_.isModifiable()) {
										keys_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(keys_);
									}
									keys_.addInt(input.readUInt32());
									break;
								}
								case 18: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!keys_.isModifiable() && input.getBytesUntilLimit() > 0) {
										keys_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(keys_);
									}
									while (input.getBytesUntilLimit() > 0) {
										keys_.addInt(input.readUInt32());
									}
									input.popLimit(limit);
									break;
								}
								case 24: {
									if (!vals_.isModifiable()) {
										vals_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(vals_);
									}
									vals_.addInt(input.readUInt32());
									break;
								}
								case 26: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!vals_.isModifiable() && input.getBytesUntilLimit() > 0) {
										vals_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(vals_);
									}
									while (input.getBytesUntilLimit() > 0) {
										vals_.addInt(input.readUInt32());
									}
									input.popLimit(limit);
									break;
								}
								case 34: {
									Info.Builder subBuilder = null;
									if ((bitField0_ & 0x00000002) == 0x00000002) {
										subBuilder = info_.toBuilder();
									}
									info_ = input.readMessage(Info.parser(), extensionRegistry);
									if (subBuilder != null) {
										subBuilder.mergeFrom(info_);
										info_ = subBuilder.buildPartial();
									}
									bitField0_ |= 0x00000002;
									break;
								}
								case 64: {
									bitField0_ |= 0x00000004;
									lat_ = input.readSInt64();
									break;
								}
								case 72: {
									bitField0_ |= 0x00000008;
									lon_ = input.readSInt64();
									break;
								}
								default: {
									if (!parseUnknownField(tag, input)) {
										done = true;
									}
									break;
								}
							}
						}
					} catch (final com.google.protobuf.InvalidProtocolBufferException e) {
						throw new RuntimeException(e.setUnfinishedMessage(this));
					} catch (final java.io.IOException e) {
						throw new RuntimeException(
								new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
										.setUnfinishedMessage(this));
					} finally {}
				}
				// fall through
				case GET_DEFAULT_INSTANCE: {
					return DEFAULT_INSTANCE;
				}
				case GET_PARSER: {
					com.google.protobuf.Parser<Node> parser = PARSER;
					if (parser == null) {
						synchronized (Node.class) {
							parser = PARSER;
							if (parser == null) {
								parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
								PARSER = parser;
							}
						}
					}
					return parser;
				}
				case GET_MEMOIZED_IS_INITIALIZED: {
					return memoizedIsInitialized;
				}
				case SET_MEMOIZED_IS_INITIALIZED: {
					memoizedIsInitialized = (byte) (arg0 == null ? 0 : 1);
					return null;
				}
			}
			throw new UnsupportedOperationException();
		}

		/** The Constant DEFAULT_INSTANCE. */
		// @@protoc_insertion_point(class_scope:OSMPBF.Node)
		private static final Node DEFAULT_INSTANCE;
		static {
			// New instances are implicitly immutable so no need to make
			// immutable.
			DEFAULT_INSTANCE = new Node();
		}

		/**
		 * Gets the default instance.
		 *
		 * @return the default instance
		 */
		public static Node getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		/** The parser. */
		private static volatile com.google.protobuf.Parser<Node> PARSER;

		/**
		 * Parser.
		 *
		 * @return the com.google.protobuf. parser
		 */
		public static com.google.protobuf.Parser<Node> parser() {
			return DEFAULT_INSTANCE.getParserForType();
		}
	}

	/**
	 * The Interface DenseNodesOrBuilder.
	 */
	public interface DenseNodesOrBuilder extends
			// @@protoc_insertion_point(interface_extends:OSMPBF.DenseNodes)
			com.google.protobuf.MessageLiteOrBuilder {

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 id = 1 [packed = true];</code>.
		 *
		 * @return the id list
		 */
		java.util.List<java.lang.Long> getIdList();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 id = 1 [packed = true];</code>.
		 *
		 * @return the id count
		 */
		int getIdCount();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 id = 1 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the id
		 */
		long getId(int index);

		/**
		 * <pre>
		 * repeated Info info = 4;
		 * </pre>
		 * 
		 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
		 *
		 * @return true, if successful
		 */
		boolean hasDenseinfo();

		/**
		 * <pre>
		 * repeated Info info = 4;
		 * </pre>
		 * 
		 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
		 *
		 * @return the denseinfo
		 */
		DenseInfo getDenseinfo();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lat = 8 [packed = true];</code>.
		 *
		 * @return the lat list
		 */
		java.util.List<java.lang.Long> getLatList();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lat = 8 [packed = true];</code>.
		 *
		 * @return the lat count
		 */
		int getLatCount();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lat = 8 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the lat
		 */
		long getLat(int index);

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lon = 9 [packed = true];</code>.
		 *
		 * @return the lon list
		 */
		java.util.List<java.lang.Long> getLonList();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lon = 9 [packed = true];</code>.
		 *
		 * @return the lon count
		 */
		int getLonCount();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lon = 9 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the lon
		 */
		long getLon(int index);

		/**
		 * <pre>
		 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
		 * </pre>
		 * 
		 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
		 *
		 * @return the keys vals list
		 */
		java.util.List<java.lang.Integer> getKeysValsList();

		/**
		 * <pre>
		 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
		 * </pre>
		 * 
		 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
		 *
		 * @return the keys vals count
		 */
		int getKeysValsCount();

		/**
		 * <pre>
		 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
		 * </pre>
		 * 
		 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
		 *
		 * @param index the index
		 * @return the keys vals
		 */
		int getKeysVals(int index);
	}

	/**
	 * Protobuf type {@code OSMPBF.DenseNodes}
	 */
	public static final class DenseNodes
			extends com.google.protobuf.GeneratedMessageLite<DenseNodes, DenseNodes.Builder> implements
			// @@protoc_insertion_point(message_implements:OSMPBF.DenseNodes)
			DenseNodesOrBuilder {
		
		/**
		 * Instantiates a new dense nodes.
		 */
		private DenseNodes() {
			id_ = emptyLongList();
			lat_ = emptyLongList();
			lon_ = emptyLongList();
			keysVals_ = emptyIntList();
		}

		/** The bit field 0. */
		private int bitField0_;
		
		/** The Constant ID_FIELD_NUMBER. */
		public static final int ID_FIELD_NUMBER = 1;
		
		/** The id. */
		private com.google.protobuf.Internal.LongList id_;

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 id = 1 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Long> getIdList() {
			return id_;
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 id = 1 [packed = true];</code>
		 */
		@java.lang.Override
		public int getIdCount() {
			return id_.size();
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 id = 1 [packed = true];</code>
		 */
		@java.lang.Override
		public long getId(final int index) {
			return id_.getLong(index);
		}

		/** The id memoized serialized size. */
		private int idMemoizedSerializedSize = -1;

		/**
		 * Ensure id is mutable.
		 */
		private void ensureIdIsMutable() {
			if (!id_.isModifiable()) {
				id_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(id_);
			}
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 id = 1 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setId(final int index, final long value) {
			ensureIdIsMutable();
			id_.setLong(index, value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 id = 1 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addId(final long value) {
			ensureIdIsMutable();
			id_.addLong(value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 id = 1 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllId(final java.lang.Iterable<? extends java.lang.Long> values) {
			ensureIdIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, id_);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 id = 1 [packed = true];</code>.
		 */
		private void clearId() {
			id_ = emptyLongList();
		}

		/** The Constant DENSEINFO_FIELD_NUMBER. */
		public static final int DENSEINFO_FIELD_NUMBER = 5;
		
		/** The denseinfo. */
		private DenseInfo denseinfo_;

		/**
		 * <pre>
		 *repeated Info info = 4;
		 * </pre>
		 *
		 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
		 */
		@java.lang.Override
		public boolean hasDenseinfo() {
			return (bitField0_ & 0x00000001) == 0x00000001;
		}

		/**
		 * <pre>
		 *repeated Info info = 4;
		 * </pre>
		 *
		 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
		 */
		@java.lang.Override
		public DenseInfo getDenseinfo() {
			return denseinfo_ == null ? DenseInfo.getDefaultInstance() : denseinfo_;
		}

		/**
		 * <pre>
		 * repeated Info info = 4;
		 * </pre>
		 * 
		 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
		 *
		 * @param value the new denseinfo
		 */
		private void setDenseinfo(final DenseInfo value) {
			if (value == null) { throw new NullPointerException(); }
			denseinfo_ = value;
			bitField0_ |= 0x00000001;
		}

		/**
		 * <pre>
		 * repeated Info info = 4;
		 * </pre>
		 * 
		 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
		 *
		 * @param builderForValue the new denseinfo
		 */
		private void setDenseinfo(final DenseInfo.Builder builderForValue) {
			denseinfo_ = builderForValue.build();
			bitField0_ |= 0x00000001;
		}

		/**
		 * <pre>
		 * repeated Info info = 4;
		 * </pre>
		 * 
		 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
		 *
		 * @param value the value
		 */
		private void mergeDenseinfo(final DenseInfo value) {
			if (value == null) { throw new NullPointerException(); }
			if (denseinfo_ != null && denseinfo_ != DenseInfo.getDefaultInstance()) {
				denseinfo_ = DenseInfo.newBuilder(denseinfo_).mergeFrom(value).buildPartial();
			} else {
				denseinfo_ = value;
			}
			bitField0_ |= 0x00000001;
		}

		/**
		 * <pre>
		 *repeated Info info = 4;
		 * </pre>
		 *
		 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
		 */
		private void clearDenseinfo() {
			denseinfo_ = null;
			bitField0_ = bitField0_ & ~0x00000001;
		}

		/** The Constant LAT_FIELD_NUMBER. */
		public static final int LAT_FIELD_NUMBER = 8;
		
		/** The lat. */
		private com.google.protobuf.Internal.LongList lat_;

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 lat = 8 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Long> getLatList() {
			return lat_;
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 lat = 8 [packed = true];</code>
		 */
		@java.lang.Override
		public int getLatCount() {
			return lat_.size();
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 lat = 8 [packed = true];</code>
		 */
		@java.lang.Override
		public long getLat(final int index) {
			return lat_.getLong(index);
		}

		/** The lat memoized serialized size. */
		private int latMemoizedSerializedSize = -1;

		/**
		 * Ensure lat is mutable.
		 */
		private void ensureLatIsMutable() {
			if (!lat_.isModifiable()) {
				lat_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(lat_);
			}
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lat = 8 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setLat(final int index, final long value) {
			ensureLatIsMutable();
			lat_.setLong(index, value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lat = 8 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addLat(final long value) {
			ensureLatIsMutable();
			lat_.addLong(value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lat = 8 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllLat(final java.lang.Iterable<? extends java.lang.Long> values) {
			ensureLatIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, lat_);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lat = 8 [packed = true];</code>.
		 */
		private void clearLat() {
			lat_ = emptyLongList();
		}

		/** The Constant LON_FIELD_NUMBER. */
		public static final int LON_FIELD_NUMBER = 9;
		
		/** The lon. */
		private com.google.protobuf.Internal.LongList lon_;

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 lon = 9 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Long> getLonList() {
			return lon_;
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 lon = 9 [packed = true];</code>
		 */
		@java.lang.Override
		public int getLonCount() {
			return lon_.size();
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 lon = 9 [packed = true];</code>
		 */
		@java.lang.Override
		public long getLon(final int index) {
			return lon_.getLong(index);
		}

		/** The lon memoized serialized size. */
		private int lonMemoizedSerializedSize = -1;

		/**
		 * Ensure lon is mutable.
		 */
		private void ensureLonIsMutable() {
			if (!lon_.isModifiable()) {
				lon_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(lon_);
			}
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lon = 9 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setLon(final int index, final long value) {
			ensureLonIsMutable();
			lon_.setLong(index, value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lon = 9 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addLon(final long value) {
			ensureLonIsMutable();
			lon_.addLong(value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lon = 9 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllLon(final java.lang.Iterable<? extends java.lang.Long> values) {
			ensureLonIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, lon_);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 lon = 9 [packed = true];</code>.
		 */
		private void clearLon() {
			lon_ = emptyLongList();
		}

		/** The Constant KEYS_VALS_FIELD_NUMBER. */
		public static final int KEYS_VALS_FIELD_NUMBER = 10;
		
		/** The keys vals. */
		private com.google.protobuf.Internal.IntList keysVals_;

		/**
		 * <pre>
		 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
		 * </pre>
		 *
		 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Integer> getKeysValsList() {
			return keysVals_;
		}

		/**
		 * <pre>
		 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
		 * </pre>
		 *
		 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
		 */
		@java.lang.Override
		public int getKeysValsCount() {
			return keysVals_.size();
		}

		/**
		 * <pre>
		 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
		 * </pre>
		 *
		 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
		 */
		@java.lang.Override
		public int getKeysVals(final int index) {
			return keysVals_.getInt(index);
		}

		/** The keys vals memoized serialized size. */
		private int keysValsMemoizedSerializedSize = -1;

		/**
		 * Ensure keys vals is mutable.
		 */
		private void ensureKeysValsIsMutable() {
			if (!keysVals_.isModifiable()) {
				keysVals_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(keysVals_);
			}
		}

		/**
		 * <pre>
		 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
		 * </pre>
		 * 
		 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setKeysVals(final int index, final int value) {
			ensureKeysValsIsMutable();
			keysVals_.setInt(index, value);
		}

		/**
		 * <pre>
		 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
		 * </pre>
		 * 
		 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
		 *
		 * @param value the value
		 */
		private void addKeysVals(final int value) {
			ensureKeysValsIsMutable();
			keysVals_.addInt(value);
		}

		/**
		 * <pre>
		 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
		 * </pre>
		 * 
		 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
		 *
		 * @param values the values
		 */
		private void addAllKeysVals(final java.lang.Iterable<? extends java.lang.Integer> values) {
			ensureKeysValsIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, keysVals_);
		}

		/**
		 * <pre>
		 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
		 * </pre>
		 *
		 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
		 */
		private void clearKeysVals() {
			keysVals_ = emptyIntList();
		}

		@java.lang.Override
		public void writeTo(final com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
			getSerializedSize();
			if (getIdList().size() > 0) {
				output.writeUInt32NoTag(10);
				output.writeUInt32NoTag(idMemoizedSerializedSize);
			}
			for (int i = 0; i < id_.size(); i++) {
				output.writeSInt64NoTag(id_.getLong(i));
			}
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				output.writeMessage(5, getDenseinfo());
			}
			if (getLatList().size() > 0) {
				output.writeUInt32NoTag(66);
				output.writeUInt32NoTag(latMemoizedSerializedSize);
			}
			for (int i = 0; i < lat_.size(); i++) {
				output.writeSInt64NoTag(lat_.getLong(i));
			}
			if (getLonList().size() > 0) {
				output.writeUInt32NoTag(74);
				output.writeUInt32NoTag(lonMemoizedSerializedSize);
			}
			for (int i = 0; i < lon_.size(); i++) {
				output.writeSInt64NoTag(lon_.getLong(i));
			}
			if (getKeysValsList().size() > 0) {
				output.writeUInt32NoTag(82);
				output.writeUInt32NoTag(keysValsMemoizedSerializedSize);
			}
			for (int i = 0; i < keysVals_.size(); i++) {
				output.writeInt32NoTag(keysVals_.getInt(i));
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSerializedSize;
			if (size != -1) { return size; }

			size = 0;
			{
				int dataSize = 0;
				for (int i = 0; i < id_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeSInt64SizeNoTag(id_.getLong(i));
				}
				size += dataSize;
				if (!getIdList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				idMemoizedSerializedSize = dataSize;
			}
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				size += com.google.protobuf.CodedOutputStream.computeMessageSize(5, getDenseinfo());
			}
			{
				int dataSize = 0;
				for (int i = 0; i < lat_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeSInt64SizeNoTag(lat_.getLong(i));
				}
				size += dataSize;
				if (!getLatList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				latMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				for (int i = 0; i < lon_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeSInt64SizeNoTag(lon_.getLong(i));
				}
				size += dataSize;
				if (!getLonList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				lonMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				for (int i = 0; i < keysVals_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(keysVals_.getInt(i));
				}
				size += dataSize;
				if (!getKeysValsList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				keysValsMemoizedSerializedSize = dataSize;
			}
			size += unknownFields.getSerializedSize();
			memoizedSerializedSize = size;
			return size;
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the dense nodes
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static DenseNodes parseFrom(final java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the dense nodes
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static DenseNodes parseFrom(final java.nio.ByteBuffer data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the dense nodes
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static DenseNodes parseFrom(final com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the dense nodes
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static DenseNodes parseFrom(final com.google.protobuf.ByteString data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the dense nodes
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static DenseNodes parseFrom(final byte[] data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the dense nodes
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static DenseNodes parseFrom(final byte[] data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the dense nodes
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static DenseNodes parseFrom(final java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the dense nodes
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static DenseNodes parseFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @return the dense nodes
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static DenseNodes parseDelimitedFrom(final java.io.InputStream input) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the dense nodes
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static DenseNodes parseDelimitedFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the dense nodes
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static DenseNodes parseFrom(final com.google.protobuf.CodedInputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the dense nodes
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static DenseNodes parseFrom(final com.google.protobuf.CodedInputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * New builder.
		 *
		 * @return the builder
		 */
		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.newBuilder();
		}

		/**
		 * New builder.
		 *
		 * @param prototype the prototype
		 * @return the builder
		 */
		public static Builder newBuilder(final DenseNodes prototype) {
			return DEFAULT_INSTANCE.newBuilder(prototype);
		}

		/**
		 * Protobuf type {@code OSMPBF.DenseNodes}
		 */
		public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<DenseNodes, Builder>
				implements
				// @@protoc_insertion_point(builder_implements:OSMPBF.DenseNodes)
				DenseNodesOrBuilder {
			
			/**
			 * Instantiates a new builder.
			 */
			// Construct using DenseNodes.newBuilder()
			private Builder() {
				super(DEFAULT_INSTANCE);
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 id = 1 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Long> getIdList() {
				return java.util.Collections.unmodifiableList(instance.getIdList());
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 id = 1 [packed = true];</code>
			 */
			@java.lang.Override
			public int getIdCount() {
				return instance.getIdCount();
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 id = 1 [packed = true];</code>
			 */
			@java.lang.Override
			public long getId(final int index) {
				return instance.getId(index);
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 id = 1 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setId(final int index, final long value) {
				copyOnWrite();
				instance.setId(index, value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 id = 1 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addId(final long value) {
				copyOnWrite();
				instance.addId(value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 id = 1 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllId(final java.lang.Iterable<? extends java.lang.Long> values) {
				copyOnWrite();
				instance.addAllId(values);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 id = 1 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearId() {
				copyOnWrite();
				instance.clearId();
				return this;
			}

			/**
			 * <pre>
			 *repeated Info info = 4;
			 * </pre>
			 *
			 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
			 */
			@java.lang.Override
			public boolean hasDenseinfo() {
				return instance.hasDenseinfo();
			}

			/**
			 * <pre>
			 *repeated Info info = 4;
			 * </pre>
			 *
			 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
			 */
			@java.lang.Override
			public DenseInfo getDenseinfo() {
				return instance.getDenseinfo();
			}

			/**
			 * <pre>
			 * repeated Info info = 4;
			 * </pre>
			 * 
			 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setDenseinfo(final DenseInfo value) {
				copyOnWrite();
				instance.setDenseinfo(value);
				return this;
			}

			/**
			 * <pre>
			 * repeated Info info = 4;
			 * </pre>
			 * 
			 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
			 *
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder setDenseinfo(final DenseInfo.Builder builderForValue) {
				copyOnWrite();
				instance.setDenseinfo(builderForValue);
				return this;
			}

			/**
			 * <pre>
			 * repeated Info info = 4;
			 * </pre>
			 * 
			 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder mergeDenseinfo(final DenseInfo value) {
				copyOnWrite();
				instance.mergeDenseinfo(value);
				return this;
			}

			/**
			 * <pre>
			 * repeated Info info = 4;
			 * </pre>
			 * 
			 * <code>optional .OSMPBF.DenseInfo denseinfo = 5;</code>
			 *
			 * @return the builder
			 */
			public Builder clearDenseinfo() {
				copyOnWrite();
				instance.clearDenseinfo();
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 lat = 8 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Long> getLatList() {
				return java.util.Collections.unmodifiableList(instance.getLatList());
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 lat = 8 [packed = true];</code>
			 */
			@java.lang.Override
			public int getLatCount() {
				return instance.getLatCount();
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 lat = 8 [packed = true];</code>
			 */
			@java.lang.Override
			public long getLat(final int index) {
				return instance.getLat(index);
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 lat = 8 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setLat(final int index, final long value) {
				copyOnWrite();
				instance.setLat(index, value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 lat = 8 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addLat(final long value) {
				copyOnWrite();
				instance.addLat(value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 lat = 8 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllLat(final java.lang.Iterable<? extends java.lang.Long> values) {
				copyOnWrite();
				instance.addAllLat(values);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 lat = 8 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearLat() {
				copyOnWrite();
				instance.clearLat();
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 lon = 9 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Long> getLonList() {
				return java.util.Collections.unmodifiableList(instance.getLonList());
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 lon = 9 [packed = true];</code>
			 */
			@java.lang.Override
			public int getLonCount() {
				return instance.getLonCount();
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 lon = 9 [packed = true];</code>
			 */
			@java.lang.Override
			public long getLon(final int index) {
				return instance.getLon(index);
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 lon = 9 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setLon(final int index, final long value) {
				copyOnWrite();
				instance.setLon(index, value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 lon = 9 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addLon(final long value) {
				copyOnWrite();
				instance.addLon(value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 lon = 9 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllLon(final java.lang.Iterable<? extends java.lang.Long> values) {
				copyOnWrite();
				instance.addAllLon(values);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 lon = 9 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearLon() {
				copyOnWrite();
				instance.clearLon();
				return this;
			}

			/**
			 * <pre>
			 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
			 * </pre>
			 *
			 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Integer> getKeysValsList() {
				return java.util.Collections.unmodifiableList(instance.getKeysValsList());
			}

			/**
			 * <pre>
			 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
			 * </pre>
			 *
			 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
			 */
			@java.lang.Override
			public int getKeysValsCount() {
				return instance.getKeysValsCount();
			}

			/**
			 * <pre>
			 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
			 * </pre>
			 *
			 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
			 */
			@java.lang.Override
			public int getKeysVals(final int index) {
				return instance.getKeysVals(index);
			}

			/**
			 * <pre>
			 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
			 * </pre>
			 * 
			 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setKeysVals(final int index, final int value) {
				copyOnWrite();
				instance.setKeysVals(index, value);
				return this;
			}

			/**
			 * <pre>
			 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
			 * </pre>
			 * 
			 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addKeysVals(final int value) {
				copyOnWrite();
				instance.addKeysVals(value);
				return this;
			}

			/**
			 * <pre>
			 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
			 * </pre>
			 * 
			 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllKeysVals(final java.lang.Iterable<? extends java.lang.Integer> values) {
				copyOnWrite();
				instance.addAllKeysVals(values);
				return this;
			}

			/**
			 * <pre>
			 * Special packing of keys and vals into one array. May be empty if all nodes in this block are tagless.
			 * </pre>
			 * 
			 * <code>repeated int32 keys_vals = 10 [packed = true];</code>
			 *
			 * @return the builder
			 */
			public Builder clearKeysVals() {
				copyOnWrite();
				instance.clearKeysVals();
				return this;
			}

			// @@protoc_insertion_point(builder_scope:OSMPBF.DenseNodes)
		}

		@java.lang.Override
		@java.lang.SuppressWarnings ({ "unchecked", "fallthrough" })
		protected java.lang.Object dynamicMethod(final com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
				final java.lang.Object arg0, final java.lang.Object arg1) {
			switch (method) {
				case NEW_MUTABLE_INSTANCE: {
					return new DenseNodes();
				}
				case NEW_BUILDER: {
					return new Builder();
				}
				case IS_INITIALIZED: {
					return DEFAULT_INSTANCE;
				}
				case MAKE_IMMUTABLE: {
					id_.makeImmutable();
					lat_.makeImmutable();
					lon_.makeImmutable();
					keysVals_.makeImmutable();
					return null;
				}
				case VISIT: {
					final Visitor visitor = (Visitor) arg0;
					final DenseNodes other = (DenseNodes) arg1;
					id_ = visitor.visitLongList(id_, other.id_);
					denseinfo_ = visitor.visitMessage(denseinfo_, other.denseinfo_);
					lat_ = visitor.visitLongList(lat_, other.lat_);
					lon_ = visitor.visitLongList(lon_, other.lon_);
					keysVals_ = visitor.visitIntList(keysVals_, other.keysVals_);
					if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
						bitField0_ |= other.bitField0_;
					}
					return this;
				}
				case MERGE_FROM_STREAM: {
					final com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
					final com.google.protobuf.ExtensionRegistryLite extensionRegistry =
							(com.google.protobuf.ExtensionRegistryLite) arg1;
					if (extensionRegistry == null) { throw new java.lang.NullPointerException(); }
					try {
						boolean done = false;
						while (!done) {
							final int tag = input.readTag();
							switch (tag) {
								case 0:
									done = true;
									break;
								case 8: {
									if (!id_.isModifiable()) {
										id_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(id_);
									}
									id_.addLong(input.readSInt64());
									break;
								}
								case 10: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!id_.isModifiable() && input.getBytesUntilLimit() > 0) {
										id_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(id_);
									}
									while (input.getBytesUntilLimit() > 0) {
										id_.addLong(input.readSInt64());
									}
									input.popLimit(limit);
									break;
								}
								case 42: {
									DenseInfo.Builder subBuilder = null;
									if ((bitField0_ & 0x00000001) == 0x00000001) {
										subBuilder = denseinfo_.toBuilder();
									}
									denseinfo_ = input.readMessage(DenseInfo.parser(), extensionRegistry);
									if (subBuilder != null) {
										subBuilder.mergeFrom(denseinfo_);
										denseinfo_ = subBuilder.buildPartial();
									}
									bitField0_ |= 0x00000001;
									break;
								}
								case 64: {
									if (!lat_.isModifiable()) {
										lat_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(lat_);
									}
									lat_.addLong(input.readSInt64());
									break;
								}
								case 66: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!lat_.isModifiable() && input.getBytesUntilLimit() > 0) {
										lat_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(lat_);
									}
									while (input.getBytesUntilLimit() > 0) {
										lat_.addLong(input.readSInt64());
									}
									input.popLimit(limit);
									break;
								}
								case 72: {
									if (!lon_.isModifiable()) {
										lon_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(lon_);
									}
									lon_.addLong(input.readSInt64());
									break;
								}
								case 74: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!lon_.isModifiable() && input.getBytesUntilLimit() > 0) {
										lon_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(lon_);
									}
									while (input.getBytesUntilLimit() > 0) {
										lon_.addLong(input.readSInt64());
									}
									input.popLimit(limit);
									break;
								}
								case 80: {
									if (!keysVals_.isModifiable()) {
										keysVals_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(keysVals_);
									}
									keysVals_.addInt(input.readInt32());
									break;
								}
								case 82: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!keysVals_.isModifiable() && input.getBytesUntilLimit() > 0) {
										keysVals_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(keysVals_);
									}
									while (input.getBytesUntilLimit() > 0) {
										keysVals_.addInt(input.readInt32());
									}
									input.popLimit(limit);
									break;
								}
								default: {
									if (!parseUnknownField(tag, input)) {
										done = true;
									}
									break;
								}
							}
						}
					} catch (final com.google.protobuf.InvalidProtocolBufferException e) {
						throw new RuntimeException(e.setUnfinishedMessage(this));
					} catch (final java.io.IOException e) {
						throw new RuntimeException(
								new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
										.setUnfinishedMessage(this));
					} finally {}
				}
				// fall through
				case GET_DEFAULT_INSTANCE: {
					return DEFAULT_INSTANCE;
				}
				case GET_PARSER: {
					com.google.protobuf.Parser<DenseNodes> parser = PARSER;
					if (parser == null) {
						synchronized (DenseNodes.class) {
							parser = PARSER;
							if (parser == null) {
								parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
								PARSER = parser;
							}
						}
					}
					return parser;
				}
				case GET_MEMOIZED_IS_INITIALIZED: {
					return (byte) 1;
				}
				case SET_MEMOIZED_IS_INITIALIZED: {
					return null;
				}
			}
			throw new UnsupportedOperationException();
		}

		/** The Constant DEFAULT_INSTANCE. */
		// @@protoc_insertion_point(class_scope:OSMPBF.DenseNodes)
		private static final DenseNodes DEFAULT_INSTANCE;
		static {
			// New instances are implicitly immutable so no need to make
			// immutable.
			DEFAULT_INSTANCE = new DenseNodes();
		}

		/**
		 * Gets the default instance.
		 *
		 * @return the default instance
		 */
		public static DenseNodes getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		/** The parser. */
		private static volatile com.google.protobuf.Parser<DenseNodes> PARSER;

		/**
		 * Parser.
		 *
		 * @return the com.google.protobuf. parser
		 */
		public static com.google.protobuf.Parser<DenseNodes> parser() {
			return DEFAULT_INSTANCE.getParserForType();
		}
	}

	/**
	 * The Interface WayOrBuilder.
	 */
	public interface WayOrBuilder extends
			// @@protoc_insertion_point(interface_extends:OSMPBF.Way)
			com.google.protobuf.MessageLiteOrBuilder {

		/**
		 * <code>required int64 id = 1;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasId();

		/**
		 * <code>required int64 id = 1;</code>.
		 *
		 * @return the id
		 */
		long getId();

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @return the keys list
		 */
		java.util.List<java.lang.Integer> getKeysList();

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @return the keys count
		 */
		int getKeysCount();

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @param index the index
		 * @return the keys
		 */
		int getKeys(int index);

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 *
		 * @return the vals list
		 */
		java.util.List<java.lang.Integer> getValsList();

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 *
		 * @return the vals count
		 */
		int getValsCount();

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the vals
		 */
		int getVals(int index);

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @return true, if successful
		 */
		boolean hasInfo();

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @return the info
		 */
		Info getInfo();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 refs = 8 [packed = true];</code>.
		 *
		 * @return the refs list
		 */
		java.util.List<java.lang.Long> getRefsList();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 refs = 8 [packed = true];</code>.
		 *
		 * @return the refs count
		 */
		int getRefsCount();

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 refs = 8 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the refs
		 */
		long getRefs(int index);

		/**
		 * <code>repeated sint64 lat = 9 [packed = true];</code>.
		 *
		 * @return the lat list
		 */
		java.util.List<java.lang.Long> getLatList();

		/**
		 * <code>repeated sint64 lat = 9 [packed = true];</code>.
		 *
		 * @return the lat count
		 */
		int getLatCount();

		/**
		 * <code>repeated sint64 lat = 9 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the lat
		 */
		long getLat(int index);

		/**
		 * <code>repeated sint64 lon = 10 [packed = true];</code>.
		 *
		 * @return the lon list
		 */
		java.util.List<java.lang.Long> getLonList();

		/**
		 * <code>repeated sint64 lon = 10 [packed = true];</code>.
		 *
		 * @return the lon count
		 */
		int getLonCount();

		/**
		 * <code>repeated sint64 lon = 10 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the lon
		 */
		long getLon(int index);
	}

	/**
	 * Protobuf type {@code OSMPBF.Way}
	 */
	public static final class Way extends com.google.protobuf.GeneratedMessageLite<Way, Way.Builder> implements
			// @@protoc_insertion_point(message_implements:OSMPBF.Way)
			WayOrBuilder {
		
		/**
		 * Instantiates a new way.
		 */
		private Way() {
			keys_ = emptyIntList();
			vals_ = emptyIntList();
			refs_ = emptyLongList();
			lat_ = emptyLongList();
			lon_ = emptyLongList();
		}

		/** The bit field 0. */
		private int bitField0_;
		
		/** The Constant ID_FIELD_NUMBER. */
		public static final int ID_FIELD_NUMBER = 1;
		
		/** The id. */
		private long id_;

		/**
		 * <code>required int64 id = 1;</code>
		 */
		@java.lang.Override
		public boolean hasId() {
			return (bitField0_ & 0x00000001) == 0x00000001;
		}

		/**
		 * <code>required int64 id = 1;</code>
		 */
		@java.lang.Override
		public long getId() {
			return id_;
		}

		/**
		 * <code>required int64 id = 1;</code>.
		 *
		 * @param value the new id
		 */
		private void setId(final long value) {
			bitField0_ |= 0x00000001;
			id_ = value;
		}

		/**
		 * <code>required int64 id = 1;</code>.
		 */
		private void clearId() {
			bitField0_ = bitField0_ & ~0x00000001;
			id_ = 0L;
		}

		/** The Constant KEYS_FIELD_NUMBER. */
		public static final int KEYS_FIELD_NUMBER = 2;
		
		/** The keys. */
		private com.google.protobuf.Internal.IntList keys_;

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 *
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Integer> getKeysList() {
			return keys_;
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 *
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 */
		@java.lang.Override
		public int getKeysCount() {
			return keys_.size();
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 *
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 */
		@java.lang.Override
		public int getKeys(final int index) {
			return keys_.getInt(index);
		}

		/** The keys memoized serialized size. */
		private int keysMemoizedSerializedSize = -1;

		/**
		 * Ensure keys is mutable.
		 */
		private void ensureKeysIsMutable() {
			if (!keys_.isModifiable()) {
				keys_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(keys_);
			}
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setKeys(final int index, final int value) {
			ensureKeysIsMutable();
			keys_.setInt(index, value);
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @param value the value
		 */
		private void addKeys(final int value) {
			ensureKeysIsMutable();
			keys_.addInt(value);
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @param values the values
		 */
		private void addAllKeys(final java.lang.Iterable<? extends java.lang.Integer> values) {
			ensureKeysIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, keys_);
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 *
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 */
		private void clearKeys() {
			keys_ = emptyIntList();
		}

		/** The Constant VALS_FIELD_NUMBER. */
		public static final int VALS_FIELD_NUMBER = 3;
		
		/** The vals. */
		private com.google.protobuf.Internal.IntList vals_;

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Integer> getValsList() {
			return vals_;
		}

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 */
		@java.lang.Override
		public int getValsCount() {
			return vals_.size();
		}

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 */
		@java.lang.Override
		public int getVals(final int index) {
			return vals_.getInt(index);
		}

		/** The vals memoized serialized size. */
		private int valsMemoizedSerializedSize = -1;

		/**
		 * Ensure vals is mutable.
		 */
		private void ensureValsIsMutable() {
			if (!vals_.isModifiable()) {
				vals_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(vals_);
			}
		}

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setVals(final int index, final int value) {
			ensureValsIsMutable();
			vals_.setInt(index, value);
		}

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addVals(final int value) {
			ensureValsIsMutable();
			vals_.addInt(value);
		}

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllVals(final java.lang.Iterable<? extends java.lang.Integer> values) {
			ensureValsIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, vals_);
		}

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 */
		private void clearVals() {
			vals_ = emptyIntList();
		}

		/** The Constant INFO_FIELD_NUMBER. */
		public static final int INFO_FIELD_NUMBER = 4;
		
		/** The info. */
		private Info info_;

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 */
		@java.lang.Override
		public boolean hasInfo() {
			return (bitField0_ & 0x00000002) == 0x00000002;
		}

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 */
		@java.lang.Override
		public Info getInfo() {
			return info_ == null ? Info.getDefaultInstance() : info_;
		}

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @param value the new info
		 */
		private void setInfo(final Info value) {
			if (value == null) { throw new NullPointerException(); }
			info_ = value;
			bitField0_ |= 0x00000002;
		}

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @param builderForValue the new info
		 */
		private void setInfo(final Info.Builder builderForValue) {
			info_ = builderForValue.build();
			bitField0_ |= 0x00000002;
		}

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @param value the value
		 */
		private void mergeInfo(final Info value) {
			if (value == null) { throw new NullPointerException(); }
			if (info_ != null && info_ != Info.getDefaultInstance()) {
				info_ = Info.newBuilder(info_).mergeFrom(value).buildPartial();
			} else {
				info_ = value;
			}
			bitField0_ |= 0x00000002;
		}

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 */
		private void clearInfo() {
			info_ = null;
			bitField0_ = bitField0_ & ~0x00000002;
		}

		/** The Constant REFS_FIELD_NUMBER. */
		public static final int REFS_FIELD_NUMBER = 8;
		
		/** The refs. */
		private com.google.protobuf.Internal.LongList refs_;

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 refs = 8 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Long> getRefsList() {
			return refs_;
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 refs = 8 [packed = true];</code>
		 */
		@java.lang.Override
		public int getRefsCount() {
			return refs_.size();
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 *
		 * <code>repeated sint64 refs = 8 [packed = true];</code>
		 */
		@java.lang.Override
		public long getRefs(final int index) {
			return refs_.getLong(index);
		}

		/** The refs memoized serialized size. */
		private int refsMemoizedSerializedSize = -1;

		/**
		 * Ensure refs is mutable.
		 */
		private void ensureRefsIsMutable() {
			if (!refs_.isModifiable()) {
				refs_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(refs_);
			}
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 refs = 8 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setRefs(final int index, final long value) {
			ensureRefsIsMutable();
			refs_.setLong(index, value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 refs = 8 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addRefs(final long value) {
			ensureRefsIsMutable();
			refs_.addLong(value);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 refs = 8 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllRefs(final java.lang.Iterable<? extends java.lang.Long> values) {
			ensureRefsIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, refs_);
		}

		/**
		 * <pre>
		 * DELTA coded
		 * </pre>
		 * 
		 * <code>repeated sint64 refs = 8 [packed = true];</code>.
		 */
		private void clearRefs() {
			refs_ = emptyLongList();
		}

		/** The Constant LAT_FIELD_NUMBER. */
		public static final int LAT_FIELD_NUMBER = 9;
		
		/** The lat. */
		private com.google.protobuf.Internal.LongList lat_;

		/**
		 * <code>repeated sint64 lat = 9 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Long> getLatList() {
			return lat_;
		}

		/**
		 * <code>repeated sint64 lat = 9 [packed = true];</code>
		 */
		@java.lang.Override
		public int getLatCount() {
			return lat_.size();
		}

		/**
		 * <code>repeated sint64 lat = 9 [packed = true];</code>
		 */
		@java.lang.Override
		public long getLat(final int index) {
			return lat_.getLong(index);
		}

		/** The lat memoized serialized size. */
		private int latMemoizedSerializedSize = -1;

		/**
		 * Ensure lat is mutable.
		 */
		private void ensureLatIsMutable() {
			if (!lat_.isModifiable()) {
				lat_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(lat_);
			}
		}

		/**
		 * <code>repeated sint64 lat = 9 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setLat(final int index, final long value) {
			ensureLatIsMutable();
			lat_.setLong(index, value);
		}

		/**
		 * <code>repeated sint64 lat = 9 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addLat(final long value) {
			ensureLatIsMutable();
			lat_.addLong(value);
		}

		/**
		 * <code>repeated sint64 lat = 9 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllLat(final java.lang.Iterable<? extends java.lang.Long> values) {
			ensureLatIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, lat_);
		}

		/**
		 * <code>repeated sint64 lat = 9 [packed = true];</code>.
		 */
		private void clearLat() {
			lat_ = emptyLongList();
		}

		/** The Constant LON_FIELD_NUMBER. */
		public static final int LON_FIELD_NUMBER = 10;
		
		/** The lon. */
		private com.google.protobuf.Internal.LongList lon_;

		/**
		 * <code>repeated sint64 lon = 10 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Long> getLonList() {
			return lon_;
		}

		/**
		 * <code>repeated sint64 lon = 10 [packed = true];</code>
		 */
		@java.lang.Override
		public int getLonCount() {
			return lon_.size();
		}

		/**
		 * <code>repeated sint64 lon = 10 [packed = true];</code>
		 */
		@java.lang.Override
		public long getLon(final int index) {
			return lon_.getLong(index);
		}

		/** The lon memoized serialized size. */
		private int lonMemoizedSerializedSize = -1;

		/**
		 * Ensure lon is mutable.
		 */
		private void ensureLonIsMutable() {
			if (!lon_.isModifiable()) {
				lon_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(lon_);
			}
		}

		/**
		 * <code>repeated sint64 lon = 10 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setLon(final int index, final long value) {
			ensureLonIsMutable();
			lon_.setLong(index, value);
		}

		/**
		 * <code>repeated sint64 lon = 10 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addLon(final long value) {
			ensureLonIsMutable();
			lon_.addLong(value);
		}

		/**
		 * <code>repeated sint64 lon = 10 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllLon(final java.lang.Iterable<? extends java.lang.Long> values) {
			ensureLonIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, lon_);
		}

		/**
		 * <code>repeated sint64 lon = 10 [packed = true];</code>.
		 */
		private void clearLon() {
			lon_ = emptyLongList();
		}

		@java.lang.Override
		public void writeTo(final com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
			getSerializedSize();
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				output.writeInt64(1, id_);
			}
			if (getKeysList().size() > 0) {
				output.writeUInt32NoTag(18);
				output.writeUInt32NoTag(keysMemoizedSerializedSize);
			}
			for (int i = 0; i < keys_.size(); i++) {
				output.writeUInt32NoTag(keys_.getInt(i));
			}
			if (getValsList().size() > 0) {
				output.writeUInt32NoTag(26);
				output.writeUInt32NoTag(valsMemoizedSerializedSize);
			}
			for (int i = 0; i < vals_.size(); i++) {
				output.writeUInt32NoTag(vals_.getInt(i));
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				output.writeMessage(4, getInfo());
			}
			if (getRefsList().size() > 0) {
				output.writeUInt32NoTag(66);
				output.writeUInt32NoTag(refsMemoizedSerializedSize);
			}
			for (int i = 0; i < refs_.size(); i++) {
				output.writeSInt64NoTag(refs_.getLong(i));
			}
			if (getLatList().size() > 0) {
				output.writeUInt32NoTag(74);
				output.writeUInt32NoTag(latMemoizedSerializedSize);
			}
			for (int i = 0; i < lat_.size(); i++) {
				output.writeSInt64NoTag(lat_.getLong(i));
			}
			if (getLonList().size() > 0) {
				output.writeUInt32NoTag(82);
				output.writeUInt32NoTag(lonMemoizedSerializedSize);
			}
			for (int i = 0; i < lon_.size(); i++) {
				output.writeSInt64NoTag(lon_.getLong(i));
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSerializedSize;
			if (size != -1) { return size; }

			size = 0;
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, id_);
			}
			{
				int dataSize = 0;
				for (int i = 0; i < keys_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(keys_.getInt(i));
				}
				size += dataSize;
				if (!getKeysList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				keysMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				for (int i = 0; i < vals_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(vals_.getInt(i));
				}
				size += dataSize;
				if (!getValsList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				valsMemoizedSerializedSize = dataSize;
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				size += com.google.protobuf.CodedOutputStream.computeMessageSize(4, getInfo());
			}
			{
				int dataSize = 0;
				for (int i = 0; i < refs_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeSInt64SizeNoTag(refs_.getLong(i));
				}
				size += dataSize;
				if (!getRefsList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				refsMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				for (int i = 0; i < lat_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeSInt64SizeNoTag(lat_.getLong(i));
				}
				size += dataSize;
				if (!getLatList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				latMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				for (int i = 0; i < lon_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeSInt64SizeNoTag(lon_.getLong(i));
				}
				size += dataSize;
				if (!getLonList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				lonMemoizedSerializedSize = dataSize;
			}
			size += unknownFields.getSerializedSize();
			memoizedSerializedSize = size;
			return size;
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the way
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Way parseFrom(final java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the way
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Way parseFrom(final java.nio.ByteBuffer data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the way
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Way parseFrom(final com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the way
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Way parseFrom(final com.google.protobuf.ByteString data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the way
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Way parseFrom(final byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the way
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Way parseFrom(final byte[] data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the way
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Way parseFrom(final java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the way
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Way parseFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @return the way
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Way parseDelimitedFrom(final java.io.InputStream input) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the way
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Way parseDelimitedFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the way
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Way parseFrom(final com.google.protobuf.CodedInputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the way
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Way parseFrom(final com.google.protobuf.CodedInputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * New builder.
		 *
		 * @return the builder
		 */
		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.newBuilder();
		}

		/**
		 * New builder.
		 *
		 * @param prototype the prototype
		 * @return the builder
		 */
		public static Builder newBuilder(final Way prototype) {
			return DEFAULT_INSTANCE.newBuilder(prototype);
		}

		/**
		 * Protobuf type {@code OSMPBF.Way}
		 */
		public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<Way, Builder>
				implements
				// @@protoc_insertion_point(builder_implements:OSMPBF.Way)
				WayOrBuilder {
			
			/**
			 * Instantiates a new builder.
			 */
			// Construct using Way.newBuilder()
			private Builder() {
				super(DEFAULT_INSTANCE);
			}

			/**
			 * <code>required int64 id = 1;</code>
			 */
			@java.lang.Override
			public boolean hasId() {
				return instance.hasId();
			}

			/**
			 * <code>required int64 id = 1;</code>
			 */
			@java.lang.Override
			public long getId() {
				return instance.getId();
			}

			/**
			 * <code>required int64 id = 1;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setId(final long value) {
				copyOnWrite();
				instance.setId(value);
				return this;
			}

			/**
			 * <code>required int64 id = 1;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearId() {
				copyOnWrite();
				instance.clearId();
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 *
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Integer> getKeysList() {
				return java.util.Collections.unmodifiableList(instance.getKeysList());
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 *
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 */
			@java.lang.Override
			public int getKeysCount() {
				return instance.getKeysCount();
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 *
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 */
			@java.lang.Override
			public int getKeys(final int index) {
				return instance.getKeys(index);
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 * 
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setKeys(final int index, final int value) {
				copyOnWrite();
				instance.setKeys(index, value);
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 * 
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addKeys(final int value) {
				copyOnWrite();
				instance.addKeys(value);
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 * 
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllKeys(final java.lang.Iterable<? extends java.lang.Integer> values) {
				copyOnWrite();
				instance.addAllKeys(values);
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 * 
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 *
			 * @return the builder
			 */
			public Builder clearKeys() {
				copyOnWrite();
				instance.clearKeys();
				return this;
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Integer> getValsList() {
				return java.util.Collections.unmodifiableList(instance.getValsList());
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>
			 */
			@java.lang.Override
			public int getValsCount() {
				return instance.getValsCount();
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>
			 */
			@java.lang.Override
			public int getVals(final int index) {
				return instance.getVals(index);
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setVals(final int index, final int value) {
				copyOnWrite();
				instance.setVals(index, value);
				return this;
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addVals(final int value) {
				copyOnWrite();
				instance.addVals(value);
				return this;
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllVals(final java.lang.Iterable<? extends java.lang.Integer> values) {
				copyOnWrite();
				instance.addAllVals(values);
				return this;
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearVals() {
				copyOnWrite();
				instance.clearVals();
				return this;
			}

			/**
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 */
			@java.lang.Override
			public boolean hasInfo() {
				return instance.hasInfo();
			}

			/**
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 */
			@java.lang.Override
			public Info getInfo() {
				return instance.getInfo();
			}

			/**
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setInfo(final Info value) {
				copyOnWrite();
				instance.setInfo(value);
				return this;
			}

			/**
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 *
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder setInfo(final Info.Builder builderForValue) {
				copyOnWrite();
				instance.setInfo(builderForValue);
				return this;
			}

			/**
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder mergeInfo(final Info value) {
				copyOnWrite();
				instance.mergeInfo(value);
				return this;
			}

			/**
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 *
			 * @return the builder
			 */
			public Builder clearInfo() {
				copyOnWrite();
				instance.clearInfo();
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 refs = 8 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Long> getRefsList() {
				return java.util.Collections.unmodifiableList(instance.getRefsList());
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 refs = 8 [packed = true];</code>
			 */
			@java.lang.Override
			public int getRefsCount() {
				return instance.getRefsCount();
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 *
			 * <code>repeated sint64 refs = 8 [packed = true];</code>
			 */
			@java.lang.Override
			public long getRefs(final int index) {
				return instance.getRefs(index);
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 refs = 8 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setRefs(final int index, final long value) {
				copyOnWrite();
				instance.setRefs(index, value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 refs = 8 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addRefs(final long value) {
				copyOnWrite();
				instance.addRefs(value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 refs = 8 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllRefs(final java.lang.Iterable<? extends java.lang.Long> values) {
				copyOnWrite();
				instance.addAllRefs(values);
				return this;
			}

			/**
			 * <pre>
			 * DELTA coded
			 * </pre>
			 * 
			 * <code>repeated sint64 refs = 8 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearRefs() {
				copyOnWrite();
				instance.clearRefs();
				return this;
			}

			/**
			 * <code>repeated sint64 lat = 9 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Long> getLatList() {
				return java.util.Collections.unmodifiableList(instance.getLatList());
			}

			/**
			 * <code>repeated sint64 lat = 9 [packed = true];</code>
			 */
			@java.lang.Override
			public int getLatCount() {
				return instance.getLatCount();
			}

			/**
			 * <code>repeated sint64 lat = 9 [packed = true];</code>
			 */
			@java.lang.Override
			public long getLat(final int index) {
				return instance.getLat(index);
			}

			/**
			 * <code>repeated sint64 lat = 9 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setLat(final int index, final long value) {
				copyOnWrite();
				instance.setLat(index, value);
				return this;
			}

			/**
			 * <code>repeated sint64 lat = 9 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addLat(final long value) {
				copyOnWrite();
				instance.addLat(value);
				return this;
			}

			/**
			 * <code>repeated sint64 lat = 9 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllLat(final java.lang.Iterable<? extends java.lang.Long> values) {
				copyOnWrite();
				instance.addAllLat(values);
				return this;
			}

			/**
			 * <code>repeated sint64 lat = 9 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearLat() {
				copyOnWrite();
				instance.clearLat();
				return this;
			}

			/**
			 * <code>repeated sint64 lon = 10 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Long> getLonList() {
				return java.util.Collections.unmodifiableList(instance.getLonList());
			}

			/**
			 * <code>repeated sint64 lon = 10 [packed = true];</code>
			 */
			@java.lang.Override
			public int getLonCount() {
				return instance.getLonCount();
			}

			/**
			 * <code>repeated sint64 lon = 10 [packed = true];</code>
			 */
			@java.lang.Override
			public long getLon(final int index) {
				return instance.getLon(index);
			}

			/**
			 * <code>repeated sint64 lon = 10 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setLon(final int index, final long value) {
				copyOnWrite();
				instance.setLon(index, value);
				return this;
			}

			/**
			 * <code>repeated sint64 lon = 10 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addLon(final long value) {
				copyOnWrite();
				instance.addLon(value);
				return this;
			}

			/**
			 * <code>repeated sint64 lon = 10 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllLon(final java.lang.Iterable<? extends java.lang.Long> values) {
				copyOnWrite();
				instance.addAllLon(values);
				return this;
			}

			/**
			 * <code>repeated sint64 lon = 10 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearLon() {
				copyOnWrite();
				instance.clearLon();
				return this;
			}

			// @@protoc_insertion_point(builder_scope:OSMPBF.Way)
		}

		/** The memoized is initialized. */
		private byte memoizedIsInitialized = 2;

		@java.lang.Override
		@java.lang.SuppressWarnings ({ "unchecked", "fallthrough" })
		protected java.lang.Object dynamicMethod(final com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
				final java.lang.Object arg0, final java.lang.Object arg1) {
			switch (method) {
				case NEW_MUTABLE_INSTANCE: {
					return new Way();
				}
				case NEW_BUILDER: {
					return new Builder();
				}
				case IS_INITIALIZED: {
					final byte isInitialized = memoizedIsInitialized;
					if (isInitialized == 1) { return DEFAULT_INSTANCE; }
					if (isInitialized == 0) { return null; }

					if (!hasId()) { return null; }
					return DEFAULT_INSTANCE;

				}
				case MAKE_IMMUTABLE: {
					keys_.makeImmutable();
					vals_.makeImmutable();
					refs_.makeImmutable();
					lat_.makeImmutable();
					lon_.makeImmutable();
					return null;
				}
				case VISIT: {
					final Visitor visitor = (Visitor) arg0;
					final Way other = (Way) arg1;
					id_ = visitor.visitLong(hasId(), id_, other.hasId(), other.id_);
					keys_ = visitor.visitIntList(keys_, other.keys_);
					vals_ = visitor.visitIntList(vals_, other.vals_);
					info_ = visitor.visitMessage(info_, other.info_);
					refs_ = visitor.visitLongList(refs_, other.refs_);
					lat_ = visitor.visitLongList(lat_, other.lat_);
					lon_ = visitor.visitLongList(lon_, other.lon_);
					if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
						bitField0_ |= other.bitField0_;
					}
					return this;
				}
				case MERGE_FROM_STREAM: {
					final com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
					final com.google.protobuf.ExtensionRegistryLite extensionRegistry =
							(com.google.protobuf.ExtensionRegistryLite) arg1;
					if (extensionRegistry == null) { throw new java.lang.NullPointerException(); }
					try {
						boolean done = false;
						while (!done) {
							final int tag = input.readTag();
							switch (tag) {
								case 0:
									done = true;
									break;
								case 8: {
									bitField0_ |= 0x00000001;
									id_ = input.readInt64();
									break;
								}
								case 16: {
									if (!keys_.isModifiable()) {
										keys_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(keys_);
									}
									keys_.addInt(input.readUInt32());
									break;
								}
								case 18: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!keys_.isModifiable() && input.getBytesUntilLimit() > 0) {
										keys_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(keys_);
									}
									while (input.getBytesUntilLimit() > 0) {
										keys_.addInt(input.readUInt32());
									}
									input.popLimit(limit);
									break;
								}
								case 24: {
									if (!vals_.isModifiable()) {
										vals_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(vals_);
									}
									vals_.addInt(input.readUInt32());
									break;
								}
								case 26: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!vals_.isModifiable() && input.getBytesUntilLimit() > 0) {
										vals_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(vals_);
									}
									while (input.getBytesUntilLimit() > 0) {
										vals_.addInt(input.readUInt32());
									}
									input.popLimit(limit);
									break;
								}
								case 34: {
									Info.Builder subBuilder = null;
									if ((bitField0_ & 0x00000002) == 0x00000002) {
										subBuilder = info_.toBuilder();
									}
									info_ = input.readMessage(Info.parser(), extensionRegistry);
									if (subBuilder != null) {
										subBuilder.mergeFrom(info_);
										info_ = subBuilder.buildPartial();
									}
									bitField0_ |= 0x00000002;
									break;
								}
								case 64: {
									if (!refs_.isModifiable()) {
										refs_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(refs_);
									}
									refs_.addLong(input.readSInt64());
									break;
								}
								case 66: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!refs_.isModifiable() && input.getBytesUntilLimit() > 0) {
										refs_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(refs_);
									}
									while (input.getBytesUntilLimit() > 0) {
										refs_.addLong(input.readSInt64());
									}
									input.popLimit(limit);
									break;
								}
								case 72: {
									if (!lat_.isModifiable()) {
										lat_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(lat_);
									}
									lat_.addLong(input.readSInt64());
									break;
								}
								case 74: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!lat_.isModifiable() && input.getBytesUntilLimit() > 0) {
										lat_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(lat_);
									}
									while (input.getBytesUntilLimit() > 0) {
										lat_.addLong(input.readSInt64());
									}
									input.popLimit(limit);
									break;
								}
								case 80: {
									if (!lon_.isModifiable()) {
										lon_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(lon_);
									}
									lon_.addLong(input.readSInt64());
									break;
								}
								case 82: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!lon_.isModifiable() && input.getBytesUntilLimit() > 0) {
										lon_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(lon_);
									}
									while (input.getBytesUntilLimit() > 0) {
										lon_.addLong(input.readSInt64());
									}
									input.popLimit(limit);
									break;
								}
								default: {
									if (!parseUnknownField(tag, input)) {
										done = true;
									}
									break;
								}
							}
						}
					} catch (final com.google.protobuf.InvalidProtocolBufferException e) {
						throw new RuntimeException(e.setUnfinishedMessage(this));
					} catch (final java.io.IOException e) {
						throw new RuntimeException(
								new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
										.setUnfinishedMessage(this));
					} finally {}
				}
				// fall through
				case GET_DEFAULT_INSTANCE: {
					return DEFAULT_INSTANCE;
				}
				case GET_PARSER: {
					com.google.protobuf.Parser<Way> parser = PARSER;
					if (parser == null) {
						synchronized (Way.class) {
							parser = PARSER;
							if (parser == null) {
								parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
								PARSER = parser;
							}
						}
					}
					return parser;
				}
				case GET_MEMOIZED_IS_INITIALIZED: {
					return memoizedIsInitialized;
				}
				case SET_MEMOIZED_IS_INITIALIZED: {
					memoizedIsInitialized = (byte) (arg0 == null ? 0 : 1);
					return null;
				}
			}
			throw new UnsupportedOperationException();
		}

		/** The Constant DEFAULT_INSTANCE. */
		// @@protoc_insertion_point(class_scope:OSMPBF.Way)
		private static final Way DEFAULT_INSTANCE;
		static {
			// New instances are implicitly immutable so no need to make
			// immutable.
			DEFAULT_INSTANCE = new Way();
		}

		/**
		 * Gets the default instance.
		 *
		 * @return the default instance
		 */
		public static Way getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		/** The parser. */
		private static volatile com.google.protobuf.Parser<Way> PARSER;

		/**
		 * Parser.
		 *
		 * @return the com.google.protobuf. parser
		 */
		public static com.google.protobuf.Parser<Way> parser() {
			return DEFAULT_INSTANCE.getParserForType();
		}
	}

	/**
	 * The Interface RelationOrBuilder.
	 */
	public interface RelationOrBuilder extends
			// @@protoc_insertion_point(interface_extends:OSMPBF.Relation)
			com.google.protobuf.MessageLiteOrBuilder {

		/**
		 * <code>required int64 id = 1;</code>.
		 *
		 * @return true, if successful
		 */
		boolean hasId();

		/**
		 * <code>required int64 id = 1;</code>.
		 *
		 * @return the id
		 */
		long getId();

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @return the keys list
		 */
		java.util.List<java.lang.Integer> getKeysList();

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @return the keys count
		 */
		int getKeysCount();

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @param index the index
		 * @return the keys
		 */
		int getKeys(int index);

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 *
		 * @return the vals list
		 */
		java.util.List<java.lang.Integer> getValsList();

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 *
		 * @return the vals count
		 */
		int getValsCount();

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the vals
		 */
		int getVals(int index);

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @return true, if successful
		 */
		boolean hasInfo();

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @return the info
		 */
		Info getInfo();

		/**
		 * <pre>
		 * Parallel arrays
		 * </pre>
		 * 
		 * <code>repeated int32 roles_sid = 8 [packed = true];</code>.
		 *
		 * @return the roles sid list
		 */
		java.util.List<java.lang.Integer> getRolesSidList();

		/**
		 * <pre>
		 * Parallel arrays
		 * </pre>
		 * 
		 * <code>repeated int32 roles_sid = 8 [packed = true];</code>.
		 *
		 * @return the roles sid count
		 */
		int getRolesSidCount();

		/**
		 * <pre>
		 * Parallel arrays
		 * </pre>
		 * 
		 * <code>repeated int32 roles_sid = 8 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the roles sid
		 */
		int getRolesSid(int index);

		/**
		 * <pre>
		 * DELTA encoded
		 * </pre>
		 * 
		 * <code>repeated sint64 memids = 9 [packed = true];</code>.
		 *
		 * @return the memids list
		 */
		java.util.List<java.lang.Long> getMemidsList();

		/**
		 * <pre>
		 * DELTA encoded
		 * </pre>
		 * 
		 * <code>repeated sint64 memids = 9 [packed = true];</code>.
		 *
		 * @return the memids count
		 */
		int getMemidsCount();

		/**
		 * <pre>
		 * DELTA encoded
		 * </pre>
		 * 
		 * <code>repeated sint64 memids = 9 [packed = true];</code>.
		 *
		 * @param index the index
		 * @return the memids
		 */
		long getMemids(int index);

		/**
		 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
		 *
		 * @return the types list
		 */
		java.util.List<Relation.MemberType> getTypesList();

		/**
		 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
		 *
		 * @return the types count
		 */
		int getTypesCount();

		/**
		 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
		 *
		 * @param index the index
		 * @return the types
		 */
		Relation.MemberType getTypes(int index);
	}

	/**
	 * Protobuf type {@code OSMPBF.Relation}
	 */
	public static final class Relation extends com.google.protobuf.GeneratedMessageLite<Relation, Relation.Builder>
			implements
			// @@protoc_insertion_point(message_implements:OSMPBF.Relation)
			RelationOrBuilder {
		
		/**
		 * Instantiates a new relation.
		 */
		private Relation() {
			keys_ = emptyIntList();
			vals_ = emptyIntList();
			rolesSid_ = emptyIntList();
			memids_ = emptyLongList();
			types_ = emptyIntList();
		}

		/**
		 * Protobuf enum {@code OSMPBF.Relation.MemberType}
		 */
		public enum MemberType implements com.google.protobuf.Internal.EnumLite {
			
			/** <code>NODE = 0;</code>. */
			NODE(0),
			
			/** <code>WAY = 1;</code>. */
			WAY(1),
			
			/** <code>RELATION = 2;</code>. */
			RELATION(2),;

			/** <code>NODE = 0;</code>. */
			public static final int NODE_VALUE = 0;
			
			/** <code>WAY = 1;</code>. */
			public static final int WAY_VALUE = 1;
			
			/** <code>RELATION = 2;</code>. */
			public static final int RELATION_VALUE = 2;

			@java.lang.Override
			public int getNumber() {
				return value;
			}

			/**
			 * Value of.
			 *
			 * @param value the value
			 * @return the member type
			 * @deprecated Use {@link #forNumber(int)} instead.
			 */
			@Deprecated
			public static MemberType valueOf(final int value) {
				return forNumber(value);
			}

			/**
			 * For number.
			 *
			 * @param value the value
			 * @return the member type
			 */
			public static MemberType forNumber(final int value) {
				switch (value) {
					case 0:
						return NODE;
					case 1:
						return WAY;
					case 2:
						return RELATION;
					default:
						return null;
				}
			}

			/**
			 * Internal get value map.
			 *
			 * @return the com.google.protobuf. internal. enum lite map
			 */
			public static com.google.protobuf.Internal.EnumLiteMap<MemberType> internalGetValueMap() {
				return internalValueMap;
			}

			/** The Constant internalValueMap. */
			private static final com.google.protobuf.Internal.EnumLiteMap<MemberType> internalValueMap =
					number -> MemberType.forNumber(number);

			/** The value. */
			private final int value;

			/**
			 * Instantiates a new member type.
			 *
			 * @param value the value
			 */
			private MemberType(final int value) {
				this.value = value;
			}

			// @@protoc_insertion_point(enum_scope:OSMPBF.Relation.MemberType)
		}

		/** The bit field 0. */
		private int bitField0_;
		
		/** The Constant ID_FIELD_NUMBER. */
		public static final int ID_FIELD_NUMBER = 1;
		
		/** The id. */
		private long id_;

		/**
		 * <code>required int64 id = 1;</code>
		 */
		@java.lang.Override
		public boolean hasId() {
			return (bitField0_ & 0x00000001) == 0x00000001;
		}

		/**
		 * <code>required int64 id = 1;</code>
		 */
		@java.lang.Override
		public long getId() {
			return id_;
		}

		/**
		 * <code>required int64 id = 1;</code>.
		 *
		 * @param value the new id
		 */
		private void setId(final long value) {
			bitField0_ |= 0x00000001;
			id_ = value;
		}

		/**
		 * <code>required int64 id = 1;</code>.
		 */
		private void clearId() {
			bitField0_ = bitField0_ & ~0x00000001;
			id_ = 0L;
		}

		/** The Constant KEYS_FIELD_NUMBER. */
		public static final int KEYS_FIELD_NUMBER = 2;
		
		/** The keys. */
		private com.google.protobuf.Internal.IntList keys_;

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 *
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Integer> getKeysList() {
			return keys_;
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 *
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 */
		@java.lang.Override
		public int getKeysCount() {
			return keys_.size();
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 *
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 */
		@java.lang.Override
		public int getKeys(final int index) {
			return keys_.getInt(index);
		}

		/** The keys memoized serialized size. */
		private int keysMemoizedSerializedSize = -1;

		/**
		 * Ensure keys is mutable.
		 */
		private void ensureKeysIsMutable() {
			if (!keys_.isModifiable()) {
				keys_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(keys_);
			}
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setKeys(final int index, final int value) {
			ensureKeysIsMutable();
			keys_.setInt(index, value);
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @param value the value
		 */
		private void addKeys(final int value) {
			ensureKeysIsMutable();
			keys_.addInt(value);
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 * 
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 *
		 * @param values the values
		 */
		private void addAllKeys(final java.lang.Iterable<? extends java.lang.Integer> values) {
			ensureKeysIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, keys_);
		}

		/**
		 * <pre>
		 * Parallel arrays.
		 * </pre>
		 *
		 * <code>repeated uint32 keys = 2 [packed = true];</code>
		 */
		private void clearKeys() {
			keys_ = emptyIntList();
		}

		/** The Constant VALS_FIELD_NUMBER. */
		public static final int VALS_FIELD_NUMBER = 3;
		
		/** The vals. */
		private com.google.protobuf.Internal.IntList vals_;

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Integer> getValsList() {
			return vals_;
		}

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 */
		@java.lang.Override
		public int getValsCount() {
			return vals_.size();
		}

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>
		 */
		@java.lang.Override
		public int getVals(final int index) {
			return vals_.getInt(index);
		}

		/** The vals memoized serialized size. */
		private int valsMemoizedSerializedSize = -1;

		/**
		 * Ensure vals is mutable.
		 */
		private void ensureValsIsMutable() {
			if (!vals_.isModifiable()) {
				vals_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(vals_);
			}
		}

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setVals(final int index, final int value) {
			ensureValsIsMutable();
			vals_.setInt(index, value);
		}

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addVals(final int value) {
			ensureValsIsMutable();
			vals_.addInt(value);
		}

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllVals(final java.lang.Iterable<? extends java.lang.Integer> values) {
			ensureValsIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, vals_);
		}

		/**
		 * <code>repeated uint32 vals = 3 [packed = true];</code>.
		 */
		private void clearVals() {
			vals_ = emptyIntList();
		}

		/** The Constant INFO_FIELD_NUMBER. */
		public static final int INFO_FIELD_NUMBER = 4;
		
		/** The info. */
		private Info info_;

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 */
		@java.lang.Override
		public boolean hasInfo() {
			return (bitField0_ & 0x00000002) == 0x00000002;
		}

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 */
		@java.lang.Override
		public Info getInfo() {
			return info_ == null ? Info.getDefaultInstance() : info_;
		}

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @param value the new info
		 */
		private void setInfo(final Info value) {
			if (value == null) { throw new NullPointerException(); }
			info_ = value;
			bitField0_ |= 0x00000002;
		}

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @param builderForValue the new info
		 */
		private void setInfo(final Info.Builder builderForValue) {
			info_ = builderForValue.build();
			bitField0_ |= 0x00000002;
		}

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 *
		 * @param value the value
		 */
		private void mergeInfo(final Info value) {
			if (value == null) { throw new NullPointerException(); }
			if (info_ != null && info_ != Info.getDefaultInstance()) {
				info_ = Info.newBuilder(info_).mergeFrom(value).buildPartial();
			} else {
				info_ = value;
			}
			bitField0_ |= 0x00000002;
		}

		/**
		 * <code>optional .OSMPBF.Info info = 4;</code>
		 */
		private void clearInfo() {
			info_ = null;
			bitField0_ = bitField0_ & ~0x00000002;
		}

		/** The Constant ROLES_SID_FIELD_NUMBER. */
		public static final int ROLES_SID_FIELD_NUMBER = 8;
		
		/** The roles sid. */
		private com.google.protobuf.Internal.IntList rolesSid_;

		/**
		 * <pre>
		 * Parallel arrays
		 * </pre>
		 *
		 * <code>repeated int32 roles_sid = 8 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Integer> getRolesSidList() {
			return rolesSid_;
		}

		/**
		 * <pre>
		 * Parallel arrays
		 * </pre>
		 *
		 * <code>repeated int32 roles_sid = 8 [packed = true];</code>
		 */
		@java.lang.Override
		public int getRolesSidCount() {
			return rolesSid_.size();
		}

		/**
		 * <pre>
		 * Parallel arrays
		 * </pre>
		 *
		 * <code>repeated int32 roles_sid = 8 [packed = true];</code>
		 */
		@java.lang.Override
		public int getRolesSid(final int index) {
			return rolesSid_.getInt(index);
		}

		/** The roles sid memoized serialized size. */
		private int rolesSidMemoizedSerializedSize = -1;

		/**
		 * Ensure roles sid is mutable.
		 */
		private void ensureRolesSidIsMutable() {
			if (!rolesSid_.isModifiable()) {
				rolesSid_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(rolesSid_);
			}
		}

		/**
		 * <pre>
		 * Parallel arrays
		 * </pre>
		 * 
		 * <code>repeated int32 roles_sid = 8 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setRolesSid(final int index, final int value) {
			ensureRolesSidIsMutable();
			rolesSid_.setInt(index, value);
		}

		/**
		 * <pre>
		 * Parallel arrays
		 * </pre>
		 * 
		 * <code>repeated int32 roles_sid = 8 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addRolesSid(final int value) {
			ensureRolesSidIsMutable();
			rolesSid_.addInt(value);
		}

		/**
		 * <pre>
		 * Parallel arrays
		 * </pre>
		 * 
		 * <code>repeated int32 roles_sid = 8 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllRolesSid(final java.lang.Iterable<? extends java.lang.Integer> values) {
			ensureRolesSidIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, rolesSid_);
		}

		/**
		 * <pre>
		 * Parallel arrays
		 * </pre>
		 * 
		 * <code>repeated int32 roles_sid = 8 [packed = true];</code>.
		 */
		private void clearRolesSid() {
			rolesSid_ = emptyIntList();
		}

		/** The Constant MEMIDS_FIELD_NUMBER. */
		public static final int MEMIDS_FIELD_NUMBER = 9;
		
		/** The memids. */
		private com.google.protobuf.Internal.LongList memids_;

		/**
		 * <pre>
		 * DELTA encoded
		 * </pre>
		 *
		 * <code>repeated sint64 memids = 9 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<java.lang.Long> getMemidsList() {
			return memids_;
		}

		/**
		 * <pre>
		 * DELTA encoded
		 * </pre>
		 *
		 * <code>repeated sint64 memids = 9 [packed = true];</code>
		 */
		@java.lang.Override
		public int getMemidsCount() {
			return memids_.size();
		}

		/**
		 * <pre>
		 * DELTA encoded
		 * </pre>
		 *
		 * <code>repeated sint64 memids = 9 [packed = true];</code>
		 */
		@java.lang.Override
		public long getMemids(final int index) {
			return memids_.getLong(index);
		}

		/** The memids memoized serialized size. */
		private int memidsMemoizedSerializedSize = -1;

		/**
		 * Ensure memids is mutable.
		 */
		private void ensureMemidsIsMutable() {
			if (!memids_.isModifiable()) {
				memids_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(memids_);
			}
		}

		/**
		 * <pre>
		 * DELTA encoded
		 * </pre>
		 * 
		 * <code>repeated sint64 memids = 9 [packed = true];</code>.
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setMemids(final int index, final long value) {
			ensureMemidsIsMutable();
			memids_.setLong(index, value);
		}

		/**
		 * <pre>
		 * DELTA encoded
		 * </pre>
		 * 
		 * <code>repeated sint64 memids = 9 [packed = true];</code>.
		 *
		 * @param value the value
		 */
		private void addMemids(final long value) {
			ensureMemidsIsMutable();
			memids_.addLong(value);
		}

		/**
		 * <pre>
		 * DELTA encoded
		 * </pre>
		 * 
		 * <code>repeated sint64 memids = 9 [packed = true];</code>.
		 *
		 * @param values the values
		 */
		private void addAllMemids(final java.lang.Iterable<? extends java.lang.Long> values) {
			ensureMemidsIsMutable();
			com.google.protobuf.AbstractMessageLite.addAll(values, memids_);
		}

		/**
		 * <pre>
		 * DELTA encoded
		 * </pre>
		 * 
		 * <code>repeated sint64 memids = 9 [packed = true];</code>.
		 */
		private void clearMemids() {
			memids_ = emptyLongList();
		}

		/** The Constant TYPES_FIELD_NUMBER. */
		public static final int TYPES_FIELD_NUMBER = 10;
		
		/** The types. */
		private com.google.protobuf.Internal.IntList types_;
		
		/** The Constant types_converter_. */
		private static final com.google.protobuf.Internal.ListAdapter.Converter<java.lang.Integer, Relation.MemberType> types_converter_ =
				from -> {
					final Relation.MemberType result = Relation.MemberType.forNumber(from);
					return result == null ? Relation.MemberType.NODE : result;
				};

		/**
		 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
		 */
		@java.lang.Override
		public java.util.List<Relation.MemberType> getTypesList() {
			return new com.google.protobuf.Internal.ListAdapter<>(types_, types_converter_);
		}

		/**
		 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
		 */
		@java.lang.Override
		public int getTypesCount() {
			return types_.size();
		}

		/**
		 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
		 */
		@java.lang.Override
		public Relation.MemberType getTypes(final int index) {
			return types_converter_.convert(types_.getInt(index));
		}

		/** The types memoized serialized size. */
		private int typesMemoizedSerializedSize;

		/**
		 * Ensure types is mutable.
		 */
		private void ensureTypesIsMutable() {
			if (!types_.isModifiable()) {
				types_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(types_);
			}
		}

		/**
		 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
		 *
		 * @param index the index
		 * @param value the value
		 */
		private void setTypes(final int index, final Relation.MemberType value) {
			if (value == null) { throw new NullPointerException(); }
			ensureTypesIsMutable();
			types_.setInt(index, value.getNumber());
		}

		/**
		 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
		 *
		 * @param value the value
		 */
		private void addTypes(final Relation.MemberType value) {
			if (value == null) { throw new NullPointerException(); }
			ensureTypesIsMutable();
			types_.addInt(value.getNumber());
		}

		/**
		 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
		 *
		 * @param values the values
		 */
		private void addAllTypes(final java.lang.Iterable<? extends Relation.MemberType> values) {
			ensureTypesIsMutable();
			for (final Relation.MemberType value : values) {
				types_.addInt(value.getNumber());
			}
		}

		/**
		 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
		 */
		private void clearTypes() {
			types_ = emptyIntList();
		}

		@java.lang.Override
		public void writeTo(final com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
			getSerializedSize();
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				output.writeInt64(1, id_);
			}
			if (getKeysList().size() > 0) {
				output.writeUInt32NoTag(18);
				output.writeUInt32NoTag(keysMemoizedSerializedSize);
			}
			for (int i = 0; i < keys_.size(); i++) {
				output.writeUInt32NoTag(keys_.getInt(i));
			}
			if (getValsList().size() > 0) {
				output.writeUInt32NoTag(26);
				output.writeUInt32NoTag(valsMemoizedSerializedSize);
			}
			for (int i = 0; i < vals_.size(); i++) {
				output.writeUInt32NoTag(vals_.getInt(i));
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				output.writeMessage(4, getInfo());
			}
			if (getRolesSidList().size() > 0) {
				output.writeUInt32NoTag(66);
				output.writeUInt32NoTag(rolesSidMemoizedSerializedSize);
			}
			for (int i = 0; i < rolesSid_.size(); i++) {
				output.writeInt32NoTag(rolesSid_.getInt(i));
			}
			if (getMemidsList().size() > 0) {
				output.writeUInt32NoTag(74);
				output.writeUInt32NoTag(memidsMemoizedSerializedSize);
			}
			for (int i = 0; i < memids_.size(); i++) {
				output.writeSInt64NoTag(memids_.getLong(i));
			}
			if (getTypesList().size() > 0) {
				output.writeUInt32NoTag(82);
				output.writeUInt32NoTag(typesMemoizedSerializedSize);
			}
			for (int i = 0; i < types_.size(); i++) {
				output.writeEnumNoTag(types_.getInt(i));
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSerializedSize;
			if (size != -1) { return size; }

			size = 0;
			if ((bitField0_ & 0x00000001) == 0x00000001) {
				size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, id_);
			}
			{
				int dataSize = 0;
				for (int i = 0; i < keys_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(keys_.getInt(i));
				}
				size += dataSize;
				if (!getKeysList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				keysMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				for (int i = 0; i < vals_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(vals_.getInt(i));
				}
				size += dataSize;
				if (!getValsList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				valsMemoizedSerializedSize = dataSize;
			}
			if ((bitField0_ & 0x00000002) == 0x00000002) {
				size += com.google.protobuf.CodedOutputStream.computeMessageSize(4, getInfo());
			}
			{
				int dataSize = 0;
				for (int i = 0; i < rolesSid_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(rolesSid_.getInt(i));
				}
				size += dataSize;
				if (!getRolesSidList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				rolesSidMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				for (int i = 0; i < memids_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeSInt64SizeNoTag(memids_.getLong(i));
				}
				size += dataSize;
				if (!getMemidsList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
				}
				memidsMemoizedSerializedSize = dataSize;
			}
			{
				int dataSize = 0;
				for (int i = 0; i < types_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeEnumSizeNoTag(types_.getInt(i));
				}
				size += dataSize;
				if (!getTypesList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(dataSize);
				}
				typesMemoizedSerializedSize = dataSize;
			}
			size += unknownFields.getSerializedSize();
			memoizedSerializedSize = size;
			return size;
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the relation
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Relation parseFrom(final java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the relation
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Relation parseFrom(final java.nio.ByteBuffer data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the relation
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Relation parseFrom(final com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the relation
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Relation parseFrom(final com.google.protobuf.ByteString data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @return the relation
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Relation parseFrom(final byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
		}

		/**
		 * Parses the from.
		 *
		 * @param data the data
		 * @param extensionRegistry the extension registry
		 * @return the relation
		 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
		 */
		public static Relation parseFrom(final byte[] data,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the relation
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Relation parseFrom(final java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the relation
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Relation parseFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @return the relation
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Relation parseDelimitedFrom(final java.io.InputStream input) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the delimited from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the relation
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Relation parseDelimitedFrom(final java.io.InputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @return the relation
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Relation parseFrom(final com.google.protobuf.CodedInputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
		}

		/**
		 * Parses the from.
		 *
		 * @param input the input
		 * @param extensionRegistry the extension registry
		 * @return the relation
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public static Relation parseFrom(final com.google.protobuf.CodedInputStream input,
				final com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
		}

		/**
		 * New builder.
		 *
		 * @return the builder
		 */
		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.newBuilder();
		}

		/**
		 * New builder.
		 *
		 * @param prototype the prototype
		 * @return the builder
		 */
		public static Builder newBuilder(final Relation prototype) {
			return DEFAULT_INSTANCE.newBuilder(prototype);
		}

		/**
		 * Protobuf type {@code OSMPBF.Relation}
		 */
		public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<Relation, Builder>
				implements
				// @@protoc_insertion_point(builder_implements:OSMPBF.Relation)
				RelationOrBuilder {
			
			/**
			 * Instantiates a new builder.
			 */
			// Construct using Relation.newBuilder()
			private Builder() {
				super(DEFAULT_INSTANCE);
			}

			/**
			 * <code>required int64 id = 1;</code>
			 */
			@java.lang.Override
			public boolean hasId() {
				return instance.hasId();
			}

			/**
			 * <code>required int64 id = 1;</code>
			 */
			@java.lang.Override
			public long getId() {
				return instance.getId();
			}

			/**
			 * <code>required int64 id = 1;</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setId(final long value) {
				copyOnWrite();
				instance.setId(value);
				return this;
			}

			/**
			 * <code>required int64 id = 1;</code>.
			 *
			 * @return the builder
			 */
			public Builder clearId() {
				copyOnWrite();
				instance.clearId();
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 *
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Integer> getKeysList() {
				return java.util.Collections.unmodifiableList(instance.getKeysList());
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 *
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 */
			@java.lang.Override
			public int getKeysCount() {
				return instance.getKeysCount();
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 *
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 */
			@java.lang.Override
			public int getKeys(final int index) {
				return instance.getKeys(index);
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 * 
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setKeys(final int index, final int value) {
				copyOnWrite();
				instance.setKeys(index, value);
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 * 
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addKeys(final int value) {
				copyOnWrite();
				instance.addKeys(value);
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 * 
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllKeys(final java.lang.Iterable<? extends java.lang.Integer> values) {
				copyOnWrite();
				instance.addAllKeys(values);
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays.
			 * </pre>
			 * 
			 * <code>repeated uint32 keys = 2 [packed = true];</code>
			 *
			 * @return the builder
			 */
			public Builder clearKeys() {
				copyOnWrite();
				instance.clearKeys();
				return this;
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Integer> getValsList() {
				return java.util.Collections.unmodifiableList(instance.getValsList());
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>
			 */
			@java.lang.Override
			public int getValsCount() {
				return instance.getValsCount();
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>
			 */
			@java.lang.Override
			public int getVals(final int index) {
				return instance.getVals(index);
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setVals(final int index, final int value) {
				copyOnWrite();
				instance.setVals(index, value);
				return this;
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addVals(final int value) {
				copyOnWrite();
				instance.addVals(value);
				return this;
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllVals(final java.lang.Iterable<? extends java.lang.Integer> values) {
				copyOnWrite();
				instance.addAllVals(values);
				return this;
			}

			/**
			 * <code>repeated uint32 vals = 3 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearVals() {
				copyOnWrite();
				instance.clearVals();
				return this;
			}

			/**
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 */
			@java.lang.Override
			public boolean hasInfo() {
				return instance.hasInfo();
			}

			/**
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 */
			@java.lang.Override
			public Info getInfo() {
				return instance.getInfo();
			}

			/**
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder setInfo(final Info value) {
				copyOnWrite();
				instance.setInfo(value);
				return this;
			}

			/**
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 *
			 * @param builderForValue the builder for value
			 * @return the builder
			 */
			public Builder setInfo(final Info.Builder builderForValue) {
				copyOnWrite();
				instance.setInfo(builderForValue);
				return this;
			}

			/**
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder mergeInfo(final Info value) {
				copyOnWrite();
				instance.mergeInfo(value);
				return this;
			}

			/**
			 * <code>optional .OSMPBF.Info info = 4;</code>
			 *
			 * @return the builder
			 */
			public Builder clearInfo() {
				copyOnWrite();
				instance.clearInfo();
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays
			 * </pre>
			 *
			 * <code>repeated int32 roles_sid = 8 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Integer> getRolesSidList() {
				return java.util.Collections.unmodifiableList(instance.getRolesSidList());
			}

			/**
			 * <pre>
			 * Parallel arrays
			 * </pre>
			 *
			 * <code>repeated int32 roles_sid = 8 [packed = true];</code>
			 */
			@java.lang.Override
			public int getRolesSidCount() {
				return instance.getRolesSidCount();
			}

			/**
			 * <pre>
			 * Parallel arrays
			 * </pre>
			 *
			 * <code>repeated int32 roles_sid = 8 [packed = true];</code>
			 */
			@java.lang.Override
			public int getRolesSid(final int index) {
				return instance.getRolesSid(index);
			}

			/**
			 * <pre>
			 * Parallel arrays
			 * </pre>
			 * 
			 * <code>repeated int32 roles_sid = 8 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setRolesSid(final int index, final int value) {
				copyOnWrite();
				instance.setRolesSid(index, value);
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays
			 * </pre>
			 * 
			 * <code>repeated int32 roles_sid = 8 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addRolesSid(final int value) {
				copyOnWrite();
				instance.addRolesSid(value);
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays
			 * </pre>
			 * 
			 * <code>repeated int32 roles_sid = 8 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllRolesSid(final java.lang.Iterable<? extends java.lang.Integer> values) {
				copyOnWrite();
				instance.addAllRolesSid(values);
				return this;
			}

			/**
			 * <pre>
			 * Parallel arrays
			 * </pre>
			 * 
			 * <code>repeated int32 roles_sid = 8 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearRolesSid() {
				copyOnWrite();
				instance.clearRolesSid();
				return this;
			}

			/**
			 * <pre>
			 * DELTA encoded
			 * </pre>
			 *
			 * <code>repeated sint64 memids = 9 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<java.lang.Long> getMemidsList() {
				return java.util.Collections.unmodifiableList(instance.getMemidsList());
			}

			/**
			 * <pre>
			 * DELTA encoded
			 * </pre>
			 *
			 * <code>repeated sint64 memids = 9 [packed = true];</code>
			 */
			@java.lang.Override
			public int getMemidsCount() {
				return instance.getMemidsCount();
			}

			/**
			 * <pre>
			 * DELTA encoded
			 * </pre>
			 *
			 * <code>repeated sint64 memids = 9 [packed = true];</code>
			 */
			@java.lang.Override
			public long getMemids(final int index) {
				return instance.getMemids(index);
			}

			/**
			 * <pre>
			 * DELTA encoded
			 * </pre>
			 * 
			 * <code>repeated sint64 memids = 9 [packed = true];</code>.
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setMemids(final int index, final long value) {
				copyOnWrite();
				instance.setMemids(index, value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA encoded
			 * </pre>
			 * 
			 * <code>repeated sint64 memids = 9 [packed = true];</code>.
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addMemids(final long value) {
				copyOnWrite();
				instance.addMemids(value);
				return this;
			}

			/**
			 * <pre>
			 * DELTA encoded
			 * </pre>
			 * 
			 * <code>repeated sint64 memids = 9 [packed = true];</code>.
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllMemids(final java.lang.Iterable<? extends java.lang.Long> values) {
				copyOnWrite();
				instance.addAllMemids(values);
				return this;
			}

			/**
			 * <pre>
			 * DELTA encoded
			 * </pre>
			 * 
			 * <code>repeated sint64 memids = 9 [packed = true];</code>.
			 *
			 * @return the builder
			 */
			public Builder clearMemids() {
				copyOnWrite();
				instance.clearMemids();
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
			 */
			@java.lang.Override
			public java.util.List<Relation.MemberType> getTypesList() {
				return instance.getTypesList();
			}

			/**
			 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
			 */
			@java.lang.Override
			public int getTypesCount() {
				return instance.getTypesCount();
			}

			/**
			 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
			 */
			@java.lang.Override
			public Relation.MemberType getTypes(final int index) {
				return instance.getTypes(index);
			}

			/**
			 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
			 *
			 * @param index the index
			 * @param value the value
			 * @return the builder
			 */
			public Builder setTypes(final int index, final Relation.MemberType value) {
				copyOnWrite();
				instance.setTypes(index, value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
			 *
			 * @param value the value
			 * @return the builder
			 */
			public Builder addTypes(final Relation.MemberType value) {
				copyOnWrite();
				instance.addTypes(value);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
			 *
			 * @param values the values
			 * @return the builder
			 */
			public Builder addAllTypes(final java.lang.Iterable<? extends Relation.MemberType> values) {
				copyOnWrite();
				instance.addAllTypes(values);
				return this;
			}

			/**
			 * <code>repeated .OSMPBF.Relation.MemberType types = 10 [packed = true];</code>
			 *
			 * @return the builder
			 */
			public Builder clearTypes() {
				copyOnWrite();
				instance.clearTypes();
				return this;
			}

			// @@protoc_insertion_point(builder_scope:OSMPBF.Relation)
		}

		/** The memoized is initialized. */
		private byte memoizedIsInitialized = 2;

		@java.lang.Override
		@java.lang.SuppressWarnings ({ "unchecked", "fallthrough" })
		protected java.lang.Object dynamicMethod(final com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
				final java.lang.Object arg0, final java.lang.Object arg1) {
			switch (method) {
				case NEW_MUTABLE_INSTANCE: {
					return new Relation();
				}
				case NEW_BUILDER: {
					return new Builder();
				}
				case IS_INITIALIZED: {
					final byte isInitialized = memoizedIsInitialized;
					if (isInitialized == 1) { return DEFAULT_INSTANCE; }
					if (isInitialized == 0) { return null; }

					if (!hasId()) { return null; }
					return DEFAULT_INSTANCE;

				}
				case MAKE_IMMUTABLE: {
					keys_.makeImmutable();
					vals_.makeImmutable();
					rolesSid_.makeImmutable();
					memids_.makeImmutable();
					types_.makeImmutable();
					return null;
				}
				case VISIT: {
					final Visitor visitor = (Visitor) arg0;
					final Relation other = (Relation) arg1;
					id_ = visitor.visitLong(hasId(), id_, other.hasId(), other.id_);
					keys_ = visitor.visitIntList(keys_, other.keys_);
					vals_ = visitor.visitIntList(vals_, other.vals_);
					info_ = visitor.visitMessage(info_, other.info_);
					rolesSid_ = visitor.visitIntList(rolesSid_, other.rolesSid_);
					memids_ = visitor.visitLongList(memids_, other.memids_);
					types_ = visitor.visitIntList(types_, other.types_);
					if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
						bitField0_ |= other.bitField0_;
					}
					return this;
				}
				case MERGE_FROM_STREAM: {
					final com.google.protobuf.CodedInputStream input = (com.google.protobuf.CodedInputStream) arg0;
					final com.google.protobuf.ExtensionRegistryLite extensionRegistry =
							(com.google.protobuf.ExtensionRegistryLite) arg1;
					if (extensionRegistry == null) { throw new java.lang.NullPointerException(); }
					try {
						boolean done = false;
						while (!done) {
							final int tag = input.readTag();
							switch (tag) {
								case 0:
									done = true;
									break;
								case 8: {
									bitField0_ |= 0x00000001;
									id_ = input.readInt64();
									break;
								}
								case 16: {
									if (!keys_.isModifiable()) {
										keys_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(keys_);
									}
									keys_.addInt(input.readUInt32());
									break;
								}
								case 18: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!keys_.isModifiable() && input.getBytesUntilLimit() > 0) {
										keys_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(keys_);
									}
									while (input.getBytesUntilLimit() > 0) {
										keys_.addInt(input.readUInt32());
									}
									input.popLimit(limit);
									break;
								}
								case 24: {
									if (!vals_.isModifiable()) {
										vals_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(vals_);
									}
									vals_.addInt(input.readUInt32());
									break;
								}
								case 26: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!vals_.isModifiable() && input.getBytesUntilLimit() > 0) {
										vals_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(vals_);
									}
									while (input.getBytesUntilLimit() > 0) {
										vals_.addInt(input.readUInt32());
									}
									input.popLimit(limit);
									break;
								}
								case 34: {
									Info.Builder subBuilder = null;
									if ((bitField0_ & 0x00000002) == 0x00000002) {
										subBuilder = info_.toBuilder();
									}
									info_ = input.readMessage(Info.parser(), extensionRegistry);
									if (subBuilder != null) {
										subBuilder.mergeFrom(info_);
										info_ = subBuilder.buildPartial();
									}
									bitField0_ |= 0x00000002;
									break;
								}
								case 64: {
									if (!rolesSid_.isModifiable()) {
										rolesSid_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(rolesSid_);
									}
									rolesSid_.addInt(input.readInt32());
									break;
								}
								case 66: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!rolesSid_.isModifiable() && input.getBytesUntilLimit() > 0) {
										rolesSid_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(rolesSid_);
									}
									while (input.getBytesUntilLimit() > 0) {
										rolesSid_.addInt(input.readInt32());
									}
									input.popLimit(limit);
									break;
								}
								case 72: {
									if (!memids_.isModifiable()) {
										memids_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(memids_);
									}
									memids_.addLong(input.readSInt64());
									break;
								}
								case 74: {
									final int length = input.readRawVarint32();
									final int limit = input.pushLimit(length);
									if (!memids_.isModifiable() && input.getBytesUntilLimit() > 0) {
										memids_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(memids_);
									}
									while (input.getBytesUntilLimit() > 0) {
										memids_.addLong(input.readSInt64());
									}
									input.popLimit(limit);
									break;
								}
								case 80: {
									if (!types_.isModifiable()) {
										types_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(types_);
									}
									final int rawValue = input.readEnum();
									final Relation.MemberType value = Relation.MemberType.forNumber(rawValue);
									if (value == null) {
										super.mergeVarintField(10, rawValue);
									} else {
										types_.addInt(rawValue);
									}
									break;
								}
								case 82: {
									if (!types_.isModifiable()) {
										types_ = com.google.protobuf.GeneratedMessageLite.mutableCopy(types_);
									}
									final int length = input.readRawVarint32();
									final int oldLimit = input.pushLimit(length);
									while (input.getBytesUntilLimit() > 0) {
										final int rawValue = input.readEnum();
										final Relation.MemberType value = Relation.MemberType.forNumber(rawValue);
										if (value == null) {
											super.mergeVarintField(10, rawValue);
										} else {
											types_.addInt(rawValue);
										}
									}
									input.popLimit(oldLimit);
									break;
								}
								default: {
									if (!parseUnknownField(tag, input)) {
										done = true;
									}
									break;
								}
							}
						}
					} catch (final com.google.protobuf.InvalidProtocolBufferException e) {
						throw new RuntimeException(e.setUnfinishedMessage(this));
					} catch (final java.io.IOException e) {
						throw new RuntimeException(
								new com.google.protobuf.InvalidProtocolBufferException(e.getMessage())
										.setUnfinishedMessage(this));
					} finally {}
				}
				// fall through
				case GET_DEFAULT_INSTANCE: {
					return DEFAULT_INSTANCE;
				}
				case GET_PARSER: {
					com.google.protobuf.Parser<Relation> parser = PARSER;
					if (parser == null) {
						synchronized (Relation.class) {
							parser = PARSER;
							if (parser == null) {
								parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
								PARSER = parser;
							}
						}
					}
					return parser;
				}
				case GET_MEMOIZED_IS_INITIALIZED: {
					return memoizedIsInitialized;
				}
				case SET_MEMOIZED_IS_INITIALIZED: {
					memoizedIsInitialized = (byte) (arg0 == null ? 0 : 1);
					return null;
				}
			}
			throw new UnsupportedOperationException();
		}

		/** The Constant DEFAULT_INSTANCE. */
		// @@protoc_insertion_point(class_scope:OSMPBF.Relation)
		private static final Relation DEFAULT_INSTANCE;
		static {
			// New instances are implicitly immutable so no need to make
			// immutable.
			DEFAULT_INSTANCE = new Relation();
		}

		/**
		 * Gets the default instance.
		 *
		 * @return the default instance
		 */
		public static Relation getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		/** The parser. */
		private static volatile com.google.protobuf.Parser<Relation> PARSER;

		/**
		 * Parser.
		 *
		 * @return the com.google.protobuf. parser
		 */
		public static com.google.protobuf.Parser<Relation> parser() {
			return DEFAULT_INSTANCE.getParserForType();
		}
	}

	static {}

	// @@protoc_insertion_point(outer_class_scope)
}
