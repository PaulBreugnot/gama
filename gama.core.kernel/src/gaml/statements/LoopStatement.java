/*******************************************************************************************************
 *
 * LoopStatement.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.statements;

import gama.common.interfaces.IGamlIssue;
import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.example;
import gama.core.dev.annotations.GamlAnnotations.facet;
import gama.core.dev.annotations.GamlAnnotations.facets;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.core.dev.annotations.GamlAnnotations.usage;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.IContainer;
import gaml.compilation.IDescriptionValidator;
import gaml.compilation.annotations.serializer;
import gaml.compilation.annotations.validator;
import gaml.descriptions.IDescription;
import gaml.descriptions.IExpressionDescription;
import gaml.descriptions.SymbolDescription;
import gaml.descriptions.SymbolSerializer;
import gaml.expressions.IExpression;
import gaml.operators.Cast;
import gaml.statements.IStatement.Breakable;
import gaml.statements.LoopStatement.LoopSerializer;
import gaml.statements.LoopStatement.LoopValidator;
import gaml.types.IType;
import gaml.types.Types;

// A group of commands that can be executed repeatedly.

/**
 * The Class LoopStatement.
 */
@symbol (
		name = IKeyword.LOOP,
		kind = ISymbolKind.SEQUENCE_STATEMENT,
		with_sequence = true,
		concept = { IConcept.LOOP })
@facets (
		value = { @facet (
				name = IKeyword.FROM,
				type = IType.INT,
				optional = true,
				doc = @doc ("an int expression")),
				@facet (
						name = IKeyword.TO,
						type = IType.INT,
						optional = true,
						doc = @doc ("an int expression")),
				@facet (
						name = IKeyword.STEP,
						type = IType.INT,
						optional = true,
						doc = @doc ("an int expression")),
				@facet (
						name = IKeyword.NAME,
						type = IType.NEW_TEMP_ID,
						optional = true,
						doc = @doc ("a temporary variable name")),
				@facet (
						name = IKeyword.OVER,
						type = { IType.CONTAINER, IType.POINT },
						optional = true,
						doc = @doc ("a list, point, matrix or map expression")),
				@facet (
						name = IKeyword.WHILE,
						type = IType.BOOL,
						optional = true,
						doc = @doc ("a boolean expression")),
				@facet (
						name = IKeyword.TIMES,
						type = IType.INT,
						optional = true,
						doc = @doc ("an int expression")) },
		omissible = IKeyword.NAME)
@inside (
		kinds = { ISymbolKind.BEHAVIOR, ISymbolKind.SEQUENCE_STATEMENT, ISymbolKind.LAYER })
