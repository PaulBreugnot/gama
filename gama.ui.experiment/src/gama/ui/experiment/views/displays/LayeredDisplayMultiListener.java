/*******************************************************************************************************
 *
 * LayeredDisplayMultiListener.java, in gama.ui.experiment, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.experiment.views.displays;

import java.util.function.Consumer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;

import gama.common.ui.IDisplaySurface;
import gama.runtime.GAMA;
import gama.ui.base.utils.PlatformHelper;
import gama.ui.base.utils.WorkbenchHelper;
import gama.ui.base.views.WorkaroundForIssue1353;

/**
 * The listener interface for receiving layeredDisplayMulti events.
 * The class that is interested in processing a layeredDisplayMulti
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addLayeredDisplayMultiListener<code> method. When
 * the layeredDisplayMulti event occurs, that object's appropriate
 * method is invoked.
 *
 * @see LayeredDisplayMultiEvent
 */
public class LayeredDisplayMultiListener {

	/** The view. */
	private final LayeredDisplayDecorator view;
	
	/** The surface. */
	private final IDisplaySurface surface;
	
	/** The mouse is down. */
	volatile boolean mouseIsDown;
	
	/** The in menu. */
	volatile boolean inMenu;
	
	/** The last enter time. */
	volatile long lastEnterTime;
	
	/** The last enter position. */
	volatile Point lastEnterPosition = new Point(0, 0);
	
	/** The suppress next enter. */
	volatile boolean suppressNextEnter;
	
	/** The key listener. */
	final Consumer<Integer> keyListener;

	/**
	 * Instantiates a new layered display multi listener.
	 *
	 * @param surface the surface
	 * @param deco the deco
	 */
	public LayeredDisplayMultiListener(final IDisplaySurface surface, final LayeredDisplayDecorator deco) {
		this.view = deco;
		this.surface = surface;

		keyListener = (keyCode) -> {
			switch (keyCode.intValue()) {
				case 'o':
					deco.toggleOverlay();
					break;
				case 'l':
					deco.toggleSideControls();
					break;
				case 'k':
					if (deco.isFullScreen()) {
						deco.toggleInteractiveConsole();
					}
					break;
				case 't':
					deco.toggleToolbar();
			}
		};
	}

	/**
	 * Key pressed.
	 *
	 * @param e the e
	 */
	public void keyPressed(final char e) {
		surface.dispatchKeyEvent(e);
		WorkbenchHelper.asyncRun(view.displayOverlay);
	}

	/**
	 * Key released.
	 *
	 * @param e the e
	 * @param command the command
	 */
	public void keyReleased(final int e, final boolean command) {
		if (!command) { return; }
		keyListener.accept(e);
	}

	/**
	 * Mouse enter.
	 *
	 * @param x the x
	 * @param y the y
	 * @param modifier the modifier
	 * @param button the button
	 */
	public void mouseEnter(final int x, final int y, final boolean modifier, final int button) {
		if (suppressNextEnter) {
			// DEBUG.LOG("One mouse enter suppressed");
			suppressNextEnter = false;
			return;
		}
		if (modifier) { return; }

		setMousePosition(x, y);
		if (button > 0) { return; }
		final long currentTime = System.currentTimeMillis();
		if (currentTime - lastEnterTime < 100 && lastEnterPosition.x == x && lastEnterPosition.y == y) { return; }
		lastEnterTime = System.currentTimeMillis();
		lastEnterPosition = new Point(x, y);
		// DEBUG.LOG("Mouse entering " + e);
		surface.dispatchMouseEvent(SWT.MouseEnter);
	}

	/**
	 * Mouse exit.
	 *
	 * @param x the x
	 * @param y the y
	 * @param modifier the modifier
	 * @param button the button
	 */
	public void mouseExit(final int x, final int y, final boolean modifier, final int button) {
		final long currentTime = System.currentTimeMillis();
		if (currentTime - lastEnterTime < 100 && lastEnterPosition.x == x && lastEnterPosition.y == y) { return; }
		setMousePosition(-1, -1);
		if (button > 0) { return; }
		// DEBUG.LOG("Mouse exiting " + e);
		surface.dispatchMouseEvent(SWT.MouseExit);
		if (!view.isFullScreen() && WorkaroundForIssue1353.isInstalled()) {
			// suppressNextEnter = true;
			// DEBUG.LOG("Invoking WorkaroundForIssue1353");
			WorkaroundForIssue1353.showShell();
		}

	}

