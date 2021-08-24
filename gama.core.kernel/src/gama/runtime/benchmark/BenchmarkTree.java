/*******************************************************************************************************
 *
 * BenchmarkTree.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.runtime.benchmark;

import gama.common.interfaces.IBenchmarkable;
import gama.util.tree.GamaNode;
import gama.util.tree.GamaTree;
import gaml.descriptions.ExperimentDescription;
import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;
import gaml.expressions.operators.IOperator;

/**
 * The Class BenchmarkTree.
 */
public class BenchmarkTree extends GamaTree<IBenchmarkable> {

	/**
	 * Instantiates a new benchmark tree.
	 *
	 * @param model the model
	 * @param focusedExperiment the focused experiment
	 */
	public BenchmarkTree(final IDescription model, final ExperimentDescription focusedExperiment) {
		setRoot(new GamaNode<>(model, 0));
		build(model, focusedExperiment, getRoot(), 1);
	}

	/**
	 * Builds the.
	 *
	 * @param desc the desc
	 * @param focusedExperiment the focused experiment
	 * @param node the node
	 * @param level the level
	 */
	private void build(final IDescription desc, final ExperimentDescription focusedExperiment,
			final GamaNode<IBenchmarkable> node, final int level) {
		desc.visitFacets((name, exp) -> {
			final IExpression expr = exp.getExpression();
			if (expr instanceof IOperator) {
				final IOperator op = (IOperator) expr;
				final GamaNode<IBenchmarkable> newNode = node.addChild(new GamaNode<>(op, level));
				build(op, newNode, level + 1);
			}
			return true;
		});
		desc.visitOwnChildren((d) -> {
			if (d instanceof ExperimentDescription && !d.equals(focusedExperiment)) { return true; }
			final GamaNode<IBenchmarkable> newNode = node.addChild(new GamaNode<>(d, level));
			build(d, focusedExperiment, newNode, level + 1);
			return true;
		});
	}

	/**
	 * Builds the.
	 *
	 * @param op the op
	 * @param currentNode the current node
	 * @param level the level
	 */
	private void build(final IOperator op, final GamaNode<IBenchmarkable> currentNode, final int level) {
		op.visitSuboperators((o) -> {
			final GamaNode<IBenchmarkable> node = currentNode.addChild(new GamaNode<>(o, level));
			build(o, node, level + 1);
		});

	}

}
