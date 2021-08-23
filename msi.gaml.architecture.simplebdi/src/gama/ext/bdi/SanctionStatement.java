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

@symbol(name = { SanctionStatement.SANCTION }, kind = ISymbolKind.BEHAVIOR, with_sequence = true, concept = {
		IConcept.BDI })
@inside(kinds = { ISymbolKind.SPECIES, ISymbolKind.MODEL })
@facets(value = {
		@facet(name = IKeyword.NAME, type = IType.ID, optional = true) }, omissible = IKeyword.NAME)
@doc("declare the actions an agent execute when enforcing norms of others during a perception")
public class SanctionStatement extends AbstractStatementSequence{

	public static final String SANCTION = "sanction";
	
	
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
