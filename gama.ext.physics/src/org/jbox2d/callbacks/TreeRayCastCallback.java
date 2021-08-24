/*******************************************************************************************************
 *
 * TreeRayCastCallback.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package org.jbox2d.callbacks;

import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.broadphase.DynamicTree;

// updated to rev 100

/**
 * callback for {@link DynamicTree}.
 *
 * @author Daniel Murphy
 */
public interface TreeRayCastCallback {
	
	/**
	 * Raycast callback.
	 *
	 * @param input the input
	 * @param nodeId the node id
	 * @return the fraction to the node
	 */
	public float raycastCallback( RayCastInput input, int nodeId);
}
