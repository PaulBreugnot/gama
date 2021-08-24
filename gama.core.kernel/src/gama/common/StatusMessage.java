/*******************************************************************************************************
 *
 * StatusMessage.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common;

import gama.common.ui.IGui;
import gama.common.ui.IStatusMessage;
import gama.util.GamaColor;

/**
 * The Class StatusMessage.
 */
public class StatusMessage implements IStatusMessage {

	/** The message. */
	String message = "";
	
	/** The code. */
	protected int code = IGui.INFORM;
	
	/** The icon. */
	protected String icon;

	/**
	 * Instantiates a new status message.
	 *
	 * @param msg the msg
	 * @param s the s
	 */
	public StatusMessage(final String msg, final int s) {
		message = msg;
		code = s;
	}

	/**
	 * Instantiates a new status message.
	 *
	 * @param msg the msg
	 * @param s the s
	 * @param icon the icon
	 */
	public StatusMessage(final String msg, final int s, final String icon) {
		message = msg;
		this.icon = icon;
		code = s;
	}

	@Override
	public String getText() {
		return message;
	}

	@Override
	public int getCode() {
		return code;
	}

	/**
	 * Method getColor()
	 * 
	 * @see gama.common.ui.IStatusMessage#getColor()
	 */
	@Override
	public GamaColor getColor() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see msi.gama.common.IStatusMessage#getIcon()
	 */
	@Override
	public String getIcon() {
		return icon;
	}

}