// This software is released into the Public Domain. See copying.txt for details.
package msi.gama.util.file.osm;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX parser factory that additionally verifies that the underlying parser is providing correct unicode support for
 * characters requiring more than 1 UTF-16 character.
 */
public final class SaxParserFactory {

	private SaxParserFactory() {}

	/**
	 * Creates a new SAX parser.
	 *
	 * @return The newly created SAX parser.
	 */
	public static SAXParser createParser() {
		try {
			return SAXParserFactory.newInstance().newSAXParser();

		} catch (final ParserConfigurationException e) {
			throw new OsmosisRuntimeException("Unable to create SAX Parser.", e);
		} catch (final SAXException e) {
			throw new OsmosisRuntimeException("Unable to create SAX Parser.", e);
		}
	}

	/**
	 * Validate SAX parser unicode support.
	 */
	private static void validate() {
		try {
			final UnicodeTestHandler unicodeTestHandler = new UnicodeTestHandler();

			final SAXParser parser = createParser();
			final InputStream is = SaxParserFactory.class.getResourceAsStream("test-unicode-node.osm");
			parser.parse(is, unicodeTestHandler);
			if (!unicodeTestHandler.isCorrect()) {
				throw new OsmosisRuntimeException("SAX Parser doesn't correctly support multi-byte characters,"
						+ " try including a modern version of Xerces on the classpath.");
			}
		} catch (final SAXException e) {
			throw new OsmosisRuntimeException("Unable to create SAX Parser.", e);
		} catch (final IOException e) {
			throw new OsmosisRuntimeException("Unable to read unicode test file.", e);
		}
	}

	static {
		// Trigger validation during class initialisation.
		// validate();
	}

	/**
	 * Looks at the SAX document and validates that the "name" and "name:en" attributes both contain the correct value.
	 */
	private static class UnicodeTestHandler extends DefaultHandler {
		// The expected value of test tags. These escape sequences represent a single treble-clef which requires
		// two 16-bit characters. Represented using escape sequences to prevent accidental munging by dev tools.
		private static final String NAME_VALUE = "H\uD834\uDD1EM Events";
		private boolean nameCorrect;
		private boolean enNameCorrect;

		public UnicodeTestHandler() {
			// TODO Auto-generated constructor stub
		}

		private boolean validateNameValue(final Attributes attributes) {
			return NAME_VALUE.equals(attributes.getValue("v"));
		}

		@Override
		public void startElement(final String uri, final String localName, final String qName,
				final Attributes attributes) throws SAXException {
			if ("tag".equals(qName)) {
				if ("name".equals(attributes.getValue("k"))) {
					if (validateNameValue(attributes)) {
						nameCorrect = true;
					}
				} else if ("name:en".equals(attributes.getValue("k"))) {
					if (validateNameValue(attributes)) {
						enNameCorrect = true;
					}
				}
			}
		}

		/**
		 * Are all fields correct.
		 *
		 * @return True if all correct.
		 */
		public boolean isCorrect() {
			return nameCorrect && enNameCorrect;
		}
	}
}
