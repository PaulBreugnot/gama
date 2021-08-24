/*******************************************************************************************************
 *
 * ExperimentBackwardAgent.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.experiment;

import com.thoughtworks.xstream.XStream;

import gama.common.interfaces.IKeyword;
import gama.common.util.RandomUtils;
import gama.core.dev.annotations.GamlAnnotations.experiment;
import gama.ext.serialize.factory.StreamConverter;
import gama.ext.serialize.gamaType.converters.ConverterScope;
import gama.ext.serialize.gaml.ReverseOperators;
import gama.kernel.experiment.ExperimentAgent;
import gama.kernel.experiment.ExperimentPlan;
import gama.kernel.simulation.SimulationAgent;
import gama.metamodel.agent.IAgent;
import gama.metamodel.agent.SavedAgent;
import gama.metamodel.population.IPopulation;
import gama.outputs.IOutputManager;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.tree.GamaNode;
import gama.util.tree.GamaTree;

/**
 * The Class ExperimentBackwardAgent.
 */
@experiment (IKeyword.MEMORIZE)
public class ExperimentBackwardAgent extends ExperimentAgent {

	/** The history tree. */
	GamaTree<String> historyTree;
	
	/** The current node. */
	GamaNode<String> currentNode;

	/**
	 * Instantiates a new experiment backward agent.
	 *
	 * @param s the s
	 * @param index the index
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public ExperimentBackwardAgent(final IPopulation<? extends IAgent> s, final int index) throws GamaRuntimeException {
		super(s, index);
		historyTree = new GamaTree<>();
	}

	/**
	 * Redefinition of the callback method
	 * 
	 * @see gama.metamodel.agent.GamlAgent#_init_(gama.runtime.IScope)
	 */
	@Override
	public Object _init_(final IScope scope) {
		super._init_(scope);
		// Save simulation state in the history
		final String state = ReverseOperators.serializeAgent(scope, this.getSimulation());

		historyTree.setRoot(state);
		currentNode = historyTree.getRoot();

		return this;
	}

	@Override
	public boolean step(final IScope scope) {
		// Do a normal step
		final boolean result = super.step(scope);

		// Save simulation state in the history
		final String state = ReverseOperators.serializeAgent(scope, this.getSimulation());

		currentNode = currentNode.addChild(state);

		// scope.getGui().getConsole(scope).informConsole("step RNG " + getSimulation().getRandomGenerator().getUsage(),
		// scope.getRoot(), new GamaColor(0, 0, 0));

		return result;
	}

	@Override
	public boolean backward(final IScope scope) {
		final boolean result = true;
		GamaNode<String> previousNode;

		try {
			if (canStepBack()) {
				previousNode = currentNode.getParent();
				final String previousState = previousNode.getData();

				if (previousState != null) {
					final ConverterScope cScope = new ConverterScope(scope);
					final XStream xstream = StreamConverter.loadAndBuild(cScope);

					// get the previous state
					final SavedAgent agt = (SavedAgent) xstream.fromXML(previousState);

					// Update of the simulation
					final SimulationAgent currentSimAgt = getSimulation();

					currentSimAgt.updateWith(scope, agt);

					// useful to recreate the random generator
					final int rngUsage = currentSimAgt.getRandomGenerator().getUsage();
					final String rngName = currentSimAgt.getRandomGenerator().getRngName();
					final Double rngSeed = currentSimAgt.getRandomGenerator().getSeed();

					final IOutputManager outputs = getSimulation().getOutputManager();
					if (outputs != null) {
						outputs.step(scope);
					}

					// Recreate the random generator and set it to the same state as the saved one
					if (((ExperimentPlan) this.getSpecies()).keepsSeed()) {
						currentSimAgt.setRandomGenerator(new RandomUtils(rngSeed, rngName));
						currentSimAgt.getRandomGenerator().setUsage(rngUsage);
					} else {
						currentSimAgt.setRandomGenerator(new RandomUtils(super.random.next(), rngName));
					}

					currentNode = currentNode.getParent();
				}
			}
		} finally {
			informStatus();

			// TODO a remettre
			// final int nbThreads =
			// this.getSimulationPopulation().getNumberOfActiveThreads();

			// if (!getSpecies().isBatch() && getSimulation() != null) {
			// scope.getGui().informStatus(
			// getSimulation().getClock().getInfo() + (nbThreads > 1 ? " (" +
			// nbThreads + " threads)" : ""));
			// }
		}
		return result;
	}

	@Override
	public boolean canStepBack() {

		final int current_cycle = getSimulation().getCycle(this.getScope());
		return (current_cycle > 0) ? true : false;
		// return currentNode != null && currentNode.getParent() != null;
	}

	@Override
	public boolean isMemorize() {
		return true;
	}
}
