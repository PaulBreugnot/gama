/*******************************************************************************************************
 *
 * GamaMatrixReducer.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.gamaType.reduced;

import gama.metamodel.shape.GamaPoint;
import gama.runtime.IScope;
import gama.util.IList;
import gama.util.matrix.GamaMatrix;
import gaml.types.GamaMatrixType;
import gaml.types.IType;

/**
 * The Class GamaMatrixReducer.
 */
@SuppressWarnings({ "rawtypes" })
public class GamaMatrixReducer {
	
	/** The content type matrix reducer. */
	private final IType contentTypeMatrixReducer;
	
	/** The values matrix reducer. */
	private final IList valuesMatrixReducer;
	
	/** The n rows. */
	private final int nRows;
	
	/** The n cols. */
	private final int nCols;

	/**
	 * Instantiates a new gama matrix reducer.
	 *
	 * @param scope the scope
	 * @param m the m
	 */
	public GamaMatrixReducer(final IScope scope, final GamaMatrix m) {
		contentTypeMatrixReducer = m.getGamlType().getContentType();
		nRows = m.getRows(null);
		nCols = m.getCols(null);
		valuesMatrixReducer = m.listValue(scope, contentTypeMatrixReducer, true);
	}

	/**
	 * Construct object.
	 *
	 * @param scope the scope
	 * @return the gama matrix
	 */
	public GamaMatrix constructObject(final IScope scope) {
		return (GamaMatrix) GamaMatrixType.from(scope, valuesMatrixReducer, contentTypeMatrixReducer,
				new GamaPoint(nCols, nRows));

	}
}
