/*******************************************************************************************************
 *
 * Neighborhood.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.List;

import gama.kernel.experiment.*;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;

/**
 * The Class Neighborhood.
 */
public abstract class Neighborhood {

	/** The variables. */
	protected final List<IParameter.Batch> variables;

	/**
	 * Instantiates a new neighborhood.
	 *
	 * @param variables the variables
	 */
	public Neighborhood(final List<IParameter.Batch> variables) {
		this.variables = variables;
	}

	/**
	 * Neighbor.
	 *
	 * @param scope the scope
	 * @param solution the solution
	 * @return the list
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public abstract List<ParametersSet> neighbor(IScope scope, final ParametersSet solution)
		throws GamaRuntimeException;

}
