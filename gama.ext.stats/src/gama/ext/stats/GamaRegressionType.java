/*******************************************************************************************************
 *
 * GamaRegressionType.java, in gama.ext.stats, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.stats;

import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.type;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.types.GamaType;
import gaml.types.IType;


/**
 * The Class GamaRegressionType.
 */
@type(name = "regression", id = IType.REGRESSION, wraps = {
		GamaRegression.class }, kind = ISymbolKind.Variable.REGULAR, concept = { IConcept.TYPE },
				doc = {@doc(value = "Type of variables that enables to learn a regression function and to use it to predict new values")})
public class GamaRegressionType extends GamaType<GamaRegression> {

	@Override
	public boolean canCastToConst() {
		return true;
	}

	@Override
	public GamaRegression cast(final IScope scope, final Object obj, final Object param, final boolean copy)
			throws GamaRuntimeException {
		if (obj instanceof GamaRegression) {
			return (GamaRegression) obj;
		}
		return null;
	}

	@Override
	public GamaRegression getDefault() {
		return null;
	}

}
