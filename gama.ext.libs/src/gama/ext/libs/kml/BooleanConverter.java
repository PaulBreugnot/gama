/*******************************************************************************************************
 *
 * BooleanConverter.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * The Class BooleanConverter.
 */
public final class BooleanConverter
    extends XmlAdapter<Integer, Boolean>
{


    @Override
    public Boolean unmarshal(final Integer i)
        throws Exception
    {
        return ((i == null)?null:(i == 1));
    }

    @Override
    public Integer marshal(final Boolean b)
        throws Exception
    {
        return ((b == null)?null:(b? 1 : 0));
    }

}
