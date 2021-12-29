/*******************************************************************************************************
 *
 * CameraPositionUnitExpression.java, in gama.core.kernel, is part of the source code of the GAMA modeling and
 * simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.expressions.units;

import gama.common.ui.IDisplaySurface;
import gama.common.ui.IGraphics;
import gama.metamodel.shape.GamaPoint;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.runtime.IScope.IGraphicsScope;
import gaml.types.Types;

/**
 * The Class CameraPositionUnitExpression.
 */
public class CameraPositionUnitExpression extends UnitConstantExpression {

	/**
	 * Instantiates a new camera position unit expression.
	 *
	 * @param doc
	 *            the doc
	 */
	public CameraPositionUnitExpression(final String doc) {
		super(new GamaPoint(), Types.POINT, "camera_location", doc, null);
	}

	@Override
	public GamaPoint _value(final IScope sc) {
		if (sc == null || !sc.isGraphics()) {
			IDisplaySurface surface = GAMA.getGui().getFrontmostDisplaySurface();
			if (surface != null) return surface.getData().getCameraPos().clone();
			return null;
		}
		IGraphicsScope scope = (IGraphicsScope) sc;
		final IGraphics g = scope.getGraphics();
		if (g.is2D()) return null;
		return ((IGraphics.ThreeD) g).getCameraPos().clone();
	}

	@Override
	public boolean isConst() { return false; }

}
