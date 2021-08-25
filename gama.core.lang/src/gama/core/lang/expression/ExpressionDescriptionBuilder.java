/*******************************************************************************************************
 *
 * ExpressionDescriptionBuilder.java, in gama.core.lang, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.lang.expression;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.Diagnostic;

import gama.common.interfaces.IKeyword;
import gama.core.lang.EGaml;
import gama.core.lang.gaml.BooleanLiteral;
import gama.core.lang.gaml.DoubleLiteral;
import gama.core.lang.gaml.IntLiteral;
import gama.core.lang.gaml.StringLiteral;
import gama.core.lang.gaml.Unary;
import gama.core.lang.gaml.UnitName;
import gama.core.lang.gaml.util.GamlSwitch;
import gama.core.lang.resource.GamlResourceServices;
import gaml.compilation.ast.ISyntacticElement;
import gaml.descriptions.ConstantExpressionDescription;
import gaml.descriptions.IExpressionDescription;
import gaml.operators.IUnits;

/**
 * The Class ExpressionDescriptionBuilder.
 */
public class ExpressionDescriptionBuilder extends GamlSwitch<IExpressionDescription> {

	// private Set<Diagnostic> currentErrors;

	/**
	 * Sets the errors.
	 *
	 * @param errors the new errors
	 */
	void setErrors(final Set<Diagnostic> errors) {
		// currentErrors = errors;
	}

	@Override
	public IExpressionDescription caseIntLiteral(final IntLiteral object) {
		IExpressionDescription ed = null;
		try {
			ed = ConstantExpressionDescription.create(Integer.parseInt(object.getOp()));
		} catch (final NumberFormatException e) {
			// final Diagnostic d = new EObjectDiagnosticImpl(Severity.WARNING,
			// "",
			// "Impossible to parse this int value, automatically set to 0",
			// object, null, 0, null);
			// if (currentErrors != null)
			// currentErrors.add(d);
			ed = ConstantExpressionDescription.create(0);
		}
		GamlResourceServices.getResourceDocumenter().setGamlDocumentation(object, ed.getExpression(), true);
		return ed;
	}

	@Override
	public IExpressionDescription caseDoubleLiteral(final DoubleLiteral object) {
		IExpressionDescription ed = null;
		try {
			ed = ConstantExpressionDescription.create(Double.parseDouble(object.getOp()));
		} catch (final NumberFormatException e) {
			// final Diagnostic d = new EObjectDiagnosticImpl(Severity.WARNING,
			// "",
			// "Impossible to parse this float value, automatically set to 0.0",
			// object, null, 0, null);
			// if (currentErrors != null)
			// currentErrors.add(d);
			ed = ConstantExpressionDescription.create(0d);
		}
		GamlResourceServices.getResourceDocumenter().setGamlDocumentation(object, ed.getExpression(), true);
		return ed;
	}

	@Override
	public IExpressionDescription caseStringLiteral(final StringLiteral object) {
		final IExpressionDescription ed = ConstantExpressionDescription.create(object.getOp());

		// AD: Change 14/11/14
		// IExpressionDescription ed =
		// LabelExpressionDescription.create(object.getOp());
		GamlResourceServices.getResourceDocumenter().setGamlDocumentation(object, ed.getExpression(), true);
		return ed;
	}

	@Override
	public IExpressionDescription caseBooleanLiteral(final BooleanLiteral object) {
		final IExpressionDescription ed = ConstantExpressionDescription.create(object.getOp().equals(IKeyword.TRUE));
		GamlResourceServices.getResourceDocumenter().setGamlDocumentation(object, ed.getExpression(), true);
		return ed;
	}

	/** The count. */
	static int count;

	@Override
	public IExpressionDescription caseUnitName(final UnitName object) {
		final String s = EGaml.getInstance().getKeyOf(object);
		if (IUnits.UNITS_EXPR.containsKey(s)) {
			return IUnits.UNITS_EXPR.get(s);
		}
		return null;
	}

	@Override
	public IExpressionDescription caseUnary(final Unary object) {
		final String op = EGaml.getInstance().getKeyOf(object);
		if (op.equals("°") || op.equals("#")) {
			return doSwitch(object.getRight());
		}
		return null;
	}

	@Override
	public IExpressionDescription defaultCase(final EObject object) {
		return new EcoreBasedExpressionDescription(object);
	}

	/**
	 * Creates the.
	 *
	 * @param e the e
	 * @param errors the errors
	 * @return the i expression description
	 */
	public static IExpressionDescription create(final ISyntacticElement e, final Set<Diagnostic> errors) {
		final IExpressionDescription ed = new BlockExpressionDescription(e);
		return ed;
	}

	/**
	 * Creates the.
	 *
	 * @param expr the expr
	 * @return the i expression description
	 */
	public IExpressionDescription create(
			final EObject expr/* , final Set<Diagnostic> errors */) {
		try {
			// setErrors(errors);
			final IExpressionDescription result = doSwitch(expr);
			result.setTarget(expr);
			return result;
		} finally {
			// setErrors(null);
		}
	}

}