@doc (
		value = "Allows the agent to perform the same set of statements either a fixed number of times, or while a condition is true, or by progressing in a collection of elements or along an interval of integers. Be aware that there are no prevention of infinite loops. As a consequence, open loops should be used with caution, as one agent may block the execution of the whole model.",
		usages = { @usage (
				value = "The basic syntax for repeating a fixed number of times a set of statements is:",
				examples = { @example (
						value = "loop times: an_int_expression {",
						isExecutable = false),
						@example (
								value = "     // [statements]",
								isExecutable = false),
						@example (
								value = "}",
								isExecutable = false),
						@example (
								value = "int sumTimes <- 1;",
								isTestOnly = true),
						@example (
								value = "loop times: 3 {sumTimes <- sumTimes + sumTimes;}",
								isTestOnly = true),
						@example (
								var = "sumTimes",
								equals = "8",
								isTestOnly = true) }),
				@usage (
						value = "The basic syntax for repeating a set of statements while a condition holds is:",
						examples = { @example (
								value = "loop while: a_bool_expression {",
								isExecutable = false),
								@example (
										value = "     // [statements]",
										isExecutable = false),
								@example (
										value = "}",
										isExecutable = false),
								@example (
										value = "int sumWhile <- 1;",
										isTestOnly = true),
								@example (
										value = "loop while: (sumWhile < 5) {sumWhile <- sumWhile + sumWhile;}",
										isTestOnly = true),
								@example (
										var = "sumWhile",
										equals = "8",
										isTestOnly = true) }),
				@usage (
						value = "The basic syntax for repeating a set of statements by progressing over a container of a point is:",
						examples = { @example (
								value = "loop a_temp_var over: a_collection_expression {",
								isExecutable = false),
								@example (
										value = "     // [statements]",
										isExecutable = false),
								@example (
										value = "}",
										isExecutable = false) }),
				@usage (
						value = "The basic syntax for repeating a set of statements while an index iterates over a range of values with a fixed step of 1 is:",
						examples = { @example (
								value = "loop a_temp_var from: int_expression_1 to: int_expression_2 {",
								isExecutable = false),
								@example (
										value = "     // [statements]",
										isExecutable = false),
								@example (
										value = "}",
										isExecutable = false) }),
				@usage (
						value = "The incrementation step of the index can also be chosen:",
						examples = { @example (
								value = "loop a_temp_var from: int_expression_1 to: int_expression_2 step: int_expression3 {",
								isExecutable = false),
								@example (
										value = "     // [statements]",
										isExecutable = false),
								@example (
										value = "}",
										isExecutable = false),
								@example (
										value = "int sumFor <- 0;",
										isTestOnly = true),
								@example (
										value = "loop i from: 10 to: 30 step: 10 {sumFor <- sumFor + i;}",
										isTestOnly = true),
								@example (
										var = "sumFor",
										equals = "60",
										isTestOnly = true) }),
				@usage (
						value = "In these latter three cases, the name facet designates the name of a temporary variable, whose scope is the loop, and that takes, in turn, the value of each of the element of the list (or each value in the interval). For example, in the first instance of the \"loop over\" syntax :",
						examples = { @example (
								value = "int a <- 0;"),
								@example (
										value = "loop i over: [10, 20, 30] {"),
								@example (
										value = "     a <- a + i;"),
								@example (
										value = "} // a now equals 60"),
								@example (
										var = "a",
										equals = "60",
										isTestOnly = true) }),
				@usage (
						value = "The second (quite common) case of the loop syntax allows one to use an interval of integers. The from and to facets take an integer expression as arguments, with the first (resp. the last) specifying the beginning (resp. end) of the inclusive interval (i.e. [to, from]). If the step is not defined, it is assumed to be equal to 1 or -1, depending on the direction of the range. If it is defined, its sign will be respected, so that a positive step will never allow the loop to enter a loop from i to j where i is greater than j",
						examples = { @example (
								value = "list the_list <-list (species_of (self));"),
								@example (
										value = "loop i from: 0 to: length (the_list) - 1 {"),
								@example (
										value = "     ask the_list at i {"),
								@example (
										value = "        // ..."),
								@example (
										value = "     }"),
								@example (
										value = "} // every  agent of the list is asked to do something") }) })
@serializer (LoopSerializer.class)
@validator (LoopValidator.class)
@SuppressWarnings ({ "rawtypes" })
public class LoopStatement extends AbstractStatementSequence implements Breakable {

	/**
	 * The Class LoopValidator.
	 */
	public static class LoopValidator implements IDescriptionValidator<IDescription> {

