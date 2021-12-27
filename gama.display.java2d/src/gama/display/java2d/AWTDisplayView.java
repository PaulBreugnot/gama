/*******************************************************************************************************
 *
 * AWTDisplayView.java, in gama.display.java2d, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.display.java2d;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import gama.display.java2d.swing.SwingControl;
import gama.ui.experiment.views.displays.LayeredDisplayView;

// TODO: Auto-generated Javadoc
/**
 * The Class AWTDisplayView.
 */
public class AWTDisplayView extends LayeredDisplayView {

	/**
	 * Creates the surface composite.
	 *
	 * @param parent
	 *            the parent
	 * @return the composite
	 */
	@Override
	protected Composite createSurfaceComposite(final Composite parent) {

		if (getOutput() == null) return null;

		surfaceComposite = new SwingControl(parent, SWT.NO_FOCUS) {

			@Override
			protected Java2DDisplaySurface createSwingComponent() {
				return (Java2DDisplaySurface) getDisplaySurface();
			}

		};
		surfaceComposite.setEnabled(false);
		WorkaroundForIssue1594.installOn(this, parent, surfaceComposite, (Java2DDisplaySurface) getDisplaySurface());
		// WorkaroundForIssue2745.installOn(this);
		// WorkaroundForIssue1353.install();
		return surfaceComposite;
	}

}