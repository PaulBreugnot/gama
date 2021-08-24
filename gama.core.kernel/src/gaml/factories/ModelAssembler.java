/*******************************************************************************************************
 *
 * ModelAssembler.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.factories;

import static gama.common.interfaces.IKeyword.FREQUENCY;
import static gama.common.interfaces.IKeyword.GLOBAL;
import static gama.common.interfaces.IKeyword.NAME;
import static gama.common.interfaces.IKeyword.PARENT;
import static gama.common.interfaces.IKeyword.SCHEDULES;
import static gama.common.interfaces.IKeyword.SPECIES;
import static gaml.descriptions.ModelDescription.BUILT_IN_MODELS;
import static gaml.descriptions.ModelDescription.ROOT;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.jgrapht.graph.DirectedAcyclicGraph;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

import gama.common.interfaces.IGamlIssue;
import gama.common.interfaces.IKeyword;
import gama.util.GamaMapFactory;
import gama.util.IMap;
import gaml.compilation.GamlCompilationError;
import gaml.compilation.ast.ISyntacticElement;
import gaml.compilation.ast.SyntacticFactory;
import gaml.compilation.ast.SyntacticModelElement;
import gaml.compilation.ast.ISyntacticElement.SyntacticVisitor;
import gaml.descriptions.ExperimentDescription;
import gaml.descriptions.IDescription;
import gaml.descriptions.ModelDescription;
import gaml.descriptions.SpeciesDescription;
import gaml.descriptions.SymbolDescription;
import gaml.descriptions.TypeDescription;
import gaml.descriptions.ValidationContext;
import gaml.descriptions.IDescription.DescriptionVisitor;
import gaml.statements.Facets;
import gaml.types.Types;

/**
 * Class ModelAssembler.
 *
 * @author drogoul
 * @since 15 avr. 2014
 *
 */
@SuppressWarnings ({ "unchecked", "rawtypes" })
public class ModelAssembler {

