/*********************************************************************************************
 *
 * 'LutherSolver.java, in plugin ummisco.gaml.extensions.maths, is part of the source code of the
 * GAMA modeling and simulation platform.
 * (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 * 
 *
 **********************************************************************************************/
package gama.ext.maths.ode.utils.solver;

import java.util.List;


import org.apache.commons.math3.ode.nonstiff.LutherIntegrator;

import gama.util.IList;
import gama.util.IMap;

public class LutherSolver extends Solver {

	public LutherSolver(final double step, final IMap<String, IList<Double>> integrated_val) {
		super(step, new LutherIntegrator(step), integrated_val);
	}

}
