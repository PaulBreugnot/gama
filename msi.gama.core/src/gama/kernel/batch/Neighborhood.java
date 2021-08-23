/*******************************************************************************************************
 *
 * msi.gama.kernel.batch.Neighborhood.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 * 
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.List;

import gama.kernel.experiment.*;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;

public abstract class Neighborhood {

	protected final List<IParameter.Batch> variables;

	public Neighborhood(final List<IParameter.Batch> variables) {
		this.variables = variables;
	}

	public abstract List<ParametersSet> neighbor(IScope scope, final ParametersSet solution)
		throws GamaRuntimeException;

}
