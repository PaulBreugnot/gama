/*******************************************************************************************************
 *
 * Neighborhood1Var.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.ParametersSet;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;

/**
 * The Class Neighborhood1Var.
 */
public class Neighborhood1Var extends Neighborhood {

	/**
	 * Instantiates a new neighborhood 1 var.
	 *
	 * @param variables the variables
	 */
	public Neighborhood1Var(final List<IParameter.Batch> variables) {
		super(variables);
	}

	@Override
	public List<ParametersSet> neighbor(final IScope scope, final ParametersSet solution) throws GamaRuntimeException {
		final List<ParametersSet> neighbors = new ArrayList<ParametersSet>();
		for (final IParameter.Batch var : variables) {
			var.setValue(scope, solution.get(var.getName()));
			final Set<Object> neighborValues = var.neighborValues(scope);
			for (final Object val : neighborValues) {
				final ParametersSet newSol = new ParametersSet(solution);
				newSol.put(var.getName(), val);
				neighbors.add(newSol);
			}
		}
		neighbors.remove(solution);
		return neighbors;
	}
}
