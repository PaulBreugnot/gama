/*******************************************************************************************************
 *
 * RunAllTestsAction.java, in gama.ui.navigator, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.navigator.actions;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.ui.actions.WorkspaceAction;

import gama.ui.base.commands.TestsRunner;
import gama.ui.navigator.contents.ResourceManager;
import gama.ui.navigator.contents.TestModelsFolder;

/**
 * The Class RunAllTestsAction.
 */
public class RunAllTestsAction extends WorkspaceAction {

	/**
	 * Instantiates a new run all tests action.
	 *
	 * @param provider the provider
	 * @param text the text
	 */
	protected RunAllTestsAction(final IShellProvider provider, final String text) {
		super(provider, text);
	}

	@Override
	protected String getOperationMessage() {
		return "Running all tests";
	}

	@Override
	public boolean updateSelection(final IStructuredSelection event) {
		return event.getFirstElement() instanceof TestModelsFolder;
	}

	@Override
	public void run() {
		TestsRunner.start();
		ResourceManager.finishTests();
	}

}
