/*******************************************************************************************************
 *
 * FIPAMessage.java, in gama.ext.fipa, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.fipa;

import gama.common.util.StringUtils;
import gama.core.dev.annotations.GamlAnnotations.getter;
import gama.core.dev.annotations.GamlAnnotations.setter;
import gaml.extensions.messaging.GamaMessage;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.IList;

/**
 * The Class MessageProxy.
 *
 * @author drogoul
 */

@SuppressWarnings ({ "rawtypes", "unchecked" })
public class FIPAMessage extends GamaMessage {

	/** The message. */
	private MessageData data;

	/**
	 * Instantiates a new FIPA message.
	 *
	 * @param scope the scope
	 * @throws GamaRuntimeException             Instantiates a new message proxy.
	 */
	public FIPAMessage(final IScope scope) {
		super(scope, null, null, null);
	}

	/**
	 * Instantiates a new FIPA message.
	 *
	 * @param scope the scope
	 * @param m            the m
	 * @throws GamaRuntimeException             Instantiates a new message proxy.
	 */
	public FIPAMessage(final IScope scope, final FIPAMessage m) throws GamaRuntimeException {
		super(scope, m.getData().getSender(), null, m.getData().getContent());
		getData().setContent(m.getData().getContent());
		getData().setConversation(m.getConversation());
		getData().setReceivers(m.getData().getReceivers());
		getData().setPerformativeName(m.getData().getPerformativeName());
		getData().setSender(m.getData().getSender());

	}

	/**
	 * Instantiates a new FIPA message.
	 *
	 * @param sender            the sender
	 * @param receivers            the receivers
	 * @param content            the content
	 * @param performative            the performative
	 * @param conversation            the conversation
	 * @throws GamaRuntimeException             Instantiates a new message proxy.
	 */
	public FIPAMessage(final IAgent sender, final IList<IAgent> receivers, final IList content,
			final Performative performative, final Conversation conversation) throws GamaRuntimeException {
		super(sender.getScope(), sender, null, content);
		setSender(sender);
		getData().setReceivers(receivers);
		getData().setPerformative(performative);
		getData().setConversation(conversation);
	}

	/**
	 * Gets the conversation.
	 *
	 * @return the conversation
	 */
	public Conversation getConversation() {
		return getData().getConversation();
	}

	@Override
	public IList<IAgent> getReceivers() {
		return getData().getReceivers();
	}

	// @Override
	// public FIPAMessage clone() {
	// final FIPAMessage m = new FIPAMessage(getSender(), getReceivers(),
	// (IList<IAgent>) getContents(null),
	// getPerformative(), getConversation());
	// return m;
	// }

	/**
	 * Gets the contents of the message.
	 *
	 * @return the contents
	 */
	@Override
	@getter (GamaMessage.CONTENTS)
	public Object getContents(final IScope scope) {
		setUnread(false);
		return getData().getContent();
	}

	/**
	 * Sets the contents of the message.
	 *
	 * @param content
	 *            the content
	 */
	@Override
	@setter (GamaMessage.CONTENTS)
	public void setContents(final Object content) {
		getData().setContent((IList) content);
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.extensions.fipa.IMessage#getMessage()
	 */
	public MessageData getData() {
		if (data == null)
			data = new MessageData();
		return data;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.extensions.fipa.IMessage#getSender()
	 */
	@Override
	@getter (FIPAMessage.SENDER)
	public IAgent getSender() {
		return getData().getSender();
	}

	/**
	 * Sets the sender.
	 *
	 * @param sender
	 *            the sender
	 */
	@setter (FIPAMessage.SENDER)
	public void setSender(final IAgent sender) {
		if (getData() != null)
			getData().setSender(sender);
	}

	/**
	 * Gets the performative.
	 *
	 * @return the performative
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.extensions.fipa.IMessage#getPerformative()
	 */
	public Performative getPerformative() {
		return getData().getPerformative();
	}

	/**
	 * Sets the performative.
	 *
	 * @param performative the new performative
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.gama.extensions.fipa.IMessage#setPerformative(int)
	 */
	public void setPerformative(final Performative performative) {
		getData().setPerformative(performative);
	}

	@Override
	public String toString() {
		return "Proxy on " + getData();
	}

	@Override
	public String serialize(final boolean includingBuiltIn) {
		return StringUtils.toGaml(getData().getContent(), includingBuiltIn);
	}

	//
	// @Override
	// public IType type() {
	// return Types.get(MessageType.MESSAGE_ID);
	// }

	@Override
	public String stringValue(final IScope scope) throws GamaRuntimeException {
		// TODO Auto-generated method stub
		return "message[sender: " + getData().getSender() + "; receivers: " + getData().getReceivers()
				+ "; performative: " + getData().getPerformativeName() + "; content: " + getData().getContent()
				+ "; content" + "]";
	}

	@Override
	public FIPAMessage copy(final IScope scope) throws GamaRuntimeException {
		final FIPAMessage m = new FIPAMessage(getSender(), getReceivers(), (IList<IAgent>) getContents(scope),
				getPerformative(), getConversation());
		return m;
	}

	/**
	 * Sets the receivers.
	 *
	 * @param receivers the new receivers
	 */
	public void setReceivers(final IList receivers) {
		getData().setReceivers(receivers);
	}

	/**
	 * Gets the performative name.
	 *
	 * @return the performative name
	 */
	public String getPerformativeName() {
		return getData().getPerformativeName();
	}

	/**
	 * Sets the conversation.
	 *
	 * @param conversation2 the new conversation
	 */
	public void setConversation(final Conversation conversation2) {
		getData().setConversation(conversation2);

	}

}
