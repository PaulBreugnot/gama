/*******************************************************************************************************
 *
 * GamlProblems.java, in gama.ui.modeling, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.modeling.views;

import java.util.*;
import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.views.markers.FiltersContributionParameters;

/**
 * The Class GamlProblems.
 */
public class GamlProblems extends FiltersContributionParameters {

	/** The parameters map. */
	private static Map<String, Integer> parametersMap;

	static {
		parametersMap = new HashMap<>();
		parametersMap.put(IMarker.SEVERITY,
			new Integer(IMarker.SEVERITY_WARNING | IMarker.SEVERITY_ERROR | IMarker.SEVERITY_INFO));
	}

	/**
	 * Create a new instance of the receiver.
	 */

	public GamlProblems() {}

	@Override
	public Map<String, Integer> getParameterValues() {
		return parametersMap;
	}

}
