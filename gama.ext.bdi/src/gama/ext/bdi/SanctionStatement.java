/*******************************************************************************************************
 *
 * SanctionStatement.java, in gama.ext.bdi, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.bdi;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.facet;
import gama.core.dev.annotations.GamlAnnotations.facets;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.descriptions.IDescription;
import gaml.statements.AbstractStatementSequence;
import gaml.types.IType;

/**
 * The Class SanctionStatement.
 */
@symbol(name = { SanctionStatement.SANCTION }, kind = ISymbolKind.BEHAVIOR, with_sequence = true, concept = {
		IConcept.BDI })
@inside(kinds = { ISymbolKind.SPECIES, ISymbolKind.MODEL })
@facets(value = {
		@facet(name = IKeyword.NAME, type = IType.ID, optional = true) }, omissible = IKeyword.NAME)
@doc("declare the actions an agent execute when enforcing norms of others during a perception")
public class SanctionStatement extends AbstractStatementSequence{

	/** The Constant SANCTION. */
	public static final String SANCTION = "sanction";
	
	
	/**
	 * Instantiates a new sanction statement.
	 *
	 * @param desc the desc
	 */
	public SanctionStatement(IDescription desc) {
		super(desc);
		setName(desc.getName());
	}
	
	public Object privateExecuteIn(final IScope scope) throws GamaRuntimeException {
//		if (_when == null || Cast.asBool(scope, _when.value(scope))) {
			return super.privateExecuteIn(scope);
//		}
//		return null;
	}
	
}
