/*******************************************************************************************************
 *
 * FileBlockHead.java, in gama.ext.libs, is part of the source code of the
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

import com.google.protobuf.ByteString;

/**
 * Intermediate representation of the header of a fileblock when a set of fileblocks is read as in a stream. The data in
 * the fileblock must be either skipped (where the returned value is a reference to the fileblock) or parsed.
 *
 * @author crosby
 *
 */
public class FileBlockHead extends FileBlockReference {
	
	/**
	 * Instantiates a new file block head.
	 *
	 * @param type the type
	 * @param indexdata the indexdata
	 */
	protected FileBlockHead(final String type, final ByteString indexdata) {
		super(type, indexdata);
	}

	/**
	 * Read the header. After reading the header, either the contents must be skipped or read
	 *
	 * @param input the input
	 * @return the file block head
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	static FileBlockHead readHead(final InputStream input) throws IOException {
		final DataInputStream datinput = new DataInputStream(input);
		final int headersize = datinput.readInt();
		// System.out.format("Header size %d %x\n",headersize,headersize);
		if (headersize > MAX_HEADER_SIZE) {
			throw new FileFormatException(
					"Unexpectedly long header " + MAX_HEADER_SIZE + " bytes. Possibly corrupt file.");
		}

		final byte buf[] = new byte[headersize];
		datinput.readFully(buf);
		// System.out.format("Read buffer for header of %d bytes\n",buf.length);
		final Fileformat.BlobHeader header = Fileformat.BlobHeader.parseFrom(buf);
		final FileBlockHead fileblock = new FileBlockHead(header.getType(), header.getIndexdata());

		fileblock.datasize = header.getDatasize();
		if (header.getDatasize() > MAX_BODY_SIZE) {
			throw new FileFormatException("Unexpectedly long body " + MAX_BODY_SIZE + " bytes. Possibly corrupt file.");
		}

		fileblock.input = input;
		if (input instanceof FileInputStream) {
			fileblock.data_offset = ((FileInputStream) input).getChannel().position();
		}

		return fileblock;
	}

	/**
	 * Assumes the stream is positioned over at the start of the data, skip over it.
	 *
	 * @param input the input
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	void skipContents(final InputStream input) throws IOException {
		if (input.skip(getDatasize()) != getDatasize()) {
			assert false : "SHORT READ";
		}
	}

	/**
	 * Assumes the stream is positioned over at the start of the data, read it and return the complete FileBlock.
	 *
	 * @param input the input
	 * @return the file block
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	FileBlock readContents(final InputStream input) throws IOException {
		final DataInputStream datinput = new DataInputStream(input);
		final byte buf[] = new byte[getDatasize()];
		datinput.readFully(buf);
		return parseData(buf);
	}
}
