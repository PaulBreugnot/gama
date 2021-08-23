/*******************************************************************************************************
 *
 * msi.gaml.expressions.NowUnitExpression.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.expressions.units;

import java.time.LocalDateTime;

import gama.runtime.IScope;
import gama.util.GamaDate;
import gaml.types.Types;

public class NowUnitExpression extends UnitConstantExpression {

	public NowUnitExpression(final String name, final String doc) {
		super(1.0, Types.DATE, name, doc, null);
	}

	@Override
	public GamaDate _value(final IScope scope) {
		return GamaDate.of(LocalDateTime.now());
	}

	@Override
	public boolean isConst() {
		return false;
	}

}
