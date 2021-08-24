/*******************************************************************************************************
 *
 * TagElementProcessor.java, in gama.ext.libs, is part of the source code of the
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
 * Provides an element processor implementation for a tag.
 *
 * @author Brett Henderson
 */
public class TagElementProcessor extends BaseElementProcessor {
	
	/** The Constant ATTRIBUTE_NAME_KEY. */
	private static final String ATTRIBUTE_NAME_KEY = "k";
	
	/** The Constant ATTRIBUTE_NAME_VALUE. */
	private static final String ATTRIBUTE_NAME_VALUE = "v";

	/** The tag listener. */
	private final TagListener tagListener;
	
	/** The tag. */
	private Tag tag;

	/**
	 * Creates a new instance.
	 *
	 * @param parentProcessor
	 *            The parent element processor.
	 * @param tagListener
	 *            The tag listener for receiving created tags.
	 */
	public TagElementProcessor(final BaseElementProcessor parentProcessor, final TagListener tagListener) {
		super(parentProcessor, true);

		this.tagListener = tagListener;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void begin(final Attributes attributes) {
		String key;
		String value;

		key = attributes.getValue(ATTRIBUTE_NAME_KEY);
		value = attributes.getValue(ATTRIBUTE_NAME_VALUE);

		tag = new Tag(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void end() {
		tagListener.processTag(tag);
		tag = null;
	}
}
