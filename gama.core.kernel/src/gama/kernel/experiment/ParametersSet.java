/*******************************************************************************************************
 *
 * ParametersSet.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.experiment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.file.GamaFile;

/**
 * The Class ParametersSet.
 */
@SuppressWarnings({ "rawtypes" })
public class ParametersSet extends HashMap<String, Object> {

	/**
	 * Instantiates a new parameters set.
	 */
	public ParametersSet() {
	}

	/**
	 * Instantiates a new parameters set.
	 *
	 * @param solution the solution
	 */
	public ParametersSet(final ParametersSet solution) {
		this.putAll(solution);
	}

	/**
	 * Instantiates a new parameters set.
	 *
	 * @param scope the scope
	 * @param variables the variables
	 * @param reinit the reinit
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public ParametersSet(final IScope scope, final Map<String, IParameter> variables, final boolean reinit)
			throws GamaRuntimeException {

		for (final String var : variables.keySet()) {
			final IParameter varBat = variables.get(var);
			if (reinit && varBat instanceof IParameter.Batch) {
				((IParameter.Batch) varBat).reinitRandomly(scope);
			}
			put(var, varBat.value(scope));
		}

	}

	/**
	 * Instantiates a new parameters set.
	 *
	 * @param scope the scope
	 * @param parameters the parameters
	 * @param reinit the reinit
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public ParametersSet(final IScope scope, final Collection<? extends IParameter> parameters, final boolean reinit)
			throws GamaRuntimeException {
		for (final IParameter p : parameters) {
			if (reinit && p instanceof IParameter.Batch) {
				((IParameter.Batch) p).reinitRandomly(scope);
			}
			put(p.getName(), p.value(scope));
		}
	}

	@Override
	public Object put(final String s, final Object o) {
		// Special case for files as they are not invariant. Their contents must
		// be invalidated before they are loaded
		// again in a simulation. See Issue 812.
		if (o instanceof GamaFile) {
			((GamaFile) o).invalidateContents();
		}
		return super.put(s, o);
	}

}
