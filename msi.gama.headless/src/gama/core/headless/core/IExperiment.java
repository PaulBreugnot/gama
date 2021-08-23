/*********************************************************************************************
 *
 *
 * 'IMoleExperiment.java', in plugin 'msi.gama.headless', is part of the source code of the GAMA modeling and simulation
 * platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.core.headless.core;

import gama.kernel.model.IModel;
import gama.kernel.simulation.SimulationAgent;
import gaml.expressions.IExpression;

public interface IExperiment {
	IModel getModel();

	SimulationAgent getSimulation();

	void setup(final String experimentName);

	void setup(final String experimentName, final double seed);

	long step();

	boolean isInterrupted();

	void setParameter(final String parameterName, final Object value);

	IExpression compileExpression(final String expression);

	Object evaluateExpression(IExpression exp);

	Object evaluateExpression(String exp);

	void dispose();

}
