/*******************************************************************************************************
 *
 * ExperimentProcessor.java, in gama.build.processor, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.build.processor;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import gama.core.dev.annotations.GamlAnnotations.experiment;

/**
 * The Class ExperimentProcessor.
 */
public class ExperimentProcessor extends ElementProcessor<experiment> {

	@Override
	protected Class<experiment> getAnnotationClass() {
		return experiment.class;
	}

	@Override
	public void createElement(final StringBuilder sb, final ProcessorContext context, final Element e,
			final experiment exp) {
		verifyDoc(context, e, "experiment " + exp.value(), exp);
		sb.append(in).append("_experiment(").append(toJavaString(exp.value())).append(",(p, i)->new ")
				.append(rawNameOf(context, e.asType())).append("(p, i));");
	}

	@Override
	protected boolean validateElement(final ProcessorContext context, final Element e) {
		return assertClassExtends(context, true, (TypeElement) e,
				context.getType("gama.kernel.experiment.IExperimentAgent"));
	}
}
