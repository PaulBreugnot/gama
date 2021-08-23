/*******************************************************************************************************
 *
 * msi.gaml.types.GamaFileType.java, in plugin msi.gama.core, is part of the source code of the GAMA modeling and
 * simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.types;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.type;
import gama.util.file.GamaFolderFile;

/**
 * Written by taillandier Modified on 10 Apr. 2021
 *
 */
@type (
		name = IKeyword.DIRECTORY,
		id = IType.DIRECTORY,
		wraps = { GamaFolderFile.class },
		kind = ISymbolKind.Variable.CONTAINER,
		concept = { IConcept.TYPE, IConcept.FILE },
		doc = @doc ("specific type of for folder"))
public class GamaDirectoryType extends GamaFileType {


}