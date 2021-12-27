/*******************************************************************************************************
 *
 * ImageDisplaySurface.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.outputs;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Collections;

import javax.imageio.ImageIO;

import org.locationtech.jts.geom.Envelope;

import gama.common.preferences.GamaPreferences;
import gama.common.ui.IDisplaySurface;
import gama.common.ui.IGraphics;
import gama.common.ui.ILayer;
import gama.common.ui.ILayerManager;
import gama.common.util.ImageUtils;
import gama.core.dev.annotations.GamlAnnotations.display;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.outputs.LayeredDisplayData.Changes;
import gama.outputs.display.AWTDisplayGraphics;
import gama.outputs.display.LayerManager;
import gama.outputs.layers.IEventLayerListener;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaListFactory;
import gama.util.IList;
import gaml.operators.Files;

// TODO: Auto-generated Javadoc
/**
 * The Class ImageDisplaySurface.
 */
@display ("image")
public class ImageDisplaySurface implements IDisplaySurface {

	/** The output. */
	private final LayeredDisplayOutput output;

	/** The buff image. */
	// private final boolean needsUpdate = true;
	private BufferedImage buffImage = null;

	/** The g 2. */
	private Graphics2D g2 = null;

	/** The height. */
	private int width = 500, height = 500;

	/** The display graphics. */
	private IGraphics displayGraphics;

	/** The manager. */
	ILayerManager manager;

	/** The snapshot folder. */
	public static String snapshotFolder = "/tmp/";

	/** The scope. */
	protected IScope scope;

	/** The data. */
	private final LayeredDisplayData data;

	/**
	 * Instantiates a new image display surface.
	 *
	 * @param args
	 *            the args
	 */
	public ImageDisplaySurface(final Object... args) {
		output = (LayeredDisplayOutput) args[0];
		data = output.getData();

	}

	/**
	 * Output reloaded.
	 *
	 * @see gama.common.ui.IDisplaySurface#initialize(double, double, gama.outputs.IDisplayOutput)
	 */
	@Override
	public void outputReloaded() {
		this.scope = output.getScope().copy("in image surface of " + output.getName());
		if (!GamaPreferences.Runtime.ERRORS_IN_DISPLAYS.getValue()) { scope.disableErrorReporting(); }
		if (manager == null) {
			manager = new LayerManager(this, output);
		} else {
			manager.outputChanged();
		}

	}

	/**
	 * Gets the scope.
	 *
	 * @return the scope
	 */
	@Override
	public IScope getScope() { return scope; }

	/**
	 * Save this surface into an image passed as a parameter.
	 *
	 * @param image
	 *            the image
	 */
	public void save(final RenderedImage image) {
		try {
			Files.newFolder(scope, snapshotFolder);
		} catch (final GamaRuntimeException e1) {
			e1.addContext("Impossible to create folder " + snapshotFolder);
			GAMA.reportError(scope, e1, false);
			e1.printStackTrace();
			return;
		}

		final String file =
				snapshotFolder + "/" + GAMA.getModel().getName() + "_display_" + scope.getClock().getCycle() + ".png";
		// DataOutputStream os = null;
		try (DataOutputStream os = new DataOutputStream(new FileOutputStream(file))) {
			ImageIO.write(image, "png", os);
		} catch (final java.io.IOException ex) {
			final GamaRuntimeException e = GamaRuntimeException.create(ex, scope);
			e.addContext("Unable to create output stream for snapshot image");
			GAMA.reportError(getScope(), e, false);
		}
	}

	/**
	 * Gets the manager.
	 *
	 * @return the manager
	 */
	@Override
	public ILayerManager getManager() { return manager; }

	/**
	 * Resize image.
	 *
	 * @param newWidth
	 *            the new width
	 * @param newHeight
	 *            the new height
	 * @param force
	 *            the force
	 * @return true, if successful
	 */
	public boolean resizeImage(final int newWidth, final int newHeight, final boolean force) {
		if (!force && width == newWidth && height == newHeight) return false;
		this.width = newWidth;
		this.height = newHeight;
		final Image copy = buffImage;
		createBuffImage();
		if (getScope() != null && getScope().isPaused()) {
			updateDisplay(true);
		} else {
			g2.drawImage(copy, 0, 0, newWidth, newHeight, null);
		}
		if (copy != null) { copy.flush(); }
		return true;
	}

	/**
	 * Update display.
	 *
	 * @param force
	 *            the force
	 */
	@Override
	public void updateDisplay(final boolean force) {
		// if ( needsUpdate || force ) {
		drawAllDisplays();
		// }
	}

	/**
	 * Draw all displays.
	 */
	private void drawAllDisplays() {
		if (displayGraphics == null) return;
		displayGraphics.fillBackground(data.getBackgroundColor());
		manager.drawLayersOn(displayGraphics);
	}

	/**
	 * Creates the buff image.
	 */
	private void createBuffImage() {
		buffImage = ImageUtils.createCompatibleImage(width, height, false);
		g2 = (Graphics2D) buffImage.getGraphics();
		displayGraphics = new AWTDisplayGraphics((Graphics2D) buffImage.getGraphics());
		((AWTDisplayGraphics) displayGraphics).setGraphics2D((Graphics2D) buffImage.getGraphics());
		((AWTDisplayGraphics) displayGraphics).setUntranslatedGraphics2D((Graphics2D) buffImage.getGraphics());
		displayGraphics.setDisplaySurface(this);
	}

