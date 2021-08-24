/*********************************************************************************************
 *
 * 'IUserDialogFactory.java, in plugin gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform.
 * (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 * 
 *
 **********************************************************************************************/
package gama.ui.base.interfaces;

import gama.runtime.IScope;
import gaml.architecture.user.UserPanelStatement;

public interface IUserDialogFactory {

	void openUserDialog(IScope scope, UserPanelStatement panel);

	void closeUserDialog();
}