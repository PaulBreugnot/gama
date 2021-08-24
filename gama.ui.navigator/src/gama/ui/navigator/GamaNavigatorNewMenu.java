/*******************************************************************************************************
 *
 * GamaNavigatorNewMenu.java, in gama.ui.navigator, is part of the source code of the
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
public class GamaNavigatorNewMenu extends GamaNavigatorMenu { // NO_UCD (unused code)

	/**
  * Instantiates a new gama navigator new menu.
  *
  * @param selection the selection
  */
 public GamaNavigatorNewMenu(final IStructuredSelection selection) {
		this.selection = selection;
	}

	/** The selection. */
	IStructuredSelection selection;

	/** The new model. */
	private final SelectionListener newModel = new SelectionAdapter() {

		@Override
		public void widgetSelected(final SelectionEvent e) {
			openWizard("msi.gama.gui.wizards.NewFileWizard", selection);
		}

	};

	/** The new experiment. */
	private final SelectionListener newExperiment = new SelectionAdapter() {

		@Override
		public void widgetSelected(final SelectionEvent e) {
			openWizard("msi.gama.gui.wizards.NewExperimentWizard", selection);
		}

	};

	/** The new project. */
	private final SelectionListener newProject = new SelectionAdapter() {

		@Override
		public void widgetSelected(final SelectionEvent e) {
			openWizard("msi.gama.gui.wizards.newProjectWizard", selection);
		}

	};
	
	/** The new folder. */
	private final SelectionListener newFolder = new SelectionAdapter() {

		@Override
		public void widgetSelected(final SelectionEvent e) {
			openWizard("org.eclipse.ui.wizards.new.folder", selection);
		}

	};

	/** The new test experiment. */
	private final SelectionListener newTestExperiment = new SelectionAdapter() {

		@Override
		public void widgetSelected(final SelectionEvent e) {
			openWizard("msi.gama.gui.wizards.NewTestExperimentWizard", selection);
		}

	};

	// private final SelectionListener newOther = new SelectionAdapter() {
	//
	// @Override
	// public void widgetSelected(final SelectionEvent e) {
	// openWizard("org.eclipse.ui.internal.dialogs.NewWizard", selection);
	// }
	//
	// };

	@Override
	protected void fillMenu() {
		action("New Model file...", newModel, GamaIcons.create("navigator/new.model2").image());
		action("New Experiment file...", newExperiment, GamaIcons.create("navigator/new.model2").image());
		action("New Project...", newProject, GamaIcons.create("navigator/new.project2").image());
		sep();
		action("New Test Experiment file...", newTestExperiment, GamaIcons.create("navigator/new.model2").image());
		sep();
		action("New Folder...", newFolder, GamaIcons.create("navigator/new.folder2").image());
		// sep();
		// action("Other...", newOther, GamaIcons.create("navigator/navigator.new2").image());
	}

}
