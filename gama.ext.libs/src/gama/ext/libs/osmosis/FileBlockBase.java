/*******************************************************************************************************
 *
 * FileBlockBase.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.osmosis;

import com.google.protobuf.ByteString;

/**
 * Base class that contains the metadata about a fileblock.
 *
 * Subclasses of this include additional fields, such as byte offsets that let a fileblock be read in a random-access
 * fashion, or the data itself.
 *
 * @author crosby
 *
 */
public class FileBlockBase {

	/**
	 * If a block header is bigger than this, fail. We use excessively large header size as an indication of corrupt
	 * files
	 */
	static final int MAX_HEADER_SIZE = 64 * 1024;
	/**
	 * If a block's size is bigger than this, fail. We use excessively large block sizes as an indication of corrupt
	 * files
	 */
	static final int MAX_BODY_SIZE = 32 * 1024 * 1024;

	/**
	 * Instantiates a new file block base.
	 *
	 * @param type the type
	 * @param indexdata the indexdata
	 */
	protected FileBlockBase(final String type, final ByteString indexdata) {
		this.type = type;
		this.indexdata = indexdata;
	}

	/**  Identifies the type of the data within a block. */
	protected final String type;
	/**
	 * Block metadata, stored in the index block and as a prefix for every block.
	 */
	protected final ByteString indexdata;

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Gets the index data.
	 *
	 * @return the index data
	 */
	public ByteString getIndexData() {
		return indexdata;
	}
}
