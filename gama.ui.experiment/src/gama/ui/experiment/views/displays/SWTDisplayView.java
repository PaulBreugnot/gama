/*******************************************************************************************************
 *
 * SWTDisplayView.java, in gama.ui.experiment, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.experiment.views.displays;

import org.eclipse.swt.widgets.Control;

import gama.core.dev.utils.DEBUG;
import gama.runtime.IScope;
import gama.ui.base.utils.WorkbenchHelper;

// TODO: Auto-generated Javadoc
/**
 * Class OpenGLLayeredDisplayView.
 *
 * @author drogoul
 * @since 25 mars 2015
 *
 */
public abstract class SWTDisplayView extends LayeredDisplayView {

	static {
		DEBUG.ON();
	}

	/**
	 * Gets the zoomable controls.
	 *
	 * @return the zoomable controls
	 */
	@Override
	public Control[] getZoomableControls() { return new Control[] { surfaceComposite }; }

	/**
	 * Sets the focus.
	 */
	@Override
	public void setFocus() {
		if (surfaceComposite != null && !surfaceComposite.isDisposed() && !surfaceComposite.isFocusControl()) {
			surfaceComposite.forceFocus();
		}
	}

	/**
	 * Close.
	 *
	 * @param scope
	 *            the scope
	 */
	@Override
	public void close(final IScope scope) {
		DEBUG.OUT("Closing " + this.getPartName());
		WorkbenchHelper.asyncRun(() -> {
			try {
				if (getDisplaySurface() != null) { getDisplaySurface().dispose(); }
				if (getSite() != null && getSite().getPage() != null) {
					getSite().getPage().hideView(SWTDisplayView.this);
				}
			} catch (final Exception e) {}
		});

	}

}
