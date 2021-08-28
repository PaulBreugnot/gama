/*******************************************************************************************************
 *
 * Splash.java, in gama.ui.base, is part of the source code of the GAMA modeling and simulation platform (v.2.0.0).
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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressIndicator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.ProgressMonitorPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.splash.EclipseSplashHandler;

import gama.common.ui.IStartupProgress;
import gama.core.dev.utils.DEBUG;
import gama.runtime.GAMA;

/**
 * The Class Splash.
 */
public class Splash extends EclipseSplashHandler implements IStartupProgress {

	/** The instance. */
	static Splash INSTANCE;

	/** The shell. */
	private Shell shell;

	/** The index. */
	private static int INDEX;

	/** The id. */
	private final int id = INDEX++;

	/**
	 * Gets the single instance of Splash.
	 *
	 * @return single instance of Splash
	 */
	public static Splash getInstance() {
		return INSTANCE;
	}

	{
		DEBUG.ON();
	}

	/**
	 * Instantiates a new splash.
	 */
	public Splash() {
		DEBUG.OUT("Instantiation of Splash #" + id);
		GAMA.setStartupProgressListener(this);
		INSTANCE = this;
		getSplash();
	}

	/**
	 * Gets the image descriptor.
	 *
	 * @return the image descriptor
	 */
	public ImageDescriptor getImageDescriptor() {
		try {
			return createFromURL(resolve(new URL("platform:/plugin/gama.ui.base/welcome/splash4.jpg")));
		} catch (final IOException e) {
			return null;
		}
	}

	/**
	 * Circle.
	 *
	 * @param r
	 *            the r
	 * @param offsetX
	 *            the offset X
	 * @param offsetY
	 *            the offset Y
	 * @return the int[]
	 */
	static int[] circle(final int r, final int offsetX, final int offsetY) {
		int[] polygon = new int[8 * r + 4];
		// x^2 + y^2 = r^2
		for (int i = 0; i < 2 * r + 1; i++) {
			int x = i - r;
			int y = (int) Math.sqrt(r * r - x * x);
			polygon[2 * i] = offsetX + x;
			polygon[2 * i + 1] = offsetY + y;
			polygon[8 * r - 2 * i - 2] = offsetX + x;
			polygon[8 * r - 2 * i - 1] = offsetY - y;
		}
		return polygon;
	}

	/**
	 * Initializes the splash.
	 *
	 * @param shell
	 *            the shell
	 */
	@Override
	public void init(final Shell shell) {
		super.init(shell);
		// ProgressIndicator pi = getProgressIndicator();
		Label label = getProgressText();
		label.setAlignment(SWT.CENTER);
	}

	/**
	 * Gets the progress indicator.
	 *
	 * @return the progress indicator
	 */
	public ProgressIndicator getProgressIndicator() {
		for (Control c : getBundleProgressMonitor().getChildren()) {
			if (c instanceof ProgressIndicator) return (ProgressIndicator) c;
		}
		return null;
	}

	/**
	 * Gets the progress text.
	 *
	 * @return the progress text
	 */
	public Label getProgressText() {
		for (Control c : getBundleProgressMonitor().getChildren()) {
			if (c instanceof Label) return (Label) c;
		}
		return null;
	}

	/**
	 * Close.
	 */
	@Override
	public void close() {
		// super.dispose();
		IStartupProgress.super.close();
	}

	@Override
	public ProgressMonitorPart getBundleProgressMonitor() {
		return (ProgressMonitorPart) super.getBundleProgressMonitor();
	}

	/**
	 * Adds a task.
	 *
	 * @param task
	 *            the task
	 */
	@Override
	public void add(final String task) {

		IProgressMonitor pm = getBundleProgressMonitor();
		if (pm == null) return;
		pm.worked(100);
		pm.setTaskName(task);
		DEBUG.OUT("Adding " + task + " to a non-null progress to #" + this.id + " in thread #"
				+ Thread.currentThread().getName());

	}

	@Override
	public Shell getSplash() {
		if (shell == null) {
			DEBUG.OUT("Creating the splash #" + id);
			shell = new Shell(SWT.NO_TRIM | SWT.ON_TOP);
			final Image im = getImageDescriptor().createImage();
			shell.setBackgroundImage(im);
			final Rectangle bounds = im.getBounds();
			final Rectangle screen = shell.getDisplay().getPrimaryMonitor().getBounds();
			shell.setLocation(screen.x + (screen.width - bounds.width) / 2,
					screen.y + (screen.height - bounds.height) / 3);
			shell.addDisposeListener(e -> im.dispose());
			Region r = new Region();
			int size = bounds.width / 2;
			r.add(circle(size, size, size));
			shell.setRegion(r);
		}
		return shell;
	}

}
