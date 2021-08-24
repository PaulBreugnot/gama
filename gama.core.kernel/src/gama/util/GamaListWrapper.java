/*******************************************************************************************************
 *
 * GamaListWrapper.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util;

import java.util.List;

import com.google.common.collect.ForwardingList;

import gaml.types.IContainerType;
import gaml.types.IType;
import gaml.types.Types;

/**
 * The Class GamaListWrapper.
 *
 * @param <E> the element type
 */
public class GamaListWrapper<E> extends ForwardingList<E> implements IList<E> {

	/** The wrapped. */
	final List<E> wrapped;
	
	/** The type. */
	final IContainerType type;

	/**
	 * Instantiates a new gama list wrapper.
	 *
	 * @param wrapped the wrapped
	 * @param contents the contents
	 */
	GamaListWrapper(final List<E> wrapped, final IType contents) {
		this.type = Types.LIST.of(contents);
		this.wrapped = wrapped;
	}

	@Override
	public IContainerType<?> getGamlType() {
		return type;
	}

	@Override
	protected List<E> delegate() {
		return wrapped;
	}

}
