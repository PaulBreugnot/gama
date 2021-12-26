/*******************************************************************************************************
 *
 * SWTOpenGLDisplaySurface.java, in gama.display.opengl, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.display.opengl.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.locationtech.jts.geom.Envelope;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.FPSCounter;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAnimatorControl;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.swt.GLCanvas;

import gama.common.geometry.Envelope3D;
import gama.common.interfaces.IKeyword;
import gama.common.preferences.GamaPreferences;
import gama.common.ui.IDisplaySurface;
import gama.common.ui.IDisplaySynchronizer;
import gama.common.ui.ILayer;
import gama.common.ui.ILayerManager;
import gama.core.dev.annotations.GamlAnnotations.display;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.utils.DEBUG;
import gama.core.dev.utils.FLAGS;
import gama.display.opengl.renderer.IOpenGLRenderer;
import gama.display.opengl.renderer.JOGLRenderer;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.metamodel.topology.filter.Different;
import gama.outputs.LayeredDisplayData;
import gama.outputs.LayeredDisplayData.Changes;
import gama.outputs.LayeredDisplayOutput;
import gama.outputs.display.LayerManager;
import gama.outputs.layers.IEventLayerListener;
import gama.outputs.layers.OverlayLayer;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.ui.base.resources.GamaIcons;
import gama.ui.base.resources.IGamaIcons;
import gama.ui.base.utils.PlatformHelper;
import gama.ui.base.utils.WorkbenchHelper;
import gama.ui.experiment.menus.AgentsMenu;
import gama.ui.experiment.views.displays.DisplaySurfaceMenu;
import gaml.expressions.IExpression;
import gaml.operators.Cast;
import gaml.statements.draw.DrawingAttributes;

// TODO: Auto-generated Javadoc
/**
 * Class OpenGLSWTDisplaySurface.
 *
 * @author drogoul
 * @since 25 mars 2015
 *
 */
@display ("opengl")
@doc ("Displays that uses the OpenGL technology to display their layers in 3D")
public class SWTOpenGLDisplaySurface implements IDisplaySurface.OpenGL {

	static {
		DEBUG.OFF();
	}

	/** The animator. */
	GLAnimatorControl animator;

	/** The renderer. */
	IOpenGLRenderer renderer;

	/** The zoom fit. */
	protected boolean zoomFit = true;

	/** The listeners. */
	Set<IEventLayerListener> listeners = new HashSet<>();

	/** The output. */
	final LayeredDisplayOutput output;

	/** The layer manager. */
	final LayerManager layerManager;

	/** The menu manager. */
	protected DisplaySurfaceMenu menuManager;

	/** The temp focus. */
	protected IExpression temp_focus;

	/** The scope. */
	IScope scope;

	/** The synchronizer. */
	public IDisplaySynchronizer synchronizer;

	/** The parent. */
	final Composite parent;

	/** The disposed. */
	volatile boolean disposed;

	/** The already updating. */
	private volatile boolean alreadyUpdating;

	/**
	 * Instantiates a new SWT open GL display surface.
	 *
	 * @param objects
	 *            the objects
	 */
	public SWTOpenGLDisplaySurface(final Object... objects) {
		output = (LayeredDisplayOutput) objects[0];
		parent = (Composite) objects[1];
		output.getData().addListener(this);
		output.setSurface(this);
		setDisplayScope(output.getScope().copy("in opengl display"));
		renderer = createRenderer();
		renderer.setDisplaySurface(this);
		animator = createAnimator();
		layerManager = new LayerManager(this, output);
		temp_focus = output.getFacet(IKeyword.FOCUS);
		animator.start();
	}

	/**
	 * Creates the renderer.
	 *
	 * @return the i open GL renderer
	 */
	protected IOpenGLRenderer createRenderer() {
		return new JOGLRenderer();
	}

	/**
	 * Creates the animator.
	 *
	 * @return the GL animator control
	 */
	private GLAnimatorControl createAnimator() {
		final GLAutoDrawable drawable = createCanvas(parent);
		return drawable.getAnimator();
	}

