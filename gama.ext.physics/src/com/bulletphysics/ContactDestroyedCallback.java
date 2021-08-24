/*******************************************************************************************************
 *
 * ContactDestroyedCallback.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package com.bulletphysics;

/**
 * Called when contact has been destroyed between two collision objects.
 *
 * @author jezek2
 * @see BulletGlobals#setContactDestroyedCallback
 */
public interface ContactDestroyedCallback {

	/**
	 * Contact destroyed.
	 *
	 * @param userPersistentData the user persistent data
	 * @return true, if successful
	 */
	boolean contactDestroyed(Object userPersistentData);

}
