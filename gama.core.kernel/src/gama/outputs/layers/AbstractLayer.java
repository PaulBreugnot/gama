/*******************************************************************************************************
 *
 * AbstractLayer.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.outputs.layers;

import gama.common.ui.IGraphics;
import gama.common.ui.ILayer;
import gama.runtime.IScope.IGraphicsScope;
import gama.runtime.exceptions.GamaRuntimeException;

// TODO: Auto-generated Javadoc
/**
 * Written by drogoul Modified on 9 nov. 2009
 *
 * @todo Description
 *
 */
public abstract class AbstractLayer implements ILayer {

	/** The definition. */
	protected ILayerStatement definition;

	/** The name. */
	private String name;

	/** The has been drawn once. */
	boolean hasBeenDrawnOnce;

	/** The data. */
	private final ILayerData data;

	/**
	 * Instantiates a new abstract layer.
	 *
	 * @param layer
	 *            the layer
	 */
	public AbstractLayer(final ILayerStatement layer) {
		definition = layer;
		if (definition != null) { setName(definition.getName()); }
		data = createData();
	}

	/**
	 * Gets the definition.
	 *
	 * @return the definition
	 */
	@Override
	public ILayerStatement getDefinition() { return definition; }

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	@Override
	public ILayerData getData() { return data; }

	/**
	 * Creates the data.
	 *
	 * @return the i layer data
	 */
	protected ILayerData createData() {
		return new LayerData(definition);
	}

	/**
	 * Force redrawing once.
	 */
	@Override
	public void forceRedrawingOnce() {
		hasBeenDrawnOnce = false;
	}

	/**
	 * Draw.
	 *
	 * @param scope
	 *            the scope
	 * @param g
	 *            the g
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	@Override
	public void draw(final IGraphicsScope scope, final IGraphics g) throws GamaRuntimeException {
		if (shouldNotDraw(g)) return;
		g.setAlpha(1 - getData().getTransparency(scope));
		g.beginDrawingLayer(this);
		privateDraw(scope, g);
		g.endDrawingLayer(this);
		hasBeenDrawnOnce = true;
	}

	/**
	 * A layer should not be drawn if it has been drawn once and either (1) it is considered as static (and we are in
	 * OpenGL), or (2) the graphics environment is not ready to update (we skip one frame).
	 *
	 * @param g
	 *            the IGraphics instance on which we draw
	 * @return true if ok to draw, false otherwise
	 */
	protected boolean shouldNotDraw(final IGraphics g) {
		return !getData().isVisible()
				|| hasBeenDrawnOnce && (!g.is2D() && !getData().isDynamic() || g.isNotReadyToUpdate());
	}

	/**
	 * Private draw.
	 *
	 * @param scope
	 *            the scope
	 * @param g
	 *            the g
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	protected abstract void privateDraw(IGraphicsScope scope, final IGraphics g) throws GamaRuntimeException;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Override
	public final String getName() { return name; }

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	@Override
	public final void setName(final String name) { this.name = name; }

}
