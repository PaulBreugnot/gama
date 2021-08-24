/*******************************************************************************************************
 *
 * Operators.java, in gama.ext.pedestrian, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.pedestrian.operator;

import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.example;
import gama.core.dev.annotations.GamlAnnotations.no_test;
import gama.core.dev.annotations.GamlAnnotations.operator;
import gama.core.dev.annotations.GamlAnnotations.usage;
import gama.metamodel.shape.IShape;
import gama.runtime.IScope;
import gama.util.IContainer;
import gama.util.IList;

/**
 * The Class Operators.
 */
public class Operators {

	/**
	 * Generate network.
	 *
	 * @param scope the scope
	 * @param obst the obst
	 * @param bounds the bounds
	 * @param openArea the open area
	 * @param randomDist the random dist
	 * @param valDistForOpenArea the val dist for open area
	 * @param valDensityOpenArea the val density open area
	 * @param cleanNetwork the clean network
	 * @param toleranceClip the tolerance clip
	 * @param toleranceTriang the tolerance triang
	 * @param minDistPath the min dist path
	 * @param simplificationDist the simplification dist
	 * @param SizeSquares the size squares
	 * @return the i list
	 */
	@operator(value = "generate_pedestrian_network", category = { "Pedestrian" } , concept = { IConcept.NETWORK })
	@doc (
			value = "generateNetwork(obstacles (list of lists of geometries/agents), bounds (list of geometries/agents), add point to open areas (boolean),\n" + 
					" random densification (boolean; if true, use random points to fill open areas; if false, use uniform points), min distance to considered an area as open area (float), density of points in the open areas (float),\n" + 
			" clean network (boolean), tolerance for the cliping in triangulation (float; distance), tolerance for the triangulation (float), minimal distance to obstacles to keep a path (float; if 0.0, no filtering), "
			+ "simplification distance for the final geometries, size of squares for decomposition (optimization)",
			examples = { @example (
					value = "generate_pedestrian_network([wall], [world],true,false,3.0,0.1, true,0.1,0.0,0.0,0.0,50.0)",
					equals = "a list of polylines corresponding to the pedestrian paths",
					isExecutable = false) })
	@no_test
	public static IList<IShape> generateNetwork(IScope scope,  IList<IContainer<?, ? extends IShape>> obst, IContainer<?, ? extends IShape> bounds, Boolean openArea,
			boolean randomDist, double valDistForOpenArea, double valDensityOpenArea,
			Boolean cleanNetwork, double toleranceClip, double toleranceTriang, double minDistPath, double simplificationDist, double SizeSquares) {
		return PedestrianNetwork.generateNetwork(scope, obst, bounds, null, openArea, randomDist,valDistForOpenArea,
				valDensityOpenArea, cleanNetwork, toleranceClip, toleranceTriang, minDistPath, simplificationDist, SizeSquares);
	}

	/**
	 * Generate network.
	 *
	 * @param scope the scope
	 * @param obst the obst
	 * @param bounds the bounds
	 * @param openArea the open area
	 * @param randomDist the random dist
	 * @param valDistForOpenArea the val dist for open area
	 * @param valDensityOpenArea the val density open area
	 * @param cleanNetwork the clean network
	 * @param toleranceClip the tolerance clip
	 * @param toleranceTriang the tolerance triang
	 * @param minDistPath the min dist path
	 * @param simplificationDist the simplification dist
	 * @return the i list
	 */
	@operator(value = "generate_pedestrian_network", category = { "Pedestrian" } , concept = { IConcept.NETWORK })
	@doc (
			usages = { @usage (
					value = "generateNetwork("
							+ "obstacles (list of lists of geometries/agents), "
							+ "bounds (list of geometries/agents), "
							+ "add point to open areas (boolean), \n" 
							+ "random densification (boolean; if true, use random points to fill open areas; if false, use uniform points), "
							+ "min distance to considered an area as open area (float), "
							+ "density of points in the open areas (float), \n" 
							+ "clean network (boolean), "
							+ "tolerance for the cliping in triangulation (float; distance), "
							+ "tolerance for the triangulation (float), "
							+ "minimal distance to obstacles to keep a path (float; if 0.0, no filtering),"
							+ "simplification distance for the final geometries") },
			examples = { @example (
					value = "generate_pedestrian_network([wall], [world],true,false,3.0,0.1, true,0.1,0.0,0.0,0.0,0.0)",
					equals = "a list of polylines corresponding to the pedestrian paths",
					isExecutable = false) })
	@no_test
	public static IList<IShape> generateNetwork(IScope scope,  IList<IContainer<?, ? extends IShape>> obst, IContainer<?, ? extends IShape> bounds, Boolean openArea,
			boolean randomDist, double valDistForOpenArea, double valDensityOpenArea,
			Boolean cleanNetwork, double toleranceClip, double toleranceTriang, double minDistPath, double simplificationDist) {
		return PedestrianNetwork.generateNetwork(scope, obst, bounds, null, openArea, randomDist,valDistForOpenArea,
				valDensityOpenArea, cleanNetwork, toleranceClip, toleranceTriang, minDistPath, simplificationDist, 0);
	}

