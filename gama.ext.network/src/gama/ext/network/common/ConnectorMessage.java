/*******************************************************************************************************
 *
 * ConnectorMessage.java, in gama.ext.network, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.network.common;

import gama.runtime.IScope;
import gaml.extensions.messaging.GamaMessage;

/**
 * The Interface ConnectorMessage.
 */
public interface ConnectorMessage {
	
	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 */
	String getSender();

	/**
	 * Gets the receiver.
	 *
	 * @return the receiver
	 */
	String getReceiver();

	/**
	 * Gets the plain contents.
	 *
	 * @return the plain contents
	 */
	String getPlainContents();

	/**
	 * Checks if is plain message.
	 *
	 * @return true, if is plain message
	 */
	boolean isPlainMessage();

	/**
	 * Checks if is command message.
	 *
	 * @return true, if is command message
	 */
	boolean isCommandMessage();

	/**
	 * Gets the contents.
	 *
	 * @param scope the scope
	 * @return the contents
	 */
	GamaMessage getContents(IScope scope);
}
