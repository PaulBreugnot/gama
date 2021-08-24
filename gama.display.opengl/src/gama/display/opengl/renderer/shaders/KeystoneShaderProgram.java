/*******************************************************************************************************
 *
 * KeystoneShaderProgram.java, in gama.display.opengl, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.display.opengl.renderer.shaders;

import com.jogamp.opengl.GL2;

/**
 * The Class KeystoneShaderProgram.
 */
public class KeystoneShaderProgram extends AbstractPostprocessingShader {

	/**
	 * Instantiates a new keystone shader program.
	 *
	 * @param gl the gl
	 * @param vertexFile the vertex file
	 * @param fragmentFile the fragment file
	 */
	public KeystoneShaderProgram(final GL2 gl, final String vertexFile, final String fragmentFile) {
		super(gl, vertexFile, fragmentFile);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(UVMAPPING_ATTRIBUTE_IDX, "attribute_TextureCoords3D");
	}
}
