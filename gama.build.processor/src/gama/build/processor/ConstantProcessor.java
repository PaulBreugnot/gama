/*******************************************************************************************************
 *
 * ConstantProcessor.java, in gama.build.processor, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.build.processor;

import javax.lang.model.element.Element;

import gama.core.dev.annotations.GamlAnnotations.constant;

/**
 * The Class ConstantProcessor.
 */
public class ConstantProcessor extends ElementProcessor<constant> {

	@Override
	protected Class<constant> getAnnotationClass() {
		return constant.class;
	}

	@Override
	public void createElement(final StringBuilder sb, final ProcessorContext context, final Element e,
			final constant constant) {
		verifyDoc(context, e, "constant " + constant.value(), constant);
	}

	@Override
	public boolean outputToJava() {
		return false;
	}

}