	/**
	 * Assemble.
	 *
	 * @param projectPath the project path
	 * @param modelPath the model path
	 * @param allModels the all models
	 * @param collector the collector
	 * @param document the document
	 * @param mm the mm
	 * @return the model description
	 */
	public ModelDescription assemble(final String projectPath, final String modelPath,
			final Iterable<ISyntacticElement> allModels, final ValidationContext collector, final boolean document,
			final Map<String, ModelDescription> mm) {
		final ImmutableList<ISyntacticElement> models = ImmutableList.copyOf(allModels);
		final IMap<String, ISyntacticElement> speciesNodes = GamaMapFactory.create();
		final IMap<String, IMap<String, ISyntacticElement>>[] experimentNodes = new IMap[1];
		final ISyntacticElement globalNodes = SyntacticFactory.create(GLOBAL, (EObject) null, true);
		final ISyntacticElement source = models.get(0);
		Facets globalFacets = null;
		if (source.hasFacet(IKeyword.PRAGMA)) {
			final Facets facets = source.copyFacets(null);
			final List<String> pragmas = (List<String>) facets.get(IKeyword.PRAGMA).getExpression().getConstValue();
			collector.resetInfoAndWarning();
			if (pragmas != null) {
				if (pragmas.contains(IKeyword.NO_INFO)) { collector.setNoInfo(); }
				if (pragmas.contains(IKeyword.NO_WARNING)) { collector.setNoWarning(); }
				if (pragmas.contains(IKeyword.NO_EXPERIMENT)) { collector.setNoExperiment(); }
			}

		}
		final Map<String, SpeciesDescription> tempSpeciesCache = GamaMapFactory.createUnordered();

		for (final ISyntacticElement cm : models.reverse()) {
			final SyntacticModelElement currentModel = (SyntacticModelElement) cm;
			if (currentModel != null) {
				if (currentModel.hasFacets()) {
					if (globalFacets == null) {
						globalFacets = currentModel.copyFacets(null);
					} else {
						globalFacets.putAll(currentModel.copyFacets(null));
					}
				}
				currentModel.visitChildren(element -> globalNodes.addChild(element));
				SyntacticVisitor visitor = element -> addSpeciesNode(element, speciesNodes, collector);
				currentModel.visitSpecies(visitor);

				// We input the species so that grids are always the last ones
				// (see DiffusionStatement)
				currentModel.visitGrids(visitor);
				visitor = element -> {
					if (experimentNodes[0] == null) { experimentNodes[0] = GamaMapFactory.create(); }
					addExperimentNode(element, currentModel.getName(), experimentNodes[0], collector);

				};
				currentModel.visitExperiments(visitor);

			}
		}

		final String modelName = buildModelName(source.getName());

		// We build a list of working paths from which the composite model will
		// be able to look for resources. These working paths come from the
		// imported models

		Set<String> absoluteAlternatePathAsStrings = models.isEmpty() ? null : ImmutableSet
				.copyOf(Iterables.transform(models.reverse(), each -> ((SyntacticModelElement) each).getPath()));

		if (mm != null) {
			for (final ModelDescription m1 : mm.values()) {
				for (final String im : m1.getAlternatePaths()) {
					absoluteAlternatePathAsStrings =
							Sets.union(absoluteAlternatePathAsStrings, Collections.singleton(im));
				}
			}
		}

		ModelDescription parent = ROOT;
		if (globalFacets != null && globalFacets.containsKey(PARENT)) {
			String parentModel = globalFacets.getLabel(PARENT);
			if (BUILT_IN_MODELS.containsKey(parentModel)) { parent = BUILT_IN_MODELS.get(parentModel); }
		}
		final ModelDescription model =
				new ModelDescription(modelName, null, projectPath, modelPath, source.getElement(), null, parent, null,
						globalFacets, collector, absoluteAlternatePathAsStrings, parent.getAgentConstructor());

		final Collection<String> allModelNames = models.size() == 1 ? null : ImmutableSet
				.copyOf(Iterables.transform(Iterables.skip(models, 1), each -> buildModelName(each.getName())));
		model.setImportedModelNames(allModelNames);
		model.isDocumenting(document);

		// hqnghi add micro-models
		if (mm != null) {
			// model.setMicroModels(mm);
			model.addChildren(mm.values());
		}
		// end-hqnghi
		// recursively add user-defined species to world and down on to the
		// hierarchy
		speciesNodes.forEachValue(speciesNode -> {
			addMicroSpecies(model, speciesNode, tempSpeciesCache);
			return true;
		});
		if (experimentNodes[0] != null) {
			experimentNodes[0].forEachPair((s, b) -> {
				b.forEachValue(experimentNode -> {
					addExperiment(s, model, experimentNode, tempSpeciesCache);
					return true;
				});
				return true;
			});
		}

		// Parent the species and the experiments of the model (all are now
		// known).
		speciesNodes.forEachValue(speciesNode -> {
			parentSpecies(model, speciesNode, model, tempSpeciesCache);
			return true;
		});

		if (experimentNodes[0] != null) {
			experimentNodes[0].forEachPair((s, b) -> {
				b.forEachValue(experimentNode -> {
					parentExperiment(model, experimentNode);
					return true;
				});
				return true;
			});
		}

		// Initialize the hierarchy of types
		model.buildTypes();
		// hqnghi build micro-models as types
		if (mm != null) {
			mm.forEach((k, v) -> model.getTypesManager().alias(v.getName(), k));
			// end-hqnghi
		}

		// Make species and experiments recursively create their attributes,
		// actions....
		complementSpecies(model, globalNodes);

		speciesNodes.forEachValue(speciesNode -> {
			complementSpecies(model.getMicroSpecies(speciesNode.getName()), speciesNode);
			return true;
		});

		if (experimentNodes[0] != null) {
			experimentNodes[0].forEachPair((s, b) -> {
				b.forEachValue(experimentNode -> {
					complementSpecies(model.getExperiment(experimentNode.getName()), experimentNode);
					return true;
				});
				return true;
			});
		}

		// Complement recursively the different species (incl. the world). The
		// recursion is hierarchical

		model.inheritFromParent();

		for (final SpeciesDescription sd : getSpeciesInHierarchicalOrder(model)) {
			sd.inheritFromParent();
			if (sd.isExperiment() && !sd.finalizeDescription()) return null;
		}

		// Issue #1708 (put before the finalization)
		if (model.hasFacet(SCHEDULES) || model.hasFacet(FREQUENCY)) { createSchedulerSpecies(model); }

		if (!model.finalizeDescription()) return null;

		if (document) { collector.document(model); }
		return model;

	}

