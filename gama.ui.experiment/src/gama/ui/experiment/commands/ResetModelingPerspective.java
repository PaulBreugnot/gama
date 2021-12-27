/*******************************************************************************************************
 *
 * ResetModelingPerspective.java, in gama.ui.experiment, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.experiment.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import gama.common.preferences.GamaPreferenceStore;
import gama.core.application.workspace.WorkspaceManager;
import gama.ui.base.dialogs.Dialogs;
import gama.ui.base.utils.WorkbenchHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class ResetModelingPerspective.
 */
public class ResetModelingPerspective extends AbstractHandler {

	/**
	 * Execute.
	 *
	 * @param event
	 *            the event
	 * @return the object
	 * @throws ExecutionException
	 *             the execution exception
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final boolean result = Dialogs.confirm("Reset modeling perspective",
				"Resetting the modeling perspective will lose memory of the current editors, navigator state and restart GAMA in a pristine state. Do you want to proceed ?");
		if (result) {
			GamaPreferenceStore.getStore().putBoolean(WorkspaceManager.KEY_CLEAR_WORKSPACE, true);
			WorkbenchHelper.getWorkbench().restart();
		}
		return null;

	}

}
