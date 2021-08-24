/*******************************************************************************************************
 *
 * IViewportTransform.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package org.jbox2d.common;

/**
 * This is the viewport transform used from drawing. Use yFlip if you are drawing from the top-left
 * corner.
 * 
 * @author Daniel
 */
public interface IViewportTransform {

  /**
   * Checks if is y flip.
   *
   * @return if the transform flips the y axis
   */
  boolean isYFlip();

  /**
   * Sets the y flip.
   *
   * @param yFlip if we flip the y axis when transforming
   */
  void setYFlip(boolean yFlip);

  /**
   * This is the half-width and half-height. This should be the actual half-width and half-height,
   * not anything transformed or scaled. Not a copy.
   *
   * @return the extents
   */
  Vec2 getExtents();

  /**
   * This sets the half-width and half-height. This should be the actual half-width and half-height,
   * not anything transformed or scaled.
   *
   * @param extents the new extents
   */
  void setExtents(Vec2 extents);

  /**
   * This sets the half-width and half-height of the viewport. This should be the actual half-width
   * and half-height, not anything transformed or scaled.
   *
   * @param halfWidth the half width
   * @param halfHeight the half height
   */
  void setExtents(float halfWidth, float halfHeight);

  /**
   * center of the viewport. Not a copy.
   *
   * @return the center
   */
  Vec2 getCenter();

  /**
   * sets the center of the viewport.
   *
   * @param pos the new center
   */
  void setCenter(Vec2 pos);

  /**
   * sets the center of the viewport.
   *
   * @param x the x
   * @param y the y
   */
  void setCenter(float x, float y);

  /**
   * Sets the transform's center to the given x and y coordinates, and using the given scale.
   *
   * @param x the x
   * @param y the y
   * @param scale the scale
   */
  void setCamera(float x, float y, float scale);

  /**
   * Transforms the given directional vector by the viewport transform (not positional).
   *
   * @param world the world
   * @param screen the screen
   * @return the world vector to screen
   */
  void getWorldVectorToScreen(Vec2 world, Vec2 screen);


  /**
   * Transforms the given directional screen vector back to the world direction.
   *
   * @param screen the screen
   * @param world the world
   * @return the screen vector to world
   */
  void getScreenVectorToWorld(Vec2 screen, Vec2 world);
  
  /**
   * Gets the mat 22 representation.
   *
   * @return the mat 22 representation
   */
  Mat22 getMat22Representation();


  /**
   * takes the world coordinate (world) puts the corresponding screen coordinate in screen. It
   * should be safe to give the same object as both parameters.
   *
   * @param world the world
   * @param screen the screen
   * @return the world to screen
   */
  void getWorldToScreen(Vec2 world, Vec2 screen);


  /**
   * takes the screen coordinates (screen) and puts the corresponding world coordinates in world. It
   * should be safe to give the same object as both parameters.
   *
   * @param screen the screen
   * @param world the world
   * @return the screen to world
   */
  void getScreenToWorld(Vec2 screen, Vec2 world);

  /**
   * Multiplies the viewport transform by the given Mat22.
   *
   * @param transform the transform
   */
  void mulByTransform(Mat22 transform);
}
