/*******************************************************************************************************
 *
 * DisplayWidthUnitExpression.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.expressions.units;

import gama.common.ui.IGraphics;
import gama.runtime.IScope;
import gaml.types.Types;

/**
 * The Class DisplayWidthUnitExpression.
 */
public class DisplayWidthUnitExpression extends UnitConstantExpression {

	/**
	 * Instantiates a new display width unit expression.
	 *
	 * @param doc the doc
	 */
	public DisplayWidthUnitExpression(final String doc) {
		super(0.0, Types.FLOAT, "display_width", doc, null);
	}

	@Override
	public Double _value(final IScope scope) {
		final IGraphics g = scope.getGraphics();
		if (g == null) { return 0d; }
		return (double) g.getDisplayWidth();
		// return (double) g.getEnvironmentWidth();
	}

	@Override
	public boolean isConst() {
		return false;
	}

	@Override
	public boolean isContextIndependant() {
		return false;
	}

}
