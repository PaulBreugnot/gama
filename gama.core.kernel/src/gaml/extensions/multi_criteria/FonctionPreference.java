/*******************************************************************************************************
 *
 * FonctionPreference.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extensions.multi_criteria;

/**
 * The Interface FonctionPreference.
 */
public interface FonctionPreference {

	/**
	 * Valeur.
	 *
	 * @param diff the diff
	 * @return the double
	 */
	public double valeur(double diff);

	/**
	 * Copie.
	 *
	 * @return the fonction preference
	 */
	public FonctionPreference copie();
}
