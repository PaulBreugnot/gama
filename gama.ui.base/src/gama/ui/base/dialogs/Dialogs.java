/*******************************************************************************************************
 *
 * Dialogs.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.dialogs;

import org.eclipse.jface.dialogs.MessageDialog;

import gama.ui.base.utils.WorkbenchHelper;

/**
 * The Class Dialogs.
 */
public class Dialogs {

	/**
	 * Error.
	 *
	 * @param title the title
	 * @param error the error
	 */
	public static void error(final String title, final String error) {
		WorkbenchHelper.run(() -> MessageDialog.openError(WorkbenchHelper.getShell(), "Error", error));
	}

	/**
	 * Inform.
	 *
	 * @param title the title
	 * @param error the error
	 */
	public static void inform(final String title, final String error) {
		WorkbenchHelper.run(() -> MessageDialog.openInformation(WorkbenchHelper.getShell(), "Message", error));
	}

	/**
	 * Question.
	 *
	 * @param title the title
	 * @param message the message
	 * @return true, if successful
	 */
	public static boolean question(final String title, final String message) {
		boolean[] result = { true };
		WorkbenchHelper.run(() -> {
			try {
				result[0] = MessageDialog.openQuestion(null, title, message);
			} catch (Exception e) {}
		});
		return result[0];
	}

	/**
	 * Confirm.
	 *
	 * @param title the title
	 * @param message the message
	 * @return true, if successful
	 */
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
