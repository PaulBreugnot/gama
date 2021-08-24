/*******************************************************************************************************
 *
 * IExpressionDescription.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.descriptions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

import gama.common.interfaces.IDisposable;
import gama.common.interfaces.IGamlable;
import gaml.expressions.IExpression;
import gaml.types.IType;

/**
 * The class IExpressionDescription.
 *
 * @author drogoul
 * @since 31 mars 2012
 *
 */
public interface IExpressionDescription extends IGamlable, IDisposable {

	/**
	 * Sets the expression.
	 *
	 * @param expr the new expression
	 */
	public abstract void setExpression(final IExpression expr);

	/**
	 * Compile.
	 *
	 * @param context the context
	 * @return the i expression
	 */
	public abstract IExpression compile(final IDescription context);

	/**
	 * Gets the expression.
	 *
	 * @return the expression
	 */
	public abstract IExpression getExpression();

	/**
	 * Compile as label.
	 *
	 * @return the i expression description
	 */
	public abstract IExpressionDescription compileAsLabel();

	/**
	 * Equals string.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	public abstract boolean equalsString(String o);

	/**
	 * Gets the target.
	 *
	 * @return the target
	 */
	public EObject getTarget();

	/**
	 * Sets the target.
	 *
	 * @param target the new target
	 */
	public void setTarget(EObject target);

	/**
	 * Checks if is const.
	 *
	 * @return true, if is const
	 */
	public boolean isConst();

	/**
	 * Gets the strings.
	 *
	 * @param context the context
	 * @param skills the skills
	 * @return the strings
	 */
	public Collection<String> getStrings(IDescription context, boolean skills);

	/**
	 * Clean copy.
	 *
	 * @return the i expression description
	 */
	public abstract IExpressionDescription cleanCopy();

	/**
	 * Gets the denoted type.
	 *
	 * @param context the context
	 * @return the denoted type
	 */
	public abstract IType<?> getDenotedType(IDescription context);

	// public abstract void collectMetaInformation(GamlProperties meta);

}