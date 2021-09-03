/*******************************************************************************************************
 *
 * SpeciesProcessor.java, in gama.build.processor, is part of the source code of the
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

import gama.core.dev.annotations.GamlAnnotations.species;

/**
 * The Class SpeciesProcessor.
 */
public class SpeciesProcessor extends ElementProcessor<species> {

	@Override
	protected Class<species> getAnnotationClass() {
		return species.class;
	}

	@Override
	public void createElement(final StringBuilder sb, final ProcessorContext context, final Element e,
			final species spec) {
		final String clazz = rawNameOf(context, e.asType());
		verifyDoc(context, e, "species " + spec.name(), spec);
		sb.append(in).append("_species(").append(toJavaString(spec.name())).append(",").append(toClassObject(clazz))
				.append(",(p, i)->").append("new ").append(clazz).append("(p, i),");
		toArrayOfStrings(spec.skills(), sb).append(");");
	}

	@Override
	protected boolean validateElement(final ProcessorContext context, final Element e) {
		return assertClassExtends(context, true, (TypeElement) e, context.getType("gama.metamodel.agent.IAgent"));
	}

}
