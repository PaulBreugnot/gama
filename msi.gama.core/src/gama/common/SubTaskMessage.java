/*******************************************************************************************************
 *
 * msi.gama.common.SubTaskMessage.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common;

import gama.common.ui.IGui;
import gama.common.ui.IStatusMessage;
import gama.util.GamaColor;

/**
 * Class SubTaskMessage.
 *
 * @author drogoul
 * @since 5 nov. 2014
 *
 */
public class SubTaskMessage implements IStatusMessage {

	Double completion;
	String name;
	Boolean beginOrEnd;

	public SubTaskMessage(final String name, final boolean begin) {
		this.name = name;
		completion = null;
		this.beginOrEnd = begin;
	}

	public SubTaskMessage(final Double completion) {
		this.completion = completion;
		this.beginOrEnd = null;
	}

	/**
	 * Method getText()
	 * 
	 * @see gama.common.ui.IStatusMessage#getText()
	 */
	@Override
	public String getText() {
		return name;
	}

	/**
	 * Method getCode()
	 * 
	 * @see gama.common.ui.IStatusMessage#getCode()
	 */
	@Override
	public int getCode() {
		return IGui.NEUTRAL;
	}

	public Double getCompletion() {
		return completion;
	}

	public Boolean getBeginOrEnd() {
		return beginOrEnd;
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
		return null;
	}

}
