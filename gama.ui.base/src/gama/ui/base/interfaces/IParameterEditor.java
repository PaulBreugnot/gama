/*******************************************************************************************************
 *
 * IParameterEditor.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.interfaces;

import gama.common.interfaces.IScoped;
import gama.kernel.experiment.IParameter;
import gaml.types.IType;

/**
 * The class IParameterEditor.
 *
 * @author drogoul
 * @param <T> the generic type
 * @since 18 d�c. 2011
 */
@SuppressWarnings ({ "rawtypes" })
public interface IParameterEditor<T> extends IScoped {

	/**
	 * Gets the expected type.
	 *
	 * @return the expected type
	 */
	IType getExpectedType();

	/**
	 * Checks if is value modified.
	 *
	 * @return true, if is value modified
	 */
	boolean isValueModified();

	/**
	 * Revert to default value.
	 */
	void revertToDefaultValue();

	/**
	 * Gets the param.
	 *
	 * @return the param
	 */
	IParameter getParam();

	/**
	 * Update with value of parameter.
	 */
	void updateWithValueOfParameter();

	/**
	 * Sets the active.
	 *
	 * @param value the new active
	 */
	void setActive(Boolean value);

	/**
	 * Gets the current value.
	 *
	 * @return the current value
	 */
	T getCurrentValue();

	/** Items to add to the editor. */

	int PLUS = 0;
	
	/** The minus. */
	int MINUS = 1;
	
	/** The edit. */
	int EDIT = 2;
	
	/** The inspect. */
	int INSPECT = 3;
	
	/** The browse. */
	int BROWSE = 4;
	
	/** The change. */
	int CHANGE = 5;
	
	/** The revert. */
	int REVERT = 6;
	
	/** The define. */
	int DEFINE = 7;
	
	/** The value. */
	int VALUE = 8;

	/**
	 * Checks if is sub parameter.
	 *
	 * @param b the b
	 */
	void isSubParameter(boolean b);

}