/*******************************************************************************************************
 *
 * BoundContainer.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Entity container implementation for bound.
 *
 * @author knewman
 */
public class BoundContainer extends EntityContainer {

	/** The bound. */
	private final Bound bound;

	/**
	 * Creates a new instance.
	 *
	 * @param bound
	 *            The bound to wrap.
	 */
	public BoundContainer(final Bound bound) {
		this.bound = bound;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void store(final StoreWriter sw, final StoreClassRegister scr) {
		bound.store(sw, scr);
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
	public Bound getEntity() {
		return bound;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BoundContainer getWriteableInstance() {
		if (bound.isReadOnly()) {
			return new BoundContainer(bound.getWriteableInstance());
		} else {
			return this;
		}
	}
}
