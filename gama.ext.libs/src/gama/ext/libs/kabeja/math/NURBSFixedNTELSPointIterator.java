/*******************************************************************************************************
 *
 * NURBSFixedNTELSPointIterator.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.math;

import java.util.Iterator;

import gama.ext.libs.kabeja.dxf.helpers.Point;


/**
 * The Class NURBSFixedNTELSPointIterator.
 */
public class NURBSFixedNTELSPointIterator implements Iterator {
    
    /** The nurbs. */
    private NURBS nurbs;
    
    /** The ntels. */
    private int ntels;
    
    /** The dt. */
    private double dt = 0;
    
    /** The t. */
    private double t = 0;
    
    /** The interval. */
    private int interval;
    
    /** The last interval. */
    private int lastInterval;

    /**
     * Instantiates a new NURBS fixed NTELS point iterator.
     *
     * @param nurbs            The NURBS curve to draw
     * @param ntels            the ntels per interval to use
     */
    public NURBSFixedNTELSPointIterator(NURBS nurbs, int ntels) {
        this.nurbs = nurbs;
        this.ntels = ntels;

        if (this.nurbs.getKnots().length == (this.nurbs.getDegree() +
                this.nurbs.controlPoints.length + 1)) {
            this.lastInterval = this.nurbs.getKnots().length -
                this.nurbs.getDegree() - 1;
            this.interval = this.nurbs.getDegree();
        } else if (this.nurbs.getKnots().length > 0) {
            // find self the start and end interval
            this.interval = 0;

            double start = this.nurbs.getKnots()[0];

            while (start == this.nurbs.getKnots()[this.interval + 1]) {
                this.interval++;
            }

            this.lastInterval = this.nurbs.getKnots().length - 1;

            double end = this.nurbs.getKnots()[this.lastInterval];

            while (end == this.nurbs.getKnots()[this.lastInterval]) {
                this.lastInterval--;
            }
        }

        //init t
        this.t = this.nurbs.getKnots()[this.nurbs.getDegree()];
        this.nextInterval();

        //fix for some broken nurbs
        if ((this.interval - 1) < this.nurbs.getDegree()) {
            this.interval = this.nurbs.getDegree() + 1;
        }
    }

    public boolean hasNext() {
        if (this.t < this.nurbs.getKnots()[this.interval]) {
            return true;
        } else if (this.interval < this.lastInterval) {
            this.nextInterval();

            return hasNext();
        }

        return false;
    }

    public Object next() {
        Point p = this.nurbs.getPointAt(this.interval - 1, t);
        //		System.out.println("t="+t);
        //		Point p = this.nurbs.getPointAt(t);
        this.t += this.dt;

        return p;
    }

    public void remove() {
        //nothing todo here
    }

    /**
     * Next interval.
     */
    protected void nextInterval() {
        this.interval++;

        while ((this.t > this.nurbs.getKnots()[this.interval]) &&
                (this.interval < this.lastInterval)) {
            this.interval++;
        }

        double length = this.nurbs.getKnots()[this.interval] - this.t;
        this.dt = length / this.ntels;
    }
}
