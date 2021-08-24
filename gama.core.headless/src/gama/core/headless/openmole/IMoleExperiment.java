/*******************************************************************************************************
 *
 * IMoleExperiment.java, in gama.core.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.headless.openmole;

import gama.core.headless.core.IExperiment;

/**
 * The Interface IMoleExperiment.
 */
public interface IMoleExperiment extends IExperiment
{
    
    /**
     * Play.
     *
     * @param finalStep the final step
     */
    //keep to ensure compatibility with openMole	
	void play(int finalStep);
	
	/**
	 * Play.
	 *
	 * @param exp the exp
	 * @param finalStep the final step
	 */
	void play(String exp, int finalStep);
}