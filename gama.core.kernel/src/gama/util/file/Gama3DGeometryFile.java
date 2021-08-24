/*******************************************************************************************************
 *
 * Gama3DGeometryFile.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util.file;

import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Geometry;

import gama.common.geometry.AxisAngle;
import gama.common.geometry.Envelope3D;
import gama.common.geometry.GeometryUtils;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.GamaShape;
import gama.metamodel.shape.IShape;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaPair;
import gaml.operators.Cast;

/**
 * The Class Gama3DGeometryFile.
 */
public abstract class Gama3DGeometryFile extends GamaGeometryFile {

	/** The init rotation. */
	protected AxisAngle initRotation;
	
	/** The envelope. */
	protected Envelope3D envelope;

	/**
	 * Instantiates a new gama 3 D geometry file.
	 *
	 * @param scope the scope
	 * @param pathName the path name
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public Gama3DGeometryFile(final IScope scope, final String pathName) throws GamaRuntimeException {
		super(scope, pathName);
	}

	/**
	 * Instantiates a new gama 3 D geometry file.
	 *
	 * @param scope the scope
	 * @param pathName the path name
	 * @param initRotation the init rotation
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public Gama3DGeometryFile(final IScope scope, final String pathName, final GamaPair<Double, GamaPoint> initRotation)
			throws GamaRuntimeException {
		super(scope, pathName);
		if (initRotation != null) {
			final Double angle = Cast.asFloat(null, initRotation.key);
			final GamaPoint axis = initRotation.value;
			this.initRotation = new AxisAngle(axis, angle);
		} else {
			this.initRotation = null;
		}
	}

	@Override
	protected IShape buildGeometry(final IScope scope) {
		final List<Geometry> faces = new ArrayList<>();
		for (final IShape shape : getBuffer().iterable(scope)) {
			faces.add(shape.getInnerGeometry());
		}
		return new GamaShape(GeometryUtils.GEOMETRY_FACTORY.buildGeometry(faces));
	}

	@Override
	public AxisAngle getInitRotation() {
		return initRotation;
	}

	/**
	 * Sets the inits the rotation.
	 *
	 * @param initRotation the new inits the rotation
	 */
	public void setInitRotation(final AxisAngle initRotation) {
		this.initRotation = initRotation;
	}

	@Override
	public Envelope3D computeEnvelope(final IScope scope) {
		if (envelope == null) {
			fillBuffer(scope);
			if (initRotation != null && initRotation.angle != 0.0)
				envelope = envelope.rotate(initRotation);
		}
		return envelope;
	}

	@Override
	public boolean is2D() {
		return false;
	}

}