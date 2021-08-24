/*******************************************************************************************************
 *
 * AbstractArchitecture.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.architecture.reflex;

import gama.runtime.IScope;
import gaml.architecture.IArchitecture;
import gaml.expressions.IExpression;
import gaml.skills.Skill;
import gaml.species.ISpecies;

/**
 * The Class AbstractArchitecture.
 */
public abstract class AbstractArchitecture extends Skill implements IArchitecture {

	/**
	 * Instantiates a new abstract architecture.
	 */
	public AbstractArchitecture() {
		super();
	}

	@Override
	public String serialize(final boolean includingBuiltIn) {
		return getName();
	}

	@Override
	public String getKeyword() {
		return getName();
	}

	@Override
	public String getTrace(final IScope scope) {
		return "";
	}

	@Override
	public IExpression getFacet(final String... key) {
		return null;
	}

	@Override
	public boolean hasFacet(final String key) {
		return false;
	}

	@Override
	public void verifyBehaviors(final ISpecies context) {
	}

	@Override
	public void dispose() {
	}

}