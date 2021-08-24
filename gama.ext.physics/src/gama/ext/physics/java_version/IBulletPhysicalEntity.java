/*******************************************************************************************************
 *
 * IBulletPhysicalEntity.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.physics.java_version;

import javax.vecmath.Vector3f;

import gama.ext.physics.common.IPhysicalEntity;
import gama.ext.physics.common.VectorUtils;
import gama.metamodel.shape.GamaPoint;

/**
 * The Interface IBulletPhysicalEntity.
 */
public interface IBulletPhysicalEntity extends IPhysicalEntity<Vector3f> {
	
	/**
	 * To vector.
	 *
	 * @param v the v
	 * @return the vector 3 f
	 */
	@Override
	default Vector3f toVector(final GamaPoint v) {
		return VectorUtils.toBulletVector(v);
	}

	/**
	 * To gama point.
	 *
	 * @param v the v
	 * @return the gama point
	 */
	@Override
	default GamaPoint toGamaPoint(final Vector3f v) {
		return VectorUtils.toGamaPoint(v);

	}

	/**
	 * To gama point.
	 *
	 * @param v the v
	 * @param result the result
	 * @return the gama point
	 */
	default GamaPoint toGamaPoint(final Vector3f v, final GamaPoint result) {
		return VectorUtils.toGamaPoint(v, result);

	}

	/**
	 * To vector.
	 *
	 * @param v the v
	 * @param result the result
	 * @return the vector 3 f
	 */
	default Vector3f toVector(final GamaPoint v, final Vector3f result) {
		return VectorUtils.toBulletVector(v, result);
	}
}
