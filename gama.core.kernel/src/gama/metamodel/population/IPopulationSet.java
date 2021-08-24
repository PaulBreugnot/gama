/*******************************************************************************************************
 *
 * IPopulationSet.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.metamodel.population;

import java.util.Collection;

import gama.metamodel.agent.IAgent;
import gama.metamodel.topology.filter.IAgentFilter;
import gama.runtime.IScope;
import gama.util.IContainer;
import one.util.streamex.StreamEx;

/**
 * Class IPopulationSet. An interface common to ISpecies, IPopulation and
 * MetaPopulation
 *
 * @author drogoul
 * @param <T> the generic type
 * @since 9 déc. 2013
 */
public interface IPopulationSet<T extends IAgent> extends IContainer<Integer, T>, IAgentFilter {

	/**
	 * Gets the populations.
	 *
	 * @param scope the scope
	 * @return the populations
	 */
	Collection<? extends IPopulation<? extends IAgent>> getPopulations(IScope scope);

	/**
	 * Stream.
	 *
	 * @param scope the scope
	 * @return the stream ex
	 */
	@Override
	StreamEx<T> stream(final IScope scope);

}