	/**
	 * Paint.
	 */
	private void paint() {
		if (buffImage == null) { createBuffImage(); }
		drawAllDisplays();

	}

	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {
		if (g2 != null) { g2.dispose(); }
		if (manager != null) { manager.dispose(); }
		GAMA.releaseScope(scope);
	}

	/**
	 * Gets the image.
	 *
	 * @param w
	 *            the w
	 * @param h
	 *            the h
	 * @return the image
	 */
	@Override
	public BufferedImage getImage(final int w, final int h) {
		paint();
		return ImageUtils.resize(buffImage, w, h);
	}

	/**
	 * Zoom in.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.gui.graphics.IDisplaySurface#zoomIn(msi.gama.gui.views. IGamaView)
	 */
	@Override
	public void zoomIn() {
		// TODO Auto-generated method stub

	}

	/**
	 * Zoom out.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.gui.graphics.IDisplaySurface#zoomOut(msi.gama.gui.views. IGamaView)
	 */
	@Override
	public void zoomOut() {
		// TODO Auto-generated method stub

	}

	/**
	 * Zoom fit.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.gui.graphics.IDisplaySurface#zoomFit(msi.gama.gui.views. IGamaView)
	 */
	@Override
	public void zoomFit() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.gui.graphics.IDisplaySurface#fireSelectionChanged(java.lang. Object)
	 */
	// @Override
	// public void fireSelectionChanged(final Object a) {
	// // TODO Auto-generated method stub
	//
	// }

	/**
	 * Focus on.
	 *
	 * @param geometry
	 *            the geometry
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.gui.graphics.IDisplaySurface#focusOn(msi.gama.util.GamaGeometry, msi.gama.gui.displays.IDisplay)
	 */
	@Override
	public void focusOn(final IShape geometry) {
		// TODO Auto-generated method stub

	}

	//
	// @Override
	// public void canBeUpdated(final boolean ok) {
	// needsUpdate = ok;
	// }

	/**
	 * Gets the width.
	 *
	 * @return the width
	 * @see gama.common.ui.IDisplaySurface#getWidth()
	 */
	@Override
	public int getWidth() { return width; }

	/**
	 * Gets the height.
	 *
	 * @return the height
	 * @see gama.common.ui.IDisplaySurface#getHeight()
	 */
	@Override
	public int getHeight() { return height; }

	// /**
	// * @see msi.gama.common.interfaces.IDisplaySurface#getImageWidth()
	// */
	// @Override
	// public int getImageWidth() {
	// return width;
	// }
	//
	// /**
	// * @see msi.gama.common.interfaces.IDisplaySurface#getImageHeight()
	// */
	// @Override
	// public int getImageHeight() {
	// return height;
	// }

	// /**
	// * @see msi.gama.common.interfaces.IDisplaySurface#getOriginX()
	// */
	// @Override
	// public int getOriginX() {
	// return 0;
	// }
	//
	// /**
	// * @see msi.gama.common.interfaces.IDisplaySurface#getOriginY()
	// */
	// @Override
	// public int getOriginY() {
	// return 0;
	// }

	/**
	 * Adds the listener.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void addListener(final IEventLayerListener e) {}

	/**
	 * Gets the env width.
	 *
	 * @return the env width
	 */
	@Override
	public double getEnvWidth() { return data.getEnvWidth(); }

	/**
	 * Gets the env height.
	 *
	 * @return the env height
	 */
	@Override
	public double getEnvHeight() { return data.getEnvHeight(); }

	/**
	 * Gets the display width.
	 *
	 * @return the display width
	 */
	@Override
	public double getDisplayWidth() { return width; }

	/**
	 * Gets the display height.
	 *
	 * @return the display height
	 */
	@Override
	public double getDisplayHeight() { return this.getHeight(); }

	// @Override
	// public void setZoomListener(final IZoomListener listener) {}
	//
	/**
	 * Method getModelCoordinates().
	 *
	 * @return the model coordinates
	 * @see gama.common.ui.IDisplaySurface#getModelCoordinates()
	 */
	@Override
	public GamaPoint getModelCoordinates() { return null; }

	/**
	 * Method followAgent().
	 *
	 * @param a
	 *            the a
	 * @see gama.common.ui.IDisplaySurface#followAgent(gama.metamodel.agent.IAgent)
	 */
	@Override
	public void followAgent(final IAgent a) {}

	/**
	 * Method getZoomLevel().
	 *
	 * @return the zoom level
	 * @see gama.common.ui.IDisplaySurface#getZoomLevel()
	 */
	@Override
	public double getZoomLevel() { return 1.0; }

	/**
	 * Method setSize().
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @see gama.common.ui.IDisplaySurface#setSize(int, int)
	 */
	@Override
	public void setSize(final int x, final int y) {
		resizeImage(x, y, false);
	}

