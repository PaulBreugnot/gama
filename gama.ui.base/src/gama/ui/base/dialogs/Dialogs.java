/*********************************************************************************************
 *
 * 'Messages.java, in plugin ummisco.gama.ui.shared, is part of the source code of the GAMA modeling and simulation
 * platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.ui.base.dialogs;

import org.eclipse.jface.dialogs.MessageDialog;

import gama.ui.base.utils.WorkbenchHelper;

public class Dialogs {

	public static void error(final String title, final String error) {
		WorkbenchHelper.run(() -> MessageDialog.openError(WorkbenchHelper.getShell(), "Error", error));
	}

	public static void inform(final String title, final String error) {
		WorkbenchHelper.run(() -> MessageDialog.openInformation(WorkbenchHelper.getShell(), "Message", error));
	}

	public static boolean question(final String title, final String message) {
		boolean[] result = { true };
		WorkbenchHelper.run(() -> {
			try {
				result[0] = MessageDialog.openQuestion(null, title, message);
			} catch (Exception e) {}
		});
		return result[0];
	}

	public static boolean confirm(final String title, final String message) {
		boolean[] result = { true };
		WorkbenchHelper.run(() -> {
			try {
				result[0] = MessageDialog.openConfirm(null, title, message);
			} catch (Exception e) {}
		});
		return result[0];
	}

}
