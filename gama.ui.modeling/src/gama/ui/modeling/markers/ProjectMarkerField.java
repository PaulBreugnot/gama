/*******************************************************************************************************
 *
 * ProjectMarkerField.java, in gama.ui.modeling, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.modeling.markers;

import org.eclipse.ui.views.markers.*;

/**
 * The Class ProjectMarkerField.
 */
public class ProjectMarkerField extends MarkerField {

	/**
	 * Instantiates a new project marker field.
	 */
	public ProjectMarkerField() {}

	@Override
	public String getValue(final MarkerItem item) {
		if ( item.getMarker() == null ) { return null; }
		return item.getMarker().getResource().getProject().getName();
	}

}
