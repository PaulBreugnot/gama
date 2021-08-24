/*******************************************************************************************************
 *
 * ISkill.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.interfaces;

import gaml.descriptions.SkillDescription;

/**
 * SkillInterface - convenience interface for any object that might be used as a "skill" for an agent.
 *
 * @author drogoul 4 juil. 07
 */
public interface ISkill extends IGamlDescription, IVarAndActionSupport {

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	SkillDescription getDescription();
}
