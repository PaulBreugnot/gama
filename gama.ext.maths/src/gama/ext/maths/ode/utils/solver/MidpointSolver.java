/*******************************************************************************************************
 *
 * MidpointSolver.java, in gama.ext.maths, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.maths.ode.utils.solver;

import org.apache.commons.math3.ode.nonstiff.MidpointIntegrator;

import gama.util.IList;
import gama.util.IMap;

/**
 * The Class MidpointSolver.
 */
public class MidpointSolver extends Solver {

	/**
	 * Instantiates a new midpoint solver.
	 *
	 * @param step the step
	 * @param integrated_val the integrated val
	 */
	public MidpointSolver(final double step, final IMap<String, IList<Double>> integrated_val) {
		super(step, new MidpointIntegrator(step), integrated_val);
	}

}
