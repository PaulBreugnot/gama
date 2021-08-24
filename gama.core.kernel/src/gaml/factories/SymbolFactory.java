/*******************************************************************************************************
 *
 * SymbolFactory.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.factories;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import gaml.descriptions.IDescription;
import gaml.descriptions.SymbolProto;
import gaml.statements.Facets;

/**
 * Written by Alexis Drogoul Modified on 11 mai 2010.
 *
 * @todo Description
 */
public abstract class SymbolFactory {

	/** The kinds handled. */
	protected final Set<Integer> kindsHandled;

	/**
	 * Instantiates a new symbol factory.
	 *
	 * @param handles the handles
	 */
	public SymbolFactory(final int... handles) {
		kindsHandled = new HashSet<>(handles.length);
		for (final int i : handles) {
			kindsHandled.add(i);
		}
	}

	/**
	 * Gets the handles.
	 *
	 * @return the handles
	 */
	Set<Integer> getHandles() {
		return kindsHandled;
	}

	/**
	 * Builds the description.
	 *
	 * @param keyword the keyword
	 * @param facets the facets
	 * @param element the element
	 * @param children the children
	 * @param enclosing the enclosing
	 * @param proto the proto
	 * @return the i description
	 */
	protected abstract IDescription buildDescription(String keyword, Facets facets, EObject element,
			Iterable<IDescription> children, IDescription enclosing, SymbolProto proto);

}
