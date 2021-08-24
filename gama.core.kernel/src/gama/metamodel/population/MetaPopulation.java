/*******************************************************************************************************
 *
 * MetaPopulation.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.metamodel.population;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Iterables;

import gama.common.interfaces.IValue;
import gama.common.util.RandomUtils;
import gama.common.util.StringUtils;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.Collector;
import gama.util.GamaListFactory;
import gama.util.GamaMapFactory;
import gama.util.IContainer;
import gama.util.IList;
import gama.util.IMap;
import gama.util.matrix.IMatrix;
import gaml.species.ISpecies;
import gaml.types.IContainerType;
import gaml.types.IType;
import gaml.types.Types;
import one.util.streamex.StreamEx;

/**
 * Class MetaPopulation. A list of IPopulation, ISpecies or MetaPopulation that behaves like a list of agents (also to
 * filter them).
 *
 * @author drogoul
 * @since 8 déc. 2013
 *
 */
@SuppressWarnings ({ "rawtypes", "unchecked" })
public class MetaPopulation implements IContainer.Addressable<Integer, IAgent>, IPopulationSet {

	/** The population sets. */
	protected final List<IPopulationSet<? extends IAgent>> populationSets;
	
	/** The set of populations. */
	// We cache the value in case.
	protected IMap<String, IPopulation> setOfPopulations;
	
	/** The type. */
	protected IContainerType type = Types.LIST.of(Types.AGENT);

	/**
	 * Instantiates a new meta population.
	 */
	public MetaPopulation() {
		populationSets = new ArrayList();
	}

	/**
	 * Instantiates a new meta population.
	 *
	 * @param pops the pops
	 */
	public MetaPopulation(final IPopulation<? extends IAgent>[] pops) {
		this();
		for (final IPopulation<? extends IAgent> pop : pops) {
			addPopulation(pop);
		}
	}

	@Override
	public IPopulation<? extends IAgent> getPopulation(final IScope scope) {
		getMapOfPopulations(scope);
		if (setOfPopulations.size() == 1) return setOfPopulations.values().iterator().next();
		return null;
	}

	@Override
	public StreamEx<IAgent> stream(final IScope scope) {
		return StreamEx.of(populationSets).flatMap(each -> each.stream(scope));
	}

	/**
	 * Adds the population.
	 *
	 * @param pop the pop
	 */
	public void addPopulation(final IPopulation pop) {
		populationSets.add(pop);
	}

	/**
	 * Adds the population set.
	 *
	 * @param pop the pop
	 */
	public void addPopulationSet(final IPopulationSet pop) {
		populationSets.add(pop);
	}

	@Override
	public IContainerType getGamlType() {
		return type;
	}

	@Override
	public boolean hasAgentList() {
		return true;
	}

	/**
	 * Method getAgents()
	 *
	 * @see gama.metamodel.topology.filter.IAgentFilter#getAgents()
	 */
	@Override
	public IContainer<?, ? extends IAgent> getAgents(final IScope scope) {
		try (final Collector.AsList<java.lang.Iterable<? extends IAgent>> result = Collector.getList()) {
			for (final IPopulationSet p : populationSets) {
				result.add(p.iterable(scope));
			}
			return GamaListFactory.create(scope, Types.AGENT, Iterables.concat(result.items()));
		}
	}

	/**
	 * Method accept()
	 *
	 * @see gama.metamodel.topology.filter.IAgentFilter#accept(gama.runtime.IScope,
	 *      gama.metamodel.shape.IShape, gama.metamodel.shape.IShape)
	 */
	@Override
	public boolean accept(final IScope scope, final IShape source, final IShape a) {
		final IAgent agent = a.getAgent();
		if (agent == source.getAgent()) return false;
		return contains(scope, agent);
	}

	/**
	 * Method filter()
	 *
	 * @see gama.metamodel.topology.filter.IAgentFilter#filter(gama.runtime.IScope,
	 *      gama.metamodel.shape.IShape, java.util.Collection)
	 */
	@Override
	public void filter(final IScope scope, final IShape source, final Collection<? extends IShape> results) {
		final IAgent sourceAgent = source == null ? null : source.getAgent();
		results.remove(sourceAgent);
		results.removeIf(each -> !contains(scope, each));
	}

