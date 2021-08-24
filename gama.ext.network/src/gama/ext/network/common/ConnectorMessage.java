/*********************************************************************************************
 *
 * 'ConnectorMessage.java, in plugin ummisco.gama.network, is part of the source code of the GAMA modeling and
 * simulation platform. (v. 1.8.1)
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

public interface ConnectorMessage {
	String getSender();

	String getReceiver();

	String getPlainContents();

	boolean isPlainMessage();

	boolean isCommandMessage();

	GamaMessage getContents(IScope scope);
}