	/**
	 * Creates the canvas.
	 *
	 * @param parent
	 *            the parent
	 * @return the GL canvas
	 */
	public GLCanvas createCanvas(final Composite parent) {
		final GLProfile profile = GLProfile.getDefault();
		final GLCapabilities cap = new GLCapabilities(profile);
		cap.setDepthBits(24);
		cap.setDoubleBuffered(true);
		cap.setHardwareAccelerated(true);
		cap.setSampleBuffers(true);
		cap.setAlphaBits(8);
		cap.setNumSamples(8);
		final GLCanvas canvas = new GLCanvas(parent, SWT.NONE, cap, null);
		canvas.setAutoSwapBufferMode(true);
		// See issue #3164. No multithreaded animator on Linux
		GLAnimatorControl animator = FLAGS.USE_OLD_ANIMATOR || PlatformHelper.isLinux()
				? new SingleThreadGLAnimator(canvas) : new MultithreadGLAnimator(canvas);
		animator.setUpdateFPSFrames(FPSCounter.DEFAULT_FRAMES_PER_INTERVAL, null);
		renderer.setCanvas(canvas);
		final FillLayout gl = new FillLayout();
		canvas.setLayout(gl);
		return canvas;
	}

	/**
	 * Sets the menu manager.
	 *
	 * @param menuManager the new menu manager
	 */
	@Override
	public void setMenuManager(final Object menuManager) { this.menuManager = (DisplaySurfaceMenu) menuManager; }

	/**
	 * Method getImage().
	 *
	 * @param w the w
	 * @param h the h
	 * @return the image
	 * @see gama.common.ui.IDisplaySurface#getImage()
	 */
	@Override
	public BufferedImage getImage(final int w, final int h) {
		while (!isRendered()) {
			try {
				Thread.sleep(1);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
		final GLCanvas glad = renderer.getCanvas();
		if (glad == null || glad.getGL() == null || glad.getGL().getContext() == null) return null;
		final boolean current = glad.getGL().getContext().isCurrent();
		if (!current) { glad.getGL().getContext().makeCurrent(); }
		final BufferedImage image = getImage(glad.getGL().getGL2(), w, h);
		// final AWTGLReadBufferUtil glReadBufferUtil = new AWTGLReadBufferUtil(glad.getGLProfile(), false);
		// final BufferedImage image = glReadBufferUtil.readPixelsToBufferedImage(glad.getGL(), true);
		if (!current) { glad.getGL().getContext().release(); }
		return image;
		// return ImageUtils.resize(image, w, h);
	}

	/** The buffer. */
	ByteBuffer buffer;

	/**
	 * Gets the buffer.
	 *
	 * @param w
	 *            the w
	 * @param h
	 *            the h
	 * @return the buffer
	 */
	protected ByteBuffer getBuffer(final int w, final int h) {

		if (buffer == null || buffer.capacity() != w * h * 4) {
			buffer = Buffers.newDirectByteBuffer(w * h * 4);
		} else {
			buffer.rewind();
		}

		return buffer;
	}

	/**
	 * Gets the image.
	 *
	 * @param gl3
	 *            the gl 3
	 * @param ww
	 *            the ww
	 * @param hh
	 *            the hh
	 * @return the image
	 */
	protected BufferedImage getImage(final GL2 gl3, final int ww, final int hh) {

		// See #2628 and https://github.com/sgothel/jogl/commit/ca7f0fb61b0a608b6e684a5bbde71f6ecb6e3fe0
		final int width = PlatformHelper.autoScaleDown(ww);
		final int height = PlatformHelper.autoScaleDown(hh);
		final BufferedImage screenshot = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		final Graphics graphics = screenshot.getGraphics();

		final ByteBuffer buffer = getBuffer(width, height);
		// be sure you are reading from the right fbo (here is supposed to be the default one)
		// bind the right buffer to read from
		gl3.glReadBuffer(GL.GL_BACK); // or GL.GL_FRONT ?
		// if the width is not multiple of 4, set unpackPixel = 1
		gl3.glReadPixels(0, 0, width, height, GL.GL_RGBA, GL.GL_UNSIGNED_BYTE, buffer);

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				// The color are the three consecutive bytes, it's like referencing
				// to the next consecutive array elements, so we got red, green, blue..
				// red, green, blue, and so on..+ ", "
				graphics.setColor(new Color(buffer.get() & 0xff, buffer.get() & 0xff, buffer.get() & 0xff));
				buffer.get(); // consume alpha
				graphics.drawRect(w, height - h - 1, 1, 1); // height - h is for flipping the image
			}
		}
		return screenshot;
	}

