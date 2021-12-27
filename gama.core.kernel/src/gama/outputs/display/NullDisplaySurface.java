/*******************************************************************************************************
 *
 * NullDisplaySurface.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.outputs.display;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.Collections;

import org.locationtech.jts.geom.Envelope;

import gama.common.ui.IDisplaySurface;
import gama.common.ui.ILayer;
import gama.common.ui.ILayerManager;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.outputs.LayeredDisplayData;
import gama.outputs.LayeredDisplayData.Changes;
import gama.outputs.LayeredDisplayOutput;
import gama.outputs.layers.IEventLayerListener;
import gama.runtime.IScope;
import gama.util.IList;

// TODO: Auto-generated Javadoc
/**
 * Class NullDisplaySurface.
 *
 * @author drogoul
 * @since 26 mars 2014
 *
 */
public class NullDisplaySurface implements IDisplaySurface {

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
		return null;
	}

	/**
	 * Gets the scope.
	 *
	 * @return the scope
	 */
	@Override
	public IScope getScope() { return null; }

	/**
	 * Method dispose().
	 *
	 * @see gama.common.ui.IDisplaySurface#dispose()
	 */
	@Override
	public void dispose() {}

	/**
	 * Method updateDisplay().
	 *
	 * @param force the force
	 * @see gama.common.ui.IDisplaySurface#updateDisplay()
	 */
	@Override
	public void updateDisplay(final boolean force) {}

	/**
	 * Method zoomIn().
	 *
	 * @see gama.common.ui.IDisplaySurface#zoomIn()
	 */
	@Override
	public void zoomIn() {}

	/**
	 * Method zoomOut().
	 *
	 * @see gama.common.ui.IDisplaySurface#zoomOut()
	 */
	@Override
	public void zoomOut() {}

	/**
	 * Method zoomFit().
	 *
	 * @see gama.common.ui.IDisplaySurface#zoomFit()
	 */
	@Override
	public void zoomFit() {}

	/**
	 * Method getManager().
	 *
	 * @return the manager
	 * @see gama.common.ui.IDisplaySurface#getManager()
	 */
	@Override
	public ILayerManager getManager() { return null; }

	/**
	 * Method focusOn().
	 *
	 * @param geometry the geometry
	 * @see gama.common.ui.IDisplaySurface#focusOn(gama.metamodel.shape.IShape)
	 */
	@Override
	public void focusOn(final IShape geometry) {}

	/**
	 * Method getWidth().
	 *
	 * @return the width
	 * @see gama.common.ui.IDisplaySurface#getWidth()
	 */
	@Override
	public int getWidth() { return 0; }

	/**
	 * Method getHeight().
	 *
	 * @return the height
	 * @see gama.common.ui.IDisplaySurface#getHeight()
	 */
	@Override
	public int getHeight() { return 0; }

	/**
	 * Method initialize().
	 *
	 * @see gama.common.ui.IDisplaySurface#initialize(double, double, gama.outputs.LayeredDisplayOutput)
	 */
	@Override
	public void outputReloaded() {}

	/**
	 * Method addMouseListener().
	 *
	 * @param e the e
	 * @see gama.common.ui.IDisplaySurface#addMouseListener(java.awt.event.MouseListener)
	 */
	@Override
	public void addListener(final IEventLayerListener e) {}

	/**
	 * Method removeMouseListener().
	 *
	 * @param e the e
	 * @see gama.common.ui.IDisplaySurface#removeMouseListener(java.awt.event.MouseListener)
	 */
	@Override
	public void removeListener(final IEventLayerListener e) {}

	/**
	 * Method getEnvWidth().
	 *
	 * @return the env width
	 * @see gama.common.ui.IDisplaySurface#getEnvWidth()
	 */
	@Override
	public double getEnvWidth() { return 0; }

	/**
	 * Method getEnvHeight().
	 *
	 * @return the env height
	 * @see gama.common.ui.IDisplaySurface#getEnvHeight()
	 */
	@Override
	public double getEnvHeight() { return 0; }

	/**
	 * Method getDisplayWidth().
	 *
	 * @return the display width
	 * @see gama.common.ui.IDisplaySurface#getDisplayWidth()
	 */
	@Override
	public double getDisplayWidth() { return 0; }

	/**
	 * Method getDisplayHeight().
	 *
	 * @return the display height
	 * @see gama.common.ui.IDisplaySurface#getDisplayHeight()
	 */
	@Override
	public double getDisplayHeight() { return 0; }

	/**
	 * Method setZoomListener().
	 *
	 * @return the model coordinates
	 * @see msi.gama.common.interfaces.IDisplaySurface#setZoomListener(msi.gama.common.interfaces.IDisplaySurface.IZoomListener)
	 */
	// @Override
	// public void setZoomListener(final IZoomListener listener) {}

	/**
	 * Method getModelCoordinates()
	 *
	 * @see gama.common.ui.IDisplaySurface#getModelCoordinates()
	 */
	@Override
	public GamaPoint getModelCoordinates() { return new GamaPoint(); }

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
		return new GamaPoint();
	}

	/**
	 * Method selectAgent().
	 *
	 * @param x the x
	 * @param y the y
	 * @return the i list
	 * @see gama.common.ui.IDisplaySurface#selectAgent(int, int)
	 */
	@Override
	public IList<IAgent> selectAgent(final int x, final int y) {
		return null;
	}

	// /**
	// * Method isSynchronized()
	// * @see msi.gama.common.interfaces.IDisplaySurface#isSynchronized()
	// */
	// @Override
	// public boolean isSynchronized() {
	// return false;
	// }

	/**
	 * Method followAgent().
	 *
	 * @param a the a
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
	public double getZoomLevel() { return 0; }

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
	 * Method getOutput().
	 *
	 * @return the output
	 * @see gama.common.ui.IDisplaySurface#getOutput()
	 */
	@Override
	public LayeredDisplayOutput getOutput() { return null; }

	/**
	 * Method waitForUpdateAndRun().
	 *
	 * @param r the r
	 * @see gama.common.ui.IDisplaySurface#waitForUpdateAndRun(java.lang.Runnable)
	 */
	@Override
	public void runAndUpdate(final Runnable r) {}

	/**
	 * Method getData().
	 *
	 * @return the data
	 * @see gama.common.ui.IDisplaySurface#getData()
	 */
	@Override
	public LayeredDisplayData getData() { return null; }

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
	 * @param property the property
	 * @param value the value
	 * @see gama.outputs.LayeredDisplayData.DisplayDataListener#changed(gama.outputs.LayeredDisplayData.Changes,
	 *      boolean)
	 */
	@Override
	public void changed(final Changes property, final Object value) {}

	/**
	 * Gets the layer listeners.
	 *
	 * @return the layer listeners
	 */
	@Override
	public Collection<IEventLayerListener> getLayerListeners() { return Collections.EMPTY_LIST; }

	/**
	 * Method getVisibleRegionForLayer().
	 *
	 * @param currentLayer the current layer
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
	//
	// @Override
	// public boolean isRealized() {
	// return true;
	// }

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
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.common.interfaces.IDisplaySurface#isDisposed()
	 */
	@Override
	public boolean isDisposed() { return false; }

	/**
	 * Gets the model coordinates info.
	 *
	 * @param sb the sb
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
	 * @param character the character
	 */
	@Override
	public void dispatchKeyEvent(final char character) {}

	/**
	 * Dispatch mouse event.
	 *
	 * @param swtEventType the swt event type
	 * @param x the x
	 * @param y the y
	 */
	@Override
	public void dispatchMouseEvent(final int swtEventType, final int x, final int y) {}

	/**
	 * Sets the mouse position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	@Override
	public void setMousePosition(final int x, final int y) {}

	/**
	 * Select agents around mouse.
	 */
	@Override
	public void selectAgentsAroundMouse() {}

	/**
	 * Dragged to.
	 *
	 * @param x the x
	 * @param y the y
	 */
	@Override
	public void draggedTo(final int x, final int y) {}

	/**
	 * Sets the menu manager.
	 *
	 * @param displaySurfaceMenu the new menu manager
	 */
	@Override
	public void setMenuManager(final Object displaySurfaceMenu) {}

}
