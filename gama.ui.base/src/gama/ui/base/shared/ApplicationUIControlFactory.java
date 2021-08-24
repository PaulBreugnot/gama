/*******************************************************************************************************
 *
 * ApplicationUIControlFactory.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.shared;

import gama.common.ui.IApplicationControl;
import gama.common.ui.IApplicationControlProvider;

/**
 * A factory for creating ApplicationUIControl objects.
 */
public class ApplicationUIControlFactory implements IApplicationControlProvider {

	@Override
	public IApplicationControl get() {
		return ApplicationControl.getInstance();
	}

}