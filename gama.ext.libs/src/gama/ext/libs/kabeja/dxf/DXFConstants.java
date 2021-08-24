/*******************************************************************************************************
 *
 * DXFConstants.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import gama.ext.libs.kabeja.dxf.helpers.Vector;


/**
 * The Class DXFConstants.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFConstants {
    
    /** The Constant COMMAND_CODE. */
    public final static int COMMAND_CODE = 0;
    
    /** The Constant DEFAULT_LAYER. */
    public static final String DEFAULT_LAYER = "0";
    
    /** The Constant DEFAULT_X_AXIS_VECTOR. */
    public final static Vector DEFAULT_X_AXIS_VECTOR = new Vector(1.0, 0.0, 0.0);
    
    /** The Constant DEFAULT_Y_AXIS_VECTOR. */
    public final static Vector DEFAULT_Y_AXIS_VECTOR = new Vector(0.0, 1.0, 0.0);
    
    /** The Constant DEFAULT_Z_AXIS_VECTOR. */
    public final static Vector DEFAULT_Z_AXIS_VECTOR = new Vector(0.0, 0.0, 1.0);
    
    /** The Constant DICTIONARY_KEY_GROUP. */
    public final static String DICTIONARY_KEY_GROUP = "ACAD_GROUP";
    
    /** The Constant DICTIONARY_KEY_LAYOUT. */
    public final static String DICTIONARY_KEY_LAYOUT = "ACAD_LAYOUT";
    
    /** The Constant DICTIONARY_KEY_MLINESTYLE. */
    public final static String DICTIONARY_KEY_MLINESTYLE = "ACAD_MLINESTYLE";
    
    /** The Constant DICTIONARY_KEY_PLOTSETTINGS. */
    public final static String DICTIONARY_KEY_PLOTSETTINGS = "ACAD_PLOTSETTINGS";
    
    /** The Constant DICTIONARY_KEY_PLOTSTYLENAME. */
    public final static String DICTIONARY_KEY_PLOTSTYLENAME = "ACAD_PLOTSTYLENAME";
    
    /** The Constant END_STREAM. */
    public final static String END_STREAM = "EOF";
    
    /** The Constant ENTITY_TYPE_3DFACE. */
    public final static String ENTITY_TYPE_3DFACE = "3DFACE";
    
    /** The Constant ENTITY_TYPE_3DSOLID. */
    public final static String ENTITY_TYPE_3DSOLID = "3DSOLID";

    /** The Constant ENTITY_TYPE_ARC. */
    //Entity types
    public final static String ENTITY_TYPE_ARC = "ARC";
    
    /** The Constant ENTITY_TYPE_ATTRIB. */
    public final static String ENTITY_TYPE_ATTRIB = "ATTRIB";
    
    /** The Constant ENTITY_TYPE_BODY. */
    public final static String ENTITY_TYPE_BODY = "BODY";
    
    /** The Constant ENTITY_TYPE_CIRCLE. */
    public final static String ENTITY_TYPE_CIRCLE = "CIRCLE";
    
    /** The Constant ENTITY_TYPE_DIMENSION. */
    public final static String ENTITY_TYPE_DIMENSION = "DIMENSION";
    
    /** The Constant ENTITY_TYPE_ELLIPSE. */
    public final static String ENTITY_TYPE_ELLIPSE = "ELLIPSE";
    
    /** The Constant ENTITY_TYPE_HATCH. */
    public final static String ENTITY_TYPE_HATCH = "HATCH";
    
    /** The Constant ENTITY_TYPE_IMAGE. */
    public final static String ENTITY_TYPE_IMAGE = "IMAGE";
    
    /** The Constant ENTITY_TYPE_INSERT. */
    public final static String ENTITY_TYPE_INSERT = "INSERT";
    
    /** The Constant ENTITY_TYPE_LEADER. */
    public final static String ENTITY_TYPE_LEADER = "LEADER";
    
    /** The Constant ENTITY_TYPE_LINE. */
    public final static String ENTITY_TYPE_LINE = "LINE";
    
    /** The Constant ENTITY_TYPE_LWPOLYLINE. */
    public final static String ENTITY_TYPE_LWPOLYLINE = "LWPOLYLINE";
    
    /** The Constant ENTITY_TYPE_MLINE. */
    public final static String ENTITY_TYPE_MLINE = "MLINE";
    
    /** The Constant ENTITY_TYPE_MTEXT. */
    public final static String ENTITY_TYPE_MTEXT = "MTEXT";
    
    /** The Constant ENTITY_TYPE_POINT. */
    public final static String ENTITY_TYPE_POINT = "POINT";
    
    /** The Constant ENTITY_TYPE_POLYLINE. */
    public final static String ENTITY_TYPE_POLYLINE = "POLYLINE";
    
    /** The Constant ENTITY_TYPE_RAY. */
    public final static String ENTITY_TYPE_RAY = "RAY";
    
    /** The Constant ENTITY_TYPE_REGION. */
    public final static String ENTITY_TYPE_REGION = "REGION";
    
    /** The Constant ENTITY_TYPE_SHAPE. */
    public final static String ENTITY_TYPE_SHAPE = "SHAPE";
    
    /** The Constant ENTITY_TYPE_SOLID. */
    public final static String ENTITY_TYPE_SOLID = "SOLID";
    
    /** The Constant ENTITY_TYPE_SPLINE. */
    public final static String ENTITY_TYPE_SPLINE = "SPLINE";
    
    /** The Constant ENTITY_TYPE_TABLE. */
    public final static String ENTITY_TYPE_TABLE = "TABLE";
    
    /** The Constant ENTITY_TYPE_TEXT. */
    public final static String ENTITY_TYPE_TEXT = "TEXT";
    
    /** The Constant ENTITY_TYPE_TOLERANCE. */
    public final static String ENTITY_TYPE_TOLERANCE = "TOLERANCE";
    
    /** The Constant ENTITY_TYPE_TRACE. */
    public final static String ENTITY_TYPE_TRACE = "TRACE";
    
    /** The Constant ENTITY_TYPE_VERTEX. */
    public final static String ENTITY_TYPE_VERTEX = "VERTEX";
    
    /** The Constant ENTITY_TYPE_VIEWPORT. */
    public final static String ENTITY_TYPE_VIEWPORT = "VIEWPORT";
    
    /** The Constant ENTITY_TYPE_XLINE. */
    public final static String ENTITY_TYPE_XLINE = "XLINE";
    
    /** The Constant ENVIRONMENT_VARIABLE_LWDEFAULT. */
    public final static int ENVIRONMENT_VARIABLE_LWDEFAULT = 25;
    
    /** The Constant GROUPCODE_STANDARD_FLAGS. */
    public final static int GROUPCODE_STANDARD_FLAGS = 70;
    
    /** The Constant GROUPCODE_STANDARD_LAYER. */
    public final static int GROUPCODE_STANDARD_LAYER = 8;
    
    /** The Constant GROUPCODE_SUBCLASS_MARKER. */
    public final static int GROUPCODE_SUBCLASS_MARKER = 100;
    
    /** The Constant HEADER_VARIABLE_ACADMAINTVER. */
    public static final String HEADER_VARIABLE_ACADMAINTVER = "$ACADMAINTVER";
    
    /** The Constant HEADER_VARIABLE_ACADVER. */
    public static final String HEADER_VARIABLE_ACADVER = "$ACADVER";
    
    /** The Constant HEADER_VARIABLE_ANGBASE. */
    public static final String HEADER_VARIABLE_ANGBASE = "$ANGBASE";
    
    /** The Constant HEADER_VARIABLE_ANGDIR. */
    public static final String HEADER_VARIABLE_ANGDIR = "$ANGDIR";
    
    /** The Constant HEADER_VARIABLE_ATTMODE. */
    public static final String HEADER_VARIABLE_ATTMODE = "$ATTMODE";
    
    /** The Constant HEADER_VARIABLE_AUNITS. */
    public static final String HEADER_VARIABLE_AUNITS = "$AUNITS";
    
    /** The Constant HEADER_VARIABLE_AUPREC. */
    public static final String HEADER_VARIABLE_AUPREC = "$AUPREC";
    
    /** The Constant HEADER_VARIABLE_CECOLOR. */
    public static final String HEADER_VARIABLE_CECOLOR = "$CECOLOR";
    
    /** The Constant HEADER_VARIABLE_CELTSCALE. */
    public static final String HEADER_VARIABLE_CELTSCALE = "$CELTSCALE";
    
    /** The Constant HEADER_VARIABLE_CELTYPE. */
    public static final String HEADER_VARIABLE_CELTYPE = "$CELTYPE";
    
    /** The Constant HEADER_VARIABLE_CELWEIGHT. */
    public static final String HEADER_VARIABLE_CELWEIGHT = "$CELWEIGHT";
    
    /** The Constant HEADER_VARIABLE_CEPSNID. */
    public static final String HEADER_VARIABLE_CEPSNID = "$CEPSNID";
    
    /** The Constant HEADER_VARIABLE_CEPSNTYPE. */
    public static final String HEADER_VARIABLE_CEPSNTYPE = "$CEPSNTYPE";
    
    /** The Constant HEADER_VARIABLE_CHAMFERA. */
    public static final String HEADER_VARIABLE_CHAMFERA = "$CHAMFERA";
    
    /** The Constant HEADER_VARIABLE_CHAMFERB. */
    public static final String HEADER_VARIABLE_CHAMFERB = "$CHAMFERB";
    
    /** The Constant HEADER_VARIABLE_CHAMFERC. */
    public static final String HEADER_VARIABLE_CHAMFERC = "$CHAMFERC";
    
    /** The Constant HEADER_VARIABLE_CHAMFERD. */
    public static final String HEADER_VARIABLE_CHAMFERD = "$CHAMFERD";
    
    /** The Constant HEADER_VARIABLE_CLAYER. */
    public static final String HEADER_VARIABLE_CLAYER = "$CLAYER";
    
    /** The Constant HEADER_VARIABLE_CMLJUST. */
    public static final String HEADER_VARIABLE_CMLJUST = "$CMLJUST";
    
    /** The Constant HEADER_VARIABLE_CMLSCALE. */
    public static final String HEADER_VARIABLE_CMLSCALE = "$CMLSCALE";
    
    /** The Constant HEADER_VARIABLE_CMLSTYLE. */
    public static final String HEADER_VARIABLE_CMLSTYLE = "$CMLSTYLE";
    
    /** The Constant HEADER_VARIABLE_DIMADEC. */
    public static final String HEADER_VARIABLE_DIMADEC = "$DIMADEC";
    
    /** The Constant HEADER_VARIABLE_DIMALT. */
    public static final String HEADER_VARIABLE_DIMALT = "$DIMALT";
    
    /** The Constant HEADER_VARIABLE_DIMALTD. */
    public static final String HEADER_VARIABLE_DIMALTD = "$DIMALTD";
    
    /** The Constant HEADER_VARIABLE_DIMALTF. */
    public static final String HEADER_VARIABLE_DIMALTF = "$DIMALTF";
    
    /** The Constant HEADER_VARIABLE_DIMALTRND. */
    public static final String HEADER_VARIABLE_DIMALTRND = "$DIMALTRND";
    
    /** The Constant HEADER_VARIABLE_DIMALTTD. */
    public static final String HEADER_VARIABLE_DIMALTTD = "$DIMALTTD";
    
    /** The Constant HEADER_VARIABLE_DIMALTTZ. */
    public static final String HEADER_VARIABLE_DIMALTTZ = "$DIMALTTZ";
    
    /** The Constant HEADER_VARIABLE_DIMALTU. */
    public static final String HEADER_VARIABLE_DIMALTU = "$DIMALTU";
    
    /** The Constant HEADER_VARIABLE_DIMALTZ. */
    public static final String HEADER_VARIABLE_DIMALTZ = "$DIMALTZ";
    
    /** The Constant HEADER_VARIABLE_DIMAPOST. */
    public static final String HEADER_VARIABLE_DIMAPOST = "$DIMAPOST";
    
    /** The Constant HEADER_VARIABLE_DIMASO. */
    public static final String HEADER_VARIABLE_DIMASO = "$DIMASO";
    
    /** The Constant HEADER_VARIABLE_DIMASSOC. */
    public static final String HEADER_VARIABLE_DIMASSOC = "$DIMASSOC";
    
    /** The Constant HEADER_VARIABLE_DIMASZ. */
    public static final String HEADER_VARIABLE_DIMASZ = "$DIMASZ";
    
    /** The Constant HEADER_VARIABLE_DIMATFIT. */
    public static final String HEADER_VARIABLE_DIMATFIT = "$DIMATFIT";
    
    /** The Constant HEADER_VARIABLE_DIMAUNIT. */
    public static final String HEADER_VARIABLE_DIMAUNIT = "$DIMAUNIT";
    
    /** The Constant HEADER_VARIABLE_DIMAZIN. */
    public static final String HEADER_VARIABLE_DIMAZIN = "$DIMAZIN";
    
    /** The Constant HEADER_VARIABLE_DIMBLK. */
    public static final String HEADER_VARIABLE_DIMBLK = "$DIMBLK";
    
    /** The Constant HEADER_VARIABLE_DIMBLK1. */
    public static final String HEADER_VARIABLE_DIMBLK1 = "$DIMBLK1";
    
    /** The Constant HEADER_VARIABLE_DIMCEN. */
    public static final String HEADER_VARIABLE_DIMCEN = "$DIMCEN";
    
    /** The Constant HEADER_VARIABLE_DIMCLRD. */
    public static final String HEADER_VARIABLE_DIMCLRD = "$DIMCLRD";
    
    /** The Constant HEADER_VARIABLE_DIMCLRE. */
    public static final String HEADER_VARIABLE_DIMCLRE = "$DIMCLRE";
    
    /** The Constant HEADER_VARIABLE_DIMCLRT. */
    public static final String HEADER_VARIABLE_DIMCLRT = "$DIMCLRT";
    
    /** The Constant HEADER_VARIABLE_DIMDEC. */
    public static final String HEADER_VARIABLE_DIMDEC = "$DIMDEC";
    
    /** The Constant HEADER_VARIABLE_DIMDLE. */
    public static final String HEADER_VARIABLE_DIMDLE = "$DIMDLE";
    
    /** The Constant HEADER_VARIABLE_DIMDLI. */
    public static final String HEADER_VARIABLE_DIMDLI = "$DIMDLI";
    
    /** The Constant HEADER_VARIABLE_DIMDSEP. */
    public static final String HEADER_VARIABLE_DIMDSEP = "$DIMDSEP";
    
    /** The Constant HEADER_VARIABLE_DIMEXE. */
    public static final String HEADER_VARIABLE_DIMEXE = "$DIMEXE";
    
    /** The Constant HEADER_VARIABLE_DIMEXO. */
    public static final String HEADER_VARIABLE_DIMEXO = "$DIMEXO";
    
    /** The Constant HEADER_VARIABLE_DIMFAC. */
    public static final String HEADER_VARIABLE_DIMFAC = "$DIMFAC";
    
    /** The Constant HEADER_VARIABLE_DIMGAP. */
    public static final String HEADER_VARIABLE_DIMGAP = "$DIMGAP";
    
    /** The Constant HEADER_VARIABLE_DIMJUST. */
    public static final String HEADER_VARIABLE_DIMJUST = "$DIMJUST";
    
    /** The Constant HEADER_VARIABLE_DIMLDRBLK. */
    public static final String HEADER_VARIABLE_DIMLDRBLK = "$DIMLDRBLK";
    
    /** The Constant HEADER_VARIABLE_DIMLFAC. */
    public static final String HEADER_VARIABLE_DIMLFAC = "$DIMLFAC";
    
    /** The Constant HEADER_VARIABLE_DIMLIM. */
    public static final String HEADER_VARIABLE_DIMLIM = "$DIMLIM";
    
    /** The Constant HEADER_VARIABLE_DIMLUNIT. */
    public static final String HEADER_VARIABLE_DIMLUNIT = "$DIMLUNIT";
    
    /** The Constant HEADER_VARIABLE_DIMLWD. */
    public static final String HEADER_VARIABLE_DIMLWD = "$DIMLWD";
    
    /** The Constant HEADER_VARIABLE_DIMLWE. */
    public static final String HEADER_VARIABLE_DIMLWE = "$DIMLWE";
    
    /** The Constant HEADER_VARIABLE_DIMPOST. */
    public static final String HEADER_VARIABLE_DIMPOST = "$DIMPOST";
    
    /** The Constant HEADER_VARIABLE_DIMRND. */
    public static final String HEADER_VARIABLE_DIMRND = "$DIMRND";
    
    /** The Constant HEADER_VARIABLE_DIMSAH. */
    public static final String HEADER_VARIABLE_DIMSAH = "$DIMSAH";
    
    /** The Constant HEADER_VARIABLE_DIMSCALE. */
    public static final String HEADER_VARIABLE_DIMSCALE = "$DIMSCALE";
    
    /** The Constant HEADER_VARIABLE_DIMSD1. */
    public static final String HEADER_VARIABLE_DIMSD1 = "$DIMSD1";
    
    /** The Constant HEADER_VARIABLE_DIMSD2. */
    public static final String HEADER_VARIABLE_DIMSD2 = "$DIMSD2";
    
    /** The Constant HEADER_VARIABLE_DIMSE1. */
    public static final String HEADER_VARIABLE_DIMSE1 = "$DIMSE1";
    
    /** The Constant HEADER_VARIABLE_DIMSE2. */
    public static final String HEADER_VARIABLE_DIMSE2 = "$DIMSE2";
    
    /** The Constant HEADER_VARIABLE_DIMSHO. */
    public static final String HEADER_VARIABLE_DIMSHO = "$DIMSHO";
    
    /** The Constant HEADER_VARIABLE_DIMSOXD. */
    public static final String HEADER_VARIABLE_DIMSOXD = "$DIMSOXD";
    
    /** The Constant HEADER_VARIABLE_DIMSTYLE. */
    public static final String HEADER_VARIABLE_DIMSTYLE = "$DIMSTYLE";
    
    /** The Constant HEADER_VARIABLE_DIMTAD. */
    public static final String HEADER_VARIABLE_DIMTAD = "$DIMTAD";
    
    /** The Constant HEADER_VARIABLE_DIMTDEC. */
    public static final String HEADER_VARIABLE_DIMTDEC = "$DIMTDEC";
    
    /** The Constant HEADER_VARIABLE_DIMTFAC. */
    public static final String HEADER_VARIABLE_DIMTFAC = "$DIMTFAC";
    
    /** The Constant HEADER_VARIABLE_DIMTIH. */
    public static final String HEADER_VARIABLE_DIMTIH = "$DIMTIH";
    
    /** The Constant HEADER_VARIABLE_DIMTIX. */
    public static final String HEADER_VARIABLE_DIMTIX = "$DIMTIX";
    
    /** The Constant HEADER_VARIABLE_DIMTM. */
    public static final String HEADER_VARIABLE_DIMTM = "$DIMTM";
    
    /** The Constant HEADER_VARIABLE_DIMTMOVE. */
    public static final String HEADER_VARIABLE_DIMTMOVE = "$DIMTMOVE";
    
    /** The Constant HEADER_VARIABLE_DIMTOFL. */
    public static final String HEADER_VARIABLE_DIMTOFL = "$DIMTOFL";
    
    /** The Constant HEADER_VARIABLE_DIMTOH. */
    public static final String HEADER_VARIABLE_DIMTOH = "$DIMTOH";
    
    /** The Constant HEADER_VARIABLE_DIMTOL. */
    public static final String HEADER_VARIABLE_DIMTOL = "$DIMTOL";
    
    /** The Constant HEADER_VARIABLE_DIMTOLJ. */
    public static final String HEADER_VARIABLE_DIMTOLJ = "$DIMTOLJ";
    
    /** The Constant HEADER_VARIABLE_DIMTP. */
    public static final String HEADER_VARIABLE_DIMTP = "$DIMTP";
    
    /** The Constant HEADER_VARIABLE_DIMTSZ. */
    public static final String HEADER_VARIABLE_DIMTSZ = "$DIMTSZ";
    
    /** The Constant HEADER_VARIABLE_DIMTVP. */
    public static final String HEADER_VARIABLE_DIMTVP = "$DIMTVP";
    
    /** The Constant HEADER_VARIABLE_DIMTXSTY. */
    public static final String HEADER_VARIABLE_DIMTXSTY = "$DIMTXSTY";
    
    /** The Constant HEADER_VARIABLE_DIMTXT. */
    public static final String HEADER_VARIABLE_DIMTXT = "$DIMTXT";
    
    /** The Constant HEADER_VARIABLE_DIMTZIN. */
    public static final String HEADER_VARIABLE_DIMTZIN = "$DIMTZIN";
    
    /** The Constant HEADER_VARIABLE_DIMUPT. */
    public static final String HEADER_VARIABLE_DIMUPT = "$DIMUPT";
    
    /** The Constant HEADER_VARIABLE_DIMZIN. */
    public static final String HEADER_VARIABLE_DIMZIN = "$DIMZIN";
    
    /** The Constant HEADER_VARIABLE_DISPSILH. */
    public static final String HEADER_VARIABLE_DISPSILH = "$DISPSILH";
    
    /** The Constant HEADER_VARIABLE_DWGCODEPAGE. */
    public static final String HEADER_VARIABLE_DWGCODEPAGE = "$DWGCODEPAGE";
    
    /** The Constant HEADER_VARIABLE_ELEVATION. */
    public static final String HEADER_VARIABLE_ELEVATION = "$ELEVATION";
    
    /** The Constant HEADER_VARIABLE_ENDCAPS. */
    public static final String HEADER_VARIABLE_ENDCAPS = "$ENDCAPS";
    
    /** The Constant HEADER_VARIABLE_EXTMAX. */
    public static final String HEADER_VARIABLE_EXTMAX = "$EXTMAX";
    
    /** The Constant HEADER_VARIABLE_EXTMIN. */
    public static final String HEADER_VARIABLE_EXTMIN = "$EXTMIN";
    
    /** The Constant HEADER_VARIABLE_EXTNAMES. */
    public static final String HEADER_VARIABLE_EXTNAMES = "$EXTNAMES";

    /** Some older header variables maybe overriden by the vport table. */
    public static final String HEADER_VARIABLE_FASTZOOM = "$FASTZOOM";
    
    /** The Constant HEADER_VARIABLE_FILLETRAD. */
    public static final String HEADER_VARIABLE_FILLETRAD = "$FILLETRAD";
    
    /** The Constant HEADER_VARIABLE_FILLMODE. */
    public static final String HEADER_VARIABLE_FILLMODE = "$FILLMODE";
    
    /** The Constant HEADER_VARIABLE_FINGERPRINTGUID. */
    public static final String HEADER_VARIABLE_FINGERPRINTGUID = "$FINGERPRINTGUID";
    
    /** The Constant HEADER_VARIABLE_GRIDMODE. */
    public static final String HEADER_VARIABLE_GRIDMODE = "$GRIDMODE";
    
    /** The Constant HEADER_VARIABLE_GRIDUNIT. */
    public static final String HEADER_VARIABLE_GRIDUNIT = "$GRIDUNIT";
    
    /** The Constant HEADER_VARIABLE_HALOGAP. */
    public static final String HEADER_VARIABLE_HALOGAP = "$HALOGAP";
    
    /** The Constant HEADER_VARIABLE_HANDSEED. */
    public static final String HEADER_VARIABLE_HANDSEED = "$HANDSEED";
    
    /** The Constant HEADER_VARIABLE_HIDETEXT. */
    public static final String HEADER_VARIABLE_HIDETEXT = "$HIDETEXT";
    
    /** The Constant HEADER_VARIABLE_HYPERLINKBASE. */
    public static final String HEADER_VARIABLE_HYPERLINKBASE = "$HYPERLINKBASE";
    
    /** The Constant HEADER_VARIABLE_INDEXCTL. */
    public static final String HEADER_VARIABLE_INDEXCTL = "$INDEXCTL";
    
    /** The Constant HEADER_VARIABLE_INSBASE. */
    public static final String HEADER_VARIABLE_INSBASE = "$INSBASE";
    
    /** The Constant HEADER_VARIABLE_INSUNITS. */
    public static final String HEADER_VARIABLE_INSUNITS = "$INSUNITS";
    
    /** The Constant HEADER_VARIABLE_INTERSECTIONCOLOR. */
    public static final String HEADER_VARIABLE_INTERSECTIONCOLOR = "$INTERSECTIONCOLOR";
    
    /** The Constant HEADER_VARIABLE_INTERSECTIONDISPLAY. */
    public static final String HEADER_VARIABLE_INTERSECTIONDISPLAY = "$INTERSECTIONDISPLAY";
    
    /** The Constant HEADER_VARIABLE_JOINSTYLE. */
    public static final String HEADER_VARIABLE_JOINSTYLE = "$JOINSTYLE";
    
    /** The Constant HEADER_VARIABLE_LIMCHECK. */
    public static final String HEADER_VARIABLE_LIMCHECK = "$LIMCHECK";
    
    /** The Constant HEADER_VARIABLE_LIMMAX. */
    public static final String HEADER_VARIABLE_LIMMAX = "$LIMMAX";
    
    /** The Constant HEADER_VARIABLE_LIMMIN. */
    public static final String HEADER_VARIABLE_LIMMIN = "$LIMMIN";
    
    /** The Constant HEADER_VARIABLE_LTSCALE. */
    public static final String HEADER_VARIABLE_LTSCALE = "$LTSCALE";
    
    /** The Constant HEADER_VARIABLE_LUNITS. */
    public static final String HEADER_VARIABLE_LUNITS = "$LUNITS";
    
    /** The Constant HEADER_VARIABLE_LUPREC. */
    public static final String HEADER_VARIABLE_LUPREC = "$LUPREC";
    
    /** The Constant HEADER_VARIABLE_LWDISPLAY. */
    public static final String HEADER_VARIABLE_LWDISPLAY = "$LWDISPLAY";
    
    /** The Constant HEADER_VARIABLE_MAXACTVP. */
    public static final String HEADER_VARIABLE_MAXACTVP = "$MAXACTVP";
    
    /** The Constant HEADER_VARIABLE_MEASUREMENT. */
    public static final String HEADER_VARIABLE_MEASUREMENT = "$MEASUREMENT";
    
    /** The Constant HEADER_VARIABLE_MENU. */
    public static final String HEADER_VARIABLE_MENU = "$MENU";
    
    /** The Constant HEADER_VARIABLE_MIRRTEXT. */
    public static final String HEADER_VARIABLE_MIRRTEXT = "$MIRRTEXT";
    
    /** The Constant HEADER_VARIABLE_OBSCOLOR. */
    public static final String HEADER_VARIABLE_OBSCOLOR = "$OBSCOLOR";
    
    /** The Constant HEADER_VARIABLE_OBSLTYPE. */
    public static final String HEADER_VARIABLE_OBSLTYPE = "$OBSLTYPE";
    
    /** The Constant HEADER_VARIABLE_ORTHOMODE. */
    public static final String HEADER_VARIABLE_ORTHOMODE = "$ORTHOMODE";
    
    /** The Constant HEADER_VARIABLE_PDMODE. */
    public static final String HEADER_VARIABLE_PDMODE = "$PDMODE";
    
    /** The Constant HEADER_VARIABLE_PDSIZE. */
    public static final String HEADER_VARIABLE_PDSIZE = "$PDSIZE";
    
    /** The Constant HEADER_VARIABLE_PELEVATION. */
    public static final String HEADER_VARIABLE_PELEVATION = "$PELEVATION";
    
    /** The Constant HEADER_VARIABLE_PEXTMAX. */
    public static final String HEADER_VARIABLE_PEXTMAX = "$PEXTMAX";
    
    /** The Constant HEADER_VARIABLE_PEXTMIN. */
    public static final String HEADER_VARIABLE_PEXTMIN = "$PEXTMIN";
    
    /** The Constant HEADER_VARIABLE_PINSBASE. */
    public static final String HEADER_VARIABLE_PINSBASE = "$PINSBASE";
    
    /** The Constant HEADER_VARIABLE_PLIMCHECK. */
    public static final String HEADER_VARIABLE_PLIMCHECK = "$PLIMCHECK";
    
    /** The Constant HEADER_VARIABLE_PLIMMAX. */
    public static final String HEADER_VARIABLE_PLIMMAX = "$PLIMMAX";
    
    /** The Constant HEADER_VARIABLE_PLIMMIN. */
    public static final String HEADER_VARIABLE_PLIMMIN = "$PLIMMIN";
    
    /** The Constant HEADER_VARIABLE_PLINEGEN. */
    public static final String HEADER_VARIABLE_PLINEGEN = "$PLINEGEN";
    
    /** The Constant HEADER_VARIABLE_PLINEWID. */
    public static final String HEADER_VARIABLE_PLINEWID = "$PLINEWID";
    
    /** The Constant HEADER_VARIABLE_PROJECTNAME. */
    public static final String HEADER_VARIABLE_PROJECTNAME = "$PROJECTNAME";
    
    /** The Constant HEADER_VARIABLE_PROXYGRAPHICS. */
    public static final String HEADER_VARIABLE_PROXYGRAPHICS = "$PROXYGRAPHICS";
    
    /** The Constant HEADER_VARIABLE_PSLTSCALE. */
    public static final String HEADER_VARIABLE_PSLTSCALE = "$PSLTSCALE";
    
    /** The Constant HEADER_VARIABLE_PSTYLEMODE. */
    public static final String HEADER_VARIABLE_PSTYLEMODE = "$PSTYLEMODE";
    
    /** The Constant HEADER_VARIABLE_PSVPSCALE. */
    public static final String HEADER_VARIABLE_PSVPSCALE = "$PSVPSCALE";
    
    /** The Constant HEADER_VARIABLE_PUCSBASE. */
    public static final String HEADER_VARIABLE_PUCSBASE = "$PUCSBASE";
    
    /** The Constant HEADER_VARIABLE_PUCSNAME. */
    public static final String HEADER_VARIABLE_PUCSNAME = "$PUCSNAME";
    
    /** The Constant HEADER_VARIABLE_PUCSORG. */
    public static final String HEADER_VARIABLE_PUCSORG = "$PUCSORG";
    
    /** The Constant HEADER_VARIABLE_PUCSORGBACK. */
    public static final String HEADER_VARIABLE_PUCSORGBACK = "$PUCSORGBACK";
    
    /** The Constant HEADER_VARIABLE_PUCSORGBOTTOM. */
    public static final String HEADER_VARIABLE_PUCSORGBOTTOM = "$PUCSORGBOTTOM";
    
    /** The Constant HEADER_VARIABLE_PUCSORGFRONT. */
    public static final String HEADER_VARIABLE_PUCSORGFRONT = "$PUCSORGFRONT";
    
    /** The Constant HEADER_VARIABLE_PUCSORGLEFT. */
    public static final String HEADER_VARIABLE_PUCSORGLEFT = "$PUCSORGLEFT";
    
    /** The Constant HEADER_VARIABLE_PUCSORGRIGHT. */
    public static final String HEADER_VARIABLE_PUCSORGRIGHT = "$PUCSORGRIGHT";
    
    /** The Constant HEADER_VARIABLE_PUCSORGTOP. */
    public static final String HEADER_VARIABLE_PUCSORGTOP = "$PUCSORGTOP";
    
    /** The Constant HEADER_VARIABLE_PUCSORTHOREF. */
    public static final String HEADER_VARIABLE_PUCSORTHOREF = "$PUCSORTHOREF";
    
    /** The Constant HEADER_VARIABLE_PUCSORTHOVIEW. */
    public static final String HEADER_VARIABLE_PUCSORTHOVIEW = "$PUCSORTHOVIEW";
    
    /** The Constant HEADER_VARIABLE_PUCSXDIR. */
    public static final String HEADER_VARIABLE_PUCSXDIR = "$PUCSXDIR";
    
    /** The Constant HEADER_VARIABLE_PUCSYDIR. */
    public static final String HEADER_VARIABLE_PUCSYDIR = "$PUCSYDIR";
    
    /** The Constant HEADER_VARIABLE_QTEXTMODE. */
    public static final String HEADER_VARIABLE_QTEXTMODE = "$QTEXTMODE";
    
    /** The Constant HEADER_VARIABLE_REGENMODE. */
    public static final String HEADER_VARIABLE_REGENMODE = "$REGENMODE";
    
    /** The Constant HEADER_VARIABLE_SHADEDGE. */
    public static final String HEADER_VARIABLE_SHADEDGE = "$SHADEDGE";
    
    /** The Constant HEADER_VARIABLE_SHADEDIF. */
    public static final String HEADER_VARIABLE_SHADEDIF = "$SHADEDIF";
    
    /** The Constant HEADER_VARIABLE_SKETCHINC. */
    public static final String HEADER_VARIABLE_SKETCHINC = "$SKETCHINC";
    
    /** The Constant HEADER_VARIABLE_SKPOLY. */
    public static final String HEADER_VARIABLE_SKPOLY = "$SKPOLY";
    
    /** The Constant HEADER_VARIABLE_SNAPANG. */
    public static final String HEADER_VARIABLE_SNAPANG = "$SNAPANG";
    
    /** The Constant HEADER_VARIABLE_SNAPBASE. */
    public static final String HEADER_VARIABLE_SNAPBASE = "$SNAPBASE";
    
    /** The Constant HEADER_VARIABLE_SNAPISOPAIR. */
    public static final String HEADER_VARIABLE_SNAPISOPAIR = "$SNAPISOPAIR";
    
    /** The Constant HEADER_VARIABLE_SNAPMODE. */
    public static final String HEADER_VARIABLE_SNAPMODE = "$SNAPMODE";
    
    /** The Constant HEADER_VARIABLE_SNAPSTYLE. */
    public static final String HEADER_VARIABLE_SNAPSTYLE = "$SNAPSTYLE";
    
    /** The Constant HEADER_VARIABLE_SNAPUNIT. */
    public static final String HEADER_VARIABLE_SNAPUNIT = "$SNAPUNIT";
    
    /** The Constant HEADER_VARIABLE_SORTENTS. */
    public static final String HEADER_VARIABLE_SORTENTS = "$SORTENTS";
    
    /** The Constant HEADER_VARIABLE_SPLFRAME. */
    public static final String HEADER_VARIABLE_SPLFRAME = "$SPLFRAME";
    
    /** The Constant HEADER_VARIABLE_SPLINESEGS. */
    public static final String HEADER_VARIABLE_SPLINESEGS = "$SPLINESEGS";
    
    /** The Constant HEADER_VARIABLE_SPLINETYPE. */
    public static final String HEADER_VARIABLE_SPLINETYPE = "$SPLINETYPE";
    
    /** The Constant HEADER_VARIABLE_SURFTAB1. */
    public static final String HEADER_VARIABLE_SURFTAB1 = "$SURFTAB1";
    
    /** The Constant HEADER_VARIABLE_SURFTAB2. */
    public static final String HEADER_VARIABLE_SURFTAB2 = "$SURFTAB2";
    
    /** The Constant HEADER_VARIABLE_SURFTYPE. */
    public static final String HEADER_VARIABLE_SURFTYPE = "$SURFTYPE";
    
    /** The Constant HEADER_VARIABLE_SURFU. */
    public static final String HEADER_VARIABLE_SURFU = "$SURFU";
    
    /** The Constant HEADER_VARIABLE_SURFV. */
    public static final String HEADER_VARIABLE_SURFV = "$SURFV";
    
    /** The Constant HEADER_VARIABLE_TDCREATE. */
    public static final String HEADER_VARIABLE_TDCREATE = "$TDCREATE";
    
    /** The Constant HEADER_VARIABLE_TDINDWG. */
    public static final String HEADER_VARIABLE_TDINDWG = "$TDINDWG";
    
    /** The Constant HEADER_VARIABLE_TDUCREATE. */
    public static final String HEADER_VARIABLE_TDUCREATE = "$TDUCREATE";
    
    /** The Constant HEADER_VARIABLE_TDUPDATE. */
    public static final String HEADER_VARIABLE_TDUPDATE = "$TDUPDATE";
    
    /** The Constant HEADER_VARIABLE_TDUSRTIMER. */
    public static final String HEADER_VARIABLE_TDUSRTIMER = "$TDUSRTIMER";
    
    /** The Constant HEADER_VARIABLE_TDUUPDATE. */
    public static final String HEADER_VARIABLE_TDUUPDATE = "$TDUUPDATE";
    
    /** The Constant HEADER_VARIABLE_TEXTSIZE. */
    public static final String HEADER_VARIABLE_TEXTSIZE = "$TEXTSIZE";
    
    /** The Constant HEADER_VARIABLE_TEXTSTYLE. */
    public static final String HEADER_VARIABLE_TEXTSTYLE = "$TEXTSTYLE";
    
    /** The Constant HEADER_VARIABLE_THICKNESS. */
    public static final String HEADER_VARIABLE_THICKNESS = "$THICKNESS";
    
    /** The Constant HEADER_VARIABLE_TILEMODE. */
    public static final String HEADER_VARIABLE_TILEMODE = "$TILEMODE";
    
    /** The Constant HEADER_VARIABLE_TRACEWID. */
    public static final String HEADER_VARIABLE_TRACEWID = "$TRACEWID";
    
    /** The Constant HEADER_VARIABLE_TREEDEPTH. */
    public static final String HEADER_VARIABLE_TREEDEPTH = "$TREEDEPTH";
    
    /** The Constant HEADER_VARIABLE_UCSBASE. */
    public static final String HEADER_VARIABLE_UCSBASE = "$UCSBASE";
    
    /** The Constant HEADER_VARIABLE_UCSNAME. */
    public static final String HEADER_VARIABLE_UCSNAME = "$UCSNAME";
    
    /** The Constant HEADER_VARIABLE_UCSORG. */
    public static final String HEADER_VARIABLE_UCSORG = "$UCSORG";
    
    /** The Constant HEADER_VARIABLE_UCSORGBACK. */
    public static final String HEADER_VARIABLE_UCSORGBACK = "$UCSORGBACK";
    
    /** The Constant HEADER_VARIABLE_UCSORGBOTTOM. */
    public static final String HEADER_VARIABLE_UCSORGBOTTOM = "$UCSORGBOTTOM";
    
    /** The Constant HEADER_VARIABLE_UCSORGFRONT. */
    public static final String HEADER_VARIABLE_UCSORGFRONT = "$UCSORGFRONT";
    
    /** The Constant HEADER_VARIABLE_UCSORGLEFT. */
    public static final String HEADER_VARIABLE_UCSORGLEFT = "$UCSORGLEFT";
    
    /** The Constant HEADER_VARIABLE_UCSORGRIGHT. */
    public static final String HEADER_VARIABLE_UCSORGRIGHT = "$UCSORGRIGHT";
    
    /** The Constant HEADER_VARIABLE_UCSORGTOP. */
    public static final String HEADER_VARIABLE_UCSORGTOP = "$UCSORGTOP";
    
    /** The Constant HEADER_VARIABLE_UCSORTHOREF. */
    public static final String HEADER_VARIABLE_UCSORTHOREF = "$UCSORTHOREF";
    
    /** The Constant HEADER_VARIABLE_UCSORTHOVIEW. */
    public static final String HEADER_VARIABLE_UCSORTHOVIEW = "$UCSORTHOVIEW";
    
    /** The Constant HEADER_VARIABLE_UCSXDIR. */
    public static final String HEADER_VARIABLE_UCSXDIR = "$UCSXDIR";
    
    /** The Constant HEADER_VARIABLE_UCSYDIR. */
    public static final String HEADER_VARIABLE_UCSYDIR = "$UCSYDIR";
    
    /** The Constant HEADER_VARIABLE_UNITMODE. */
    public static final String HEADER_VARIABLE_UNITMODE = "$UNITMODE";
    
    /** The Constant HEADER_VARIABLE_USERI1. */
    public static final String HEADER_VARIABLE_USERI1 = "$USERI1";
    
    /** The Constant HEADER_VARIABLE_USERR1. */
    public static final String HEADER_VARIABLE_USERR1 = "$USERR1";
    
    /** The Constant HEADER_VARIABLE_USRTIMER. */
    public static final String HEADER_VARIABLE_USRTIMER = "$USRTIMER";
    
    /** The Constant HEADER_VARIABLE_VERSIONGUID. */
    public static final String HEADER_VARIABLE_VERSIONGUID = "$VERSIONGUID";
    
    /** The Constant HEADER_VARIABLE_VIEWCTR. */
    public static final String HEADER_VARIABLE_VIEWCTR = "$VIEWCTR";
    
    /** The Constant HEADER_VARIABLE_VIEWDIR. */
    public static final String HEADER_VARIABLE_VIEWDIR = "$VIEWDIR";
    
    /** The Constant HEADER_VARIABLE_VIEWSIZE. */
    public static final String HEADER_VARIABLE_VIEWSIZE = "$VIEWSIZE";
    
    /** The Constant HEADER_VARIABLE_VISRETAIN. */
    public static final String HEADER_VARIABLE_VISRETAIN = "$VISRETAIN";
    
    /** The Constant HEADER_VARIABLE_WORLDVIEW. */
    public static final String HEADER_VARIABLE_WORLDVIEW = "$WORLDVIEW";
    
    /** The Constant HEADER_VARIABLE_XCLIPFRAME. */
    public static final String HEADER_VARIABLE_XCLIPFRAME = "$XCLIPFRAME";
    
    /** The Constant HEADER_VARIABLE_XEDIT. */
    public static final String HEADER_VARIABLE_XEDIT = "$XEDIT";
    
    /** The Constant LAYOUT_DEFAULT_NAME. */
    public final static String LAYOUT_DEFAULT_NAME = "Model";
    
    /** The Constant OBJECT_TYPE_ACAD_PROXY_OBJECT. */
    public final static String OBJECT_TYPE_ACAD_PROXY_OBJECT = "ACAD_PROXY_OBJERCT";
    
    /** The Constant OBJECT_TYPE_ACDBDICTIONARYWDFLT. */
    public final static String OBJECT_TYPE_ACDBDICTIONARYWDFLT = "ACDBDICTIONARYWDFLT";
    
    /** The Constant OBJECT_TYPE_ACDBPLACEHOLDER. */
    public final static String OBJECT_TYPE_ACDBPLACEHOLDER = "ACDBPLACEHOLDER";
    
    /** The Constant OBJECT_TYPE_DICTIONARY. */
    public final static String OBJECT_TYPE_DICTIONARY = "DICTIONARY";
    
    /** The Constant OBJECT_TYPE_DICTIONARYVAR. */
    public final static String OBJECT_TYPE_DICTIONARYVAR = "DICTIONARYVAR";
    
    /** The Constant OBJECT_TYPE_DIMASSOC. */
    public final static String OBJECT_TYPE_DIMASSOC = "DIMASSOC";
    
    /** The Constant OBJECT_TYPE_FIELD. */
    public final static String OBJECT_TYPE_FIELD = "FIELD";
    
    /** The Constant OBJECT_TYPE_GROUP. */
    public final static String OBJECT_TYPE_GROUP = "GROUP";
    
    /** The Constant OBJECT_TYPE_IDBUFFER. */
    public final static String OBJECT_TYPE_IDBUFFER = "IDBUFFER";

    /** The Constant OBJECT_TYPE_IMAGEDEF. */
    //Object types
    public final static String OBJECT_TYPE_IMAGEDEF = "IMAGEDEF";
    
    /** The Constant OBJECT_TYPE_IMAGEDEF_REACTOR. */
    public final static String OBJECT_TYPE_IMAGEDEF_REACTOR = "IMAGEDEF_REACTOR";
    
    /** The Constant OBJECT_TYPE_LAYER_FILTER. */
    public final static String OBJECT_TYPE_LAYER_FILTER = "LAYER_FILTER";
    
    /** The Constant OBJECT_TYPE_LAYER_INDEX. */
    public final static String OBJECT_TYPE_LAYER_INDEX = "LAYER_INDEX";
    
    /** The Constant OBJECT_TYPE_LAYOUT. */
    public final static String OBJECT_TYPE_LAYOUT = "LAYOUT";
    
    /** The Constant OBJECT_TYPE_MATERIAL. */
    public final static String OBJECT_TYPE_MATERIAL = "MATERIAL";
    
    /** The Constant OBJECT_TYPE_MLINESTYLE. */
    public final static String OBJECT_TYPE_MLINESTYLE = "MLINESTYLE";
    
    /** The Constant OBJECT_TYPE_OBJECT_PTR. */
    public final static String OBJECT_TYPE_OBJECT_PTR = "OBJECT_PTR";
    
    /** The Constant OBJECT_TYPE_PLOTSETTINGS. */
    public final static String OBJECT_TYPE_PLOTSETTINGS = "PLOTSETTINGS";
    
    /** The Constant OBJECT_TYPE_RASTERVARIABLES. */
    public final static String OBJECT_TYPE_RASTERVARIABLES = "RASTERVARIABLES";
    
    /** The Constant OBJECT_TYPE_SORTENTSTABLE. */
    public final static String OBJECT_TYPE_SORTENTSTABLE = "SORTENTSTABLE";
    
    /** The Constant OBJECT_TYPE_SPATIAL_FILTER. */
    public final static String OBJECT_TYPE_SPATIAL_FILTER = "SPATIAL_FILTER";
    
    /** The Constant OBJECT_TYPE_SPATIAL_INDEX. */
    public final static String OBJECT_TYPE_SPATIAL_INDEX = "SPATIAL_INDEX";
    
    /** The Constant OBJECT_TYPE_TABLESTYLE. */
    public final static String OBJECT_TYPE_TABLESTYLE = "TABLESTYLE";
    
    /** The Constant OBJECT_TYPE_VBA_PROJECT. */
    public final static String OBJECT_TYPE_VBA_PROJECT = "VBA_PROJECT";
    
    /** The Constant OBJECT_TYPE_WIPEOUTVARIABLES. */
    public final static String OBJECT_TYPE_WIPEOUTVARIABLES = "WIPEOUTVARIABLES";
    
    /** The Constant OBJECT_TYPE_XRECORD. */
    public final static String OBJECT_TYPE_XRECORD = "XRECORD";
    
    /** The Constant PAPER_UNIT_INCH. */
    public final static int PAPER_UNIT_INCH = 0;
    
    /** The Constant PAPER_UNIT_MILLIMETER. */
    public final static int PAPER_UNIT_MILLIMETER = 1;
    
    /** The Constant PAPER_UNIT_PIXEL. */
    public final static int PAPER_UNIT_PIXEL = 2;
    
    /** The Constant PLOT_STYLE_DRAWING_EXTENTS. */
    public final static int PLOT_STYLE_DRAWING_EXTENTS = 1;
    
    /** The Constant PLOT_STYLE_DRAWING_LIMITS. */
    public final static int PLOT_STYLE_DRAWING_LIMITS = 2;
    
    /** The Constant PLOT_STYLE_LAST_SCREEN_DISPLAY. */
    public final static int PLOT_STYLE_LAST_SCREEN_DISPLAY = 0;
    
    /** The Constant PLOT_STYLE_LAYOUT. */
    public final static int PLOT_STYLE_LAYOUT = 5;
    
    /** The Constant PLOT_STYLE_SPECIFIECED_VIEW. */
    public final static int PLOT_STYLE_SPECIFIECED_VIEW = 3;
    
    /** The Constant PLOT_STYLE_SPECIFIECED_WINDOW. */
    public final static int PLOT_STYLE_SPECIFIECED_WINDOW = 4;
    
    /** The point connection radius. */
    public static double POINT_CONNECTION_RADIUS = 0.0001;
    
    /** The Constant SECTION_BLOCKS. */
    public final static String SECTION_BLOCKS = "BLOCKS";
    
    /** The Constant SECTION_CLASSES. */
    public final static String SECTION_CLASSES = "CLASSES";
    
    /** The Constant SECTION_END. */
    public final static String SECTION_END = "ENDSEC";
    
    /** The Constant SECTION_ENTITIES. */
    public final static String SECTION_ENTITIES = "ENTITIES";
    
    /** The Constant SECTION_HEADER. */
    public final static String SECTION_HEADER = "HEADER";
    
    /** The Constant SECTION_OBJECTS. */
    public final static String SECTION_OBJECTS = "OBJECTS";
    
    /** The Constant SECTION_START. */
    public final static String SECTION_START = "SECTION";
    
    /** The Constant SECTION_TABLES. */
    public final static String SECTION_TABLES = "TABLES";
    
    /** The Constant SECTION_THUMBNAILIMAGE. */
    public final static String SECTION_THUMBNAILIMAGE = "THUMBNAILIMAGE";
    
    /** The Constant TABLE_KEY_APPID. */
    public final static String TABLE_KEY_APPID = "APPID";
    
    /** The Constant TABLE_KEY_BLOCK_RECORD. */
    public final static String TABLE_KEY_BLOCK_RECORD = "BLOCK_RECORD";
    
    /** The Constant TABLE_KEY_DIMSTYLE. */
    public final static String TABLE_KEY_DIMSTYLE = "DIMSTYLE";
    
    /** The Constant TABLE_KEY_LAYER. */
    public final static String TABLE_KEY_LAYER = "LAYER";
    
    /** The Constant TABLE_KEY_LTYPE. */
    public final static String TABLE_KEY_LTYPE = "LTYPE";
    
    /** The Constant TABLE_KEY_STYLE. */
    public final static String TABLE_KEY_STYLE = "STYLE";
    
    /** The Constant TABLE_KEY_UCS. */
    public final static String TABLE_KEY_UCS = "UCS";
    
    /** The Constant TABLE_KEY_VIEW. */
    public final static String TABLE_KEY_VIEW = "VIEW";
    
    /** The Constant TABLE_KEY_VPORT. */
    public final static String TABLE_KEY_VPORT = "VPORT";
}
