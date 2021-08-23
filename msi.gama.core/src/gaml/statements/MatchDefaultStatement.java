/*******************************************************************************************************
 *
 * msi.gaml.statements.MatchDefaultStatement.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
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
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.descriptions.IDescription;

@symbol (
		name = { IKeyword.DEFAULT },
		kind = ISymbolKind.SEQUENCE_STATEMENT,
		with_sequence = true,
		unique_in_context = true,
		concept = { IConcept.CONDITION })
@inside (
		symbols = IKeyword.SWITCH)
@doc (
		value = "Used in a switch match structure, the block prefixed by default is executed only if no other block has matched (otherwise it is not).",
		see = { "switch", "match" })
public class MatchDefaultStatement extends MatchStatement {

	public MatchDefaultStatement(final IDescription desc) {
		super(desc);
	}

	@Override
	public boolean matches(final IScope scope, final Object switchValue) throws GamaRuntimeException {
		return false;
	}

}