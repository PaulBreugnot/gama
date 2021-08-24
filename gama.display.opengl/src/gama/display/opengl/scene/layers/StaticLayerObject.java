/*******************************************************************************************************
 *
 * StaticLayerObject.java, in gama.display.opengl, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.display.opengl.scene.layers;

import java.util.List;

import gama.display.opengl.OpenGL;
import gama.display.opengl.renderer.IOpenGLRenderer;
import gama.display.opengl.scene.AbstractObject;

/**
 * The Class StaticLayerObject.
 */
public class StaticLayerObject extends LayerObject {

	/**
	 * The Class World.
	 */
	public static abstract class World extends StaticLayerObject {

		/**
		 * Instantiates a new world.
		 *
		 * @param renderer the renderer
		 */
		public World(final IOpenGLRenderer renderer) {
			super(renderer);
		}

		@Override
		public boolean canSplit() {
			return false;
		}

		@Override
		public void computeScale() {}

		@Override
		public void computeOffset() {}

		@Override
		public boolean isLightInteraction() {
			return false;
		}

		@Override
		public void draw(final OpenGL gl) {
			if (renderer.getPickingHelper().isPicking()) { return; }

			if (currentList.isEmpty()) {
				fillWithObjects(currentList);
			}

			gl.suspendZTranslation();
			final boolean previous = gl.setLighting(false);
			super.draw(gl);
			gl.setLighting(previous);
			gl.resumeZTranslation();

		}

		@Override
		protected boolean isPickable() {
			return false;
		}

		/**
		 * Fill with objects.
		 *
		 * @param list the list
		 */
		public abstract void fillWithObjects(List<AbstractObject<?, ?>> list);
	}

	/**
	 * Instantiates a new static layer object.
	 *
	 * @param renderer the renderer
	 */
	public StaticLayerObject(final IOpenGLRenderer renderer) {
		super(renderer, null);
	}

	@Override
	public boolean isStatic() {
		return true;
	}

	@Override
	public void clear(final OpenGL gl) {}

}