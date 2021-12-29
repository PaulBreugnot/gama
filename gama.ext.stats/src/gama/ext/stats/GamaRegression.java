/*******************************************************************************************************
 *
 * GamaRegression.java, in gama.ext.stats, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ext.stats;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.commons.math3.stat.regression.RegressionResults;

import gama.common.interfaces.IValue;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.getter;
import gama.core.dev.annotations.GamlAnnotations.variable;
import gama.core.dev.annotations.GamlAnnotations.vars;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaListFactory;
import gama.util.IList;
import gama.util.matrix.GamaMatrix;
import gaml.operators.Cast;
import gaml.types.IType;
import gaml.types.Types;

@vars ({ @variable (
		name = "parameters",
		type = IType.LIST,
		of = IType.FLOAT,
		doc = { @doc ("List of regression coefficients (float) - same order as the variable in the input matrix ") }),
		@variable (
				name = "nb_features",
				type = IType.INT,
				doc = { @doc ("number of variables") }),
		@variable (
				name = "r_square",
				type = IType.FLOAT,
				doc = { @doc ("Estimated pearson's R-squared statistic") }),
		@variable (
				name = "residuals",
				type = IType.LIST,
				of = IType.FLOAT,
				doc = { @doc ("error terms associated to each observation of the sample") }) })
public class GamaRegression implements IValue {

	RegressionResults regressionResults;
	int nbFeatures;

	double param[];
	double error[];
	double rsquare;

	public GamaRegression(final IScope scope, final GamaMatrix<?> data) throws Exception {
		final OLSMultipleLinearRegression regressionMethod = new OLSMultipleLinearRegression();
		final int nbFeatures = data.numCols - 1;
		final int nbInstances = data.numRows;

		final double[] instances = new double[data.numCols * data.numRows];

		for (int i = 0; i < data.length(scope); i++) {
			instances[i] = Cast.asFloat(scope, data.getNthElement(i));
		}
		regressionMethod.newSampleData(instances, nbInstances, nbFeatures);
		param = regressionMethod.estimateRegressionParameters();
		rsquare = regressionMethod.calculateAdjustedRSquared();
	}

	public GamaRegression(final double[] param, final int nbFeatures, final RegressionResults regressionResults) {
		this.regressionResults = regressionResults;
		this.nbFeatures = nbFeatures;
		this.param = param;
	}

	public Double predict(final IScope scope, final IList<?> instance) {
		if (param == null) return null;
		double val = param[0];
		for (int i = 1; i < param.length; i++) {
			val += param[i] * Cast.asFloat(scope, instance.get(i - 1));
		}
		return val;
	}

	@getter ("parameters")
	public IList<Double> getParameters() {
		if (param == null) return GamaListFactory.create(Types.FLOAT);
		final IList<Double> vals = GamaListFactory.create(Types.FLOAT);
		for (final double element : param) {
			vals.add(element);
		}
		return vals;
	}

	@getter ("residuals")
	public IList<Double> getResiduals() {
		IList<Double> res = GamaListFactory.create(Types.FLOAT);
		if (error != null) {
			for (double e : error) {
				res.add(e);
			}
		}
		return res;
	}

	@getter ("r_square")
	public double getRSquare() { return rsquare; }

	@getter ("nb_features")
	public Integer getNbFeatures() { return nbFeatures; }

	@Override
	public String serialize(final boolean includingBuiltIn) {
		return stringValue(null);
	}

	@Override
	public IType<?> getGamlType() { return Types.get(IType.REGRESSION); }

	@Override
	public String stringValue(final IScope scope) throws GamaRuntimeException {
		if (param == null) return "no function";
		StringBuilder st = new StringBuilder("y = ").append(param[0]);
		for (int i = 1; i < param.length; i++) {
			st.append(" + ").append(param[i]).append(" x").append(i);
		}
		return st.toString();
	}

	@Override
	public IValue copy(final IScope scope) throws GamaRuntimeException {
		return new GamaRegression(param.clone(), nbFeatures, regressionResults);
	}

}
