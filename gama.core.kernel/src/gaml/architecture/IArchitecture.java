/*******************************************************************************************************
 *
 * IArchitecture.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.architecture;

import gama.common.interfaces.ISkill;
import gama.metamodel.agent.IAgent;
import gama.metamodel.population.IPopulation;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.species.ISpecies;
import gaml.statements.IStatement;

/**
 * Written by drogoul Modified on 12 sept. 2010
 * 
 * @todo Description
 * 
 */
public interface IArchitecture extends ISkill, IStatement {

	/**
	 * Inits the.
	 *
	 * @param scope the scope
	 * @return true, if successful
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public abstract boolean init(IScope scope) throws GamaRuntimeException;

	/**
	 * Abort.
	 *
	 * @param scope the scope
	 * @return true, if successful
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public abstract boolean abort(IScope scope) throws GamaRuntimeException;

	/**
	 * Verify behaviors.
	 *
	 * @param context the context
	 */
	public abstract void verifyBehaviors(ISpecies context);

	/**
	 * Pre step.
	 *
	 * @param scope the scope
	 * @param gamaPopulation the gama population
	 */
	public abstract void preStep(final IScope scope, IPopulation<? extends IAgent> gamaPopulation);

	@Override
	public default int getOrder() {
		return 0;
	}

	@Override
	public default void setOrder(final int o) {}
}