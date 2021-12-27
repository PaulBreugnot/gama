/*******************************************************************************************************
 *
 * JOGLRenderer.java, in gama.display.opengl, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.display.opengl.renderer;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.List;

import org.locationtech.jts.geom.Geometry;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import gama.common.ui.IDisplaySurface;
import gama.common.ui.ILayer;
import gama.core.dev.utils.DEBUG;
import gama.core.dev.utils.FLAGS;
import gama.display.opengl.OpenGL;
import gama.display.opengl.renderer.helpers.AbstractRendererHelper.Pass;
import gama.display.opengl.renderer.helpers.CameraHelper;
import gama.display.opengl.renderer.helpers.KeystoneHelper;
import gama.display.opengl.renderer.helpers.LightHelper;
import gama.display.opengl.renderer.helpers.PickingHelper;
import gama.display.opengl.renderer.helpers.SceneHelper;
import gama.display.opengl.scene.ModelScene;
import gama.display.opengl.view.GamaGLCanvas;
import gama.display.opengl.view.SWTOpenGLDisplaySurface;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.outputs.display.AbstractDisplayGraphics;
import gama.outputs.layers.charts.ChartOutput;
import gama.ui.base.utils.DPIHelper;
import gama.ui.base.utils.WorkbenchHelper;
import gama.util.GamaColor;
import gama.util.file.GamaFile;
import gama.util.file.GamaGeometryFile;
import gama.util.file.GamaImageFile;
import gama.util.matrix.IField;
import gaml.statements.draw.DrawingAttributes;
import gaml.statements.draw.FileDrawingAttributes;
import gaml.statements.draw.MeshDrawingAttributes;
import gaml.statements.draw.ShapeDrawingAttributes;
import gaml.statements.draw.TextDrawingAttributes;
import gaml.types.GamaGeometryType;

// TODO: Auto-generated Javadoc
/**
 * This class plays the role of Renderer and IGraphics. Class JOGLRenderer.
 *
 * @author drogoul
 * @since 27 avr. 2015
 *
 */
@SuppressWarnings ({ "rawtypes", "unchecked" })
public class JOGLRenderer extends AbstractDisplayGraphics implements IOpenGLRenderer {

	static {
		DEBUG.ON();
	}

	/** The keystone helper. */
	// Helpers
	private final KeystoneHelper keystoneHelper = createKeystoneHelper();

	/** The picking helper. */
	private final PickingHelper pickingHelper = new PickingHelper(this);

	/** The light helper. */
	private final LightHelper lightHelper = new LightHelper(this);

	/** The camera helper. */
	private final CameraHelper cameraHelper = new CameraHelper(this);

	/** The scene helper. */
	private final SceneHelper sceneHelper = createSceneHelper();

	/** The open GL. */
	// OpenGL back-end
	protected OpenGL openGL;

	/** The disposed. */
	// State
	protected volatile boolean inited, visible, disposed;

	/** The canvas. */
	// Canvas
	protected GamaGLCanvas canvas;

	/**
	 * Sets the display surface.
	 *
	 * @param d
	 *            the new display surface
	 */
	@Override
	public void setDisplaySurface(final IDisplaySurface d) {
		super.setDisplaySurface(d);
		d.getScope().setGraphics(this);
		openGL = new OpenGL(this);
	}

	/**
	 * Creates the scene helper.
	 *
	 * @return the scene helper
	 */
	protected SceneHelper createSceneHelper() {
		return new SceneHelper(this);
	}

	/**
	 * Creates the keystone helper.
	 *
	 * @return the keystone helper
	 */
	protected KeystoneHelper createKeystoneHelper() {
		return new KeystoneHelper(this);
	}

	/**
	 * Sets the canvas.
	 *
	 * @param canvas
	 *            the new canvas
	 */
	@Override
	public void setCanvas(final GamaGLCanvas canvas) {
		this.canvas = canvas;
		canvas.addGLEventListener(this);
		cameraHelper.hook();
	}

