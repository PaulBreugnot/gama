/*******************************************************************************************************
 *
 * IOrderedStack.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package org.jbox2d.pooling;

/**
 * This stack assumes that when you push 'n' items back,
 * you're pushing back the last 'n' items popped.
 *
 * @author Daniel
 * @param <E> the element type
 */
public interface IOrderedStack<E> {

	/**
	 * Returns the next object in the pool.
	 *
	 * @return the e
	 */
	public E pop();

	/**
	 * Returns the next 'argNum' objects in the pool
	 * in an array.
	 *
	 * @param argNum the arg num
	 * @return an array containing the next pool objects in
	 * 		   items 0-argNum.  Array length and uniqueness not
	 * 		   guaranteed.
	 */
	public E[] pop(int argNum);

	/**
	 * Tells the stack to take back the last 'argNum' items.
	 *
	 * @param argNum the arg num
	 */
	public void push(int argNum);

}
