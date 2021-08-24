/*******************************************************************************************************
 *
 * IConsoleDisplayer.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.ui;

import gama.kernel.experiment.ITopLevelAgent;
import gama.util.GamaColor;

/**
 * The Interface IConsoleDisplayer.
 */
public interface IConsoleDisplayer {

	/**
	 * Debug console.
	 *
	 * @param cycle the cycle
	 * @param s the s
	 * @param root the root
	 * @param color the color
	 */
	void debugConsole(int cycle, String s, ITopLevelAgent root, GamaColor color);

	/**
	 * Debug console.
	 *
	 * @param cycle the cycle
	 * @param s the s
	 * @param root the root
	 */
	void debugConsole(int cycle, String s, ITopLevelAgent root);

	/**
	 * Inform console.
	 *
	 * @param s the s
	 * @param root the root
	 * @param color the color
	 */
	void informConsole(String s, ITopLevelAgent root, GamaColor color);

	/**
	 * Inform console.
	 *
	 * @param s the s
	 * @param root the root
	 */
	void informConsole(String s, ITopLevelAgent root);

	/**
	 * Show console view.
	 *
	 * @param agent the agent
	 */
	void showConsoleView(ITopLevelAgent agent);

	/**
	 * Erase console.
	 *
	 * @param setToNull the set to null
	 */
	public void eraseConsole(final boolean setToNull);
}
