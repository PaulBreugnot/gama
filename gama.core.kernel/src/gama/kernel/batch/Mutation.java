/*******************************************************************************************************
 *
 * Mutation.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.List;

import gama.kernel.experiment.IParameter;
import gama.runtime.IScope;

/**
 * The Interface Mutation.
 */
public interface Mutation {

	/**
	 * Mutate.
	 *
	 * @param scope the scope
	 * @param chromosome the chromosome
	 * @param variables the variables
	 * @return the chromosome
	 */
	public Chromosome mutate(IScope scope, Chromosome chromosome, List<IParameter.Batch> variables);

}
