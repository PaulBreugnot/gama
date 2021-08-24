/*******************************************************************************************************
 *
 * AbstractStatementSequenceWithArgs.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.statements;

import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.descriptions.IDescription;
import gaml.statements.IStatement.WithArgs;

/**
 * Class AbstractStatementSequenceWithArgs.
 *
 * @author drogoul
 * @since 11 mai 2014
 *
 */
public class AbstractStatementSequenceWithArgs extends AbstractStatementSequence implements WithArgs {

	/** The actual args. */
	final ThreadLocal<Arguments> actualArgs = new ThreadLocal<>();

	/**
	 * Instantiates a new abstract statement sequence with args.
	 *
	 * @param desc the desc
	 */
	public AbstractStatementSequenceWithArgs(final IDescription desc) {
		super(desc);
	}

	/**
	 * Method setFormalArgs()
	 *
	 * @see gaml.statements.IStatement.WithArgs#setFormalArgs(gaml.statements.Arguments)
	 */
	@Override
	public void setFormalArgs(final Arguments args) {}

	/**
	 * Method setRuntimeArgs()
	 *
	 * @see gaml.statements.IStatement.WithArgs#setRuntimeArgs(gaml.statements.Arguments)
	 */
	@Override
	public void setRuntimeArgs(final IScope scope, final Arguments args) {
		// TODO Verify that this copy of the arguments is required or not.
		actualArgs.set(new Arguments(args));
	}

	@Override
	public Object privateExecuteIn(final IScope scope) throws GamaRuntimeException {
		scope.stackArguments(actualArgs.get());
		return super.privateExecuteIn(scope);
	}

}
