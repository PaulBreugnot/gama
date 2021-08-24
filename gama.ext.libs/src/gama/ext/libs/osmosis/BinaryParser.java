/*******************************************************************************************************
 *
 * BinaryParser.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.osmosis;

import java.util.Date;
import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * The Class BinaryParser.
 */
public abstract class BinaryParser implements BlockReaderAdapter {
	
	/** The granularity. */
	protected int granularity;
	
	/** The lat offset. */
	private long lat_offset;
	
	/** The lon offset. */
	private long lon_offset;
	
	/** The date granularity. */
	protected int date_granularity;
	
	/** The strings. */
	private String strings[];

	/**
	 *  Take a Info protocol buffer containing a date and convert it into a java Date object.
	 *
	 * @param info the info
	 * @return the date
	 */
	protected Date getDate(final Osmformat.Info info) {
		if (info.hasTimestamp()) {
			return new Date(date_granularity * info.getTimestamp());
		} else {
			return NODATE;
		}
	}

	/** The Constant NODATE. */
	public static final Date NODATE = new Date(-1);

	/**
	 * Get a string based on the index used.
	 * 
	 * Index 0 is reserved to use as a delimiter, therefore, index 1 corresponds to the first string in the table
	 *
	 * @param id the id
	 * @return the string by id
	 */
	protected String getStringById(final int id) {
		return strings[id];
	}

	@Override
	public void handleBlock(final FileBlock message) {
		// TODO Auto-generated method stub
		try {
			if (message.getType().equals("OSMHeader")) {
				final Osmformat.HeaderBlock headerblock = Osmformat.HeaderBlock.parseFrom(message.getData());
				parse(headerblock);
			} else if (message.getType().equals("OSMData")) {
				final Osmformat.PrimitiveBlock primblock = Osmformat.PrimitiveBlock.parseFrom(message.getData());
				parse(primblock);
			}
		} catch (final InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Error("ParseError"); // TODO
		}

	}

	@Override
	public boolean skipBlock(final FileBlockPosition block) {
		// System.out.println("Seeing block of type: "+block.getType());
		if (block.getType().equals("OSMData")) { return false; }
		if (block.getType().equals("OSMHeader")) { return false; }
		System.out.println("Skipped block of type: " + block.getType());
		return true;
	}

	/**
	 *  Convert a latitude value stored in a protobuf into a double, compensating for granularity and latitude offset.
	 *
	 * @param degree the degree
	 * @return the double
	 */
	public double parseLat(final long degree) {
		// Support non-zero offsets. (We don't currently generate them)
		return (granularity * degree + lat_offset) * .000000001;
	}

	/**
	 * Convert a longitude value stored in a protobuf into a double, compensating for granularity and longitude offset.
	 *
	 * @param degree the degree
	 * @return the double
	 */
	public double parseLon(final long degree) {
		// Support non-zero offsets. (We don't currently generate them)
		return (granularity * degree + lon_offset) * .000000001;
	}

	/**
	 *  Parse a Primitive block (containing a string table, other paramaters, and PrimitiveGroups.
	 *
	 * @param block the block
	 */
	public void parse(final Osmformat.PrimitiveBlock block) {
		final Osmformat.StringTable stablemessage = block.getStringtable();
		strings = new String[stablemessage.getSCount()];

		for (int i = 0; i < strings.length; i++) {
			strings[i] = stablemessage.getS(i).toStringUtf8();
		}

		granularity = block.getGranularity();
		lat_offset = block.getLatOffset();
		lon_offset = block.getLonOffset();
		date_granularity = block.getDateGranularity();

		for (final Osmformat.PrimitiveGroup groupmessage : block.getPrimitivegroupList()) {
			// Exactly one of these should trigger on each loop.
			parseNodes(groupmessage.getNodesList());
			parseWays(groupmessage.getWaysList());
			parseRelations(groupmessage.getRelationsList());
			if (groupmessage.hasDense()) {
				parseDense(groupmessage.getDense());
			}
		}
	}

	/**
	 *  Parse a list of Relation protocol buffers and send the resulting relations to a sink.
	 *
	 * @param rels the rels
	 */
	protected abstract void parseRelations(List<Osmformat.Relation> rels);

	/**
	 *  Parse a DenseNode protocol buffer and send the resulting nodes to a sink.
	 *
	 * @param nodes the nodes
	 */
	protected abstract void parseDense(Osmformat.DenseNodes nodes);

	/**
	 *  Parse a list of Node protocol buffers and send the resulting nodes to a sink.
	 *
	 * @param nodes the nodes
	 */
	protected abstract void parseNodes(List<Osmformat.Node> nodes);

	/**
	 *  Parse a list of Way protocol buffers and send the resulting ways to a sink.
	 *
	 * @param ways the ways
	 */
	protected abstract void parseWays(List<Osmformat.Way> ways);

	/**
	 *  Parse a header message.
	 *
	 * @param header the header
	 */
	protected abstract void parse(Osmformat.HeaderBlock header);

}