	/**
	 * Method updateDisplay().
	 *
	 * @param force the force
	 * @see gama.common.ui.IDisplaySurface#updateDisplay(boolean)
	 */
	@Override
	public void updateDisplay(final boolean force) {

		if (alreadyUpdating) return;
		try {
			alreadyUpdating = true;

			final boolean oldState = animator.isPaused();
			if (force) { animator.resume(); }
			layerManager.drawLayersOn(renderer);

			// EXPERIMENTAL

			if (temp_focus != null) {
				final IShape geometry = Cast.asGeometry(getScope(), temp_focus.value(getScope()));
				if (geometry != null) {
					temp_focus = null;
					focusOn(geometry);
				}
			}
			if (force && oldState) { animator.pause(); }
		} catch (Exception e) {

		} finally {
			alreadyUpdating = false;
		}
	}

	/**
	 * Gets the display width.
	 *
	 * @return the display width
	 */
	@Override
	public double getDisplayWidth() { return renderer.getWidth(); }

	/**
	 * Gets the display height.
	 *
	 * @return the display height
	 */
	@Override
	public double getDisplayHeight() { return renderer.getHeight(); }

	/**
	 * Method zoomIn().
	 *
	 * @see gama.common.ui.IDisplaySurface#zoomIn()
	 */
	@Override
	public void zoomIn() {
		if (renderer.getData().cameraInteractionDisabled()) return;
		renderer.getCameraHelper().zoom(true);
	}

	/**
	 * Method zoomOut().
	 *
	 * @see gama.common.ui.IDisplaySurface#zoomOut()
	 */
	@Override
	public void zoomOut() {
		if (renderer.getData().cameraInteractionDisabled()) return;
		renderer.getCameraHelper().zoom(false);
	}

	/**
	 * Method zoomFit().
	 *
	 * @see gama.common.ui.IDisplaySurface#zoomFit()
	 */
	@Override
	public void zoomFit() {
		// if (renderer.getData().cameraInteractionDisabled())
		// return;
		renderer.getCameraHelper().initialize();
		output.getData().resetZRotation();
		output.getData().setZoomLevel(LayeredDisplayData.INITIAL_ZOOM, true, true);
		zoomFit = true;

	}

	/**
	 * Method getManager().
	 *
	 * @return the manager
	 * @see gama.common.ui.IDisplaySurface#getManager()
	 */
	@Override
	public ILayerManager getManager() { return layerManager; }

	/**
	 * Method focusOn().
	 *
	 * @param geometry the geometry
	 * @see gama.common.ui.IDisplaySurface#focusOn(gama.metamodel.shape.IShape)
	 */
	@Override
	public void focusOn(final IShape geometry) {
		// FIXME: Need to compute the depth of the shape to adjust ZPos value.
		// FIXME: Problem when the geometry is a point how to determine the
		// maxExtent of the shape?
		// FIXME: Problem when an agent is placed on a layer with a z_value how
		// to get this z_layer value to offset it?
		renderer.getCameraHelper().zoomFocus(geometry.getEnvelope().yNegated());
	}

	/**
	 * Method waitForUpdateAndRun().
	 *
	 * @param r the r
	 * @see gama.common.ui.IDisplaySurface#waitForUpdateAndRun(java.lang.Runnable)
	 */
	@Override
	public void runAndUpdate(final Runnable r) {
		r.run();
		if (getScope().isPaused()) { updateDisplay(true); }
		if (animator.isPaused()) {
			animator.resume();
			animator.pause();
		}
	}

	/**
	 * Method getWidth().
	 *
	 * @return the width
	 * @see gama.common.ui.IDisplaySurface#getWidth()
	 */
	@Override
	public int getWidth() {
		return renderer.getCanvas().getSurfaceWidth();
		// return size.x;
	}

	/**
	 * Method getHeight().
	 *
	 * @return the height
	 * @see gama.common.ui.IDisplaySurface#getHeight()
	 */
	@Override
	public int getHeight() {
		return renderer.getCanvas().getSurfaceHeight();
		// return size.y;
	}

