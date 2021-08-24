/*******************************************************************************************************
 *
 * CameraDefinition.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.outputs.layers;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.facet;
import gama.core.dev.annotations.GamlAnnotations.facets;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.metamodel.shape.GamaPoint;
import gama.outputs.LayeredDisplayOutput;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;
import gaml.operators.Cast;
import gaml.types.IType;

/**
 * The Class CameraDefinition.
 */
@symbol (
		name = IKeyword.CAMERA,
		kind = ISymbolKind.LAYER,
		with_sequence = false,
		unique_in_context = false,
		concept = { IConcept.CAMERA, IConcept.DISPLAY, IConcept.THREED })
@inside (
		symbols = IKeyword.DISPLAY)
@facets (
		value = { @facet (
				name = IKeyword.NAME,
				type = IType.STRING,
				optional = false,
				doc = @doc ("The name of the camera")),
				@facet (
						name = IKeyword.LOCATION,
						type = IType.POINT,
						optional = true,
						doc = @doc ("The location of the camera in the world")),
				@facet (
						name = IKeyword.LOOK_AT,
						type = IType.POINT,
						optional = true,
						doc = @doc ("The location that the camera is looking")),
				@facet (
						name = IKeyword.UP_VECTOR,
						type = IType.POINT,
						optional = true,
						doc = @doc ("The up-vector of the camera.")) },
		omissible = IKeyword.NAME)
@doc (
		value = "`" + IKeyword.CAMERA
				+ "` allows the modeler to define a camera. The display will then be able to choose among the camera defined (either within this statement or globally in GAMA) in a dynamic way. ",
		see = { IKeyword.DISPLAY, IKeyword.AGENTS, IKeyword.CHART, IKeyword.EVENT, "graphics", IKeyword.GRID_POPULATION,
				IKeyword.IMAGE, IKeyword.POPULATION, })
public class CameraDefinition extends AbstractLayerStatement {

	/** The up vector expr. */
	final IExpression locationExpr, lookAtExpr, upVectorExpr;
	
	/** The up vector. */
	GamaPoint location, lookAt, upVector;

	/**
	 * Instantiates a new camera definition.
	 *
	 * @param desc the desc
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public CameraDefinition(final IDescription desc) throws GamaRuntimeException {
		super(desc);
		locationExpr = getFacet(IKeyword.LOCATION);
		lookAtExpr = getFacet(IKeyword.LOOK_AT);
		upVectorExpr = getFacet(IKeyword.UP_VECTOR);
	}

	@Override
	public LayerType getType(final LayeredDisplayOutput output) {
		return LayerType.OVERLAY;
	}

	@Override
	protected boolean _init(final IScope scope) {
		return true;
	}

	@Override
	protected boolean _step(final IScope scope) {
		location = locationExpr == null ? null : Cast.asPoint(scope, locationExpr.value(scope));
		lookAt = lookAtExpr == null ? null : Cast.asPoint(scope, lookAtExpr.value(scope));
		upVector = upVectorExpr == null ? null : Cast.asPoint(scope, upVectorExpr.value(scope));
		return true;
	}

}