	/**
	 * Inits the.
	 *
	 * @param drawable
	 *            the drawable
	 */
	@Override
	public void init(final GLAutoDrawable drawable) {
		if (!FLAGS.USE_NATIVE_OPENGL_WINDOW) { WorkbenchHelper.asyncRun(() -> canvas.setVisible(visible)); }
		openGL.setGL2(drawable.getGL().getGL2());
		cameraHelper.initialize();
		openGL.initializeGLStates(data.getBackgroundColor());
		lightHelper.initialize();
		// We mark the renderer as inited
		inited = true;
	}

	/**
	 * Fill background.
	 *
	 * @param bgColor
	 *            the bg color
	 */
	@Override
	public void fillBackground(final Color bgColor) {
		openGL.setCurrentObjectAlpha(1);
	}

	/**
	 * Gets the surface.
	 *
	 * @return the surface
	 */
	@Override
	public SWTOpenGLDisplaySurface getSurface() { return (SWTOpenGLDisplaySurface) surface; }

	/**
	 * Gets the canvas.
	 *
	 * @return the canvas
	 */
	@Override
	public final GamaGLCanvas getCanvas() { return canvas; }

	/**
	 * Inits the scene.
	 */
	@Override
	public void initScene() {
		final ModelScene scene = sceneHelper.getSceneToRender();
		if (scene != null) { scene.reload(); }
	}

	/**
	 * Begin drawing layers.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean beginDrawingLayers() {
		while (!inited) {
			try {
				Thread.sleep(10);
			} catch (final InterruptedException e) {
				return false;
			}
		}
		return sceneHelper.beginUpdatingScene();

	}

	/**
	 * Checks if is not ready to update.
	 *
	 * @return true, if is not ready to update
	 */
	@Override
	public boolean isNotReadyToUpdate() {
		if (data.isSynchronized()) return false;
		return sceneHelper.isNotReadyToUpdate();
	}

	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {
		super.dispose();
		dispose(canvas);
	}

	/**
	 * Begin drawing layer.
	 *
	 * @param layer
	 *            the layer
	 */
	@Override
	public void beginDrawingLayer(final ILayer layer) {
		super.beginDrawingLayer(layer);
		sceneHelper.beginDrawingLayer(layer, currentLayerAlpha);
	}

	/**
	 * Method endDrawingLayers().
	 *
	 * @see gama.common.ui.IGraphics#endDrawingLayers()
	 */
	@Override
	public void endDrawingLayers() {
		sceneHelper.endUpdatingScene();
		getSurface().invalidateVisibleRegions();
	}

	/**
	 * Display.
	 *
	 * @param drawable
	 *            the drawable
	 */
	@Override
	public void display(final GLAutoDrawable drawable) {
		if (!sceneHelper.isReady()) return;

		try (Pass c = keystoneHelper.render(); Pass d = openGL.beginScene();) {
			cameraHelper.update();
			lightHelper.draw();
			sceneHelper.draw();
		}

		if (!visible) {
			// We make the canvas visible only after a first display has occured
			WorkbenchHelper.asyncRun(() -> getCanvas().setVisible(true));
			visible = true;
		}

	}

	/** The first. */
	boolean first = true;

	/**
	 * Reshape.
	 *
	 * @param drawable
	 *            the drawable
	 * @param arg1
	 *            the arg 1
	 * @param arg2
	 *            the arg 2
	 * @param w
	 *            the w
	 * @param h
	 *            the h
	 */
	@Override
	public void reshape(final GLAutoDrawable drawable, final int arg1, final int arg2, final int w, final int h) {
		int width = DPIHelper.autoScaleDown(w), height = DPIHelper.autoScaleDown(h);
		// int width = w, height = h;
		// See #2628 and https://github.com/sgothel/jogl/commit/ca7f0fb61b0a608b6e684a5bbde71f6ecb6e3fe0
		// width = scaleDownIfMac(width);
		// height = scaleDownIfMac(height);
		if (width <= 0 || height <= 0 || openGL.getViewWidth() == width && openGL.getViewHeight() == height) return;
		final GL2 gl = drawable.getContext().getGL().getGL2();
		keystoneHelper.reshape(width, height);
		openGL.reshape(gl, width, height);
		sceneHelper.reshape(width, height);
		surface.updateDisplay(true);
	}

