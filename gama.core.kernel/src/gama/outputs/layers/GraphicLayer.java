/*******************************************************************************************************
 *
 * GraphicLayer.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.outputs.layers;

import gama.common.interfaces.IKeyword;
import gama.common.ui.IGraphics;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope.IGraphicsScope;
import gama.runtime.exceptions.GamaRuntimeException;

/**
 * The Class GraphicLayer.
 */
public class GraphicLayer extends AbstractLayer {

	/**
	 * Instantiates a new graphic layer.
	 *
	 * @param layer
	 *            the layer
	 */
	public GraphicLayer(final ILayerStatement layer) {
		super(layer);
	}

	@Override
	protected void privateDraw(final IGraphicsScope scope, final IGraphics g) throws GamaRuntimeException {
		final IAgent agent = scope.getAgent();
		scope.execute(((GraphicLayerStatement) definition).getAspect(), agent, null);
	}

	@Override
	public String getType() { return IKeyword.GRAPHICS; }

	// Just a trial to make sure that graphics + chart produce not proportional results.
	@Override
	public boolean stayProportional() {
		return false;
	}
}
