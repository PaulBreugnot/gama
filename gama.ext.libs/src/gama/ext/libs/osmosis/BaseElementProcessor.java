/*******************************************************************************************************
 *
 * BaseElementProcessor.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

import java.util.Calendar;

/**
 * Provides common functionality shared by element processor implementations.
 *
 * @author Brett Henderson
 */
public abstract class BaseElementProcessor implements ElementProcessor {
	
	/** The parent processor. */
	private final BaseElementProcessor parentProcessor;
	
	/** The dummy child processor. */
	private ElementProcessor dummyChildProcessor;
	
	/** The timestamp format. */
	private TimestampFormat timestampFormat;
	
	/** The dummy timestamp container. */
	private TimestampContainer dummyTimestampContainer;
	
	/** The enable date parsing. */
	private final boolean enableDateParsing;

	/**
	 * Creates a new instance.
	 *
	 * @param parentProcessor
	 *            The parent of this element processor.
	 * @param enableDateParsing
	 *            If true, dates will be parsed from xml data, else the current date will be used thus saving parsing
	 *            time.
	 */
	protected BaseElementProcessor(final BaseElementProcessor parentProcessor, final boolean enableDateParsing) {
		this.parentProcessor = parentProcessor;
		this.enableDateParsing = enableDateParsing;

		if (enableDateParsing) {
			timestampFormat = new XmlTimestampFormat();
		} else {
			Calendar calendar;

			calendar = Calendar.getInstance();
			calendar.set(Calendar.MILLISECOND, 0);
			dummyTimestampContainer = new SimpleTimestampContainer(calendar.getTime());
		}
	}

	/**
	 * This implementation returns a dummy element processor as the child which ignores all nested xml elements.
	 * Sub-classes wishing to handle child elements must override this method and delegate to this method for xml
	 * elements they don't care about.
	 *
	 * @param uri
	 *            The element uri.
	 * @param localName
	 *            The element localName.
	 * @param qName
	 *            The element qName.
	 * @return A dummy element processor.
	 */
	@Override
	public ElementProcessor getChild(final String uri, final String localName, final String qName) {
		if (dummyChildProcessor == null) {
			dummyChildProcessor = new DummyElementProcessor(this);
		}

		return dummyChildProcessor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ElementProcessor getParent() {
		return parentProcessor;
	}

	/**
	 * Parses a date using the standard osm date format.
	 *
	 * @param data
	 *            The date string to be parsed.
	 * @return The parsed date (if dateparsing is enabled).
	 */
	protected TimestampContainer createTimestampContainer(final String data) {
		if (enableDateParsing) {
			return new UnparsedTimestampContainer(timestampFormat, data);
		} else {
			return dummyTimestampContainer;
		}
	}
}
