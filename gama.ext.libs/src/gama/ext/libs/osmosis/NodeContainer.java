/*******************************************************************************************************
 *
 * NodeContainer.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Entity container implementation for nodes.
 *
 * @author Brett Henderson
 */
public class NodeContainer extends EntityContainer {

	/** The node. */
	private final Node node;

	/**
	 * Creates a new instance.
	 *
	 * @param node
	 *            The node to wrap.
	 */
	public NodeContainer(final Node node) {
		this.node = node;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void store(final StoreWriter sw, final StoreClassRegister scr) {
		node.store(sw, scr);
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
	public Node getEntity() {
		return node;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NodeContainer getWriteableInstance() {
		if (node.isReadOnly()) {
			return new NodeContainer(node.getWriteableInstance());
		} else {
			return this;
		}
	}
}
