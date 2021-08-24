/*******************************************************************************************************
 *
 * DXFStreamEntityFilter.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.dxf.filter;

import gama.ext.libs.kabeja.parser.DXFValue;
import gama.ext.libs.kabeja.parser.ParseException;


/**
 * The Class DXFStreamEntityFilter.
 */
abstract class DXFStreamEntityFilter extends DXFStreamSectionFilter {
    
    /** The section key. */
    private static String SECTION_KEY = "ENTITIES";
    
    /** The Constant ENTITY_START. */
    public static final int ENTITY_START = 0;
    
    /** The entity section. */
    protected boolean entitySection = false;
    
    /** The parse entity. */
    protected boolean parseEntity = false;
    
    /** The parse header. */
    protected boolean parseHeader = false;

    protected void parseSection(int groupCode, DXFValue value)
        throws ParseException {
        if (parseHeader) {
            if (value.getValue().equals(SECTION_KEY)) {
                this.entitySection = true;
                this.parseHeader = false;
            }
        } else if (entitySection) {
            if (groupCode == ENTITY_START) {
                if (parseEntity) {
                    endEntity();
                } else {
                    parseEntity = true;
                }

                startEntity(value.getValue());
            }

            parseEntity(groupCode, value);

            return;
        }

        handler.parseGroup(groupCode, value);
    }

    protected void sectionEnd(String Section) throws ParseException {
        if (section.equals(SECTION_KEY)) {
            this.entitySection = false;
        }
    }

    protected void sectionStart(String Section) throws ParseException {
        if (section.equals(SECTION_KEY)) {
            this.parseHeader = true;
        }
    }

    /**
     * Start entity.
     *
     * @param type the type
     * @throws ParseException the parse exception
     */
    protected abstract void startEntity(String type) throws ParseException;

    /**
     * End entity.
     *
     * @throws ParseException the parse exception
     */
    protected abstract void endEntity() throws ParseException;

    /**
     * Parses the entity.
     *
     * @param groupCode the group code
     * @param value the value
     * @throws ParseException the parse exception
     */
    protected abstract void parseEntity(int groupCode, DXFValue value)
        throws ParseException;
}
