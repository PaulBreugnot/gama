/*******************************************************************************************************
 *
 * MeshLayer.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.outputs.layers;

import java.util.Arrays;

import gama.common.geometry.Scaling3D;
import gama.common.ui.IGraphics;
import gama.runtime.IScope;
import gama.util.GamaColor;
import gama.util.file.GamaImageFile;
import gama.util.matrix.IField;
import gaml.statements.draw.MeshDrawingAttributes;

/**
 * The Class MeshLayer.
 */
public class MeshLayer extends AbstractLayer {

	/**
	 * Instantiates a new mesh layer.
	 *
	 * @param layer the layer
	 */
	public MeshLayer(final ILayerStatement layer) {
		super(layer);
	}

	@Override
	protected ILayerData createData() {
		return new MeshLayerData(definition);
	}

	@Override
	public MeshLayerData getData() {
		return (MeshLayerData) super.getData();
	}

	@Override
	public void privateDraw(final IScope scope, final IGraphics dg) {
		GamaColor lineColor = null;
		final MeshLayerData data = getData();
		if (data.drawLines()) { lineColor = data.getLineColor(); }
		final IField values = data.getElevationMatrix(scope);
		final GamaImageFile textureFile = data.textureFile();
		final MeshDrawingAttributes attributes = new MeshDrawingAttributes("", lineColor, false);
		attributes.setGrayscaled(data.isGrayScaled());
		attributes.setEmpty(data.isWireframe());
		if (textureFile != null) { attributes.setTextures(Arrays.asList(textureFile)); }
		attributes.setLocation(data.getPosition());
		attributes.setTriangulated(data.isTriangulated());
		attributes.setWithText(data.isShowText());
		attributes.setCellSize(data.getCellSize());
		attributes.setBorder(lineColor);
		attributes.setXYDimension(data.getDimension());
		attributes.setSize(Scaling3D.of(data.getSize()));
		attributes.setScale(data.getScale());
		attributes.setColors(data.getColor());
		attributes.setSmooth(data.getSmooth());
		attributes.setNoData(data.getNoDataValue());
		dg.drawField(values, attributes);

	}

	@Override
	public String getType() {
		return "Field layer";
	}

}
