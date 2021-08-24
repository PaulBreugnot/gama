/*******************************************************************************************************
 *
 * AbstractGraphEdgeAgent.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util.graph;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.species;
import gama.core.dev.annotations.GamlAnnotations.variable;
import gama.core.dev.annotations.GamlAnnotations.vars;
import gama.metamodel.agent.GamlAgent;
import gama.metamodel.agent.IAgent;
import gama.metamodel.population.IPopulation;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.types.GamaGeometryType;
import gaml.types.IType;

// FIXME: Add all the necessary variables and actions ?
/**
 * The Class AbstractGraphEdgeAgent.
 */
// FIXME:
@species (
		name = "graph_edge",
		doc = @doc ("A species that represents an edge of a graph made of agents. The source and the target of the edge should be agents"))
@vars ({ @variable (
		name = IKeyword.SOURCE,
		type = IType.AGENT,
		doc = @doc ("The source agent of this edge")),
		@variable (
				name = IKeyword.TARGET,
				type = IType.AGENT,
				doc = @doc ("The target agent of this edge")) })
@doc ("A species that represents an edge of a graph made of agents. The source and the target of the edge should be agents")
public class AbstractGraphEdgeAgent extends GamlAgent {
	
	/**
	 * Instantiates a new abstract graph edge agent.
	 *
	 * @param s the s
	 * @param index the index
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public AbstractGraphEdgeAgent(final IPopulation<? extends IAgent> s, final int index) throws GamaRuntimeException {
		super(s, index);
	}

	@Override
	public Object _step_(final IScope scope) {
		// if ( scope.interrupted() || dead() ) { return null; }
		final IAgent s = (IAgent) getAttribute(IKeyword.SOURCE);
		final IAgent t = (IAgent) getAttribute(IKeyword.TARGET);
		if (s == null || t == null) { return null; }
		setGeometry(GamaGeometryType.buildLine(s.getLocation(), t.getLocation()));
		return super._step_(scope);
	}

}
