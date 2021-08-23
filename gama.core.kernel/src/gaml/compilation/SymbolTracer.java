/*******************************************************************************************************
 *
 * msi.gaml.compilation.SymbolTracer.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compilation;

import gama.common.interfaces.IKeyword;
import gama.runtime.IScope;
import gaml.expressions.IExpression;
import gaml.operators.Cast;

public class SymbolTracer {

	public String trace(final IScope scope, final ISymbol statement) {

		final String k = statement.getKeyword(); // getFacet(IKeyword.KEYWORD).literalValue();
		final StringBuilder sb = new StringBuilder(100);
		sb.append(k).append(' ');
		if (statement.getDescription() != null) {
			statement.getDescription().visitFacets((name, ed) -> {
				if (name.equals(IKeyword.NAME)) {
					final String n = statement.getFacet(IKeyword.NAME).literalValue();
					if (n.startsWith(IKeyword.INTERNAL)) { return true; }
				}
				IExpression expr = null;
				if (ed != null) {
					expr = ed.getExpression();
				}
				final String exprString = expr == null ? "N/A" : expr.serialize(false);
				final String exprValue = expr == null ? "nil" : Cast.toGaml(expr.value(scope));
				sb.append(name).append(": [ ").append(exprString).append(" ] ").append(exprValue).append(" ");

				return true;
			});
		}

		return sb.toString();

	}

}
