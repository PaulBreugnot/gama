/*******************************************************************************************************
 *
 * BaseGraphEdgeAgent.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util.graph;

import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.species;
import gama.metamodel.agent.IAgent;
import gama.metamodel.population.IPopulation;
import gama.runtime.exceptions.GamaRuntimeException;

/**
 * The Class BaseGraphEdgeAgent.
 */
@species (
		name = "base_edge",
		doc = @doc ("A built-in species for agents representing the edges of a graph, from which one can inherit"))
@doc ("A built-in species for agents representing the edges of a graph, from which one can inherit")
public class BaseGraphEdgeAgent extends AbstractGraphEdgeAgent {

	/**
	 * Instantiates a new base graph edge agent.
	 *
	 * @param s the s
	 * @param index the index
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public BaseGraphEdgeAgent(final IPopulation<? extends IAgent> s, final int index) throws GamaRuntimeException {
		super(s, index);
	}

}