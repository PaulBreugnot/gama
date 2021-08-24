/*******************************************************************************************************
 *
 * ConstraintSolver.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package com.bulletphysics.dynamics.constraintsolver;

import java.util.ArrayList;

import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.narrowphase.PersistentManifold;

/**
 * Abstract class for constraint solvers.
 *
 * @author jezek2
 */
public interface ConstraintSolver {

	// protected final BulletStack stack = BulletStack.get();

	/**
	 * Prepare solve.
	 *
	 * @param numBodies the num bodies
	 * @param numManifolds the num manifolds
	 */
	default void prepareSolve(final int numBodies, final int numManifolds) {}

	/**
	 * Solve a group of constraints.
	 *
	 * @param bodies the bodies
	 * @param numBodies the num bodies
	 * @param manifold the manifold
	 * @param manifold_offset the manifold offset
	 * @param numManifolds the num manifolds
	 * @param constraints the constraints
	 * @param constraints_offset the constraints offset
	 * @param numConstraints the num constraints
	 * @param info the info
	 * @param dispatcher the dispatcher
	 * @return the float
	 */
	float solveGroup(ArrayList<CollisionObject> bodies, int numBodies, ArrayList<PersistentManifold> manifold,
			int manifold_offset, int numManifolds, ArrayList<TypedConstraint> constraints, int constraints_offset,
			int numConstraints, ContactSolverInfo info/* , btStackAlloc* stackAlloc */, Dispatcher dispatcher);

	/**
	 * All solved.
	 *
	 * @param info the info
	 */
	default void allSolved(final ContactSolverInfo info/* , btStackAlloc* stackAlloc */) {}

	/**
	 * Clear internal cached data and reset random seed.
	 */
	void reset();

}