	/**
	 * Dispose.
	 *
	 * @param drawable
	 *            the drawable
	 */
	@Override
	public void dispose(final GLAutoDrawable drawable) {
		sceneHelper.garbageCollect(openGL);
		sceneHelper.dispose();
		openGL.dispose();
		keystoneHelper.dispose();
		cameraHelper.dispose();
		drawable.removeGLEventListener(this);
		disposed = true;
	}

	/**
	 * IGraphics DRAWING METHODS.
	 *
	 * @return true, if successful
	 */

	@Override
	public boolean cannotDraw() {
		final ModelScene scene = sceneHelper.getSceneToUpdate();
		return scene != null && scene.cannotAdd();
	}

	/**
	 * Draw file.
	 *
	 * @param file
	 *            the file
	 * @param attributes
	 *            the attributes
	 * @return the rectangle 2 D
	 */
	@Override
	public Rectangle2D drawFile(final GamaFile file, final DrawingAttributes attributes) {
		if (file == null) return null;
		final ModelScene scene = sceneHelper.getSceneToUpdate();
		if (scene == null) return null;
		tryToHighlight(attributes);
		if (file instanceof GamaGeometryFile) {
			scene.addGeometryFile((GamaGeometryFile) file, attributes);
			openGL.cacheGeometry((GamaGeometryFile) file);
		} else if (file instanceof GamaImageFile) {
			if (attributes.useCache()) { openGL.cacheTexture(file.getFile(getSurface().getScope())); }
			scene.addImage(file, attributes);
		}

		return rect;
	}

	/**
	 * Draw field.
	 *
	 * @param fieldValues
	 *            the field values
	 * @param attributes
	 *            the attributes
	 * @return the rectangle 2 D
	 */
	@Override
	public Rectangle2D drawField(final IField fieldValues, final MeshDrawingAttributes attributes) {
		final ModelScene scene = sceneHelper.getSceneToUpdate();
		if (scene == null) return null;
		final List<?> textures = attributes.getTextures();
		if (textures != null && !textures.isEmpty()) {
			for (final Object img : textures) {
				if (img instanceof GamaImageFile) {
					openGL.cacheTexture(((GamaImageFile) img).getFile(getSurface().getScope()));
				}
			}
		}
		scene.addField(fieldValues, attributes);
		/*
		 * This line has been removed to fix the issue 1174 if ( gridColor != null ) { drawGridLine(img, gridColor); }
		 */
		return rect;
	}

	/**
	 * Method drawShape. Add a given JTS Geometry in the list of all the existing geometry that will be displayed by
	 * openGl.
	 *
	 * @param shape
	 *            the shape
	 * @param attributes
	 *            the attributes
	 * @return the rectangle 2 D
	 */
	@Override
	public Rectangle2D drawShape(final Geometry shape, final DrawingAttributes attributes) {
		if (shape == null) return null;
		final ModelScene scene = sceneHelper.getSceneToUpdate();
		if (scene == null) return null;
		tryToHighlight(attributes);
		scene.addGeometry(shape, attributes);
		return rect;
	}

	/**
	 * Draw image.
	 *
	 * @param img
	 *            the img
	 * @param attributes
	 *            the attributes
	 * @return the rectangle 2 D
	 */
	@Override
	public Rectangle2D drawImage(final BufferedImage img, final DrawingAttributes attributes) {
		if (img == null) return null;
		final ModelScene scene = sceneHelper.getSceneToUpdate();
		if (scene == null) return null;
		scene.addImage(img, attributes);
		tryToHighlight(attributes);
		if (attributes.getBorder() != null) {
			drawGridLine(new GamaPoint(img.getWidth(), img.getHeight()), attributes.getBorder());
		}
		return rect;
	}

	/**
	 * Draw chart.
	 *
	 * @param chart
	 *            the chart
	 * @return the rectangle 2 D
	 */
	@Override
	public Rectangle2D drawChart(final ChartOutput chart) {
		final ModelScene scene = sceneHelper.getSceneToUpdate();
		if (scene == null) return null;
		int x = getLayerWidth();
		int y = getLayerHeight();
		x = (int) (Math.min(x, y) * 0.80);
		y = x;
		// TODO See if it not possible to generate directly a texture renderer instead
		final BufferedImage im = chart.getImage(x, y, getSurface().getData().isAntialias());
		scene.addImage(im, new FileDrawingAttributes(null, true));
		return rect;
	}

