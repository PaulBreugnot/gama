/*******************************************************************************************************
 *
 * LayerData.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.outputs.layers;

import static gama.common.interfaces.IKeyword.FADING;
import static gama.common.interfaces.IKeyword.POSITION;
import static gama.common.interfaces.IKeyword.REFRESH;
import static gama.common.interfaces.IKeyword.SELECTABLE;
import static gama.common.interfaces.IKeyword.SIZE;
import static gama.common.interfaces.IKeyword.TRACE;
import static gama.common.interfaces.IKeyword.TRANSPARENCY;
import static gaml.types.Types.BOOL;
import static gaml.types.Types.FLOAT;
import static gaml.types.Types.INT;
import static gaml.types.Types.POINT;

import java.awt.Point;

import org.locationtech.jts.geom.Envelope;

import gama.common.interfaces.IKeyword;
import gama.common.ui.IGraphics;
import gama.core.dev.utils.DEBUG;
import gama.metamodel.shape.GamaPoint;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.expressions.IExpression;
import gaml.expressions.units.PixelUnitExpression;
import gaml.operators.Cast;
import gaml.statements.draw.AttributeHolder;

// TODO: Auto-generated Javadoc
/**
 * Written by drogoul Modified on 16 nov. 2010
 *
 * @todo Description
 *
 */
public class LayerData extends AttributeHolder implements ILayerData {

	static {
		DEBUG.ON();
	}

	/** The position in pixels. */
	protected final Point positionInPixels = new Point();

	/** The size in pixels. */
	protected final Point sizeInPixels = new Point();

	/** The added elevation. */
	protected double addedElevation;

	/** The size is in pixels. */
	boolean positionIsInPixels, sizeIsInPixels;

	/** The visible region. */
	Envelope visibleRegion;

	/** The size. */
	Attribute<GamaPoint> size;

	/** The position. */
	Attribute<GamaPoint> position;

	/** The refresh. */
	final Attribute<Boolean> refresh;

	/** The fading. */
	final Attribute<Boolean> fading;

	/** The trace. */
	final Attribute<Integer> trace;

	/** The selectable. */
	Attribute<Boolean> selectable;

	/** The transparency. */
	Attribute<Double> transparency;

	/** The visible. */
	Attribute<Boolean> visible;

	/**
	 * Instantiates a new layer data.
	 *
	 * @param def
	 *            the def
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	public LayerData(final ILayerStatement def) throws GamaRuntimeException {
		super(def);
		final IExpression sizeExp = def.getFacet(SIZE);
		sizeIsInPixels = sizeExp != null && sizeExp.findAny(p -> p instanceof PixelUnitExpression);
		size = create(SIZE, sizeExp, POINT, new GamaPoint(1, 1, 1), e -> Cast.asPoint(null, e.getConstValue()));
		final IExpression posExp = def.getFacet(POSITION);
		positionIsInPixels = posExp != null && posExp.findAny(p -> p instanceof PixelUnitExpression);
		position = create(POSITION, posExp, POINT, new GamaPoint(), e -> Cast.asPoint(null, e.getConstValue()));
		refresh = create(REFRESH, def.getRefreshFacet(), BOOL, true, e -> Cast.asBool(null, e.getConstValue()));
		fading = create(FADING, BOOL, false);
		visible = create(IKeyword.VISIBLE, BOOL, true);
		trace = create(TRACE,
				(scope, exp) -> exp.getGamlType() == BOOL && Cast.asBool(scope, exp.value(scope)) ? Integer.MAX_VALUE
						: Cast.asInt(scope, exp.value(scope)),
						INT, 0, e -> (e.getGamlType() == BOOL && Cast.asBool(null, e.getConstValue()) ? Integer.MAX_VALUE
								: Cast.asInt(null, e.getConstValue())));
		selectable = create(SELECTABLE, BOOL, true);
		transparency =
				create(TRANSPARENCY, (scope, exp) -> Math.min(Math.max(Cast.asFloat(scope, exp.value(scope)), 0d), 1d),
						FLOAT, 0d, e -> Math.min(Math.max(Cast.asFloat(null, e.getConstValue()), 0d), 1d));

	}

	/**
	 * Compute.
	 *
	 * @param scope the scope
	 * @param g the g
	 * @return true, if successful
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	@Override
	public boolean compute(final IScope scope, final IGraphics g) throws GamaRuntimeException {
		boolean v = isVisible();
		this.refresh(scope);
		computePixelsDimensions(g);
		return scope.getClock().getCycle() > 0 && isVisible() != v;
	}

	/**
	 * Sets the transparency.
	 *
	 * @param f the new transparency
	 */
	@Override
	public void setTransparency(final double f) { transparency = create(TRANSPARENCY, Math.min(Math.max(f, 0d), 1d)); }

	/**
	 * Sets the size.
	 *
	 * @param p the new size
	 */
	@Override
	public void setSize(final GamaPoint p) {
		setSize(p.getX(), p.getY(), p.getZ());
	}

	/**
	 * Sets the size.
	 *
	 * @param width the width
	 * @param height the height
	 * @param depth the depth
	 */
	@Override
	public void setSize(final double width, final double height, final double depth) {
		size = create(SIZE, new GamaPoint(width, height, depth));
		sizeIsInPixels = false;
	}

	/**
	 * Sets the position.
	 *
	 * @param p the new position
	 */
	@Override
	public void setPosition(final GamaPoint p) {
		setPosition(p.getX(), p.getY(), p.getZ());
	}

