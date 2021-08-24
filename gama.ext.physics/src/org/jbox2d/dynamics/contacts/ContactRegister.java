/*******************************************************************************************************
 *
 * ContactRegister.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package org.jbox2d.dynamics.contacts;

import org.jbox2d.pooling.IDynamicStack;

/**
 * The Class ContactRegister.
 */
public class ContactRegister {
  
  /** The creator. */
  public IDynamicStack<Contact> creator;
  
  /** The primary. */
  public boolean primary;
}
