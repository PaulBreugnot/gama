/*******************************************************************************************************
 *
 * EntityContainer.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Implementations of this class allow data entities to be processed without the caller knowing their type.
 *
 * @author Brett Henderson
 */
public abstract class EntityContainer implements Storeable {
	/**
	 * Calls the appropriate process method with the contained entity.
	 *
	 * @param processor
	 *            The processor to invoke.
	 */
	public abstract void process(EntityProcessor processor);

	/**
	 * Returns the contained entity.
	 *
	 * @return The entity.
	 */
	public abstract Entity getEntity();

	/**
	 * Returns an instance containing a writeable entity. If the entity within this instance is already writeable then
	 * "this" will be returned, otherwise a cloned entity and container will be created.
	 *
	 * @return A container holding a writeable entity.
	 */
	public abstract EntityContainer getWriteableInstance();
}
