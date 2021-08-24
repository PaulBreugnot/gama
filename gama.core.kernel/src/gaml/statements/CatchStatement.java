/*******************************************************************************************************
 *
 * CatchStatement.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.statements;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gaml.descriptions.IDescription;

/**
 * Written by drogoul Modified on 8 févr. 2010
 * 
 * @todo Description
 * 
 */
@symbol (
		name = IKeyword.CATCH,
		kind = ISymbolKind.SEQUENCE_STATEMENT,
		with_sequence = true,
		concept = { IConcept.ACTION })
@inside (
		symbols = IKeyword.TRY)
@doc (
		value = "This statement cannot be used alone",
		see = { IKeyword.TRY })
public class CatchStatement extends AbstractStatementSequence {

	/**
	 * Instantiates a new catch statement.
	 *
	 * @param desc the desc
	 */
	public CatchStatement(final IDescription desc) {
		super(desc);
		setName(IKeyword.CATCH);
	}

}
