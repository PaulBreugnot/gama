/*******************************************************************************************************
 *
 * ParserBuilder.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import gama.ext.libs.kabeja.parser.entities.DXF3DFaceHandler;
import gama.ext.libs.kabeja.parser.entities.DXF3DSolidHandler;
import gama.ext.libs.kabeja.parser.entities.DXFArcHandler;
import gama.ext.libs.kabeja.parser.entities.DXFBodyHandler;
import gama.ext.libs.kabeja.parser.entities.DXFCircleHandler;
import gama.ext.libs.kabeja.parser.entities.DXFDimensionHandler;
import gama.ext.libs.kabeja.parser.entities.DXFEllipseHandler;
import gama.ext.libs.kabeja.parser.entities.DXFHatchHandler;
import gama.ext.libs.kabeja.parser.entities.DXFImageHandler;
import gama.ext.libs.kabeja.parser.entities.DXFInsertHandler;
import gama.ext.libs.kabeja.parser.entities.DXFLWPolylineHandler;
import gama.ext.libs.kabeja.parser.entities.DXFLeaderHandler;
import gama.ext.libs.kabeja.parser.entities.DXFLineHandler;
import gama.ext.libs.kabeja.parser.entities.DXFMLineHandler;
import gama.ext.libs.kabeja.parser.entities.DXFMTextHandler;
import gama.ext.libs.kabeja.parser.entities.DXFPolylineHandler;
import gama.ext.libs.kabeja.parser.entities.DXFRayHandler;
import gama.ext.libs.kabeja.parser.entities.DXFRegionHandler;
import gama.ext.libs.kabeja.parser.entities.DXFSolidHandler;
import gama.ext.libs.kabeja.parser.entities.DXFSplineHandler;
import gama.ext.libs.kabeja.parser.entities.DXFTextHandler;
import gama.ext.libs.kabeja.parser.entities.DXFToleranceHandler;
import gama.ext.libs.kabeja.parser.entities.DXFTraceHandler;
import gama.ext.libs.kabeja.parser.entities.DXFViewportHandler;
import gama.ext.libs.kabeja.parser.entities.DXFXLineHandler;
import gama.ext.libs.kabeja.parser.objects.DXFDictionaryHandler;
import gama.ext.libs.kabeja.parser.objects.DXFImageDefHandler;
import gama.ext.libs.kabeja.parser.objects.DXFLayoutHandler;
import gama.ext.libs.kabeja.parser.objects.DXFMLineStyleHandler;
import gama.ext.libs.kabeja.parser.objects.DXFPlotsettingsHandler;
import gama.ext.libs.kabeja.parser.table.DXFDimensionStyleTableHandler;
import gama.ext.libs.kabeja.parser.table.DXFLayerTableHandler;
import gama.ext.libs.kabeja.parser.table.DXFLineTypeTableHandler;
import gama.ext.libs.kabeja.parser.table.DXFStyleTableHandler;
import gama.ext.libs.kabeja.parser.table.DXFVPortTableHandler;
import gama.ext.libs.kabeja.parser.table.DXFViewTableHandler;


/**
 * The Class ParserBuilder.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class ParserBuilder {
    
    /**
     * Creates the default parser.
     *
     * @return the parser
     */
    public static Parser createDefaultParser() {
        DXFParser parser = new DXFParser();

        Handler handler;

        handler = new DXFHeaderSectionHandler();

        parser.addHandler(handler);

        // the blocks handler
        HandlerManager handlerManager = new DXFBlocksSectionHandler();
        parser.addHandler(handlerManager);

        Handler h = new DXFLineHandler();
        handlerManager.addHandler(h);

        h = new DXFCircleHandler();
        handlerManager.addHandler(h);

        h = new DXFArcHandler();
        handlerManager.addHandler(h);

        h = new DXFPolylineHandler();
        handlerManager.addHandler(h);

        h = new DXFLWPolylineHandler();
        handlerManager.addHandler(h);

        h = new DXFMTextHandler();
        handlerManager.addHandler(h);

        h = new DXFTextHandler();
        handlerManager.addHandler(h);

        h = new DXFInsertHandler();
        handlerManager.addHandler(h);

        h = new DXFEllipseHandler();
        handlerManager.addHandler(h);

        h = new DXFSolidHandler();
        handlerManager.addHandler(h);

        h = new DXFTraceHandler();
        handlerManager.addHandler(h);

        h = new DXFDimensionHandler();
        handlerManager.addHandler(h);

        h = new DXFHatchHandler();
        handlerManager.addHandler(h);

        h = new DXFImageHandler();
        handlerManager.addHandler(h);

        h = new DXF3DFaceHandler();
        handlerManager.addHandler(h);

        h = new DXFRayHandler();
        handlerManager.addHandler(h);

        h = new DXFXLineHandler();
        handlerManager.addHandler(h);

        h = new DXFRegionHandler();
        handlerManager.addHandler(h);

        h = new DXFBodyHandler();
        handlerManager.addHandler(h);

        h = new DXF3DSolidHandler();
        handlerManager.addHandler(h);

        h = new DXFSplineHandler();
        handlerManager.addHandler(h);

        h = new DXFMLineHandler();
        handlerManager.addHandler(h);

        h = new DXFLeaderHandler();
        handlerManager.addHandler(h);

        h = new DXFToleranceHandler();
        handlerManager.addHandler(h);

        h = new DXFViewportHandler();
        handlerManager.addHandler(h);

        // the table handler
        handlerManager = new DXFTableSectionHandler();
        parser.addHandler(handlerManager);

        handler = new DXFLayerTableHandler();
        handlerManager.addHandler(handler);

        handler = new DXFLineTypeTableHandler();
        handlerManager.addHandler(handler);

        handler = new DXFDimensionStyleTableHandler();
        handlerManager.addHandler(handler);

        handler = new DXFStyleTableHandler();
        handlerManager.addHandler(handler);

        handler = new DXFVPortTableHandler();
        handlerManager.addHandler(handler);

        handler = new DXFViewTableHandler();
        handlerManager.addHandler(handler);

        // the entity section handler
        handlerManager = new DXFEntitiesSectionHandler();
        parser.addHandler(handlerManager);

        // the entity handlers
        h = new DXFLineHandler();
        handlerManager.addHandler(h);

        h = new DXFCircleHandler();
        handlerManager.addHandler(h);

        h = new DXFArcHandler();
        handlerManager.addHandler(h);

        h = new DXFPolylineHandler();
        handlerManager.addHandler(h);

        h = new DXFLWPolylineHandler();
        handlerManager.addHandler(h);

        h = new DXFMTextHandler();
        handlerManager.addHandler(h);

        h = new DXFTextHandler();
        handlerManager.addHandler(h);

        h = new DXFInsertHandler();
        handlerManager.addHandler(h);

        h = new DXFEllipseHandler();
        handlerManager.addHandler(h);

        h = new DXFSolidHandler();
        handlerManager.addHandler(h);

        h = new DXFTraceHandler();
        handlerManager.addHandler(h);

        h = new DXFDimensionHandler();
        handlerManager.addHandler(h);

        h = new DXFHatchHandler();
        handlerManager.addHandler(h);

        h = new DXFImageHandler();
        handlerManager.addHandler(h);

        h = new DXF3DFaceHandler();
        handlerManager.addHandler(h);

        h = new DXFRayHandler();
        handlerManager.addHandler(h);

        h = new DXFXLineHandler();
        handlerManager.addHandler(h);

        h = new DXFRegionHandler();
        handlerManager.addHandler(h);

        h = new DXFBodyHandler();
        handlerManager.addHandler(h);

        h = new DXF3DSolidHandler();
        handlerManager.addHandler(h);

        h = new DXFSplineHandler();
        handlerManager.addHandler(h);

        h = new DXFMLineHandler();
        handlerManager.addHandler(h);

        h = new DXFLeaderHandler();
        handlerManager.addHandler(h);

        h = new DXFToleranceHandler();
        handlerManager.addHandler(h);

        h = new DXFViewportHandler();
        handlerManager.addHandler(h);

        // the OBJECTS section
        handlerManager = new DXFObjectsSectionHandler();

        h = new DXFImageDefHandler();
        handlerManager.addHandler(h);

        h = new DXFDictionaryHandler();
        handlerManager.addHandler(h);

        h = new DXFPlotsettingsHandler();
        handlerManager.addHandler(h);

        h = new DXFLayoutHandler();
        handlerManager.addHandler(h);

        h = new DXFMLineStyleHandler();
        handlerManager.addHandler(h);

        //add the HandlerManager as Handler to the parser
        parser.addHandler(handlerManager);

        return parser;
    }

    /**
     * Builds the from XML.
     *
     * @param file the file
     * @return the DXFParser build from the XML description file
     * @see org.kabeja.parser.SAXParserBuilder the SAXParserBuilder for XML
     *      description
     */
    public static Parser buildFromXML(String file) {
        try {
            return buildFromXML(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Builds the from XML.
     *
     * @param in the in
     * @return the parser
     */
    public static Parser buildFromXML(InputStream in) {
        return SAXParserBuilder.buildFromStream(in);
    }
}
