/*******************************************************************************************************
 *
 * OverlayLayerData.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.outputs.layers;

import java.awt.Color;

import gama.common.interfaces.IKeyword;
import gama.common.ui.IGraphics;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaColor;
import gaml.types.Types;

/**
 * The Class OverlayLayerData.
 */
public class OverlayLayerData extends LayerData {

	/** The border. */
	final Attribute<GamaColor> border;
	
	/** The background. */
	final Attribute<GamaColor> background;
	
	/** The rounded. */
	final Attribute<Boolean> rounded;
	
	/** The computed. */
	boolean computed;

	/**
	 * Instantiates a new overlay layer data.
	 *
	 * @param def the def
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public OverlayLayerData(final ILayerStatement def) throws GamaRuntimeException {
		super(def);
		border = create(IKeyword.BORDER, Types.COLOR, null);
		background = create(IKeyword.BACKGROUND, Types.COLOR, new GamaColor(Color.black));
		rounded = create(IKeyword.ROUNDED, Types.BOOL, true);
	}

	/**
	 * Gets the background color.
	 *
	 * @param scope the scope
	 * @return the background color
	 */
	public Color getBackgroundColor(final IScope scope) {
		return new Color(background.get().getRed(), background.get().getGreen(), background.get().getBlue(),
				(int) ((1 - getTransparency(scope)) * 255));
	}

	@Override
	public void computePixelsDimensions(final IGraphics g) {
		if (computed) { return; }
		super.computePixelsDimensions(g);
		computed = true;
	}

	/**
	 * Gets the border color.
	 *
	 * @return the border color
	 */
	public Color getBorderColor() {
		return border.get();
	}

	/**
	 * Checks if is rounded.
	 *
	 * @return true, if is rounded
	 */
	public boolean isRounded() {
		return rounded.get();
	}

}
