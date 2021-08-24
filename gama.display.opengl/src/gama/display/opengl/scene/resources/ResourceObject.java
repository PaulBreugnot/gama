/*******************************************************************************************************
 *
 * ResourceObject.java, in gama.display.opengl, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.display.opengl.scene.resources;

import gama.display.opengl.scene.AbstractObject;
import gama.display.opengl.scene.AbstractObject.DrawerType;
import gama.util.file.GamaGeometryFile;
import gaml.statements.draw.DrawingAttributes;

/**
 * The Class ResourceObject.
 */
public class ResourceObject extends AbstractObject<GamaGeometryFile, DrawingAttributes> {

	/**
	 * Instantiates a new resource object.
	 *
	 * @param file the file
	 * @param attributes the attributes
	 */
	public ResourceObject(final GamaGeometryFile file, final DrawingAttributes attributes) {
		super(file, attributes, DrawerType.RESOURCE);
	}

}
