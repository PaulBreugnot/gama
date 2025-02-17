/*******************************************************************************************************
 *
 * Point4d.java, in simtools.gaml.extensions.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.1.9.3).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package javax.vecmath;


/**
 * A 4 element vector represented by double precision floating point
 * x,y,z,w coordinates.
 *
 */
public class Point4d extends Tuple4d implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    // Compatible with 1.1
    static final long serialVersionUID = 1733471895962736949L;


    /**
     * Constructs and initializes a Point4d from the specified xyzw coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     * @param w the w coordinate
     */
    public Point4d(double x, double y, double z, double w)
    {
        super(x,y,z,w);
    }

    /**
     * Constructs and initializes a Point4d from the coordinates contained
     * in the array.
     * @param p the array of length 4 containing xyzw in order
     */
    public Point4d(double[] p)
    {
        super(p);
    }


    /**
     * Constructs and initializes a Point4d from the specified Point4d.
     * @param p1 the Point4d containing the initialization x y z w data
     */
    public Point4d(Point4d p1)
    {
         super(p1);
    }


    /**
     * Constructs and initializes a Point4d from the specified Point4f.
     * @param p1 the Point4f containing the initialization x y z w data
     */
    public Point4d(Point4f p1)
    {
       super(p1);
    }


    /**
     * Constructs and initializes a Point4d from the specified Tuple4f.
     * @param t1 the Tuple4f containing the initialization x y z w data
     */
    public Point4d(Tuple4f t1)
    {
       super(t1);
    }


    /**
     * Constructs and initializes a Point4d from the specified Tuple4d.
     * @param t1 the Tuple4d containing the initialization x y z w data
     */
    public Point4d(Tuple4d t1)
    {
       super(t1);
    }


    /**
     * Constructs and initializes a Point4d from the specified Tuple3d.
     * The x,y,z components of this point are set to the corresponding
     * components of tuple t1.  The w component of this point
     * is set to 1.
     * @param t1 the tuple to be copied
     *
     * @since vecmath 1.2
     */
    public Point4d(Tuple3d t1) {
	super(t1.x, t1.y, t1.z, 1.0);
    }


    /**
     * Constructs and initializes a Point4d to (0,0,0,0).
     */
    public Point4d()
    {
       super();
    }


    /**
     * Sets the x,y,z components of this point to the corresponding
     * components of tuple t1.  The w component of this point
     * is set to 1.
     * @param t1 the tuple to be copied
     *
     * @since vecmath 1.2
     */
    public final void set(Tuple3d t1) {
	this.x = t1.x;
	this.y = t1.y;
	this.z = t1.z;
	this.w = 1.0;
    }


 /**
   * Returns the square of the distance between this point and point p1.
   * @param p1 the first point
   * @return the square of distance between this point and point p1
   */
    public final double distanceSquared(Point4d p1)
    {
      double dx, dy, dz, dw;

      dx = this.x-p1.x;
      dy = this.y-p1.y;
      dz = this.z-p1.z;
      dw = this.w-p1.w;
      return (dx*dx+dy*dy+dz*dz+dw*dw);
    }


  /**
   * Returns the distance between this point and point p1.
   * @param p1 the first point
   * @return the distance between these this point and point p1.
   */
    public final double distance(Point4d p1)
    {
      double dx, dy, dz, dw;

      dx = this.x-p1.x;
      dy = this.y-p1.y;
      dz = this.z-p1.z;
      dw = this.w-p1.w;
      return Math.sqrt(dx*dx+dy*dy+dz*dz+dw*dw);
    }


  /**
    * Computes the L-1 (Manhattan) distance between this point and
    * point p1.  The L-1 distance is equal to:
    *  abs(x1-x2) + abs(y1-y2) + abs(z1-z2) + abs(w1-w2).
    * @param p1 the other point
    * @return  the L-1 distance
    */
    public final double distanceL1(Point4d p1) {
	return Math.abs(this.x-p1.x) + Math.abs(this.y-p1.y) +
	    Math.abs(this.z-p1.z) + Math.abs(this.w-p1.w);
    }

    /**
     * Computes the L-infinite distance between this point and
     * point p1.  The L-infinite distance is equal to
     * MAX[abs(x1-x2), abs(y1-y2), abs(z1-z2), abs(w1-w2)].
     * @param p1 the other point
     * @return  the L-infinite distance
     */
    public final double distanceLinf(Point4d p1) {
	double t1, t2;
	t1 = Math.max( Math.abs(this.x-p1.x), Math.abs(this.y-p1.y));
	t2 = Math.max( Math.abs(this.z-p1.z), Math.abs(this.w-p1.w));

	return Math.max(t1,t2);
    }

  /**
    *  Multiplies each of the x,y,z components of the Point4d parameter
    *  by 1/w, places the projected values into this point, and places
    *  a 1 as the w parameter of this point.
    *  @param  p1  the source Point4d, which is not modified
    */
   public final void project(Point4d p1)
   {
     double oneOw;

     oneOw = 1/p1.w;
     x = p1.x*oneOw;
     y = p1.y*oneOw;
     z = p1.z*oneOw;
     w = 1.0;

   }


}
