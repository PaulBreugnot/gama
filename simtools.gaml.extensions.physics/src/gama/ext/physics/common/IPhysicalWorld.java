package gama.ext.physics.common;

import gama.ext.physics.gaml.PhysicalSimulationAgent;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;

/**
 * The link between a simulation agent and the physical world / space, as defined by Bullet.
 *
 * @author drogoul
 *
 */
public interface IPhysicalWorld<WorldType, ShapeType, VectorType> extends IPhysicalEntity<VectorType> {

	IShapeConverter<ShapeType, VectorType> getShapeConverter();

	void doStep(Double timeStep, int maxSubSteps);

	void registerAgent(IAgent agent);

	void unregisterAgent(IAgent agent);

	void updateAgentShape(IAgent agent);

	void setCCD(boolean ccd);

	void setGravity(GamaPoint gravity);

	void dispose();

	WorldType getWorld();

	PhysicalSimulationAgent getSimulation();

	void updatePositionsAndRotations();

}