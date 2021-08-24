/*******************************************************************************************************
 *
 * NullDisplaySurface.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
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
import gama.outputs.LayeredDisplayOutput;
import gama.outputs.LayeredDisplayData.Changes;
import gama.outputs.layers.IEventLayerListener;
import gama.runtime.IScope;
import gama.util.IList;

/**
 * Class NullDisplaySurface.
 *
 * @author drogoul
 * @since 26 mars 2014
 *
 */
public class NullDisplaySurface implements IDisplaySurface {

	/**
	 * Method getImage()
	 *
	 * @see gama.common.ui.IDisplaySurface#getImage()
	 */
	@Override
	public BufferedImage getImage(final int w, final int h) {
		return null;
	}

	@Override
	public IScope getScope() {
		return null;
	}

	/**
	 * Method dispose()
	 *
	 * @see gama.common.ui.IDisplaySurface#dispose()
	 */
	@Override
	public void dispose() {}

	/**
	 * Method updateDisplay()
	 *
	 * @see gama.common.ui.IDisplaySurface#updateDisplay()
	 */
	@Override
	public void updateDisplay(final boolean force) {}

	/**
	 * Method zoomIn()
	 *
	 * @see gama.common.ui.IDisplaySurface#zoomIn()
	 */
	@Override
	public void zoomIn() {}

	/**
	 * Method zoomOut()
	 *
	 * @see gama.common.ui.IDisplaySurface#zoomOut()
	 */
	@Override
	public void zoomOut() {}

	/**
	 * Method zoomFit()
	 *
	 * @see gama.common.ui.IDisplaySurface#zoomFit()
	 */
	@Override
	public void zoomFit() {}

	/**
	 * Method getManager()
	 *
	 * @see gama.common.ui.IDisplaySurface#getManager()
	 */
	@Override
	public ILayerManager getManager() {
		return null;
	}

	/**
	 * Method focusOn()
	 *
	 * @see gama.common.ui.IDisplaySurface#focusOn(gama.metamodel.shape.IShape)
	 */
	@Override
	public void focusOn(final IShape geometry) {}

	/**
	 * Method getWidth()
	 *
	 * @see gama.common.ui.IDisplaySurface#getWidth()
	 */
	@Override
	public int getWidth() {
		return 0;
	}

	/**
	 * Method getHeight()
	 *
	 * @see gama.common.ui.IDisplaySurface#getHeight()
	 */
	@Override
	public int getHeight() {
		return 0;
	}

	/**
	 * Method initialize()
	 *
	 * @see gama.common.ui.IDisplaySurface#initialize(double, double, gama.outputs.LayeredDisplayOutput)
	 */
	@Override
	public void outputReloaded() {}

	/**
	 * Method addMouseListener()
	 *
	 * @see gama.common.ui.IDisplaySurface#addMouseListener(java.awt.event.MouseListener)
	 */
	@Override
	public void addListener(final IEventLayerListener e) {}

	/**
	 * Method removeMouseListener()
	 *
	 * @see gama.common.ui.IDisplaySurface#removeMouseListener(java.awt.event.MouseListener)
	 */
	@Override
	public void removeListener(final IEventLayerListener e) {}

	/**
	 * Method getEnvWidth()
	 *
	 * @see gama.common.ui.IDisplaySurface#getEnvWidth()
	 */
	@Override
	public double getEnvWidth() {
		return 0;
	}

	/**
	 * Method getEnvHeight()
	 *
	 * @see gama.common.ui.IDisplaySurface#getEnvHeight()
	 */
	@Override
	public double getEnvHeight() {
		return 0;
	}

	/**
	 * Method getDisplayWidth()
	 *
	 * @see gama.common.ui.IDisplaySurface#getDisplayWidth()
	 */
	@Override
	public double getDisplayWidth() {
		return 0;
	}

	/**
	 * Method getDisplayHeight()
	 *
	 * @see gama.common.ui.IDisplaySurface#getDisplayHeight()
	 */
	@Override
	public double getDisplayHeight() {
		return 0;
	}

	/**
	 * Method setZoomListener()
	 *
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
	public GamaPoint getModelCoordinates() {
		return new GamaPoint();
	}

	/**
	 * Method getModelCoordinatesFrom()
	 *
	 * @see gama.common.ui.IDisplaySurface#getModelCoordinatesFrom(int, int, java.awt.Point, java.awt.Point)
	 */
	@Override
	public GamaPoint getModelCoordinatesFrom(final int xOnScreen, final int yOnScreen, final Point sizeInPixels,
			final Point positionInPixels) {
		return new GamaPoint();
	}

	/**
	 * Method selectAgent()
	 *
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
	 * Method followAgent()
	 *
	 * @see gama.common.ui.IDisplaySurface#followAgent(gama.metamodel.agent.IAgent)
	 */
	@Override
	public void followAgent(final IAgent a) {}

	/**
	 * Method getZoomLevel()
	 *
	 * @see gama.common.ui.IDisplaySurface#getZoomLevel()
	 */
	@Override
	public double getZoomLevel() {
		return 0;
	}

	/**
	 * Method setSize()
	 *
	 * @see gama.common.ui.IDisplaySurface#setSize(int, int)
	 */
	@Override
	public void setSize(final int x, final int y) {}

	/**
	 * Method getOutput()
	 *
	 * @see gama.common.ui.IDisplaySurface#getOutput()
	 */
	@Override
	public LayeredDisplayOutput getOutput() {
		return null;
	}

	/**
	 * Method waitForUpdateAndRun()
	 *
	 * @see gama.common.ui.IDisplaySurface#waitForUpdateAndRun(java.lang.Runnable)
	 */
	@Override
	public void runAndUpdate(final Runnable r) {}

	/**
	 * Method getData()
	 *
	 * @see gama.common.ui.IDisplaySurface#getData()
	 */
	@Override
	public LayeredDisplayData getData() {
		return null;
	}

	/**
	 * Method setSWTMenuManager()
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
	 * Method changed()
	 *
	 * @see gama.outputs.LayeredDisplayData.DisplayDataListener#changed(gama.outputs.LayeredDisplayData.Changes,
	 *      boolean)
	 */
	@Override
	public void changed(final Changes property, final Object value) {}

	@Override
	public Collection<IEventLayerListener> getLayerListeners() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Method getVisibleRegionForLayer()
	 *
	 * @see gama.common.ui.IDisplaySurface#getVisibleRegionForLayer(gama.common.ui.ILayer)
	 */
	@Override
	public Envelope getVisibleRegionForLayer(final ILayer currentLayer) {
		return null;
	}

	/**
	 * Method getFPS()
	 *
	 * @see gama.common.ui.IDisplaySurface#getFPS()
	 */
	@Override
	public int getFPS() {
		return 0;
	}
	//
	// @Override
	// public boolean isRealized() {
	// return true;
	// }

	/**
	 * Method isRendered()
	 *
	 * @see gama.common.ui.IDisplaySurface#isRendered()
	 */
	@Override
	public boolean isRendered() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.common.interfaces.IDisplaySurface#isDisposed()
	 */
	@Override
	public boolean isDisposed() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.common.interfaces.IDisplaySurface#getModelCoordinatesInfo()
	 */
	@Override
	public void getModelCoordinatesInfo(final StringBuilder sb) {}

	@Override
	public void dispatchKeyEvent(final char character) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispatchMouseEvent(final int swtEventType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMousePosition(final int x, final int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectAgentsAroundMouse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draggedTo(final int x, final int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMenuManager(final Object displaySurfaceMenu) {
		// TODO Auto-generated method stub

	}

}
