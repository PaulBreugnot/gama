/*******************************************************************************************************
 *
 * GamaTopologyType.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.types;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.type;
import gama.metamodel.agent.IAgent;
import gama.metamodel.population.IPopulation;
import gama.metamodel.shape.IShape;
import gama.metamodel.topology.ITopology;
import gama.metamodel.topology.continuous.ContinuousTopology;
import gama.metamodel.topology.continuous.MultipleTopology;
import gama.metamodel.topology.graph.GamaSpatialGraph;
import gama.metamodel.topology.graph.ISpatialGraph;
import gama.metamodel.topology.grid.GridTopology;
import gama.metamodel.topology.grid.IGrid;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.IContainer;
import gaml.operators.Cast;
import gaml.species.ISpecies;

/**
 * The type topology.
 * 
 * @author Alexis Drogoul
 * @since 26 nov. 2011
 * 
 */
@SuppressWarnings ("unchecked")
@type (
		name = IKeyword.TOPOLOGY,
		id = IType.TOPOLOGY,
		wraps = { ITopology.class },
		kind = ISymbolKind.Variable.REGULAR,
		concept = { IConcept.TYPE, IConcept.TOPOLOGY },
		doc = @doc ("Represents a topology, obtained from agents or geometries, that can be used to compute distances, neighbours, etc."))
public class GamaTopologyType extends GamaType<ITopology> {

	/**
	 * Static cast.
	 *
	 * @param scope the scope
	 * @param obj the obj
	 * @param copy the copy
	 * @return the i topology
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	@SuppressWarnings ("rawtypes")
	public static ITopology staticCast(final IScope scope, final Object obj, final boolean copy)
			throws GamaRuntimeException {
		// Many cases.
		if (obj == null) { return null; }
		if (obj instanceof ISpatialGraph) { return ((ISpatialGraph) obj).getTopology(scope); }
		if (obj instanceof ITopology) { return (ITopology) obj; }
		if (obj instanceof IAgent)
			return ((IAgent) obj).getTopology();
		if (obj instanceof IPopulation) { return ((IPopulation) obj).getTopology(); }
		if (obj instanceof ISpecies) { return staticCast(scope, scope.getAgent().getPopulationFor((ISpecies) obj),
				copy); }
		if (obj instanceof IShape) { return from(scope, (IShape) obj); }
		if (obj instanceof IContainer) { return from(scope, (IContainer) obj); }
		return staticCast(scope, Cast.asGeometry(scope, obj, copy), copy);
	}

	/**
	 * @see msi.gama.internal.types.GamaType#cast(msi.gama.interfaces.IScope, java.lang.Object, java.lang.Object)
	 */
	@Override
	public ITopology cast(final IScope scope, final Object obj, final Object param, final boolean copy)
			throws GamaRuntimeException {
		return staticCast(scope, obj, copy);
	}

	/**
	 * From.
	 *
	 * @param scope the scope
	 * @param obj the obj
	 * @return the i topology
	 */
	public static ITopology from(final IScope scope, final IShape obj) {
		return new ContinuousTopology(scope, obj);
	}

	/**
	 * From.
	 *
	 * @param scope the scope
	 * @param obj the obj
	 * @return the i topology
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	private static ITopology from(final IScope scope, final IContainer<?, IShape> obj) throws GamaRuntimeException {
		if (obj instanceof GamaSpatialGraph) {
			return ((GamaSpatialGraph) obj).getTopology(scope);
		} else if (obj instanceof IGrid) {
			return new GridTopology(scope, (IGrid) obj);
		} else {
			return new MultipleTopology(scope, obj);
		}
	}

	/**
	 * @see msi.gama.internal.types.GamaType#getDefault()
	 */
	@Override
	public ITopology getDefault() {
		return null;
	}

	@Override
	public IType<?> getContentType() {
		return Types.GEOMETRY;
	}

	@Override
	public boolean canCastToConst() {
		return false;
	}

}
