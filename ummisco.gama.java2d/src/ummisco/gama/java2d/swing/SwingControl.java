/*******************************************************************************************************
 *
 * SwingControl.java, in ummisco.gama.java2d, is part of the source code of the GAMA modeling and simulation platform
 * (v.1.8.2).
 *
 * (c) 2007-2022 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package ummisco.gama.java2d.swing;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import msi.gama.runtime.PlatformHelper;
import ummisco.gama.dev.utils.DEBUG;
import ummisco.gama.java2d.Java2DDisplaySurface;
import ummisco.gama.java2d.WorkaroundForIssue2476;
import ummisco.gama.ui.utils.WorkbenchHelper;

/**
 * The Class SwingControl.
 */
public abstract class SwingControl extends Composite {

	static {
		DEBUG.ON();
	}

	/** The applet. */
	JApplet applet;

	/** The multi listener. */
	KeyListener multiListener;

	/** The frame. */
	Frame frame;

	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public Frame getFrame() { return frame; }

	/** The surface. */
	Java2DDisplaySurface surface;

	/** The populated. */
	boolean populated = false;

	/**
	 * Instantiates a new swing control.
	 *
	 * @param parent
	 *            the parent
	 * @param style
	 *            the style
	 */
	public SwingControl(final Composite parent, final int style) {
		super(parent, style | ((style & SWT.BORDER) == 0 ? SWT.EMBEDDED : 0) | SWT.NO_BACKGROUND);
		setLayout(new FillLayout());
	}

	@Override
	public void checkWidget() {}

	@Override
	public boolean isFocusControl() {
		boolean result = false;
		try {
			result = super.isFocusControl();
		} catch (final Exception e) {
			// Nothing. Eliminates annoying exceptions when closing Java2D displays.
		}
		return result;
	}

	/**
	 * Populate.
	 */
	protected void populate() {
		if (isDisposed()) return;
		if (!populated) {
			populated = true;
			WorkbenchHelper.asyncRun(() -> {
				frame = SWT_AWT.new_Frame(SwingControl.this);
				frame.setAlwaysOnTop(false);
				if (multiListener != null) { frame.addKeyListener(multiListener); }
				applet = new JApplet();
				surface = createSwingComponent();
				applet.getContentPane().add(surface);
				WorkaroundForIssue2476.installOn(applet, surface);
				frame.add(applet);
				if (PlatformHelper.isMac()) {
					MouseListener ml = new MouseAdapter() {

						@Override
						public void mouseExited(final MouseEvent e) {
							if (surface.isFocusOwner() && !surface.contains(e.getPoint())) {
								frame.setVisible(false);
								frame.setVisible(true);
								WorkbenchHelper.asyncRun(() -> getShell().forceActive());
							}

						}

					};
					applet.addMouseListener(ml);
					surface.addMouseListener(ml);

				}
			});
			addListener(SWT.Dispose, event -> EventQueue.invokeLater(() -> {
				try {
					frame.remove(applet);
				} catch (final Exception e) {}

			}));
		}
	}

	/**
	 * Creates the embedded Swing component. This method is called from the AWT event thread.
	 *
	 * @return a non-null Swing component
	 */
	protected abstract Java2DDisplaySurface createSwingComponent();

	/**
	 * Overridden to propagate the size to the embedded Swing component.
	 */
	@Override
	public void setBounds(final int x, final int y, final int width, final int height) {
		// DEBUG.OUT("-- SwingControl bounds set to " + x + " " + y + " | " + width + " " + height);
		populate();
		// See Issue #3426

		super.setBounds(x, y, width, height);
		// Assignment necessary for #3313 and #3239
		WorkbenchHelper.asyncRun(() -> {
			// getParent().requestLayout();
			EventQueue.invokeLater(() -> {
				// DEBUG.OUT("Set size sent by SwingControl " + width + " " + height);
				// frame.setBounds(x, y, width, height);
				// frame.setVisible(false);
				surface.setSize(width, height);
				// frame.setVisible(true);
			});

		});

	}

	/**
	 * Sets the key listener.
	 *
	 * @param adapter
	 *            the new key listener
	 */
	public void setKeyListener(final KeyListener adapter) { multiListener = adapter; }

}
