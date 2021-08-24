/*******************************************************************************************************
 *
 * InstallHandler.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.commands;

import static gama.ui.base.utils.WorkbenchHelper.getCommand;
import static gama.ui.base.utils.WorkbenchHelper.runCommand;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.internal.AbstractEnabledHandler;

/**
 * The Class InstallHandler.
 */
public class InstallHandler extends AbstractEnabledHandler implements IHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		return runCommand(getCommand("org.eclipse.equinox.p2.ui.sdk.install"), event);
	}

}
