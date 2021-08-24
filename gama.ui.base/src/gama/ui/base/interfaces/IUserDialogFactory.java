/*******************************************************************************************************
 *
 * IUserDialogFactory.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.interfaces;

import gama.runtime.IScope;
import gaml.architecture.user.UserPanelStatement;

/**
 * A factory for creating IUserDialog objects.
 */
public interface IUserDialogFactory {

	/**
	 * Open user dialog.
	 *
	 * @param scope the scope
	 * @param panel the panel
	 */
	void openUserDialog(IScope scope, UserPanelStatement panel);

	/**
	 * Close user dialog.
	 */
	void closeUserDialog();
}