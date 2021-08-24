/*******************************************************************************************************
 *
 * Selection.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.List;

import gama.runtime.IScope;

/**
 * The Interface Selection.
 */
public interface Selection {

	/**
	 * Select.
	 *
	 * @param scope the scope
	 * @param population the population
	 * @param populationDim the population dim
	 * @param maximize the maximize
	 * @return the list
	 */
	public List<Chromosome> select(IScope scope, final List<Chromosome> population, final int populationDim,
		boolean maximize);
}
