/*******************************************************************************************************
 *
 * ScalarType.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package com.bulletphysics.collision.shapes;

/**
 * Scalar type, used when accessing triangle mesh data.
 * 
 * @author jezek2
 */
public enum ScalarType {
	
	/** The float. */
	FLOAT,
	
	/** The double. */
	DOUBLE,
	
	/** The integer. */
	INTEGER,
	
	/** The short. */
	SHORT,
	
	/** The fixedpoint88. */
	FIXEDPOINT88
}
