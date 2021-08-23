/*******************************************************************************************************
 *
 * msi.gama.kernel.batch.Initialization.java, in plugin msi.gama.core, is part of the source code of the GAMA modeling
 * and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.List;

import gama.kernel.experiment.IParameter;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;

public interface Initialization {

	List<Chromosome> initializePop(IScope scope, List<IParameter.Batch> variables, GeneticAlgorithm algo)
			throws GamaRuntimeException;
}
