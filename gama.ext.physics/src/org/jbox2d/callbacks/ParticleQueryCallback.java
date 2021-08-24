/*******************************************************************************************************
 *
 * ParticleQueryCallback.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package org.jbox2d.callbacks;

import org.jbox2d.dynamics.World;

/**
 * Callback class for AABB queries. See
 * {@link World#queryAABB(QueryCallback, org.jbox2d.collision.AABB)}.
 * 
 * @author dmurph
 * 
 */
public interface ParticleQueryCallback {
  
  /**
   * Called for each particle found in the query AABB.
   *
   * @param index the index
   * @return false to terminate the query.
   */
  boolean reportParticle(int index);
}
