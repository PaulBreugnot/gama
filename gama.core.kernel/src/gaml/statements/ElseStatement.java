/*******************************************************************************************************
 *
 * msi.gaml.statements.ElseStatement.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 * 
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.statements;

import gama.common.interfaces.IKeyword;
import gama.core.dev.*;
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
@symbol(name = IKeyword.ELSE, kind = ISymbolKind.SEQUENCE_STATEMENT, with_sequence = true, concept = { IConcept.CONDITION })
@inside(symbols = IKeyword.IF)
@doc(value="This statement cannot be used alone",see={IKeyword.IF})
public class ElseStatement extends AbstractStatementSequence {

	public ElseStatement(final IDescription desc) {
		super(desc);
		setName(IKeyword.ELSE);
	}

}
