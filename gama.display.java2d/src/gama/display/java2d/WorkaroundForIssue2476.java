/*******************************************************************************************************
 *
 * WorkaroundForIssue2476.java, in gama.display.java2d, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.display.java2d;

import java.awt.Panel;
import java.awt.event.MouseMotionListener;

import org.eclipse.swt.SWT;

import gama.common.ui.IDisplaySurface;
import gama.core.dev.utils.DEBUG;
import gama.runtime.GAMA;

/**
 * The Class WorkaroundForIssue2476.
 */
public class WorkaroundForIssue2476 {

	static {
		DEBUG.OFF();
	}

	/**
	 * Sets the mouse position.
	 *
	 * @param surface the surface
	 * @param x the x
	 * @param y the y
	 */
	private static void setMousePosition(final IDisplaySurface surface, final int x, final int y) {
		surface.setMousePosition(x, y);
		GAMA.getGui().setMouseLocationInModel(surface.getModelCoordinates());
	}

	/**
	 * Install on.
	 *
	 * @param applet the applet
	 * @param surface the surface
	 */
	public static void installOn(final Panel applet, final IDisplaySurface surface) {
		// Install only on Linux
		if (!gama.ui.base.utils.PlatformHelper.isLinux()) return;
		applet.addMouseWheelListener(e -> {
			if (e.getPreciseWheelRotation() > 0) {
				surface.zoomOut();
			} else {
				surface.zoomIn();
			}
		});
		applet.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(final java.awt.event.MouseEvent e) {
				setMousePosition(surface, e.getX(), e.getY());
			}

			@Override
			public void mouseDragged(final java.awt.event.MouseEvent e) {
				surface.draggedTo(e.getX(), e.getY());
			}
		});
		applet.addMouseListener(new java.awt.event.MouseListener() {

			volatile boolean inMenu;

			@Override
			public void mouseReleased(final java.awt.event.MouseEvent e) {
				surface.setMousePosition(e.getX(), e.getY());
				surface.dispatchMouseEvent(SWT.MouseUp);
			}

			@Override
			public void mousePressed(final java.awt.event.MouseEvent e) {

			}

			@Override
			public void mouseExited(final java.awt.event.MouseEvent e) {
				surface.dispatchMouseEvent(SWT.MouseExit);
			}

			@Override
			public void mouseEntered(final java.awt.event.MouseEvent e) {
				surface.dispatchMouseEvent(SWT.MouseEnter);
			}

			@Override
			public void mouseClicked(final java.awt.event.MouseEvent e) {
				if (e.getClickCount() == 2) { surface.zoomFit(); }
				if (e.getButton() == 3 && !inMenu) {
					inMenu = surface.canTriggerContextualMenu();
					setMousePosition(surface, e.getX(), e.getY());
					if (inMenu) { surface.selectAgentsAroundMouse(); }
					surface.dispatchMouseEvent(SWT.MenuDetect);
					return;
				}

				if (inMenu) {
					inMenu = false;
					return;
				}
				// DEBUG.OUT("Click on " + e.getX() + " " + e.getY());
				setMousePosition(surface, e.getX(), e.getY());
				surface.dispatchMouseEvent(SWT.MouseDown);

			}
		});

	}

}
