/*******************************************************************************************************
 *
 * msi.gama.outputs.layers.GraphicLayer.java, in plugin msi.gama.core, is part of the source code of the GAMA modeling
 * and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.outputs.layers;

import gama.common.interfaces.IKeyword;
import gama.common.ui.IGraphics;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;

public class GraphicLayer extends AbstractLayer {

	public GraphicLayer(final ILayerStatement layer) {
		super(layer);
	}

	@Override
	protected void privateDraw(final IScope scope, final IGraphics g) throws GamaRuntimeException {
		final IAgent agent = scope.getAgent();
		scope.execute(((GraphicLayerStatement) definition).getAspect(), agent, null);
	}

	@Override
	public String getType() {
		return IKeyword.GRAPHICS;
	}

	// Just a trial to make sure that graphics + chart produce not proportional results.
	@Override
	public boolean stayProportional() {
		return false;
	}
}
