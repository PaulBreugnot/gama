/*******************************************************************************************************
 *
 * DXFBlocksSectionHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser;

import gama.ext.libs.kabeja.dxf.DXFBlock;
import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.dxf.DXFDocument;
import gama.ext.libs.kabeja.dxf.DXFEntity;


/**
 * The Class DXFBlocksSectionHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFBlocksSectionHandler extends DXFEntitiesSectionHandler {
    
    /** The Constant SECTION_KEY. */
    public final static String SECTION_KEY = "BLOCKS";
    
    /** The Constant BLOCK_START. */
    public final static String BLOCK_START = "BLOCK";
    
    /** The Constant BLOCK_END. */
    public final static String BLOCK_END = "ENDBLK";
    
    /** The Constant BLOCK. */
    public final static int BLOCK = 0;
    
    /** The Constant BLOCK_NAME. */
    public final static int BLOCK_NAME = 2;
    
    /** The Constant BLOCK_NAME2. */
    public final static int BLOCK_NAME2 = 3;
    
    /** The Constant BLOCK_DESCRIPTION. */
    public final static int BLOCK_DESCRIPTION = 4;
    
    /** The Constant BLOCK_XREFPATHNAME. */
    public final static int BLOCK_XREFPATHNAME = 1;
    
    /** The Constant BLOCK_BASE_X. */
    public final static int BLOCK_BASE_X = 10;
    
    /** The Constant BLOCK_BASE_Y. */
    public final static int BLOCK_BASE_Y = 20;
    
    /** The Constant BLOCK_BASE_Z. */
    public final static int BLOCK_BASE_Z = 30;
    
    /** The parse block header. */
    protected boolean parseBlockHeader = false;
    
    /** The block. */
    private DXFBlock block;

    /**
     * Instantiates a new DXF blocks section handler.
     */
    public DXFBlocksSectionHandler() {
        super();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.DXFSectionHandler#getSectionKey()
     */
    public String getSectionKey() {
        return SECTION_KEY;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.DXFSectionHandler#parseGroup(int,
     *      org.dxf2svg.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case BLOCK:

            if (BLOCK_START.equals(value.getValue())) {
                // handle
                parseBlockHeader = true;

                block = new DXFBlock();
            } else if (BLOCK_END.equals(value.getValue())) {
                // handle
                endEntity();

                doc.addDXFBlock(block);
            } else {
                // an entity
                parseBlockHeader = false;
                super.parseGroup(groupCode, value);
            }

            break;

        case BLOCK_NAME:

            if (parseBlockHeader) {
                block.setName(value.getValue());
            } else {
                super.parseGroup(groupCode, value);
            }

            break;

        case BLOCK_NAME2:

            if (parseBlockHeader) {
            } else {
                super.parseGroup(groupCode, value);
            }

            break;

        case BLOCK_DESCRIPTION:

            if (parseBlockHeader) {
                block.setDescription(value.getValue());
            } else {
                super.parseGroup(groupCode, value);
            }

            break;

        case DXFConstants.GROUPCODE_STANDARD_LAYER:

            if (parseBlockHeader) {
                block.setLayerID(value.getValue());
            } else {
                super.parseGroup(groupCode, value);
            }

            break;

        case BLOCK_BASE_X:

            if (parseBlockHeader) {
                block.getReferencePoint().setX(value.getDoubleValue());
            } else {
                super.parseGroup(groupCode, value);
            }

            break;

        case BLOCK_BASE_Y:

            if (parseBlockHeader) {
                block.getReferencePoint().setY(value.getDoubleValue());
            } else {
                super.parseGroup(groupCode, value);
            }

            break;

        case BLOCK_BASE_Z:

            if (parseBlockHeader) {
                block.getReferencePoint().setZ(value.getDoubleValue());
            } else {
                super.parseGroup(groupCode, value);
            }

            break;

        default:
            super.parseGroup(groupCode, value);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.DXFSectionHandler#setDXFDocument(org.dxf2svg.dxf.DXFDocument)
     */
    public void setDXFDocument(DXFDocument doc) {
        super.setDXFDocument(doc);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.DXFSectionHandler#startSection()
     */
    public void startSection() {
        parseEntity = false;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.DXFSectionHandler#endSection()
     */
    public void endSection() {
        // endEntity();
    }

    protected void endEntity() {
        if (parseEntity) {
            handler.endDXFEntity();

            DXFEntity entity = handler.getDXFEntity();
            block.addDXFEntity(entity);
            parseEntity = false;
        }
    }
}
