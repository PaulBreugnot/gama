/*********************************************************************************************
 *
 * 'ConnectorMessage.java, in plugin ummisco.gama.network, is part of the source code of the
 * GAMA modeling and simulation platform.
 * (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 * 
 *
 **********************************************************************************************/
package gama.ext.network.common;

import gama.extensions.messaging.GamaMessage;
import gama.runtime.IScope;

public interface ConnectorMessage {
	public String getSender();
	public String getReceiver();
	public String getPlainContents();
	public boolean isPlainMessage();
	public boolean isCommandMessage();
	public GamaMessage getContents(IScope scope);
}
