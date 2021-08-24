/*******************************************************************************************************
 *
 * ResetModelingPerspective.java, in gama.ui.experiment, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.experiment.commands;

import static gama.ui.base.utils.WorkbenchHelper.getShell;
import static org.eclipse.jface.dialogs.MessageDialog.QUESTION;
import static org.eclipse.jface.dialogs.MessageDialog.open;
import static org.eclipse.swt.SWT.SHEET;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import gama.common.preferences.GamaPreferenceStore;
import gama.core.application.workspace.WorkspaceManager;
import gama.ui.base.utils.WorkbenchHelper;

/**
 * The Class ResetModelingPerspective.
 */
public class ResetModelingPerspective extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final String message =
				"Resetting the modeling perspective will lose memory of the current editors, navigator state and restart GAMA in a pristine state. Do you want to proceed ?";
		final boolean result = open(QUESTION, getShell(), "Reset modeling perspective", message, SHEET);
		if (result) {
			GamaPreferenceStore.getStore().putBoolean(WorkspaceManager.KEY_CLEAR_WORKSPACE, true);
			WorkbenchHelper.getWorkbench().restart();
		}
		return null;

	}

}
