/*******************************************************************************************************
 *
 * GamlFile.java, in gama.core.lang, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.lang.resource;

import org.eclipse.emf.common.util.URI;

import gama.common.geometry.Envelope3D;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.example;
import gama.core.dev.annotations.GamlAnnotations.file;
import gama.core.lang.validation.GamlModelBuilder;
import gama.kernel.experiment.IExperimentPlan;
import gama.kernel.model.IModel;
import gama.outputs.IOutput;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaListFactory;
import gama.util.IList;
import gama.util.IMap;
import gama.util.file.GamaFile;
import gaml.descriptions.ModelDescription;
import gaml.expressions.IExpression;
import gaml.operators.Cast;
import gaml.types.IContainerType;
import gaml.types.IType;
import gaml.types.Types;

/**
 * Written by drogoul Modified on 13 nov. 2011
 *
 * @todo Description
 *
 */
@file (
		name = "gaml",
		extensions = { "gaml", "experiment" },
		buffer_type = IType.LIST,
		buffer_content = IType.SPECIES,
		buffer_index = IType.INT,
		concept = { IConcept.FILE },
		doc = @doc ("Represents GAML model files"))
@SuppressWarnings ({ "unchecked", "rawtypes" })
public class GamlFile extends GamaFile<IList<IModel>, IModel> {

	/** The mymodel. */
	private final IModel mymodel;
	
	/**
	 * The experiment name.
	 *
	 */
	private final String experimentName;

	/** The alias name. */
	private final String aliasName;

	/**
	 * Instantiates a new gaml file.
	 *
	 * @param scope the scope
	 * @param pathName the path name
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	@doc (
			value = "This file constructor allows to read a gaml file (.gaml)",
			examples = { @example (
					value = "file f <- gaml_file(\"file.gaml\");",
					isExecutable = false) })
	public GamlFile(final IScope scope, final String pathName) throws GamaRuntimeException {
		super(scope, pathName);
		experimentName = "";
		aliasName = "";
		mymodel = GamlModelBuilder.getDefaultInstance().compile(URI.createURI(getPath(scope), false), null);
	}

	@Override
	public IContainerType getGamlType() {
		return Types.FILE.of(Types.INT, Types.SPECIES);
	}

	/**
	 * Instantiates a new gaml file.
	 *
	 * @param scope the scope
	 * @param pathName the path name
	 * @param expName the exp name
	 * @param cName the c name
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	@doc (
			value = "This file constructor allows to compile a gaml file and run an experiment",
			examples = { @example (
					value = "file f <- gaml_file(\"file.gaml\", \"my_experiment\", \"my_model\");",
					isExecutable = false) })
	public GamlFile(final IScope scope, final String pathName, final String expName, final String cName)
			throws GamaRuntimeException {
		super(scope, pathName);
		experimentName = expName;
		aliasName = cName;
		mymodel = GamlModelBuilder.getDefaultInstance().compile(URI.createURI(getPath(scope), false), null);
		((ModelDescription) mymodel.getDescription()).setAlias(aliasName);
	}

	@Override
	public IList<String> getAttributes(final IScope scope) {
		return GamaListFactory.EMPTY_LIST;
	}

	/**
	 * Creates the experiment.
	 *
	 * @param expName the exp name
	 * @return the i experiment plan
	 */
	public IExperimentPlan createExperiment(final String expName) {
		final IExperimentPlan exp = mymodel.getExperiment("Experiment " + expName);
		for (final IOutput o : exp.getOriginalSimulationOutputs()) {
			o.setName(o.getName() + "#" + aliasName);
		}
		for (final IOutput o : exp.getExperimentOutputs()) {
			o.setName(o.getName() + "#" + aliasName);
		}

		// GAMA.addGuiExperiment(exp);

		return exp;
	}

	/**
	 * Execute.
	 *
	 * @param scope the scope
	 * @param with_exp the with exp
	 * @param param_input the param input
	 * @param param_output the param output
	 * @param reset the reset
	 * @param repeat the repeat
	 * @param stopCondition the stop condition
	 * @param share the share
	 */
	public void execute(final IScope scope, final IExpression with_exp, final IExpression param_input,
			final IExpression param_output, final IExpression reset, final IExpression repeat,
			final IExpression stopCondition, final IExpression share) {
		final IExperimentPlan experiment = createExperiment(experimentName);

		if (param_input != null) {
			final IMap in = Cast.asMap(scope, param_input.value(scope), true);
			for (int i = 0; i < in.getKeys().size(); i++) {
				experiment.getModel().getVar(in.getKeys().get(i).toString()).setValue(null, in.getValues().get(i));
			}
		}
		GAMA.openExperimentFromGamlFile(experiment);
	}

	/**
	 * @see msi.gama.util.GamaFile#fillBuffer()
	 */
	@Override
	protected void fillBuffer(final IScope scope) throws GamaRuntimeException {
		if (getBuffer() != null) { return; }
		setBuffer(GamaListFactory.<IModel> create(Types.SPECIES));
		((IList) getBuffer()).add(mymodel.getSpecies());
	}

	@Override
	public Envelope3D computeEnvelope(final IScope scope) {
		return null;
	}

}
