/*******************************************************************************************************
 *
 * IExpressionCompiler.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.expressions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import gama.common.interfaces.IDisposable;
import gama.runtime.IExecutionContext;
import gama.util.GamaMapFactory;
import gama.util.IMap;
import gaml.descriptions.ActionDescription;
import gaml.descriptions.IDescription;
import gaml.descriptions.IExpressionDescription;
import gaml.descriptions.OperatorProto;
import gaml.statements.Arguments;
import gaml.types.Signature;

/**
 * Written by drogoul Modified on 28 d�c. 2010
 *
 * @param <T> the generic type
 * @todo Description
 */
public interface IExpressionCompiler<T> extends IDisposable {

	/** The operators. */
	IMap<String, IMap<Signature, OperatorProto>> OPERATORS = GamaMapFactory.createUnordered();
	
	/** The iterators. */
	Set<String> ITERATORS = new HashSet<>();

	/**
	 * Compile.
	 *
	 * @param s the s
	 * @param parsingContext the parsing context
	 * @return the i expression
	 */
	IExpression compile(final IExpressionDescription s, final IDescription parsingContext);

	/**
	 * Compile.
	 *
	 * @param expression the expression
	 * @param parsingContext the parsing context
	 * @param tempContext the temp context
	 * @return the i expression
	 */
	IExpression compile(final String expression, final IDescription parsingContext, IExecutionContext tempContext);

	/**
	 * Parses the arguments.
	 *
	 * @param action the action
	 * @param eObject the e object
	 * @param context the context
	 * @param compileArgValues the compile arg values
	 * @return the arguments
	 */
	Arguments parseArguments(ActionDescription action, EObject eObject, IDescription context, boolean compileArgValues);

	/**
	 * Compile block.
	 *
	 * @param string the string
	 * @param actionContext the action context
	 * @param tempContext the temp context
	 * @return the list
	 */

	List<IDescription> compileBlock(final String string, final IDescription actionContext,
			IExecutionContext tempContext);

}