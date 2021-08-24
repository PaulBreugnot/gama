/*******************************************************************************************************
 *
 * RelationElementProcessor.java, in gama.ext.libs, is part of the source code of the
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
 * Provides an element processor implementation for a relation.
 *
 * @author Brett Henderson
 */
public class RelationElementProcessor extends EntityElementProcessor implements TagListener, RelationMemberListener {
	
	/** The Constant ELEMENT_NAME_TAG. */
	private static final String ELEMENT_NAME_TAG = "tag";
	
	/** The Constant ELEMENT_NAME_MEMBER. */
	private static final String ELEMENT_NAME_MEMBER = "member";
	
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

	/** The tag element processor. */
	private final TagElementProcessor tagElementProcessor;
	
	/** The relation member element processor. */
	private final RelationMemberElementProcessor relationMemberElementProcessor;
	
	/** The relation. */
	private Relation relation;

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
	public RelationElementProcessor(final BaseElementProcessor parentProcessor, final Sink sink,
			final boolean enableDateParsing) {
		super(parentProcessor, sink, enableDateParsing);

		tagElementProcessor = new TagElementProcessor(this, this);
		relationMemberElementProcessor = new RelationMemberElementProcessor(this, this);
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

		id = Long.parseLong(attributes.getValue(ATTRIBUTE_NAME_ID));
		sversion = attributes.getValue(ATTRIBUTE_NAME_VERSION);
		if (sversion == null) {
			throw new OsmosisRuntimeException("Relation " + id
					+ " does not have a version attribute as OSM 0.6 are required to have.  Is this a 0.5 file?");
		} else {
			version = Integer.parseInt(sversion);
		}
		timestampContainer = createTimestampContainer(attributes.getValue(ATTRIBUTE_NAME_TIMESTAMP));
		rawUserId = attributes.getValue(ATTRIBUTE_NAME_USERID);
		rawUserName = attributes.getValue(ATTRIBUTE_NAME_USER);
		changesetId = buildChangesetId(attributes.getValue(ATTRIBUTE_NAME_CHANGESET_ID));

		user = buildUser(rawUserId, rawUserName);

		relation = new Relation(new CommonEntityData(id, version, timestampContainer, user, changesetId));
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
		if (ELEMENT_NAME_MEMBER.equals(qName)) {
			return relationMemberElementProcessor;
		} else if (ELEMENT_NAME_TAG.equals(qName)) { return tagElementProcessor; }

		return super.getChild(uri, localName, qName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void end() {
		getSink().process(new RelationContainer(relation));
	}

	/**
	 * This is called by child element processors when a tag object is encountered.
	 *
	 * @param tag
	 *            The tag to be processed.
	 */
	@Override
	public void processTag(final Tag tag) {
		relation.getTags().add(tag);
	}

	/**
	 * This is called by child element processors when a way node object is encountered.
	 *
	 * @param relationMember
	 *            The wayNode to be processed.
	 */
	public void processRelationMember(final RelationMember relationMember) {
		relation.getMembers().add(relationMember);
	}
}
