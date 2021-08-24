/*******************************************************************************************************
 *
 * SyntacticStructuralElement.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compilation.ast;

import org.eclipse.emf.ecore.EObject;

import gaml.statements.Facets;

/**
 * The Class SyntacticStructuralElement.
 */
public class SyntacticStructuralElement extends SyntacticComposedElement {

	/**
	 * The name.
	 */
	String name;

	/**
	 * Instantiates a new syntactic structural element.
	 *
	 * @param keyword the keyword
	 * @param facets the facets
	 * @param statement the statement
	 */
	public SyntacticStructuralElement(final String keyword, final Facets facets, final EObject statement) {
		super(keyword, facets, statement);
		name = super.getName();
	}

	/* (non-Javadoc)
	 * @see msi.gaml.compilation.ast.AbstractSyntacticElement#getName()
	 */
	@Override
	public String getName() {
		if (name == null) {
			name = super.getName();
		}
		return name;
	}

}