	/**
	 * Mouse hover.
	 *
	 * @param button the button
	 */
	public void mouseHover(final int button) {
		if (button > 0) { return; }
		// DEBUG.LOG("Mouse hovering on " + view.getPartName());
		surface.dispatchMouseEvent(SWT.MouseHover);
	}

	/**
	 * Mouse move.
	 *
	 * @param x the x
	 * @param y the y
	 * @param modifier the modifier
	 */
	public void mouseMove(final int x, final int y, final boolean modifier) {
		WorkbenchHelper.asyncRun(view.displayOverlay);
		if (modifier) {
			return;
			// DEBUG.LOG("Mouse moving on " + view.getPartName());
		}

		if (mouseIsDown) {
			surface.draggedTo(x, y);
			surface.dispatchMouseEvent(SWT.DragDetect);
		} else {
			setMousePosition(x, y);
			surface.dispatchMouseEvent(SWT.MouseMove);
		}

	}

	/**
	 * Mouse down event fired.
	 *
	 * @param x            the x coordinate relative to the display (in pixels, not model coordinates)
	 * @param y            the y coordinate relative to the display (in pixels, not model coordinates)
	 * @param button            the button clicked (1 for left, 2 for middle, 3 for right)
	 * @param modifier            whetehr ALT, CTRL, CMD, META or other modifiers are used
	 */
	public void mouseDown(final int x, final int y, final int button, final boolean modifier) {
		setMousePosition(x, y);
		if (inMenu) {
			inMenu = false;
			return;
		}
		if (modifier) { return; }
		if (PlatformHelper.isWindows() && button == 3) {
			// see Issue #2756: Windows emits the mouseDown(...) event *before* the menuDetected(..) one.
			// No need to patch mouseUp(...) right now
			return;
		}
		mouseIsDown = true;
		// DEBUG.LOG("Mouse down on " + view.getPartName());
		surface.dispatchMouseEvent(SWT.MouseDown);
	}

	/**
	 * Mouse up event fired.
	 *
	 * @param x            the x coordinate relative to the display (in pixels, not model coordinates)
	 * @param y            the y coordinate relative to the display (in pixels, not model coordinates)
	 * @param button            the button clicked (1 for left, 2 for middle, 3 for right)
	 * @param modifier            whetehr ALT, CTRL, CMD, META or other modifiers are used
	 */
	public void mouseUp(final int x, final int y, final int button, final boolean modifier) {
		// In case the mouse has moved (for example on a menu)
		if (!mouseIsDown) { return; }
		setMousePosition(x, y);
		if (modifier) { return; }
		mouseIsDown = false;
		// DEBUG.LOG("Mouse up on " + view.getPartName());
		if (!view.isFullScreen() && WorkaroundForIssue1353.isInstalled()) {
			WorkaroundForIssue1353.showShell();
		}
		surface.dispatchMouseEvent(SWT.MouseUp);
	}

	/**
	 * Menu detected.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void menuDetected(final int x, final int y) {
		if (inMenu) { return; }
		// DEBUG.LOG("Menu detected on " + view.getPartName());
		inMenu = surface.canTriggerContextualMenu();
		setMousePosition(x, y);
		surface.dispatchMouseEvent(SWT.MenuDetect);
		if (inMenu) {
			surface.selectAgentsAroundMouse();
		}
	}

	/**
	 * Drag detected.
	 */
	public void dragDetected() {
		// DEBUG.LOG("Mouse drag detected on " + view.getPartName());
		// surface.draggedTo(e.x, e.y);
		surface.dispatchMouseEvent(SWT.DragDetect);
	}

	/**
	 * Focus gained.
	 */
	public void focusGained() {
		// if (!ok()) { return; }
		// if (suppressNextEnter) {
		// DEBUG.LOG("One mouse enter suppressed");
		// suppressNextEnter = false;
		// return;
		// }
		// DEBUG.LOG("Control has gained focus");
		// surface.dispatchMouseEvent(SWT.MouseEnter);
		// Thread.dumpStack();
	}

	/**
	 * Focus lost.
	 */
	public void focusLost() {
		// if (!ok()) { return; }
		// surface.dispatchMouseEvent(SWT.MouseExit);

		// DEBUG.LOG("Control has lost focus");
		// Thread.dumpStack();
	}

	/**
	 * Sets the mouse position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	private void setMousePosition(final int x, final int y) {
		surface.setMousePosition(x, y);
		GAMA.getGui().setMouseLocationInModel(surface.getModelCoordinates());
	}

}
