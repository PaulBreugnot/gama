/*******************************************************************************************************
 *
 * NURBS.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.math;

import gama.ext.libs.kabeja.dxf.helpers.Point;


/**
 * The Class NURBS.
 */
public class NURBS {
    
    /** The control points. */
    protected Point[] controlPoints;
    
    /** The knots. */
    protected double[] knots;
    
    /** The weights. */
    protected double[] weights;
    
    /** The degree. */
    protected int degree;
    
    /** The closed. */
    protected boolean closed = false;

    /**
     * Instantiates a new nurbs.
     *
     * @param controlPoints the control points
     * @param knots the knots
     * @param weights the weights
     * @param degree the degree
     */
    public NURBS(Point[] controlPoints, double[] knots, double[] weights,
        int degree) {
        this.controlPoints = controlPoints;

        this.knots = knots;
        this.weights = weights;
        this.degree = degree;

        //some init stuff
        if (this.weights.length == 0) {
            this.weights = new double[this.controlPoints.length];
        }

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] == 0.0) {
                weights[i] = 1.0;
            }
        }
    }

    /**
     * Gets the basic functions.
     *
     * @param i the i
     * @param u the u
     * @return the basic functions
     */
    public double[] getBasicFunctions(int i, double u) {
        double[] n = new double[degree + 1];
        n[0] = 1.0;

        double[] left = new double[degree + 1];
        double[] right = new double[degree + 1];

        for (int j = 1; j <= degree; j++) {
            left[j] = u - this.knots[(i + 1) - j];
            right[j] = this.knots[i + j] - u;

            double saved = 0.0;

            for (int r = 0; r < j; r++) {
                double t = n[r] / (right[r + 1] + left[j - r]);
                n[r] = saved + (right[r + 1] * t);
                saved = left[j - r] * t;
            }

            n[j] = saved;
        }

        return n;
    }

    /**
     * Gets the point at.
     *
     * @param i the i
     * @param u the u
     * @return the point at
     */
    public Point getPointAt(int i, double u) {
        Point p = new Point();
        double[] n = this.getBasicFunctions(i, u);

        double t = 0.0;

        for (int j = 0; j <= this.degree; j++) {
            int d = i - this.degree + j;
            double w = this.weights[d];

            p.setX(p.getX() + (n[j] * this.controlPoints[d].getX() * w));
            p.setY(p.getY() + (n[j] * this.controlPoints[d].getY() * w));
            p.setZ(p.getZ() + (n[j] * this.controlPoints[d].getZ() * w));
            t += (n[j] * w);
        }

        p.setX((p.getX() / t));
        p.setY(p.getY() / t);
        p.setZ(p.getZ() / t);

        return p;
    }

    /**
     * Gets the point at.
     *
     * @param u the u
     * @return the point at
     */
    public Point getPointAt(double u) {
        int interval = this.findSpawnIndex(u);

        return this.getPointAt(interval, u);
    }

    /**
     * Find spawn index.
     *
     * @param u the u
     * @return the int
     */
    public int findSpawnIndex(double u) {
        if (u == this.knots[this.controlPoints.length + 1]) {
            return this.controlPoints.length;
        }

        int low = this.degree;
        int high = this.controlPoints.length + 1;
        int mid = (low + high) / 2;

        while ((u < this.knots[mid]) || (u >= this.knots[mid + 1])) {
            if (u < this.knots[mid]) {
                high = mid;
            } else {
                low = mid;
            }

            mid = (low + high) / 2;
        }

        return mid;
    }

    /**
     * Gets the control points.
     *
     * @return the control points
     */
    public Point[] getControlPoints() {
        return controlPoints;
    }

    /**
     * Sets the control points.
     *
     * @param controlPoints the new control points
     */
    public void setControlPoints(Point[] controlPoints) {
        this.controlPoints = controlPoints;
    }

    /**
     * Gets the knots.
     *
     * @return the knots
     */
    public double[] getKnots() {
        return knots;
    }

    /**
     * Sets the knots.
     *
     * @param knots the new knots
     */
    public void setKnots(double[] knots) {
        this.knots = knots;
    }

    /**
     * Gets the weights.
     *
     * @return the weights
     */
    public double[] getWeights() {
        return weights;
    }

    /**
     * Sets the weights.
     *
     * @param weights the new weights
     */
    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    /**
     * Gets the degree.
     *
     * @return the degree
     */
    public int getDegree() {
        return degree;
    }

    /**
     * Sets the degree.
     *
     * @param degree the new degree
     */
    public void setDegree(int degree) {
        this.degree = degree;
    }

    /**
     * Checks if is closed.
     *
     * @return true, if is closed
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * Sets the closed.
     *
     * @param closed the new closed
     */
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
