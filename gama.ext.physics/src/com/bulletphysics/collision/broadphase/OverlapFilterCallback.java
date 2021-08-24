/*******************************************************************************************************
 *
 * OverlapFilterCallback.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package com.bulletphysics.collision.broadphase;

/**
 * Callback for filtering broadphase collisions.
 *
 * @author jezek2
 * @see OverlappingPairCache#setOverlapFilterCallback
 */
@FunctionalInterface
public interface OverlapFilterCallback {

	/**
	 * Checks if given pair of collision objects needs collision.
	 *
	 * @param proxy0
	 *            first object
	 * @param proxy1
	 *            second object
	 * @return true when pairs need collision
	 */
	boolean needBroadphaseCollision(BroadphaseProxy proxy0, BroadphaseProxy proxy1);

}