	/**
	 * Try to highlight.
	 *
	 * @param attributes
	 *            the attributes
	 */
	protected void tryToHighlight(final DrawingAttributes attributes) {
		if (highlight) { attributes.setHighlighted(data.getHighlightColor()); }
	}

	/**
	 * Draw grid line.
	 *
	 * @param dimensions
	 *            the dimensions
	 * @param lineColor
	 *            the line color
	 */
	public void drawGridLine(final GamaPoint dimensions, final Color lineColor) {
		final ModelScene scene = sceneHelper.getSceneToUpdate();
		if (scene == null) return;
		double stepX, stepY;
		final double cellWidth = getEnvHeight() / dimensions.x;
		final double cellHeight = getEnvWidth() / dimensions.y;
		final GamaColor color = GamaColor.getInt(lineColor.getRGB());
		final DrawingAttributes attributes = new ShapeDrawingAttributes(null, color, color, IShape.Type.GRIDLINE);
		attributes.setEmpty(true);
		for (double i = 0; i < dimensions.x; i++) {
			for (double j = 0; j < dimensions.y; j++) {
				stepX = i + 0.5;
				stepY = j + 0.5;
				final Geometry g = GamaGeometryType
						.buildRectangle(cellWidth, cellHeight, new GamaPoint(stepX * cellWidth, stepY * cellHeight))
						.getInnerGeometry();
				scene.addGeometry(g, attributes);
			}
		}
	}

	/**
	 * Draw string.
	 *
	 * @param string
	 *            the string
	 * @param attributes
	 *            the attributes
	 * @return the rectangle 2 D
	 */
	@Override
	public Rectangle2D drawString(final String string, final TextDrawingAttributes attributes) {
		if (string == null || string.isEmpty()) return null;
		final ModelScene scene = sceneHelper.getSceneToUpdate();
		if (scene == null) return null;
		// Multiline: Issue #780
		if (string.contains("\n")) {
			int i = 0;
			final double shift = attributes.getFont().getSize() / this.getyRatioBetweenPixelsAndModelUnits();
			for (final String s : string.split("\n")) {
				// DEBUG.OUT("Attributes Font Size: " + attributes.font.getSize());
				// DEBUG.OUT("Get Y Ratio: " + getyRatioBetweenPixelsAndModelUnits());
				drawString(s, attributes.copyTranslatedBy(new GamaPoint(0, shift * i)));
				i++;
			}
			return null;
		}
		// openGL.cacheFont(attributes.getFont());
		attributes.getLocation().setY(-attributes.getLocation().getY());
		scene.addString(string, attributes);
		return null;
	}

	/**
	 * DIMENSIONS, RATIOS AND LOCATIONS METHODS.
	 *
	 * @return the camera pos
	 */

	@Override
	public final GamaPoint getCameraPos() { return cameraHelper.getPosition(); }

	/**
	 * Gets the camera target.
	 *
	 * @return the camera target
	 */
	@Override
	public final GamaPoint getCameraTarget() { return cameraHelper.getTarget(); }

	/**
	 * Gets the camera orientation.
	 *
	 * @return the camera orientation
	 */
	@Override
	public final GamaPoint getCameraOrientation() { return cameraHelper.getOrientation(); }

	/**
	 * Gets the x ratio between pixels and model units.
	 *
	 * @return the x ratio between pixels and model units
	 */
	@Override
	public double getxRatioBetweenPixelsAndModelUnits() {
		return DPIHelper.autoScaleDown(openGL.getRatios().x);
	}

