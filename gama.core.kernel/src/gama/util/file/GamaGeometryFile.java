/*******************************************************************************************************
 *
 * GamaGeometryFile.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util.file;

import gama.common.geometry.AxisAngle;
import gama.common.geometry.Envelope3D;
import gama.metamodel.shape.IShape;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.IList;
import gaml.types.IContainerType;
import gaml.types.Types;

/**
 * Class GamaGeometryFile. An abstract class that supports loading and saving geometries in specific subclasses. The
 * buffer is a GamaList of points (GamaPoint) from which the GamaGeometry can be constructed (using
 * geometry(file("..."));)
 *
 * @author drogoul
 * @since 30 déc. 2013
 *
 */
public abstract class GamaGeometryFile extends GamaFile<IList<IShape>, IShape> {

	/** The geometry. */
	protected IShape geometry;

	/**
	 * Instantiates a new gama geometry file.
	 *
	 * @param scope the scope
	 * @param pathName the path name
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public GamaGeometryFile(final IScope scope, final String pathName) throws GamaRuntimeException {
		super(scope, pathName);
	}

	/**
	 * Instantiates a new gama geometry file.
	 *
	 * @param scope the scope
	 * @param pathName the path name
	 * @param b the b
	 */
	public GamaGeometryFile(final IScope scope, final String pathName, final boolean b) {
		super(scope, pathName, b);
	}

	@Override
	public IContainerType<?> getGamlType() {
		return Types.FILE.of(Types.INT, Types.GEOMETRY);
	}

	/**
	 * Method computeEnvelope()
	 *
	 * @see gama.util.file.IGamaFile#computeEnvelope(gama.runtime.IScope)
	 */
	@Override
	public Envelope3D computeEnvelope(final IScope scope) {
		return getGeometry(scope).getEnvelope();
	}

	/**
	 * Gets the geometry.
	 *
	 * @param scope the scope
	 * @return the geometry
	 */
	public IShape getGeometry(final IScope scope) {
		fillBuffer(scope);
		if (geometry == null) { geometry = buildGeometry(scope); }
		return geometry;
	}

	/**
	 * Builds the geometry.
	 *
	 * @param scope the scope
	 * @return the i shape
	 */
	protected abstract IShape buildGeometry(IScope scope);

	@Override
	public void invalidateContents() {
		super.invalidateContents();
		geometry = null;
	}

	/**
	 * Gets the inits the rotation.
	 *
	 * @return the inits the rotation
	 */
	public AxisAngle getInitRotation() {
		return null;
	}

	/**
	 * Checks if is 2d.
	 *
	 * @return true, if is 2d
	 */
	public boolean is2D() {
		return true;
	}

}
