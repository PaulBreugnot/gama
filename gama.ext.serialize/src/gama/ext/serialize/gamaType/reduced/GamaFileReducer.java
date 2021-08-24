/*******************************************************************************************************
 *
 * GamaFileReducer.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.gamaType.reduced;

import gama.runtime.IScope;
import gama.util.file.IGamaFile;
import gaml.types.GamaFileType;

/**
 * The Class GamaFileReducer.
 */
@SuppressWarnings ({ "rawtypes" })
public class GamaFileReducer {
	
	/** The path. */
	private final String path;
	// private final IList attributes;

	/**
	 * Instantiates a new gama file reducer.
	 *
	 * @param scope the scope
	 * @param f the f
	 */
	public GamaFileReducer(final IScope scope, final IGamaFile f) {
		path = f.getPath(scope);
		// attributes = f.getAttributes(scope);
	}

	/**
	 * Construct object.
	 *
	 * @param scope the scope
	 * @return the i gama file
	 */
	public IGamaFile constructObject(final IScope scope) {
		return GamaFileType.createFile(scope, path, null);// , attributes) ;
		// return (GamaMatrix) GamaMatrixType.from(scope, valuesMatrixReducer,
		// contentTypeMatrixReducer, new GamaPoint(nCols, nRows)) ;

	}
}
