/*******************************************************************************************************
 *
 * msi.gaml.expressions.SkillConstantExpression.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.expressions.types;

import gama.common.interfaces.ISkill;
import gaml.compilation.kernel.GamaSkillRegistry;
import gaml.expressions.ConstantExpression;
import gaml.expressions.IExpression;
import gaml.types.IType;

public class SkillConstantExpression extends ConstantExpression {

	public SkillConstantExpression(final String val, final IType<ISkill> t) {
		super(GamaSkillRegistry.INSTANCE.getSkillInstanceFor(val), t);
	}

	/**
	 * @see gaml.expressions.IExpression#getDocumentation()
	 */
	@Override
	public String getDocumentation() {
		return ((ISkill) value).getDocumentation();
	}

	@Override
	public String getTitle() {
		return ((ISkill) value).getTitle();
	}

	@Override
	public String literalValue() {
		return ((ISkill) value).getName();
	}

	// @Override
	// public void collectMetaInformation(final GamlProperties meta) {
	// final ISkill skill = (ISkill) value;
	// meta.put(GamlProperties.PLUGINS, skill.getDefiningPlugin());
	// meta.put(skill instanceof IArchitecture ? GamlProperties.ARCHITECTURES : GamlProperties.SKILLS,
	// skill.getName());
	// }

}
