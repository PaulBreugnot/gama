/*******************************************************************************************************
 *
 * ummisco.gama.opengl.scene.layers.FrameLayerObject.java, in plugin ummisco.gama.opengl, is part of the source code of
 * the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.display.opengl.scene.layers;

import java.util.List;

import gama.display.opengl.renderer.IOpenGLRenderer;
import gama.display.opengl.scene.AbstractObject;
import gama.display.opengl.scene.geometry.GeometryObject;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.util.GamaColor;
import gaml.statements.draw.DrawingAttributes;
import gaml.statements.draw.ShapeDrawingAttributes;
import gaml.types.GamaGeometryType;

public class FrameLayerObject extends StaticLayerObject.World {

	private static final GamaColor FRAME = new GamaColor(150, 150, 150, 255);

	public FrameLayerObject(final IOpenGLRenderer renderer) {
		super(renderer);
	}

	@Override
	public void fillWithObjects(final List<AbstractObject<?, ?>> list) {
		final double w = renderer.getData().getEnvWidth();
		final double h = renderer.getData().getEnvHeight();
		final IShape g = GamaGeometryType.buildRectangle(w, h, new GamaPoint(w / 2, h / 2));
		final DrawingAttributes drawingAttr = new ShapeDrawingAttributes(g, (IAgent) null, null, FRAME);
		drawingAttr.setLighting(false);
		final GeometryObject geomObj = new GeometryObject(g.getInnerGeometry(), drawingAttr);
		list.add(geomObj);
	}
}