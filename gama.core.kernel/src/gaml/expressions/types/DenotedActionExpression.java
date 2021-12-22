/*******************************************************************************************************
 *
 * DenotedActionExpression.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.expressions.types;

import gama.runtime.IScope;
import gaml.descriptions.StatementDescription;
import gaml.expressions.variables.VariableExpression;
import gaml.types.Types;

// TODO: Auto-generated Javadoc
/**
 * The Class DenotedActionExpression.
 */
public class DenotedActionExpression extends VariableExpression {

	/**
	 * Instantiates a new denoted action expression.
	 *
	 * @param action
	 *            the action
	 */
	public DenotedActionExpression(final StatementDescription action) {
		super(action.getName(), Types.ACTION, true, action);
	}

	/**
	 * Value.
	 *
	 * @param scope the scope
	 * @return the object
	 */
	@Override
	public Object _value(final IScope scope) {
		return getDefinitionDescription();
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	@Override
	public String getTitle() { return getDefinitionDescription().getTitle(); }

	/**
	 * Gets the documentation.
	 *
	 * @return the documentation
	 * @see msi.gaml.expressions.IExpression#getDocumentation()
	 */
	@Override
	public String getDocumentation() { return getDefinitionDescription().getDocumentation(); }

	/**
	 * Sets the val.
	 *
	 * @param scope the scope
	 * @param v the v
	 * @param create the create
	 */
	@Override
	public void setVal(final IScope scope, final Object v, final boolean create) {}

}
