/*******************************************************************************************************
 *
 * Splash2.java, in gama.ui.base, is part of the source code of the GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.base.workbench;

import static org.eclipse.core.runtime.FileLocator.resolve;
import static org.eclipse.jface.resource.ImageDescriptor.createFromURL;

import java.io.IOException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

import gama.common.ui.IStartupProgress;

/**
 * The Class Splash2.
 */
public class Splash2 implements IStartupProgress {

	/** The splash shell. */
	private Shell splashShell = null;

	/** The text label. */
	private Label textLabel = null;

	/** The next message. */
	private String nextMessage = null;

	/**
	 * Open.
	 *
	 * @return the splash 2
	 */
	public Splash2 open() {
		splashShell = createSplashShell();
		splashShell.open();
		return this;
	}

	/**
	 * Creates the splash shell.
	 *
	 * @return the shell
	 */
	private Shell createSplashShell() {
		final Shell shell = new Shell(SWT.TOOL | SWT.NO_TRIM);
		Image image = createBackgroundImage(shell);
		shell.setBackgroundImage(image);
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);

		final GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginHeight = 40;
		layout.marginWidth = 20;
		layout.verticalSpacing = 6;
		layout.horizontalSpacing = 6;
		shell.setLayout(layout);

		// TODO Set the postion and stlye of the text from outside to make the service reusable
		textLabel = createTextLabel(shell);

		Rectangle imageBounds = image.getBounds();
		shell.setSize(imageBounds.width, imageBounds.height);
		shell.setLocation(getMonitorCenter(shell));
		shell.setVisible(true);
		return shell;
	}

	/**
	 * Creates the background image.
	 *
	 * @param parent
	 *            the parent
	 * @return the image
	 */
	private Image createBackgroundImage(final Shell parent) {
		final Image splashImage = getImageDescriptor().createImage();
		parent.addDisposeListener(e -> splashImage.dispose());
		return splashImage;
	}

	/**
	 * Gets the image descriptor.
	 *
	 * @return the image descriptor
	 */
	public ImageDescriptor getImageDescriptor() {
		try {
			return createFromURL(resolve(new URL("platform:/plugin/gama.ui.base/welcome/splash4.png")));
		} catch (final IOException e) {
			return null;
		}
	}

	/**
	 * Creates the text label.
	 *
	 * @param parent
	 *            the parent
	 * @return the label
	 */
	private Label createTextLabel(final Composite parent) {
		Label label = new Label(parent, SWT.WRAP);
		GridData gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		gd.verticalAlignment = SWT.BOTTOM;
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		label.setLayoutData(gd);

		label.setForeground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		label.setFont(parent.getDisplay().getSystemFont());

		if (nextMessage != null) { label.setText(nextMessage); }
		return label;
	}

	/**
	 * Gets the monitor center.
	 *
	 * @param shell
	 *            the shell
	 * @return the monitor center
	 */
	private Point getMonitorCenter(final Shell shell) {
		Monitor primary = shell.getDisplay().getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		Rectangle rect = shell.getBounds();
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
		return new Point(x, y);
	}

	/**
	 * Close.
	 */
	@Override
	public void close() {
		splashShell.close();
		splashShell = null;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	@Override
	public void add(final String message) {
		if (textLabel != null && !textLabel.isDisposed()) {
			splashShell.getDisplay().syncExec(() -> {
				textLabel.setText(message);
				splashShell.layout();
				splashShell.update();
			});
		} else {
			nextMessage = message;
		}
	}

}