/*******************************************************************************************************
 *
 * DXFInsert.java, in gama.ext.libs, is part of the source code of the
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
 * The Class DXFInsert.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFInsert extends DXFEntity {
    
    /** The insert point. */
    private Point insertPoint = new Point();
    
    /** The scale x. */
    private double scale_x = 1.0;
    
    /** The scale y. */
    private double scale_y = 1.0;
    
    /** The scale z. */
    private double scale_z = 1.0;
    
    /** The rotate. */
    private double rotate = 0;
    
    /** The rows. */
    private int rows = 1;
    
    /** The columns. */
    private int columns = 1;
    
    /** The row spacing. */
    private double row_spacing = 0;
    
    /** The column spacing. */
    private double column_spacing = 0;
    
    /** The block ID. */
    private String blockID = "";

    /**
     * Instantiates a new DXF insert.
     */
    public DXFInsert() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.dxf.DXFEntity#getBounds()
     */
    public Bounds getBounds() {
        Bounds bounds = new Bounds();

        // extrusion.calculateExtrusion();
        // get the Block bounds
        DXFBlock block = doc.getDXFBlock(getBlockID());
        Bounds b = block.getBounds();

        if (!b.isValid()) {
            bounds.setValid(false);

            return bounds;
        }

        Point blkPoint = block.getReferencePoint();

        // Translate to origin and scale
        bounds.setMaximumX((b.getMaximumX() - blkPoint.getX()) * scale_x);
        bounds.setMinimumX((b.getMinimumX() - blkPoint.getX()) * scale_x);
        bounds.setMaximumY((b.getMaximumY() - blkPoint.getY()) * scale_y);
        bounds.setMinimumY((b.getMinimumY() - blkPoint.getY()) * scale_y);

        // Rotate the Bounds
        if (rotate != 0) {
            Point p1 = rotatePoint(bounds.getMaximumX(), bounds.getMaximumY());
            Point p2 = rotatePoint(bounds.getMaximumX(), bounds.getMinimumY());
            Point p3 = rotatePoint(bounds.getMinimumX(), bounds.getMaximumY());
            Point p4 = rotatePoint(bounds.getMinimumX(), bounds.getMinimumY());

            // we have now 4 Points
            // and we have to check all if they are the new maximum/minimum
            // start with a empty bounds
            bounds = new Bounds();

            bounds.addToBounds(p1);
            bounds.addToBounds(p2);
            bounds.addToBounds(p3);
            bounds.addToBounds(p4);
        }

        // translate to the InsertPoint
        bounds.setMaximumX(bounds.getMaximumX() + insertPoint.getX());
        bounds.setMinimumX(bounds.getMinimumX() + insertPoint.getX());
        bounds.setMaximumY(bounds.getMaximumY() + insertPoint.getY());
        bounds.setMinimumY(bounds.getMinimumY() + insertPoint.getY());

        // add the space from columns and rows
        double width = (columns - 1) * column_spacing;
        double height = (rows - 1) * row_spacing;

        if (width >= 0) {
            bounds.setMinimumX(bounds.getMinimumX() - width);
        } else {
            bounds.setMaximumX(bounds.getMaximumX() - width);
        }

        if (height >= 0) {
            bounds.setMinimumY(bounds.getMinimumY() - height);
        } else {
            bounds.setMaximumY(bounds.getMaximumY() - height);
        }

        return bounds;
    }

    /**
     * Gets the block ID.
     *
     * @return Returns the blockID.
     */
    public String getBlockID() {
        return blockID;
    }

    /**
     * Sets the block ID.
     *
     * @param blockID            The blockID to set.
     */
    public void setBlockID(String blockID) {
        this.blockID = blockID;
    }

    /**
     * Gets the column spacing.
     *
     * @return Returns the column_spacing.
     */
    public double getColumnSpacing() {
        return column_spacing;
    }

    /**
     * Sets the column spacing.
     *
     * @param column_spacing            The column_spacing to set.
     */
    public void setColumnSpacing(double column_spacing) {
        this.column_spacing = column_spacing;
    }

    /**
     * Gets the columns.
     *
     * @return Returns the columns.
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Sets the columns.
     *
     * @param columns            The columns to set.
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * Gets the point.
     *
     * @return Returns the p.
     */
    public Point getPoint() {
        return insertPoint;
    }

    /**
     * Sets the point.
     *
     * @param p            The p to set.
     */
    public void setPoint(Point p) {
        this.insertPoint = p;
    }

    /**
     * Gets the rotate.
     *
     * @return Returns the rotate.
     */
    public double getRotate() {
        return rotate;
    }

    /**
     * Sets the rotate.
     *
     * @param rotate            The rotate to set.
     */
    public void setRotate(double rotate) {
        this.rotate = rotate;
    }

    /**
     * Gets the row spacing.
     *
     * @return Returns the row_spacing.
     */
    public double getRowSpacing() {
        return row_spacing;
    }

    /**
     * Sets the row spacing.
     *
     * @param row_spacing            The row_spacing to set.
     */
    public void setRowSpacing(double row_spacing) {
        this.row_spacing = row_spacing;
    }

    /**
     * Gets the rows.
     *
     * @return Returns the rows.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Sets the rows.
     *
     * @param rows            The rows to set.
     */
    public void setRows(int rows) {
        this.rows = rows;
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
     * Gets the scale Y.
     *
     * @return Returns the scale_y.
     */
    public double getScaleY() {
        return scale_y;
    }

    /**
     * Sets the scale Y.
     *
     * @param scale_y            The scale_y to set.
     */
    public void setScaleY(double scale_y) {
        this.scale_y = scale_y;
    }

    /**
     * Gets the scale Z.
     *
     * @return Returns the scale_z.
     */
    public double getScaleZ() {
        return scale_z;
    }

    /**
     * Sets the scale Z.
     *
     * @param scale_z            The scale_z to set.
     */
    public void setScaleZ(double scale_z) {
        this.scale_z = scale_z;
    }

    /**
     * Rotate point.
     *
     * @param x the x
     * @param y the y
     * @return the point
     */
    private Point rotatePoint(double x, double y) {
        double phi = Math.toRadians(rotate);
        Point point = new Point();

        // the rotation matrix
        point.setX((x * Math.cos(phi)) - (y * Math.sin(phi)));
        point.setY((x * Math.sin(phi)) + (y * Math.cos(phi)));

        return point;
    }

    public String getType() {
        return DXFConstants.ENTITY_TYPE_INSERT;
    }

    public double getLength() {
        return this.doc.getDXFBlock(this.blockID).getLength();
    }
}
