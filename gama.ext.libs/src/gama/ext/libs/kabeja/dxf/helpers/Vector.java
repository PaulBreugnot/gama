/*******************************************************************************************************
 *
 * Vector.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.helpers;


/**
 * The Class Vector.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class Vector extends Point {
    
    /**
     * Instantiates a new vector.
     */
    public Vector() {
        super();
    }

    /**
     * Instantiates a new vector.
     *
     * @param p the p
     */
    public Vector(Point p) {
        super(p.getX(), p.getY(), p.getZ());
    }

    /**
     * Instantiates a new vector.
     *
     * @param x the x
     * @param y the y
     * @param z the z
     */
    public Vector(double x, double y, double z) {
        super(x, y, z);
    }

    /**
     * Gets the length.
     *
     * @return the length
     */
    public double getLength() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    /**
     * Normalize.
     */
    public void normalize() {
        double r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        x = x / r;
        y = y / r;
        z = z / r;
    }
}
