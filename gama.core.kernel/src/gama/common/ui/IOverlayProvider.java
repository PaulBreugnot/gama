/*******************************************************************************************************
 *
 * IOverlayProvider.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.ui;

import gama.outputs.layers.OverlayStatement.OverlayInfo;

/**
 * Class IOverlay.
 *
 * @author drogoul
 * @param <C> the generic type
 * @since 9 mars 2014
 */
public interface IOverlayProvider<C extends OverlayInfo> {

	/**
	 * Sets the target.
	 *
	 * @param overlay the overlay
	 * @param surface the surface
	 */
	public void setTarget(IUpdaterTarget<C> overlay, IDisplaySurface surface);
}
