/*******************************************************************************************************
 *
 * IMacroAgent.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.metamodel.agent;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.getter;
import gama.core.dev.annotations.GamlAnnotations.setter;
import gama.core.dev.annotations.GamlAnnotations.variable;
import gama.core.dev.annotations.GamlAnnotations.vars;
import gama.metamodel.population.IPopulation;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.IContainer;
import gama.util.IList;
import gaml.species.ISpecies;
import gaml.types.IType;

/**
 * The Interface IMacroAgent.
 */
@vars ({ @variable (
		name = IKeyword.MEMBERS,
		type = IType.LIST,
		of = IType.AGENT,
		doc = { @doc ("Returns the list of agents for the population(s) of which the receiver agent is a direct host") }),
		@variable (
				name = IKeyword.AGENTS,
				type = IType.LIST,
				of = IType.AGENT,
				doc = { @doc ("Returns the list of agents for the population(s) of which the receiver agent is a direct or undirect host") }) })
public interface IMacroAgent extends IAgent {

	/**
	 * Verifies if this agent can capture other agent as the specified micro-species.
	 * 
	 * An agent A can capture another agent B as newSpecies if the following conditions are correct: 1. other is not
	 * this agent; 2. other is not "world" agent; 3. newSpecies is a (direct) micro-species of A's species; 4.
	 * newSpecies is a direct sub-species of B's species.
	 *
	 * @param other the other
	 * @param newSpecies the new species
	 * @return true if this agent can capture other agent false otherwise
	 */
	public abstract boolean canCapture(IAgent other, ISpecies newSpecies);

	/**
	 * Capture micro agent.
	 *
	 * @param scope the scope
	 * @param microSpecies the micro species
	 * @param microAgent the micro agent
	 * @return the i agent
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public abstract IAgent captureMicroAgent(IScope scope, final ISpecies microSpecies, final IAgent microAgent)
			throws GamaRuntimeException;

	/**
	 * Captures some agents as micro-agents with the specified micro-species as their new species.
	 *
	 * @param scope the scope
	 * @param microSpecies            the species that the captured agents will become, this must be a micro-species of this agent's
	 *            species.
	 * @param microAgents the micro agents
	 * @return the i list
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public abstract IList<IAgent> captureMicroAgents(IScope scope, final ISpecies microSpecies,
			final IList<IAgent> microAgents) throws GamaRuntimeException;

	/**
	 * Returns all the agents which consider this agent as direct host.
	 *
	 * @param scope the scope
	 * @return the members
	 */
	@getter (IKeyword.MEMBERS)
	public abstract IContainer<?, IAgent> getMembers(IScope scope);

	/**
	 * Returns the population of the specified (direct) micro-species.
	 *
	 * @param microSpecies the micro species
	 * @return the micro population
	 */
	public abstract IPopulation<? extends IAgent> getMicroPopulation(ISpecies microSpecies);

	/**
	 * Returns the population of the specified (direct) micro-species.
	 *
	 * @param microSpeciesName the micro species name
	 * @return the micro population
	 */
	public abstract IPopulation<? extends IAgent> getMicroPopulation(String microSpeciesName);

	/**
	 * Returns a list of populations of (direct) micro-species.
	 *
	 * @return the micro populations
	 */
	public abstract IPopulation<? extends IAgent>[] getMicroPopulations();

	/**
	 * Verifies if this agent contains micro-agents or not.
	 *
	 * @return true if this agent contains micro-agent(s) false otherwise
	 */
	public abstract boolean hasMembers();

	/**
	 * Gets the members size.
	 *
	 * @param scope the scope
	 * @return the members size
	 */
	public int getMembersSize(final IScope scope);

	/**
	 * Initialize micro population.
	 *
	 * @param scope the scope
	 * @param name the name
	 */
	public abstract void initializeMicroPopulation(IScope scope, String name);

	/**
	 * Initialize Populations to manage micro-agents.
	 *
	 * @param scope the scope
	 * @param microAgents the micro agents
	 * @param newMicroSpecies the new micro species
	 * @return the i list
	 */
	// public abstract void initializeMicroPopulations(IScope scope);

	/**
	 * Migrates some micro-agents from one micro-species to another micro-species of this agent's species.
	 *
	 * @param microAgent
	 * @param newMicroSpecies
	 * @return
	 */
	public abstract IList<IAgent> migrateMicroAgents(IScope scope, final IList<IAgent> microAgents,
			final ISpecies newMicroSpecies);

	/**
	 * Migrates some micro-agents from one micro-species to another micro-species of this agent's species.
	 *
	 * @param scope the scope
	 * @param oldMicroSpecies the old micro species
	 * @param newMicroSpecies the new micro species
	 * @return the i list
	 */
	public abstract IList<IAgent> migrateMicroAgents(IScope scope, final ISpecies oldMicroSpecies,
			final ISpecies newMicroSpecies);

	/**
	 * Releases some micro-agents of this agent.
	 *
	 * @param scope the scope
	 * @param microAgents the micro agents
	 * @return the i list
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public abstract IList<IAgent> releaseMicroAgents(IScope scope, final IList<IAgent> microAgents)
			throws GamaRuntimeException;

	/**
	 * Sets the members.
	 *
	 * @param members the new members
	 */
	@setter (IKeyword.MEMBERS)
	public abstract void setMembers(IList<IAgent> members);

	/**
	 * Sets the agents.
	 *
	 * @param agents the new agents
	 */
	@setter (IKeyword.AGENTS)
	public abstract void setAgents(IList<IAgent> agents);

	/**
	 * Returns all the agents which consider this agent as direct or in-direct host.
	 *
	 * @param scope the scope
	 * @return the agents
	 */
	@getter (IKeyword.AGENTS)
	public abstract IList<IAgent> getAgents(IScope scope);

	/**
	 * Adds the extern micro population.
	 *
	 * @param expName the exp name
	 * @param pop the pop
	 */
	public abstract void addExternMicroPopulation(final String expName, final IPopulation<? extends IAgent> pop);

	/**
	 * Gets the extern micro population for.
	 *
	 * @param expName the exp name
	 * @return the extern micro population for
	 */
	public abstract IPopulation<? extends IAgent> getExternMicroPopulationFor(final String expName);

}