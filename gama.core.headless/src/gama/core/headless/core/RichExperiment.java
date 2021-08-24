/*******************************************************************************************************
 *
 * RichExperiment.java, in gama.core.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.headless.core;

import gama.core.headless.common.DataType;
import gama.core.headless.common.DataTypeFactory;
import gama.core.headless.job.ListenedVariable;
import gama.core.headless.job.ExperimentJob.OutputType;
import gama.kernel.model.IModel;
import gama.kernel.simulation.SimulationAgent;
import gama.outputs.AbstractOutputManager;
import gama.outputs.FileOutput;
import gama.outputs.IOutput;
import gama.outputs.LayeredDisplayOutput;
import gama.outputs.MonitorOutput;
import gama.runtime.exceptions.GamaRuntimeException;

/**
 * The Class RichExperiment.
 */
public class RichExperiment extends Experiment implements IRichExperiment {
	
	/**
	 * Instantiates a new rich experiment.
	 *
	 * @param mdl the mdl
	 */
	public RichExperiment(final IModel mdl) {
		super(mdl);
	}

	@Override
	public OutputType getTypeOf(final String name) {
		if (currentExperiment == null) return OutputType.OUTPUT;
		if (currentExperiment.hasVar(name)) return OutputType.EXPERIMENT_ATTRIBUTE;
		if (currentExperiment.getModel().getSpecies().hasVar(name)) return OutputType.SIMULATION_ATTRIBUTE;
		return OutputType.OUTPUT;
	}

	@Override
	public RichOutput getRichOutput(final ListenedVariable v) {
		final String parameterName = v.getName();
		SimulationAgent currentSimulation = getSimulation();
		if (currentSimulation == null || currentSimulation.dead()) return null;
		final IOutput output =
				((AbstractOutputManager) currentSimulation.getOutputManager()).getOutputWithOriginalName(parameterName);
		if (output == null)
			throw GamaRuntimeException.error("Output unresolved", currentExperiment.getExperimentScope());
		output.update();

		Object val = null;
		DataType tpe = null;

		if (output instanceof MonitorOutput) {
			val = ((MonitorOutput) output).getLastValue();
			tpe = DataTypeFactory.getObjectMetaData(val);
		} else if (output instanceof LayeredDisplayOutput) {
			val = ((LayeredDisplayOutput) output).getImage(v.width, v.height);
			tpe = DataType.DISPLAY2D;
		} else if (output instanceof FileOutput) {
			val = ((FileOutput) output).getFile();
			tpe = DataType.DISPLAY2D;
		}
		return new RichOutput(parameterName, this.currentStep, val, tpe);
	}

}
