/*******************************************************************************************************
 *
 * ModelFactory.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.factories;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.factory;
import gaml.compilation.IAgentConstructor;
import gaml.compilation.ast.ISyntacticElement;
import gaml.descriptions.IDescription;
import gaml.descriptions.ModelDescription;
import gaml.descriptions.SpeciesDescription;
import gaml.descriptions.SymbolProto;
import gaml.descriptions.ValidationContext;
import gaml.statements.Facets;

/**
 * Written by drogoul Modified on 27 oct. 2009
 *
 * @todo Description
 */
@factory (
		handles = { ISymbolKind.MODEL })
public class ModelFactory extends SymbolFactory {

	/** The assembler. */
	final ModelAssembler assembler = new ModelAssembler();

	/**
	 * Instantiates a new model factory.
	 *
	 * @param handles the handles
	 */
	public ModelFactory(final int... handles) {
		super(handles);
	}

	/**
	 * Creates a new Model object.
	 *
	 * @param projectPath the project path
	 * @param modelPath the model path
	 * @param models the models
	 * @param collector the collector
	 * @param document the document
	 * @param mm the mm
	 * @return the model description
	 */
	public ModelDescription createModelDescription(final String projectPath, final String modelPath,
			final Iterable<ISyntacticElement> models, final ValidationContext collector, final boolean document,
			final Map<String, ModelDescription> mm) {
		return assembler.assemble(projectPath, modelPath, models, collector, document, mm);
	}

	/**
	 * Creates a new Model object.
	 *
	 * @param name the name
	 * @param clazz the clazz
	 * @param macro the macro
	 * @param parent the parent
	 * @param helper the helper
	 * @param skills the skills
	 * @param plugin the plugin
	 * @return the model description
	 */
	@SuppressWarnings ("rawtypes")
	public static ModelDescription createRootModel(final String name, final Class clazz, final SpeciesDescription macro,
			final SpeciesDescription parent, final IAgentConstructor helper, final Set<String> skills,
			final String plugin) {
		if (name.equals(IKeyword.MODEL)) {
			ModelDescription.ROOT = new ModelDescription(name, clazz, "", "", null, macro, parent, null, null,
					ValidationContext.NULL, Collections.EMPTY_SET, helper);
			return ModelDescription.ROOT;
		} else {
			// we are with a built-in model species
			// for the moment we suppose its parent is the root (macro)
			ModelDescription model = new ModelDescription(name, clazz, "", "", null, null, ModelDescription.ROOT, null,
					null, ValidationContext.NULL, Collections.EMPTY_SET, helper, skills);
			ModelDescription.BUILT_IN_MODELS.put(name, model);
			return model;
		}

	}

	@Override
	protected IDescription buildDescription(final String keyword, final Facets facets, final EObject element,
			final Iterable<IDescription> children, final IDescription enclosing, final SymbolProto proto) {
		// This method is actually never called.
		return null;
	}

}
