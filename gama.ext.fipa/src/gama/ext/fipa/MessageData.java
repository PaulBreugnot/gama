/*******************************************************************************************************
 *
 * MessageData.java, in gama.ext.fipa, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.fipa;

import gama.metamodel.agent.IAgent;
import gama.util.IList;

/**
 * The Message class represents the piece of information transfered between agents capable of communicating.
 */
@SuppressWarnings ({ "rawtypes", "unchecked" })
public class MessageData {

	/** The name of sender. */
	private IAgent sender;

	/** The name of all receivers. */
	private IList<IAgent> receivers;

	/** The content of the message. */
	private IList content;

	/** The performative of the message (defined by the FIPA). */
	private Performative performative;

	/** The associated conversation. */
	private Conversation conversation;

	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.misc.current_development.IMessage#getSender()
	 */
	public IAgent getSender() {
		return sender;
	}

	/**
	 * Sets the sender.
	 *
	 * @param sender the new sender
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.misc.current_development.IMessage#setSender(msi.gama.metamodel.agent .interfaces.BasicEntity)
	 */
	public void setSender(final IAgent sender) {
		this.sender = sender;
	}

	/**
	 * Gets the receivers.
	 *
	 * @return the receivers
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.misc.current_development.IMessage#getReceivers()
	 */
	public IList getReceivers() {
		return receivers;
	}

	/**
	 * Sets the receivers.
	 *
	 * @param receivers the new receivers
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.misc.current_development.IMessage#setReceivers(java.util.List)
	 */
	public void setReceivers(final IList receivers) {
		this.receivers = receivers;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.misc.current_development.IMessage#getContent()
	 */
	public IList getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.misc.current_development.IMessage#setContent(java.lang.String)
	 */
	public void setContent(final IList content) {
		if (content != null) {
			this.content = content;
		}
	}

	/**
	 * Gets the performative name.
	 *
	 * @return the performative name
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.misc.current_development.IMessage#getPerformative()
	 */
	public String getPerformativeName() {
		return performative.name();
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
		return performative;
	}

	/**
	 * Sets the performative name.
	 *
	 * @param performative the new performative name
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.misc.current_development.IMessage#setPerformative(java.lang.String)
	 */
	public void setPerformativeName(final String performative) {
		this.performative = Performative.valueOf(performative);
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
		this.performative = performative;
	}

	/**
	 * Gets the conversation.
	 *
	 * @return the conversation
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.misc.current_development.IMessage#getConversation()
	 */
	public Conversation getConversation() {
		return conversation;
	}

	/**
	 * Sets the conversation.
	 *
	 * @param conv the new conversation
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.misc.current_development.IMessage#setConversation(msi.gama.metamodel .agent.interfaces.BasicEntity)
	 */
	public void setConversation(final Conversation conv) {
		conversation = conv;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuffer retVal = new StringBuffer();
		retVal.append("Message[sender : " + sender + ", receivers : " + receivers + ", conversation : " + conversation
				+ ", performative : " + performative + "]");
		return retVal.toString();
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see msi.misc.current_development.IMessage#getMessage()
	 */
	public MessageData getMessage() {
		return this;
	}

}
