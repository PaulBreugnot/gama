/*********************************************************************************************
 *
 * 'ThreadedOverlayUpdater.java, in plugin ummisco.gama.ui.experiment, is part of the source code of the
 * GAMA modeling and simulation platform.
 * (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 * 
 *
 **********************************************************************************************/
package gama.ui.experiment.views.displays;

import gama.common.ui.IOverlayProvider;
import gama.outputs.layers.OverlayStatement.OverlayInfo;
import gama.ui.base.utils.ThreadedUpdater;

public class ThreadedOverlayUpdater extends ThreadedUpdater<OverlayInfo> implements IOverlayProvider<OverlayInfo> {

	public ThreadedOverlayUpdater(final DisplayOverlay displayOverlay) {
		super("Overlay refresh");
		setTarget(displayOverlay, null);
	}

}