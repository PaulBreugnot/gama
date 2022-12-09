/*******************************************************************************************************
 *
 * MouseEventLayerDelegate.java, in msi.gama.core, is part of the source code of the
 * GAMA modeling and simulation platform (v.1.9.0).
 *
 * (c) 2007-2022 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package msi.gama.outputs.layers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import msi.gama.common.interfaces.IEventLayerDelegate;
import msi.gama.common.interfaces.IKeyword;
import msi.gama.runtime.IScope;

/**
 * The Class MouseEventLayerDelegate.
 */
public class MouseEventLayerDelegate implements IEventLayerDelegate {

	/** The Constant EVENTS. */
	public static final Set<String> EVENTS = new HashSet<>(Arrays.asList(IKeyword.MOUSE_UP, IKeyword.MOUSE_DOWN,
			IKeyword.MOUSE_MOVED, IKeyword.MOUSE_ENTERED, IKeyword.MOUSE_EXITED, IKeyword.MOUSE_MENU));

	@Override
	public boolean acceptSource(final IScope scope, final Object source) {
		return Objects.equals(source, IKeyword.DEFAULT);
	}

	@Override
	public boolean createFrom(final IScope scope, final Object source, final EventLayerStatement statement) {
		return true;
	}

	@Override
	public Set<String> getEvents() {
		return EVENTS;
	}

}