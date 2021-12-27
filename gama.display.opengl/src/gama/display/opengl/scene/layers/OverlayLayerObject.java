/*******************************************************************************************************
 *
 * OverlayLayerObject.java, in gama.display.opengl, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.display.opengl.scene.layers;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.fixedfunc.GLMatrixFunc;

import gama.common.interfaces.IKeyword;
import gama.common.ui.ILayer;
import gama.core.dev.utils.DEBUG;
import gama.display.opengl.OpenGL;
import gama.display.opengl.renderer.IOpenGLRenderer;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.outputs.layers.OverlayLayer;
import gama.runtime.IScope;
import gaml.expressions.IExpression;
import gaml.operators.Cast;

// TODO: Auto-generated Javadoc
/**
 * The Class OverlayLayerObject.
 */
public class OverlayLayerObject extends LayerObject {

	static {
		DEBUG.OFF();
	}

	/**
	 * Instantiates a new overlay layer object.
	 *
	 * @param renderer
	 *            the renderer
	 * @param layer
	 *            the layer
	 */
	public OverlayLayerObject(final IOpenGLRenderer renderer, final ILayer layer) {
		super(renderer, layer);
	}

	/**
	 * Compute scale.
	 */
	@Override
	public void computeScale() {
		scale.setLocation(0.9, 0.9, 1);
	}

	/**
	 * Adds the frame.
	 *
	 * @param gl
	 *            the gl
	 */
	protected void addFrame(final OpenGL gl) {
		GamaPoint size = new GamaPoint(renderer.getEnvWidth(), renderer.getEnvHeight());
		final IScope scope = renderer.getSurface().getScope();
		final IExpression expr = layer.getDefinition().getFacet(IKeyword.SIZE);
		if (expr != null) {
			size = Cast.asPoint(scope, expr.value(scope));
			if (size.x <= 1) { size.x *= renderer.getEnvWidth(); }
			if (size.y <= 1) { size.y *= renderer.getEnvHeight(); }
		}
		gl.pushMatrix();
		gl.setObjectWireframe(false);
		gl.translateBy(0, -size.y, 0);
		gl.scaleBy(size.x, size.y, 1);
		gl.setCurrentColor(((OverlayLayer) layer).getData().getBackgroundColor(scope),
				1 - layer.getData().getTransparency(scope));
		gl.drawCachedGeometry(IShape.Type.ROUNDED, null);
		gl.popMatrix();
	}

	/**
	 * Checks if is overlay.
	 *
	 * @return true, if is overlay
	 */
	@Override
	public boolean isOverlay() { return true; }

	/**
	 * Increase Z.
	 */
	@Override
	protected void increaseZ() {}

	/**
	 * Prepare drawing.
	 *
	 * @param gl
	 *            the gl
	 */
	@Override
	protected void prepareDrawing(final OpenGL gl) {
		gl.getGL().glDisable(GL.GL_DEPTH_TEST);
		// Addition to fix #2228 and #2222
		gl.suspendZTranslation();
		//
		final double viewHeight = gl.getViewHeight();
		final double viewWidth = gl.getViewWidth();
		final double viewRatio = viewWidth / (viewHeight == 0 ? 1 : viewHeight);
		final double worldHeight = gl.getWorldHeight();
		final double worldWidth = gl.getWorldWidth();
		final double maxDim = worldHeight > worldWidth ? worldHeight : worldWidth;
		gl.pushIdentity(GLMatrixFunc.GL_PROJECTION);
		if (viewRatio >= 1.0) {
			gl.getGL().glOrtho(0, maxDim * viewRatio, -maxDim, 0, -1, 1);
		} else {
			gl.getGL().glOrtho(0, maxDim, -maxDim / viewRatio, 0, -1, 1);
		}
		gl.pushIdentity(GLMatrixFunc.GL_MODELVIEW);
		// gl.push(GLMatrixFunc.GL_MODELVIEW);
		final GamaPoint nonNullOffset = getOffset();
		gl.translateBy(nonNullOffset.x, -nonNullOffset.y, 0);
		final GamaPoint nonNullScale = getScale();
		gl.scaleBy(nonNullScale.x, nonNullScale.y, nonNullScale.z);
	}

	/**
	 * Do drawing.
	 *
	 * @param gl
	 *            the gl
	 * @param picking
	 *            the picking
	 */
	@Override
	protected void doDrawing(final OpenGL gl, final boolean picking) {
		if (!picking) {
			addFrame(gl);
			drawObjects(gl, currentList, alpha, picking);
		}
	}

	/**
	 * Stop drawing.
	 *
	 * @param gl
	 *            the gl
	 */
	@Override
	protected void stopDrawing(final OpenGL gl) {
		super.stopDrawing(gl);
		// Addition to fix #2228 and #2222
		gl.resumeZTranslation();
		// gl.getGL().glEnable(GL.GL_DEPTH_TEST);
		gl.pop(GLMatrixFunc.GL_MODELVIEW);
		gl.pop(GLMatrixFunc.GL_PROJECTION);
	}

	/**
	 * Checks if is pickable.
	 *
	 * @return true, if is pickable
	 */
	@Override
	protected boolean isPickable() { return false; }

}
