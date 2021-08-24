/*******************************************************************************************************
 *
 * MultiThreadedUDPSocketServer.java, in gama.ext.network, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.network.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;

import gama.core.dev.utils.DEBUG;
import gama.ext.network.common.ConnectorMessage;
import gama.ext.network.common.MessageFactory;
import gama.ext.network.common.NetworkMessage;
import gama.metamodel.agent.IAgent;
import gama.util.GamaListFactory;
import gama.util.IList;

/**
 * The Class MultiThreadedUDPSocketServer.
 */
public class MultiThreadedUDPSocketServer extends Thread {

	static {
		DEBUG.ON();
	}

	/** The my agent. */
	private final IAgent myAgent;
	
	/** The closed. */
	private volatile boolean closed = false;
	
	/** The my UDP server socket. */
	private DatagramSocket myUDPServerSocket;
	
	/** The nb bits. */
	private int nbBits ;

	/**
	 * Gets the my server socket.
	 *
	 * @return the myServerSocket
	 */
	public DatagramSocket getMyServerSocket() {
		return myUDPServerSocket;
	}

	/**
	 * Sets the my server socket.
	 *
	 * @param u the new my server socket
	 */
	public void setMyServerSocket(final DatagramSocket u) {
		this.myUDPServerSocket = u;
	}

	/**
	 * Instantiates a new multi threaded UDP socket server.
	 *
	 * @param a the a
	 * @param ss the ss
	 * @param maxSizePackage the max size package
	 */
	public MultiThreadedUDPSocketServer(final IAgent a, final DatagramSocket ss, final String maxSizePackage) {
		myAgent = a;
		myUDPServerSocket = ss;
		nbBits = (maxSizePackage == null) ? 1024 : Integer.parseInt(maxSizePackage);
	}

	@SuppressWarnings ("unchecked")
	@Override
	public void run() {
		// Successfully created Server Socket. Now wait for connections.
		while (!closed) {
			try {
				if (myAgent.dead()) {
					this.interrupt();
				}
				final byte[] receiveData = new byte[nbBits];
				// Accept incoming connections.
				final DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				myUDPServerSocket.receive(receivePacket);
				final String sentence = new String(receivePacket.getData());

				IList<ConnectorMessage> msgs = (IList<ConnectorMessage>) myAgent.getAttribute("messages" + myAgent);
				if (msgs == null) {
					msgs = GamaListFactory.create(ConnectorMessage.class);
				}
				if (myAgent.dead()) {
					this.interrupt();
				}

				final NetworkMessage msg = MessageFactory.buildNetworkMessage(myUDPServerSocket.toString(), sentence);
				msgs.addValue(myAgent.getScope(), msg);

				myAgent.setAttribute("messages" + myAgent, msgs);

			} catch (final SocketTimeoutException ste) {
				closed = true;
				// ste.printStackTrace();
				// DEBUG.LOG("closed ");
			} catch (final Exception ioe) {
				if (myUDPServerSocket.isClosed()) {
					closed = true;
					this.interrupt();
				} else {
					ioe.printStackTrace();
				}
			}

		}
	}
}