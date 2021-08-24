/*******************************************************************************************************
 *
 * PHullResult.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package com.bulletphysics.linearmath.convexhull;

import com.bulletphysics.util.IntArrayList;
import java.util.ArrayList;
import javax.vecmath.Vector3f;

/**
 * The Class PHullResult.
 *
 * @author jezek2
 */
class PHullResult {
	
	/** The vcount. */
	public int vcount = 0;
	
	/** The index count. */
	public int indexCount = 0;
	
	/** The face count. */
	public int faceCount = 0;
	
	/** The vertices. */
	public ArrayList<Vector3f> vertices = null;
	
	/** The indices. */
	public IntArrayList indices = new IntArrayList();
	
}
