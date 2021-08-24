/*******************************************************************************************************
 *
 * IGamlAdditions.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compilation;

import java.util.Arrays;
import java.util.Collections;

import gama.common.interfaces.IKeyword;
import gama.kernel.experiment.ExperimentAgent;
import gama.kernel.root.PlatformAgent;
import gama.kernel.simulation.SimulationAgent;
import gama.metamodel.agent.GamlAgent;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.GamaShape;
import gama.metamodel.shape.IShape;
import gama.metamodel.topology.ITopology;
import gama.runtime.IScope;
import gama.util.GamaColor;
import gama.util.GamaDate;
import gama.util.GamaPair;
import gama.util.IContainer;
import gama.util.IList;
import gama.util.IMap;
import gama.util.file.IGamaFile;
import gama.util.graph.IGraph;
import gama.util.matrix.IMatrix;
import gama.util.path.IPath;
import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;
import gaml.operators.DeprecatedOperators;
import gaml.skills.GridSkill;
import gaml.skills.MovingSkill;
import gaml.species.ISpecies;

/**
 * The Interface IGamlAdditions.
 */
public interface IGamlAdditions {

	/**
	 * The Class Children.
	 */
	public static class Children {

		/** The children. */
		private final Iterable<IDescription> children;

		/**
		 * Instantiates a new children.
		 *
		 * @param descs the descs
		 */
		public Children(final IDescription... descs) {
			if (descs == null || descs.length == 0) {
				children = Collections.emptyList();
			} else {
				children = Arrays.asList(descs);
			}
		}

		/**
		 * Gets the children.
		 *
		 * @return the children
		 */
		public Iterable<IDescription> getChildren() {
			return children;
		}

	}

	/** The ai. */
	int[] AI = new int[0];
	
	/** The as. */
	String[] AS = new String[0];
	
	/** The f. */
	boolean F = false;
	
	/** The t. */
	boolean T = true;
	
	/** The prim. */
	String PRIM = IKeyword.PRIMITIVE;
	
	/** The ia. */
	Class<?> IA = IAgent.class;
	
	/** The it. */
	Class<?> IT = ITopology.class;
	
	/** The sp. */
	Class<?> SP = ISpecies.class;
	
	/** The ga. */
	Class<?> GA = GamlAgent.class;
	
	/** The gc. */
	Class<?> GC = GamaColor.class;
	
	/** The gp. */
	Class<?> GP = GamaPair.class;
	
	/** The gs. */
	Class<?> GS = GamaShape.class;
	
	/** The o. */
	Class<?> O = Object.class;
	
	/** The b. */
	Class<?> B = Boolean.class;
	
	/** The i. */
	Class<?> I = Integer.class;
	
	/** The d. */
	Class<?> D = Double.class;
	
	/** The s. */
	Class<?> S = String.class;
	
	/** The ie. */
	Class<?> IE = IExpression.class;
	
	/** The is. */
	Class<?> IS = IShape.class;
	
	/** The gm. */
	Class<?> GM = IMap.class;
	
	/** The p. */
	// public final static Class<?> GL = GamaList.class;
	Class<?> P = GamaPoint.class;
	
	/** The ic. */
	Class<?> IC = IContainer.class;
	
	/** The il. */
	Class<?> IL = GamaPoint.class;
	
	/** The li. */
	Class<?> LI = IList.class;
	
	/** The im. */
	Class<?> IM = IMatrix.class;
	
	/** The gr. */
	Class<?> GR = IGraph.class;
	
	/** The ip. */
	Class<?> IP = IPath.class;
	
	/** The gf. */
	Class<?> GF = IGamaFile.class;
	
	/** The msk. */
	Class<?> MSK = MovingSkill.class;
	
	/** The gsk. */
	Class<?> GSK = GridSkill.class;
	
	/** The sc. */
	Class<?> SC = IScope.class;
	
	/** The gd. */
	Class<?> GD = GamaDate.class;
	
	/** The sa. */
	Class<?> SA = SimulationAgent.class;
	
	/** The ea. */
	Class<?> EA = ExperimentAgent.class;
	
	/** The do. */
	Class<?> DO = DeprecatedOperators.class;
	
	/** The pa. */
	Class<?> PA = PlatformAgent.class;
	
	/** The i. */
	Class<?> i = int.class;
	
	/** The d. */
	Class<?> d = double.class;
	
	/** The b. */
	Class<?> b = boolean.class;

	/**
	 * Initialize.
	 *
	 * @throws SecurityException the security exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	void initialize() throws SecurityException, NoSuchMethodException;

}
