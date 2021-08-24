/*******************************************************************************************************
 *
 * FileBlock.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.osmosis;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.zip.Deflater;

import com.google.protobuf.ByteString;

import gama.ext.libs.osmosis.Fileformat.BlobHeader;

/**
 *  A full fileblock object contains both the metadata and data of a fileblock.
 */
public class FileBlock extends FileBlockBase {
	
	/**  Contains the contents of a block for use or further processing. */
	ByteString data; // serialized Format.Blob

	/**  Don't be noisy unless the warning occurs somewhat often. */
	static int warncount = 0;

	/**
	 * Instantiates a new file block.
	 *
	 * @param type the type
	 * @param blob the blob
	 * @param indexdata the indexdata
	 */
	private FileBlock(final String type, final ByteString blob, final ByteString indexdata) {
		super(type, indexdata);
		this.data = blob;
	}

	/**
	 * New instance.
	 *
	 * @param type the type
	 * @param blob the blob
	 * @param indexdata the indexdata
	 * @return the file block
	 */
	public static FileBlock newInstance(final String type, final ByteString blob, final ByteString indexdata) {
		if (blob != null && blob.size() > MAX_BODY_SIZE / 2) {
			System.err.println("Warning: Fileblock has body size too large and may be considered corrupt");
			if (blob.size() > MAX_BODY_SIZE - 1024 * 1024) {
				throw new Error("This file has too many entities in a block. Parsers will reject it.");
			}
		}
		if (indexdata != null && indexdata.size() > MAX_HEADER_SIZE / 2) {
			System.err.println("Warning: Fileblock has indexdata too large and may be considered corrupt");
			if (indexdata.size() > MAX_HEADER_SIZE - 512) {
				throw new Error("This file header is too large. Parsers will reject it.");
			}
		}
		return new FileBlock(type, blob, indexdata);
	}

	/**
	 * Deflate into.
	 *
	 * @param blobbuilder the blobbuilder
	 */
	protected void deflateInto(final Fileformat.Blob.Builder blobbuilder) {
		final int size = data.size();
		final Deflater deflater = new Deflater();
		deflater.setInput(data.toByteArray());
		deflater.finish();
		byte out[] = new byte[size];
		deflater.deflate(out);

		if (!deflater.finished()) {
			// Buffer wasn't long enough. Be noisy.
			++warncount;
			if (warncount > 10 && warncount % 100 == 0) {
				System.err.println("Compressed buffers are too short, causing extra copy");
			}
			out = Arrays.copyOf(out, size + size / 64 + 16);
			deflater.deflate(out, deflater.getTotalOut(), out.length - deflater.getTotalOut());
			if (!deflater.finished()) { throw new Error("Internal error in compressor"); }
		}
		final ByteString compressed = ByteString.copyFrom(out, 0, deflater.getTotalOut());
		blobbuilder.setZlibData(compressed);
		deflater.end();
	}

	/**
	 * Write to.
	 *
	 * @param outwrite the outwrite
	 * @param flags the flags
	 * @return the file block position
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public FileBlockPosition writeTo(final OutputStream outwrite, final CompressFlags flags) throws IOException {
		final BlobHeader.Builder builder = Fileformat.BlobHeader.newBuilder();
		if (indexdata != null) {
			builder.setIndexdata(indexdata);
		}
		builder.setType(type);

		final Fileformat.Blob.Builder blobbuilder = Fileformat.Blob.newBuilder();
		if (flags == CompressFlags.NONE) {
			blobbuilder.setRaw(data);
			blobbuilder.setRawSize(data.size());
		} else {
			blobbuilder.setRawSize(data.size());
			if (flags == CompressFlags.DEFLATE) {
				deflateInto(blobbuilder);
			} else {
				throw new Error("Compression flag not understood");
			}
		}
		final Fileformat.Blob blob = blobbuilder.build();

		builder.setDatasize(blob.getSerializedSize());
		final Fileformat.BlobHeader message = builder.build();
		final int size = message.getSerializedSize();

		// System.out.format("Outputed header size %d bytes, header of %d bytes, and blob of %d bytes\n",
		// size,message.getSerializedSize(),blob.getSerializedSize());
		new DataOutputStream(outwrite).writeInt(size);
		message.writeTo(outwrite);
		long offset = -1;

		if (outwrite instanceof FileOutputStream) {
			offset = ((FileOutputStream) outwrite).getChannel().position();
		}

		blob.writeTo(outwrite);
		return FileBlockPosition.newInstance(this, offset, size);
	}

	/**
	 *  Reads or skips a fileblock.
	 *
	 * @param input the input
	 * @param callback the callback
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	static void process(final InputStream input, final BlockReaderAdapter callback) throws IOException {
		final FileBlockHead fileblock = FileBlockHead.readHead(input);
		if (callback.skipBlock(fileblock)) {
			// System.out.format("Attempt to skip %d bytes\n",header.getDatasize());
			fileblock.skipContents(input);
		} else {
			callback.handleBlock(fileblock.readContents(input));
		}
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public ByteString getData() {
		return data;
	}
}
