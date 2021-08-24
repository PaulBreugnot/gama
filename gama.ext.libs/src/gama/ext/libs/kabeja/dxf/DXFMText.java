/*******************************************************************************************************
 *
 * DXFMText.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import gama.ext.libs.kabeja.dxf.helpers.DXFTextParser;
import gama.ext.libs.kabeja.dxf.helpers.DXFUtils;
import gama.ext.libs.kabeja.dxf.helpers.TextDocument;


/**
 * The Class DXFMText.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFMText extends DXFText {
    
    /** The Constant ATTACHMENT_TOP_LEFT. */
    public static final int ATTACHMENT_TOP_LEFT = 1;
    
    /** The Constant ATTACHMENT_TOP_CENTER. */
    public static final int ATTACHMENT_TOP_CENTER = 2;
    
    /** The Constant ATTACHMENT_TOP_RIGHT. */
    public static final int ATTACHMENT_TOP_RIGHT = 3;
    
    /** The Constant ATTACHMENT_MIDDLE_LEFT. */
    public static final int ATTACHMENT_MIDDLE_LEFT = 4;
    
    /** The Constant ATTACHMENT_MIDDLE_CENTER. */
    public static final int ATTACHMENT_MIDDLE_CENTER = 5;
    
    /** The Constant ATTACHMENT_MIDDLE_RIGHT. */
    public static final int ATTACHMENT_MIDDLE_RIGHT = 6;
    
    /** The Constant ATTACHMENT_BOTTOM_LEFT. */
    public static final int ATTACHMENT_BOTTOM_LEFT = 7;
    
    /** The Constant ATTACHMENT_BOTTOM_CENTER. */
    public static final int ATTACHMENT_BOTTOM_CENTER = 8;
    
    /** The Constant ATTACHMENT_BOTTOM_RIGHT. */
    public static final int ATTACHMENT_BOTTOM_RIGHT = 9;
    
    /** The attachmentpoint location. */
    private int attachmentpointLocation = 1;
    
    /** The refwidth. */
    private double refwidth = 0.0;
    
    /** The refheight. */
    private double refheight = 0.0;

    /**
     * Sets the attachment point.
     *
     * @param value the new attachment point
     */
    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.dxf.DXFText#processText(java.lang.String,
     *      org.xml.sax.ContentHandler)
     */
    public void setAttachmentPoint(int value) {
        this.attachmentpointLocation = value;
    }

    /**
     * Sets the reference width.
     *
     * @param width the new reference width
     */
    public void setReferenceWidth(double width) {
        this.refwidth = width;
    }

    /**
     * Gets the reference width.
     *
     * @return the reference width
     */
    public double getReferenceWidth() {
        return this.refwidth;
    }

    /**
     * Sets the reference height.
     *
     * @param height the new reference height
     */
    public void setReferenceHeight(double height) {
        this.refheight = height;
    }

    /**
     * Gets the reference height.
     *
     * @return the reference height
     */
    public double getReferenceHeight() {
        return this.refheight;
    }

    public String getType() {
        return DXFConstants.ENTITY_TYPE_MTEXT;
    }

    public double getRotation() {
        if (rotation != 0.0) {
            return rotation;
        } else if ((align_p1.getX() != 0.0) || (align_p1.getY() != 0.0) ||
                (align_p1.getZ() != 0.0)) {
            // the align point as direction vector here
            // calculate the angle between the x-axis and the direction-vector
            double[] x = { align_p1.getX(), align_p1.getY(), align_p1.getZ() };
            double v = align_p1.getX() / DXFUtils.vectorValue(x);
            v = Math.toDegrees(Math.acos(v));

            return v;
        }

        // same as 0.0
        return rotation;
    }

    public TextDocument getTextDocument() {
        return this.textDoc;
    }

    public void setText(String text) {
        this.text = text;

        this.textDoc = DXFTextParser.parseDXFMText(this);
    }

    /**
     * Gets the alignment.
     *
     * @return the alignment
     */
    public int getAlignment() {
        return attachmentpointLocation;
    }

    public boolean isOmitLineType() {
        return true;
    }

    /* (non-Javadoc)
     * @see org.kabeja.dxf.DXFEntity#getBounds()
     */
    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        int l = this.textDoc.getMaximumLineLength();

        if (l > 0) {
            double h = getHeight();

            if (h == 0.0) {
                h = getReferenceHeight();
            }

            double w = l * 0.7 * h;
            h *= this.textDoc.getLineCount();

            switch (this.attachmentpointLocation) {
            case ATTACHMENT_BOTTOM_CENTER:
                bounds.addToBounds(this.p.getX() + (w / 2), this.p.getY() + h,
                    p.getZ());
                bounds.addToBounds(this.p.getX() - (w / 2), this.p.getY(),
                    p.getZ());

                break;

            case ATTACHMENT_BOTTOM_LEFT:
                bounds.addToBounds(this.p.getX() + w, this.p.getY() + h,
                    p.getZ());
                bounds.addToBounds(this.p.getX(), this.p.getY(), p.getZ());

                break;

            case ATTACHMENT_BOTTOM_RIGHT:
                bounds.addToBounds(this.p.getX() - w, this.p.getY() + h,
                    p.getZ());
                bounds.addToBounds(this.p.getX(), this.p.getY(), p.getZ());

                break;

            case ATTACHMENT_MIDDLE_CENTER:
                bounds.addToBounds(this.p.getX() + (w / 2),
                    this.p.getY() + (h / 2), p.getZ());
                bounds.addToBounds(this.p.getX() - (w / 2),
                    this.p.getY() - (h / 2), p.getZ());

                break;

            case ATTACHMENT_MIDDLE_LEFT:
                bounds.addToBounds(this.p.getX(), this.p.getY() + (h / 2),
                    p.getZ());
                bounds.addToBounds(this.p.getX() + w, this.p.getY() - (h / 2),
                    p.getZ());

                break;

            case ATTACHMENT_MIDDLE_RIGHT:
                bounds.addToBounds(this.p.getX(), this.p.getY() + (h / 2),
                    p.getZ());
                bounds.addToBounds(this.p.getX() - w, this.p.getY() - (h / 2),
                    p.getZ());

                break;

            case ATTACHMENT_TOP_LEFT:
                bounds.addToBounds(this.p.getX(), this.p.getY(), p.getZ());
                bounds.addToBounds(this.p.getX() + w, this.p.getY() - h,
                    p.getZ());

                break;

            case ATTACHMENT_TOP_CENTER:
                bounds.addToBounds(this.p.getX() + (w / 2), this.p.getY(),
                    p.getZ());
                bounds.addToBounds(this.p.getX() - (w / 2), this.p.getY() - h,
                    p.getZ());

                break;

            case ATTACHMENT_TOP_RIGHT:
                bounds.addToBounds(this.p.getX(), this.p.getY(), p.getZ());
                bounds.addToBounds(this.p.getX() - w, this.p.getY() - h,
                    p.getZ());

                break;
            }
        } else {
            bounds.setValid(false);
        }

        return bounds;
    }
}
