/*******************************************************************************************************
 *
 * DifferentList.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.metamodel.topology.filter;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import gama.metamodel.agent.IAgent;
import gama.metamodel.population.IPopulation;
import gama.metamodel.shape.IShape;
import gama.runtime.IScope;
import gama.util.GamaListFactory;
import gama.util.IContainer;
import gama.util.IList;
import gaml.species.ISpecies;

/**
 * The Class DifferentList.
 */
public class DifferentList implements IAgentFilter {

	/** The agents. */
	final Set<IShape> agents;

	/**
	 * Instantiates a new different list.
	 *
	 * @param list the list
	 */
	public DifferentList(final IList<? extends IShape> list) {
		agents = new LinkedHashSet<>(list);
	}

	@Override
	public boolean accept(final IScope scope, final IShape source, final IShape a) {
		return a.getGeometry() != source.getGeometry() && !agents.contains(a);
	}

	@Override
	public IContainer<?, ? extends IAgent> getAgents(final IScope scope) {
		return GamaListFactory.EMPTY_LIST;
	}

	@Override
	public ISpecies getSpecies() {
		return null;
	}

	@Override
	public boolean hasAgentList() {
		return false;
	}

	@Override
	public IPopulation<? extends IAgent> getPopulation(final IScope scope) {
		return null;
	}

	@Override
	public void filter(final IScope scope, final IShape source, final Collection<? extends IShape> results) {
		agents.remove(source);
		results.removeAll(agents);
	}

}
