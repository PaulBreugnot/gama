/*******************************************************************************************************
 *
 * IElement.java, in gama.build.processor, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.build.processor.doc;

/**
 * The Interface IElement.
 */
public interface IElement {
	
	/**
	 * Gets the element DOM.
	 *
	 * @return the element DOM
	 */
	public org.w3c.dom.Element getElementDOM();
}
