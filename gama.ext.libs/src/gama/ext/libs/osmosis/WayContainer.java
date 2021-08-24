/*******************************************************************************************************
 *
 * WayContainer.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Entity container implementation for ways.
 *
 * @author Brett Henderson
 */
public class WayContainer extends EntityContainer {

	/** The way. */
	private final Way way;

	/**
	 * Creates a new instance.
	 *
	 * @param way
	 *            The way to wrap.
	 */
	public WayContainer(final Way way) {
		this.way = way;
	}

	/**
	 * Creates a new instance.
	 *
	 * @param sr
	 *            The store to read state from.
	 * @param scr
	 *            Maintains the mapping between classes and their identifiers within the store.
	 */
	public WayContainer(final StoreReader sr, final StoreClassRegister scr) {
		way = new Way(sr, scr);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void store(final StoreWriter sw, final StoreClassRegister scr) {
		way.store(sw, scr);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void process(final EntityProcessor processor) {
		processor.process(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Way getEntity() {
		return way;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WayContainer getWriteableInstance() {
		if (way.isReadOnly()) {
			return new WayContainer(way.getWriteableInstance());
		} else {
			return this;
		}
	}
}