	/**
	 * Gets the y ratio between pixels and model units.
	 *
	 * @return the y ratio between pixels and model units
	 */
	@Override
	public double getyRatioBetweenPixelsAndModelUnits() {
		return DPIHelper.autoScaleDown(openGL.getRatios().y);
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see ummisco.gama.opengl.renderer.IOpenGLRenderer#getWidth()
	 */
	@SuppressWarnings ("restriction")
	@Override
	public final double getWidth() {
		// DEBUG.OUT(
		// "Result of getWidth: "
		// + PlatformHelper.autoScaleDown(canvas.getSurfaceWidth()) * (float) surface.getZoomLevel(),
		// false);
		// DEBUG.OUT(" -- Canvas surface width " + canvas.getSurfaceWidth(), false);
		// DEBUG.OUT("Canvas size " + canvas.getSize().x, false);
		// DEBUG.OUT(" -- Width of world in pixels computed by OpenGL " + openGL.getPixelWidthAndHeightOfWorld()[0]);
		// return canvas.getSize().x * surface.getZoomLevel();
		return openGL.getPixelWidthAndHeightOfWorld()[0] * (float) surface.getZoomLevel();
		// return PlatformHelper.autoScaleDown(canvas.getSurfaceWidth()) *
		// PlatformHelper.autoScaleDown(canvas.getSurfaceWidth()) * (float) surface.getZoomLevel();
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see ummisco.gama.opengl.renderer.IOpenGLRenderer#getHeight()
	 */
	@Override
	public final double getHeight() {
		return openGL.getPixelWidthAndHeightOfWorld()[1] * (float) surface.getZoomLevel();
		// return canvas.getSurfaceHeight() * surface.getZoomLevel();
	}

	/**
	 * Gets the real world point from window point.
	 *
	 * @param mouse
	 *            the mouse
	 * @return the real world point from window point
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see ummisco.gama.opengl.renderer.IOpenGLRenderer#getRealWorldPointFromWindowPoint (java.awt.Point)
	 */
	@Override
	public GamaPoint getRealWorldPointFromWindowPoint(final GamaPoint mouse) {
		return openGL.getWorldPositionFrom(new GamaPoint(mouse.x, mouse.y));
	}

	/**
	 * Gets the display width.
	 *
	 * @return the display width
	 */
	@Override
	public final int getDisplayWidth() { return (int) Math.round(getWidth()); }

	/**
	 * Gets the display height.
	 *
	 * @return the display height
	 */
	@Override
	public final int getDisplayHeight() { return (int) Math.round(getHeight()); }

	/*
	 * (non-Javadoc)
	 *
	 * @see ummisco.gama.opengl.renderer.IOpenGLRenderer#getCameraHelper()
	 */

	/**
	 * Gets the camera helper.
	 *
	 * @return the camera helper
	 */
	@Override
	public CameraHelper getCameraHelper() { return cameraHelper; }

	/**
	 * Gets the keystone helper.
	 *
	 * @return the keystone helper
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see ummisco.gama.opengl.renderer.IOpenGLRenderer#getKeystoneHelper()
	 */
	@Override
	public KeystoneHelper getKeystoneHelper() { return keystoneHelper; }

	/**
	 * Gets the picking helper.
	 *
	 * @return the picking helper
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see ummisco.gama.opengl.renderer.IOpenGLRenderer#getPickingHelper()
	 */
	@Override
	public PickingHelper getPickingHelper() { return pickingHelper; }

	/**
	 * Gets the open GL helper.
	 *
	 * @return the open GL helper
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see ummisco.gama.opengl.renderer.IOpenGLRenderer#getOpenGLHelper()
	 */
	@Override
	public OpenGL getOpenGLHelper() { return openGL; }

	/**
	 * Gets the light helper.
	 *
	 * @return the light helper
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see ummisco.gama.opengl.renderer.IOpenGLRenderer#getLightHelper()
	 */
	@Override
	public LightHelper getLightHelper() { return lightHelper; }

	/**
	 * Gets the scene helper.
	 *
	 * @return the scene helper
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see ummisco.gama.opengl.renderer.IOpenGLRenderer#getSceneHelper()
	 */
	@Override
	public SceneHelper getSceneHelper() { return sceneHelper; }

	/**
	 * Checks if is disposed.
	 *
	 * @return true, if is disposed
	 */
	@Override
	public boolean isDisposed() { return disposed; }

}
