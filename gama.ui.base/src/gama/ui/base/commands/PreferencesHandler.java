/*******************************************************************************************************
 *
 * PreferencesHandler.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import gama.ui.base.views.GamaPreferencesView;

/**
 * The Class PreferencesHandler.
 */
public class PreferencesHandler extends AbstractHandler {

	// GamaPreferencesView view;

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		GamaPreferencesView.show();
		return null;
	}

}
