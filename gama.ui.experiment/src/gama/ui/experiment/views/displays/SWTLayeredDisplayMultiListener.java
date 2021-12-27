/*******************************************************************************************************
 *
 * SWTLayeredDisplayMultiListener.java, in gama.ui.experiment, is part of the source code of the GAMA modeling and
 * simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.experiment.views.displays;

import java.util.Objects;
import java.util.function.Supplier;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;

import gama.common.interfaces.IDisposable;
import gama.common.ui.IDisplaySurface;
import gama.ui.base.bindings.GamaKeyBindings;
import gama.ui.base.utils.WorkbenchHelper;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving SWTLayeredDisplayMulti events. The class that is interested in processing a
 * SWTLayeredDisplayMulti event implements this interface, and the object created with that class is registered with a
 * component using the component's <code>addSWTLayeredDisplayMultiListener<code> method. When the SWTLayeredDisplayMulti
 * event occurs, that object's appropriate method is invoked.
 *
 * @see SWTLayeredDisplayMultiEvent
 */
public class SWTLayeredDisplayMultiListener implements MenuDetectListener, MouseListener, MouseMoveListener,
		MouseTrackListener, MouseWheelListener, KeyListener, DragDetectListener, FocusListener, IDisposable {

	/** The delegate. */
	final LayeredDisplayMultiListener delegate;

	/** The control. */
	Control control;

	/** The ok. */
	final Supplier<Boolean> ok;

	/**
	 * Instantiates a new SWT layered display multi listener.
	 *
	 * @param deco
	 *            the deco
	 * @param surface
	 *            the surface
	 */
	public SWTLayeredDisplayMultiListener(final LayeredDisplayDecorator deco, final IDisplaySurface surface) {

		delegate = new LayeredDisplayMultiListener(surface, deco);
		control = deco.view.getInteractionControl();
		ok = () -> {
			final boolean viewOk = deco.view != null && !deco.view.disposed;
			if (!viewOk) return false;
			final boolean controlOk = control != null && !control.isDisposed();
			if (!controlOk) return false;
			final boolean surfaceOk = surface != null && !surface.isDisposed();
			if (!control.isFocusControl()) { control.forceFocus(); }
			if (!Objects.equals(WorkbenchHelper.getActivePart(), deco.view)) {
				WorkbenchHelper.getPage().activate(deco.view);
			}
			return surfaceOk;
		};

		control.addKeyListener(this);
		control.addMouseListener(this);
		control.addMenuDetectListener(this);
		control.addDragDetectListener(this);
		control.addMouseTrackListener(this);
		control.addMouseMoveListener(this);
		control.addFocusListener(this);
	}

	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {
		if (control == null || control.isDisposed()) return;
		control.removeKeyListener(this);
		control.removeMouseListener(this);
		control.removeMenuDetectListener(this);
		control.removeDragDetectListener(this);
		control.removeMouseTrackListener(this);
		control.removeMouseMoveListener(this);
		control.removeFocusListener(this);
	}

	/**
	 * Key pressed.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void keyPressed(final KeyEvent e) {
		if (!ok.get()) return;
		delegate.keyPressed(e.character);
	}

	/**
	 * Key released.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void keyReleased(final KeyEvent e) {
		if (!ok.get()) return;
		delegate.keyReleased(e.keyCode, GamaKeyBindings.ctrl(e));
	}

	/**
	 * Mouse scrolled.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseScrolled(final MouseEvent e) {
		if (!ok.get()) {}
	}

	/**
	 * Mouse enter.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseEnter(final MouseEvent e) {
		if (!ok.get()) return;
		delegate.mouseEnter(e.x, e.y, (e.stateMask & SWT.MODIFIER_MASK) != 0, e.button);
	}

	/**
	 * Mouse exit.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseExit(final MouseEvent e) {
		if (!ok.get()) return;
		delegate.mouseExit(e.x, e.y, (e.stateMask & SWT.MODIFIER_MASK) != 0, e.button);
	}

	/**
	 * Mouse hover.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseHover(final MouseEvent e) {
		if (!ok.get()) return;
		delegate.mouseHover(e.x, e.y, e.button);
	}

	/**
	 * Mouse move.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseMove(final MouseEvent e) {
		if (!ok.get()) return;
		delegate.mouseMove(e.x, e.y, (e.stateMask & SWT.MODIFIER_MASK) != 0);
	}

	/**
	 * Mouse double click.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseDoubleClick(final MouseEvent e) {
		if (!ok.get()) {}
	}

	/**
	 * Mouse down.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseDown(final MouseEvent e) {
		if (!ok.get()) return;
		delegate.mouseDown(e.x, e.y, e.button, (e.stateMask & SWT.MODIFIER_MASK) != 0);
	}

	/**
	 * Mouse up.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void mouseUp(final MouseEvent e) {
		if (!ok.get()) return;
		delegate.mouseUp(e.x, e.y, e.button, (e.stateMask & SWT.MODIFIER_MASK) != 0);
	}

	/**
	 * Menu detected.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void menuDetected(final MenuDetectEvent e) {
		if (!ok.get()) return;
		// DEBUG.LOG("Menu detected on " + view.getPartName());
		final Point p = control.toControl(e.x, e.y);
		delegate.menuDetected(p.x, p.y);
	}

	/**
	 * Drag detected.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void dragDetected(final DragDetectEvent e) {
		if (!ok.get()) return;
		delegate.dragDetected(e.x, e.y);
	}

	/**
	 * Focus gained.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void focusGained(final FocusEvent e) {
		delegate.focusGained();
	}

	/**
	 * Focus lost.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void focusLost(final FocusEvent e) {
		delegate.focusLost();
	}

}
