/*******************************************************************************************************
 *
 * GamlEncodingProvider.java, in gama.core.lang, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.lang.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.parser.IEncodingProvider;

/**
 * Created by drogoul, 16 déc. 2013
 * 
 */

/**
 * Class GamlEncodingProvider.
 * 
 * @author drogoul
 * @since 16 déc. 2013
 * 
 */
public class GamlEncodingProvider implements IEncodingProvider {

	/**
	 * Method getEncoding()
	 * @see org.eclipse.xtext.parser.IEncodingProvider#getEncoding(org.eclipse.emf.common.util.URI)
	 */
	@Override
	public String getEncoding(final URI uri) {
		return "UTF-8";
	}

}
