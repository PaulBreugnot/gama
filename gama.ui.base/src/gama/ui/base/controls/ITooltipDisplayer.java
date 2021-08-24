/*******************************************************************************************************
 *
 * ITooltipDisplayer.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.controls;

import gama.ui.base.resources.GamaColors.GamaUIColor;

/**
 * The class ITooltipDisplayer. 
 *
 * @author drogoul
 * @since 8 déc. 2014
 *
 */
public interface ITooltipDisplayer {

	/**
	 * Stop displaying tooltips.
	 */
	public abstract void stopDisplayingTooltips();

	/**
	 * Display tooltip.
	 *
	 * @param text the text
	 * @param color the color
	 */
	public abstract void displayTooltip(String text, GamaUIColor color);

}