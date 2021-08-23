/*******************************************************************************************************
 *
 * msi.gaml.descriptions.IExpressionDescription.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.descriptions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

import gama.common.interfaces.IDisposable;
import gama.common.interfaces.IGamlable;
import gaml.expressions.IExpression;
import gaml.types.IType;

/**
 * The class IExpressionDescription.
 *
 * @author drogoul
 * @since 31 mars 2012
 *
 */
public interface IExpressionDescription extends IGamlable, IDisposable {

	public abstract void setExpression(final IExpression expr);

	public abstract IExpression compile(final IDescription context);

	public abstract IExpression getExpression();

	public abstract IExpressionDescription compileAsLabel();

	public abstract boolean equalsString(String o);

	public EObject getTarget();

	public void setTarget(EObject target);

	public boolean isConst();

	public Collection<String> getStrings(IDescription context, boolean skills);

	public abstract IExpressionDescription cleanCopy();

	public abstract IType<?> getDenotedType(IDescription context);

	// public abstract void collectMetaInformation(GamlProperties meta);

}