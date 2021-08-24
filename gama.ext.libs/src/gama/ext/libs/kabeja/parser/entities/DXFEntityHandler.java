/*******************************************************************************************************
 *
 * DXFEntityHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.entities;

import gama.ext.libs.kabeja.dxf.DXFDocument;
import gama.ext.libs.kabeja.dxf.DXFEntity;
import gama.ext.libs.kabeja.parser.DXFValue;
import gama.ext.libs.kabeja.parser.Handler;


/**
 *
 * This interface descripe an Entity jandler, which should
 * handle (parse) an DXF entity.
 *
 * <h3>Lifecycle</h3>
 * <ol>
 * <li>setDXFDocument</li>
 * <li>startDXFEntity</li>
 * <li>parseGroup (multiple)</li>
 * <li>isFollowSequence (need for polylines, where multiple vertices follow)</li>
 * <li>endDXFEntity</li>
 * <li>getDXFEntity</li>
 * </lo>
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public interface DXFEntityHandler extends Handler {
    
    /**
     * Gets the DXF entity name.
     *
     * @return the DXFEntity name (LINE,POLYLINE,TEXT,...)
     */
    public abstract String getDXFEntityName();

    public void setDXFDocument(DXFDocument doc);

    /**
     * Will called if the entity block starts.
     *
     */
    public abstract void startDXFEntity();

    /**
     * Parses the group.
     *
     * @param groupCode the group code
     * @param value the value
     */
    public abstract void parseGroup(int groupCode, DXFValue value);

    /**
     * Called after endDXFEntity.
     * @return the parsed Entity
     */
    public abstract DXFEntity getDXFEntity();

    /**
     * Will called if the entity block ends.
     *
     */
    public abstract void endDXFEntity();

    /**
     * Checks if is follow sequence.
     *
     * @return true if the this DXFEntityHandler have to parse the following entities (like POLYLINE),
     *  otherwise false (like TEXT,LINE).
     */
    public abstract boolean isFollowSequence();
}
