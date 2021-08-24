/*******************************************************************************************************
 *
 * BroadPhaseStrategy.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package org.jbox2d.collision.broadphase;

import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.callbacks.TreeCallback;
import org.jbox2d.callbacks.TreeRayCastCallback;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.common.Vec2;

/**
 * The Interface BroadPhaseStrategy.
 */
public interface BroadPhaseStrategy {

  /**
   * Create a proxy. Provide a tight fitting AABB and a userData pointer.
   *
   * @param aabb the aabb
   * @param userData the user data
   * @return the int
   */
  int createProxy(AABB aabb, Object userData);

  /**
   * Destroy a proxy.
   *
   * @param proxyId the proxy id
   */
  void destroyProxy(int proxyId);

  /**
   * Move a proxy with a swepted AABB. If the proxy has moved outside of its fattened AABB, then the
   * proxy is removed from the tree and re-inserted. Otherwise the function returns immediately.
   *
   * @param proxyId the proxy id
   * @param aabb the aabb
   * @param displacement the displacement
   * @return true if the proxy was re-inserted.
   */
  boolean moveProxy(int proxyId, AABB aabb, Vec2 displacement);
  
  /**
   * Gets the user data.
   *
   * @param proxyId the proxy id
   * @return the user data
   */
  Object getUserData(int proxyId);

  /**
   * Gets the fat AABB.
   *
   * @param proxyId the proxy id
   * @return the fat AABB
   */
  AABB getFatAABB(int proxyId);

  /**
   * Query an AABB for overlapping proxies. The callback class is called for each proxy that
   * overlaps the supplied AABB.
   *
   * @param callback the callback
   * @param aabb the aabb
   */
  void query(TreeCallback callback, AABB aabb);

  /**
   * Ray-cast against the proxies in the tree. This relies on the callback to perform a exact
   * ray-cast in the case were the proxy contains a shape. The callback also performs the any
   * collision filtering. This has performance roughly equal to k * log(n), where k is the number of
   * collisions and n is the number of proxies in the tree.
   *
   * @param callback a callback class that is called for each proxy that is hit by the ray.
   * @param input the ray-cast input data. The ray extends from p1 to p1 + maxFraction * (p2 - p1).
   */
  void raycast(TreeRayCastCallback callback, RayCastInput input);

  /**
   * Compute the height of the tree.
   *
   * @return the int
   */
  int computeHeight();

  /**
   * Compute the height of the binary tree in O(N) time. Should not be called often.
   *
   * @return the height
   */
  int getHeight();

  /**
   * Get the maximum balance of an node in the tree. The balance is the difference in height of the
   * two children of a node.
   *
   * @return the max balance
   */
  int getMaxBalance();

  /**
   * Get the ratio of the sum of the node areas to the root area.
   *
   * @return the area ratio
   */
  float getAreaRatio();

  /**
   * Draw tree.
   *
   * @param draw the draw
   */
  void drawTree(DebugDraw draw);
}