	/**
	 * Method stringValue()
	 *
	 * @see gama.common.interfaces.IValue#stringValue(gama.runtime.IScope)
	 */
	@Override
	public String stringValue(final IScope scope) throws GamaRuntimeException {
		return serialize(false);
	}

	/**
	 * Method copy()
	 *
	 * @see gama.common.interfaces.IValue#copy(gama.runtime.IScope)
	 */
	@Override
	public IValue copy(final IScope scope) throws GamaRuntimeException {
		final MetaPopulation mp = new MetaPopulation();
		for (final IPopulationSet ps : populationSets) {
			mp.populationSets.add(ps);
		}
		return mp;
	}

	/**
	 * Method toGaml()
	 *
	 * @see gama.common.interfaces.IGamlable#toGaml()
	 */
	@Override
	public String serialize(final boolean includingBuiltIn) {
		final StringBuilder sb = new StringBuilder(populationSets.size() * 10);
		sb.append('[');
		for (int i = 0; i < populationSets.size(); i++) {
			if (i != 0) { sb.append(','); }
			sb.append(StringUtils.toGaml(populationSets.get(i), includingBuiltIn));
		}
		sb.append(']');
		return sb.toString();

	}

	/**
	 * Method get()
	 *
	 * @see gama.util.IContainer#get(gama.runtime.IScope, java.lang.Object)
	 */
	@Override
	public IAgent get(final IScope scope, final Integer index) throws GamaRuntimeException {
		return listValue(scope, Types.NO_TYPE, false).get(scope, index);
	}

	/**
	 * Method getFromIndicesList()
	 *
	 * @see gama.util.IContainer#getFromIndicesList(gama.runtime.IScope, gama.util.IList)
	 */
	@Override
	public IAgent getFromIndicesList(final IScope scope, final IList indices) throws GamaRuntimeException {
		return listValue(scope, Types.NO_TYPE, false).getFromIndicesList(scope, indices);
	}

	/**
	 * Method contains()
	 *
	 * @see gama.util.IContainer#contains(gama.runtime.IScope, java.lang.Object)
	 */
	@Override
	public boolean contains(final IScope scope, final Object o) throws GamaRuntimeException {
		if (!(o instanceof IAgent)) return false;
		for (final IPopulationSet pop : populationSets) {
			if (pop.contains(scope, o)) return true;
		}
		return false;
	}

	@Override
	public boolean containsKey(final IScope scope, final Object o) {
		if (o instanceof Integer) {
			final Integer i = (Integer) o;
			return i > 0 && i < length(scope);
		}
		return false;
	}

	/**
	 * Method first()
	 *
	 * @see gama.util.IContainer#first(gama.runtime.IScope)
	 */
	@Override
	public IAgent firstValue(final IScope scope) throws GamaRuntimeException {
		if (populationSets.size() == 0) return null;
		return populationSets.get(0).firstValue(scope);
	}

	/**
	 * Method last()
	 *
	 * @see gama.util.IContainer#last(gama.runtime.IScope)
	 */
	@Override
	public IAgent lastValue(final IScope scope) throws GamaRuntimeException {
		if (populationSets.size() == 0) return null;
		return populationSets.get(populationSets.size() - 1).lastValue(scope);
	}

	/**
	 * Method length()
	 *
	 * @see gama.util.IContainer#length(gama.runtime.IScope)
	 */
	@Override
	public int length(final IScope scope) {
		int result = 0;
		for (final IPopulationSet p : populationSets) {
			result += p.length(scope);
		}
		return result;
	}

	/**
	 * Method isEmpty()
	 *
	 * @see gama.util.IContainer#isEmpty(gama.runtime.IScope)
	 */
	@Override
	public boolean isEmpty(final IScope scope) {
		for (final IPopulationSet p : populationSets) {
			if (!p.isEmpty(scope)) return false;
		}
		return true;
	}

