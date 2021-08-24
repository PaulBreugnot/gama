/*******************************************************************************************************
 *
 * ParticleRaycastCallback.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package org.jbox2d.callbacks;

import org.jbox2d.common.Vec2;

/**
 * The Interface ParticleRaycastCallback.
 */
public interface ParticleRaycastCallback {
  
  /**
   * Called for each particle found in the query. See
   * {@link RayCastCallback#reportFixture(org.jbox2d.dynamics.Fixture, Vec2, Vec2, float)} for
   * argument info.
   *
   * @param index the index
   * @param point the point
   * @param normal the normal
   * @param fraction the fraction
   * @return the float
   */
  float reportParticle(int index, Vec2 point, Vec2 normal, float fraction);

}
