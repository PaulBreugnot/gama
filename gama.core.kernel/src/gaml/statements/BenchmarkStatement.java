/*******************************************************************************************************
 *
 * BenchmarkStatement.java, in gama.core.kernel, is part of the source code of the
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
import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;
import gaml.operators.Cast;
import gaml.types.IType;

/**
 * Class TraceStatement.
 *
 * @author drogoul
 * @since 23 févr. 2014
 *
 */
@symbol (
		name = "benchmark",
		kind = ISymbolKind.SEQUENCE_STATEMENT,
		with_sequence = true,
		concept = { IConcept.TEST })
@facets (
		omissible = IKeyword.MESSAGE,
		value = { @facet (
				name = IKeyword.MESSAGE,
				type = IType.NONE,
				optional = true,
				doc = @doc ("A message to display alongside the results. Should concisely describe the contents of the benchmark")),
				@facet (
						name = IKeyword.REPEAT,
						type = IType.INT,
						optional = true,
						doc = @doc ("An int expression describing how many executions of the block must be handled. The output in this case will return the min, max and average durations")) })
@inside (
		kinds = { ISymbolKind.BEHAVIOR, ISymbolKind.SEQUENCE_STATEMENT, ISymbolKind.LAYER })
@doc (
		value = "Displays in the console the duration in ms of the execution of the statements included in the block. It is possible to indicate, with the 'repeat' facet, how many times the sequence should be run")
public class BenchmarkStatement extends AbstractStatementSequence {

	/** The message. */
	final IExpression repeat, message;

	/**
	 * Instantiates a new benchmark statement.
	 *
	 * @param desc the desc
	 */
	public BenchmarkStatement(final IDescription desc) {
		super(desc);
		repeat = getFacet(IKeyword.REPEAT);
		message = getFacet(IKeyword.MESSAGE);
	}

	@Override
	public Object privateExecuteIn(final IScope scope) throws GamaRuntimeException {
		final int repeatTimes = repeat == null ? 1 : Cast.asInt(scope, repeat.value(scope));
		double min = Long.MAX_VALUE;
		int timeOfMin = 0;
		double max = Long.MIN_VALUE;
		int timeOfMax = 0;
		double total = 0;

		for (int i = 0; i < repeatTimes; i++) {
			final long begin = System.nanoTime();
			super.privateExecuteIn(scope);
			final long end = System.nanoTime();
			final double duration = (end - begin) / 1000000d;
			if (min > duration) {
				min = duration;
				timeOfMin = i;
			}
			if (max < duration) {
				max = duration;
				timeOfMax = i;
			}
			total += duration;
		}
		final String title = message == null ? "Execution time " : Cast.asString(scope, message.value(scope));
		final String result = title + " (over " + repeatTimes + " iteration(s)): min = " + min + " ms (iteration #"
				+ timeOfMin + ") | max = " + max + " ms (iteration #" + timeOfMax + ") | average = "
				+ total / repeatTimes + "ms";
		scope.getGui().getConsole().informConsole(result, scope.getRoot(), null);
		return result;
	}

}
