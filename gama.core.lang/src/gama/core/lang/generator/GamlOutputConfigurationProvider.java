/*******************************************************************************************************
 *
 * GamlOutputConfigurationProvider.java, in gama.core.lang, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.lang.generator;

import static com.google.common.collect.Sets.newHashSet;
import java.util.Set;
import org.eclipse.xtext.generator.*;

/**
 * Class GamlOutputConfigurationProvider.
 *
 * @author drogoul
 * @since 4 janv. 2016
 *
 */
public class GamlOutputConfigurationProvider implements IOutputConfigurationProvider {

	/** The Constant META. */
	public final static String META = "METADATA_OUTPUT";

	/**
	 * Instantiates a new gaml output configuration provider.
	 */
	public GamlOutputConfigurationProvider() {}

	/**
	 * Method getOutputConfigurations()
	 * @see org.eclipse.xtext.generator.IOutputConfigurationProvider#getOutputConfigurations()
	 */
	@Override
	public Set<OutputConfiguration> getOutputConfigurations() {
		OutputConfiguration defaultOutput = new OutputConfiguration(META);
		defaultOutput.setDescription("Metadata Folder");
		defaultOutput.setCanClearOutputDirectory(true);
		defaultOutput.setOutputDirectory("./.metadata");
		defaultOutput.setOverrideExistingResources(true);
		defaultOutput.setCreateOutputDirectory(true);
		defaultOutput.setCleanUpDerivedResources(true);
		defaultOutput.setSetDerivedProperty(true);
		defaultOutput.setKeepLocalHistory(true);
		return newHashSet(defaultOutput);
	}

}
