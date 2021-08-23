/*******************************************************************************************************
 *
 * msi.gaml.types.GamaKmlExportType.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.types;

import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.type;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;


@type(name = "kml", id = IType.KML, wraps = {
		GamaKmlExport.class }, kind = ISymbolKind.Variable.REGULAR, concept = { IConcept.TYPE },
				doc = {@doc(value = "Type of variables that enables to store objects that to export them into a KML (Keyhole Markup Language) file")})
public class GamaKmlExportType extends GamaType<GamaKmlExport> {

	@Override
	public boolean canCastToConst() {
		return true;
	}

	@Override
	public GamaKmlExport cast(final IScope scope, final Object obj, final Object param, final boolean copy)
			throws GamaRuntimeException {
		if (obj instanceof GamaKmlExport) {
			return (GamaKmlExport) obj;
		}
		return null;
	}

	@Override
	public GamaKmlExport getDefault() {
		return new GamaKmlExport(); 
	}

}
