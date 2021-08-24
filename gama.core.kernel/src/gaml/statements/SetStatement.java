/*******************************************************************************************************
 *
 * SetStatement.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.statements;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.facet;
import gama.core.dev.annotations.GamlAnnotations.facets;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.compilation.GAML;
import gaml.compilation.IDescriptionValidator;
import gaml.compilation.annotations.serializer;
import gaml.compilation.annotations.validator;
import gaml.descriptions.IDescription;
import gaml.descriptions.IExpressionDescription;
import gaml.descriptions.ModelDescription;
import gaml.descriptions.SymbolDescription;
import gaml.descriptions.SymbolSerializer;
import gaml.expressions.IExpression;
import gaml.expressions.IVarExpression;
import gaml.operators.Cast;
import gaml.statements.SetStatement.AssignmentSerializer;
import gaml.statements.SetStatement.AssignmentValidator;
import gaml.types.IType;

/**
 * Written by drogoul Modified on 6 févr. 2010
 *
 * @todo Description
 *
 */

@facets (
		value = { /*
					 * @facet(name = IKeyword.VAR, type = IType.NONE, optional = true),
					 */
				@facet (
						name = IKeyword.NAME,
						type = IType.NONE,
						optional = false,
						doc = @doc ("the name of an existing variable or attribute to be modified")),
				@facet (
						name = IKeyword.VALUE,
						type = { IType.NONE },
						optional = false,
						doc = @doc ("the value to affect to the variable or attribute")) },
		omissible = IKeyword.NAME)
@symbol (
		name = { IKeyword.SET },
		kind = ISymbolKind.SINGLE_STATEMENT,
		concept = { IConcept.ATTRIBUTE },
		with_sequence = false)
@inside (
		kinds = { ISymbolKind.BEHAVIOR, ISymbolKind.SEQUENCE_STATEMENT, ISymbolKind.LAYER },
		symbols = IKeyword.CHART)
@validator (AssignmentValidator.class)
@doc (
		value = "Allows to assign a value to the variable or attribute specified")
@serializer (AssignmentSerializer.class)
public class SetStatement extends AbstractStatement {

	/**
	 * The Class AssignmentSerializer.
	 */
	public static class AssignmentSerializer extends SymbolSerializer<SymbolDescription> {

		@Override
		protected void serialize(final SymbolDescription desc, final StringBuilder sb, final boolean includingBuiltIn) {
			if (desc == null) { return; }
			final IExpressionDescription ed = desc.getFacet(VALUE);
			if (ed == null) { return; }
			final String exp = ed.serialize(includingBuiltIn);
			if (exp == null) { return; }
			sb.append(desc.getName());
			sb.append(" <- ");
			sb.append(exp);
			sb.append(";");
		}

	}

	/**
	 * The Class AssignmentValidator.
	 */
	public static class AssignmentValidator implements IDescriptionValidator<IDescription> {

		/**
		 * Method validate()
		 *
		 * @see gaml.compilation.IDescriptionValidator#validate(gaml.descriptions.IDescription)
		 */
		@Override
		public void validate(final IDescription cd) {
			final IExpressionDescription receiver = cd.getFacet(NAME);
			// String name = cd.getName();
			final IExpression expr = receiver.getExpression();
			if (!(expr instanceof IVarExpression)) {
				cd.error("The expression " + cd.getLitteral(NAME) + " is not a reference to a variable ", NAME);
				return;
			}
			final IVarExpression var = (IVarExpression) expr;
			final IExpressionDescription assigned = cd.getFacet(VALUE);
			if (assigned != null) {
				Assert.typesAreCompatibleForAssignment(VALUE, cd, Cast.toGaml(expr), expr.getGamlType(), assigned);
			}

			// AD 19/1/13: test of the constants
			if (var.getVar().isNotModifiable()) {
				cd.error("The variable " + expr.serialize(false)
						+ " is a constant or a function and cannot be assigned a value.", IKeyword.NAME);
			}

			if (var.getName().equals(IKeyword.SHAPE)) {
				if (cd.getSpeciesContext() instanceof ModelDescription) {
					cd.warning(
							"Dynamically changing the shape of the world can lead to unexpected results. It is advised to redefine the attribute instead (e.g. 'geometry shape <- "
									+ (assigned == null ? "..." : assigned.serialize(false)) + "')",
							IKeyword.NAME);
				}
			}

		}
	}

	/** The var expr. */
	protected final IVarExpression varExpr;
	
	/** The value. */
	protected final IExpression value;

	/**
	 * Instantiates a new sets the statement.
	 *
	 * @param desc the desc
	 */
	public SetStatement(final IDescription desc) {
		super(desc);
		varExpr = (IVarExpression) getFacet(IKeyword.NAME);
		setName(IKeyword.SET + getVarName());
		final IExpression expr = getFacet(IKeyword.VALUE);
		if (expr == null) {
			value = GAML.getExpressionFactory().createConst(varExpr.getGamlType().getDefault(), varExpr.getGamlType());
		} else {
			value = expr;
		}

	}

	@Override
	protected Object privateExecuteIn(final IScope scope) throws GamaRuntimeException {
		final Object val = value.value(scope);
		varExpr.setVal(scope, val, false);
		return val;
	}

	/**
	 * Gets the var name.
	 *
	 * @return the var name
	 */
	public String getVarName() {
		if (varExpr != null) { return varExpr.literalValue(); }
		return null;
	}

}
