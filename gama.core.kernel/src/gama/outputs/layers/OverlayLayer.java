/*******************************************************************************************************
 *
 * OverlayLayer.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.outputs.layers;

import java.awt.geom.Rectangle2D;

import gama.common.interfaces.IKeyword;
import gama.common.ui.IDisplaySurface;
import gama.common.ui.IGraphics;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.IShape;
import gama.runtime.IScope.IGraphicsScope;
import gama.runtime.exceptions.GamaRuntimeException;

/**
 * Class OverlayLayer.
 *
 * @author drogoul
 * @since 23 févr. 2016
 *
 */
public class OverlayLayer extends GraphicLayer {

	/**
	 * Instantiates a new overlay layer.
	 *
	 * @param layer
	 *            the layer
	 */
	public OverlayLayer(final ILayerStatement layer) {
		super(layer);
	}

	@Override
	public boolean isOverlay() { return true; }

	@Override
	protected OverlayLayerData createData() {
		return new OverlayLayerData(definition);
	}

	@Override
	public OverlayLayerData getData() { return (OverlayLayerData) super.getData(); }

	@Override
	public Rectangle2D focusOn(final IShape geometry, final IDisplaySurface s) {
		return null;
	}

	@Override
	public String getType() { return IKeyword.OVERLAY; }

	@Override
	protected void privateDraw(final IGraphicsScope scope, final IGraphics g) throws GamaRuntimeException {
		g.beginOverlay(this);
		final IAgent agent = scope.getAgent();
		scope.execute(((OverlayStatement) definition).getAspect(), agent, null);
		g.endOverlay();
	}

	@Override
	public boolean isProvidingCoordinates() {
		return false; // by default
	}

	@Override
	public boolean isProvidingWorldCoordinates() {
		return false; // by default
	}

}
