/*******************************************************************************************************
 *
 * ZoomController.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.toolbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.GestureListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.widgets.Control;

import gama.ui.base.resources.IGamaIcons;

/**
 * Class ZoomController.
 *
 * @author drogoul
 * @since 9 févr. 2015
 *
 */
public class ZoomController {

	/** The including scrolling. */
	// Fix for Issue #1291
	final boolean includingScrolling;
	
	/** The view. */
	final IToolbarDecoratedView.Zoomable view;

	/**
	 * Instantiates a new zoom controller.
	 *
	 * @param view the view
	 */
	public ZoomController(final IToolbarDecoratedView.Zoomable view) {
		this.view = view;
		this.includingScrolling = view.zoomWhenScrolling();
	}

	/**
	 * Install.
	 *
	 * @param tb the tb
	 */
	public void install(final GamaToolbar2 tb) {
		final GestureListener gl = ge -> {
			if (ge.detail == SWT.GESTURE_MAGNIFY) {
				if (ge.magnification > 1.0) {
					view.zoomIn();
				} else if (ge.magnification < 1.0) {
					view.zoomOut();
				}
			}

		};

		final MouseListener ml = new MouseAdapter() {

			@Override
			public void mouseDoubleClick(final MouseEvent e) {
				if (e.button == 1) {
					view.zoomFit();
				}
			}
		};

		final MouseWheelListener mw = e -> {
			if (e.count < 0) {
				view.zoomOut();
			} else {
				view.zoomIn();
			}
		};

		tb.addControlListener(new ControlAdapter() {

			@Override
			public void controlResized(final ControlEvent e) {
				final Control[] controls = view.getZoomableControls();
				for (final Control c : controls) {
					if (c != null) {
						c.addGestureListener(gl);
						c.addMouseListener(ml);
						if (includingScrolling) {
							c.addMouseWheelListener(mw);
						}
						// once installed the listener removes itself from the
						// toolbar
						tb.removeControlListener(this);
					}
				}
			}

		});
		tb.button(IGamaIcons.DISPLAY_TOOLBAR_ZOOMIN, "Zoom in", "Zoom in", e -> view.zoomIn(), SWT.RIGHT);
		tb.button(IGamaIcons.DISPLAY_TOOLBAR_ZOOMFIT, "Zoom fit", "Zoom to fit view", e -> view.zoomFit(), SWT.RIGHT);
		tb.button(IGamaIcons.DISPLAY_TOOLBAR_ZOOMOUT, "Zoom out", "Zoom out", e -> view.zoomOut(), SWT.RIGHT);

	}

}
