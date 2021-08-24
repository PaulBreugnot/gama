/*******************************************************************************************************
 *
 * ItemList.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.interfaces;

import java.util.List;
import java.util.Map;

import gama.util.GamaColor;

/**
 * Written by drogoul Modified on 13 mai 2011.
 *
 * @param <T> the generic type
 * @todo Description
 */
public interface ItemList<T> {

	/** The Constant ERROR_CODE. */
	public static final Character ERROR_CODE = '\u00F7';
	
	/** The Constant INFO_CODE. */
	public static final Character INFO_CODE = '\u00F8';
	
	/** The Constant WARNING_CODE. */
	public static final Character WARNING_CODE = '\u00FE';
	
	/** The Constant SEPARATION_CODE. */
	public static final Character SEPARATION_CODE = '\u00FF';

	/**
	 * Adds the item.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	boolean addItem(T obj);

	/**
	 * Removes the item.
	 *
	 * @param obj the obj
	 */
	void removeItem(T obj);

	/**
	 * Pause item.
	 *
	 * @param obj the obj
	 */
	void pauseItem(T obj);

	/**
	 * Resume item.
	 *
	 * @param obj the obj
	 */
	void resumeItem(T obj);

	/**
	 * Focus item.
	 *
	 * @param obj the obj
	 */
	void focusItem(T obj);

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public List<T> getItems();

	/**
	 * Gets the item display name.
	 *
	 * @param obj the obj
	 * @param previousName the previous name
	 * @return the item display name
	 */
	String getItemDisplayName(T obj, String previousName);

	/**
	 * Update item values.
	 */
	void updateItemValues();

	/**
	 * Make item selectable.
	 *
	 * @param data the data
	 * @param b the b
	 */
	void makeItemSelectable(T data, boolean b);

	/**
	 * Make item visible.
	 *
	 * @param obj the obj
	 * @param b the b
	 */
	void makeItemVisible(T obj, boolean b);

	/**
	 * Gets the item display color.
	 *
	 * @param data the data
	 * @return the item display color
	 */
	GamaColor getItemDisplayColor(T data);

	/**
	 * Handle menu.
	 *
	 * @param data the data
	 * @param x the x
	 * @param y the y
	 * @return the map
	 */
	Map<String, Runnable> handleMenu(T data, int x, int y);

}
