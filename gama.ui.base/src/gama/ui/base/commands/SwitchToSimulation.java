/*******************************************************************************************************
 *
 * SwitchToSimulation.java, in gama.ui.base, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.base.commands;

import gama.ui.base.utils.PerspectiveHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class SwitchToSimulation.
 */
public class SwitchToSimulation extends SwitchToHandler {

	/**
	 * Execute.
	 */
	@Override
	public void execute() {
		PerspectiveHelper.switchToSimulationPerspective();
	}
}
