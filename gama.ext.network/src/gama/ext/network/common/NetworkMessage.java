/*******************************************************************************************************
 *
 * NetworkMessage.java, in gama.ext.network, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.network.common;

import gama.ext.serialize.factory.StreamConverter;
import gama.runtime.IScope;
import gaml.extensions.messaging.GamaMessage;

/**
 * The Class NetworkMessage.
 */
public class NetworkMessage implements ConnectorMessage {
	
	/** The Constant UNDEFINED. */
	public static final String UNDEFINED = "undefined";

	/** The from. */
	private final String from;
	
	/** The to. */
	private final String to;
	
	/** The content. */
	private final String content;
	
	/** The is plain message. */
	protected boolean isPlainMessage = false;

	/**
	 * Instantiates a new network message.
	 *
	 * @param to the to
	 * @param data the data
	 */
	protected NetworkMessage(final String to, final String data) {
		this.content = data;
		this.from = UNDEFINED;
		this.to = to;
		isPlainMessage = true;
	}

	/**
	 * Instantiates a new network message.
	 *
	 * @param from the from
	 * @param to the to
	 * @param data the data
	 */
	protected NetworkMessage(final String from, final String to, final String data) {
		this.from = from;
		this.to = to;
		this.content = data;
		isPlainMessage = false;
	}

	@Override
	public String getSender() {
		return from;
	}

	@Override
	public String getReceiver() {
		return to;
	}

	@Override
	public String getPlainContents() {
		return content;
	}

	@Override
	public boolean isPlainMessage() {
		return isPlainMessage;
	}

	@Override
	public GamaMessage getContents(final IScope scope) {
		return isPlainMessage ? getPlainContent(scope) : getCompositeContent(scope);
	}

	/**
	 * Gets the plain content.
	 *
	 * @param scope the scope
	 * @return the plain content
	 */
	public GamaMessage getPlainContent(final IScope scope) {
		final GamaMessage message = new GamaMessage(scope, from, to, content);
		message.hasBeenReceived(scope);
		return message;
	}

	/**
	 * Gets the composite content.
	 *
	 * @param scope the scope
	 * @return the composite content
	 */
	public GamaMessage getCompositeContent(final IScope scope) {
		final Object messageContent = StreamConverter.convertStreamToObject(scope, content);
		GamaMessage message = null;
		if (messageContent instanceof CompositeGamaMessage) {
			message = (GamaMessage) messageContent;
		} else {
			message = new GamaMessage(scope, from, to, messageContent);
		}
		message.hasBeenReceived(scope);
		return message;
	}

	@Override
	public boolean isCommandMessage() {
		return false;
	}
}
