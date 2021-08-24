/*******************************************************************************************************
 *
 * StoppingCriterionMaxIt.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.Map;

/**
 * The Class StoppingCriterionMaxIt.
 */
public class StoppingCriterionMaxIt implements StoppingCriterion {

	/** The max it. */
	private final int maxIt;

	/**
	 * Instantiates a new stopping criterion max it.
	 *
	 * @param maxIt the max it
	 */
	public StoppingCriterionMaxIt(final int maxIt) {
		super();
		this.maxIt = maxIt;
	}

	@Override
	@SuppressWarnings("boxing")
	public boolean stopSearchProcess(final Map<String, Object> parameters) {
		return (Integer) parameters.get("Iteration") > maxIt;
	}

}