		/**
		 * Method validate()
		 *
		 * @see gaml.compilation.IDescriptionValidator#validate(gaml.descriptions.IDescription)
		 */
		@Override
		public void validate(final IDescription description) {
			final IExpressionDescription times = description.getFacet(TIMES);
			final IExpressionDescription over = description.getFacet(OVER);
			final IExpressionDescription from = description.getFacet(FROM);
			final IExpressionDescription to = description.getFacet(TO);
			// final IExpressionDescription step = description.getFacet(STEP);
			final IExpressionDescription cond = description.getFacet(WHILE);
			IExpressionDescription name = description.getFacet(NAME);
			if (name != null && name.isConst() && name.toString().startsWith(INTERNAL)) { name = null; }
			// See Issue #3085
			if (name != null) { Assert.nameIsValid(description); }
			if (times != null) {
				if (over != null) {
					description.error("'times' and 'over' are not compatible", IGamlIssue.CONFLICTING_FACETS, TIMES,
							OVER);
					return;
				}
				if (cond != null) {
					description.error("'times' and 'while' are not compatible", IGamlIssue.CONFLICTING_FACETS, TIMES,
							WHILE);
					return;
				}
				if (from != null) {
					description.error("'times' and 'from' are not compatible", IGamlIssue.CONFLICTING_FACETS, TIMES,
							FROM);
					return;
				}
				if (to != null) {
					description.error("'times' and 'to' are not compatible", IGamlIssue.CONFLICTING_FACETS, TIMES, TO);
					return;
				}
				if (name != null) { description.error("No variable should be declared", IGamlIssue.UNUSED, NAME); }
			} else if (over != null) {
				if (cond != null) {
					description.error("'over' and 'while' are not compatible", IGamlIssue.CONFLICTING_FACETS, OVER,
							WHILE);
					return;
				}
				if (from != null) {
					description.error("'over' and 'from' are not compatible", IGamlIssue.CONFLICTING_FACETS, OVER,
							FROM);
					return;
				}
				if (to != null) {
					description.error("'over' and 'to' are not compatible", IGamlIssue.CONFLICTING_FACETS, OVER, TO);
					return;
				}
				if (name == null) { description.error("No variable has been declared", IGamlIssue.MISSING_NAME, OVER); }
			} else if (cond != null) {
				if (from != null) {
					description.error("'while' and 'from' are not compatible", IGamlIssue.CONFLICTING_FACETS, WHILE,
							FROM);
					return;
				}
				if (to != null) {
					description.error("'while' and 'to' are not compatible", IGamlIssue.CONFLICTING_FACETS, WHILE, TO);
					return;
				}
				if (name != null) {
					description.error("No variable should be declared", IGamlIssue.UNUSED, WHILE, NAME);
				}
			} else if (from != null) {
				if (name == null) {
					description.error("No variable has been declared", IGamlIssue.MISSING_NAME, NAME);
					return;
				}
				if (to == null) {
					description.error("'loop' is missing the 'to:' facet", IGamlIssue.MISSING_FACET,
							description.getUnderlyingElement(), TO, "0");
				}
			} else if (to != null) {
				description.error("'loop' is missing the 'from:' facet", IGamlIssue.MISSING_FACET,
						description.getUnderlyingElement(), FROM, "0");
			} else {
				description.error("Missing the definition of the kind of loop to perform (times, over, while, from/to)",
						IGamlIssue.MISSING_FACET);
			}
		}

	}

	/**
	 * The Class LoopSerializer.
	 */
	public static class LoopSerializer extends SymbolSerializer<SymbolDescription> {

		@Override
		protected String serializeFacetValue(final SymbolDescription s, final String key,
				final boolean includingBuiltIn) {
			if (key.equals(NAME)) { if (s.hasFacet(TIMES) || s.hasFacet(WHILE)) return null; }
			return super.serializeFacetValue(s, key, includingBuiltIn);
		}

	}

	/** The executer. */
	private final LoopExecuter executer;
	
	/** The var name. */
	private final String varName;
	// private final Object[] result = new Object[1];

	/**
	 * Instantiates a new loop statement.
	 *
	 * @param desc the desc
	 */
	public LoopStatement(final IDescription desc) {
		super(desc);
		final boolean isWhile = getFacet(IKeyword.WHILE) != null;
		final boolean isList = getFacet(IKeyword.OVER) != null;
		final boolean isBounded = getFacet(IKeyword.FROM) != null && getFacet(IKeyword.TO) != null;
		varName = desc.getName();
		executer = isWhile ? new While() : isList ? new Over() : isBounded ? new Bounded() : new Times();
	}

	@Override
	public void enterScope(final IScope scope) {
		// 25/02/14: Suppressed because already done in loopBody() :
		// super.enterScope(scope);

		// if (varName != null) { scope.addVarWithValue(varName, null); }
	}

	@Override
	public void leaveScope(final IScope scope) {
		// Should clear any _loop_halted status present
		// if (varName != null) { scope.removeAllVars(); }
		scope.popLoop();
	}

	@Override
	public Object privateExecuteIn(final IScope scope) throws GamaRuntimeException {
		return executer.runIn(scope);
	}

	/**
	 * Loop body.
	 *
	 * @param scope the scope
	 * @param var the var
	 * @param result the result
	 * @return true, if successful
	 */
	protected boolean loopBody(final IScope scope, final Object var, final Object[] result) {
		scope.push(this);
		// We set it explicitely to the newly created scope
		if (varName != null) { scope.setVarValue(varName, var, true); }
		result[0] = super.privateExecuteIn(scope);
		scope.pop(this);
		return !scope.interrupted();
	}

