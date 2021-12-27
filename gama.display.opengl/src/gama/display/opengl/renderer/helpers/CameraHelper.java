/*
 *
 */
package gama.display.opengl.renderer.helpers;

/*******************************************************************************************************
 *
 * CameraHelper.java, in ummisco.gama.opengl, is part of the source code of the GAMA modeling and simulation platform
 * (v.1.8.2).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;

import gama.common.geometry.Envelope3D;
import gama.display.opengl.camera.CameraArcBall;
import gama.display.opengl.camera.FreeFlyCamera;
import gama.display.opengl.camera.ICamera;
import gama.display.opengl.renderer.IOpenGLRenderer;
import gama.metamodel.shape.GamaPoint;

// TODO: Auto-generated Javadoc
/**
 * The Class CameraHelper.
 */
public class CameraHelper extends AbstractRendererHelper implements ICamera {

	/** The Constant UNDEFINED. */
	public final static GamaPoint UNDEFINED = new GamaPoint();

	/** The Constant NULL_POINT. */
	public final static GamaPoint NULL_POINT = new GamaPoint();

	/** The presets. */
	public static Map<String, CameraPreset> PRESETS = new LinkedHashMap<>();

	/** The camera. */
	ICamera camera;

	static {
		PRESETS.put("Choose...", c -> {});
		PRESETS.put("From top", c -> {
			c.setPosition(c.getTarget().x, c.getTarget().y, c.getRenderer().getMaxEnvDim() * c.getInitialZFactor());
			c.setUpVector(0, 1, 0);
		});
		PRESETS.put("From left", c -> {
			c.setPosition(c.getTarget().x - c.getRenderer().getEnvWidth() * c.getInitialZFactor(), c.getTarget().y, 0);
			c.setUpVector(0, 0, 1);
		});
		PRESETS.put("From up left", c -> {
			c.setPosition(c.getTarget().x - c.getRenderer().getEnvWidth() * c.getInitialZFactor(), c.getTarget().y,
					c.getRenderer().getMaxEnvDim() * c.getInitialZFactor());
			c.setUpVector(0, 0, 1);
		});
		PRESETS.put("From right", c -> {
			c.setPosition(c.getTarget().x + c.getRenderer().getEnvWidth() * c.getInitialZFactor(), c.getTarget().y, 0);
			c.setUpVector(0, 0, 1);
		});
		PRESETS.put("From up right", c -> {
			c.setPosition(c.getTarget().x + c.getRenderer().getEnvWidth() * c.getInitialZFactor(), c.getTarget().y,
					c.getRenderer().getMaxEnvDim() * c.getInitialZFactor());
			c.setUpVector(0, 0, 1);
		});
		PRESETS.put("From front", c -> {
			c.setPosition(c.getTarget().x, c.getTarget().y - c.getRenderer().getEnvHeight() * c.getInitialZFactor(), 0);
			c.setUpVector(0, 0, 1);
		});
		PRESETS.put("From up front", c -> {
			c.setPosition(c.getTarget().x, c.getTarget().y - c.getRenderer().getEnvHeight() * c.getInitialZFactor(),
					c.getRenderer().getMaxEnvDim() * c.getInitialZFactor());
			c.setUpVector(0, 0, 1);
		});

	}

	/**
	 * Instantiates a new camera helper.
	 *
	 * @param renderer
	 *            the renderer
	 */
	public CameraHelper(final IOpenGLRenderer renderer) {
		super(renderer);
	}

	/**
	 * Setup camera.
	 */
	public final void setupCamera() {
		if (!getData().isArcBallCamera()) {
			camera = new FreeFlyCamera(getRenderer());
		} else {
			camera = new CameraArcBall(getRenderer());
		}
		camera.initialize();
		camera.update();

	}

	/**
	 * Apply preset.
	 *
	 * @param value
	 *            the value
	 */
	@Override
	public void applyPreset(final String value) {
		if (camera != null) { camera.applyPreset(value); }
	}

