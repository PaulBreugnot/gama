/*******************************************************************************************************
 *
 * IStatement.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.statements;

import gama.runtime.IScope;
import gaml.compilation.ISymbol;

/**
 * Written by drogoul Feb. 2009
 * 
 * @todo Description
 * 
 */
public interface IStatement extends ISymbol, IExecutable {

	/**
	 * The Interface WithArgs.
	 */
	public interface WithArgs extends IStatement {

		/**
		 * Sets the formal args.
		 *
		 * @param args the new formal args
		 */
		public abstract void setFormalArgs(Arguments args);

		public abstract void setRuntimeArgs(IScope scope, Arguments args);

	}

	/**
	 * The Interface Breakable.
	 */
	public interface Breakable extends IStatement {
		// Unused tagging interface (for the moment)
	}

}
