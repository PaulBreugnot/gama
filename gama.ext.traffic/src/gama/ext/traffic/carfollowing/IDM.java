/*******************************************************************************************************
 *
 * IDM.java, in gama.ext.traffic, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.traffic.carfollowing;

import static gama.ext.traffic.DrivingSkill.getDeltaIDM;
import static gama.ext.traffic.DrivingSkill.getMaxAcceleration;
import static gama.ext.traffic.DrivingSkill.getMaxDeceleration;
import static gama.ext.traffic.DrivingSkill.getMaxSpeed;
import static gama.ext.traffic.DrivingSkill.getMinSafetyDistance;
import static gama.ext.traffic.DrivingSkill.getSpeed;
import static gama.ext.traffic.DrivingSkill.getSpeedCoeff;
import static gama.ext.traffic.DrivingSkill.getTimeHeadway;

import gama.ext.traffic.RoadSkill;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;

/**
 * The Class IDM.
 */
public class IDM {
	
	/**
	 * Computes the acceleration according to the Intelligent Driver Model
	 * (https://traffic-simulation.de/info/info_IDM.html), DrivingSkill.isViolatingOneway(driver)
	 *
	 * @param scope the scope
	 * @param vehicle      the vehicle whose acceleration will be computed
	 * @param road the road
	 * @param leadingDist  the bumper-to-bumper gap with its leading vehicle
	 * @param leadingSpeed the speed of the leading vehicle
	 * @return the resulting acceleration (deceleration if it is < 0)
	 */
	public static double computeAcceleration(final IScope scope,
			final IAgent vehicle,
			final IAgent road,
			final double leadingDist,
			final double leadingSpeed) {
		// IDM params
		double T = getTimeHeadway(vehicle);
		double a = getMaxAcceleration(vehicle);
		double b = getMaxDeceleration(vehicle);
		double v0 = Math.min(getMaxSpeed(vehicle), getSpeedCoeff(vehicle) * RoadSkill.getMaxSpeed(road));
		double s0 = getMinSafetyDistance(vehicle);
		double delta = getDeltaIDM(vehicle);

		double s = leadingDist;
		double v = getSpeed(vehicle);
		double dv = v - leadingSpeed;

		double sStar = s0 + Math.max(0, v * T + v * dv / 2 / Math.sqrt(a * b));
		double accel = a * (1 - Math.pow(v / v0, delta) - Math.pow(sStar / s, 2));

		return accel;
	}
}
