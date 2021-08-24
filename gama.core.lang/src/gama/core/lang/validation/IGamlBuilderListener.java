/*******************************************************************************************************
 *
 * IGamlBuilderListener.java, in gama.core.lang, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.lang.validation;

import gaml.descriptions.IDescription;
import gaml.descriptions.ValidationContext;

/**
 * The class IGamlBuilder.
 * 
 * @author drogoul
 * @since 2 mars 2012
 * 
 */
public interface IGamlBuilderListener {

	/**
	 * Validation ended.
	 *
	 * @param experiments the experiments
	 * @param status the status
	 */
	void validationEnded(final Iterable<? extends IDescription> experiments, final ValidationContext status);
}