	/**
	 * Gets the species in hierarchical order.
	 *
	 * @param model the model
	 * @return the species in hierarchical order
	 */
	private Iterable<SpeciesDescription> getSpeciesInHierarchicalOrder(final ModelDescription model) {
		final DirectedAcyclicGraph<SpeciesDescription, Object> hierarchy = new DirectedAcyclicGraph<>(Object.class);
		final DescriptionVisitor<SpeciesDescription> visitor = desc -> {
			if (desc instanceof ModelDescription) return true;
			final SpeciesDescription sd = desc.getParent();
			if (sd == null || sd == desc) return false;
			hierarchy.addVertex(desc);
			if (!sd.isBuiltIn()) {
				hierarchy.addVertex(sd);
				try {
					hierarchy.addEdge(sd, desc);
				} catch (IllegalArgumentException e) {
					// denotes the presence of a cycle in the hierarchy
					desc.error("The hierarchy of " + desc.getName() + " is inconsistent.", IGamlIssue.WRONG_PARENT);
					return false;
				}
			}
			return true;
		};
		model.visitAllSpecies(visitor);
		return () -> hierarchy.iterator();
	}

	/**
	 * Creates the scheduler species.
	 *
	 * @param model the model
	 */
	private void createSchedulerSpecies(final ModelDescription model) {
		final SpeciesDescription sd =
				(SpeciesDescription) DescriptionFactory.create(SPECIES, model, NAME, "_internal_global_scheduler");
		sd.finalizeDescription();
		if (model.hasFacet(SCHEDULES)) {
			// remove the warning as GAMA integrates a working workaround to use this facet at the global level
			// model.warning(
			// "'schedules' is deprecated in global. Define a dedicated species instead and add the facet to it",
			// IGamlIssue.DEPRECATED, NAME);
			sd.setFacet(SCHEDULES, model.getFacet(SCHEDULES));
			model.removeFacets(SCHEDULES);
		}
		if (model.hasFacet(FREQUENCY)) {
			model.warning(
					"'frequency' is deprecated in global. Define a dedicated species instead and add the facet to it",
					IGamlIssue.DEPRECATED, NAME);
			sd.setFacet(FREQUENCY, model.getFacet(FREQUENCY));
			model.removeFacets(FREQUENCY);
		}
		model.addChild(sd);
	}

	/**
	 * Adds the experiment.
	 *
	 * @param origin the origin
	 * @param model the model
	 * @param experiment the experiment
	 * @param cache the cache
	 */
	void addExperiment(final String origin, final ModelDescription model, final ISyntacticElement experiment,
			final Map<String, SpeciesDescription> cache) {
		// Create the experiment description
		final IDescription desc = DescriptionFactory.create(experiment, model, Collections.EMPTY_LIST);
		final ExperimentDescription eDesc = (ExperimentDescription) desc;
		cache.put(eDesc.getName(), eDesc);
		((SymbolDescription) desc).resetOriginName();
		desc.setOriginName(buildModelName(origin));
		model.addChild(desc);
	}

	/**
	 * Adds the experiment node.
	 *
	 * @param element the element
	 * @param modelName the model name
	 * @param experimentNodes the experiment nodes
	 * @param collector the collector
	 */
	void addExperimentNode(final ISyntacticElement element, final String modelName,
			final Map<String, IMap<String, ISyntacticElement>> experimentNodes, final ValidationContext collector) {
		// First we verify that this experiment has not been declared previously
		final String experimentName = element.getName();
		for (final String otherModel : experimentNodes.keySet()) {
			if (!otherModel.equals(modelName)) {
				final Map<String, ISyntacticElement> otherExperiments = experimentNodes.get(otherModel);
				if (otherExperiments.containsKey(experimentName)) {
					collector.add(new GamlCompilationError(
							"Experiment " + experimentName + " supersedes the one declared in " + otherModel,
							IGamlIssue.DUPLICATE_DEFINITION, element.getElement(), false, true));
					// We remove the old one
					otherExperiments.remove(experimentName);
				}
			}
		}

		if (!experimentNodes.containsKey(modelName)) { experimentNodes.put(modelName, GamaMapFactory.create()); }
		final Map<String, ISyntacticElement> nodes = experimentNodes.get(modelName);
		if (nodes.containsKey(experimentName)) {
			collector.add(new GamlCompilationError("Experiment " + element.getName() + " is declared twice",
					IGamlIssue.DUPLICATE_DEFINITION, element.getElement(), false, false));
		}
		nodes.put(experimentName, element);
	}

