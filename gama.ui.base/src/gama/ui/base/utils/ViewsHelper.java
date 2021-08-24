/*******************************************************************************************************
 *
 * ViewsHelper.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.utils;

import gama.common.ui.IGamaView;

/**
 * The Class ViewsHelper.
 */
public class ViewsHelper {

	/** The is requesting. */
	static volatile boolean isRequesting;

	/**
	 * Request user attention.
	 *
	 * @param part the part
	 * @param tempMessage the temp message
	 */
	public static void requestUserAttention(final IGamaView part, final String tempMessage) {
		if (isRequesting) { return; }
		// rate at which the title will change in milliseconds
		final int rateOfChange = 200;
		final int numberOfTimes = 2;

		// flash n times and thats it
		final String orgText = part.getPartName();

		for (int x = 0; x < numberOfTimes; x++) {
			WorkbenchHelper.getDisplay().timerExec(2 * rateOfChange * x - rateOfChange, () -> {
				isRequesting = true;
				part.setName(tempMessage);
			});
			WorkbenchHelper.getDisplay().timerExec(2 * rateOfChange * x, () -> {
				part.setName(orgText);
				isRequesting = false;
			});
		}
	}

}
