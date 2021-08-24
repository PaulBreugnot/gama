/*******************************************************************************************************
 *
 * CoordinatesConverter.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * The Class CoordinatesConverter.
 */
public final class CoordinatesConverter
    extends XmlAdapter<String, List<Coordinate>>
{


    @Override
    public String marshal(final List<Coordinate> dt)
        throws Exception
    {
        StringBuilder sb = new StringBuilder();
        for (Coordinate coord: dt) {
            sb.append((coord + " "));
        }
        return sb.toString().trim();
    }

    @Override
    public List<Coordinate> unmarshal(final String s)
        throws Exception
    {
        String[] coords = s.replaceAll(",[\\s]+", ",").trim().split("\\s+");
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        if (coords.length<= 0) {
            return coordinates;
        }
        for (String string: coords) {
            coordinates.add(new Coordinate(string));
        }
        return coordinates;
    }

}