	/**
	 * Sets the position.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	@Override
	public void setPosition(final double x, final double y, final double z) {
		position = create(POSITION, new GamaPoint(x, y, z));
		positionIsInPixels = false;
	}

	/**
	 * Adds the elevation.
	 *
	 * @param elevation the elevation
	 */
	@Override
	public void addElevation(final double elevation) {
		addedElevation = elevation;
	}

	/**
	 * Gets the transparency.
	 *
	 * @param scope the scope
	 * @return the transparency
	 */
	@Override
	public final Double getTransparency(final IScope scope) {
		return Cast.asFloat(scope, transparency.value(scope));
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	@Override
	public GamaPoint getPosition() { return position.get(); }

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	@Override
	public GamaPoint getSize() { return size.get(); }

	/**
	 * Gets the refresh.
	 *
	 * @return the refresh
	 */
	@Override
	public Boolean getRefresh() { return refresh.get(); }

	/**
	 * Sets the selectable.
	 *
	 * @param b the new selectable
	 */
	@Override
	public void setSelectable(final Boolean b) { selectable = create(SELECTABLE, b); }

	/**
	 * Method getTrace().
	 *
	 * @return the trace
	 * @see msi.gama.outputs.layers.ILayerData#getTrace()
	 */
	@Override
	public Integer getTrace() { return trace.get(); }

	/**
	 * Method getFading().
	 *
	 * @return the fading
	 * @see msi.gama.outputs.layers.ILayerData#getFading()
	 */
	@Override
	public Boolean getFading() { return fading.get(); }

	/**
	 * Checks if is selectable.
	 *
	 * @return the boolean
	 */
	@Override
	public Boolean isSelectable() { return selectable.get(); }

	/**
	 * Checks if is relative position.
	 *
	 * @return true, if is relative position
	 */
	@Override
	public boolean isRelativePosition() { return !positionIsInPixels; }

	/**
	 * Checks if is relative size.
	 *
	 * @return true, if is relative size
	 */
	@Override
	public boolean isRelativeSize() { return !sizeIsInPixels; }

	/**
	 * Gets the size in pixels.
	 *
	 * @return the size in pixels
	 */
	@Override
	public Point getSizeInPixels() { return sizeInPixels; }

	/**
	 * Gets the position in pixels.
	 *
	 * @return the position in pixels
	 */
	@Override
	public Point getPositionInPixels() { return positionInPixels; }

	/**
	 * Compute pixels dimensions.
	 *
	 * @param g the g
	 */
	@Override
	public void computePixelsDimensions(final IGraphics g) {
		// Voir comment conserver cette information
		final int pixelWidth = g.getDisplayWidth();
		final int pixelHeight = g.getDisplayHeight();
		final double xRatio = g.getxRatioBetweenPixelsAndModelUnits();
		final double yRatio = g.getyRatioBetweenPixelsAndModelUnits();

		GamaPoint point = getPosition();
		// Computation of x
		final double x = point.getX();

		double relative_x;
		if (!isRelativePosition()) {
			relative_x = xRatio * x;
		} else {
			relative_x = Math.abs(x) <= 1 ? pixelWidth * x : xRatio * x;
		}
		final double absolute_x = Math.signum(x) < 0 ? pixelWidth + relative_x : relative_x;
		// Computation of y

		final double y = point.getY();
		double relative_y;
		if (!isRelativePosition()) {
			relative_y = yRatio * y;
		} else {
			relative_y = Math.abs(y) <= 1 ? pixelHeight * y : yRatio * y;
		}

		// relative_y = Math.abs(y) <= 1 ? pixelHeight * y : yRatio * y;
		final double absolute_y = Math.signum(y) < 0 ? pixelHeight + relative_y : relative_y;

		point = getSize();
		// Computation of width
		final double w = point.getX();
		double absolute_width;
		if (!isRelativeSize()) {
			absolute_width = xRatio * w;
		} else {
			absolute_width = Math.abs(w) <= 1 ? pixelWidth * w : xRatio * w;
		}
		// Computation of height
		final double h = point.getY();
		double absolute_height;
		if (!isRelativeSize()) {
			absolute_height = yRatio * h;
		} else {
			absolute_height = Math.abs(h) <= 1 ? pixelHeight * h : yRatio * h;
		}

		getSizeInPixels().setLocation(absolute_width, absolute_height);
		getPositionInPixels().setLocation(absolute_x, absolute_y);
	}

	/**
	 * Sets the visible region.
	 *
	 * @param e the new visible region
	 */
	@Override
	public void setVisibleRegion(final Envelope e) { visibleRegion = e; }

	/**
	 * Gets the visible region.
	 *
	 * @return the visible region
	 */
	@Override
	public Envelope getVisibleRegion() { return visibleRegion; }

	/**
	 * Checks if is visible.
	 *
	 * @return the boolean
	 */
	@Override
	public Boolean isVisible() {
		return visible.get();

	}

	/**
	 * Sets the visible.
	 *
	 * @param b
	 *            the new visible
	 */
	@Override
	public void setVisible(final Boolean b) {
		// TODO AD We should maybe force it to a constant ?
		if (isVisible() != b) { visible = create(IKeyword.VISIBLE, BOOL, b); }
	}

	/**
	 * Gets the added elevation.
	 *
	 * @return the added elevation
	 */
	@Override
	public double getAddedElevation() { return addedElevation; }

}
