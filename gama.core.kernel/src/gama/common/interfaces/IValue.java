/*******************************************************************************************************
 *
 * IValue.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.interfaces;

import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;

/**
 * Represents a 'value' in GAML (a Java object that can provide a GAML type, be serializable into a GAML expression, and
 * be copied.
 *
 * @author drogoul
 * @since 19 nov. 2008
 */
public interface IValue extends IGamlable, ITyped {

	/**
	 * Returns the string 'value' of this value.
	 *
	 * @param scope            the current GAMA scope
	 * @return a string representing this value (not necessarily its serialization in GAML)
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	String stringValue(IScope scope) throws GamaRuntimeException;

	/**
	 * Returns a copy of this value.
	 *
	 * @param scope            the current GAMA scope
	 * @return a copy of this value. The definition of copy (whether shallow or deep, etc.) depends on the subclasses
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	IValue copy(IScope scope) throws GamaRuntimeException;

}
