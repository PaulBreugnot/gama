/*******************************************************************************************************
 *
 * IVarDescriptionProvider.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.descriptions;

import gaml.expressions.IExpression;

/**
 * The Interface IVarDescriptionProvider.
 */
public interface IVarDescriptionProvider {

	/**
	 * If asField is true, then should not return a GlobalVarExpression, but a normal var expression.
	 *
	 * @param name the name
	 * @param asField the as field
	 * @return the var expr
	 */
	public abstract IExpression getVarExpr(final String name, boolean asField);

	/**
	 * Checks for attribute.
	 *
	 * @param name the name
	 * @return true, if successful
	 */
	public boolean hasAttribute(String name);

}
