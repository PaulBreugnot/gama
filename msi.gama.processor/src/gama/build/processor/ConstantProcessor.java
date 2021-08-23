package gama.build.processor;

import javax.lang.model.element.Element;

import gama.core.dev.annotations.GamlAnnotations.constant;

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
