/*******************************************************************************************************
 *
 * msi.gaml.types.GamaStringType.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.types;

import gama.common.interfaces.IKeyword;
import gama.common.interfaces.INamed;
import gama.common.interfaces.IValue;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.type;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;

/**
 *
 *
 *
 * Written by drogoul Modified on 3 juin 2010
 *
 * @todo Description
 * 
 */
@SuppressWarnings ("unchecked")
@type (
		name = IKeyword.STRING,
		id = IType.STRING,
		wraps = { String.class },
		kind = ISymbolKind.Variable.REGULAR,
		concept = { IConcept.TYPE, IConcept.STRING },
		doc = @doc ("Strings are ordered list of characters"))
public class GamaStringType extends GamaType<String> {

	@Override
	public String cast(final IScope scope, final Object obj, final Object param, final boolean copy)
			throws GamaRuntimeException {
		return staticCast(scope, obj, copy);
	}

	public static String staticCast(final IScope scope, final Object obj, final boolean copy)
			throws GamaRuntimeException {
		if (obj == null) { return null; }
		if (obj instanceof IValue) { return ((IValue) obj).stringValue(scope); }
		if (obj instanceof INamed) { return ((INamed) obj).getName(); }
		return obj.toString();
	}

	@Override
	public String getDefault() {
		return null;
	}

	@Override
	public boolean canCastToConst() {
		return true;
	}

	@Override
	public boolean isDrawable() {
		return true;
	}

}
