/*******************************************************************************************************
 *
 * InitializationUniform.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gama.kernel.experiment.IParameter;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;

/**
 * The Class InitializationUniform.
 */
public class InitializationUniform implements Initialization {

	/**
	 * Instantiates a new initialization uniform.
	 */
	public InitializationUniform() {}

	@Override
	public List<Chromosome> initializePop(final IScope scope, final List<IParameter.Batch> variables,
			final GeneticAlgorithm algo) throws GamaRuntimeException {
		final Set<Chromosome> populationInit = new HashSet<>();
		final int nbPrelimGenerations = algo.getNbPrelimGenerations();
		final int populationDim = algo.getPopulationDim();
		for (int i = 0; i < nbPrelimGenerations; i++) {
			for (int j = 0; j < populationDim; j++) {
				populationInit.add(new Chromosome(scope, variables, true));
			}
		}
		for (final Chromosome chromosome : populationInit) {
			algo.computeChroFitness(scope, chromosome);
		}
		final List<Chromosome> populationInitOrd = new ArrayList<>(populationInit);
		Collections.sort(populationInitOrd);
		if (algo.isMaximize) {
			Collections.reverse(populationInitOrd);
		}
		return populationInitOrd.subList(0, populationDim - 1);
	}

}
