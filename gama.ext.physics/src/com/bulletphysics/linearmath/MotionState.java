/*******************************************************************************************************
 *
 * MotionState.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package com.bulletphysics.linearmath;

/**
 * MotionState allows the dynamics world to synchronize the updated world transforms with graphics. For optimizations,
 * potentially only moving objects get synchronized (using {@link #setWorldTransform setWorldTransform} method).
 *
 * @author jezek2
 */

public interface MotionState {

	/**
	 * Returns world transform.
	 *
	 * @param out the out
	 * @return the world transform
	 */
	Transform getWorldTransform(Transform out);

	/**
	 * Sets world transform. This method is called by JBullet whenever an active object represented by this MotionState
	 * is moved or rotated.
	 *
	 * @param worldTrans the new world transform
	 */
	void setWorldTransform(Transform worldTrans);

}
