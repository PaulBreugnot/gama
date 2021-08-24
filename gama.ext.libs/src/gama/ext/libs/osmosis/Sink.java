/*******************************************************************************************************
 *
 * Sink.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

import java.util.Map;

/**
 * Defines the interface for tasks consuming OSM data types.
 *
 * @author Brett Henderson
 */
public interface Sink {

	/**
	 * Process the entity.
	 *
	 * @param entityContainer
	 *            The entity to be processed.
	 */
	void process(EntityContainer entityContainer);

	/**
	 * Initialize.
	 *
	 * @param metaData the meta data
	 */
	void initialize(Map<String, Object> metaData);

	/**
	 * Ensures that all information is fully persisted. This includes database commits, file buffer flushes, etc.
	 * Implementations must call complete on any nested Completable objects. Where the releasable method of a Releasable
	 * class should be called within a finally block, this method should typically be the final statement within the try
	 * block.
	 */
	void complete();
}
