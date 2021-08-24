/*******************************************************************************************************
 *
 * DXFDictionaryHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.objects;

import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.dxf.objects.DXFDictionary;
import gama.ext.libs.kabeja.dxf.objects.DXFObject;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFDictionaryHandler.
 */
public class DXFDictionaryHandler extends AbstractDXFObjectHandler {
    
    /** The groupcode record name. */
    public final int GROUPCODE_RECORD_NAME = 3;
    
    /** The groupcode record id. */
    public final int GROUPCODE_RECORD_ID = 350;
    
    /** The dictionary. */
    protected DXFDictionary dictionary;
    
    /** The object name. */
    protected String objectName;
    
    /** The root dictionary parsed. */
    protected boolean rootDictionaryParsed = false;

    public void endObject() {
    }

    public DXFObject getDXFObject() {
        return dictionary;
    }

    public String getObjectType() {
        return DXFConstants.OBJECT_TYPE_DICTIONARY;
    }

    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_RECORD_NAME:
            this.objectName = value.getValue();

            break;

        case GROUPCODE_RECORD_ID:
            this.dictionary.putDXFObjectRelation(this.objectName,
                value.getValue());

            break;

        default:
            super.parseCommonGroupCode(groupCode, value, this.dictionary);
        }
    }

    public void startObject() {
        if (this.rootDictionaryParsed) {
            this.dictionary = new DXFDictionary();
        } else {
            this.dictionary = this.doc.getRootDXFDictionary();
            this.rootDictionaryParsed = true;
        }
    }
}
