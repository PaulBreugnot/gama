/*********************************************************************************************
 *
 * 'IModelRunner.java, in plugin gama.ui.base, is part of the source code of the GAMA modeling and simulation
 * platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 * 
 *
 **********************************************************************************************/
package gama.ui.base.interfaces;

import java.util.List;

import gaml.statements.test.TestExperimentSummary;

public interface IModelRunner {

	void editModel(Object eObject);

	void runModel(Object object, String exp);

	List<TestExperimentSummary> runHeadlessTests(Object model);

}
