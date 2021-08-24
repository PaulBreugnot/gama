/*******************************************************************************************************
 *
 * GamaNavigatorImportMenu.java, in gama.ui.navigator, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.navigator;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import gama.ui.base.resources.GamaIcons;

/**
 * Class GamaNavigatorMenus.
 *
 * @author drogoul
 * @since 8 mars 2015
 *
 */
public class GamaNavigatorImportMenu extends GamaNavigatorMenu { // NO_UCD (unused code)

	/**
  * Instantiates a new gama navigator import menu.
  *
  * @param selection the selection
  */
 public GamaNavigatorImportMenu(final IStructuredSelection selection) {
		this.selection = selection;
	}

	/** The selection. */
	IStructuredSelection selection;

	/** The from disk. */
	private final SelectionListener fromDisk = new SelectionAdapter() {

		@Override
		public void widgetSelected(final SelectionEvent e) {
			openWizard("org.eclipse.ui.wizards.import.FileSystem", selection);
		}

	};

	/** The from archive. */
	private final SelectionListener fromArchive = new SelectionAdapter() {

		@Override
		public void widgetSelected(final SelectionEvent e) {
			openWizard("org.eclipse.ui.wizards.import.ZipFile", selection);
		}

	};
	
	/** The project. */
	private final SelectionListener project = new SelectionAdapter() {

		@Override
		public void widgetSelected(final SelectionEvent e) {
			openWizard("gama.wizard.import.ExternalProject", selection);
		}

	};

	@Override
	protected void fillMenu() {
		action("Import project...", project, GamaIcons.create("navigator/navigator.import.project2").image());
		sep();
		action("Import resources into projects from disk...", fromDisk,
				GamaIcons.create("navigator/navigator.import.disk2").image());
		action("Import resources into projects from archive...", fromArchive,
				GamaIcons.create("navigator/navigator.import.archive2").image());
	}

}
