/*
 *
 */
package gama.build.processor;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcessorConstants.
 */
public interface ProcessorConstants {

	/** The Constant ADDITIONS_PACKAGE_BASE. */
	String ADDITIONS_PACKAGE_BASE = "gaml.additions";

	/** The Constant ADDITIONS_CLASS_NAME. */
	String ADDITIONS_CLASS_NAME = "GamlAdditions";

	/** The i var and action support qn. */
	String I_VAR_AND_ACTION_SUPPORT_QN = "gama.common.interfaces.IVarAndActionSupport";

	/** The i agent qn. */
	String I_AGENT_QN = "gama.metamodel.agent.IAgent";

	/** The i scope qn. */
	String I_SCOPE_QN = "gama.runtime.IScope";

	/** The i skill qn. */
	String I_SKILL_QN = "gama.common.interfaces.ISkill";

	/** The string qn. */
	String STRING_QN = "java.lang.String";

	/** The imports. */
	Set<String> IMPORTS = Stream.of("gaml.extensions.multi_criteria", "gama.outputs.layers.charts",
			"gama.outputs.layers", "gama.outputs", "gama.kernel.batch", "gama.kernel.root",
			"gaml.architecture.weighted_tasks", "gaml.architecture.user", "gaml.architecture.reflex",
			"gaml.architecture.finite_state_machine", "gaml.species", "gama.metamodel.shape", "gaml.expressions",
			"gama.metamodel.topology", "gaml.statements.test", "gama.metamodel.population", "gama.kernel.simulation",
			"gama.kernel.model", "java.util", "gaml.statements.draw", " gama.metamodel.shape", "gama.common.interfaces",
			"gama.runtime", "java.lang", "gama.metamodel.agent", "gaml.types", "gaml.compilation", "gaml.factories",
			"gaml.descriptions", "gama.util.tree", "gama.util.file", "gama.util.matrix", "gama.util.graph",
			"gama.util.path", "gama.util", "gama.runtime.exceptions", "gaml.factories", "gaml.statements",
			"gaml.skills", "gaml.variables", "gama.kernel.experiment", "gaml.operators", "gama.common.interfaces",
			"gama.common.ui", "gaml.extensions.messaging", "gama.metamodel.population").map(s -> s + ".")
			.collect(Collectors.toSet());
}
