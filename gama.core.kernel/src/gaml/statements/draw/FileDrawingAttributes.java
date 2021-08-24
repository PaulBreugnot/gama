/*******************************************************************************************************
 *
 * FileDrawingAttributes.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.statements.draw;

import gama.common.geometry.AxisAngle;
import gama.common.geometry.Scaling3D;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.util.GamaColor;

/**
 * The Class FileDrawingAttributes.
 */
public class FileDrawingAttributes extends DrawingAttributes {

	/** The agent identifier. */
	public final IAgent agentIdentifier;
	
	/** The Constant USE_CACHE. */
	public static final int USE_CACHE = 16;

	/**
	 * Instantiates a new file drawing attributes.
	 *
	 * @param size the size
	 * @param rotation the rotation
	 * @param location the location
	 * @param color the color
	 * @param border the border
	 * @param agent the agent
	 * @param lineWidth the line width
	 * @param isImage the is image
	 * @param lighting the lighting
	 */
	public FileDrawingAttributes(final Scaling3D size, final AxisAngle rotation, final GamaPoint location,
			final GamaColor color, final GamaColor border, final IAgent agent, final Double lineWidth,
			final boolean isImage, final Boolean lighting) {
		super(size, rotation, location, color, border, lighting);
		this.agentIdentifier = agent;
		setLineWidth(lineWidth);
		setType(isImage ? IShape.Type.POLYGON : IShape.Type.THREED_FILE);
		setUseCache(true); // by default
	}

	/**
	 * Instantiates a new file drawing attributes.
	 *
	 * @param location the location
	 * @param isImage the is image
	 */
	public FileDrawingAttributes(final GamaPoint location, final boolean isImage) {
		super(null, null, location, null, null, null);
		agentIdentifier = null;
		setType(isImage ? IShape.Type.POLYGON : IShape.Type.THREED_FILE);
		setUseCache(true); // by default
	}

	@Override
	public boolean useCache() {
		return isSet(USE_CACHE);
	}

	@Override
	public IAgent getAgentIdentifier() {
		return agentIdentifier;
	}

	/**
	 * Sets the use cache.
	 *
	 * @param b the new use cache
	 */
	public void setUseCache(final boolean b) {
		setFlag(USE_CACHE, b);
	}

}