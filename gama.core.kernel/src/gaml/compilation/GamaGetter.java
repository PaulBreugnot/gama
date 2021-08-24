/*******************************************************************************************************
 *
 * GamaGetter.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compilation;

import gama.runtime.IScope;

/**
 * The Interface GamaGetter.
 *
 * @param <T> the generic type
 */
public interface GamaGetter<T> {
	
	/**
	 * The Interface Unary.
	 *
	 * @param <T> the generic type
	 */
	@FunctionalInterface
	public interface Unary<T> extends GamaGetter<T> {
		
		/**
		 * Gets the.
		 *
		 * @param scope the scope
		 * @param argument the argument
		 * @return the t
		 */
		T get(IScope scope, Object argument);
	}

	/**
	 * The Interface Binary.
	 *
	 * @param <T> the generic type
	 */
	@FunctionalInterface
	public interface Binary<T> extends GamaGetter<T> {
		
		/**
		 * Gets the.
		 *
		 * @param scope the scope
		 * @param argument1 the argument 1
		 * @param argument2 the argument 2
		 * @return the t
		 */
		T get(IScope scope, Object argument1, Object argument2);
	}

	/**
	 * The Interface NAry.
	 *
	 * @param <T> the generic type
	 */
	@FunctionalInterface
	public interface NAry<T> extends GamaGetter<T> {
		
		/**
		 * Gets the.
		 *
		 * @param scope the scope
		 * @param arguments the arguments
		 * @return the t
		 */
		T get(IScope scope, Object... arguments);
	}

}
