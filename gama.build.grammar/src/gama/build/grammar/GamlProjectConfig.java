/*******************************************************************************************************
 *
 * GamlProjectConfig.java, in gama.build.grammar, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.build.grammar;

import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.project.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.RuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.SubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.WebProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.XtextProjectConfig;

import com.google.common.base.Objects;

/**
 * The Class GamlProjectConfig.
 */
public class GamlProjectConfig extends XtextProjectConfig {

	/** The root path. */
	private String rootPath;

	/** The base (runtime) name. */
	private String runtimeName;

	/** The base (ui) name. */
	private String uiName;

	/**
	 * The base name of the project, which is usually equal to the runtime subproject.
	 *
	 * @param baseName
	 *            the base name
	 * @return the string
	 */
	@Mandatory
	public String setRuntimeName(final String baseName) {
		return this.runtimeName = baseName;
	}

	/**
	 * Sets the ui name.
	 *
	 * @param baseName
	 *            the base name
	 * @return the string
	 */
	@Mandatory
	public String setUiName(final String baseName) {
		return this.uiName = baseName;
	}

	/**
	 * The root path, usually {@code ".."}.
	 *
	 * @param rootPath
	 *            the root path
	 * @return the string
	 */
	@Mandatory
	public String setRootPath(final String rootPath) {
		return this.rootPath = rootPath;
	}

	/**
	 * Check configuration.
	 *
	 * @param issues
	 *            the issues
	 */
	@Override
	public void checkConfiguration(final Issues issues) {
		super.checkConfiguration(issues);
		if (rootPath == null) { issues.addError("The property 'rootPath' must be set", this); }
		if (runtimeName == null) { issues.addError("The property 'runtimeName' must be set", this); }
		if (uiName == null) { issues.addError("The property 'uiName' must be set", this); }
	}

	/**
	 * Sets the defaults.
	 */
	@Override
	public void setDefaults() {
		super.setDefaults();
		for (SubProjectConfig it : getEnabledProjects()) {
			if (it.getName() == null) { it.setName(computeName(it)); }
			if (it.getRootPath() == null) { it.setRoot(computeRoot(it)); }
			if (it.getMetaInfPath() == null) { it.setMetaInf(computeMetaInf(it)); }
			if (it.getSrcPath() == null) { it.setSrc(computeSrc(it)); }
			if (it.getSrcGenPath() == null) { it.setSrcGen(computeSrcGen(it)); }
			if (it.getIconsPath() == null) { it.setIcons(computeIcons(it)); }
			if (it instanceof BundleProjectConfig) {
				BundleProjectConfig bundleProjectConfig = (BundleProjectConfig) it;
				if (bundleProjectConfig.getManifest() == null) { bundleProjectConfig.setManifest(newManifestAccess()); }
				if (bundleProjectConfig.getPluginXml() == null) {
					bundleProjectConfig.setPluginXml(newPluginXmlAccess());
				}
			}
			if (it instanceof RuntimeProjectConfig) {
				RuntimeProjectConfig runtimeProjectConfig = (RuntimeProjectConfig) it;
				if (runtimeProjectConfig.getEcoreModelPath() == null) {
					runtimeProjectConfig.setEcoreModel(computeEcoreModel(runtimeProjectConfig));
				}
			}
			if (it instanceof WebProjectConfig) {
				WebProjectConfig webProjectConfig = (WebProjectConfig) it;
				if (webProjectConfig.getAssetsPath() == null) {
					webProjectConfig.setAssets(computeAssets(webProjectConfig));
				}
			}
		}
	}

	/**
	 * Compute name.
	 *
	 * @param project
	 *            the project
	 * @return the string
	 */
	protected String computeName(final SubProjectConfig project) {
		if (Objects.equal(project, getRuntime())) return runtimeName;
		// if (Objects.equal(project, getRuntimeTest())) return runtimeName + ".tests";
		// if (Objects.equal(project, getGenericIde())) return null;
		if (Objects.equal(project, getGenericIde()) || Objects.equal(project, getEclipsePlugin())) return uiName;
		// if (Objects.equal(project, getEclipsePluginTest())) return uiName + ".tests";
		// if (Objects.equal(project, getWeb())) return runtimeName + ".web";
		return null;
	}

	/**
	 * Compute root.
	 *
	 * @param project
	 *            the project
	 * @return the string
	 */
	protected String computeRoot(final SubProjectConfig project) {
		return rootPath + "/" + project.getName();
	}

	/**
	 * In case of "Maven/Gradle" source layout the src outlet is named 'src/main/java', test classes go into
	 * 'src/test/java' instead of any dedicated '...tests' project.
	 *
	 * @param project
	 *            the project
	 * @return the string
	 */
	protected String computeSrc(final SubProjectConfig project) {
		return project.getRootPath() + "/" + "src";
	}

	/**
	 * In case of "Maven/Gradle" source layout the srcGen outlet is named 'src/main/xtext-gen', test-related srcGen
	 * classes go into 'src/test/xtext-gen' instead of any dedicated '...tests' project. Don't confuse it with
	 * 'src/main/xtend-gen'!
	 *
	 * @param project
	 *            the project
	 * @return the string
	 */
	protected String computeSrcGen(final SubProjectConfig project) {
		return project.getRootPath() + "/" + "src-gen";
	}

	/**
	 * Compute meta inf.
	 *
	 * @param project
	 *            the project
	 * @return the string
	 */
	protected String computeMetaInf(final SubProjectConfig project) {
		return project.getRootPath() + "/" + "META-INF";
	}

	/**
	 * Compute ecore model.
	 *
	 * @param project
	 *            the project
	 * @return the string
	 */
	protected String computeEcoreModel(final RuntimeProjectConfig project) {
		return project.getRootPath() + "/" + "model/generated";
	}

	/**
	 * Compute assets.
	 *
	 * @param project
	 *            the project
	 * @return the string
	 */
	protected String computeAssets(final WebProjectConfig project) {
		return project.getRootPath() + "/" + "WebRoot";
	}

	/**
	 * Compute source set.
	 *
	 * @param project
	 *            the project
	 * @return the string
	 */
	protected String computeSourceSet(final SubProjectConfig project) {
		if (getTestProjects().contains(project)) return "test";
		return "main";
	}

	/**
	 * Compute icons.
	 *
	 * @param project
	 *            the project
	 * @return the string
	 */
	protected String computeIcons(final SubProjectConfig project) {
		return project.getRootPath() + "/" + "icons";
	}

	/**
	 * Gets the root path.
	 *
	 * @return the root path
	 */
	public String getRootPath() { return rootPath; }

	/**
	 * Gets the base name.
	 *
	 * @return the base name
	 */
	public String getBaseName() { return runtimeName; }
}