	/**
	 * Method outputReloaded().
	 *
	 * @see gama.common.ui.IDisplaySurface#outputReloaded()
	 */
	@Override
	public void outputReloaded() {
		setDisplayScope(output.getScope().copy("in opengl display"));
		if (!GamaPreferences.Runtime.ERRORS_IN_DISPLAYS.getValue()) { getScope().disableErrorReporting(); }
		renderer.initScene();
		layerManager.outputChanged();

		// resizeImage(getWidth(), getHeight(), true);
		if (zoomFit) { zoomFit(); }
	}

	/**
	 * Method addMouseListener().
	 *
	 * @param listener the listener
	 * @see gama.common.ui.IDisplaySurface#addMouseListener(java.awt.event.MouseListener)
	 */
	@Override
	public void addListener(final IEventLayerListener listener) {
		listeners.add(listener);
	}

	/**
	 * Method removeMouseListener().
	 *
	 * @param listener the listener
	 * @see gama.common.ui.IDisplaySurface#removeMouseListener(java.awt.event.MouseListener)
	 */
	@Override
	public void removeListener(final IEventLayerListener listener) {
		listeners.remove(listener);

	}

	/**
	 * Gets the layer listeners.
	 *
	 * @return the layer listeners
	 */
	@Override
	public Collection<IEventLayerListener> getLayerListeners() { return listeners; }

	/**
	 * Method getEnvWidth().
	 *
	 * @return the env width
	 * @see gama.common.ui.IDisplaySurface#getEnvWidth()
	 */
	@Override
	public double getEnvWidth() { return output.getData().getEnvWidth(); }

	/**
	 * Method getEnvHeight().
	 *
	 * @return the env height
	 * @see gama.common.ui.IDisplaySurface#getEnvHeight()
	 */
	@Override
	public double getEnvHeight() { return output.getData().getEnvHeight(); }

	/**
	 * Method getModelCoordinates().
	 *
	 * @return the model coordinates
	 * @see gama.common.ui.IDisplaySurface#getModelCoordinates()
	 */
	@Override
	public GamaPoint getModelCoordinates() {
		final GamaPoint mp = renderer.getCameraHelper().getMousePosition();
		if (mp == null) return null;
		final GamaPoint p = renderer.getRealWorldPointFromWindowPoint(mp);
		if (p == null) return null;
		return new GamaPoint(p.x, -p.y);
	}

	/**
	 * Gets the model coordinates info.
	 *
	 * @param sb the sb
	 * @return the model coordinates info
	 */
	@Override
	public void getModelCoordinatesInfo(final StringBuilder sb) {
		boolean canObtainInfo = getManager().isProvidingCoordinates();
		if (!canObtainInfo) {
			sb.append("No world coordinates");
			return;
		}
		canObtainInfo = getManager().isProvidingWorldCoordinates();
		if (!canObtainInfo) {
			sb.append("No world coordinates");
			return;
		}
		// By default, returns the coordinates in the world.
		final GamaPoint point = getModelCoordinates();
		final String x = point == null ? "N/A" : String.format("%8.6f", point.getX());
		final String y = point == null ? "N/A" : String.format("%8.6f", point.getY());
		sb.append(String.format("X%15s | Y%15s", x, y));
	}

	/**
	 * Gets the visible region for layer.
	 *
	 * @param currentLayer the current layer
	 * @return the visible region for layer
	 */
	@Override
	public Envelope getVisibleRegionForLayer(final ILayer currentLayer) {
		if (currentLayer instanceof OverlayLayer) return getScope().getSimulation().getEnvelope();
		Envelope e = currentLayer.getData().getVisibleRegion();
		if (e == null) {
			e = new Envelope();
			final Point origin = new Point(0, 0);
			int xc = -origin.x;
			int yc = -origin.y;
			e.expandToInclude(currentLayer.getModelCoordinatesFrom(xc, yc, this));
			xc = xc + renderer.getCanvas().getSurfaceWidth();
			yc = yc + renderer.getCanvas().getSurfaceHeight();
			e.expandToInclude(currentLayer.getModelCoordinatesFrom(xc, yc, this));
			currentLayer.getData().setVisibleRegion(e);
		}
		return e;
	}

