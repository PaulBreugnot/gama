/*******************************************************************************************************
 *
 * BlockInputStream.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.osmosis;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
 * The Class BlockInputStream.
 */
public class BlockInputStream {
	
	/**
	 * Instantiates a new block input stream.
	 *
	 * @param input the input
	 * @param adaptor the adaptor
	 */
	// TODO: Should be seekable input stream!
	public BlockInputStream(final InputStream input, final BlockReaderAdapter adaptor) {
		this.input = input;
		this.adaptor = adaptor;
	}

	/**
	 * Process.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void process() throws IOException {
		try {
			while (true) {
				FileBlock.process(input, adaptor);
			}
		} catch (final EOFException e) {
			adaptor.complete();
		}
	}

	/**
	 * Close.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void close() throws IOException {
		input.close();
	}

	/** The input. */
	InputStream input;
	
	/** The adaptor. */
	BlockReaderAdapter adaptor;
}
