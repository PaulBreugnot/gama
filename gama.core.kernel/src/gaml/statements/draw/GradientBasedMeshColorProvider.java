/*******************************************************************************************************
 *
 * GradientBasedMeshColorProvider.java, in gama.core.kernel, is part of the source code of the GAMA modeling and
 * simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.statements.draw;

import gama.core.dev.utils.DEBUG;
import gama.util.GamaColor;
import gaml.operators.Colors.GamaGradient;

// TODO: Auto-generated Javadoc
/**
 * The Class GradientBasedMeshColorProvider.
 */
public class GradientBasedMeshColorProvider implements IMeshColorProvider {

	/** The RGB + stop components. */
	final double[] components;

	/** The size. */
	final int size;

	/**
	 * Instantiates a new gradient based mesh color provider.
	 *
	 * @param palette
	 *            the palette
	 */
	public GradientBasedMeshColorProvider(final GamaGradient palette) {
		// each pair color::float represents a stop from 0 to 1
		this.size = palette.size();

		components = new double[size * 4]; // last value is the stop position

		int i = 0;
		for (GamaColor c : palette.keySet()) {
			components[i * 4] = c.getRed() / 255d;
			components[i * 4 + 1] = c.getGreen() / 255d;
			components[i * 4 + 2] = c.getBlue() / 255d;
			components[i * 4 + 3] = palette.get(c);
			i++;
		}
	}

	/**
	 * Gets the color.
	 *
	 * @param index the index
	 * @param z the z
	 * @param min the min
	 * @param max the max
	 * @param rgb the rgb
	 * @return the color
	 */
	@Override
	public double[] getColor(final int index, final double z, final double min, final double max, final double[] rgb) {
		double[] result = rgb;
		if (result == null) { result = new double[3]; }
		double position = (z - min) / (max - min);
		// DEBUG.OUT("Position " + position + " corresponds to slot ", false);
		for (int s = 0; s < size - 1; s++) {
			var leftStop = components[s * 4 + 3];
			var rightStop = components[(s + 1) * 4 + 3];
			if (position <= leftStop) {
				// DEBUG.OUT(s);
				result[0] = components[4 * s];
				result[1] = components[4 * s + 1];
				result[2] = components[4 * s + 2];
				return result;
			}
			if (position < rightStop) {
				double r = (position - leftStop) / (rightStop - leftStop);
				DEBUG.OUT(s + " with a ratio of " + r);
				double ir = 1d - r;
				result[0] = components[s * 4] * ir + components[(s + 1) * 4] * r;
				result[1] = components[s * 4 + 1] * ir + components[(s + 1) * 4 + 1] * r;
				result[2] = components[s * 4 + 2] * ir + components[(s + 1) * 4 + 2] * r;
				return result;
			}
		}
		// DEBUG.OUT(size - 1);
		result[0] = components[4 * (size - 1)];
		result[1] = components[4 * (size - 1) + 1];
		result[2] = components[4 * (size - 1) + 2];
		return result;

	}

}
