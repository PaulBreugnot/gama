/*******************************************************************************************************
 *
 * GamaFloatType.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.types;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.type;
import gama.metamodel.shape.GamaShape;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaDate;
import gama.util.GamaFont;
import gaml.descriptions.IDescription;

/**
 * Written by drogoul Modified on 1 ao�t 2010.
 *
 * @todo Description
 */
@SuppressWarnings("unchecked")
@type(name = IKeyword.FLOAT, id = IType.FLOAT, wraps = { Double.class,
		double.class }, kind = ISymbolKind.Variable.NUMBER, doc = {
				@doc("Represents floating point numbers (equivalent to Double in Java)") }, concept = { IConcept.TYPE })
public class GamaFloatType extends GamaType<Double> {

	@Override
	public Double cast(final IScope scope, final Object obj, final Object param, final boolean copy)
			throws GamaRuntimeException {
		return staticCast(scope, obj, param, copy);
	}

	/**
	 * Static cast.
	 *
	 * @param scope the scope
	 * @param obj the obj
	 * @param param the param
	 * @param copy the copy
	 * @return the double
	 */
	public static Double staticCast(final IScope scope, final Object obj, final Object param, final boolean copy) {
		if (obj instanceof Double) {
			return (Double) obj;
		}
		if (obj instanceof Number) {
			return ((Number) obj).doubleValue();
		}
		if (obj instanceof String) {
			try {
				return Double.valueOf((String) obj);
			} catch (final NumberFormatException e) {
				return 0d;
			}
		}
		if (obj instanceof Boolean) {
			return (Boolean) obj ? 1d : 0d;
		}
		if (obj instanceof GamaShape) {
			return ((GamaShape) obj).getArea();
		}
		if (obj instanceof GamaFont) {
			return (double) ((GamaFont) obj).getSize();
		}
		if (obj instanceof GamaDate)
			return ((GamaDate) obj).floatValue(scope);
		return 0d;
	}

	@Override
	public Double getDefault() {
		return 0.0;
	}

	@Override
	public boolean isTranslatableInto(final IType<?> type) {
		return type.isNumber() || type == Types.NO_TYPE;
	}

	@Override
	public IType<?> coerce(final IType<?> type, final IDescription context) {
		if (type == this) {
			return null;
		}
		return this;
	}

	@Override
	public IType<? super Double> findCommonSupertypeWith(final IType<?> type) {
		return type.isNumber() ? this : Types.NO_TYPE;
	}

	@Override
	public boolean canCastToConst() {
		return true;
	}

	@Override
	public boolean isNumber() {
		return true;
	}
}
