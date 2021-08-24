/*******************************************************************************************************
 *
 * GamaMailbox.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.extensions.messaging;

import gama.runtime.IScope;
import gama.util.GamaList;
import gaml.types.IType;
import gaml.types.Types;

/**
 * A specialized GamaList that holds messages.
 *
 * @author drogoul
 */
public class GamaMailbox extends GamaList<GamaMessage> {

	/**
	 * Instantiates a new gama mailbox.
	 */
	public GamaMailbox() {
		this(100);
	}

	/**
	 * Instantiates a new gama mailbox.
	 *
	 * @param capacity the capacity
	 */
	public GamaMailbox(final int capacity) {
		super(capacity, Types.get(IType.MESSAGE));
	}

	/**
	 * Adds the message.
	 *
	 * @param scope the scope
	 * @param message the message
	 */
	public void addMessage(final IScope scope, final GamaMessage message) {
		message.hasBeenReceived(scope);
		addValue(scope, message);
	}

}
