/*******************************************************************************************************
 *
 * SourceElementProcessor.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Provides common behaviour across all source element processors.
 *
 * @author Brett Henderson
 */
public abstract class SourceElementProcessor extends BaseElementProcessor {
	
	/** The sink. */
	private final Sink sink;

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
	public SourceElementProcessor(final BaseElementProcessor parentProcessor, final Sink sink,
			final boolean enableDateParsing) {
		super(parentProcessor, enableDateParsing);

		this.sink = sink;
	}

	/**
	 * Gets the sink.
	 *
	 * @return The sink.
	 */
	protected Sink getSink() {
		return sink;
	}
}
