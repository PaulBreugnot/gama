/*******************************************************************************************************
 *
 * OpenGLDisplayView.java, in gama.display.opengl, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.display.opengl.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;

import gama.core.dev.utils.DEBUG;
import gama.display.opengl.renderer.helpers.CameraHelper;
import gama.runtime.GAMA;
import gama.ui.experiment.views.displays.SWTDisplayView;

/**
 * Class OpenGLLayeredDisplayView.
 *
 * @author drogoul
 * @since 25 mars 2015
 *
 */
public class OpenGLDisplayView extends SWTDisplayView {

	{
		DEBUG.OFF();
	}

	@Override
	public SWTOpenGLDisplaySurface getDisplaySurface() {
		return (SWTOpenGLDisplaySurface) super.getDisplaySurface();
	}

	@Override
	protected Composite createSurfaceComposite(final Composite parent) {
		final SWTOpenGLDisplaySurface surface =
				(SWTOpenGLDisplaySurface) GAMA.getGui().createDisplaySurfaceFor(getOutput(), parent);
		surfaceComposite = surface.renderer.getCanvas();
		surface.outputReloaded();
		return surfaceComposite;
	}

	@Override
	public boolean forceOverlayVisibility() {
		final SWTOpenGLDisplaySurface surface = getDisplaySurface();
		return surface != null && surface.getROIDimensions() != null;
	}

	@Override
	public List<String> getCameraNames() {
		return new ArrayList<>(CameraHelper.PRESETS.keySet());
	}

}
