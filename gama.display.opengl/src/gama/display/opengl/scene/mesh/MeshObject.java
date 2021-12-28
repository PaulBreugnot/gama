/*******************************************************************************************************
 *
 * MeshObject.java, in gama.display.opengl, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.display.opengl.scene.mesh;

import gama.display.opengl.scene.AbstractObject;
import gama.util.matrix.IField;
import gaml.statements.draw.DrawingAttributes.DrawerType;
import gaml.statements.draw.MeshDrawingAttributes;

// TODO: Auto-generated Javadoc
/**
 * The Class MeshObject.
 */
public class MeshObject extends AbstractObject<IField, MeshDrawingAttributes> {

	/**
	 * Instantiates a new mesh object.
	 *
	 * @param dem
	 *            the dem
	 * @param attributes
	 *            the attributes
	 */
	public MeshObject(final IField dem, final MeshDrawingAttributes attributes) {
		super(dem, attributes, DrawerType.MESH);
	}

}
