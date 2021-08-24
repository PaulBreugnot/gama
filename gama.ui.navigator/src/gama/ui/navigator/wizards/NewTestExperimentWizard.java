/*******************************************************************************************************
 *
 * NewTestExperimentWizard.java, in gama.ui.navigator, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.navigator.wizards;

import org.eclipse.jface.viewers.ISelection;

/**
 * The Class NewTestExperimentWizard.
 */
public class NewTestExperimentWizard extends AbstractNewModelWizard {

	@Override
	public AbstractNewModelWizardPage createPage(final ISelection selection) {
		return new NewTestExperimentWizardPage(selection);
	}

	@Override
	protected String getDefaultFolderForModels() {
		return "tests";
	}

}