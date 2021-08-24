/*******************************************************************************************************
 *
 * UserDialogFactory.java, in gama.ui.experiment, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.experiment.factories;

import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

import gama.runtime.IScope;
import gama.ui.experiment.views.user.UserControlDialog;
import gaml.architecture.user.UserPanelStatement;

/**
 * A factory for creating UserDialog objects.
 */
public class UserDialogFactory extends AbstractServiceFactory implements gama.ui.base.interfaces.IUserDialogFactory {

	@Override
	public void openUserDialog(final IScope scope, final UserPanelStatement panel) {
		final UserControlDialog dialog = new UserControlDialog(scope, panel);
		dialog.open();
	}

	@Override
	public void closeUserDialog() {
		final UserControlDialog d = UserControlDialog.current;
		if (d != null) {
			d.close();
		}
	}

	@Override
	public Object create(final Class serviceInterface, final IServiceLocator parentLocator,
			final IServiceLocator locator) {
		return this;
	}

}
