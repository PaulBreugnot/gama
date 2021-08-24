/*******************************************************************************************************
 *
 * FileBlockReference.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.osmosis;

import java.io.IOException;
import java.io.InputStream;

import com.google.protobuf.ByteString;

/**
 * A FileBlockPosition that remembers what file this is so that it can simply be dereferenced.
 */
public class FileBlockReference extends FileBlockPosition {

	/** Convenience cache for storing the input this reference is contained within so that it can be cached. */
	protected InputStream input;

	/**
	 * Instantiates a new file block reference.
	 *
	 * @param type the type
	 * @param indexdata the indexdata
	 */
	protected FileBlockReference(final String type, final ByteString indexdata) {
		super(type, indexdata);
	}

	/**
	 * Read.
	 *
	 * @return the file block
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public FileBlock read() throws IOException {
		return read(input);
	}

	/**
	 * New instance.
	 *
	 * @param base the base
	 * @param input the input
	 * @param offset the offset
	 * @param length the length
	 * @return the file block position
	 */
	static FileBlockPosition newInstance(final FileBlockBase base, final InputStream input, final long offset,
			final int length) {
		final FileBlockReference out = new FileBlockReference(base.type, base.indexdata);
		out.datasize = length;
		out.data_offset = offset;
		out.input = input;
		return out;
	}
}
