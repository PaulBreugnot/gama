/*******************************************************************************************************
 *
 * StringObject.java, in gama.display.opengl, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.display.opengl.scene.text;

import gama.display.opengl.scene.AbstractObject;
import gaml.statements.draw.TextDrawingAttributes;

/**
 * The Class StringObject.
 */
public class StringObject extends AbstractObject<String, TextDrawingAttributes> {

	/**
	 * Instantiates a new string object.
	 *
	 * @param string the string
	 * @param attributes the attributes
	 */
	public StringObject(final String string, final TextDrawingAttributes attributes) {
		super(string, attributes, DrawerType.STRING);
	}

}
