/*******************************************************************************************************
 *
 * WayNodeElementProcessor.java, in gama.ext.libs, is part of the source code of the
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
 * Provides an element processor implementation for a way node.
 *
 * @author Brett Henderson
 */
public class WayNodeElementProcessor extends BaseElementProcessor {
	
	/** The Constant ATTRIBUTE_NAME_ID. */
	private static final String ATTRIBUTE_NAME_ID = "ref";

	/** The way node listener. */
	private final WayNodeListener wayNodeListener;
	
	/** The way node. */
	private WayNode wayNode;

	/**
	 * Creates a new instance.
	 *
	 * @param parentProcessor
	 *            The parent element processor.
	 * @param wayNodeListener
	 *            The way node listener for receiving created tags.
	 */
	public WayNodeElementProcessor(final BaseElementProcessor parentProcessor, final WayNodeListener wayNodeListener) {
		super(parentProcessor, true);

		this.wayNodeListener = wayNodeListener;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void begin(final Attributes attributes) {
		long id;

		id = Long.parseLong(attributes.getValue(ATTRIBUTE_NAME_ID));

		wayNode = new WayNode(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void end() {
		wayNodeListener.processWayNode(wayNode);
		wayNode = null;
	}
}
