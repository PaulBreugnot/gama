/*******************************************************************************************************
 *
 * XmlTimestampFormat.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

import java.util.Date;

/**
 * A timestamp format implementation for dates read and stored from osm xml files.
 *
 * @author Brett Henderson
 */
public class XmlTimestampFormat extends TimestampFormat {

	/** The date formatter store. */
	private final ThreadLocal<DateFormatter> dateFormatterStore;
	
	/** The date parser store. */
	private final ThreadLocal<DateParser> dateParserStore;

	/**
	 * Creates a new instance.
	 */
	public XmlTimestampFormat() {
		dateFormatterStore = new ThreadLocal<>();
		dateParserStore = new ThreadLocal<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String formatTimestamp(final Date timestamp) {
		DateFormatter dateFormatter;

		dateFormatter = dateFormatterStore.get();
		if (dateFormatter == null) {
			dateFormatter = new DateFormatter();
			dateFormatterStore.set(dateFormatter);
		}

		return dateFormatter.format(timestamp);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date parseTimestamp(final String timestamp) {
		DateParser dateParser;

		dateParser = dateParserStore.get();
		if (dateParser == null) {
			dateParser = new DateParser();
			dateParserStore.set(dateParser);
		}

		return dateParser.parse(timestamp);
	}
}
