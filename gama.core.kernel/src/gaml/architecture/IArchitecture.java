/*******************************************************************************************************
 *
 * msi.gaml.architecture.IArchitecture.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
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

	public abstract boolean init(IScope scope) throws GamaRuntimeException;

	public abstract boolean abort(IScope scope) throws GamaRuntimeException;

	public abstract void verifyBehaviors(ISpecies context);

	public abstract void preStep(final IScope scope, IPopulation<? extends IAgent> gamaPopulation);

	@Override
	public default int getOrder() {
		return 0;
	}

	@Override
	public default void setOrder(final int o) {}
}