/*******************************************************************************************************
 *
 * GamaGraphGML.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util.file;

import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.file;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.species.ISpecies;
import gaml.types.IType;

/**
 * The Class GamaGraphGML.
 */
@file (
		name = "graphgml",
		extensions = { "gml" },
		buffer_type = IType.GRAPH,
		concept = { IConcept.GRAPH, IConcept.FILE },
		doc = @doc ("Represents files that contain Graph information. The internal representation is a graph"))
@SuppressWarnings ({ "unchecked", "rawtypes" })
public class GamaGraphGML extends GamaGraphFile {

	/**
	 * Instantiates a new gama graph GML.
	 *
	 * @param scope the scope
	 * @param pn the pn
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public GamaGraphGML(final IScope scope, final String pn) throws GamaRuntimeException {
		super(scope, pn);
	}

	/**
	 * Instantiates a new gama graph GML.
	 *
	 * @param scope the scope
	 * @param pathName the path name
	 * @param nodeSpecies the node species
	 */
	public GamaGraphGML(final IScope scope, final String pathName, final ISpecies nodeSpecies) {
		super(scope, pathName, nodeSpecies);
	}

	/**
	 * Instantiates a new gama graph GML.
	 *
	 * @param scope the scope
	 * @param pathName the path name
	 * @param nodeSpecies the node species
	 * @param edgeSpecies the edge species
	 */
	public GamaGraphGML(final IScope scope, final String pathName,  final ISpecies nodeSpecies, final ISpecies edgeSpecies) {
		super(scope, pathName,nodeSpecies,edgeSpecies);
	}

	@Override
	protected String getFileType() {
		return "gml";
	}

}
