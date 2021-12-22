/*******************************************************************************************************
 *
 * BasicExpressionDescription.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.descriptions;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;

import gama.common.util.StringUtils;
import gaml.compilation.GAML;
import gaml.expressions.IExpression;
import gaml.expressions.types.TypeExpression;
import gaml.types.GamaStringType;
import gaml.types.IType;
import gaml.types.ITypesManager;
import gaml.types.Types;

// TODO: Auto-generated Javadoc
/**
 * The Class BasicExpressionDescription.
 */
public class BasicExpressionDescription implements IExpressionDescription {

	/** The expression. */
	protected IExpression expression;

	/** The target. */
	protected EObject target;

	/**
	 * Instantiates a new basic expression description.
	 *
	 * @param expr
	 *            the expr
	 */
	public BasicExpressionDescription(final IExpression expr) {
		expression = expr;
	}

	/**
	 * Instantiates a new basic expression description.
	 *
	 * @param object
	 *            the object
	 */
	public BasicExpressionDescription(final EObject object) {
		target = object;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return serialize(false);
	}

	/**
	 * To own string.
	 *
	 * @return the string
	 */
	public String toOwnString() {
		return target.toString();
	}

	/**
	 * Serialize.
	 *
	 * @param includingBuiltIn the including built in
	 * @return the string
	 */
	@Override
	public String serialize(final boolean includingBuiltIn) {
		return expression == null ? toOwnString() : expression.serialize(includingBuiltIn);
	}

	/**
	 * Equals.
	 *
	 * @param c the c
	 * @return true, if successful
	 */
	@Override
	public boolean equals(final Object c) {
		if (c == null) return false;
		if (c == this) return true;
		if (c instanceof IExpressionDescription) return ((IExpressionDescription) c).equalsString(toString());
		return false;
	}

	/**
	 * Gets the expression.
	 *
	 * @return the expression
	 */
	@Override
	public IExpression getExpression() { return expression; }

	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {
		expression = null;
		target = null;
	}

	/**
	 * Sets the expression.
	 *
	 * @param expr the new expression
	 */
	@Override
	public void setExpression(final IExpression expr) { expression = expr; }

	/**
	 * Compile.
	 *
	 * @param context the context
	 * @return the i expression
	 */
	@Override
	public IExpression compile(final IDescription context) {
		if (expression == null) { expression = GAML.getExpressionFactory().createExpr(this, context); }
		return expression;
	}

	/**
	 * Compile as label.
	 *
	 * @return the i expression description
	 * @see msi.gaml.descriptions.IExpressionDescription#compileAsLabel()
	 */
	@Override
	public IExpressionDescription compileAsLabel() {
		final IExpressionDescription newEd = LabelExpressionDescription.create(StringUtils.toJavaString(toString()));
		newEd.setTarget(getTarget());
		return newEd;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Equals string.
	 *
	 * @param o the o
	 * @return true, if successful
	 * @see msi.gaml.descriptions.IExpressionDescription#equalsString(java.lang.String)
	 */
	@Override
	public boolean equalsString(final String o) {
		return o == null ? false : o.equals(toString());
	}

	/**
	 * Gets the target.
	 *
	 * @return the target
	 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
	 */
	@Override
	public EObject getTarget() { return target; }

	/**
	 * Sets the target.
	 *
	 * @param newTarget the new target
	 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	public void setTarget(final EObject newTarget) {
		if (target == null) { target = newTarget; }
	}

	/**
	 * Checks if is const.
	 *
	 * @return true, if is const
	 */
	@Override
	public boolean isConst() { return false; }

	/**
	 * Gets the strings.
	 *
	 * @param context the context
	 * @param skills the skills
	 * @return the strings
	 */
	@Override
	public Collection<String> getStrings(final IDescription context, final boolean skills) {
		return Collections.EMPTY_SET;
	}

	/**
	 * Clean copy.
	 *
	 * @return the i expression description
	 */
	@Override
	public IExpressionDescription cleanCopy() {
		final IExpressionDescription result = new BasicExpressionDescription(expression);
		result.setTarget(target);
		return result;
	}

	/**
	 * Gets the denoted type.
	 *
	 * @param context the context
	 * @return the denoted type
	 */
	@Override
	public IType<?> getDenotedType(final IDescription context) {
		compile(context);
		if (expression == null) return Types.NO_TYPE;
		if (expression instanceof TypeExpression) return ((TypeExpression) expression).getDenotedType();
		if (expression.isConst())
			return context.getTypeNamed(GamaStringType.staticCast(null, expression.getConstValue(), true));

		final String s = expression.literalValue();
		final ITypesManager tm = context.getModelDescription().getTypesManager();
		if (tm.containsType(s)) return tm.get(s);

		return expression.getGamlType();
	}

}