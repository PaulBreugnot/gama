/*******************************************************************************************************
 *
 * HatchLineFamily.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.helpers;


/**
 * The Class HatchLineFamily.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class HatchLineFamily {
    
    /** The rotation angle. */
    private double rotationAngle;
    
    /** The base X. */
    private double baseX;
    
    /** The base Y. */
    private double baseY;
    
    /** The offset X. */
    private double offsetX;
    
    /** The offset Y. */
    private double offsetY;
    
    /** The length. */
    private double length = 0.0;
    
    /** The pattern. */
    private double[] pattern = new double[0];

    /**
     * Gets the base X.
     *
     * @return Returns the baseX.
     */
    public double getBaseX() {
        return baseX;
    }

    /**
     * Sets the base X.
     *
     * @param baseX            The baseX to set.
     */
    public void setBaseX(double baseX) {
        this.baseX = baseX;
    }

    /**
     * Gets the base Y.
     *
     * @return Returns the baseY.
     */
    public double getBaseY() {
        return baseY;
    }

    /**
     * Sets the base Y.
     *
     * @param baseY            The baseY to set.
     */
    public void setBaseY(double baseY) {
        this.baseY = baseY;
    }

    /**
     * Gets the offset X.
     *
     * @return Returns the offsetX.
     */
    public double getOffsetX() {
        return offsetX;
    }

    /**
     * Sets the offset X.
     *
     * @param offsetX            The offsetX to set.
     */
    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }

    /**
     * Gets the offset Y.
     *
     * @return Returns the offsetY.
     */
    public double getOffsetY() {
        return offsetY;
    }

    /**
     * Sets the offset Y.
     *
     * @param offsetY            The offsetY to set.
     */
    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }

    /**
     * Gets the pattern.
     *
     * @return Returns the pattern.
     */
    public double[] getPattern() {
        return pattern;
    }

    /**
     * Sets the pattern.
     *
     * @param pattern            The pattern to set.
     */
    public void setPattern(double[] pattern) {
        if (pattern != null) {
            this.pattern = pattern;
        }
    }

    /**
     * Gets the rotation angle.
     *
     * @return Returns the rotationAngle.
     */
    public double getRotationAngle() {
        return rotationAngle;
    }

    /**
     * Sets the rotation angle.
     *
     * @param rotationAngle            The rotationAngle to set.
     */
    public void setRotationAngle(double rotationAngle) {
        this.rotationAngle = rotationAngle;
    }

    /**
     * Gets the length.
     *
     * @return the length
     */
    public double getLength() {
        if (length <= 0.0) {
            for (int i = 0; i < pattern.length; i++) {
                this.length += Math.abs(pattern[i]);
            }
        }

        return this.length;
    }

    /**
     * Gets the pattern width.
     *
     * @return the pattern width
     */
    public double getPatternWidth() {
        return (getLength() * Math.cos(this.rotationAngle));
    }

    /**
     * Gets the pattern height.
     *
     * @return the pattern height
     */
    public double getPatternHeight() {
        return (getLength() * Math.sin(this.rotationAngle));
    }

    /**
     * Gets the base point.
     *
     * @return the base point
     */
    public Point getBasePoint() {
        return transform(this.baseX, this.baseY);
    }

    /**
     * Gets the offset point.
     *
     * @return the offset point
     */
    public Point getOffsetPoint() {
        return transform(this.offsetX, this.offsetY);
    }

    /**
     * Transform.
     *
     * @param x the x
     * @param y the y
     * @return the point
     */
    protected Point transform(double x, double y) {
        Point p = new Point();
        p.setX((Math.cos(this.rotationAngle) * x) +
            (Math.sin(this.rotationAngle) * y));
        p.setY((Math.cos(this.rotationAngle) * y) -
            (Math.sin(this.rotationAngle) * x));

        return p;
    }

    /**
     * Gets the minimal base point.
     *
     * @return the minimal base point
     */
    public Point getMinimalBasePoint() {
        Point p = new Point();
        Point b = getBasePoint();
        Point o = getOffsetPoint();
        p.setX(b.getX() % o.getX());
        p.setY(b.getY() % o.getY());

        return p;
    }
}
