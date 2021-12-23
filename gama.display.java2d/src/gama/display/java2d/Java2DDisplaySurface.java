/*******************************************************************************************************
 *
 * Java2DDisplaySurface.java, in gama.display.java2d, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.display.java2d;

/*********************************************************************************************
 *
 *
 * 'AbstractAWTDisplaySurface.java', in plugin 'msi.gama.application', is part of the source code of the GAMA modeling
 * and simulation platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Semaphore;

import javax.swing.JPanel;

import org.eclipse.swt.SWT;
import org.locationtech.jts.geom.Envelope;

import gama.common.interfaces.IKeyword;
import gama.common.preferences.GamaPreferences;
import gama.common.ui.IDisplaySurface;
import gama.common.ui.IDisplaySynchronizer;
import gama.common.ui.IGraphics;
import gama.common.ui.ILayer;
import gama.common.ui.ILayerManager;
import gama.common.util.ImageUtils;
import gama.core.dev.annotations.GamlAnnotations.display;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.utils.DEBUG;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.outputs.LayeredDisplayData;
import gama.outputs.LayeredDisplayData.Changes;
import gama.outputs.LayeredDisplayOutput;
import gama.outputs.display.AWTDisplayGraphics;
import gama.outputs.display.LayerManager;
import gama.outputs.layers.IEventLayerListener;
import gama.outputs.layers.OverlayLayer;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.ui.base.utils.PlatformHelper;
import gama.ui.experiment.views.displays.DisplaySurfaceMenu;
import gaml.expressions.IExpression;
import gaml.operators.Cast;

// TODO: Auto-generated Javadoc
/**
 * The Class Java2DDisplaySurface.
 */
@display ("java2D")
@doc ("Display that uses the Java2D technology to draw the layers in a SWT view")
public class Java2DDisplaySurface extends JPanel implements IDisplaySurface {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	static {
		DEBUG.OFF();
		GamaPreferences.Displays.DISPLAY_NO_ACCELERATION.onChange(newValue -> {
			System.setProperty("sun.java2d.noddraw", newValue ? "true" : "false");
			System.setProperty("sun.awt.noerasebackground", "true");
			System.setProperty("sun.java2d.d3d", newValue ? "false" : "true");
			System.setProperty("sun.java2d.opengl", newValue ? "false" : "true");
			System.setProperty("sun.java2d.pmoffscreen", newValue ? "false" : "true");
		});
		// Forces the listener to run at least once
		GamaPreferences.Displays.DISPLAY_NO_ACCELERATION
		.set(GamaPreferences.Displays.DISPLAY_NO_ACCELERATION.getValue());
	}

	/** The output. */
	final LayeredDisplayOutput output;

	/** The view port. */
	protected final Rectangle viewPort = new Rectangle();

	/** The layer manager. */
	// protected final AffineTransform translation = new AffineTransform();
	protected final ILayerManager layerManager;

	/** The i graphics. */
	protected IGraphics iGraphics;

	/** The menu manager. */
	protected DisplaySurfaceMenu menuManager;

	/** The temp focus. */
	protected IExpression temp_focus;

	/** The render lock. */
	Semaphore renderLock = new Semaphore(1);

	/** The previous panel size. */
	protected Dimension previousPanelSize;

	/** The zoom increment. */
	protected double zoomIncrement = 0.1;

	/** The zoom fit. */
	protected boolean zoomFit = true;

	/** The disposed. */
	protected volatile boolean disposed;

	/** The scope. */
	private IScope scope;

	/** The frames. */
	int frames;

	/** The synchronizer. */
	private IDisplaySynchronizer synchronizer;

	/** The rendered. */
	private volatile boolean rendered = false;

	/** The listeners. */
	Set<IEventLayerListener> listeners = new HashSet<>();

	/** The mouse position. */
	Point mousePosition;

