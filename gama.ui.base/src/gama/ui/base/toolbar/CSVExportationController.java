/*******************************************************************************************************
 *
 * CSVExportationController.java, in gama.ui.base, is part of the source code of the
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

/**
 * Class ZoomController.
 *
 * @author drogoul
 * @since 9 févr. 2015
 *
 */
public class CSVExportationController {

	/** The view. */
	private final IToolbarDecoratedView.CSVExportable view;

	/**
	 * Instantiates a new CSV exportation controller.
	 *
	 * @param view the view
	 */
	public CSVExportationController(final IToolbarDecoratedView.CSVExportable view) {
		this.view = view;
	}

	/**
	 * Install.
	 *
	 * @param tb the tb
	 */
	public void install(final GamaToolbar2 tb) {
		tb.button(GamaIcons.create(IGamaIcons.DISPLAY_TOOLBAR_CSVEXPORT).getCode(), "CSV Export", "CSV Export",
				e -> view.saveAsCSV(), SWT.RIGHT);

	}

}
