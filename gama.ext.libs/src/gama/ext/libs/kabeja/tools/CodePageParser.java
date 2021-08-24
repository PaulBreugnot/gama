/*******************************************************************************************************
 *
 * CodePageParser.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.tools;

import java.io.BufferedReader;
import java.io.IOException;

import gama.ext.libs.kabeja.dxf.DXFConstants;


/**
 * The Class CodePageParser.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class CodePageParser {
    
    /** The Constant CODEPAGE_CODE. */
    public static final String CODEPAGE_CODE = "$DWGCODEPAGE";
    
    /** The Constant GROUPCODE. */
    public static final String GROUPCODE = "3";
    
    /** The Constant prefix. */
    private static final String[] prefix = { "ansi_", "dos" };
    
    /** The Constant javaPrefix. */
    private static final String javaPrefix = "Cp";

    /**
     * Parses the encoding.
     *
     * @param reader the reader
     * @return the string
     */
    public String parseEncoding(BufferedReader reader) {
        String encoding = "";

        try {
            String line = null;
            String code;
            String value;
            boolean next = true;
            boolean codepage = false;
            boolean key = true;
            String currentKey = null;

            while (((line = reader.readLine()) != null) && next) {
                line = line.trim();

                if (key) {
                    currentKey = line;
                    key = false;
                } else {
                    key = true;

                    // we read the first section
                    if (DXFConstants.SECTION_END.equals(line)) {
                        return encoding;
                    } else if (CODEPAGE_CODE.equals(line)) {
                        codepage = true;
                    } else if (codepage && currentKey.equals("3")) {
                        // the encoding
                        return translateCodePage(line);
                    } else if (DXFConstants.SECTION_CLASSES.equals(line) ||
                            DXFConstants.SECTION_BLOCKS.equals(line) ||
                            DXFConstants.SECTION_ENTITIES.equals(line)) {
                        return encoding;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return encoding;
    }

    /**
     * Translate code page.
     *
     * @param cp the cp
     * @return the string
     */
    public String translateCodePage(String cp) {
        String c = cp.toLowerCase();

        for (int i = 0; i < prefix.length; i++) {
            if (c.startsWith(prefix[i])) {
                return javaPrefix + cp.substring(prefix[i].length());
            }
        }

        return cp;
    }
}
