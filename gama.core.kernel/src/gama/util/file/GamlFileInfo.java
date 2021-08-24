/*******************************************************************************************************
 *
 * GamlFileInfo.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util.file;

import static java.util.Arrays.asList;
import static org.apache.commons.lang.StringUtils.join;
import static org.apache.commons.lang.StringUtils.splitByWholeSeparatorPreserveAllTokens;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * The Class GamlFileInfo.
 */
public class GamlFileInfo extends GamaFileMetaData {

	/** The batch prefix. */
	public static String BATCH_PREFIX = "***";
	
	/** The errors. */
	public static String ERRORS = "errors detected";

	/** The experiments. */
	private final Collection<String> experiments;
	
	/** The imports. */
	private final Collection<String> imports;
	
	/** The uses. */
	private final Collection<String> uses;
	
	/** The tags. */
	private final Collection<String> tags;
	
	/** The invalid. */
	public final boolean invalid;

	/**
	 * Instantiates a new gaml file info.
	 *
	 * @param stamp the stamp
	 * @param imports the imports
	 * @param uses the uses
	 * @param exps the exps
	 * @param tags the tags
	 */
	public GamlFileInfo(final long stamp, final Collection<String> imports, final Collection<String> uses,
			final Collection<String> exps, final Collection<String> tags) {
		super(stamp);
		invalid = stamp == Long.MAX_VALUE;
		this.imports = imports;
		this.uses = uses;
		this.experiments = exps;
		this.tags = tags;
	}

	/**
	 * Gets the imports.
	 *
	 * @return the imports
	 */
	public Collection<String> getImports() {
		return imports == null ? Collections.EMPTY_LIST : imports;
	}

	/**
	 * Gets the uses.
	 *
	 * @return the uses
	 */
	public Collection<String> getUses() {
		return uses == null ? Collections.EMPTY_LIST : uses;
	}

	/**
	 * Gets the tags.
	 *
	 * @return the tags
	 */
	public Collection<String> getTags() {
		return tags == null ? Collections.EMPTY_LIST : tags;
	}

	/**
	 * Gets the experiments.
	 *
	 * @return the experiments
	 */
	public Collection<String> getExperiments() {
		return experiments == null ? Collections.EMPTY_LIST : experiments;
	}

	/**
	 * Instantiates a new gaml file info.
	 *
	 * @param propertyString the property string
	 */
	public GamlFileInfo(final String propertyString) {
		super(propertyString);
		final String[] values = split(propertyString);
		int size = values.length;
		final List<String> imports = asList(splitByWholeSeparatorPreserveAllTokens(values[1], SUB_DELIMITER));
		this.imports = imports == null || imports.isEmpty() || imports.contains(null) ? null : imports;
		final List<String> uses = asList(splitByWholeSeparatorPreserveAllTokens(values[2], SUB_DELIMITER));
		this.uses = uses == null || uses.isEmpty() || uses.contains(null) ? null : uses;
		final List<String> exps = asList(splitByWholeSeparatorPreserveAllTokens(values[3], SUB_DELIMITER));
		this.experiments = exps == null || exps.isEmpty() || exps.contains(null) ? null : exps;
		final List<String> tags =
				size < 5 ? null : asList(splitByWholeSeparatorPreserveAllTokens(values[4], SUB_DELIMITER));
		this.tags = tags == null || tags.isEmpty() || tags.contains(null) ? null : tags;
		invalid = size > 5 ? values[5].equals("TRUE") : values[4].equals("TRUE");
	}

	/**
	 * Method getSuffix()
	 *
	 * @see msi.gama.util.file.GamaFileMetaInformation#getSuffix()
	 */
	@Override
	public String getSuffix() {
		if (invalid)
			return ERRORS;
		final int expCount = experiments == null ? 0 : experiments.size();
		if (expCount > 0) { return "" + (expCount == 1 ? "1 experiment" : expCount + " experiments"); }

		return "no experiment";
	}

	@Override
	public void appendSuffix(final StringBuilder sb) {
		if (invalid) {
			sb.append(ERRORS);
			return;
		}
		final int expCount = experiments == null ? 0 : experiments.size();
		if (expCount > 0) {
			sb.append(expCount).append(" experiment");
			if (expCount > 1)
				sb.append("s");
		} else
			sb.append("no experiment");
	}

	@Override
	public String toPropertyString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(super.toPropertyString()).append(DELIMITER);
		sb.append(imports == null ? "" : join(imports, SUB_DELIMITER)).append(DELIMITER);
		sb.append(uses == null ? "" : join(uses, SUB_DELIMITER)).append(DELIMITER);
		sb.append(experiments == null ? "" : join(experiments, SUB_DELIMITER)).append(DELIMITER);
		sb.append(tags == null ? "" : join(tags, SUB_DELIMITER)).append(DELIMITER);
		sb.append(invalid ? "TRUE" : "FALSE").append(DELIMITER);
		return sb.toString();

	}

	@Override
	public String getDocumentation() {
		return "GAML model file with " + getSuffix();
	}

}