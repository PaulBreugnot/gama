/*******************************************************************************************************
 *
 * NodeElementProcessor.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

import org.xml.sax.Attributes;

/**
 * Provides an element processor implementation for a node.
 *
 * @author Brett Henderson
 */
public class NodeElementProcessor extends EntityElementProcessor implements TagListener {
	
	/** The Constant ELEMENT_NAME_TAG. */
	private static final String ELEMENT_NAME_TAG = "tag";
	
	/** The Constant ATTRIBUTE_NAME_ID. */
	private static final String ATTRIBUTE_NAME_ID = "id";
	
	/** The Constant ATTRIBUTE_NAME_TIMESTAMP. */
	private static final String ATTRIBUTE_NAME_TIMESTAMP = "timestamp";
	
	/** The Constant ATTRIBUTE_NAME_USER. */
	private static final String ATTRIBUTE_NAME_USER = "user";
	
	/** The Constant ATTRIBUTE_NAME_USERID. */
	private static final String ATTRIBUTE_NAME_USERID = "uid";
	
	/** The Constant ATTRIBUTE_NAME_CHANGESET_ID. */
	private static final String ATTRIBUTE_NAME_CHANGESET_ID = "changeset";
	
	/** The Constant ATTRIBUTE_NAME_VERSION. */
	private static final String ATTRIBUTE_NAME_VERSION = "version";
	
	/** The Constant ATTRIBUTE_NAME_LATITUDE. */
	private static final String ATTRIBUTE_NAME_LATITUDE = "lat";
	
	/** The Constant ATTRIBUTE_NAME_LONGITUDE. */
	private static final String ATTRIBUTE_NAME_LONGITUDE = "lon";

	/** The tag element processor. */
	private final TagElementProcessor tagElementProcessor;
	
	/** The node. */
	private Node node;
	
	/** The coordinates required. */
	private final boolean coordinatesRequired;

	/**
	 * Creates a new instance.
	 *
	 * @param parentProcessor
	 *            The parent of this element processor.
	 * @param sink
	 *            The sink for receiving processed data.
	 * @param enableDateParsing
	 *            If true, dates will be parsed from xml data, else the current date will be used thus saving parsing
	 *            time.
	 */
	public NodeElementProcessor(final BaseElementProcessor parentProcessor, final Sink sink,
			final boolean enableDateParsing) {
		this(parentProcessor, sink, enableDateParsing, true);
	}

	/**
	 * Creates a new instance.
	 *
	 * @param parentProcessor
	 *            The parent of this element processor.
	 * @param sink
	 *            The sink for receiving processed data.
	 * @param enableDateParsing
	 *            If true, dates will be parsed from xml data, else the current date will be used thus saving parsing
	 *            time.
	 * @param coordinatesRequired
	 *            If true, nodes without lat and lon attributes set will cause an exception.
	 */
	public NodeElementProcessor(final BaseElementProcessor parentProcessor, final Sink sink,
			final boolean enableDateParsing, final boolean coordinatesRequired) {
		super(parentProcessor, sink, enableDateParsing);

		this.coordinatesRequired = coordinatesRequired;
		tagElementProcessor = new TagElementProcessor(this, this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void begin(final Attributes attributes) {
		long id;
		String sversion;
		int version;
		TimestampContainer timestampContainer;
		String rawUserId;
		String rawUserName;
		OsmUser user;
		long changesetId;
		double latitude;
		double longitude;

		id = Long.parseLong(attributes.getValue(ATTRIBUTE_NAME_ID));
		sversion = attributes.getValue(ATTRIBUTE_NAME_VERSION);
		if (sversion == null) {
			throw new OsmosisRuntimeException("Node " + id
					+ " does not have a version attribute as OSM 0.6 are required to have.  Is this a 0.5 file?");
		} else {
			version = Integer.parseInt(sversion);
		}
		timestampContainer = createTimestampContainer(attributes.getValue(ATTRIBUTE_NAME_TIMESTAMP));
		rawUserId = attributes.getValue(ATTRIBUTE_NAME_USERID);
		rawUserName = attributes.getValue(ATTRIBUTE_NAME_USER);
		changesetId = buildChangesetId(attributes.getValue(ATTRIBUTE_NAME_CHANGESET_ID));

		latitude = getLatLonDouble(attributes, ATTRIBUTE_NAME_LATITUDE, id);
		longitude = getLatLonDouble(attributes, ATTRIBUTE_NAME_LONGITUDE, id);

		user = buildUser(rawUserId, rawUserName);

		node = new Node(new CommonEntityData(id, version, timestampContainer, user, changesetId), latitude, longitude);
	}

	/**
	 * Retrieves the appropriate child element processor for the newly encountered nested element.
	 *
	 * @param uri
	 *            The element uri.
	 * @param localName
	 *            The element localName.
	 * @param qName
	 *            The element qName.
	 * @return The appropriate element processor for the nested element.
	 */
	@Override
	public ElementProcessor getChild(final String uri, final String localName, final String qName) {
		if (ELEMENT_NAME_TAG.equals(qName)) { return tagElementProcessor; }

		return super.getChild(uri, localName, qName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void end() {
		getSink().process(new NodeContainer(node));
	}

	/**
	 * This is called by child element processors when a tag object is encountered.
	 *
	 * @param tag
	 *            The tag to be processed.
	 */
	@Override
	public void processTag(final Tag tag) {
		node.getTags().add(tag);
	}

	/**
	 * Gets the lat lon double.
	 *
	 * @param attributes the attributes
	 * @param attributeName the attribute name
	 * @param id the id
	 * @return the lat lon double
	 */
	private double getLatLonDouble(final Attributes attributes, final String attributeName, final long id) {
		final String value = attributes.getValue(attributeName);
		if (value == null) {
			if (coordinatesRequired) {
				throw new OsmosisRuntimeException(String.format(
						"Node %s does not have its %s attribute set; this attribute is required in current context.",
						id, attributeName));
			} else {
				return Double.NaN;
			}
		}

		try {
			return Double.parseDouble(value);
		} catch (final NumberFormatException ex) {
			throw new OsmosisRuntimeException(
					String.format("Node %s: cannot parse the %s attribute as a numeric value", id, attributeName));
		}
	}
}
