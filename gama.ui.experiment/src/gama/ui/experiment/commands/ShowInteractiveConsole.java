/*******************************************************************************************************
 *
 * ShowInteractiveConsole.java, in gama.ui.experiment, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.experiment.commands;

import static org.eclipse.ui.IWorkbenchPage.VIEW_VISIBLE;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import gama.common.ui.IGui;
import gama.runtime.GAMA;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowInteractiveConsole.
 */
public class ShowInteractiveConsole extends AbstractHandler {

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
		return GAMA.getGui().showView(null, IGui.INTERACTIVE_CONSOLE_VIEW_ID, null, VIEW_VISIBLE);
	}

}
