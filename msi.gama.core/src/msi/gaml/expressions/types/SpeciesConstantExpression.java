/*******************************************************************************************************
 *
 * SpeciesConstantExpression.java, in msi.gama.core, is part of the source code of the GAMA modeling and simulation
 * platform (v.1.9.3).
 *
 * (c) 2007-2024 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package msi.gaml.expressions.types;

import msi.gama.metamodel.agent.IAgent;
import msi.gama.metamodel.population.IPopulation;
import msi.gama.precompiler.GamlProperties;
import msi.gama.runtime.IScope;
import msi.gama.util.ICollector;
import msi.gaml.descriptions.IDescription;
import msi.gaml.descriptions.IVarDescriptionUser;
import msi.gaml.descriptions.SpeciesDescription;
import msi.gaml.descriptions.VariableDescription;
import msi.gaml.expressions.ConstantExpression;
import msi.gaml.types.IType;
import ummisco.gama.dev.utils.DEBUG;

/**
 * The Class SpeciesConstantExpression.
 *
 * @author Alexis Drogoul (alexis.drogoul@ird.fr)
 * @date 16 janv. 2024
 */
@SuppressWarnings ({ "rawtypes" })
public class SpeciesConstantExpression extends ConstantExpression {

	static {
		DEBUG.ON();
	}

	/**
	 * The origin name of the species. Can be in a remote micro-model. Equivalent to the originName present on
	 * SpeciesDescription
	 */
	final String origin;

	/** The alias. */
	final String alias;

	/** The belongs to A micro model. */
	final boolean belongsToAMicroModel;

	/**
	 * Instantiates a new species constant expression.
	 *
	 * @param string
	 *            the string
	 * @param t
	 *            the t
	 */
	public SpeciesConstantExpression(final String string, final IType t, final IDescription context) {
		super(string, t);

		origin = context.getModelDescription().getName();
		alias = context.getModelDescription().getAlias();
		belongsToAMicroModel = alias != null && !alias.isEmpty();
		// DEBUG.OUT("Creation of species constant expression " + string + " in context of " + origin + " with alias "
		// + alias);
	}

	@Override
	public Object _value(final IScope scope) {
		final IAgent a = scope.getAgent();
		if (a != null) {
			if (!belongsToAMicroModel) {
				final IPopulation pop = a.getPopulationFor((String) value);
				if (pop != null) return pop.getSpecies();
				return scope.getModel().getSpecies((String) value);
			}
			final IPopulation pop = scope.getRoot().getExternMicroPopulationFor(alias + "." + value);
			if (pop != null) return pop.getSpecies();
			return scope.getModel().getSpecies((String) value, origin);
		}
		return null;
	}

	@Override
	public boolean isConst() { return false; }

	@Override
	public String serializeToGaml(final boolean includingBuiltIn) {
		return (String) value;
	}

	@Override
	public Doc getDocumentation() {
		Doc result = new RegularDoc("");
		getGamlType().getContentType().getSpecies().documentThis(result);
		return result;
	}

	/**
	 * Method collectPlugins()
	 *
	 * @see msi.gaml.interfaces.IGamlDescription#collectPlugins(java.util.Set)
	 */
	@Override
	public void collectMetaInformation(final GamlProperties meta) {
		final SpeciesDescription sd = getGamlType().getContentType().getSpecies();
		if (sd != null) {
			meta.put(GamlProperties.PLUGINS, sd.getDefiningPlugin());
			if (sd.isBuiltIn()) { meta.put(GamlProperties.SPECIES, (String) value); }
		}
	}

	@Override
	public boolean isContextIndependant() { return false; }

	@Override
	public boolean isAllowedInParameters() { return true; } // verify this

	@Override
	public void collectUsedVarsOf(final SpeciesDescription species,
			final ICollector<IVarDescriptionUser> alreadyProcessed, final ICollector<VariableDescription> result) {
		if (alreadyProcessed.contains(this)) return;
		alreadyProcessed.add(this);
		if (species.hasAttribute(value.toString())) { result.add(species.getAttribute(value.toString())); }
	}

}
