/*******************************************************************************************************
 *
 * IGamlResourceInfoProvider.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util.file;

import org.eclipse.emf.common.util.URI;

import gaml.compilation.ast.ISyntacticElement;

/**
 * The Interface IGamlResourceInfoProvider.
 */
public interface IGamlResourceInfoServices {

	/**
	 * Gets the info.
	 *
	 * @param uri the uri
	 * @param stamp the stamp
	 * @return the info
	 */
	public GamlFileInfo getInfo(final URI uri, final long stamp);

	/**
	 * Gets the contents.
	 *
	 * @param uri the uri
	 * @return the contents
	 */
	public ISyntacticElement getContents(URI uri);

}
