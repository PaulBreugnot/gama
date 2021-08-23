/*******************************************************************************************************
 *
 * msi.gama.util.file.GamaGraphMLFile.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
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

@file (
		name = "graphgexf",
		extensions = { "gexf" },
		buffer_type = IType.GRAPH,
		concept = { IConcept.GRAPH, IConcept.FILE },
		doc = @doc ("Represents files that contain Graph information. The internal representation is a graph"))
@SuppressWarnings ({ "unchecked", "rawtypes" })
public class GamaGraphGexf extends GamaGraphFile {

	public GamaGraphGexf(final IScope scope, final String pn) throws GamaRuntimeException {
		super(scope, pn);
	}

	public GamaGraphGexf(final IScope scope, final String pathName, final ISpecies nodeSpecies) {
		super(scope, pathName, nodeSpecies);
	}

	public GamaGraphGexf(final IScope scope, final String pathName, final ISpecies nodeSpecies, final ISpecies edgeSpecies) {
		super(scope, pathName,nodeSpecies,edgeSpecies);
	}

	@Override
	protected String getFileType() {
		return "gexf";
	}

}
