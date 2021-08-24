/*******************************************************************************************************
 *
 * DXFText.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import gama.ext.libs.kabeja.dxf.helpers.DXFTextParser;
import gama.ext.libs.kabeja.dxf.helpers.Point;
import gama.ext.libs.kabeja.dxf.helpers.TextDocument;


/**
 * The Class DXFText.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFText extends DXFEntity {
    
    /** The Constant DEFAULT_FONT_SIZE. */
    public static final double DEFAULT_FONT_SIZE = 8;
    
    /** The Constant VALIGN_BASELINE. */
    public static final int VALIGN_BASELINE = 0;
    
    /** The Constant VALIGN_BOTTOM. */
    public static final int VALIGN_BOTTOM = 1;
    
    /** The Constant VALIGN_CENTER. */
    public static final int VALIGN_CENTER = 2;
    
    /** The Constant VALIGN_TOP. */
    public static final int VALIGN_TOP = 3;
    
    /** The Constant ALIGN_LEFT. */
    public static final int ALIGN_LEFT = 0;
    
    /** The Constant ALIGN_CENTER. */
    public static final int ALIGN_CENTER = 1;
    
    /** The Constant ALIGN_RIGHT. */
    public static final int ALIGN_RIGHT = 2;
    
    /** The Constant ALIGN_ALIGNED. */
    public static final int ALIGN_ALIGNED = 3;
    
    /** The Constant ALIGN_MIDDLE. */
    public static final int ALIGN_MIDDLE = 4;
    
    /** The Constant ALIGN_FIT. */
    public static final int ALIGN_FIT = 5;
    
    /** The rotation. */
    protected double rotation = 0.0;
    
    /** The height. */
    protected double height = 0.0;
    
    /** The scale x. */
    protected double scale_x = 1.0;
    
    /** The oblique angle. */
    protected double oblique_angle = 0.0;
    
    /** The align x. */
    protected double align_x = 0.0;
    
    /** The align y. */
    protected double align_y = 0.0;
    
    /** The align z. */
    protected double align_z = 0.0;

    /** The align. */
    // the horizontal align
    protected int align = 0;

    /** The valign. */
    // the vertical align
    protected int valign = 0;
    
    /** The text. */
    protected String text = "";
    
    /** The text style. */
    protected String textStyle = "";
    
    /** The p. */
    protected Point p;
    
    /** The align p 1. */
    protected Point align_p1;
    
    /** The align p 2. */
    protected Point align_p2;
    
    /** The upside down. */
    protected boolean upsideDown = false;
    
    /** The backward. */
    protected boolean backward = false;
    
    /** The alignment point set. */
    protected boolean alignmentPointSet = false;
    
    /** The top. */
    protected boolean top = false;
    
    /** The bottom. */
    protected boolean bottom = false;
    
    /** The vertical center. */
    protected boolean vertical_center = false;
    
    /** The text doc. */
    protected TextDocument textDoc = new TextDocument();

    /**
     * Instantiates a new DXF text.
     */
    public DXFText() {
        this.p = new Point();
        this.align_p1 = new Point();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.dxf.DXFEntity#setDXFDocument(org.dxf2svg.dxf.DXFDocument)
     */
    public void setDXFDocument(DXFDocument doc) {
        super.setDXFDocument(doc);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.dxf.DXFEntity#updateViewPort()
     */
    public Bounds getBounds() {
        Bounds bounds = new Bounds();

        double tl = getTextDocument().getText().length();

        if (tl > 0) {
            // TODO calculate the real values
            Point p = calculateAlignmentPoint();
            bounds.addToBounds(p);

            double h = getHeight();

            double w = tl * h * 0.6;

            if (this.isBackward()) {
                w = -1 * w;
            }

            // we set the horizontal width
            switch (this.align) {
            case 0:
                bounds.addToBounds(p.getX() + w, p.getY(), p.getZ());

                break;

            case 1:
                bounds.addToBounds(p.getX() + (w / 2), p.getY(), p.getZ());
                bounds.addToBounds(p.getX() - (w / 2), p.getY(), p.getZ());

                break;

            case 2:
                bounds.addToBounds(p.getX() - w, p.getY(), p.getZ());

                break;

            case 3:
                bounds.addToBounds(p.getX() - w, p.getY(), p.getZ());

                break;

            case 4:
                bounds.addToBounds(p.getX() + (w / 2), p.getY(), p.getZ());
                bounds.addToBounds(p.getX() - (w / 2), p.getY(), p.getZ());

                break;

            case 5:
                bounds.addToBounds(p.getX() + (w / 2), p.getY(), p.getZ());
                bounds.addToBounds(p.getX() - (w / 2), p.getY(), p.getZ());

                break;
            }

            // set the vertical height
            switch (this.valign) {
            case VALIGN_BASELINE:
                bounds.addToBounds(p.getX(), p.getY() + (h * 0.75), p.getZ());

                break;

            case VALIGN_BOTTOM:
                bounds.addToBounds(p.getX(), p.getY() + h, p.getZ());

                break;

            case VALIGN_CENTER:
                bounds.addToBounds(p.getX(), p.getY() + (h * 0.5), p.getZ());
                bounds.addToBounds(p.getX(), p.getY() - (h * 0.5), p.getZ());

                break;

            case VALIGN_TOP:
                bounds.addToBounds(p.getX(), p.getY() - h, p.getZ());

                break;
            }
        } else {
            bounds.setValid(false);
        }

        return bounds;
    }

    /**
     * Gets the align.
     *
     * @return Returns the align.
     */
    public int getAlign() {
        return align;
    }

    /**
     * Sets the align.
     *
     * @param align            The align to set.
     */
    public void setAlign(int align) {
        this.align = align;
    }

    /**
     * Gets the align X.
     *
     * @return Returns the align_x.
     */
    public double getAlignX() {
        return align_p1.getX();
    }

    /**
     * Sets the align X.
     *
     * @param align_x            The align_x to set.
     */
    public void setAlignX(double align_x) {
        align_p1.setX(align_x);
    }

    /**
     * Gets the align Y.
     *
     * @return Returns the align_y.
     */
    public double getAlignY() {
        return align_p1.getY();
    }

    /**
     * Sets the align Y.
     *
     * @param align_y            The align_y to set.
     */
    public void setAlignY(double align_y) {
        align_p1.setY(align_y);
    }

    /**
     * Gets the align Z.
     *
     * @return Returns the align_z.
     */
    public double getAlignZ() {
        return align_p1.getZ();
    }

    /**
     * Sets the align Z.
     *
     * @param align_z            The align_z to set.
     */
    public void setAlignZ(double align_z) {
        align_p1.setZ(align_z);
    }

    /**
     * Gets the height.
     *
     * @return Returns the height.
     */
    public double getHeight() {
        if (height != 0.0) {
            return height;
        } else if (doc.getDXFStyle(this.textStyle) != null) {
            return doc.getDXFStyle(this.textStyle).getTextHeight();
        } else {
            return 0.0;
        }
    }

    /**
     * Sets the height.
     *
     * @param height            The height to set.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets the oblique angle.
     *
     * @return Returns the oblique_angle.
     */
    public double getObliqueAngle() {
        return oblique_angle;
    }

    /**
     * Sets the oblique angle.
     *
     * @param oblique_angle            The oblique_angle to set.
     */
    public void setObliqueAngle(double oblique_angle) {
        this.oblique_angle = oblique_angle;
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
     * @param rotation            The rotation to set.
     */
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    /**
     * Gets the scale X.
     *
     * @return Returns the scale_x.
     */
    public double getScaleX() {
        return scale_x;
    }

    /**
     * Sets the scale X.
     *
     * @param scale_x            The scale_x to set.
     */
    public void setScaleX(double scale_x) {
        this.scale_x = scale_x;
    }

    /**
     * Gets the text.
     *
     * @return Returns the text.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param text            The text to set.
     */
    public void setText(String text) {
        this.text = text;
        this.textDoc = DXFTextParser.parseDXFText(this);
    }

    /**
     * Gets the text style.
     *
     * @return Returns the textStyle.
     */
    public String getTextStyle() {
        return textStyle;
    }

    /**
     * Sets the text style.
     *
     * @param textStyle            The textStyle to set.
     */
    public void setTextStyle(String textStyle) {
        this.textStyle = textStyle;
    }

    /**
     * Gets the valign.
     *
     * @return Returns the valign.
     */
    public int getValign() {
        return valign;
    }

    /**
     * Sets the valign.
     *
     * @param valign            The valign to set.
     */
    public void setValign(int valign) {
        this.valign = valign;
    }

    /**
     * Sets the x.
     *
     * @param x the new x
     */
    public void setX(double x) {
        p.setX(x);
    }

    /**
     * Sets the y.
     *
     * @param y the new y
     */
    public void setY(double y) {
        p.setY(y);
    }

    /**
     * Sets the z.
     *
     * @param z the new z
     */
    public void setZ(double z) {
        p.setZ(z);
    }

    /**
     * Checks if is backward.
     *
     * @return true, if is backward
     */
    public boolean isBackward() {
        return backward;
    }

    /**
     * Sets the backward.
     *
     * @param backward the new backward
     */
    public void setBackward(boolean backward) {
        this.backward = backward;
    }

    /**
     * Checks if is upside down.
     *
     * @return true, if is upside down
     */
    public boolean isUpsideDown() {
        return upsideDown;
    }

    /**
     * Sets the upside down.
     *
     * @param upsideDown the new upside down
     */
    public void setUpsideDown(boolean upsideDown) {
        this.upsideDown = upsideDown;
    }

    public String getType() {
        return DXFConstants.ENTITY_TYPE_TEXT;
    }

    /**
     * Checks if is alignment point set.
     *
     * @return Returns the alignmentPointSet.
     */
    public boolean isAlignmentPointSet() {
        return alignmentPointSet;
    }

    /**
     * Sets the alignment point.
     *
     * @param alignmentPoint the new alignment point
     */
    public void setAlignmentPoint(boolean alignmentPoint) {
        this.alignmentPointSet = alignmentPoint;
    }

    /**
     * Gets the text document.
     *
     * @return the text document
     */
    public TextDocument getTextDocument() {
        return this.textDoc;
    }

    /**
     * Gets the insert point.
     *
     * @return the insert point
     */
    public Point getInsertPoint() {
        return p;
    }

    /**
     * Gets the alignment point.
     *
     * @return the alignment point
     */
    public Point getAlignmentPoint() {
        return align_p1;
    }

    /**
     * Calculate alignment point.
     *
     * @return the point
     */
    public Point calculateAlignmentPoint() {
        Point alignmentPoint = new Point(p.getX(), p.getY(), p.getZ());

        if (!isUpsideDown()) {
            switch (align) {
            case 1:

                if (alignmentPointSet) {
                    alignmentPoint.setX(align_p1.getX());
                }

                break;

            case 2:

                if (alignmentPointSet) {
                    alignmentPoint.setX(align_p1.getX());
                }

                break;

            case 3:

                if (alignmentPointSet) {
                    alignmentPoint.setX(align_p1.getX());
                }

                break;

            case 4:

                if (alignmentPointSet) {
                    alignmentPoint.setX(align_p1.getX());
                }

                break;

            case 5:

                if (alignmentPointSet) {
                    alignmentPoint.setX(align_p1.getX());
                }

                break;
            }

            if (alignmentPointSet) {
                alignmentPoint.setY(align_p1.getY());
            }
        }

        return alignmentPoint;
    }

    public boolean isOmitLineType() {
        return true;
    }

    public double getLength() {
        return 0;
    }
}
