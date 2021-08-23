/*******************************************************************************************************
 *
 * msi.gama.outputs.layers.GisLayer.java, in plugin msi.gama.core, is part of the source code of the GAMA modeling and
 * simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.outputs.layers;

import java.awt.Color;
import java.util.List;

import gama.common.interfaces.IKeyword;
import gama.common.preferences.GamaPreferences;
import gama.common.ui.IGraphics;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.IShape;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaColor;
import gama.util.file.GamaShapeFile;
import gaml.expressions.IExpression;
import gaml.operators.Cast;
import gaml.statements.draw.DrawingAttributes;
import gaml.statements.draw.ShapeDrawingAttributes;
import gaml.types.IType;

public class GisLayer extends AbstractLayer {

	IExpression gisExpression, colorExpression;

	public GisLayer(final ILayerStatement layer) {
		super(layer);
		gisExpression = layer.getFacet(IKeyword.GIS);
		colorExpression = layer.getFacet(IKeyword.COLOR);
	}

	@Override
	public void privateDraw(final IScope scope, final IGraphics g) {
		final GamaColor color =
				colorExpression == null ? GamaColor.getInt(GamaPreferences.Displays.CORE_COLOR.getValue().getRGB())
						: Cast.asColor(scope, colorExpression.value(scope));
		final List<IShape> shapes = buildGisLayer(scope);
		if (shapes != null) {
			for (final IShape geom : shapes) {
				if (geom != null) {
					final DrawingAttributes attributes =
							new ShapeDrawingAttributes(geom, (IAgent) null, color, new GamaColor(Color.black));
					g.drawShape(geom.getInnerGeometry(), attributes);
				}
			}
		}
	}

	public List<IShape> buildGisLayer(final IScope scope) throws GamaRuntimeException {
		final GamaShapeFile file = getShapeFile(scope);
		if (file == null) { return null; }
		return file.getContents(scope);
	}

	private GamaShapeFile getShapeFile(final IScope scope) {
		if (gisExpression == null) { return null; }
		if (gisExpression.getGamlType().id() == IType.STRING) {
			final String fileName = Cast.asString(scope, gisExpression.value(scope));
			return new GamaShapeFile(scope, fileName);
		}
		final Object o = gisExpression.value(scope);
		if (o instanceof GamaShapeFile) { return (GamaShapeFile) o; }
		return null;
	}

	@Override
	public String getType() {
		return "Gis layer";
	}

}
