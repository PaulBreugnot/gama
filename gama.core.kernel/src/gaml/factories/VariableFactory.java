/*******************************************************************************************************
 *
 * VariableFactory.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.factories;

import static gama.common.interfaces.IKeyword.ON_CHANGE;
import static gama.common.interfaces.IKeyword.PARAMETER;
import static gama.common.interfaces.IKeyword.VAR;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.factory;
import gaml.descriptions.ExperimentDescription;
import gaml.descriptions.FacetProto;
import gaml.descriptions.IDescription;
import gaml.descriptions.IExpressionDescription;
import gaml.descriptions.SymbolProto;
import gaml.descriptions.VariableDescription;
import gaml.statements.Facets;

/**
 * Written by drogoul Modified on 26 nov. 2008
 *
 * @todo Description
 */
@factory (
		handles = { ISymbolKind.Variable.CONTAINER, ISymbolKind.Variable.NUMBER, ISymbolKind.Variable.REGULAR,
				ISymbolKind.Variable.SIGNAL, ISymbolKind.PARAMETER })
public class VariableFactory extends SymbolFactory {

	/**
	 * Instantiates a new variable factory.
	 *
	 * @param handles the handles
	 */
	public VariableFactory(final int... handles) {
		super(handles);
	}

	@Override
	protected IDescription buildDescription(final String keyword, final Facets facets, final EObject element,
			final Iterable<IDescription> children, final IDescription enclosing, final SymbolProto proto) {
		if (PARAMETER.equals(keyword)) {

			final Map<String, FacetProto> possibleFacets = proto.getPossibleFacets();
			// We copy the relevant facets from the targeted var of the
			// parameter
			VariableDescription targetedVar = enclosing.getModelDescription().getAttribute(facets.getLabel(VAR));
			if (targetedVar == null && enclosing instanceof ExperimentDescription) {
				targetedVar = ((ExperimentDescription) enclosing).getAttribute(facets.getLabel(VAR));
			}
			if (targetedVar != null) {
				for (final String key : possibleFacets.keySet()) {
					if (ON_CHANGE.equals(key)) { continue; }
					final IExpressionDescription expr = targetedVar.getFacet(key);
					if (expr != null) { facets.putIfAbsent(key, expr); }
				}

			}
		}
		return new VariableDescription(keyword, enclosing, element, facets);
	}

}
