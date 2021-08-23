package gama.build.processor;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import gama.core.dev.annotations.GamlAnnotations.skill;

public class SkillProcessor extends ElementProcessor<skill> {

	@Override
	protected Class<skill> getAnnotationClass() {
		return skill.class;
	}

	@Override
	public void createElement(final StringBuilder sb, final ProcessorContext context, final Element e,
			final skill skill) {
		verifyDoc(context, e, "skill " + skill.name(), skill);
		sb.append(in).append("_skill(").append(toJavaString(skill.name())).append(',')
				.append(toClassObject(rawNameOf(context, e.asType()))).append(',');
		toArrayOfStrings(skill.attach_to(), sb).append(");");
	}

	@Override
	protected boolean validateElement(final ProcessorContext context, final Element e) {
		boolean result = assertClassExtends(context, true, (TypeElement) e, context.getISkill());
		return result;
	}

}
