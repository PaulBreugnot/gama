/*******************************************************************************************************
 *
 * ContactProcessedCallback.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package com.bulletphysics;

import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.narrowphase.ManifoldPoint;

/**
 * Called when existing contact between two collision objects has been processed.
 *
 * @author jezek2
 * @see BulletGlobals#setContactProcessedCallback
 */
public interface ContactProcessedCallback {

	/**
	 * Contact processed.
	 *
	 * @param cp the cp
	 * @param body0 the body 0
	 * @param body1 the body 1
	 * @return true, if successful
	 */
	boolean contactProcessed(ManifoldPoint cp, CollisionObject body0, CollisionObject body1);

}
