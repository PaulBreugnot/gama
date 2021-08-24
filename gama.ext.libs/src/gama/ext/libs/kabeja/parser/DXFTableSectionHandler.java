/*******************************************************************************************************
 *
 * DXFTableSectionHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser;

import java.util.Hashtable;
import java.util.Iterator;

import gama.ext.libs.kabeja.parser.table.DXFTableHandler;


/**
 * The Class DXFTableSectionHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFTableSectionHandler extends AbstractSectionHandler
    implements HandlerManager {
    
    /** The Constant sectionKey. */
    public final static String sectionKey = "TABLES";
    
    /** The Constant TABLE_START. */
    public final static String TABLE_START = "TABLE";
    
    /** The Constant TABLE_END. */
    public final static String TABLE_END = "ENDTAB";
    
    /** The table code. */
    public final int TABLE_CODE = 0;
    
    /** The table. */
    private String table = "";
    
    /** The handler. */
    private DXFTableHandler handler;
    
    /** The handlers. */
    private Hashtable handlers = new Hashtable();
    
    /** The parse. */
    private boolean parse = false;

    /**
     * Instantiates a new DXF table section handler.
     */
    public DXFTableSectionHandler() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.SectionHandler#getSectionKey()
     */
    public String getSectionKey() {
        return sectionKey;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.SectionHandler#parseGroup(int, java.lang.String)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        if (groupCode == TABLE_CODE) {
            //switch table
            if (TABLE_END.equals(value)) {
                table = "";

                if (parse) {
                    handler.endParsing();
                    parse = false;
                }
            } else if (TABLE_START.equals(value)) {
            } else {
                if (parse) {
                    handler.endParsing();
                }

                table = value.getValue();

                if (handlers.containsKey(table)) {
                    handler = (DXFTableHandler) handlers.get(table);
                    handler.setDXFDocument(this.doc);
                    handler.startParsing();
                    parse = true;
                } else {
                    parse = false;
                }
            }
        } else {
            if (parse) {
                handler.parseGroup(groupCode, value);
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.SectionHandler#endParsing()
     */
    public void endSection() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.SectionHandler#startParsing()
     */
    public void startSection() {
        parse = false;
    }

    public void addHandler(Handler handler) {
        addDXFTableHandler((DXFTableHandler) handler);
    }

    /**
     * Adds the DXF table handler.
     *
     * @param handler the handler
     */
    public void addDXFTableHandler(DXFTableHandler handler) {
        handlers.put(handler.getTableKey(), handler);
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.Handler#releaseDXFDocument()
     */
    public void releaseDXFDocument() {
        this.doc = null;

        Iterator i = handlers.values().iterator();

        while (i.hasNext()) {
            Handler handler = (Handler) i.next();
            handler.releaseDXFDocument();
        }
    }
}
