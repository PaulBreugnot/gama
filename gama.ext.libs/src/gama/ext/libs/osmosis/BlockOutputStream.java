/*******************************************************************************************************
 *
 * BlockOutputStream.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.osmosis;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

enum CompressFlags {
	NONE, DEFLATE
}

/**
 * The Class BlockOutputStream.
 */
public class BlockOutputStream {

	/**
	 * Instantiates a new block output stream.
	 *
	 * @param output the output
	 */
	public BlockOutputStream(final OutputStream output) {
		this.outwrite = new DataOutputStream(output);
		this.compression = CompressFlags.DEFLATE;
	}

	/**
	 * Sets the compress.
	 *
	 * @param flag the new compress
	 */
	public void setCompress(final CompressFlags flag) {
		compression = flag;
	}

	/**
	 * Sets the compress.
	 *
	 * @param s the new compress
	 */
	public void setCompress(final String s) {
		if (s.equals("none")) {
			compression = CompressFlags.NONE;
		} else if (s.equals("deflate")) {
			compression = CompressFlags.DEFLATE;
		} else {
			throw new Error("Unknown compression type: " + s);
		}
	}

	/**
	 *  Write a block with the stream's default compression flag.
	 *
	 * @param block the block
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void write(final FileBlock block) throws IOException {
		this.write(block, compression);
	}

	/**
	 *  Write a specific block with a specific compression flags.
	 *
	 * @param block the block
	 * @param compression the compression
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void write(final FileBlock block, final CompressFlags compression) throws IOException {
		final FileBlockPosition ref = block.writeTo(outwrite, compression);
		writtenblocks.add(ref);
	}

	/**
	 * Flush.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void flush() throws IOException {
		outwrite.flush();
	}

	/**
	 * Close.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void close() throws IOException {
		outwrite.flush();
		outwrite.close();
	}

	/** The outwrite. */
	OutputStream outwrite;
	
	/** The writtenblocks. */
	List<FileBlockPosition> writtenblocks = new ArrayList<>();
	
	/** The compression. */
	CompressFlags compression;
}
