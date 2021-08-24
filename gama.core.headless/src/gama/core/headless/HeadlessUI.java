/*******************************************************************************************************
 *
 * HeadlessUI.java, in gama.core.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.headless;

import gama.common.ui.IApplicationControl;
import gama.common.ui.IApplicationControlProvider;

/**
 * The Class HeadlessUI.
 */
public class HeadlessUI implements IApplicationControlProvider {

	/**
	 * Instantiates a new headless UI.
	 */
	public HeadlessUI() {}

	@Override
	public IApplicationControl get() {
		return null;
	}

}
