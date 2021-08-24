/*******************************************************************************************************
 *
 * IValidator.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compilation;

import org.eclipse.emf.ecore.EObject;

import gama.common.interfaces.IGamlIssue;
import gama.common.interfaces.IKeyword;
import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;

/**
 * 'Tagging' interface for IExpression and IDescription validators.
 *
 * @author A. Drogoul
 * @since July 2018
 */
public interface IValidator extends IKeyword, IGamlIssue {

	/**
	 * Validate.
	 *
	 * @param description the description
	 * @param emfContext the emf context
	 * @param arguments the arguments
	 * @return true, if successful
	 */
	boolean validate(IDescription description, EObject emfContext, IExpression... arguments);
}
