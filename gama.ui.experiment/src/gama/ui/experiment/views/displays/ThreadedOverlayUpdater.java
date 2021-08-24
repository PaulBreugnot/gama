/*******************************************************************************************************
 *
 * ThreadedOverlayUpdater.java, in gama.ui.experiment, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.experiment.views.displays;

import gama.common.ui.IOverlayProvider;
import gama.outputs.layers.OverlayStatement.OverlayInfo;
import gama.ui.base.utils.ThreadedUpdater;

/**
 * The Class ThreadedOverlayUpdater.
 */
public class ThreadedOverlayUpdater extends ThreadedUpdater<OverlayInfo> implements IOverlayProvider<OverlayInfo> {

	/**
	 * Instantiates a new threaded overlay updater.
	 *
	 * @param displayOverlay the display overlay
	 */
	public ThreadedOverlayUpdater(final DisplayOverlay displayOverlay) {
		super("Overlay refresh");
		setTarget(displayOverlay, null);
	}

}