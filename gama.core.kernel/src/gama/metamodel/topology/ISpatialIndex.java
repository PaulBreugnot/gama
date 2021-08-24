/*******************************************************************************************************
 *
 * ISpatialIndex.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.metamodel.topology;

import java.util.Collection;

import org.locationtech.jts.geom.Envelope;

import gama.common.geometry.Envelope3D;
import gama.metamodel.agent.IAgent;
import gama.metamodel.population.IPopulation;
import gama.metamodel.shape.IShape;
import gama.metamodel.topology.filter.IAgentFilter;
import gama.runtime.IScope;

/**
 * Written by drogoul Modified on 23 f�vr. 2011
 *
 * @todo Description
 *
 */
public interface ISpatialIndex {

	/**
	 * Insert.
	 *
	 * @param agent the agent
	 */
	void insert(IAgent agent);

	/**
	 * Removes the.
	 *
	 * @param previous the previous
	 * @param agent the agent
	 */
	void remove(final Envelope3D previous, final IAgent agent);

	/**
	 * First at distance.
	 *
	 * @param scope the scope
	 * @param source the source
	 * @param dist the dist
	 * @param f the f
	 * @return the i agent
	 */
	IAgent firstAtDistance(IScope scope, final IShape source, final double dist, final IAgentFilter f);

	/**
	 * First at distance.
	 *
	 * @param scope the scope
	 * @param source the source
	 * @param dist the dist
	 * @param f the f
	 * @param number the number
	 * @param alreadyChosen the already chosen
	 * @return the collection
	 */
	Collection<IAgent> firstAtDistance(IScope scope, final IShape source, final double dist, final IAgentFilter f,
			int number, Collection<IAgent> alreadyChosen);

	/**
	 * All in envelope.
	 *
	 * @param scope the scope
	 * @param source the source
	 * @param envelope the envelope
	 * @param f the f
	 * @param contained the contained
	 * @return the collection
	 */
	Collection<IAgent> allInEnvelope(IScope scope, final IShape source, final Envelope envelope, final IAgentFilter f,
			boolean contained);

	/**
	 * All at distance.
	 *
	 * @param scope the scope
	 * @param source the source
	 * @param dist the dist
	 * @param f the f
	 * @return the collection
	 */
	Collection<IAgent> allAtDistance(IScope scope, IShape source, double dist, IAgentFilter f);

	/**
	 * Dispose.
	 */
	void dispose();

	/**
	 * The Interface Compound.
	 */
	public interface Compound extends ISpatialIndex {

		/**
		 * Removes the.
		 *
		 * @param species the species
		 */
		void remove(final IPopulation<? extends IAgent> species);

		/**
		 * Update.
		 *
		 * @param envelope the envelope
		 * @param parallel the parallel
		 */
		void update(Envelope envelope, boolean parallel);

		/**
		 * Merge with.
		 *
		 * @param spatialIndex the spatial index
		 */
		void mergeWith(Compound spatialIndex);

	}

}