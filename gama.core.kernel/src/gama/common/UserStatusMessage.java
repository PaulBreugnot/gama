/*******************************************************************************************************
 *
 * UserStatusMessage.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common;

import gama.common.ui.IGui;
import gama.util.GamaColor;

/**
 * Class UserStatusMessage.
 *
 * @author drogoul
 * @since 11 mars 2015
 *
 */
public class UserStatusMessage extends StatusMessage {

	/** The color. */
	GamaColor color;

	/**
	 * Instantiates a new user status message.
	 *
	 * @param msg the msg
	 * @param color the color
	 * @param icon the icon
	 */
	public UserStatusMessage(final String msg, final GamaColor color, final String icon) {
		super(msg, IGui.USER);
		this.color = color;
		this.icon = icon;
	}

	@Override
	public GamaColor getColor() {
		return color;
	}

	@Override
	public String getIcon() {
		return icon;
	}

}
