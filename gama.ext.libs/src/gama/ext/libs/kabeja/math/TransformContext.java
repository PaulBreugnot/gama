/*******************************************************************************************************
 *
 * TransformContext.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.math;

import gama.ext.libs.kabeja.dxf.helpers.Point;
import gama.ext.libs.kabeja.dxf.helpers.Vector;


/**
 * The Class TransformContext.
 */
public class TransformContext {
    
    /** The transform matrix. */
    private double[][] transformMatrix;
    
    /** The rotation angle. */
    private double rotationAngle = 0.0;
    
    /** The scale X. */
    private double scaleX = 1.0;
    
    /** The scale Y. */
    private double scaleY = 1.0;
    
    /** The scale Z. */
    private double scaleZ = 1.0;
    
    /** The translation. */
    private Vector translation = new Vector(1.0, 1.0, 1.0);

    /**
     * Instantiates a new transform context.
     */
    public TransformContext() {
        transformMatrix = new double[][] {
                { 1.0, 0.0, 0.0, 0.0 },
                { 0.0, 1.0, 0.0, 0.0 },
                { 0.0, 0.0, 1.0, 0.0 },
                { 0.0, 0.0, 0.0, 1.0 }
            };
    }

    /**
     * Instantiates a new transform context.
     *
     * @param transformMatrix the transform matrix
     * @throws IllegalArgumentException the illegal argument exception
     */
    public TransformContext(double[][] transformMatrix)
        throws IllegalArgumentException {
        if ((transformMatrix.length != 4) && (transformMatrix[0].length != 4)) {
            throw new IllegalArgumentException(
                "Not a valid tranformation matrix.");
        }

        this.transformMatrix = transformMatrix;
    }

    /**
     * Gets the rotation Z axis.
     *
     * @return the rotation Z axis
     */
    public double getRotationZAxis() {
        return rotationAngle;
    }

    /**
     * Sets the rotation Z axis.
     *
     * @param rotationAngle the new rotation Z axis
     */
    public void setRotationZAxis(double rotationAngle) {
        this.rotationAngle = rotationAngle;
    }

    /**
     * Sets the scale.
     *
     * @param s the new scale
     */
    public void setScale(double s) {
        this.setScale(s, s, s);
    }

    /**
     * Sets the scale.
     *
     * @param x the x
     * @param y the y
     * @param z the z
     */
    public void setScale(double x, double y, double z) {
        this.scaleX = x;
        this.scaleY = y;
        this.scaleZ = z;

        double[][] m = new double[][] {
                { x, 0.0, 0.0, 0.0 },
                { 0.0, y, 0.0, 0.0 },
                { 0.0, 0.0, z, 0.0 },
                { 0.0, 0.0, 0.0, 1.0 }
            };
        this.transformMatrix = MathUtils.multiplyMatrixByMatrix(this.transformMatrix,
                m);
    }

    /**
     * Gets the scale X.
     *
     * @return the scale X
     */
    public double getScaleX() {
        return scaleX;
    }

    /**
     * Sets the scale X.
     *
     * @param scaleX the new scale X
     */
    public void setScaleX(double scaleX) {
        this.setScale(scaleX, 1.0, 1.0);
    }

    /**
     * Gets the scale Y.
     *
     * @return the scale Y
     */
    public double getScaleY() {
        return scaleY;
    }

    /**
     * Sets the scale Y.
     *
     * @param scaleY the new scale Y
     */
    public void setScaleY(double scaleY) {
        this.setScale(1.0, scaleY, 1.0);
    }

    /**
     * Gets the scale Z.
     *
     * @return the scale Z
     */
    public double getScaleZ() {
        return scaleZ;
    }

    /**
     * Sets the scale Z.
     *
     * @param scaleZ the new scale Z
     */
    public void setScaleZ(double scaleZ) {
        this.setScale(1.0, 1.0, scaleZ);
    }

    /**
     * Gets the transform matrix.
     *
     * @return the transform matrix
     */
    public double[][] getTransformMatrix() {
        return transformMatrix;
    }

    /**
     * Sets the transform matrix.
     *
     * @param transformMatrix the new transform matrix
     */
    public void setTransformMatrix(double[][] transformMatrix) {
        this.transformMatrix = transformMatrix;
    }

    /**
     * Gets the translation.
     *
     * @return the translation
     */
    public Vector getTranslation() {
        return translation;
    }

    /**
     * Sets the translation.
     *
     * @param translation the new translation
     */
    public void setTranslation(Vector translation) {
        this.translation = translation;

        double[][] m = new double[][] {
                { 1.0, 0.0, 0.0, translation.getX() },
                { 0.0, 1.0, 0.0, translation.getY() },
                { 0.0, 0.0, 1.0, translation.getZ() },
                { 0.0, 0.0, 0.0, 1.0 }
            };
        this.transformMatrix = MathUtils.multiplyMatrixByMatrix(this.transformMatrix,
                m);
    }

    /**
     * Transform.
     *
     * @param a the a
     * @return the point
     */
    public Point transform(Point a) {
        double[] v = new double[] { a.getX(), a.getY(), a.getZ(), 1.0 };
        v = MathUtils.multiplyMatrixByVector(this.transformMatrix, v);

        Point p = new Point(v[0], v[1], v[2]);

        return p;
    }
}