	/**
	 * Instantiates a new java 2 D display surface.
	 *
	 * @param args
	 *            the args
	 */
	public Java2DDisplaySurface(final Object... args) {
		output = (LayeredDisplayOutput) args[0];
		output.setSurface(this);
		setDisplayScope(output.getScope().copy("in java2D display"));
		output.getData().addListener(this);
		temp_focus = output.getFacet(IKeyword.FOCUS);
		setDoubleBuffered(true);
		setIgnoreRepaint(true);
		setLayout(new BorderLayout());
		setBackground(output.getData().getBackgroundColor());
		setName(output.getName());
		layerManager = new LayerManager(this, output);
		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(final ComponentEvent e) {
				if (zoomFit) {
					zoomFit();
				} else {
					if (isFullImageInPanel()) {
						centerImage();
					} else if (isImageEdgeInPanel()) { scaleOrigin(); }
					updateDisplay(true);
				}
				final double newZoom = Math.min(getWidth() / getDisplayWidth(), getHeight() / getDisplayHeight());
				newZoomLevel(1 / newZoom);
				previousPanelSize = getSize();
			}
		});

	}

	/**
	 * Sets the menu manager.
	 *
	 * @param menuManager the new menu manager
	 */
	@Override
	public void setMenuManager(final Object menuManager) { this.menuManager = (DisplaySurfaceMenu) menuManager; }

	/**
	 * Gets the fps.
	 *
	 * @return the fps
	 */
	@Override
	public int getFPS() {
		final int result = frames;
		frames = 0;
		return result;
	}

	/**
	 * Dispatch key event.
	 *
	 * @param e the e
	 */
	@Override
	public void dispatchKeyEvent(final char e) {
		for (final IEventLayerListener gl : listeners) { gl.keyPressed(String.valueOf(e)); }
	}

	/**
	 * Sets the mouse position.
	 *
	 * @param xm the xm
	 * @param ym the ym
	 */
	@Override
	public void setMousePosition(final int xm, final int ym) {
		final int x = PlatformHelper.autoScaleUp(xm);
		final int y = PlatformHelper.autoScaleUp(ym);
		if (mousePosition == null) {
			mousePosition = new Point(x, y);
		} else {
			mousePosition.setLocation(x, y);
		}
	}

	/**
	 * Dragged to.
	 *
	 * @param x the x
	 * @param y the y
	 */
	@Override
	public void draggedTo(final int x, final int y) {
		final Point origin = getOrigin();
		setOrigin(origin.x + PlatformHelper.autoScaleUp(x) - getMousePosition().x,
				origin.y + PlatformHelper.autoScaleUp(y) - getMousePosition().y);
		//	DEBUG.OUT("Translation on X : " + (PlatformHelper.autoScaleUp(x) - getMousePosition().x) + " | on Y : "
		//			+ (PlatformHelper.autoScaleUp(y) - getMousePosition().y));
		//	DEBUG.OUT("Old Origin = " + origin + " | New Origin = " + getOrigin());
		setMousePosition(x, y);
		updateDisplay(true);
	}

	/**
	 * Gets the mouse position.
	 *
	 * @return the mouse position
	 */
	@Override
	public Point getMousePosition() { return mousePosition; }

	/**
	 * Dispatch mouse event.
	 *
	 * @param swtMouseEvent the swt mouse event
	 */
	@Override
	public void dispatchMouseEvent(final int swtMouseEvent) {
		final int x = mousePosition.x;
		final int y = mousePosition.y;
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
	 * Output reloaded.
	 */
	@Override
	public void outputReloaded() {
		// We first copy the scope
		setDisplayScope(output.getScope().copy("in java2D display "));
		// We disable error reporting
		if (!GamaPreferences.Runtime.ERRORS_IN_DISPLAYS.getValue()) { getScope().disableErrorReporting(); }
		layerManager.outputChanged();
		resizeImage(getWidth(), getHeight(), true);
		if (zoomFit) { zoomFit(); }
		updateDisplay(true);
	}

	/**
	 * Gets the scope.
	 *
	 * @return the scope
	 */
	@Override
	public IScope getScope() { return scope; }

	/**
	 * Gets the manager.
	 *
	 * @return the manager
	 */
	@Override
	public ILayerManager getManager() { return layerManager; }

	/**
	 * Gets the origin.
	 *
	 * @return the origin
	 */
	Point getOrigin() { return viewPort.getLocation(); }

	/**
	 * Sets the font.
	 *
	 * @param f the new font
	 */
	@Override
	public void setFont(final Font f) {}

	/**
	 * Gets the image.
	 *
	 * @param w the w
	 * @param h the h
	 * @return the image
	 */
	@Override
	public BufferedImage getImage(final int w, final int h) {
		final int previousWidth = getWidth();
		final int previousHeight = getHeight();
		final int width = w == -1 ? previousWidth : w;
		final int height = h == -1 ? previousHeight : h;
		final boolean sameSize = width == previousWidth && height == previousHeight;
		final BufferedImage newImage = ImageUtils.createCompatibleImage(width, height, false);
		final Graphics g = newImage.getGraphics();

		while (!rendered) {
			try {
				Thread.sleep(10);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			EventQueue.invokeAndWait(() -> {
				final Rectangle old = new Rectangle(viewPort);
				if (!sameSize) {
					viewPort.x = viewPort.y = 0;
					final int[] point = computeBoundsFrom(width, height);
					viewPort.width = point[0];
					viewPort.height = point[1];
					// resizeImage(width, height, false);

				}
				print(g);
				if (!sameSize) {
					// resizeImage(previousWidth, previousHeight, false);
					viewPort.setBounds(old);
				}

			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
		g.dispose();
		return newImage;
	}

	/**
	 * Scale origin.
	 */
	protected void scaleOrigin() {
		final Point origin = getOrigin();
		setOrigin((int) Math.round((double) origin.x * getWidth() / previousPanelSize.width),
				(int) Math.round((double) origin.y * getHeight() / previousPanelSize.height));
		updateDisplay(true);
	}

	/**
	 * Center image.
	 */
	protected void centerImage() {
		setOrigin((int) Math.round((getWidth() - getDisplayWidth()) / 2d),
				(int) Math.round((getHeight() - getDisplayHeight()) / 2d));
	}

	/**
	 * Gets the origin X.
	 *
	 * @return the origin X
	 */
	protected int getOriginX() { return getOrigin().x; }

	/**
	 * Gets the origin Y.
	 *
	 * @return the origin Y
	 */
	protected int getOriginY() { return getOrigin().y; }

	/**
	 * Sets the origin.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	void setOrigin(final int x, final int y) {
		// Temporarily reverts the changes introduced for #2367
		final int inset = 0;
		viewPort.setLocation(x - inset, y - inset);
	}

	/**
	 * Update display.
	 *
	 * @param force the force
	 */
	@Override
	public void updateDisplay(final boolean force) {
		if (disposed) return;
		rendered = false;
		EventQueue.invokeLater(this::repaint);
	}

	/**
	 * Focus on.
	 *
	 * @param geometry the geometry
	 */
	@Override
	public void focusOn(final IShape geometry) {
		final Rectangle2D r = this.getManager().focusOn(geometry, this);
		if (r == null) return;
		final double xScale = getWidth() / r.getWidth();
		final double yScale = getHeight() / r.getHeight();
		double zoomFactor = Math.min(xScale, yScale);
		final Point center = new Point((int) Math.round(r.getCenterX()), (int) Math.round(r.getCenterY()));

		zoomFactor = applyZoom(zoomFactor);
		center.setLocation(center.x * zoomFactor, center.y * zoomFactor);
		centerOnDisplayCoordinates(center);

		updateDisplay(true);
	}

	/**
	 * Validate.
	 */
	@Override
	public void validate() {}

	/**
	 * Do layout.
	 */
	@Override
	public void doLayout() {}

	/**
	 * Zoom.
	 *
	 * @param in
	 *            whether it is a Zoom in (true) or a Zoom out (false)
	 */
	private void zoom(final boolean in) {
		final Point origin = getOrigin();
		final Point p = getMousePosition();
		int x = p.x;
		int y = p.y;
		if (x == -1 && y == -1) {
			x = getWidth() / 2;
			y = getHeight() / 2;
		}
		final double zoomFactor = applyZoom(1.0 + (in ? 1 : -1) * zoomIncrement);
		final long newx = Math.round(zoomFactor * (x - origin.x) - x + getWidth() / 2d);
		final long newy = Math.round(zoomFactor * (y - origin.y) - y + getHeight() / 2d);
		centerOnDisplayCoordinates(new Point((int) newx, (int) newy));
		// DEBUG.OUT("Zoom " + (in ? "in" : "out") + " Origin of image: " + oldOrig + " / Mouse position: " + p
		// + " / Zoom factor: " + zoomFactor + " / New Origin " + origin);
		updateDisplay(true);
	}

	/**
	 * Zoom in.
	 */
	@Override
	public void zoomIn() {
		zoom(true);
	}

	/**
	 * Zoom out.
	 */
	@Override
	public void zoomOut() {
		zoom(false);
	}

	/**
	 * Checks if is image edge in panel.
	 *
	 * @return true, if is image edge in panel
	 */
	// Used when the image is resized.
	public boolean isImageEdgeInPanel() {
		if (previousPanelSize == null) return false;
		final Point origin = getOrigin();
		return origin.x > 0 && origin.x < previousPanelSize.width
				|| origin.y > 0 && origin.y < previousPanelSize.height;
	}

	/**
	 * Checks if is full image in panel.
	 *
	 * @return true, if is full image in panel
	 */
	// Tests whether the image is displayed in its entirety in the panel.
	public boolean isFullImageInPanel() {
		final Point origin = getOrigin();
		return origin.x >= 0 && origin.x + getDisplayWidth() < getWidth() && origin.y >= 0
				&& origin.y + getDisplayHeight() < getHeight();
	}

	/**
	 * Resize image.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param force
	 *            the force
	 * @return true, if successful
	 */
	public boolean resizeImage(final int x, final int y, final boolean force) {
		//		DEBUG.OUT("Try to resize image to " + x + " " + y + "(current size is: " + getDisplayWidth() + " "
		//				+ getDisplayHeight());
		if (!force && x == getDisplayWidth() && y == getDisplayHeight()) return true;
		if (x < 10 || y < 10 || getWidth() <= 0 && getHeight() <= 0) return false;

		final int[] point = computeBoundsFrom(x, y);
		final int imageWidth = Math.max(1, point[0]);
		final int imageHeight = Math.max(1, point[1]);
		setDisplayHeight(imageHeight);
		setDisplayWidth(imageWidth);
		//		DEBUG.OUT("Resize Image suceeded : " + imageWidth + " " + imageHeight);
		iGraphics = new AWTDisplayGraphics((Graphics2D) this.getGraphics());
		iGraphics.setDisplaySurface(this);
		return true;

	}

	/**
	 * Paint component.
	 *
	 * @param g the g
	 */
	@Override
	public void paintComponent(final Graphics g) {
		final AWTDisplayGraphics gg = getIGraphics();
		if (gg == null) return;
		// DEBUG.OUT("-- Surface effectively painting on Java2D context");
		super.paintComponent(g);
		final Graphics2D g2d = (Graphics2D) g.create(getOrigin().x, getOrigin().y, (int) Math.round(getDisplayWidth()),
				(int) Math.round(getDisplayHeight()));
		gg.setGraphics2D(g2d);
		gg.setUntranslatedGraphics2D((Graphics2D) g);
		layerManager.drawLayersOn(gg);
		if (temp_focus != null) {
			final IShape geometry = Cast.asGeometry(getScope(), temp_focus.value(getScope()), false);
			temp_focus = null;
			focusOn(geometry);
			rendered = true;
			synchronizer.signalRenderingIsFinished();
			return;
		}

		// TODO Verify that the following expressions should not be also included in the "focus" block
		g2d.dispose();
		frames++;
		rendered = true;
		if (synchronizer != null) { synchronizer.signalRenderingIsFinished(); }
	}

	/**
	 * Gets the i graphics.
	 *
	 * @return the i graphics
	 */
	AWTDisplayGraphics getIGraphics() { return (AWTDisplayGraphics) iGraphics; }

	/**
	 * Gets the model coordinates.
	 *
	 * @return the model coordinates
	 */
	@Override
	public GamaPoint getModelCoordinates() {
		final Point origin = getOrigin();
		final Point mouse = getMousePosition();
		if (mouse == null) return null;
		final int xc = mouse.x - origin.x;
		final int yc = mouse.y - origin.y;
		final List<ILayer> layers = layerManager.getLayersIntersecting(xc, yc);
		for (final ILayer layer : layers) {
			if (layer.isProvidingWorldCoordinates()) return layer.getModelCoordinatesFrom(xc, yc, this);
		}
		// See Issue #2783: we dont return null but 0,0.
		// return null;
		return new GamaPoint();
	}

	/**
	 * Gets the model coordinates info.
	 *
	 * @param sb the sb
	 * @return the model coordinates info
	 */
	@Override
	public void getModelCoordinatesInfo(final StringBuilder sb) {
		final Point origin = getOrigin();
		final Point mouse = getMousePosition();
		if (mouse == null) return;
		final int xc = mouse.x - origin.x;
		final int yc = mouse.y - origin.y;
		final List<ILayer> layers = layerManager.getLayersIntersecting(xc, yc);
		for (final ILayer layer : layers) {
			if (layer.isProvidingCoordinates()) {
				layer.getModelCoordinatesInfo(xc, yc, this, sb);
				return;
			}
		}
		sb.append("No world coordinates");
	}

	/**
	 * Gets the env width.
	 *
	 * @return the env width
	 */
	@Override
	public double getEnvWidth() { return output.getData().getEnvWidth(); }

	/**
	 * Gets the env height.
	 *
	 * @return the env height
	 */
	@Override
	public double getEnvHeight() { return output.getData().getEnvHeight(); }

	/**
	 * Gets the display width.
	 *
	 * @return the display width
	 */
	@Override
	public double getDisplayWidth() { return viewPort.width; }

	/**
	 * Sets the display width.
	 *
	 * @param displayWidth
	 *            the new display width
	 */
	protected void setDisplayWidth(final int displayWidth) { viewPort.width = displayWidth /*- 2*/; }

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	@Override
	public LayeredDisplayData getData() { return output.getData(); }

	/**
	 * Gets the display height.
	 *
	 * @return the display height
	 */
	@Override
	public double getDisplayHeight() { return viewPort.height; }

	/**
	 * Sets the display height.
	 *
	 * @param displayHeight
	 *            the new display height
	 */
	protected void setDisplayHeight(final int displayHeight) { viewPort.height = displayHeight /*- 2*/; }

	/**
	 * Gets the output.
	 *
	 * @return the output
	 */
	@Override
	public LayeredDisplayOutput getOutput() { return output; }

	/**
	 * New zoom level.
	 *
	 * @param newZoomLevel
	 *            the new zoom level
	 */
	public void newZoomLevel(final double newZoomLevel) {
		getData().setZoomLevel(newZoomLevel, true, false);
	}

	/**
	 * Gets the zoom level.
	 *
	 * @return the zoom level
	 */
	@Override
	public double getZoomLevel() {
		if (getData().getZoomLevel() == null) { getData().setZoomLevel(1.0, true, false); }
		return getData().getZoomLevel();
	}

	/**
	 * Zoom fit.
	 */
	@Override
	public void zoomFit() {
		final int w = getWidth() - 2;
		final int h = getHeight() - 2;
		// - 2 to accomodate for #2367
		setMousePosition((int) Math.round((double) w / 2), (int) Math.round((double) h / 2));
		if (resizeImage(w, h, false)) {
			newZoomLevel(1d);
			zoomFit = true;
			centerImage();
			updateDisplay(true);
		}
	}

	/**
	 * Compute bounds from.
	 *
	 * @param vwidth
	 *            the vwidth
	 * @param vheight
	 *            the vheight
	 * @return the int[]
	 */
	private int[] computeBoundsFrom(final int vwidth, final int vheight) {
		if (!layerManager.stayProportional()) return new int[] { vwidth, vheight };
		final int[] dim = new int[2];
		final double widthHeightConstraint = getEnvHeight() / getEnvWidth();
		if (widthHeightConstraint < 1) {
			dim[1] = Math.min(vheight, (int) Math.round(vwidth * widthHeightConstraint));
			dim[0] = Math.min(vwidth, (int) Math.round(dim[1] / widthHeightConstraint));
		} else {
			dim[0] = Math.min(vwidth, (int) Math.round(vheight / widthHeightConstraint));
			dim[1] = Math.min(vheight, (int) Math.round(dim[0] * widthHeightConstraint));
		}
		return dim;
	}

	/**
	 * Gets the model coordinates from.
	 *
	 * @param xOnScreen the x on screen
	 * @param yOnScreen the y on screen
	 * @param sizeInPixels the size in pixels
	 * @param positionInPixels the position in pixels
	 * @return the model coordinates from
	 */
	@Override
	public GamaPoint getModelCoordinatesFrom(final int xOnScreen, final int yOnScreen, final Point sizeInPixels,
			final Point positionInPixels) {
		final double xScale = sizeInPixels.x / getEnvWidth();
		final double yScale = sizeInPixels.y / getEnvHeight();
		final int xInDisplay = xOnScreen - positionInPixels.x;
		final int yInDisplay = yOnScreen - positionInPixels.y;
		final double xInModel = xInDisplay / xScale;
		final double yInModel = yInDisplay / yScale;
		return new GamaPoint(xInModel, yInModel);
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
		final Envelope e = new Envelope();
		final Point origin = getOrigin();
		int xc = -origin.x;
		int yc = -origin.y;
		e.expandToInclude(currentLayer.getModelCoordinatesFrom(xc, yc, this));
		xc = xc + getIGraphics().getViewWidth();
		yc = yc + getIGraphics().getViewHeight();
		e.expandToInclude(currentLayer.getModelCoordinatesFrom(xc, yc, this));
		return e;
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
	 * Run and update.
	 *
	 * @param r the r
	 */
	@Override
	public void runAndUpdate(final Runnable r) {
		new Thread(() -> {
			r.run();
			if (output.isPaused() || getScope().isPaused()) { updateDisplay(true); }
		}).start();
	}

	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {
		getData().removeListener(this);
		if (disposed) return;
		// setRealized(false);
		disposed = true;
		if (layerManager != null) { layerManager.dispose(); }

		GAMA.releaseScope(getScope());
		setDisplayScope(null);
	}

	/**
	 * Adds the listener.
	 *
	 * @param ell the ell
	 */
	@Override
	public void addListener(final IEventLayerListener ell) {
		listeners.add(ell);
	}

	/**
	 * Removes the listener.
	 *
	 * @param ell the ell
	 */
	@Override
	public void removeListener(final IEventLayerListener ell) {
		listeners.remove(ell);
	}

	/**
	 * Gets the layer listeners.
	 *
	 * @return the layer listeners
	 */
	@Override
	public Collection<IEventLayerListener> getLayerListeners() { return listeners; }

	/**
	 * Method followAgent().
	 *
	 * @param a the a
	 * @see msi.gama.common.interfaces.IDisplaySurface#followAgent(msi.gama.metamodel.agent.IAgent)
	 */
	@Override
	public void followAgent(final IAgent a) {}

	/**
	 * Sets the bounds.
	 *
	 * @param arg0 the arg 0
	 * @param arg1 the arg 1
	 * @param arg2 the arg 2
	 * @param arg3 the arg 3
	 */
	@Override
	public void setBounds(final int arg0, final int arg1, final int arg2, final int arg3) {
		// DEBUG.OUT("-- Java2D surface set bounds to " + arg0 + " " + arg1 + " | " + arg2 + " " + arg3);
		if (arg2 == 0 && arg3 == 0) return;
		super.setBounds(arg0, arg1, arg2, arg3);
	}

	/**
	 * Apply zoom.
	 *
	 * @param factor
	 *            the factor
	 * @return the double
	 */
	double applyZoom(final double factor) {
		double real_factor =
				Math.max(MIN_ZOOM_FACTOR, Math.min(MAX_ZOOM_FACTOR, Math.min(factor, 10 / getZoomLevel())));
		final boolean success = resizeImage(Math.max(10, (int) Math.round(getDisplayWidth() * real_factor)),
				Math.max(10, (int) Math.round(getDisplayHeight() * real_factor)), false);

		if (success) {
			zoomFit = false;
			final double widthHeightConstraint = getEnvHeight() / getEnvWidth();

			if (widthHeightConstraint < 1) {
				newZoomLevel(getDisplayWidth() / getWidth());
			} else {
				newZoomLevel(getDisplayHeight() / getHeight());
			}
		}
		return real_factor;
	}

	/**
	 * Center on view coordinates.
	 *
	 * @param p
	 *            the p
	 */
	private void centerOnViewCoordinates(final Point p) {
		final Point origin = getOrigin();
		final int translationX = p.x - Math.round(getWidth() / (float) 2);
		final int translationY = p.y - Math.round(getHeight() / (float) 2);
		setOrigin(origin.x - translationX, origin.y - translationY);

	}

	/**
	 * Center on display coordinates.
	 *
	 * @param p
	 *            the p
	 */
	void centerOnDisplayCoordinates(final Point p) {
		final Point origin = getOrigin();
		centerOnViewCoordinates(new Point(p.x + origin.x, p.y + origin.y));
	}

	/**
	 * Select agents around mouse.
	 */
	@Override
	public void selectAgentsAroundMouse() {
		final int mousex = getMousePosition().x;
		final int mousey = getMousePosition().y;
		final Point origin = getOrigin();
		final int xc = mousex - origin.x;
		final int yc = mousey - origin.y;
		final List<ILayer> layers = layerManager.getLayersIntersecting(xc, yc);
		if (layers.isEmpty()) return;
		try {
			EventQueue.invokeAndWait(() -> menuManager.buildMenu(mousex, mousey, xc, yc, layers));
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}	}

	/**
	 * Select agent.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the collection
	 */
	@Override
	public Collection<IAgent> selectAgent(final int x, final int y) {
		final int xc = x - getOriginX();
		final int yc = y - getOriginY();
		final List<IAgent> result = new ArrayList<>();
		final List<ILayer> layers = getManager().getLayersIntersecting(xc, yc);
		for (final ILayer layer : layers) {
			final Set<IAgent> agents = layer.collectAgentsAt(xc, yc, this);
			if (!agents.isEmpty()) { result.addAll(agents); }
		}
		return result;
	}

	/**
	 * Layers changed.
	 */
	@Override
	public void layersChanged() {}

	/**
	 * Method changed().
	 *
	 * @param property the property
	 * @param value the value
	 * @see msi.gama.outputs.LayeredDisplayData.DisplayDataListener#changed(int, boolean)
	 */
	@Override
	public void changed(final Changes property, final Object value) {

		switch (property) {
			case BACKGROUND:
				setBackground((Color) value);
				break;
			default:
				;
		}

	}

	/**
	 * Checks if is rendered.
	 *
	 * @return true, if is rendered
	 */
	@Override
	public boolean isRendered() { return rendered; }

	/**
	 * Checks if is disposed.
	 *
	 * @return true, if is disposed
	 */
	@Override
	public boolean isDisposed() { return disposed; }

	/**
	 * Compute font.
	 *
	 * @param f the f
	 * @return the font
	 */
	@Override
	public Font computeFont(final Font f) {
		if (f == null) return null;
		if (PlatformHelper.isWindows() && PlatformHelper.isHiDPI())
			return f.deriveFont(PlatformHelper.autoScaleUp(f.getSize()));
		return f;

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