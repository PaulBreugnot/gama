/*******************************************************************************************************
 *
 * RelationContainer.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Entity container implementation for relations.
 *
 * @author Brett Henderson
 */
public class RelationContainer extends EntityContainer {

	/** The relation. */
	private final Relation relation;

	/**
	 * Creates a new instance.
	 *
	 * @param relation
	 *            The relation to wrap.
	 */
	public RelationContainer(final Relation relation) {
		this.relation = relation;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void store(final StoreWriter sw, final StoreClassRegister scr) {
		relation.store(sw, scr);
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
	public Relation getEntity() {
		return relation;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RelationContainer getWriteableInstance() {
		if (relation.isReadOnly()) {
			return new RelationContainer(relation.getWriteableInstance());
		} else {
			return this;
		}
	}
}