	/**
	 * Method getModelCoordinatesFrom().
	 *
	 * @param xOnScreen the x on screen
	 * @param yOnScreen the y on screen
	 * @param sizeInPixels the size in pixels
	 * @param positionInPixels the position in pixels
	 * @return the model coordinates from
	 * @see gama.common.ui.IDisplaySurface#getModelCoordinatesFrom(int, int, java.awt.Point, java.awt.Point)
	 */
	@Override
	public GamaPoint getModelCoordinatesFrom(final int xOnScreen, final int yOnScreen, final Point sizeInPixels,
			final Point positionInPixels) {
		final GamaPoint mp = new GamaPoint(xOnScreen, yOnScreen);
		final GamaPoint p = renderer.getRealWorldPointFromWindowPoint(mp);
		return new GamaPoint(p.x, -p.y);
	}

	/**
	 * Method selectAgent().
	 *
	 * @param x the x
	 * @param y the y
	 * @return the collection
	 * @see gama.common.ui.IDisplaySurface#selectAgent(int, int)
	 */
	@Override
	public Collection<IAgent> selectAgent(final int x, final int y) {
		final GamaPoint pp = getModelCoordinatesFrom(x, y, null, null);
		return scope.getRoot().getTopology().getNeighborsOf(scope, new GamaPoint(pp.getX(), pp.getY()),
				renderer.getMaxEnvDim() / 100, Different.with());
	}

	/**
	 * Method followAgent().
	 *
	 * @param a the a
	 * @see gama.common.ui.IDisplaySurface#followAgent(gama.metamodel.agent.IAgent)
	 */
	@Override
	public void followAgent(final IAgent a) {
		new Thread(
				() -> WorkbenchHelper.asyncRun(() -> renderer.getCameraHelper().zoomFocus(a.getEnvelope().yNegated())))
						.start();

	}

	/**
	 * Method getZoomLevel().
	 *
	 * @return the zoom level
	 * @see gama.common.ui.IDisplaySurface#getZoomLevel()
	 */
	@Override
	public double getZoomLevel() {
		if (output.getData().getZoomLevel() == null) {
			output.getData().setZoomLevel(computeInitialZoomLevel(), true, false);
		}
		return output.getData().getZoomLevel();
	}

	/**
	 * Compute initial zoom level.
	 *
	 * @return the double
	 */
	protected Double computeInitialZoomLevel() {
		return renderer.getCameraHelper().zoomLevel();
	}

	/**
	 * Method getDisplayScope().
	 *
	 * @return the scope
	 * @see gama.common.ui.IDisplaySurface#getDisplayScope()
	 */
	@Override
	public IScope getScope() { return scope; }

	/**
	 * Method getOutput().
	 *
	 * @return the output
	 * @see gama.common.ui.IDisplaySurface#getOutput()
	 */
	@Override
	public LayeredDisplayOutput getOutput() { return output; }

	/**
	 * Method setPaused().
	 *
	 * @param paused the new paused
	 * @see gama.common.ui.IDisplaySurface.OpenGL#setPaused(boolean)
	 */
	@Override
	public void setPaused(final boolean paused) {
		if (paused) {
			animator.pause();
		} else {
			animator.resume();
		}
	}

	/** The cleanup. */
	final Runnable cleanup = () -> WorkbenchHelper.asyncRun(() -> renderer.getPickingHelper().setPicking(false));

	/**
	 * Method selectAgents().
	 *
	 * @param attributes the attributes
	 * @see gama.common.ui.IDisplaySurface.OpenGL#selectAgents(gama.metamodel.agent.IAgent)
	 */
	@Override
	public void selectAgent(final DrawingAttributes attributes) {
		IAgent ag = null;
		boolean withHighlight = true;
		if (attributes != null) {
			if (attributes.getSpeciesName() != null) {
				// The picked image is a grid or an image of a grid
				withHighlight = false;
				final GamaPoint pickedPoint = renderer
						.getRealWorldPointFromWindowPoint(renderer.getCameraHelper().getLastMousePressedPosition());
				ag = scope.getRoot().getPopulationFor(attributes.getSpeciesName()).getAgent(scope,
						new GamaPoint(pickedPoint.x, -pickedPoint.y));
			} else {
				ag = attributes.getAgentIdentifier();
			}
		}
		if (withHighlight) {
			menuManager.buildMenu((int) renderer.getCameraHelper().getMousePosition().x,
					(int) renderer.getCameraHelper().getMousePosition().y, ag, cleanup,
					AgentsMenu.getHighlightActionFor(ag));
		} else {
			menuManager.buildMenu((int) renderer.getCameraHelper().getMousePosition().x,
					(int) renderer.getCameraHelper().getMousePosition().y, ag, cleanup);
		}
	}

