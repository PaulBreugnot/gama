/*********************************************************************************************
 *
 * 'IParameterEditor.java, in plugin gama.ui.base, is part of the source code of the GAMA modeling and
 * simulation platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.ui.base.interfaces;

import gama.common.interfaces.IScoped;
import gama.kernel.experiment.IParameter;
import gaml.types.IType;

/**
 * The class IParameterEditor.
 *
 * @author drogoul
 * @since 18 d�c. 2011
 *
 */
@SuppressWarnings ({ "rawtypes" })
public interface IParameterEditor<T> extends IScoped {

	IType getExpectedType();

	boolean isValueModified();

	void revertToDefaultValue();

	IParameter getParam();

	void updateWithValueOfParameter();

	void setActive(Boolean value);

	T getCurrentValue();

	/**
	 * Items to add to the editor
	 */

	int PLUS = 0;
	int MINUS = 1;
	int EDIT = 2;
	int INSPECT = 3;
	int BROWSE = 4;
	int CHANGE = 5;
	int REVERT = 6;
	int DEFINE = 7;
	int VALUE = 8;

	/**
	 * @param b
	 */
	void isSubParameter(boolean b);

}