/*******************************************************************************************************
 *
 * IRichExperiment.java, in gama.core.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.headless.core;

import gama.core.headless.job.ListenedVariable;
import gama.core.headless.job.ExperimentJob.OutputType;

/**
 * The Interface IRichExperiment.
 */
public interface IRichExperiment extends IExperiment{
	
	/**
	 * Gets the rich output.
	 *
	 * @param v the v
	 * @return the rich output
	 */
	public RichOutput getRichOutput(final ListenedVariable v);
	
	/**
	 * Gets the type of.
	 *
	 * @param name the name
	 * @return the type of
	 */
	public OutputType getTypeOf(final String name);
}
