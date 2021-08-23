/*******************************************************************************************************
 *
 * msi.gaml.statements.FocusStatement.java, in plugin msi.gama.core,
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
import gama.core.dev.annotations.GamlAnnotations.example;
import gama.core.dev.annotations.GamlAnnotations.facet;
import gama.core.dev.annotations.GamlAnnotations.facets;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.core.dev.annotations.GamlAnnotations.usage;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.IShape;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;
import gaml.operators.Cast;
import gaml.types.IType;

/**
 * Written by drogoul Modified on 6 févr. 2010
 * 
 * @todo Description
 * 
 */

@symbol(name = IKeyword.FOCUS_ON, kind = ISymbolKind.SINGLE_STATEMENT, with_sequence = false, concept = {
		IConcept.DISPLAY, IConcept.GEOMETRY })
@inside(kinds = { ISymbolKind.BEHAVIOR, ISymbolKind.SEQUENCE_STATEMENT, ISymbolKind.LAYER })
@facets(value = {
		@facet(name = IKeyword.VALUE, type = IType.NONE, optional = false, doc = @doc("The agent, list of agents, geometry to focus on")) }, omissible = IKeyword.VALUE)
@doc(value = "Allows to focus on the passed parameter in all available displays. Passing 'nil' for the parameter will make all screens return to their normal zoom", usages = {
		@usage(value = "Focuses on an agent, a geometry, a set of agents, etc...)", examples = {
				@example("focus_on my_species(0);") }) })
public class FocusStatement extends AbstractStatement {

	@Override
	public String getTrace(final IScope scope) {
		// We dont trace focus statements
		return "";
	}

	final IExpression value;

	public FocusStatement(final IDescription desc) {
		super(desc);
		value = getFacet(IKeyword.VALUE);
	}

	@Override
	public Object privateExecuteIn(final IScope scope) throws GamaRuntimeException {
		final IAgent agent = scope.getAgent();
		if (agent != null && !agent.dead()) {
			final IShape o = Cast.asGeometry(scope, value.value(scope));
			GAMA.getGui().setFocusOn(o);
		}
		return value.value(scope);
	}
}
