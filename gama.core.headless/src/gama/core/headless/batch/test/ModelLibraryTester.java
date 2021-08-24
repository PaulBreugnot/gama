/*******************************************************************************************************
 *
 * ModelLibraryTester.java, in gama.core.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.headless.batch.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.FileLocator;
import org.osgi.framework.Bundle;

import com.google.common.collect.Multimap;
import com.google.inject.Injector;

import gama.common.preferences.GamaPreferences;
import gama.core.application.bundles.GamaBundleLoader;
import gama.core.dev.utils.DEBUG;
import gama.core.headless.batch.AbstractModelLibraryRunner;
import gama.core.headless.core.HeadlessSimulationLoader;
import gama.core.lang.validation.GamlModelBuilder;
import gama.kernel.experiment.IExperimentPlan;
import gama.kernel.experiment.ParametersSet;
import gama.kernel.experiment.TestAgent;
import gama.kernel.model.IModel;
import gama.runtime.GAMA;
import gaml.compilation.GamlCompilationError;
import gaml.descriptions.ModelDescription;
import gaml.statements.test.TestState;

/**
 * The Class ModelLibraryTester.
 */
public class ModelLibraryTester extends AbstractModelLibraryRunner {

	/** The instance. */
	private static ModelLibraryTester instance;
	
	/** The Constant FAILED_PARAMETER. */
	private final static String FAILED_PARAMETER = "-failed";

	/** The original. */
	PrintStream original;
	
	/** The null stream. */
	PrintStream nullStream;

	/**
	 * Instantiates a new model library tester.
	 */
	private ModelLibraryTester() {}

	@Override
	public int start(final List<String> args) throws IOException {
		DEBUG.ON();
		final Injector injector = HeadlessSimulationLoader.getInjector();
		final GamlModelBuilder builder = createBuilder(injector);

		original = System.out;
		nullStream = new PrintStream(new OutputStream() {
			@Override
			public void write(final int b) {
				// DO NOTHING
			}
		});
		final int[] count = { 0 };
		final int[] code = { 0 };
		final boolean onlyFailed = args.contains(FAILED_PARAMETER);
		final boolean oldPref = GamaPreferences.Runtime.FAILED_TESTS.getValue();
		GamaPreferences.Runtime.FAILED_TESTS.set(onlyFailed);
		final Multimap<Bundle, String> plugins = GamaBundleLoader.getPluginsWithTests();
		final List<URL> allURLs = new ArrayList<>();
		for (final Bundle bundle : plugins.keySet()) {
			for (final String entry : plugins.get(bundle)) {
				final Enumeration<URL> urls = bundle.findEntries(entry, "*", true);
				if (urls != null) {
					while (urls.hasMoreElements()) {
						final URL url = urls.nextElement();
						if (isTest(url)) {
							final URL resolvedFileURL = FileLocator.toFileURL(url);
							allURLs.add(resolvedFileURL);
						}
					}
				}
			}
		}
		builder.loadURLs(allURLs);

		allURLs.forEach(u -> test(builder, count, code, u));
		GamaPreferences.Runtime.FAILED_TESTS.set(oldPref);

		DEBUG.OUT("" + count[0] + " tests executed in built-in library and plugins. " + code[0] + " failed or aborted");
		DEBUG.OUT(code[0]);
		return code[0];
	}

	/**
	 * Test.
	 *
	 * @param builder the builder
	 * @param count the count
	 * @param code the code
	 * @param p the p
	 */
	public void test(final GamlModelBuilder builder, final int[] count, final int[] code, final URL p) {
		// DEBUG.OUT(p);
		final List<GamlCompilationError> errors = new ArrayList<>();
		try {
			final IModel model = builder.compile(p, errors);
			if (model == null || model.getDescription() == null) return;
			final List<String> testExpNames = ((ModelDescription) model.getDescription()).getExperimentNames().stream()
					.filter(e -> model.getExperiment(e).isTest()).collect(Collectors.toList());

			if (testExpNames.isEmpty()) return;
			for (final String expName : testExpNames) {
				final IExperimentPlan exp = GAMA.addHeadlessExperiment(model, expName, new ParametersSet(), null);
				if (exp != null) {
					System.setOut(nullStream);
					final TestAgent agent = (TestAgent) exp.getAgent();
					exp.setHeadless(true);
					exp.getController().getScheduler().paused = false;
					exp.getAgent().step(agent.getScope());
					code[0] += agent.getSummary().countTestsWith(TestState.FAILED);
					code[0] += agent.getSummary().countTestsWith(TestState.ABORTED);
					count[0] += agent.getSummary().size();

					System.setOut(original);
					if (agent.getSummary().countTestsWith(TestState.FAILED) > 0
							|| agent.getSummary().countTestsWith(TestState.ABORTED) > 0) {

						DEBUG.OUT(agent.getSummary().toString());
					}
				}
			}
		} catch (final Exception ex) {
			DEBUG.OUT(ex.getMessage());
		}

	}

	/**
	 * Gets the single instance of ModelLibraryTester.
	 *
	 * @return single instance of ModelLibraryTester
	 */
	public static ModelLibraryTester getInstance() {
		if (instance == null) { instance = new ModelLibraryTester(); }
		return instance;
	}
}
