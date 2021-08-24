/*******************************************************************************************************
 *
 * IOperator.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.expressions.operators;

import gama.common.interfaces.IBenchmarkable;
import gaml.descriptions.OperatorProto;
import gaml.expressions.IExpression;

/**
 * Written by drogoul Modified on 22 ao�t 2010.
 *
 * @todo Description
 */
public interface IOperator extends IExpression, IBenchmarkable {

	/**
	 * The Interface IOperatorVisitor.
	 */
	@FunctionalInterface
	public static interface IOperatorVisitor {
		
		/**
		 * Visit.
		 *
		 * @param operator the operator
		 */
		void visit(IOperator operator);
	}

	/**
	 * Visit suboperators.
	 *
	 * @param visitor the visitor
	 */
	public abstract void visitSuboperators(IOperatorVisitor visitor);

	/**
	 * Arg.
	 *
	 * @param i the i
	 * @return the i expression
	 */
	public abstract IExpression arg(int i);

	/**
	 * Gets the prototype.
	 *
	 * @return the prototype
	 */
	public abstract OperatorProto getPrototype();

	/**
	 * Gets the name for benchmarks.
	 *
	 * @return the name for benchmarks
	 */
	@Override
	default String getNameForBenchmarks() {
		return serialize(true);
	}

}