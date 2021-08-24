/*******************************************************************************************************
 *
 * AbstractRendererHelper.java, in gama.display.opengl, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.display.opengl.renderer.helpers;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.swt.GLCanvas;

import gama.display.opengl.OpenGL;
import gama.display.opengl.renderer.IOpenGLRenderer;
import gama.display.opengl.view.SWTOpenGLDisplaySurface;
import gama.outputs.LayeredDisplayData;

/**
 * The Class AbstractRendererHelper.
 */
public abstract class AbstractRendererHelper {

	/**
	 * The Interface Pass.
	 */
	public interface Pass extends AutoCloseable {

		/**
		 * Close.
		 */
		@Override
		void close();

	}

	/** The renderer. */
	private final IOpenGLRenderer renderer;

	/**
	 * Instantiates a new abstract renderer helper.
	 *
	 * @param renderer the renderer
	 */
	public AbstractRendererHelper(final IOpenGLRenderer renderer) {
		this.renderer = renderer;
	}

	/**
	 * Gets the renderer.
	 *
	 * @return the renderer
	 */
	public IOpenGLRenderer getRenderer() {
		return renderer;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	protected LayeredDisplayData getData() {
		return renderer.getData();
	}

	/**
	 * Gets the gl.
	 *
	 * @return the gl
	 */
	protected GL2 getGL() {
		return renderer.getOpenGLHelper().getGL();
	}

	/**
	 * Gets the open GL.
	 *
	 * @return the open GL
	 */
	protected OpenGL getOpenGL() {
		return renderer.getOpenGLHelper();
	}

	/**
	 * Gets the canvas.
	 *
	 * @return the canvas
	 */
	protected GLCanvas getCanvas() {
		return renderer.getCanvas();
	}

	/**
	 * Gets the surface.
	 *
	 * @return the surface
	 */
	protected SWTOpenGLDisplaySurface getSurface() {
		return renderer.getSurface();
	}

	/**
	 * Gets the max env dim.
	 *
	 * @return the max env dim
	 */
	public double getMaxEnvDim() {
		return renderer.getMaxEnvDim();
	}

	/**
	 * Gets the z near.
	 *
	 * @return the z near
	 */
	public double getZNear() {
		return renderer.getData().getzNear();
	}

	/**
	 * Gets the z far.
	 *
	 * @return the z far
	 */
	public double getZFar() {
		return renderer.getData().getzFar();
	}

	/**
	 * Initialize.
	 */
	public abstract void initialize();

}
