package gama.ext.physics.common;

import gama.metamodel.shape.GamaPoint;

public interface IPhysicalEntity<VectorType> extends IPhysicalConstants {

	VectorType toVector(final GamaPoint v);

	GamaPoint toGamaPoint(VectorType v);

}
