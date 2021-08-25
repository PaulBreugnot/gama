/*******************************************************************************************************
 *
 * EcoreBasedExpressionDescription.java, in gama.core.lang, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.lang.expression;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;

import gama.common.interfaces.IGamlIssue;
import gama.core.lang.EGaml;
import gama.util.Collector;
import gama.util.ICollector;
import gaml.compilation.kernel.GamaSkillRegistry;
import gaml.descriptions.BasicExpressionDescription;
import gaml.descriptions.IDescription;
import gaml.descriptions.IExpressionDescription;
import gama.core.lang.gaml.Array;
import gama.core.lang.gaml.Expression;
import gama.core.lang.gaml.VariableRef;

/**
 * The class EcoreBasedExpressionDescription.
 *
 * @author drogoul
 * @since 31 mars 2012
 *
 */
public class EcoreBasedExpressionDescription extends BasicExpressionDescription {

	/**
	 * Instantiates a new ecore based expression description.
	 *
	 * @param exp the exp
	 */
	protected EcoreBasedExpressionDescription(final EObject exp) {
		super(exp);
	}

	@Override
	public IExpressionDescription cleanCopy() {
		return new EcoreBasedExpressionDescription(target);
	}

	@Override
	public String toOwnString() {
		return EGaml.getInstance().toString(target);
	}

	@Override
	public Collection<String> getStrings(final IDescription context, final boolean skills) {
		if (target == null) return Collections.EMPTY_SET;
		if (!(target instanceof Array)) {
			final String type = skills ? "skill" : "attribute";

			if (target instanceof VariableRef) {
				final String skillName = EGaml.getInstance().getKeyOf(target);
				context.warning(
						type + "s should be provided as a list of identifiers, for instance [" + skillName + "]",
						IGamlIssue.AS_ARRAY, target, skillName);
				if (skills && !GamaSkillRegistry.INSTANCE.hasSkill(skillName)) {
					context.error("Unknown " + type + " " + skillName, IGamlIssue.UNKNOWN_SKILL, target);
				}
				return Collections.singleton(skillName);
			}
			if (target instanceof Expression) {
				context.error("Impossible to recognize valid " + type + "s in " + EGaml.getInstance().toString(target),
						skills ? IGamlIssue.UNKNOWN_SKILL : IGamlIssue.UNKNOWN_VAR, target);
			} else {
				context.error(type + "s should be provided as a list of identifiers.", IGamlIssue.UNKNOWN_SKILL,
						target);
			}
			return Collections.EMPTY_SET;
		}
		try (final ICollector<String> result = Collector.getOrderedSet()) {
			final Array array = (Array) target;
			for (final Expression expr : EGaml.getInstance().getExprsOf(array.getExprs())) {
				final String type = skills ? "skill" : "attribute";

				final String name = EGaml.getInstance().getKeyOf(expr);
				if (skills && !GamaSkillRegistry.INSTANCE.hasSkill(name)) {
					context.error("Unknown " + type + " " + name, IGamlIssue.UNKNOWN_SKILL, expr);
				} else {
					result.add(name);
				}
			}
			return result.items();
		}
	}

}