	/**
	 * Update position.
	 */
	@Override
	public void updatePosition() {
		if (camera != null) { camera.updatePosition(); }
	}

	/**
	 * Update orientation.
	 */
	@Override
	public void updateOrientation() {
		if (camera != null) { camera.updateOrientation(); }
	}

	/**
	 * Update target.
	 */
	@Override
	public void updateTarget() {
		if (camera != null) { camera.updateTarget(); }
	}

	/**
	 * Zoom.
	 *
	 * @param value
	 *            the value
	 */
	@Override
	public void zoom(final double value) {
		if (camera != null) { camera.zoom(value); }
	}

	/**
	 * Update.
	 */
	@Override
	public void update() {
		if (camera != null) { camera.update(); }
	}

	/**
	 * Key pressed.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void keyPressed(final KeyEvent e) {
		if (camera != null) { camera.keyPressed(e); }
	}

	/**
	 * Key released.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void keyReleased(final KeyEvent e) {
		if (camera != null) { camera.keyReleased(e); }
	}

	/**
	 * Mouse double click.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseDoubleClick(final MouseEvent e) {
		if (camera != null) { camera.mouseDoubleClick(e); }

	}

	/**
	 * Mouse down.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseDown(final MouseEvent e) {
		if (camera != null) { camera.mouseDown(e); }

	}

	/**
	 * Mouse up.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseUp(final MouseEvent e) {
		if (camera != null) { camera.mouseUp(e); }
	}

	/**
	 * Mouse move.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseMove(final MouseEvent e) {
		if (camera != null) { camera.mouseMove(e); }

	}

	/**
	 * Mouse enter.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseEnter(final MouseEvent e) {
		if (camera != null) { camera.mouseEnter(e); }

	}

	/**
	 * Mouse exit.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseExit(final MouseEvent e) {
		if (camera != null) { camera.mouseExit(e); }

	}

	/**
	 * Mouse hover.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseHover(final MouseEvent e) {
		if (camera != null) { camera.mouseHover(e); }

	}

	/**
	 * Mouse scrolled.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseScrolled(final MouseEvent e) {
		if (camera != null) { camera.mouseScrolled(e); }

	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	@Override
	public GamaPoint getPosition() {
		if (camera != null) return camera.getPosition();
		return UNDEFINED;
	}

	/**
	 * Gets the orientation.
	 *
	 * @return the orientation
	 */
	@Override
	public GamaPoint getOrientation() {
		if (camera != null) return camera.getOrientation();
		return UNDEFINED;
	}

	/**
	 * Gets the target.
	 *
	 * @return the target
	 */
	@Override
	public GamaPoint getTarget() {
		if (camera != null) return camera.getTarget();
		return UNDEFINED;
	}

	/**
	 * Gets the mouse position.
	 *
	 * @return the mouse position
	 */
	@Override
	public GamaPoint getMousePosition() {
		if (camera != null) return camera.getMousePosition();
		return NULL_POINT;
	}

	/**
	 * Gets the last mouse pressed position.
	 *
	 * @return the last mouse pressed position
	 */
	@Override
	public GamaPoint getLastMousePressedPosition() {
		if (camera != null) return camera.getLastMousePressedPosition();
		return NULL_POINT;
	}

	/**
	 * Hook.
	 */
	public void hook() {
		getCanvas().addCameraListeners(this);
	}

	/**
	 * Initialize.
	 */
	@Override
	public void initialize() {
		if (camera != null) {
			camera.initialize();
		} else {
			setupCamera();
		}
	}

	/**
	 * Animate.
	 */
	@Override
	public void animate() {
		if (camera != null) { camera.animate(); }

	}

	/**
	 * Zoom level.
	 *
	 * @return the double
	 */
	@Override
	public Double zoomLevel() {
		if (camera != null) return camera.zoomLevel();
		return 1d;
	}

