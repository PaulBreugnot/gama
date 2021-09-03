/*******************************************************************************************************
 *
 * FactoryProcessor.java, in gama.build.processor, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.build.processor;

import java.util.Collection;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import gama.core.dev.annotations.GamlAnnotations.factory;

/**
 * The Class FactoryProcessor.
 */
public class FactoryProcessor extends ElementProcessor<factory> {

	@Override
	protected Class<factory> getAnnotationClass() {
		return factory.class;
	}

	@Override
	public void createElement(final StringBuilder sb, final ProcessorContext context, final Element e,
			final factory factory) {
		sb.append("new ").append(rawNameOf(context, e.asType())).append("(I(");
		for (final int i : factory.handles()) {
			sb.append(i).append(',');
		}
		sb.setLength(sb.length() - 1);
		sb.append(")),");
	}

	@Override
	public void serialize(final ProcessorContext context, final Collection<StringBuilder> elements,
			final StringBuilder sb) {
		sb.append("_factories(");
		super.serialize(context, elements, sb);
		sb.setLength(sb.length() - 1);
		sb.append(");");
	}

	@Override
	protected boolean validateElement(final ProcessorContext context, final Element e) {
		return assertClassExtends(context, true, (TypeElement) e, context.getType("gaml.factories.SymbolFactory"));
	}
}
