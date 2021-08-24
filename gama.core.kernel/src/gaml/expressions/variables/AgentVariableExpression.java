/*******************************************************************************************************
 *
 * AgentVariableExpression.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.expressions.variables;

import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.ICollector;
import gaml.descriptions.IDescription;
import gaml.descriptions.IVarDescriptionUser;
import gaml.descriptions.SpeciesDescription;
import gaml.descriptions.VariableDescription;
import gaml.expressions.IExpression;
import gaml.expressions.IVarExpression;
import gaml.types.IType;

/**
 * The Class AgentVariableExpression.
 */
public class AgentVariableExpression extends VariableExpression implements IVarExpression.Agent {

	/**
	 * Instantiates a new agent variable expression.
	 *
	 * @param n the n
	 * @param type the type
	 * @param notModifiable the not modifiable
	 * @param def the def
	 */
	@SuppressWarnings ("rawtypes")
	public AgentVariableExpression(final String n, final IType type, final boolean notModifiable,
			final IDescription def) {
		super(n, type, notModifiable, def);
	}

	@Override
	public IExpression getOwner() {
		return new SelfExpression(this.getDefinitionDescription().getSpeciesContext().getGamlType());
	}

	@Override
	public Object _value(final IScope scope) throws GamaRuntimeException {
		return scope.getAgentVarValue(scope.getAgent(), getName());
	}

	@Override
	public void setVal(final IScope scope, final Object v, final boolean create) throws GamaRuntimeException {
		scope.setAgentVarValue(scope.getAgent(), getName(), v);
	}

	@Override
	public String getDocumentation() {
		final IDescription desc = getDefinitionDescription();
		String doc = null;
		String s = "Type " + type.getTitle();
		if (desc != null) {
			final VariableDescription var = desc.getSpeciesContext().getAttribute(name);
			if (var != null) { doc = var.getBuiltInDoc(); }
		} else
			return s;
		if (doc != null) { s += "<br>" + doc; }
		final String quality =
				(desc.isBuiltIn() ? "<br>Built In " : doc == null ? "<br>Defined in " : "<br>Redefined in ")
						+ desc.getTitle();

		return s + quality;
	}

	/**
	 * Method collectPlugins()
	 *
	 * @see gama.common.interfaces.IGamlDescription#collectPlugins(java.util.Set)
	 */
	// @Override
	// public void collectMetaInformation(final GamlProperties meta) {
	// if (getDefinitionDescription().isBuiltIn()) {
	// meta.put(GamlProperties.ATTRIBUTES, getName());
	// }
	// }

	@Override
	public void collectUsedVarsOf(final SpeciesDescription species,
			final ICollector<IVarDescriptionUser> alreadyProcessed, final ICollector<VariableDescription> result) {
		if (alreadyProcessed.contains(this)) return;
		alreadyProcessed.add(this);
		final SpeciesDescription sd = this.getDefinitionDescription().getSpeciesContext();
		if (species.equals(sd) || species.hasParent(sd)) { result.add(sd.getAttribute(getName())); }
	}

}
