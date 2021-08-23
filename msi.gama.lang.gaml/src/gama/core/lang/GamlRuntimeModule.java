/*********************************************************************************************
 *
 * 'GamlRuntimeModule.java, in plugin msi.gama.lang.gaml, is part of the source code of the GAMA modeling and simulation
 * platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.core.lang;

import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.DispatchingProvider;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Binder;

import gama.core.lang.expression.GamlExpressionCompiler;
import gama.core.lang.linking.GamlLinkingErrorMessageProvider;
import gama.core.lang.linking.GamlLinkingService;
import gama.core.lang.naming.GamlNameConverter;
import gama.core.lang.naming.GamlQualifiedNameProvider;
import gama.core.lang.parsing.GamlSyntaxErrorMessageProvider;
import gama.core.lang.resource.GamlEncodingProvider;
import gama.core.lang.resource.GamlResource;
import gama.core.lang.resource.GamlResourceDescriptionManager;
import gama.core.lang.resource.GamlResourceDescriptionStrategy;
import gama.core.lang.resource.GamlResourceInfoProvider;
import gama.core.lang.validation.ErrorToDiagnoticTranslator;
import gama.core.lang.validation.GamlResourceValidator;
import gaml.compilation.GAML;
import gaml.expressions.GamlExpressionFactory;
import gaml.expressions.IExpressionCompiler;
import msi.gama.lang.gaml.AbstractGamlRuntimeModule;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class GamlRuntimeModule extends AbstractGamlRuntimeModule {

	private static boolean initialized;

	// Disabled for the moment
	// public static Pref<Boolean> ENABLE_FAST_COMPIL = GamaPreferences
	//// .create("pref_optimize_fast_compilation",
	//// "Enable faster validation (but less accurate error reporting in nagivator)", false, IType.BOOL)
	//// .in(GamaPreferences.Modeling.NAME, GamaPreferences.Modeling.OPTIONS).hidden();

	public static void staticInitialize() {
		if (!initialized) {
			GamlExpressionFactory.registerParserProvider(GamlExpressionCompiler::new);
			GAML.registerInfoProvider(GamlResourceInfoProvider.INSTANCE);
			GAML.registerGamlEcoreUtils(EGaml.getInstance());
			initialized = true;

		}

	}

	@Override
	public void configure(final Binder binder) {
		super.configure(binder);
		staticInitialize();
		// binder.bind(ExpressionDescriptionBuilder.class);
		// binder.bind(IDocManager.class).to(GamlResourceDocumenter.class);
		// binder.bind(GamlSyntacticConverter.class);
		binder.bind(IDefaultResourceDescriptionStrategy.class).to(GamlResourceDescriptionStrategy.class);
		binder.bind(IQualifiedNameConverter.class).to(GamlNameConverter.class);
		binder.bind(IResourceDescription.Manager.class).to(GamlResourceDescriptionManager.class);
		// binder.bind(IOutputConfigurationProvider.class).to(GamlOutputConfigurationProvider.class);
		binder.bind(IResourceValidator.class).to(GamlResourceValidator.class);
		binder.bind(ErrorToDiagnoticTranslator.class);

	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return GamlQualifiedNameProvider.class;
	}

	@SuppressWarnings ("rawtypes")
	public Class<? extends IExpressionCompiler> bindIGamlExpressionCompiler() {
		return GamlExpressionCompiler.class;
	}

	@Override
	@SingletonBinding ()
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return gama.core.lang.scoping.BuiltinGlobalScopeProvider.class;
	}

	public Class<? extends ISyntaxErrorMessageProvider> bindISyntaxErrorMessageProvider() {
		return GamlSyntaxErrorMessageProvider.class;
	}

	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return GamlLinkingService.class;
	}

	public Class<? extends ILinkingDiagnosticMessageProvider.Extended> bindILinkingDiagnosticMessageProvider() {
		return GamlLinkingErrorMessageProvider.class;
	}

	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return GamlResource.class;
	}

	// @Override
	// public Class<? extends IParser> bindIParser() {
	// return GamlSyntacticParser.class;
	// }

	@Override
	public void configureRuntimeEncodingProvider(final Binder binder) {
		binder.bind(IEncodingProvider.class).annotatedWith(DispatchingProvider.Runtime.class)
				.to(GamlEncodingProvider.class);
	}

	// contributed by
	// org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	@Override
	public Class<? extends org.eclipse.xtext.resource.IContainer.Manager> bindIContainer$Manager() {
		return org.eclipse.xtext.resource.containers.StateBasedContainerManager.class;
	}

	// contributed by
	// org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	@Override
	public Class<? extends org.eclipse.xtext.resource.containers.IAllContainersState.Provider>
			bindIAllContainersState$Provider() {
		return org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersStateProvider.class;
	}

	// contributed by
	// org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	@Override
	public void configureIResourceDescriptions(final com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class)
				.to(org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions.class);
	}

	// contributed by
	// org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	@Override
	public void configureIResourceDescriptionsPersisted(final com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class)
				.annotatedWith(com.google.inject.name.Names
						.named(org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS))
				.to(org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions.class);
	}

	// contributed by org.eclipse.xtext.generator.formatting.FormatterFragment
	@Override
	public Class<? extends org.eclipse.xtext.formatting.IFormatter> bindIFormatter() {
		return gama.core.lang.formatting.GamlFormatter.class;
	}
}
