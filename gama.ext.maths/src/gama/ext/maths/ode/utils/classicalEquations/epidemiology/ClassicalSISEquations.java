/*******************************************************************************************************
 *
 * ClassicalSISEquations.java, in gama.ext.maths, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.maths.ode.utils.classicalEquations.epidemiology;

import java.util.ArrayList;
import java.util.List;

import gama.ext.maths.ode.statements.SingleEquationStatement;
import gaml.compilation.GAML;
import gaml.descriptions.IDescription;
import gaml.descriptions.StatementDescription;
import gaml.expressions.IExpression;
import gaml.expressions.data.ListExpression;

// SIS equation is defined by
// diff(S,t) = -beta * S * I / N + gamma * I;
// diff(I,t) = beta * S * I / N - gamma * I;
//
// It is called using
// equation eqSIS type: SIS vars: [S,I,t] params: [N,beta,gamma]

/**
 * The Class ClassicalSISEquations.
 */
public class ClassicalSISEquations {
	
	/** The parent desc. */
	private final IDescription parentDesc;

	/**
	 * Instantiates a new classical SIS equations.
	 *
	 * @param p the p
	 */
	public ClassicalSISEquations(final IDescription p) {
		parentDesc = p;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public IDescription getDescription() {
		return parentDesc;
	}

	/**
	 * Sis.
	 *
	 * @param with_vars the with vars
	 * @param with_params the with params
	 * @return the list
	 */
	public List<SingleEquationStatement> SIS(final ListExpression with_vars, final ListExpression with_params) {
		if (with_vars == null || with_params == null) return null;
		final ArrayList<SingleEquationStatement> cmd = new ArrayList<>();
		final IExpression[] v = with_vars.getElements();
		final IExpression[] p = with_params.getElements();

		final StatementDescription stm = new StatementDescription("=", getDescription(), false, null, null, null);

		final SingleEquationStatement eq1 = new SingleEquationStatement(stm);
		eq1.setFunction(GAML.getExpressionFactory()
				.createExpr("diff(" + v[0].literalValue() + "," + v[2].literalValue() + ")", getDescription()));
		eq1.setExpression(GAML.getExpressionFactory().createExpr(
				"(- " + p[1].literalValue() + " * " + v[0].literalValue() + " * " + v[1].literalValue() + " / "
						+ p[0].literalValue() + ") + (" + p[2].literalValue() + " * " + v[1].literalValue() + ")",
				getDescription()));
		// eq1.establishVar();
		cmd.add(eq1);

		final SingleEquationStatement eq2 = new SingleEquationStatement(stm);
		eq2.setFunction(GAML.getExpressionFactory()
				.createExpr("diff(" + v[1].literalValue() + "," + v[2].literalValue() + ")", getDescription()));
		eq2.setExpression(GAML.getExpressionFactory().createExpr(
				"( " + p[1].literalValue() + " * " + v[0].literalValue() + " * " + v[1].literalValue() + " / "
						+ p[0].literalValue() + ") + ( - " + p[2].literalValue() + " * " + v[1].literalValue() + ")",
				getDescription()));
		// eq2.establishVar();
		cmd.add(eq2);

		return cmd;
	}

}
