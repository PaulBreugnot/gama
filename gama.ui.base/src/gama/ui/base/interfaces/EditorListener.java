/*******************************************************************************************************
 *
 * EditorListener.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.interfaces;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import gama.runtime.exceptions.GamaRuntimeException;

/**
 * Written by drogoul Modified on 27 mai 2011.
 *
 * @param <T> the generic type
 * @todo Description
 */
public interface EditorListener<T> {

	/**
	 * Value modified.
	 *
	 * @param val the val
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	void valueModified(T val) throws GamaRuntimeException;

	/**
	 * The Interface Command.
	 */
	public static interface Command extends EditorListener<Object>, SelectionListener {

		@Override
		public default void valueModified(final Object o) {
			this.widgetSelected(null);
		}

		@Override
		public default void widgetDefaultSelected(final SelectionEvent o) {
			this.widgetSelected(null);
		}

	}

}
