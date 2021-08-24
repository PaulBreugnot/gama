/*******************************************************************************************************
 *
 * IBox2DPhysicalEntity.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.physics.box2d_version;

import org.jbox2d.common.Vec2;

import gama.ext.physics.common.IPhysicalEntity;
import gama.ext.physics.common.VectorUtils;
import gama.metamodel.shape.GamaPoint;

/**
 * The Interface IBox2DPhysicalEntity.
 */
public interface IBox2DPhysicalEntity extends IPhysicalEntity<Vec2> {
	
	/**
	 * To vector.
	 *
	 * @param v the v
	 * @return the vec 2
	 */
	@Override
	default Vec2 toVector(final GamaPoint v) {
		return VectorUtils.toBox2DVector(v);
	}

	/**
	 * To vector.
	 *
	 * @param v the v
	 * @param to the to
	 * @return the vec 2
	 */
	default Vec2 toVector(final GamaPoint v, final Vec2 to) {
		return VectorUtils.toBox2DVector(v, to);
	}

	/**
	 * To gama point.
	 *
	 * @param v the v
	 * @return the gama point
	 */
	@Override
	default GamaPoint toGamaPoint(final Vec2 v) {
		return VectorUtils.toGamaPoint(v);

	}

	/**
	 * To gama point.
	 *
	 * @param v the v
	 * @param result the result
	 * @return the gama point
	 */
	default GamaPoint toGamaPoint(final Vec2 v, final GamaPoint result) {
		return VectorUtils.toGamaPoint(v, result);
	}

}
