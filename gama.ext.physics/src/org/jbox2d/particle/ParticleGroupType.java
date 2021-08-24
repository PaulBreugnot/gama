/*******************************************************************************************************
 *
 * ParticleGroupType.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package org.jbox2d.particle;

/**
 * The Class ParticleGroupType.
 */
public class ParticleGroupType {
  
  /**  resists penetration. */
  public static final int b2_solidParticleGroup = 1 << 0;
  
  /**  keeps its shape. */
  public static final int b2_rigidParticleGroup = 1 << 1;
}