	/**
	 * Method selectSeveralAgents().
	 *
	 * @param env the env
	 * @see gama.common.ui.IDisplaySurface.OpenGL#selectSeveralAgents(java.util.Collection, int)
	 */
	@Override
	public void selectionIn(final Envelope3D env) {

		final Envelope3D envInWorld = Envelope3D.withYNegated(env);
		final Collection<IAgent> agents = scope.getTopology().getSpatialIndex().allInEnvelope(scope,
				envInWorld.centre(), envInWorld, new Different(), false);
		final Map<String, Runnable> actions = new LinkedHashMap<>();
		final Map<String, Image> images = new HashMap<>();
		images.put(renderer.getOpenGLHelper().isStickyROI() ? "Hide region" : "Keep region visible",
				GamaIcons.create(IGamaIcons.MENU_FOLLOW).image());
		images.put("Focus on region", GamaIcons.create(IGamaIcons.DISPLAY_TOOLBAR_ZOOMFIT).image());
		actions.put(renderer.getOpenGLHelper().isStickyROI() ? "Hide region" : "Keep region visible",
				() -> renderer.getOpenGLHelper().toogleROI());
		actions.put("Focus on region", () -> renderer.getCameraHelper().zoomFocus(env));
		WorkbenchHelper.run(() -> {
			final Menu menu = menuManager.buildROIMenu((int) renderer.getCameraHelper().getMousePosition().x,
					(int) renderer.getCameraHelper().getMousePosition().y, agents, actions, images);
			menu.addMenuListener(new MenuListener() {

				@Override
				public void menuHidden(final MenuEvent e) {
					animator.resume();
					// Will be run after the selection
					WorkbenchHelper.asyncRun(() -> renderer.getOpenGLHelper().cancelROI());

				}

				@Override
				public void menuShown(final MenuEvent e) {
					animator.pause();
				}
			});

			menu.setVisible(true);
		});

	}

