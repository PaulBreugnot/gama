/*******************************************************************************************************
 *
 * DXFSpline.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gama.ext.libs.kabeja.dxf.helpers.DXFSplineConverter;
import gama.ext.libs.kabeja.dxf.helpers.SplinePoint;


/**
 * The Class DXFSpline.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFSpline extends DXFEntity {
    
    /** The Constant APPROXIMATION_STEPS. */
    protected static final int APPROXIMATION_STEPS = 10;
    
    /** The degree. */
    protected int degree;
    
    /** The node points size. */
    protected int nodePointsSize;
    
    /** The control point size. */
    protected int controlPointSize;
    
    /** The fit point size. */
    protected int fitPointSize;
    
    /** The knots. */
    protected double[] knots;
    
    /** The weights. */
    protected double[] weights;
    
    /** The points. */
    protected List points = new ArrayList();
    
    /** The fit tolerance. */
    protected double fitTolerance;
    
    /** The knots tolerance. */
    protected double knotsTolerance;
    
    /** The control point tolerance. */
    protected double controlPointTolerance;
    
    /** The polyline. */
    DXFPolyline polyline;

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.dxf.DXFEntity#getBounds()
     */
    public Bounds getBounds() {
        // simple the convex hull of the spline
        // Iterator i = points.iterator();
        //
        // while (i.hasNext()) {
        // SplinePoint p = (SplinePoint) i.next();
        // bounds.addToBounds(p);
        // }
        //
        // return bounds;

        //more correct bounds
        if (this.polyline == null) {
            this.polyline = toDXFPolyline();
        }

        return this.polyline.getBounds();
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.dxf.DXFEntity#getType()
     */
    public String getType() {
        return DXFConstants.ENTITY_TYPE_SPLINE;
    }

    /**
     * Adds the spline point.
     *
     * @param p the p
     */
    public void addSplinePoint(SplinePoint p) {
        this.points.add(p);
        this.polyline = null;
    }

    /**
     * Gets the spline point iterator.
     *
     * @return the spline point iterator
     */
    public Iterator getSplinePointIterator() {
        return points.iterator();
    }

    /**
     * Checks if is rational.
     *
     * @return true, if is rational
     */
    public boolean isRational() {
        return (this.flags & 4) == 4;
    }

    /**
     * Checks if is closed.
     *
     * @return true, if is closed
     */
    public boolean isClosed() {
        return (this.flags & 1) == 1;
    }

    /**
     * Checks if is periodic.
     *
     * @return true, if is periodic
     */
    public boolean isPeriodic() {
        return (this.flags & 2) == 2;
    }

    /**
     * Checks if is planar.
     *
     * @return true, if is planar
     */
    public boolean isPlanar() {
        return (this.flags & 8) == 8;
    }

    /**
     * Checks if is linear.
     *
     * @return true, if is linear
     */
    public boolean isLinear() {
        return (this.flags & 16) == 16;
    }

    /**
     * Gets the control point size.
     *
     * @return Returns the controlPointSize.
     */
    public int getControlPointSize() {
        return controlPointSize;
    }

    /**
     * Sets the control point size.
     *
     * @param controlPointSize            The controlPointSize to set.
     */
    public void setControlPointSize(int controlPointSize) {
        this.controlPointSize = controlPointSize;
    }

    /**
     * Gets the degree.
     *
     * @return Returns the degree.
     */
    public int getDegree() {
        return degree;
    }

    /**
     * Sets the degree.
     *
     * @param degree            The degree to set.
     */
    public void setDegree(int degree) {
        this.degree = degree;
    }

    /**
     * Gets the fit point size.
     *
     * @return Returns the fitPointSize.
     */
    public int getFitPointSize() {
        return fitPointSize;
    }

    /**
     * Sets the fit point size.
     *
     * @param fitPointSize            The fitPointSize to set.
     */
    public void setFitPointSize(int fitPointSize) {
        this.fitPointSize = fitPointSize;
    }

    /**
     * Gets the fit tolerance.
     *
     * @return Returns the fitTolerance.
     */
    public double getFitTolerance() {
        return fitTolerance;
    }

    /**
     * Sets the fit tolerance.
     *
     * @param fitTolerance            The fitTolerance to set.
     */
    public void setFitTolerance(double fitTolerance) {
        this.fitTolerance = fitTolerance;
    }

    /**
     * Gets the knots.
     *
     * @return Returns the knots.
     */
    public double[] getKnots() {
        return knots;
    }

    /**
     * Sets the knots.
     *
     * @param knots            The knots to set.
     */
    public void setKnots(double[] knots) {
        this.knots = knots;
        this.polyline = null;
    }

    /**
     * Gets the node points size.
     *
     * @return Returns the nodePointsSize.
     */
    public int getNodePointsSize() {
        return nodePointsSize;
    }

    /**
     * Sets the node points size.
     *
     * @param nodePointsSize            The nodePointsSize to set.
     */
    public void setNodePointsSize(int nodePointsSize) {
        this.nodePointsSize = nodePointsSize;
    }

    /**
     * Gets the weights.
     *
     * @return Returns the weights.
     */
    public double[] getWeights() {
        return weights;
    }

    /**
     * Sets the weights.
     *
     * @param weights            The weights to set.
     */
    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    /**
     * Gets the control point tolerance.
     *
     * @return Returns the controlPointTolerance.
     */
    public double getControlPointTolerance() {
        return controlPointTolerance;
    }

    /**
     * Sets the control point tolerance.
     *
     * @param controlPointTolerance            The controlPointTolerance to set.
     */
    public void setControlPointTolerance(double controlPointTolerance) {
        this.controlPointTolerance = controlPointTolerance;
    }

    /**
     * Gets the knots tolerance.
     *
     * @return Returns the knotsTolerance.
     */
    public double getKnotsTolerance() {
        return knotsTolerance;
    }

    /**
     * Sets the knots tolerance.
     *
     * @param knotsTolerance            The knotsTolerance to set.
     */
    public void setKnotsTolerance(double knotsTolerance) {
        this.knotsTolerance = knotsTolerance;
    }

    public double getLength() {
        if (this.polyline == null) {
            this.polyline = toDXFPolyline();
        }

        return this.polyline.getLength();
    }

    /**
     * To DXF polyline.
     *
     * @return the DXF polyline
     */
    protected DXFPolyline toDXFPolyline() {
        return DXFSplineConverter.toDXFPolyline(this);
    }
}
