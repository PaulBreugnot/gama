/*******************************************************************************************************
 *
 * IPositionChangeListener.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.controls;

/**
 * Listener interface for position change events of CoolSlider.
 *
 * @see IPositionChangeEvent
 */
public interface IPositionChangeListener {
	
	/**
	 * Puts the position of the thumb of the slider after a change has occurred. The position has range from min to max
	 * and represents a integer that is a multiple of the incrementValue.<br>
	 * <br>
	 *
	 * @param slider the slider
	 * @param position the position
	 */
	public void positionChanged(SimpleSlider slider, double position);
}
