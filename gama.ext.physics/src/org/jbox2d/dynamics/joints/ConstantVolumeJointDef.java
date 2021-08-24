/*******************************************************************************************************
 *
 * ConstantVolumeJointDef.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package org.jbox2d.dynamics.joints;

import java.util.ArrayList;

import org.jbox2d.dynamics.Body;

/**
 * Definition for a {@link ConstantVolumeJoint}, which connects a group a bodies together so they
 * maintain a constant volume within them.
 */
public class ConstantVolumeJointDef extends JointDef {
  
  /** The frequency hz. */
  public float frequencyHz;
  
  /** The damping ratio. */
  public float dampingRatio;

  /** The bodies. */
  ArrayList<Body> bodies;
  
  /** The joints. */
  ArrayList<DistanceJoint> joints;

  /**
   * Instantiates a new constant volume joint def.
   */
  public ConstantVolumeJointDef() {
    super(JointType.CONSTANT_VOLUME);
    bodies = new ArrayList<Body>();
    joints = null;
    collideConnected = false;
    frequencyHz = 0.0f;
    dampingRatio = 0.0f;
  }

  /**
   * Adds a body to the group.
   *
   * @param argBody the arg body
   */
  public void addBody(Body argBody) {
    bodies.add(argBody);
    if (bodies.size() == 1) {
      bodyA = argBody;
    }
    if (bodies.size() == 2) {
      bodyB = argBody;
    }
  }

  /**
   * Adds a body and the pre-made distance joint. Should only be used for deserialization.
   *
   * @param argBody the arg body
   * @param argJoint the arg joint
   */
  public void addBodyAndJoint(Body argBody, DistanceJoint argJoint) {
    addBody(argBody);
    if (joints == null) {
      joints = new ArrayList<DistanceJoint>();
    }
    joints.add(argJoint);
  }
}
