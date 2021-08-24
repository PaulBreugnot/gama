/*******************************************************************************************************
 *
 * Bounds.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import gama.ext.libs.kabeja.dxf.helpers.Point;


/**
 * This class is a helper class and reflect a viewport of a entity/layer or
 * document.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class Bounds {
    
    /** The max x. */
    protected double max_x = Double.NEGATIVE_INFINITY;
    
    /** The min x. */
    protected double min_x = Double.POSITIVE_INFINITY;
    
    /** The max y. */
    protected double max_y = Double.NEGATIVE_INFINITY;
    
    /** The min y. */
    protected double min_y = Double.POSITIVE_INFINITY;
    
    /** The max z. */
    protected double max_z = Double.NEGATIVE_INFINITY;
    
    /** The min z. */
    protected double min_z = Double.POSITIVE_INFINITY;
    
    /** The set. */
    protected boolean set = true;

    /**
     * Instantiates a new bounds.
     */
    public Bounds() {
    }

    /**
     * Instantiates a new bounds.
     *
     * @param max_x the max x
     * @param min_x the min x
     * @param max_y the max y
     * @param min_y the min y
     * @param max_z the max z
     * @param min_z the min z
     */
    public Bounds(double max_x, double min_x, double max_y, double min_y,
        double max_z, double min_z) {
        this.max_x = max_x;
        this.min_x = min_x;
        this.max_y = max_y;
        this.min_y = min_y;
        this.max_z = max_z;
        this.min_z = min_z;
    }

    /**
     * Instantiates a new bounds.
     *
     * @param max_x the max x
     * @param min_x the min x
     * @param max_y the max y
     * @param min_y the min y
     */
    public Bounds(double max_x, double min_x, double max_y, double min_y) {
        this.max_x = max_x;
        this.min_x = min_x;
        this.max_y = max_y;
        this.min_y = min_y;
    }

    /**
     * Instantiates a new bounds.
     *
     * @param b the b
     */
    public Bounds(Bounds b) {
        this.max_x = b.getMaximumX();
        this.min_x = b.getMinimumX();
        this.max_y = b.getMaximumY();
        this.min_y = b.getMinimumY();
        this.max_z = b.getMaximumZ();
        this.min_z = b.getMinimumZ();
    }

    /**
     * Gets the maximum X.
     *
     * @return Returns the max_x.
     */
    public double getMaximumX() {
        return max_x;
    }

    /**
     * Sets the maximum X.
     *
     * @param max_x            The max_x to set.
     */
    public void setMaximumX(double max_x) {
        this.max_x = max_x;
    }

    /**
     * Gets the maximum Y.
     *
     * @return Returns the max_y.
     */
    public double getMaximumY() {
        return max_y;
    }

    /**
     * Sets the maximum Y.
     *
     * @param max_y            The max_y to set.
     */
    public void setMaximumY(double max_y) {
        this.max_y = max_y;
    }

    /**
     * Gets the minimum X.
     *
     * @return Returns the min_x.
     */
    public double getMinimumX() {
        return min_x;
    }

    /**
     * Sets the minimum X.
     *
     * @param min_x            The min_x to set.
     */
    public void setMinimumX(double min_x) {
        this.min_x = min_x;
    }

    /**
     * Gets the minimum Y.
     *
     * @return Returns the min_y.
     */
    public double getMinimumY() {
        return min_y;
    }

    /**
     * Sets the minimum Y.
     *
     * @param min_y            The min_y to set.
     */
    public void setMinimumY(double min_y) {
        this.min_y = min_y;
    }

    /**
     * Gets the minimum Z.
     *
     * @return the minimum Z
     */
    public double getMinimumZ() {
        return this.min_z;
    }

    /**
     * Sets the minimum Z.
     *
     * @param min_z the new minimum Z
     */
    public void setMinimumZ(double min_z) {
        this.min_z = min_z;
    }

    /**
     * Gets the maximum Z.
     *
     * @return the maximum Z
     */
    public double getMaximumZ() {
        return this.max_z;
    }

    /**
     * Sets the maximum Z.
     *
     * @param max_z the new maximum Z
     */
    public void setMaximumZ(double max_z) {
        this.max_z = max_z;
    }

    /**
     * Enlarge the Bounds to the given Bounds if they enlarge the area.
     *
     * @param bounds the bounds
     */
    public void addToBounds(Bounds bounds) {
        if (bounds.getMaximumX() > this.getMaximumX()) {
            this.setMaximumX(bounds.getMaximumX());
        }

        if (bounds.getMaximumY() > this.getMaximumY()) {
            this.setMaximumY(bounds.getMaximumY());
        }

        if (bounds.getMaximumZ() > this.getMaximumZ()) {
            this.setMaximumZ(bounds.getMaximumZ());
        }

        if (bounds.getMinimumX() < this.getMinimumX()) {
            this.setMinimumX(bounds.getMinimumX());
        }

        if (bounds.getMinimumY() < this.getMinimumY()) {
            this.setMinimumY(bounds.getMinimumY());
        }

        if (bounds.getMinimumZ() < this.getMinimumZ()) {
            this.setMinimumZ(bounds.getMinimumZ());
        }
    }

    /**
     * Enlarge the Bounds if the given bounds enlarge the coordinates.
     *
     * @param x the x
     * @param y the y
     * @param z the z
     */
    public void addToBounds(double x, double y, double z) {
        if (x > this.getMaximumX()) {
            this.setMaximumX(x);
        }

        if (x < this.getMinimumX()) {
            this.setMinimumX(x);
        }

        if (y > this.getMaximumY()) {
            this.setMaximumY(y);
        }

        if (y < this.getMinimumY()) {
            this.setMinimumY(y);
        }

        if (z < this.getMinimumZ()) {
            this.setMinimumZ(z);
        }

        if (z > this.getMaximumZ()) {
            this.setMaximumZ(z);
        }
    }

    /**
     * Adds the to bounds.
     *
     * @param p the p
     */
    public void addToBounds(Point p) {
        addToBounds(p.getX(), p.getY(), p.getZ());
    }

    /**
     * Gets the width.
     *
     * @return the width
     */
    public double getWidth() {
        return Math.abs(getMaximumX() - getMinimumX());
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    public double getHeight() {
        return Math.abs(getMaximumY() - getMinimumY());
    }

    /**
     * Gets the depth.
     *
     * @return the depth
     */
    public double getDepth() {
        return Math.abs(getMaximumZ() - getMinimumZ());
    }

    /**
     * Checks if is valid.
     *
     * @return Returns the set.
     */
    public boolean isValid() {
        //later 3D bounds
        //		if ((this.max_x == Double.NEGATIVE_INFINITY)
        //				|| (this.max_y == Double.NEGATIVE_INFINITY)
        //				|| (this.min_x == Double.POSITIVE_INFINITY)
        //				|| (this.min_y == Double.POSITIVE_INFINITY)
        //				|| (this.max_z == Double.NEGATIVE_INFINITY)
        //				|| (this.min_z == Double.POSITIVE_INFINITY)) {
        //			return false;
        //		}
        if ((this.max_x == Double.NEGATIVE_INFINITY) ||
                (this.max_y == Double.NEGATIVE_INFINITY) ||
                (this.min_x == Double.POSITIVE_INFINITY) ||
                (this.min_y == Double.POSITIVE_INFINITY)) {
            return false;
        }

        return set;
    }

    /**
     * Sets the valid.
     *
     * @param set            The set to set.
     */
    public void setValid(boolean set) {
        this.set = set;
    }

    /**
     * Debug.
     */
    public void debug() {
        System.out.println("DEBUG Bounds");
        System.out.println("MAX_x=" + max_x);
        System.out.println("MAX_y=" + max_y);
        System.out.println("MIN_x=" + min_x);
        System.out.println("MIN_y=" + min_y);
        System.out.println("Width=" + getWidth() + " Height:" + getHeight());
    }

    /**
     * Determines if the given bounding box part or inside the bounds.
     *
     * @param bounds the bounds
     * @return true if the bounding box is part or inside the bounds
     */
    public boolean contains(Bounds bounds) {
        if ((bounds.getMaximumX() <= this.min_x) ||
                (bounds.getMinimumX() >= this.max_x)) {
            // the given bounds are on the left or right side of the bounds
            return false;
        }

        if ((bounds.getMaximumY() <= this.min_y) ||
                (bounds.getMinimumY() >= this.max_y)) {
            // the given bounds are above or below
            return false;
        }

        return true;
    }

    /**
     * Contains.
     *
     * @param p the p
     * @return true, if successful
     */
    public boolean contains(Point p) {
        if ((this.min_x <= p.getX()) && (this.max_x >= p.getX())) {
            if ((this.min_y <= p.getY()) && (this.max_y >= p.getY())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Determines if the given bounds are enclosed.
     *
     * @param bounds the bounds
     * @return true, if successful
     */
    public boolean enclose(Bounds bounds) {
        if ((bounds.getMaximumX() <= this.max_x) &&
                (bounds.getMinimumX() >= this.min_x)) {
            // the given bounds are on the left or right side of the bounds
            if ((bounds.getMaximumY() <= this.max_y) &&
                    (bounds.getMinimumY() >= this.min_y)) {
                // the given bounds are above or below
                return true;
            }
        }

        return false;
    }
}
