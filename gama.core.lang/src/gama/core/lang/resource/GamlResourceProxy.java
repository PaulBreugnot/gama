/*******************************************************************************************************
 *
 * GamlResourceProxy.java, in gama.core.lang, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.lang.resource;

import java.io.IOException;

/**
 * The Class GamlResourceProxy.
 */
public class GamlResourceProxy {

	/** The resource. */
	GamlResource resource;
	
	/** The is synthetic. */
	Boolean isSynthetic;

	/**
	 * Instantiates a new gaml resource proxy.
	 *
	 * @param r the r
	 * @param synthetic the synthetic
	 */
	public GamlResourceProxy(final GamlResource r, final boolean synthetic) {
		setRealResource(r, synthetic);
	}

	/**
	 * Sets the real resource.
	 *
	 * @param r the r
	 * @param synthetic the synthetic
	 */
	public void setRealResource(final GamlResource r, final boolean synthetic) {
		resource = r;
		isSynthetic = synthetic;
	}

	/**
	 * Gets the real resource.
	 *
	 * @return the real resource
	 */
	public GamlResource getRealResource() {
		return resource;
	}

	/**
	 * Checks if is synthetic.
	 *
	 * @return true, if is synthetic
	 */
	public boolean isSynthetic() {
		return resource != null && isSynthetic;
	}

	/**
	 * Dispose.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void dispose() throws IOException {
		if (isSynthetic && resource != null) {
			resource.delete(null);
			resource = null;
		}
	}

}
