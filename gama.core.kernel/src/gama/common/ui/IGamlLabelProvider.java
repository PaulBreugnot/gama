/*******************************************************************************************************
 *
 * IGamlLabelProvider.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.ui;

import gaml.compilation.ast.ISyntacticElement;

/**
 * The Interface IGamlLabelProvider.
 */
public interface IGamlLabelProvider {

	/**
	 * Gets the text.
	 *
	 * @param element the element
	 * @return the text
	 */
	String getText(ISyntacticElement element);

	/**
	 * Gets the image.
	 *
	 * @param element the element
	 * @return the image
	 */
	Object getImage(ISyntacticElement element);

}
