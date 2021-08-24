/*******************************************************************************************************
 *
 * DrawExecuter.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.statements.draw;

import java.awt.geom.Rectangle2D;

import gama.common.ui.IGraphics;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.expressions.IExpression;

/**
 * The Class DrawExecuter.
 */
abstract class DrawExecuter {

	/** The item. */
	final IExpression item;

	/**
	 * Instantiates a new draw executer.
	 *
	 * @param item the item
	 */
	DrawExecuter(final IExpression item) {
		this.item = item.isConst() ? null : item;
	}

	/**
	 * Execute on.
	 *
	 * @param agent the agent
	 * @param g the g
	 * @param data the data
	 * @return the rectangle 2 D
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	abstract Rectangle2D executeOn(IScope agent, IGraphics g, DrawingData data) throws GamaRuntimeException;

}