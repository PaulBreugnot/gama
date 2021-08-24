/*******************************************************************************************************
 *
 * DXFStreamSectionFilter.java, in gama.ext.libs, is part of the source code of the
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
 * The Class DXFStreamSectionFilter.
 */
abstract class DXFStreamSectionFilter extends AbstractDXFStreamFilter {
    
    /** The Constant SECTION_START. */
    private final static String SECTION_START = "SECTION";
    
    /** The Constant SECTION_END. */
    private final static String SECTION_END = "ENDSEC";
    
    /** The Constant COMMAND_CODE. */
    private final static int COMMAND_CODE = 0;
    
    /** The section starts. */
    protected boolean sectionStarts = false;
    
    /** The section. */
    protected String section;

    public void parseGroup(int groupCode, DXFValue value)
        throws ParseException {
        if ((groupCode == COMMAND_CODE) &&
                SECTION_START.equals(value.getValue())) {
            sectionStarts = true;
        } else if (sectionStarts) {
            sectionStarts = false;
            section = value.getValue();
            sectionStart(section);
            parseSection(COMMAND_CODE, new DXFValue(SECTION_START));
            parseSection(groupCode, value);
        } else {
            parseSection(groupCode, value);
        }

        if ((groupCode == COMMAND_CODE) &&
                SECTION_END.equals(value.getValue())) {
            sectionEnd(section);
        }
    }

    /**
     * Parses the section.
     *
     * @param groupCode the group code
     * @param value the value
     * @throws ParseException the parse exception
     */
    protected abstract void parseSection(int groupCode, DXFValue value)
        throws ParseException;

    /**
     * Section start.
     *
     * @param Section the section
     * @throws ParseException the parse exception
     */
    protected abstract void sectionStart(String Section)
        throws ParseException;

    /**
     * Section end.
     *
     * @param Section the section
     * @throws ParseException the parse exception
     */
    protected abstract void sectionEnd(String Section)
        throws ParseException;
}
