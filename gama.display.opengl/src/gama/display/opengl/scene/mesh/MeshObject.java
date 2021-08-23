/*******************************************************************************************************
 *
 * ummisco.gama.opengl.scene.FieldObject.java, in plugin ummisco.gama.opengl, is part of the source code of the GAMA
 * modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.display.opengl.scene.mesh;

import gama.display.opengl.scene.AbstractObject;
import gama.display.opengl.scene.AbstractObject.DrawerType;
import gama.util.matrix.IField;
import gaml.statements.draw.MeshDrawingAttributes;

public class MeshObject extends AbstractObject<IField, MeshDrawingAttributes> {

	public MeshObject(final IField dem, final MeshDrawingAttributes attributes) {
		super(dem, attributes, DrawerType.MESH);
	}

}
