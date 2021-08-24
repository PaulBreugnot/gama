/*******************************************************************************************************
 *
 * TestExperimentSummary.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.statements.test;

import gama.kernel.experiment.TestAgent;
import gaml.operators.Strings;

/**
 * A summary of a whole test experiment.
 *
 * @author drogoul
 */
public class TestExperimentSummary extends CompoundSummary<IndividualTestSummary, TestAgent> {

	/**
	 * Instantiates a new test experiment summary.
	 *
	 * @param testAgent the test agent
	 */
	public TestExperimentSummary(final TestAgent testAgent) {
		super(testAgent);
	}

	@Override
	protected void printFooter(final StringBuilder sb) {
		sb.append(Strings.LN);
		sb.append("----------------------------------------------------------------");
	}

	@Override
	protected void printHeader(final StringBuilder sb) {
		sb.append("----------------------------------------------------------------");
		sb.append(Strings.LN);
	}
}
