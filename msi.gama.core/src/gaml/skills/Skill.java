/*******************************************************************************************************
 *
 * msi.gaml.skills.Skill.java, in plugin msi.gama.core, is part of the source code of the GAMA modeling and simulation
 * platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.skills;

import gama.common.interfaces.ISkill;
import gama.metamodel.agent.IAgent;
import gama.metamodel.topology.ITopology;
import gama.runtime.IScope;
import gaml.descriptions.SkillDescription;

public class Skill implements ISkill {

	protected SkillDescription description;

	protected Skill() {}

	@Override
	public void setName(final String newName) {}

	public void setDescription(final SkillDescription desc) {
		description = desc;
	}

	@Override
	public String getDocumentation() {
		return description.getDocumentation();
	}

	@Override
	public SkillDescription getDescription() {
		return description;
	}

	@Override
	public String serialize(final boolean includingBuiltIn) {
		return getName();
	}

	protected IAgent getCurrentAgent(final IScope scope) {
		return scope.getAgent();
	}

	protected ITopology getTopology(final IAgent agent) {
		return agent.getTopology();
	}

	@Override
	public String getTitle() {
		return description.getTitle();
	}

	@Override
	public String getDefiningPlugin() {
		return description.getDefiningPlugin();
	}

	@Override
	public String getName() {
		return description.getName();
	}

}
