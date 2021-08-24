/*******************************************************************************************************
 *
 * DynamicsWorldType.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package com.bulletphysics.dynamics;

/**
 * Dynamics world type.
 * 
 * @author jezek2
 */
public enum DynamicsWorldType {
	
	/** The simple dynamics world. */
	SIMPLE_DYNAMICS_WORLD,
	
	/** The discrete dynamics world. */
	DISCRETE_DYNAMICS_WORLD,
	
	/** The continuous dynamics world. */
	CONTINUOUS_DYNAMICS_WORLD
}