	/**
	 * Zoom.
	 *
	 * @param in
	 *            the in
	 */
	@Override
	public void zoom(final boolean in) {
		if (camera != null) { camera.zoom(in); }

	}

	/**
	 * Zoom focus.
	 *
	 * @param env
	 *            the env
	 */
	@Override
	public void zoomFocus(final Envelope3D env) {
		if (camera != null) { camera.zoomFocus(env); }
	}

	/**
	 * Sets the position.
	 *
	 * @param x
	 *            the x
	 * @param d
	 *            the d
	 * @param e
	 *            the e
	 */
	@Override
	public void setPosition(final double x, final double d, final double e) {
		if (camera != null) { camera.setPosition(x, d, e); }
	}

	/**
	 * Sets the up vector.
	 *
	 * @param i
	 *            the i
	 * @param j
	 *            the j
	 * @param k
	 *            the k
	 */
	@Override
	public void setUpVector(final double i, final double j, final double k) {
		if (camera != null) { camera.setUpVector(i, j, k); }

	}

	/**
	 * Gets the distance.
	 *
	 * @return the distance
	 */
	@Override
	public double getDistance() {
		if (camera != null) return camera.getDistance();
		return 0d;
	}

	/**
	 * Dispose.
	 */
	public void dispose() {
		getCanvas().removeCameraListeners(this);
		camera = null;
	}

	/**
	 * Sets the initial Z factor corrector.
	 *
	 * @param factor
	 *            the new initial Z factor corrector
	 */
	@Override
	public void setInitialZFactorCorrector(final double factor) {
		if (camera != null) { camera.setInitialZFactorCorrector(factor); }

	}

	/**
	 * Sets the distance.
	 *
	 * @param distance
	 *            the new distance
	 */
	@Override
	public void setDistance(final double distance) {
		if (camera != null) { camera.setDistance(distance); }
	}

	/**
	 * Update cartesian coordinates from angles.
	 */
	@Override
	public void updateCartesianCoordinatesFromAngles() {
		if (camera != null) { camera.updateCartesianCoordinatesFromAngles(); }
	}

	/**
	 * Mouse clicked.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseClicked(final com.jogamp.newt.event.MouseEvent e) {
		if (camera != null) { camera.mouseClicked(e); }
	}

	/**
	 * Mouse entered.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseEntered(final com.jogamp.newt.event.MouseEvent e) {
		if (camera != null) { camera.mouseEntered(e); }
	}

	/**
	 * Mouse exited.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseExited(final com.jogamp.newt.event.MouseEvent e) {
		if (camera != null) { camera.mouseExited(e); }
	}

	/**
	 * Mouse pressed.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mousePressed(final com.jogamp.newt.event.MouseEvent e) {
		if (camera != null) { camera.mousePressed(e); }
	}

	/**
	 * Mouse released.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseReleased(final com.jogamp.newt.event.MouseEvent e) {
		if (camera != null) { camera.mouseReleased(e); }
	}

	/**
	 * Mouse moved.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseMoved(final com.jogamp.newt.event.MouseEvent e) {
		if (camera != null) { camera.mouseMoved(e); }
	}

	/**
	 * Mouse dragged.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseDragged(final com.jogamp.newt.event.MouseEvent e) {
		if (camera != null) { camera.mouseDragged(e); }
	}

	/**
	 * Mouse wheel moved.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseWheelMoved(final com.jogamp.newt.event.MouseEvent e) {
		if (camera != null) { camera.mouseWheelMoved(e); }
	}

	/**
	 * Key pressed.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void keyPressed(final com.jogamp.newt.event.KeyEvent e) {
		if (camera != null) { camera.keyPressed(e); }
	}

	/**
	 * Key released.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void keyReleased(final com.jogamp.newt.event.KeyEvent e) {
		if (camera != null) { camera.keyReleased(e); }
	}

}