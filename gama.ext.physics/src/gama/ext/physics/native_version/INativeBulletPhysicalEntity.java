package gama.ext.physics.native_version;

import com.jme3.math.Vector3f;

import gama.ext.physics.common.IPhysicalEntity;
import gama.ext.physics.common.VectorUtils;
import gama.metamodel.shape.GamaPoint;

public interface INativeBulletPhysicalEntity extends IPhysicalEntity<Vector3f> {
	@Override
	default Vector3f toVector(final GamaPoint v) {
		return VectorUtils.toNativeBulletVector(v);
	}

	@Override
	default GamaPoint toGamaPoint(final Vector3f v) {
		return VectorUtils.toGamaPoint(v);
	}

	default GamaPoint toGamaPoint(final Vector3f v, final GamaPoint result) {
		return VectorUtils.toGamaPoint(v, result);
	}
}
