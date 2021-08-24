/*******************************************************************************************************
 *
 * IStatusDisplayer.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.ui;

import gama.util.GamaColor;

/**
 * The Interface IStatusDisplayer.
 */
public interface IStatusDisplayer {

	/**
	 * Resume status.
	 */
	void resumeStatus();

	/**
	 * Wait status.
	 *
	 * @param string the string
	 */
	void waitStatus(String string);

	/**
	 * Inform status.
	 *
	 * @param string the string
	 */
	void informStatus(String string);

	/**
	 * Error status.
	 *
	 * @param message the message
	 */
	void errorStatus(String message);

	/**
	 * Sets the sub status completion.
	 *
	 * @param status the new sub status completion
	 */
	void setSubStatusCompletion(double status);

	/**
	 * Sets the status.
	 *
	 * @param msg the msg
	 * @param color the color
	 */
	void setStatus(String msg, GamaColor color);

	/**
	 * Inform status.
	 *
	 * @param message the message
	 * @param icon the icon
	 */
	void informStatus(String message, String icon);

	/**
	 * Sets the status.
	 *
	 * @param msg the msg
	 * @param icon the icon
	 */
	void setStatus(String msg, String icon);

	/**
	 * Begin sub status.
	 *
	 * @param name the name
	 */
	void beginSubStatus(String name);

	/**
	 * End sub status.
	 *
	 * @param name the name
	 */
	void endSubStatus(String name);

	/**
	 * Neutral status.
	 *
	 * @param string the string
	 */
	void neutralStatus(String string);

}
