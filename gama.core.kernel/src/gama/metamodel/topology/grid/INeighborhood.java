/*******************************************************************************************************
 *
 * INeighborhood.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.metamodel.topology.grid;

import java.util.Set;

import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;

/**
 * Class INeighborhood.
 *
 * @author drogoul
 * @since 19 mai 2013
 *
 */
public interface INeighborhood {

	/**
	 * Gets the neighbors in.
	 *
	 * @param scope the scope
	 * @param placeIndex the place index
	 * @param radius the radius
	 * @return the neighbors in
	 */
	public abstract Set<IAgent> getNeighborsIn(IScope scope, final int placeIndex, final int radius);

	/**
	 * Checks if is vn.
	 *
	 * @return true, if is vn
	 */
	public abstract boolean isVN();

	/**
	 * Gets the raw neighbors including.
	 *
	 * @param scope the scope
	 * @param placeIndex the place index
	 * @param range the range
	 * @return the raw neighbors including
	 */
	public abstract int[] getRawNeighborsIncluding(IScope scope, int placeIndex, int range);

	/**
	 * Neighbors index of.
	 *
	 * @param scope the scope
	 * @param placeIndex the place index
	 * @param n the n
	 * @return the int
	 */
	public abstract int neighborsIndexOf(IScope scope, int placeIndex, int n);

	/**
	 * Clear.
	 */
	public abstract void clear();

}