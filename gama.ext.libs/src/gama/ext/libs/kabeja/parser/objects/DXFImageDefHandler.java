/*******************************************************************************************************
 *
 * DXFImageDefHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.objects;

import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.dxf.objects.DXFImageDefObject;
import gama.ext.libs.kabeja.dxf.objects.DXFObject;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFImageDefHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFImageDefHandler extends AbstractDXFObjectHandler {
    
    /** The Constant GROUPCODE_FILENAME. */
    public final static int GROUPCODE_FILENAME = 1;
    
    /** The image def. */
    protected DXFImageDefObject imageDef;

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.objects.DXFObjectHandler#getObjectType()
     */
    public String getObjectType() {
        return DXFConstants.OBJECT_TYPE_IMAGEDEF;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.objects.DXFObjectHandler#startObject()
     */
    public void startObject() {
        imageDef = new DXFImageDefObject();
        imageDef.setDXFDocument(this.doc);
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.objects.DXFObjectHandler#endObject()
     */
    public void endObject() {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.objects.DXFObjectHandler#getDXFObject()
     */
    public DXFObject getDXFObject() {
        // TODO Auto-generated method stub
        return imageDef;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.objects.DXFObjectHandler#parseGroup(int,
     *      de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_FILENAME:
            imageDef.setFilename(value.getValue());

            break;

        default:
            super.parseCommonGroupCode(groupCode, value, imageDef);

            break;
        }
    }
}
