/*******************************************************************************************************
 *
 * CrossOver.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.Set;

import gama.runtime.IScope;

/**
 * The Interface CrossOver.
 */
public interface CrossOver {

	/**
	 * Cross over.
	 *
	 * @param scope the scope
	 * @param parent1 the parent 1
	 * @param parent2 the parent 2
	 * @return the sets the
	 */
	Set<Chromosome> crossOver(IScope scope, final Chromosome parent1, final Chromosome parent2);
}
