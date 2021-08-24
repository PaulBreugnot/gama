/*******************************************************************************************************
 *
 * CollisionAlgorithmConstructionInfo.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.narrowphase.PersistentManifold;

/**
 * Construction information for collision algorithms.
 * 
 * @author jezek2
 */
public class CollisionAlgorithmConstructionInfo {

	/** The dispatcher 1. */
	public Dispatcher dispatcher1;
	
	/** The manifold. */
	public PersistentManifold manifold;

	//public int getDispatcherId();
	
}
