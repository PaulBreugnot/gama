/*******************************************************************************************************
 *
 * IllegalDistributionCreation.java, in espacedev.gaml.extensions.genstar, is part of the source code of the
 * GAMA modeling and simulation platform (v.1.8.2).
 *
 * (c) 2007-2022 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gospl.distribution.exception;

/**
 * The Class IllegalDistributionCreation.
 */
public class IllegalDistributionCreation extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new illegal distribution creation.
	 *
	 * @param message the message
	 */
	public IllegalDistributionCreation(final String message) {
		super("issue regarding a set of Joint distribution\n" + message);
	}

}
