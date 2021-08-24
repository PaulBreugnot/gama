/*******************************************************************************************************
 *
 * GrayscaleMeshColorProvider.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.statements.draw;

/**
 * The Class GrayscaleMeshColorProvider.
 */
public class GrayscaleMeshColorProvider implements IMeshColorProvider {

	@Override
	public double[] getColor(final int index, final double z, final double min, final double max, final double[] rgb) {
		double[] result = rgb;
		if (result == null) { result = new double[3]; }
		result[0] = result[1] = result[2] = (z - min) / (max - min);
		return result;
	}

}
