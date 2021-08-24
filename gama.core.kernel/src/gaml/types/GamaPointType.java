/*******************************************************************************************************
 *
 * GamaPointType.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.types;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.type;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaPair;
import gaml.operators.Cast;

/**
 * Written by drogoul Modified on 1 ao�t 2010.
 *
 * @todo Description
 */
@type (
		name = IKeyword.POINT,
		id = IType.POINT,
		wraps = { GamaPoint.class },
		kind = ISymbolKind.Variable.NUMBER,
		concept = { IConcept.TYPE, IConcept.POINT },
		doc = @doc ("Represent locations in either 2 or 3 dimensions"))
@SuppressWarnings ({ "unchecked", "rawtypes" })
public class GamaPointType extends GamaType<GamaPoint> {

	@Override
	public GamaPoint cast(final IScope scope, final Object obj, final Object param, final boolean copy)
			throws GamaRuntimeException {
		return staticCast(scope, obj, copy);
	}

	/**
	 * Static cast.
	 *
	 * @param scope the scope
	 * @param obj the obj
	 * @param copy the copy
	 * @return the gama point
	 */
	public static GamaPoint staticCast(final IScope scope, final Object obj, final boolean copy) {
		if (obj instanceof GamaPoint) return (GamaPoint) obj;
		if (obj instanceof IShape) return ((IShape) obj).getLocation();
		if (obj instanceof List) {
			final List l = (List) obj;
			if (l.size() > 2) return new GamaPoint(Cast.asFloat(scope, l.get(0)), Cast.asFloat(scope, l.get(1)),
					Cast.asFloat(scope, l.get(2)));
			if (l.size() > 1) return new GamaPoint(Cast.asFloat(scope, l.get(0)), Cast.asFloat(scope, l.get(1)));
			if (l.size() > 0) return staticCast(scope, l.get(0), copy);
			return new GamaPoint(0, 0, 0);
		}
		if (obj instanceof Map) {
			final Map m = (Map) obj;
			final double x = Cast.asFloat(scope, m.get("x"));
			final double y = Cast.asFloat(scope, m.get("y"));
			final double z = Cast.asFloat(scope, m.get("z"));
			return new GamaPoint(x, y, z);
		}
		// Decodes the stringValue() of GamaPoint
		if (obj instanceof String) {
			String s = ((String) obj).trim();
			if (s.startsWith("{") && s.endsWith("}")) {
				s = s.replace("{", "").replace("}", "").trim();
				return staticCast(scope, Arrays.asList(s.split(",")), false);
			}
		}
		if (obj instanceof GamaPair) return new GamaPoint(Cast.asFloat(scope, ((GamaPair) obj).first()),
				Cast.asFloat(scope, ((GamaPair) obj).last()));
		if (obj == null) return null;
		final double dval = Cast.asFloat(scope, obj);
		return new GamaPoint(dval, dval, dval);
	}

	@Override
	public GamaPoint getDefault() {
		return null;
	}

	@Override
	public IType getContentType() {
		return Types.get(FLOAT);
	}

	@Override
	public IType getKeyType() {
		return Types.get(INT);
	}

	@Override
	public boolean canCastToConst() {
		return true;
	}

	@Override
	public boolean isDrawable() {
		return true;
	}

	@Override
	public boolean isCompoundType() {
		return true;
	}

}
