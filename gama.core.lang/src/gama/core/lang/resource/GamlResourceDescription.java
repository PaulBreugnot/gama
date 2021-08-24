/*******************************************************************************************************
 *
 * GamlResourceDescription.java, in gama.core.lang, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.lang.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.util.IResourceScopeCache;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

import gama.core.lang.scoping.BuiltinGlobalScopeProvider;

/**
 * The class GamlResourceDescription.
 * 
 * @author drogoul
 * @since 20 avr. 2012
 * 
 */

public class GamlResourceDescription extends DefaultResourceDescription {

	/**
	 * Default constructor.
	 *
	 */
	final BuiltinGlobalScopeProvider provider;

	/**
	 * Instantiates a new gaml resource description.
	 *
	 * @param resource the resource
	 * @param strategy the strategy
	 * @param cache the cache
	 * @param provider the provider
	 */
	@Inject
	public GamlResourceDescription(final Resource resource, final IDefaultResourceDescriptionStrategy strategy,
			final IResourceScopeCache cache, final BuiltinGlobalScopeProvider provider) {
		super(resource, strategy, cache);
		this.provider = provider;

	}

	@Override
	public Iterable<QualifiedName> getImportedNames() {
		final Iterable<QualifiedName> result = super.getImportedNames();
		return Iterables.filter(result, new Predicate<QualifiedName>() {

			@Override
			public boolean apply(final QualifiedName input) {
				return !provider.contains(input);
			}
		});
	}

}
