/*******************************************************************************************************
 *
 * BiConsumerWithPruning.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.interfaces;

/**
 * The Interface BiConsumerWithPruning.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public interface BiConsumerWithPruning<K, V> {
	
	/**
	 * Process.
	 *
	 * @param k the k
	 * @param v the v
	 * @return true, if successful
	 */
	boolean process(K k, V v);
}