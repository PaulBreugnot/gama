/*******************************************************************************************************
 *
 * IBenchmarkable.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.interfaces;

/**
 * Represents objects that can be used in benchmarking operations (see {@link gama.runtime.benchmark.Benchmark})
 * 
 * @author drogoul
 * @since July 2018
 *
 */

public interface IBenchmarkable {

	/**
	 * Returns a human-readable name for benchmark results.
	 *
	 * @return a string representing this object in benchmark results
	 */
	public String getNameForBenchmarks();

}