	/**
	 * Adds the micro species.
	 *
	 * @param macro the macro
	 * @param micro the micro
	 * @param cache the cache
	 */
	void addMicroSpecies(final SpeciesDescription macro, final ISyntacticElement micro,
			final Map<String, SpeciesDescription> cache) {
		// Create the species description without any children. Passing
		// explicitly an empty list and not null;
		final SpeciesDescription mDesc =
				(SpeciesDescription) DescriptionFactory.create(micro, macro, Collections.EMPTY_LIST);
		cache.put(mDesc.getName(), mDesc);
		// Add it to its macro-species
		macro.addChild(mDesc);
		// Recursively create each micro-species of the newly added
		// micro-species
		final SyntacticVisitor visitor = element -> addMicroSpecies(mDesc, element, cache);
		micro.visitSpecies(visitor);
		micro.visitExperiments(visitor);
	}

	/**
	 * Adds the species node.
	 *
	 * @param element the element
	 * @param speciesNodes the species nodes
	 * @param collector the collector
	 */
	void addSpeciesNode(final ISyntacticElement element, final Map<String, ISyntacticElement> speciesNodes,
			final ValidationContext collector) {
		final String name = element.getName();
		if (speciesNodes.containsKey(name)) {
			collector.add(new GamlCompilationError("Species " + name + " is declared twice",
					IGamlIssue.DUPLICATE_DEFINITION, element.getElement(), false, false));
			collector.add(new GamlCompilationError("Species " + name + " is declared twice",
					IGamlIssue.DUPLICATE_DEFINITION, speciesNodes.get(name).getElement(), false, false));
		}
		speciesNodes.put(name, element);
	}

	/**
	 * Recursively complements a species and its micro-species. Add variables, behaviors (actions, reflex, task, states,
	 * ...), aspects to species.
	 *
	 * @param species the species
	 * @param node the node
	 */
	void complementSpecies(final SpeciesDescription species, final ISyntacticElement node) {
		if (species == null) return;
		species.copyJavaAdditions();
		node.visitChildren(element -> {
			final IDescription childDesc = DescriptionFactory.create(element, species, null);
			if (childDesc != null) { species.addChild(childDesc); }
		});
		// recursively complement micro-species
		node.visitSpecies(element -> {
			final SpeciesDescription sd = species.getMicroSpecies(element.getName());
			if (sd != null) { complementSpecies(sd, element); }
		});

	}

	/**
	 * Parent experiment.
	 *
	 * @param model the model
	 * @param micro the micro
	 */
	void parentExperiment(final ModelDescription model, final ISyntacticElement micro) {
		// Gather the previously created species
		final SpeciesDescription mDesc = model.getExperiment(micro.getName());
		if (mDesc == null) return;
		final String p = mDesc.getLitteral(IKeyword.PARENT);
		// If no parent is defined, we assume it is "experiment"
		// No cache needed for experiments ??
		SpeciesDescription parent = model.getExperiment(p);
		if (parent == null) { parent = Types.get(IKeyword.EXPERIMENT).getSpecies(); }
		mDesc.setParent(parent);
	}

	/**
	 * Parent species.
	 *
	 * @param macro the macro
	 * @param micro the micro
	 * @param model the model
	 * @param cache the cache
	 */
	void parentSpecies(final SpeciesDescription macro, final ISyntacticElement micro, final ModelDescription model,
			final Map<String, SpeciesDescription> cache) {
		// Gather the previously created species
		final SpeciesDescription mDesc = cache.get(micro.getName());
		if (mDesc == null || mDesc.isExperiment()) return;
		String p = mDesc.getLitteral(IKeyword.PARENT);
		// If no parent is defined, we assume it is "agent"
		if (p == null) { p = IKeyword.AGENT; }
		SpeciesDescription parent = lookupSpecies(p, cache);
		if (parent == null) { parent = model.getSpeciesDescription(p); }
		mDesc.setParent(parent);
		micro.visitSpecies(element -> parentSpecies(mDesc, element, model, cache));

	}

	/**
	 * Lookup first in the cache passed in argument, then in the built-in species.
	 *
	 * @param name the name
	 * @param cache the cache
	 * @return the species description
	 */
	SpeciesDescription lookupSpecies(final String name, final Map<String, SpeciesDescription> cache) {
		SpeciesDescription result = cache.get(name);
		if (result == null) {
			for (final TypeDescription td : Types.getBuiltInSpecies()) {
				if (td.getName().equals(name)) {
					result = (SpeciesDescription) td;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Builds the model name.
	 *
	 * @param source the source
	 * @return the string
	 */
	protected String buildModelName(final String source) {
		return source.replace(' ', '_') + ModelDescription.MODEL_SUFFIX;
	}

}
