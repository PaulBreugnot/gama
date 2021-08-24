/*******************************************************************************************************
 *
 * MoleExperiment.java, in gama.core.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.headless.openmole;



import gama.core.headless.core.Experiment;
import gama.kernel.model.IModel;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.expressions.IExpression;
import gaml.expressions.IExpressionFactory;
import gaml.types.Types;

/**
 * The Class MoleExperiment.
 */
public class MoleExperiment extends Experiment implements IMoleExperiment {
	
	/**
	 * Instantiates a new mole experiment.
	 *
	 * @param mdl the mdl
	 */
	MoleExperiment(final IModel mdl) {
		super(mdl);
	}

	@Override
	public void play(int finalStep) {
		while(finalStep<this.step());
	}

	/**
	 * Play.
	 *
	 * @param finalCondition the final condition
	 */
	public void play(String finalCondition) {
		play(finalCondition,-1);
	}

	@Override
	public void play(String exp, int finalStep) {
			IExpression endCondition = this.compileExpression(exp);
			if(exp==null ||"".equals(exp)) {
				endCondition = IExpressionFactory.FALSE_EXPR;
			} else {
				endCondition =this.compileExpression(exp);			
			}
			if(endCondition.getGamlType() != Types.BOOL) {
				throw GamaRuntimeException.error("The until condition of the experiment should be a boolean", this.getSimulation().getScope());
			}
			long step = 0;
			while( ! Types.BOOL.cast(this.getSimulation().getScope(), this.evaluateExpression(endCondition), null, false).booleanValue()
					 && ((finalStep >= 0) ? (step < finalStep) : true)) {
				step = this.step();
			}
	}
		
}