	/**
	 * Generate network.
	 *
	 * @param scope the scope
	 * @param obst the obst
	 * @param bounds the bounds
	 * @param regular_network the regular network
	 * @param openArea the open area
	 * @param randomDist the random dist
	 * @param valDistForOpenArea the val dist for open area
	 * @param valDensityOpenArea the val density open area
	 * @param cleanNetwork the clean network
	 * @param toleranceClip the tolerance clip
	 * @param toleranceTriang the tolerance triang
	 * @param minDistPath the min dist path
	 * @param simplificationDist the simplification dist
	 * @param sizeSquareOpti the size square opti
	 * @return the i list
	 */
	@operator(value = "generate_pedestrian_network", category = { "Pedestrian" } , concept = { IConcept.NETWORK })
	@doc (
			usages = { @usage (
					value = "generateNetwork("
							+ "obstacles (list of lists of geometries/agents), \n"
							+ "bounds (list of geometries/agents), \n"
							+ "the road network (list of line) to have simple pedestrian behavior (1D movement) outside of the bounds \n"
							+ "add point to open areas (boolean), \n"
							+ "random densification (boolean; if true, use random points to fill open areas; if false, use uniform points), \n"
							+ "min distance to considered an area as open area (float), \n"
							+ "density of points in the open areas (float), \n" 
							+ "clean network (boolean), tolerance for the cliping in triangulation (float; distance), tolerance for the triangulation (float), "
							+ "minimal distance to obstacles to keep a path (float; if 0.0, no filtering), "
							+ "simplification distance for the final geometries,"
							+ " size of squares for decomposition (optimization)") },
			examples = { @example (
					value = "generate_pedestrian_network([wall], [world], [road], true,false,3.0,0.1, true,0.1,0.0,0.0,0.0,50.0)",
					equals = "a list of polylines corresponding to the pedestrian paths",
					isExecutable = false) })
	@no_test
	public static IList<IShape> generateNetwork(IScope scope,  IList<IContainer<?, ? extends IShape>> obst, IContainer<?, ? extends IShape> bounds, 
			IContainer<?, ? extends IShape> regular_network, Boolean openArea,
			boolean randomDist, double valDistForOpenArea, double valDensityOpenArea,
			Boolean cleanNetwork, double toleranceClip, double toleranceTriang, double minDistPath, double simplificationDist,double sizeSquareOpti) {
		return PedestrianNetwork.generateNetwork(scope, obst, bounds, regular_network, openArea, randomDist,valDistForOpenArea,
				valDensityOpenArea, cleanNetwork, toleranceClip, toleranceTriang, minDistPath, simplificationDist, sizeSquareOpti);
	}
	
	/**
	 * Generate network.
	 *
	 * @param scope the scope
	 * @param obst the obst
	 * @param bounds the bounds
	 * @param regular_network the regular network
	 * @param openArea the open area
	 * @param randomDist the random dist
	 * @param valDistForOpenArea the val dist for open area
	 * @param valDensityOpenArea the val density open area
	 * @param cleanNetwork the clean network
	 * @param toleranceClip the tolerance clip
	 * @param toleranceTriang the tolerance triang
	 * @param simplificationDist the simplification dist
	 * @param minDistPath the min dist path
	 * @return the i list
	 */
	@operator(value = "generate_pedestrian_network", category = { "Pedestrian" } , concept = { IConcept.NETWORK })
	@doc (
			usages = { @usage (
					value = "generateNetwork(obstacles (list of lists of geometries/agents), bounds (list of geometries/agents), \n"
							+ "the road network (list of line) to have simple pedestrian behavior (1D movement) outside of the bounds \n"
							+ "add point to open areas (boolean), random densification (boolean; if true, use random points to fill open areas; if false, use uniform points), "
							+ "min distance to considered an area as open area (float), density of points in the open areas (float),\n" + 
							" clean network (boolean), tolerance for the cliping in triangulation (float; distance), tolerance for the triangulation (float), "
							+ "minimal distance to obstacles to keep a path (float; if 0.0, no filtering), "
							+ "simplification distance for the final geometries") },
			examples = { @example (
					value = "generate_pedestrian_network([wall], [world], [road], true,false,3.0,0.1, true,0.1,0.0,0.0,0.0)",
					equals = "a list of polylines corresponding to the pedestrian paths",
					isExecutable = false) })
	@no_test
	public static IList<IShape> generateNetwork(IScope scope,  IList<IContainer<?, ? extends IShape>> obst, IContainer<?, ? extends IShape> bounds, 
			IContainer<?, ? extends IShape> regular_network, Boolean openArea,
			boolean randomDist, double valDistForOpenArea, double valDensityOpenArea,
			Boolean cleanNetwork, double toleranceClip, double toleranceTriang, double simplificationDist,double minDistPath) {
		return PedestrianNetwork.generateNetwork(scope, obst, bounds, regular_network, openArea, randomDist,valDistForOpenArea,
				valDensityOpenArea, cleanNetwork, toleranceClip, toleranceTriang, minDistPath, simplificationDist,0);
	}

	
	
}
