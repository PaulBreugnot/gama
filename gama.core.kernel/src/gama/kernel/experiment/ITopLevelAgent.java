/*******************************************************************************************************
 *
 * msi.gama.kernel.experiment.ITopLevelAgent.java, in plugin msi.gama.core, is part of the source code of the GAMA
 * modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.kernel.experiment;

import gama.common.interfaces.IScopedStepable;
import gama.common.util.RandomUtils;
import gama.kernel.simulation.SimulationAgent;
import gama.kernel.simulation.SimulationClock;
import gama.metamodel.agent.IMacroAgent;
import gama.outputs.IOutputManager;
import gama.util.GamaColor;
import gaml.statements.IExecutable;

/**
 * Class ITopLevelAgent Addition (Aug 2021): explicit inheritance of IScopedStepable
 *
 * @author drogoul
 * @since 27 janv. 2016
 *
 */
public interface ITopLevelAgent extends IMacroAgent, IScopedStepable {

	SimulationClock getClock();

	GamaColor getColor();

	RandomUtils getRandomGenerator();

	IOutputManager getOutputManager();

	void postEndAction(IExecutable executable);

	void postDisposeAction(IExecutable executable);

	void postOneShotAction(IExecutable executable);

	void executeAction(IExecutable executable);

	boolean isOnUserHold();

	void setOnUserHold(boolean state);

	SimulationAgent getSimulation();

	IExperimentAgent getExperiment();

}
