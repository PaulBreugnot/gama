/*******************************************************************************************************
 *
 * ActionInterface.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package com.bulletphysics.dynamics;

import com.bulletphysics.collision.dispatch.CollisionWorld;

/**
 * Basic interface to allow actions such as vehicles and characters to be updated inside a {@link DynamicsWorld}.
 *
 * @author tomrbryn
 */
public abstract class ActionInterface {

	/**
	 * Update action.
	 *
	 * @param collisionWorld the collision world
	 * @param deltaTimeStep the delta time step
	 */
	public abstract void updateAction(CollisionWorld collisionWorld, float deltaTimeStep);

}
