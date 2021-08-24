/*******************************************************************************************************
 *
 * IGamaHelper.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compilation;

import gama.common.interfaces.IVarAndActionSupport;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;

/**
 * Written by drogoul Modified on 14 ao�t 2010. Modified on 23 Apr. 2013. A general purpose helper that can be
 * subclassed like a Runnable.
 *
 * @param <T> the generic type
 * @todo Description
 */
@SuppressWarnings ({ "rawtypes" })
@FunctionalInterface
public interface IGamaHelper<T> {

	/** The empty values. */
	Object[] EMPTY_VALUES = new Object[0];

	/**
	 * Gets the skill class.
	 *
	 * @return the skill class
	 */
	default Class getSkillClass() {
		return null;
	}

	/**
	 * Run.
	 *
	 * @param scope the scope
	 * @param agent the agent
	 * @param skill the skill
	 * @return the t
	 */
	default T run(final IScope scope, final IAgent agent, final IVarAndActionSupport skill) {
		return run(scope, agent, skill, EMPTY_VALUES);
	}

	/**
	 * Run.
	 *
	 * @param scope the scope
	 * @param agent the agent
	 * @param skill the skill
	 * @param values the values
	 * @return the t
	 */
	T run(final IScope scope, final IAgent agent, final IVarAndActionSupport skill, final Object values);

}