/*******************************************************************************************************
 *
 * BlockReaderAdapter.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.osmosis;

/**
 *  An adaptor that receives blocks from an input stream.
 */
public interface BlockReaderAdapter {
	
	/**
	 * Does the reader understand this block? Does it want the data in it?
	 * 
	 * A reference contains the metadata about a block and can saved --- or stored ---- for future random access.
	 * However, during a strea read of the file, does the user want this block?
	 * 
	 * handleBlock will be called on all blocks that are not skipped, in file order.
	 *
	 * @param message the message
	 * @return true, if successful
	 */
	boolean skipBlock(FileBlockPosition message);

	/**
	 *  Called with the data in the block.
	 *
	 * @param message the message
	 */
	void handleBlock(FileBlock message);

	/** Called when the file is fully read. */
	void complete();
}
