/*******************************************************************************************************
 *
 * Different.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.metamodel.topology.filter;

import java.util.Collection;

import gama.metamodel.agent.IAgent;
import gama.metamodel.population.IPopulation;
import gama.metamodel.shape.IShape;
import gama.runtime.IScope;
import gama.util.GamaListFactory;
import gama.util.IContainer;
import gaml.species.ISpecies;

/**
 * The Class Different.
 */
public class Different implements IAgentFilter {

	/** The Constant instance. */
	private static final Different instance = new Different();

	/**
	 * With.
	 *
	 * @return the different
	 */
	public static Different with() {
		return instance;
	}

	@Override
	public boolean accept(final IScope scope, final IShape source, final IShape a) {
		return a.getGeometry() != source.getGeometry();
	}

	/**
	 * @see gama.metamodel.topology.filter.IAgentFilter#getShapes()
	 */
	@Override
	public IContainer<?, ? extends IAgent> getAgents(final IScope scope) {
		return GamaListFactory.EMPTY_LIST;
	}

	@Override
	public ISpecies getSpecies() {
		return null;
	}

	@Override
	public IPopulation<? extends IAgent> getPopulation(final IScope scope) {
		return null;
	}

	@Override
	public boolean hasAgentList() {
		return false;
	}

	/**
	 * Method filter()
	 *
	 * @see gama.metamodel.topology.filter.IAgentFilter#filter(java.util.Collection)
	 */
	@Override
	public void filter(final IScope scope, final IShape source, final Collection<? extends IShape> internal_results) {
		internal_results.remove(source);
	}

}