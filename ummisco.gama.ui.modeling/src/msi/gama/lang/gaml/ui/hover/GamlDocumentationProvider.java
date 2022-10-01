/*******************************************************************************************************
 *
 * GamlDocumentationProvider.java, in ummisco.gama.ui.modeling, is part of the source code of the GAMA modeling and
 * simulation platform (v.1.8.2).
 *
 * (c) 2007-2022 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package msi.gama.lang.gaml.ui.hover;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;

import com.google.inject.Inject;

import msi.gama.common.interfaces.IDocManager;
import msi.gama.common.interfaces.IGamlDescription;
import msi.gama.common.util.FileUtils;
import msi.gama.lang.gaml.EGaml;
import msi.gama.lang.gaml.gaml.ActionRef;
import msi.gama.lang.gaml.gaml.Facet;
import msi.gama.lang.gaml.gaml.Function;
import msi.gama.lang.gaml.gaml.Import;
import msi.gama.lang.gaml.gaml.S_Definition;
import msi.gama.lang.gaml.gaml.S_Global;
import msi.gama.lang.gaml.gaml.Statement;
import msi.gama.lang.gaml.gaml.StringLiteral;
import msi.gama.lang.gaml.gaml.TypeRef;
import msi.gama.lang.gaml.gaml.UnitName;
import msi.gama.lang.gaml.gaml.VarDefinition;
import msi.gama.lang.gaml.gaml.VariableRef;
import msi.gama.lang.gaml.resource.GamlResourceServices;
import msi.gama.lang.gaml.ui.editor.GamlHyperlinkDetector;
import msi.gama.runtime.GAMA;
import msi.gama.util.file.IGamaFileMetaData;
import msi.gaml.compilation.GAML;
import msi.gaml.descriptions.FacetProto;
import msi.gaml.descriptions.SymbolProto;
import msi.gaml.expressions.units.UnitConstantExpression;
import msi.gaml.factories.DescriptionFactory;
import msi.gaml.operators.Strings;

/**
 * The Class GamlDocumentationProvider.
 */
public class GamlDocumentationProvider extends MultiLineCommentDocumentationProvider {

	/** The detector. */
	@Inject protected GamlHyperlinkDetector detector;

	/**
	 * Gets the only comment.
	 *
	 * @param o
	 *            the o
	 * @return the only comment
	 */
	public String getOnlyComment(final EObject o) {
		return super.getDocumentation(o);
	}

	@Override
	public String getDocumentation(final EObject o) {
		if (o instanceof Import) return "ctrl-click or cmd-click on the path to open this model in a new editor";
		if (o instanceof S_Global) return getDocumentation(o.eContainer().eContainer());
		if (o instanceof StringLiteral) {
			final URI iu = detector.getURI((StringLiteral) o);
			if (iu != null) {
				if (FileUtils.isFileExistingInWorkspace(iu)) {
					final IFile file = FileUtils.getWorkspaceFile(iu);
					final IGamaFileMetaData data = GAMA.getGui().getMetaDataProvider().getMetaData(file, false, true);
					if (data == null) {
						final String ext = file.getFileExtension();
						return "This workspace " + ext + " file has no metadata associated with it";
					}
					String s = data.getDocumentation();
					if (s != null) return s.replace(Strings.LN, "<br/>");
				} else { // absolute file
					final IFile file =
							FileUtils.createLinkToExternalFile(((StringLiteral) o).getOp(), o.eResource().getURI());
					if (file == null) return "This file is outside the workspace and cannot be found.";
					final IGamaFileMetaData data = GAMA.getGui().getMetaDataProvider().getMetaData(file, false, true);
					if (data == null) {
						final String ext = file.getFileExtension();
						return "This external " + ext + " file has no metadata associated with it";
					}
					String s = data.getDocumentation();
					if (s != null) return s.replace(Strings.LN, "<br/>");
				}
			}
		}

		String comment = super.getDocumentation(o);
		if (o instanceof VariableRef) {
			comment = super.getDocumentation(((VariableRef) o).getRef());
		} else if (o instanceof ActionRef) { comment = super.getDocumentation(((ActionRef) o).getRef()); }
		if (comment == null) {
			comment = "";
		} else {
			comment += "<br/>";
		}
		if (o instanceof TypeRef) {
			final Statement s = EGaml.getInstance().getStatement(o);
			if (s instanceof S_Definition && ((S_Definition) s).getTkey() == o) {
				final IDocManager dm = GamlResourceServices.getResourceDocumenter();
				final IGamlDescription gd = dm.getGamlDocumentation(s);
				if (gd != null) return gd.getDocumentation().get();
			}
		} else if (o instanceof Function f) {
			if (f.getLeft() instanceof ActionRef) {
				final ActionRef ref = (ActionRef) f.getLeft();
				final String temp = getDocumentation(ref.getRef());
				if (temp != null && !temp.contains("No documentation")) return temp;
			}
		} else if (o instanceof UnitName) {
			final String name = ((UnitName) o).getRef().getName();
			final UnitConstantExpression exp = GAML.UNITS.get(name);
			if (exp != null) return exp.getDocumentation().get();
		}

		IGamlDescription description = GamlResourceServices.getResourceDocumenter().getGamlDocumentation(o);

		if (description == null) {
			if (o instanceof VariableRef) {
				// Case of do xxx;
				// if (o.eContainer() instanceof S_Do && ((S_Do) o.eContainer()).getExpr() == o) {
				VarDefinition vd = ((VariableRef) o).getRef();
				description = GamlResourceServices.getResourceDocumenter().getGamlDocumentation(vd);
				if (description != null) {
					String result = description.getDocumentation().get();
					if (result == null) return "";
					return result;
				}
			}
			// }
			// final VarDefinition vd = ((VariableRef) o).getRef();
			// if (vd != null && vd.eContainer() == null) {
			// final IEObjectDescription desc = scopeProvider.getVar(vd.getName());
			// if (desc != null) {
			// String userData = desc.getUserData("doc");
			// if (userData != null && !userData.isEmpty()) return userData;
			// }
			// }
			// } else
			if (o instanceof Facet) {
				String facetName = ((Facet) o).getKey();
				facetName = facetName.substring(0, facetName.length() - 1);
				final EObject cont = o.eContainer();
				final String key = EGaml.getInstance().getKeyOf(cont);
				final SymbolProto p = DescriptionFactory.getProto(key, null);
				if (p != null) {
					final FacetProto f = p.getPossibleFacets().get(facetName);
					if (f != null) return comment + Strings.LN + f.getDocumentation();
				}
				return comment;
			}
			if (comment.isEmpty()) return null;
			return comment + Strings.LN + "No documentation.";
		}

		return comment + description.getDocumentation();
	}

}