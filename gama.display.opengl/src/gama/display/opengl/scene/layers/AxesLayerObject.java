/*******************************************************************************************************
 *
 * AxesLayerObject.java, in gama.display.opengl, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.display.opengl.scene.layers;

import static gama.common.geometry.Rotation3D.MINUS_I;
import static gama.common.geometry.Rotation3D.PLUS_J;
import static gama.common.geometry.Scaling3D.of;
import static gama.util.GamaColor.getNamed;
import static gaml.operators.IUnits.bottom_center;
import static gaml.operators.IUnits.left_center;
import static gaml.operators.IUnits.top_center;
import static gaml.types.GamaGeometryType.buildCone3D;
import static gaml.types.GamaGeometryType.buildLineCylinder;

import java.util.List;

import gama.common.geometry.AxisAngle;
import gama.display.opengl.OpenGL;
import gama.display.opengl.renderer.IOpenGLRenderer;
import gama.display.opengl.scene.AbstractObject;
import gama.display.opengl.scene.text.StringObject;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.GamaShape;
import gama.metamodel.shape.IShape;
import gama.util.GamaColor;
import gama.util.GamaFont;
import gaml.statements.draw.TextDrawingAttributes;

/**
 * The Class AxesLayerObject.
 */
public class AxesLayerObject extends StaticLayerObject.World {

	/** The Constant LABELS. */
	public final static String[] LABELS = { "X", "Y", "Z" };
	
	/** The Constant ANCHORS. */
	public final static GamaPoint[] ANCHORS = { left_center, top_center, bottom_center };
	
	/** The Constant ROTATIONS. */
	public final static AxisAngle[] ROTATIONS = { new AxisAngle(PLUS_J, 90), new AxisAngle(MINUS_I, 90), null };
	
	/** The Constant COLORS. */
	public final static GamaColor[] COLORS = { getNamed("gamared"), getNamed("gamaorange"), getNamed("gamablue") };
	
	/** The Constant DEFAULT_SCALE. */
	protected final static GamaPoint DEFAULT_SCALE = new GamaPoint(.15, .15, .15);
	
	/** The Constant ORIGIN. */
	protected final static GamaPoint ORIGIN = new GamaPoint(0, 0, 0);
	
	/** The Constant AXES_FONT. */
	protected final static GamaFont AXES_FONT = new GamaFont("Helvetica", 0, 18);
	
	/** The arrow. */
	final GamaShape arrow;
	
	/** The dirs. */
	final GamaPoint[] dirs;
	
	/** The axes. */
	final GamaShape[] axes = new GamaShape[3];

	/**
	 * Instantiates a new axes layer object.
	 *
	 * @param renderer the renderer
	 */
	public AxesLayerObject(final IOpenGLRenderer renderer) {
		super(renderer);
		// Addition to fix #2227
		scale.setLocation(DEFAULT_SCALE);
		final double max = renderer.getMaxEnvDim();
		arrow = (GamaShape) buildCone3D(max / 15, max / 6, ORIGIN);
		dirs = new GamaPoint[] { new GamaPoint(max, 0, 0), new GamaPoint(0, max, 0), new GamaPoint(0, 0, max) };
		for (int i = 0; i < 3; i++) {
			axes[i] = (GamaShape) buildLineCylinder(ORIGIN, dirs[i], max / 40);
		}
	}

	@Override
	public void setScale(final GamaPoint s) {
		if (s == null) {
			scale = DEFAULT_SCALE;
		} else {
			super.setScale(s);
		}
	}

	@Override
	public void draw(final OpenGL gl) {
		if (renderer.getOpenGLHelper().isInRotationMode()) {
			final GamaPoint pivotPoint = renderer.getCameraTarget();
			setOffset(pivotPoint.yNegated());
			final double size = renderer.getOpenGLHelper().sizeOfRotationElements();
			final double ratio = size / renderer.getMaxEnvDim();
			setScale(new GamaPoint(ratio, ratio, ratio));
		} else {
			setOffset(null);
			setScale(null);
		}
		super.draw(gl);
	}

	@Override
	public void fillWithObjects(final List<AbstractObject<?, ?>> list) {
		for (int i = 0; i < 3; i++) {
			final GamaPoint p = dirs[i];
			// build axis
			addSyntheticObject(list, axes[i], COLORS[i], IShape.Type.LINECYLINDER, false);
			// build labels
			final TextDrawingAttributes text =
					new TextDrawingAttributes(of(1), null, p.times(1.3).yNegated(), COLORS[i]);
			text.setAnchor(ANCHORS[i]);
			text.setFont(AXES_FONT);
			text.setPerspective(false);
			list.add(new StringObject(LABELS[i], text));
			// build arrows
			final GamaShape s = new GamaShape(arrow, null, ROTATIONS[i], p.times(0.98));
			addSyntheticObject(list, s, COLORS[i], IShape.Type.CONE, false);
		}
	}

}