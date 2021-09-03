/*******************************************************************************************************
 *
 * DisplayProcessor.java, in gama.build.processor, is part of the source code of the
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

import gama.core.dev.annotations.GamlAnnotations.display;

/**
 * The Class DisplayProcessor.
 */
public class DisplayProcessor extends ElementProcessor<display> {

	@Override
	protected Class<display> getAnnotationClass() {
		return display.class;
	}

	@Override
	public void createElement(final StringBuilder sb, final ProcessorContext context, final Element e,
			final display d) {
		verifyDoc(context, e, "display " + d.value(), d);
		sb.append(in).append("_display(").append(toJavaString(d.value())).append(",(a)->new ")
				.append(rawNameOf(context, e.asType())).append("(a));");
	}

	@Override
	protected boolean validateElement(final ProcessorContext context, final Element e) {
		return assertClassExtends(context, true, (TypeElement) e, context.getType("gama.common.ui.IDisplaySurface"));
	}
}
