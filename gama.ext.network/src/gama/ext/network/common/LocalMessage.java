/*********************************************************************************************
 *
 * 'LocalMessage.java, in plugin ummisco.gama.network, is part of the source code of the GAMA modeling and simulation
 * platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.ext.network.common;

import gama.runtime.IScope;
import gaml.extensions.messaging.GamaMessage;

public class LocalMessage implements ConnectorMessage {
	private final Object internalMessage;
	private final String receiver;
	private final String sender;

	public LocalMessage(final String sender, final String receiver, final Object ct) {
		this.sender = sender;
		this.receiver = receiver;
		this.internalMessage = ct;
	}

	@Override
	public String getSender() {
		return sender;
	}

	@Override
	public String getReceiver() {
		return receiver;
	}

	@Override
	public String getPlainContents() {
		return this.internalMessage.toString();
	}

	@Override
	public boolean isPlainMessage() {
		return false;
	}

	@Override
	public GamaMessage getContents(final IScope scope) {
		GamaMessage message = null;
		if (internalMessage instanceof GamaMessage) {
			message = (GamaMessage) internalMessage;
		} else {
			message = new GamaMessage(scope, sender, receiver, internalMessage);
		}
		message.hasBeenReceived(scope);
		return message;
	}

	@Override
	public boolean isCommandMessage() {
		// TODO Auto-generated method stub
		return false;
	}

}
