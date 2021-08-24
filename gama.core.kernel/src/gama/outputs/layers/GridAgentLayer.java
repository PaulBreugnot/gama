/*******************************************************************************************************
 *
 * GridAgentLayer.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.outputs.layers;

import java.awt.geom.Rectangle2D;

import gama.common.interfaces.IKeyword;
import gama.common.ui.IGraphics;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.IShape;
import gama.runtime.ExecutionResult;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaColor;
import gaml.operators.Cast;
import gaml.statements.IExecutable;
import gaml.statements.draw.DrawingAttributes;
import gaml.statements.draw.ShapeDrawingAttributes;

/**
 * The Class GridAgentLayer.
 */
public class GridAgentLayer extends AgentLayer {

	/**
	 * Instantiates a new grid agent layer.
	 *
	 * @param layer the layer
	 */
	public GridAgentLayer(final ILayerStatement layer) {
		super(layer);
	}

	@Override
	protected ILayerData createData() {
		return new GridLayerData(definition);
	}

	@Override
	public GridLayerData getData() {
		return (GridLayerData) super.getData();
	}

	@Override
	public void privateDraw(final IScope s, final IGraphics gr) throws GamaRuntimeException {
		final GamaColor borderColor = getData().drawLines() ? getData().getLineColor() : null;
		final IExecutable aspect = sc -> {
			final IAgent agent = sc.getAgent();
			final IGraphics g = sc.getGraphics();
			try {
				if (agent == sc.getGui().getHighlightedAgent()) {
					g.beginHighlight();
				}
				final GamaColor color = Cast.asColor(sc, agent.getDirectVarValue(sc, IKeyword.COLOR));
				final IShape ag = agent.getGeometry();
				final IShape ag2 = ag.copy(sc);
				final DrawingAttributes attributes = new ShapeDrawingAttributes(ag2, agent, color, borderColor);
				return g.drawShape(ag2.getInnerGeometry(), attributes);
			} catch (final GamaRuntimeException e) {
				// cf. Issue 1052: exceptions are not thrown, just displayed
				e.printStackTrace();
			} finally {
				g.endHighlight();
			}
			return null;
		};

		for (final IAgent a : getData().getAgentsToDisplay()) {
			if (a != null) {
				final ExecutionResult result = s.execute(aspect, a, null);
				final Object r = result.getValue();
				if (r instanceof Rectangle2D) {
					shapes.put(a, (Rectangle2D) r);
				}
			}
		}

	}

}
