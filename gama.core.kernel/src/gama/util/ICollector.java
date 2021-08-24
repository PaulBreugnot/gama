/*******************************************************************************************************
 *
 * ICollector.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util;

import java.io.Closeable;
import java.util.Collection;

import gama.common.util.PoolUtils;
import gama.common.util.RandomUtils;

/**
 * The Interface ICollector.
 *
 * @param <E> the element type
 */
public interface ICollector<E> extends Collection<E>, Closeable {

	/**
	 * Items.
	 *
	 * @return the collection
	 */
	Collection<E> items();

	/**
	 * Close.
	 */
	@Override
	default void close() {
		if (PoolUtils.POOL) { Collector.release(this); }
	}

	/**
	 * Shuffle in place with.
	 *
	 * @param random the random
	 */
	default void shuffleInPlaceWith(final RandomUtils random) {
		random.shuffleInPlace(items());
	}

	/**
	 * Sets the.
	 *
	 * @param c the c
	 */
	void set(final ICollector<?> c);

}