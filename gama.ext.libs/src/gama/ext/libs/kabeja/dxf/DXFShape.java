/*******************************************************************************************************
 *
 * DXFShape.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import java.util.Map;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import gama.ext.libs.kabeja.dxf.helpers.Point;
import gama.ext.libs.kabeja.math.TransformContext;


/**
 * The Class DXFShape.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFShape extends DXFEntity {
    
    /** The insert point. */
    protected Point insertPoint = new Point();
    
    /** The rotation. */
    protected double rotation = 0.0;
    
    /** The height. */
    protected double height = 0.0;
    
    /** The scale factor. */
    protected double scaleFactor = 1.0;
    
    /** The oblique angle. */
    protected double obliqueAngle = 0.0;
    
    /** The name. */
    protected String name = "";

    /**
     * To SAX.
     *
     * @param handler the handler
     * @param svgContext the svg context
     * @param entity the entity
     * @param transformContext the transform context
     * @throws SAXException the SAX exception
     */
    /* (non-Javadoc)
     * @see org.kabeja.dxf.DXFEntity#toSAX(org.xml.sax.ContentHandler, java.util.Map)
     */
    public void toSAX(ContentHandler handler, Map svgContext, DXFEntity entity,
        TransformContext transformContext) throws SAXException {
    }

    /* (non-Javadoc)
     * @see org.kabeja.dxf.DXFEntity#getBounds()
     */
    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        bounds.setValid(false);

        return bounds;
    }

    /* (non-Javadoc)
     * @see org.kabeja.dxf.DXFEntity#getType()
     */
    public String getType() {
        return DXFConstants.ENTITY_TYPE_SHAPE;
    }

    /**
     * Gets the height.
     *
     * @return Returns the height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height.
     *
     * @param height The height to set.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets the insert point.
     *
     * @return Returns the insertPoint.
     */
    public Point getInsertPoint() {
        return insertPoint;
    }

    /**
     * Sets the insert point.
     *
     * @param insertPoint The insertPoint to set.
     */
    public void setInsertPoint(Point insertPoint) {
        this.insertPoint = insertPoint;
    }

    /**
     * Gets the name.
     *
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the oblique angle.
     *
     * @return Returns the obliqueAngle.
     */
    public double getObliqueAngle() {
        return obliqueAngle;
    }

    /**
     * Sets the oblique angle.
     *
     * @param obliqueAngle The obliqueAngle to set.
     */
    public void setObliqueAngle(double obliqueAngle) {
        this.obliqueAngle = obliqueAngle;
    }

    /**
     * Gets the rotation.
     *
     * @return Returns the rotation.
     */
    public double getRotation() {
        return rotation;
    }

    /**
     * Sets the rotation.
     *
     * @param rotation The rotation to set.
     */
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    /**
     * Gets the scale factor.
     *
     * @return Returns the scaleFactor.
     */
    public double getScaleFactor() {
        return scaleFactor;
    }

    /**
     * Sets the scale factor.
     *
     * @param scaleFactor The scaleFactor to set.
     */
    public void setScaleFactor(double scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public double getLength() {
        return 0;
    }
}
