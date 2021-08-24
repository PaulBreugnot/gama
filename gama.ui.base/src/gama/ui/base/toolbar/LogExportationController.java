/*******************************************************************************************************
 *
 * LogExportationController.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.toolbar;

import org.eclipse.swt.SWT;

import gama.ui.base.resources.GamaIcons;
import gama.ui.base.resources.IGamaIcons;
import gama.ui.base.toolbar.IToolbarDecoratedView.LogExportable;

/**
 * Class ZoomController.
 *
 * @author drogoul
 * @since 9 févr. 2015
 *
 */
public class LogExportationController {

	/** The view. */
	private final IToolbarDecoratedView.LogExportable view;

	/**
	 * Instantiates a new log exportation controller.
	 *
	 * @param view2 the view 2
	 */
	public LogExportationController(final LogExportable view2) {
		this.view = view2;
	}

	/**
	 * Install.
	 *
	 * @param tb the tb
	 */
	public void install(final GamaToolbar2 tb) {
		tb.button(GamaIcons.create(IGamaIcons.DISPLAY_TOOLBAR_CSVEXPORT).getCode(), "Export to log file",
				"Export to log file", e -> view.saveAsLog(), SWT.RIGHT);

	}

}
