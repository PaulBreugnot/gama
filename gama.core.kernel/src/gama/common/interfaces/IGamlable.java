/*******************************************************************************************************
 *
 * IGamlable.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.interfaces;

/**
 * The interface IGamlable. Represents objects that can represent themselves in terms of GAML descriptions
 * (serialization).
 * 
 * @author A. Drogoul
 * @since 13 dec. 2011
 * 
 */
public interface IGamlable {

	/**
	 * Returns the serialization in GAML of this object, taking into account (or not) built-in structures.
	 *
	 * @param includingBuiltIn            whether built-in structures should be part of the serialization in GAML (for instance, built-in
	 *            species within a model)
	 * @return a string that can be reinterpreted in GAML to reproduce the object
	 */
	default String serialize(final boolean includingBuiltIn) {
		return toString();
	}
}
