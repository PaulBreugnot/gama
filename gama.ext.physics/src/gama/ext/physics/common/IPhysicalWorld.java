/*******************************************************************************************************
 *
 * IPhysicalWorld.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.physics.common;

import gama.ext.physics.gaml.PhysicalSimulationAgent;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;

/**
 * The link between a simulation agent and the physical world / space, as defined by Bullet.
 *
 * @author drogoul
 * @param <WorldType> the generic type
 * @param <ShapeType> the generic type
 * @param <VectorType> the generic type
 */
public interface IPhysicalWorld<WorldType, ShapeType, VectorType> extends IPhysicalEntity<VectorType> {

	/**
	 * Gets the shape converter.
	 *
	 * @return the shape converter
	 */
	IShapeConverter<ShapeType, VectorType> getShapeConverter();

	/**
	 * Do step.
	 *
	 * @param timeStep the time step
	 * @param maxSubSteps the max sub steps
	 */
	void doStep(Double timeStep, int maxSubSteps);

	/**
	 * Register agent.
	 *
	 * @param agent the agent
	 */
	void registerAgent(IAgent agent);

	/**
	 * Unregister agent.
	 *
	 * @param agent the agent
	 */
	void unregisterAgent(IAgent agent);

	/**
	 * Update agent shape.
	 *
	 * @param agent the agent
	 */
	void updateAgentShape(IAgent agent);

	/**
	 * Sets the ccd.
	 *
	 * @param ccd the new ccd
	 */
	void setCCD(boolean ccd);

	/**
	 * Sets the gravity.
	 *
	 * @param gravity the new gravity
	 */
	void setGravity(GamaPoint gravity);

	/**
	 * Dispose.
	 */
	void dispose();

	/**
	 * Gets the world.
	 *
	 * @return the world
	 */
	WorldType getWorld();

	/**
	 * Gets the simulation.
	 *
	 * @return the simulation
	 */
	PhysicalSimulationAgent getSimulation();

	/**
	 * Update positions and rotations.
	 */
	void updatePositionsAndRotations();

}