	/**
	 * Sets the display scope.
	 *
	 * @param scope
	 *            the new display scope
	 */
	protected void setDisplayScope(final IScope scope) {
		if (this.scope != null) { GAMA.releaseScope(this.scope); }
		this.scope = scope;
	}

	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {
		if (disposed) return;
		disposed = true;
		if (layerManager != null) { layerManager.dispose(); }
		if (animator != null && animator.isStarted()) { animator.stop(); }
		this.menuManager = null;
		this.listeners.clear();
		this.renderer = null;
		GAMA.releaseScope(getScope());
		setDisplayScope(null);
		synchronizer.signalRenderingIsFinished();
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	@Override
	public LayeredDisplayData getData() { return output.getData(); }

	/**
	 * Method changed().
	 *
	 * @param property the property
	 * @param value the value
	 * @see gama.outputs.LayeredDisplayData.DisplayDataListener#changed(int, boolean)
	 */
	@Override
	public void changed(final Changes property, final Object value) {
		if (renderer == null) return;
		switch (property) {

			case CHANGE_CAMERA:
				renderer.getCameraHelper().setupCamera();
				break;
			case SPLIT_LAYER:
				final double gap = (Double) value;
				// if (DEBUG.IS_ON()) {
				// DEBUG.OUT("Value received by SWTOpenGLDisplaySurface= " + value);
				// }
				double currentElevation = 0;

				for (final ILayer layer : this.getManager().getItems()) {
					layer.getData().addElevation(currentElevation);
					currentElevation += gap;
				}
				renderer.getSceneHelper().layerOffsetChanged();

				break;
			case CAMERA_POS:
				renderer.getCameraHelper().updatePosition();
				break;
			case CAMERA_ORIENTATION:
				renderer.getCameraHelper().updateOrientation();
				break;
			case CAMERA_TARGET:
				renderer.getCameraHelper().updateTarget();
				break;
			case CAMERA_PRESET:
				renderer.getCameraHelper().applyPreset((String) value);
				break;
			case ZOOM:
				renderer.getCameraHelper().zoom((Double) value);
				break;
			default:
				break;

		}

	}

	/**
	 * Method setSize().
	 *
	 * @param x the x
	 * @param y the y
	 * @see gama.common.ui.IDisplaySurface#setSize(int, int)
	 */
	@Override
	public void setSize(final int x, final int y) {}

	/**
	 * Layers changed.
	 */
	@Override
	public void layersChanged() {
		renderer.getSceneHelper().layersChanged();

	}

	/**
	 * Invalidate visible regions.
	 */
	public void invalidateVisibleRegions() {
		for (final ILayer layer : layerManager.getItems()) {
			layer.getData().setVisibleRegion(null);
		}
	}

	/**
	 * Method getFPS().
	 *
	 * @return the fps
	 * @see gama.common.ui.IDisplaySurface#getFPS()
	 */
	@Override
	public int getFPS() { return Math.round(this.animator.getLastFPS()); }

	// @Override
	// public boolean isRealized() {
	// if (renderer == null) return false;
	// final GLAutoDrawable d = renderer.getCanvas();
	// if (d == null) return false;
	// return d.isRealized();
	// }

	/**
	 * Checks if is rendered.
	 *
	 * @return true, if is rendered
	 */
	@Override
	public boolean isRendered() {
		if (renderer == null || renderer.getSceneHelper().getSceneToRender() == null) return false;
		return renderer.getSceneHelper().getSceneToRender().rendered();
	}

	/**
	 * Checks if is disposed.
	 *
	 * @return true, if is disposed
	 */
	@Override
	public boolean isDisposed() { return disposed; }

	/**
	 * Gets the ROI dimensions.
	 *
	 * @return the ROI dimensions
	 */
	@Override
	public Envelope3D getROIDimensions() { return renderer.getOpenGLHelper().getROIEnvelope(); }

	/**
	 * Dispatch key event.
	 *
	 * @param e the e
	 */
	@Override
	public void dispatchKeyEvent(final char e) {
		for (final IEventLayerListener gl : listeners) {
			gl.keyPressed(String.valueOf(e));
		}
	}

	/**
	 * Dispatch mouse event.
	 *
	 * @param swtMouseEvent the swt mouse event
	 */
	@Override
	public void dispatchMouseEvent(final int swtMouseEvent) {
		final GamaPoint p = renderer.getCameraHelper().getMousePosition();
		final int x = (int) p.x;
		final int y = (int) p.y;
		for (final IEventLayerListener gl : listeners) {
			switch (swtMouseEvent) {
				case SWT.MouseDown:
					gl.mouseDown(x, y, 1);
					break;
				case SWT.MouseUp:
					gl.mouseUp(x, y, 1);
					break;
				case SWT.MouseMove:
					gl.mouseMove(x, y);
					break;
				case SWT.MouseEnter:
					gl.mouseEnter(x, y);
					break;
				case SWT.MouseExit:
					gl.mouseExit(x, y);
					break;
				case SWT.MenuDetect:
					gl.mouseMenu(x, y);
					break;
			}
		}
	}

	/**
	 * Sets the mouse position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	@Override
	public void setMousePosition(final int x, final int y) {
		// Nothing to do (taken in charge by the camera)

	}

	/**
	 * Select agents around mouse.
	 */
	@Override
	public void selectAgentsAroundMouse() {
		// Nothing to do (taken in charge by the camera)
	}

	/**
	 * Dragged to.
	 *
	 * @param x the x
	 * @param y the y
	 */
	@Override
	public void draggedTo(final int x, final int y) {
		// Nothing to do (taken in charge by the camera

	}

	/**
	 * Sets the display synchronizer.
	 *
	 * @param s the new display synchronizer
	 */
	@Override
	public void setDisplaySynchronizer(final IDisplaySynchronizer s) {
		synchronizer = s;
		synchronizer.signalSurfaceIsRealized();
	}

}