	/**
	 * Method removeMouseListener().
	 *
	 * @param e
	 *            the e
	 * @see gama.common.ui.IDisplaySurface#removeMouseListener(java.awt.event.MouseListener)
	 */
	@Override
	public void removeListener(final IEventLayerListener e) {}

	/**
	 * Gets the layer listeners.
	 *
	 * @return the layer listeners
	 */
	@Override
	public Collection<IEventLayerListener> getLayerListeners() { return Collections.EMPTY_LIST; }

	/**
	 * Gets the model coordinates from.
	 *
	 * @param xOnScreen
	 *            the x on screen
	 * @param yOnScreen
	 *            the y on screen
	 * @param sizeInPixels
	 *            the size in pixels
	 * @param positionInPixels
	 *            the position in pixels
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
	 * Select agent.
	 *
	 * @param xc
	 *            the xc
	 * @param yc
	 *            the yc
	 * @return the i list
	 */
	@Override
	public IList<IAgent> selectAgent(final int xc, final int yc) {
		return GamaListFactory.EMPTY_LIST;
		// final IList<IAgent> result = GamaListFactory.create(Types.AGENT);
		// final List<ILayer> layers = getManager().getLayersIntersecting(xc,
		// yc);
		// for (final ILayer layer : layers) {
		// if (layer.isSelectable()) {
		// final Set<IAgent> agents = layer.collectAgentsAt(xc, yc, this);
		// if (!agents.isEmpty()) {
		// result.addAll(agents);
		// }
		// }
		// }
		// return result;
	}

	/**
	 * Method getOutput().
	 *
	 * @return the output
	 * @see gama.common.ui.IDisplaySurface#getOutput()
	 */
	@Override
	public LayeredDisplayOutput getOutput() { return output; }

	/**
	 * Method waitForUpdateAndRun().
	 *
	 * @param r
	 *            the r
	 * @see gama.common.ui.IDisplaySurface#waitForUpdateAndRun(java.lang.Runnable)
	 */
	@Override
	public void runAndUpdate(final Runnable r) {
		r.run();
	}

	/**
	 * Method getData().
	 *
	 * @return the data
	 * @see gama.common.ui.IDisplaySurface#getData()
	 */
	@Override
	public LayeredDisplayData getData() { return data; }

	/**
	 * Method setSWTMenuManager().
	 *
	 * @see msi.gama.common.interfaces.IDisplaySurface#setSWTMenuManager(java.lang.Object)
	 */
	// @Override
	// public void setSWTMenuManager(final Object displaySurfaceMenu) {
	// }

	/**
	 * Method layersChanged()
	 *
	 * @see gama.common.ui.IDisplaySurface#layersChanged()
	 */
	@Override
	public void layersChanged() {}

	/**
	 * Method changed().
	 *
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 * @see gama.outputs.LayeredDisplayData.DisplayDataListener#changed(gama.outputs.LayeredDisplayData.Changes,
	 *      boolean)
	 */
	@Override
	public void changed(final Changes property, final Object value) {}

	/**
	 * Method getVisibleRegionForLayer().
	 *
	 * @param currentLayer
	 *            the current layer
	 * @return the visible region for layer
	 * @see gama.common.ui.IDisplaySurface#getVisibleRegionForLayer(gama.common.ui.ILayer)
	 */
	@Override
	public Envelope getVisibleRegionForLayer(final ILayer currentLayer) {
		return null;
	}

	/**
	 * Method getFPS().
	 *
	 * @return the fps
	 * @see gama.common.ui.IDisplaySurface#getFPS()
	 */
	@Override
	public int getFPS() { return 0; }

	/**
	 * Method isRendered().
	 *
	 * @return true, if is rendered
	 * @see gama.common.ui.IDisplaySurface#isRendered()
	 */
	@Override
	public boolean isRendered() { return true; }

	/**
	 * Checks if is disposed.
	 *
	 * @return true, if is disposed
	 */
	@Override
	public boolean isDisposed() { return false; }

	/**
	 * Gets the model coordinates info.
	 *
	 * @param sb
	 *            the sb
	 * @return the model coordinates info
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.common.interfaces.IDisplaySurface#getModelCoordinatesInfo()
	 */
	@Override
	public void getModelCoordinatesInfo(final StringBuilder sb) {}

	/**
	 * Dispatch key event.
	 *
	 * @param character
	 *            the character
	 */
	@Override
	public void dispatchKeyEvent(final char character) {}

	/**
	 * Dispatch mouse event.
	 *
	 * @param swtEventType
	 *            the swt event type
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	@Override
	public void dispatchMouseEvent(final int swtEventType, final int x, final int y) {}

	/**
	 * Sets the mouse position.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	@Override
	public void setMousePosition(final int x, final int y) {}

	/**
	 * Dragged to.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	@Override
	public void draggedTo(final int x, final int y) {}

	/**
	 * Select agents around mouse.
	 */
	@Override
	public void selectAgentsAroundMouse() {}

	/**
	 * Sets the menu manager.
	 *
	 * @param displaySurfaceMenu
	 *            the new menu manager
	 */
	@Override
	public void setMenuManager(final Object displaySurfaceMenu) {}

}