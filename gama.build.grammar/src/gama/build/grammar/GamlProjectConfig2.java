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
import org.eclipse.xtext.xtext.generator.model.project.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.RuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.SubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.WebProjectConfig;

import com.google.common.base.Objects;

/**
 * The Class GamlProjectConfig.
 */
public class GamlProjectConfig2 extends StandardProjectConfig {
	/**
	 * set to {@code true} by the project wizard(s) in case "Maven/Gradle" source layout is selected.
	 */
	private boolean mavenLayout;

	/** The create eclipse meta data. */
	private boolean createEclipseMetaData;

	/** The base runtime project name. */
	private final String baseRuntimeProjectName = "gama.core.lang";

	/** The base UI project name. */
	private final String baseUIProjectName = "gama.ui.modeling";

	/** The base name. */
	// private String baseName = baseRuntimeProjectName;

	/**
	 * The base name of the project, which is usually equal to the runtime subproject.
	 */
	@Override
	@Mandatory
	public String setBaseName(final String baseName) {
		return super.setBaseName(baseRuntimeProjectName);
	}

	/**
	 * The root path, usually {@code ".."}.
	 */
	@Override
	@Mandatory
	public String setRootPath(final String rootPath) {
		// We skip it
		return super.setRootPath("..");
	}

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
			if (it instanceof BundleProjectConfig && createEclipseMetaData) {
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

	@Override
	protected String computeName(final SubProjectConfig project) {
		if (Objects.equal(project, getRuntime())) return baseRuntimeProjectName;
		if (Objects.equal(project, getRuntimeTest())) {
			if (!mavenLayout) return baseRuntimeProjectName + ".tests";
			return baseRuntimeProjectName;
		}
		if (Objects.equal(project, getGenericIde()) || Objects.equal(project, getEclipsePlugin()))
			return baseUIProjectName;
		if (Objects.equal(project, getEclipsePluginTest())) {
			if (!mavenLayout) return baseUIProjectName + ".tests";
			return baseUIProjectName;
		}
		if (Objects.equal(project, getWeb())) return baseRuntimeProjectName + ".web";
		return null;
	}

	/**
	 * In case of "Maven/Gradle" source layout the src outlet is named 'src/main/java', test classes go into
	 * 'src/test/java' instead of any dedicated '...tests' project.
	 */
	@Override
	protected String computeSrc(final SubProjectConfig project) {
		if (mavenLayout) return project.getRootPath() + "/" + "src/" + computeSourceSet(project) + "/java";
		return project.getRootPath() + "/" + "src";
	}

	/**
	 * In case of "Maven/Gradle" source layout the srcGen outlet is named 'src/main/xtext-gen', test-related srcGen
	 * classes go into 'src/test/xtext-gen' instead of any dedicated '...tests' project. Don't confuse it with
	 * 'src/main/xtend-gen'!
	 */
	@Override
	protected String computeSrcGen(final SubProjectConfig project) {
		if (mavenLayout) return project.getRootPath() + "/" + "src/" + computeSourceSet(project) + "/xtext-gen";
		return project.getRootPath() + "/" + "src-gen";
	}

	@Override
	protected String computeMetaInf(final SubProjectConfig project) {
		if (mavenLayout)
			return project.getRootPath() + "/" + "src/" + computeSourceSet(project) + "/resources/META-INF";
		return project.getRootPath() + "/" + "META-INF";
	}

	@Override
	protected String computeEcoreModel(final RuntimeProjectConfig project) {
		return project.getRootPath() + "/" + "model/generated";
	}

	@Override
	protected String computeAssets(final WebProjectConfig project) {
		if (mavenLayout) return project.getRootPath() + "/" + "src/" + computeSourceSet(project) + "/webapp";
		return project.getRootPath() + "/" + "WebRoot";
	}

	@Override
	protected String computeSourceSet(final SubProjectConfig project) {
		if (getTestProjects().contains(project)) return "test";
		return "main";
	}

	@Override
	protected String computeIcons(final SubProjectConfig project) {
		return project.getRootPath() + "/" + "icons";
	}

	@Override
	public boolean isMavenLayout() {
		return mavenLayout;
	}

	@Override
	public void setMavenLayout(final boolean mavenLayout) {
		this.mavenLayout = mavenLayout;
	}

	@Override
	public boolean isCreateEclipseMetaData() {
		return createEclipseMetaData;
	}

	@Override
	public void setCreateEclipseMetaData(final boolean createEclipseMetaData) {
		this.createEclipseMetaData = createEclipseMetaData;
	}

}