	/**
	 * The Interface LoopExecuter.
	 */
	interface LoopExecuter {

		/**
		 * Run in.
		 *
		 * @param scope the scope
		 * @return the object
		 */
		Object runIn(final IScope scope);
	}

	/**
	 * The Class Bounded.
	 */
	class Bounded implements LoopExecuter {

		/** The from. */
		private final IExpression from = getFacet(IKeyword.FROM);
		
		/** The to. */
		private final IExpression to = getFacet(IKeyword.TO);
		
		/** The step. */
		private final IExpression step = getFacet(IKeyword.STEP);
		
		/** The constant step. */
		private Integer constantFrom, constantTo, constantStep;
		
		/** The step defined. */
		private final boolean stepDefined;

		/**
		 * Instantiates a new bounded.
		 *
		 * @throws GamaRuntimeException the gama runtime exception
		 */
		Bounded() throws GamaRuntimeException {
			final IScope scope = null;
			// final IScope scope = GAMA.obtainNewScope();
			if (from.isConst()) { constantFrom = Cast.asInt(scope, from.value(scope)); }
			if (to.isConst()) { constantTo = Cast.asInt(scope, to.value(scope)); }
			if (step == null) {
				stepDefined = false;
				constantStep = 1;
			} else if (step.isConst()) {
				stepDefined = true;
				constantStep = Cast.asInt(scope, step.value(scope));
			} else {
				stepDefined = true;
			}
		}

		@Override
		public Object runIn(final IScope scope) throws GamaRuntimeException {
			final Object[] result = new Object[1];
			final int f = constantFrom == null ? Cast.asInt(scope, from.value(scope)) : constantFrom;
			final int t = constantTo == null ? Cast.asInt(scope, to.value(scope)) : constantTo;
			int s = constantStep == null ? Cast.asInt(scope, step.value(scope)) : constantStep;
			final boolean negative = f - t > 0;
			// if ( f == t ) { return null; }
			if (negative) {
				if (s > 0) {
					if (!stepDefined) {
						s = -s;
					} else
						return null;
				}
				for (int i = f, n = t - 1; i > n && loopBody(scope, i, result); i += s) {}
			} else {
				for (int i = f, n = t + 1; i < n && loopBody(scope, i, result); i += s) {}
			}
			return result[0];
		}
	}

	/**
	 * The Class Over.
	 */
	class Over implements LoopExecuter {

		/** The over. */
		private final IExpression over = getFacet(IKeyword.OVER);

		@Override
		public Object runIn(final IScope scope) throws GamaRuntimeException {
			final Object[] result = new Object[1];
			final Object obj = over.value(scope);
			final Iterable list_ =
					!(obj instanceof IContainer) ? Cast.asList(scope, obj) : ((IContainer) obj).iterable(scope);
			for (final Object each : list_) {
				if (!loopBody(scope, each, result)) { break; }
			}
			return result[0];
		}
	}

	/**
	 * The Class Times.
	 */
	class Times implements LoopExecuter {

		/** The times. */
		private final IExpression times = getFacet(IKeyword.TIMES);
		
		/** The constant times. */
		private Integer constantTimes;

		/**
		 * Instantiates a new times.
		 *
		 * @throws GamaRuntimeException the gama runtime exception
		 */
		Times() throws GamaRuntimeException {
			if (times.isConst()) { constantTimes = Types.INT.cast(null, times.getConstValue(), null, false); }
		}

		@Override
		public Object runIn(final IScope scope) throws GamaRuntimeException {
			final Object[] result = new Object[1];
			final int max = constantTimes == null ? Cast.asInt(scope, times.value(scope)) : constantTimes;
			for (int i = 0; i < max && loopBody(scope, null, result); i++) {}
			return result[0];
		}

	}

	/**
	 * The Class While.
	 */
	class While implements LoopExecuter {

		/** The cond. */
		private final IExpression cond = getFacet(IKeyword.WHILE);

		@Override
		public Object runIn(final IScope scope) throws GamaRuntimeException {
			final Object[] result = new Object[1];
			while (Cast.asBool(scope, cond.value(scope)) && loopBody(scope, null, result)) {}
			return result[0];
		}
	}

}