	/**
	 * Method reverse()
	 *
	 * @see gama.util.IContainer#reverse(gama.runtime.IScope)
	 */
	@Override
	public IContainer reverse(final IScope scope) throws GamaRuntimeException {
		return listValue(scope, Types.AGENT, false).reverse(scope);
	}

	/**
	 * Method any()
	 *
	 * @see gama.util.IContainer#any(gama.runtime.IScope)
	 */
	@Override
	public IAgent anyValue(final IScope scope) {
		if (populationSets.size() == 0) return null;
		final RandomUtils r = scope.getRandom();
		final int i = r.between(0, populationSets.size() - 1);
		return populationSets.get(i).anyValue(scope);
	}

	/**
	 * Method listValue()
	 *
	 * @see gama.util.IContainer#listValue(gama.runtime.IScope)
	 */
	@Override
	public IList<? extends IAgent> listValue(final IScope scope, final IType contentsType, final boolean copy)
			throws GamaRuntimeException {
		// WARNING: Verify it is ok because no casting is made here
		return GamaListFactory.create(scope, contentsType, iterable(scope));
	}

	/**
	 * Method matrixValue()
	 *
	 * @see gama.util.IContainer#matrixValue(gama.runtime.IScope)
	 */
	@Override
	public IMatrix matrixValue(final IScope scope, final IType contentsType, final boolean copy)
			throws GamaRuntimeException {
		return listValue(scope, contentsType, false).matrixValue(scope, contentsType, false);
	}

	/**
	 * Method matrixValue()
	 *
	 * @see gama.util.IContainer#matrixValue(gama.runtime.IScope, gama.metamodel.shape.GamaPoint)
	 */
	@Override
	public IMatrix matrixValue(final IScope scope, final IType contentsType, final GamaPoint preferredSize,
			final boolean copy) throws GamaRuntimeException {
		return listValue(scope, contentsType, false).matrixValue(scope, contentsType, preferredSize, false);
	}

	/**
	 * Method mapValue()
	 *
	 * @see gama.util.IContainer#mapValue(gama.runtime.IScope)
	 */
	@Override
	public IMap mapValue(final IScope scope, final IType keyType, final IType contentsType, final boolean copy)
			throws GamaRuntimeException {
		return listValue(scope, contentsType, false).mapValue(scope, keyType, contentsType, false);
	}

	/**
	 * Method iterable()
	 *
	 * @see gama.util.IContainer#iterable(gama.runtime.IScope)
	 */
	@Override
	public java.lang.Iterable<? extends IAgent> iterable(final IScope scope) {
		try (final Collector.AsList<java.lang.Iterable<? extends IAgent>> result = Collector.getList()) {
			for (final IPopulationSet p : populationSets) {
				result.add(p.iterable(scope));
			}
			return Iterables.concat(result.items());
		}
	}

	/**
	 * Method getSpecies()
	 *
	 * @see gama.metamodel.topology.filter.IAgentFilter#getSpecies()
	 */
	@Override
	public ISpecies getSpecies() {
		return null; // We dont know what to return here.
	}

	/**
	 * Gets the map of populations.
	 *
	 * @param scope the scope
	 * @return the map of populations
	 */
	private Map<String, IPopulation> getMapOfPopulations(final IScope scope) {
		if (setOfPopulations == null) {
			setOfPopulations = GamaMapFactory.create();
			for (final IPopulationSet pop : populationSets) {
				if (pop instanceof MetaPopulation) {
					setOfPopulations.putAll(((MetaPopulation) pop).getMapOfPopulations(scope));
				} else {
					final Collection<? extends IPopulation> pops = pop.getPopulations(scope);
					for (final IPopulation p : pops) {
						setOfPopulations.put(p.getName(), p);
					}
				}
			}
		}
		return setOfPopulations;
	}

	/**
	 * Method getPopulations()
	 *
	 * @see gama.metamodel.population.IPopulationSet#getPopulations(gama.runtime.IScope)
	 */
	@Override
	public Collection<? extends IPopulation> getPopulations(final IScope scope) {
		return getMapOfPopulations(scope).values();
	}

}
