/*******************************************************************************************************
 *
 * GridVonNeumannNeighborhood.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.metamodel.topology.grid;

import java.util.HashSet;
import java.util.Set;

/**
 * Written by drogoul Modified on 8 mars 2011.
 *
 * @todo Description
 */
public class GridVonNeumannNeighborhood extends GridNeighborhood {

	/**
	 * Instantiates a new grid von neumann neighborhood.
	 *
	 * @param matrix the matrix
	 */
	GridVonNeumannNeighborhood(final GamaSpatialMatrix matrix) {
		super(matrix);
	}

	@Override
	protected Set<Integer> getNeighborsAtRadius(final int placeIndex, final int radius) {
		final int y = placeIndex / matrix.numCols;
		final int x = placeIndex - y * matrix.numCols;
		// TODO: verify the use of HashSet here, contradictory with the policy of GAMA to not use unordered Sets or maps
		final Set<Integer> v = new HashSet<>(radius << 2);
		int p;
		for (int i = -radius; i < radius; i++) {
			p = matrix.getPlaceIndexAt(x - i, y - Math.abs(i) + radius);
			if (p != -1) {
				v.add(p);
			}
			p = matrix.getPlaceIndexAt(x + i, y + Math.abs(i) - radius);
			if (p != -1) {
				v.add(p);
			}
		}
		return v;
	}

	@Override
	public boolean isVN() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.metamodel.topology.grid.INeighborhood#clear()
	 */
	@Override
	public void clear() {}
}