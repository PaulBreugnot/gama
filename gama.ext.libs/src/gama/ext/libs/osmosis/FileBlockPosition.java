/*******************************************************************************************************
 *
 * FileBlockPosition.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.osmosis;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Stores the position in the stream of a fileblock so that it can be easily read in a random-access fashion.
 *
 * We can turn this into a 'real' block by appropriately seeking into the file and doing a 'read'.
 * 
 */
public class FileBlockPosition extends FileBlockBase {
	
	/**
	 * Instantiates a new file block position.
	 *
	 * @param type the type
	 * @param indexdata the indexdata
	 */
	protected FileBlockPosition(final String type, final ByteString indexdata) {
		super(type, indexdata);
	}

	/**
	 *  Parse out and decompress the data part of a fileblock helper function.
	 *
	 * @param buf the buf
	 * @return the file block
	 * @throws InvalidProtocolBufferException the invalid protocol buffer exception
	 */
	FileBlock parseData(final byte buf[]) throws InvalidProtocolBufferException {
		final FileBlock out = FileBlock.newInstance(type, null, indexdata);
		final Fileformat.Blob blob = Fileformat.Blob.parseFrom(buf);
		if (blob.hasRaw()) {
			out.data = blob.getRaw();
		} else if (blob.hasZlibData()) {
			final byte buf2[] = new byte[blob.getRawSize()];
			final Inflater decompresser = new Inflater();
			decompresser.setInput(blob.getZlibData().toByteArray());
			// decompresser.getRemaining();
			try {
				decompresser.inflate(buf2);
			} catch (final DataFormatException e) {
				e.printStackTrace();
				throw new Error(e);
			}
			assert decompresser.finished();
			decompresser.end();
			out.data = ByteString.copyFrom(buf2);
		}
		return out;
	}

	/**
	 * Gets the datasize.
	 *
	 * @return the datasize
	 */
	public int getDatasize() {
		return datasize;
	}

	/**
	 * New instance.
	 *
	 * @param base the base
	 * @param offset the offset
	 * @param length the length
	 * @return the file block position
	 */
	/*
	 * Given any form of fileblock and an offset/length value, return a reference that can be used to dereference and
	 * read the contents.
	 */
	static FileBlockPosition newInstance(final FileBlockBase base, final long offset, final int length) {
		final FileBlockPosition out = new FileBlockPosition(base.type, base.indexdata);
		out.datasize = length;
		out.data_offset = offset;
		return out;
	}

	/**
	 * Read.
	 *
	 * @param input the input
	 * @return the file block
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public FileBlock read(final InputStream input) throws IOException {
		if (input instanceof FileInputStream) {
			((FileInputStream) input).getChannel().position(data_offset);
			final byte buf[] = new byte[getDatasize()];
			new DataInputStream(input).readFully(buf);
			return parseData(buf);
		} else {
			throw new Error("Random access binary reads require seekability");
		}
	}

	/**
	 * TODO: Convert this reference into a serialized representation that can be stored.
	 *
	 * @return the byte string
	 */
	public ByteString serialize() {
		throw new Error("TODO");
	}

	/**
	 *  TODO: Parse a serialized representation of this block reference.
	 *
	 * @param b the b
	 * @return the file block position
	 */
	static FileBlockPosition parseFrom(final ByteString b) {
		throw new Error("TODO");
	}

	/** The datasize. */
	protected int datasize;
	
	/**  Offset into the file of the data part of the block. */
	long data_offset;
}
