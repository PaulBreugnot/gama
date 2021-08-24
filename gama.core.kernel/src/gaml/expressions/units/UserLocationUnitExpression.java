/*******************************************************************************************************
 *
 * UserLocationUnitExpression.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.expressions.units;

import gama.metamodel.shape.GamaPoint;
import gama.runtime.IScope;
import gaml.types.Types;

/**
 * The Class UserLocationUnitExpression.
 */
public class UserLocationUnitExpression extends UnitConstantExpression {

	/**
	 * Instantiates a new user location unit expression.
	 *
	 * @param doc the doc
	 */
	public UserLocationUnitExpression(final String doc) {
		super(new GamaPoint(), Types.POINT, "user_location", doc, null);
	}

	@Override
	public GamaPoint _value(final IScope scope) {
		return scope.getGui().getMouseLocationInModel();
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
