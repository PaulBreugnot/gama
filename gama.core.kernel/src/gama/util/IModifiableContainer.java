/*******************************************************************************************************
 *
 * IModifiableContainer.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util;

/**
 * Class ModifiableContainer.
 *
 * @author drogoul
 * @param <K> the key type
 * @param <V> the value type
 * @param <KeyToAdd> the generic type
 * @param <ValueToAdd> the generic type
 * @since 24 janv. 2014
 */
public interface IModifiableContainer<K, V, KeyToAdd, ValueToAdd> extends IContainer<K, V>,
	IContainer.Modifiable<KeyToAdd, ValueToAdd> {

}
