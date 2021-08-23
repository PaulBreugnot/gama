/*******************************************************************************************************
 *
 * msi.gama.common.interfaces.IEnvelopeComputer.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.interfaces;

import gama.common.geometry.Envelope3D;
import gama.runtime.IScope;

public interface IEnvelopeComputer {

	Envelope3D computeEnvelopeFrom(final IScope scope, final Object obj);

}
