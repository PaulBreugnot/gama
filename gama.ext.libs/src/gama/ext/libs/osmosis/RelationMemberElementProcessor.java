/*******************************************************************************************************
 *
 * RelationMemberElementProcessor.java, in gama.ext.libs, is part of the source code of the
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
 * Provides an element processor implementation for a relation member.
 *
 * @author Brett Henderson
 */
public class RelationMemberElementProcessor extends BaseElementProcessor {
	
	/** The Constant ATTRIBUTE_NAME_ID. */
	private static final String ATTRIBUTE_NAME_ID = "ref";
	
	/** The Constant ATTRIBUTE_NAME_TYPE. */
	private static final String ATTRIBUTE_NAME_TYPE = "type";
	
	/** The Constant ATTRIBUTE_NAME_ROLE. */
	private static final String ATTRIBUTE_NAME_ROLE = "role";

	/** The relation member listener. */
	private final RelationMemberListener relationMemberListener;
	
	/** The relation member. */
	private RelationMember relationMember;
	
	/** The member type parser. */
	private final MemberTypeParser memberTypeParser;

	/**
	 * Creates a new instance.
	 *
	 * @param parentProcessor
	 *            The parent element processor.
	 * @param relationMemberListener
	 *            The relation member listener for receiving created tags.
	 */
	public RelationMemberElementProcessor(final BaseElementProcessor parentProcessor,
			final RelationMemberListener relationMemberListener) {
		super(parentProcessor, true);

		this.relationMemberListener = relationMemberListener;

		memberTypeParser = new MemberTypeParser();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void begin(final Attributes attributes) {
		long id;
		EntityType type;
		String role;

		id = Long.parseLong(attributes.getValue(ATTRIBUTE_NAME_ID));
		type = memberTypeParser.parse(attributes.getValue(ATTRIBUTE_NAME_TYPE));
		role = attributes.getValue(ATTRIBUTE_NAME_ROLE);
		if (role == null) {
			role = ""; // this may actually happen
		}

		relationMember = new RelationMember(id, type, role);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void end() {
		relationMemberListener.processRelationMember(relationMember);
		relationMember = null;
	}
}
