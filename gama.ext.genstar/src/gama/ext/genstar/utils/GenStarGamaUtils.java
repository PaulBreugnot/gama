/*******************************************************************************************************
 *
 * GenStarGamaUtils.java, in gama.ext.genstar, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ext.genstar.utils;

import java.io.FileNotFoundException;
import java.util.List;

import core.metamodel.attribute.Attribute;
import core.metamodel.io.GSSurveyType;
import core.metamodel.io.GSSurveyWrapper;
import core.metamodel.value.IValue;
import core.metamodel.value.binary.BooleanValue;
import core.metamodel.value.numeric.ContinuousValue;
import core.metamodel.value.numeric.IntegerValue;
import core.metamodel.value.numeric.RangeValue;
import core.util.data.GSEnumDataType;
import gama.ext.genstar.generator.FileBasedGenerator;
import gama.ext.genstar.generator.IGenstarGenerator;
import gama.ext.genstar.generator.MatrixBasedGenerator;
import gama.ext.genstar.type.GamaRange;
import gama.ext.genstar.type.GamaRangeType;
import gama.ext.genstar.utils.GenStarConstant.GenerationAlgorithm;
import gama.ext.genstar.utils.GenStarConstant.InputDataType;
import gama.ext.genstar.utils.GenStarConstant.SpatialDistribution;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.file.GamaCSVFile;
import gaml.types.IType;
import gospl.algo.IGosplConcept;
import old.OldGenstarGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class GenStarGamaUtils.
 */
public class GenStarGamaUtils {

	/**
	 * The spatial distribution available in the Genstar API.
	 *
	 * @param distribution
	 *            the distribution
	 * @return the spatial distribution
	 */
	public static SpatialDistribution toSpatialDistribution(final String distribution) {
		if (SpatialDistribution.AREA.getMatch(distribution)) return SpatialDistribution.AREA;
		if (SpatialDistribution.CAPACITY.getMatch(distribution)) return SpatialDistribution.CAPACITY;
		if (SpatialDistribution.DENSITY.getMatch(distribution)) return SpatialDistribution.DENSITY;
		return null;
	}

	/**
	 * The generation algorithm given by the Genstar API.
	 *
	 * @param algo
	 *            the algo
	 * @return the i gospl concept. E gospl algorithm
	 */
	public static IGosplConcept.EGosplAlgorithm toGosplAlgorithm(final String algo) {
		if (GenerationAlgorithm.DIRECTSAMPLING.getMatch(algo)) return IGosplConcept.EGosplAlgorithm.DS;
		if (GenerationAlgorithm.HIERARCHICALSAMPLING.getMatch(algo)) return IGosplConcept.EGosplAlgorithm.HS;
		if (GenerationAlgorithm.UNIFORMSAMPLING.getMatch(algo)) return IGosplConcept.EGosplAlgorithm.US;
		return null;
	}

	/**
	 * Gives the Genstar type from a Gama type.
	 *
	 * @param type
	 *            the type
	 * @param ordered
	 *            the ordered
	 * @return the GS enum data type
	 */
	@SuppressWarnings ("rawtypes")
	public static GSEnumDataType toDataType(final IType type, final boolean ordered) {
		int t = type.id();
		switch (t) {
			case IType.FLOAT:
				return GSEnumDataType.Continue;
			case IType.INT:
				return GSEnumDataType.Integer;
			case IType.BOOL:
				return GSEnumDataType.Boolean;
			case GamaRangeType.id:
				return GSEnumDataType.Range;
			default:
				break;
		}
		if (ordered) return GSEnumDataType.Order;
		return GSEnumDataType.Nominal;
	}

	/**
	 * Get Genstar API Survey type enum representation.
	 *
	 * @param type
	 *            the type
	 * @return the GS survey type
	 */
	public static GSSurveyType toSurveyType(final String type) {
		if (InputDataType.CONTINGENCY.getMatch(type)) return GSSurveyType.ContingencyTable;
		if (InputDataType.FREQUENCY.getMatch(type)) return GSSurveyType.GlobalFrequencyTable;
		if (InputDataType.LOCAL.getMatch(type)) return GSSurveyType.LocalFrequencyTable;
		if (InputDataType.SAMPLE.getMatch(type)) return GSSurveyType.Sample;
		return null;
	}

	/**
	 * Get a @GSSurveyWrapper from a gama csv file.
	 *
	 * @param scope
	 *            the scope
	 * @param survey
	 *            the survey
	 * @param atts
	 *            the atts
	 * @return the GS survey wrapper
	 */
	public static GSSurveyWrapper toSurveyWrapper(final IScope scope, final GamaCSVFile survey,
			final List<Attribute<? extends IValue>> atts) {
		GenStarGamaSurveyUtils gsg = null;
		try {
			gsg = new GenStarGamaSurveyUtils(scope, survey, atts);
		} catch (FileNotFoundException e) {
			GamaRuntimeException.create(e, scope);
		}
		GSSurveyType gsType = GenStarGamaUtils.inferSurveyType(scope, gsg);
		return new GSSurveyWrapper(gsg.getPath(), gsType, gsg.getDelimiter(), 1, 1);
	}

	/**
	 * Retrieve (smartly) the type of data from the data itself
	 *
	 * TODO : find something specific for samples, e.g. the case where every attribute of agent is a int proxy value
	 *
	 * @param scope
	 *            the scope
	 * @param gsg
	 *            the gsg
	 * @return the GS survey type
	 */
	public static GSSurveyType inferSurveyType(final IScope scope, final GenStarGamaSurveyUtils gsg) {
		switch (gsg.inferDataType().id()) {
			case IType.INT:
				return GSSurveyType.ContingencyTable;
			case IType.FLOAT:
				if (Math.abs(gsg.getTotalData() - 1.0) < GenStarConstant.EPSILON
						|| Math.abs(gsg.getTotalData() - 100.0) < GenStarConstant.EPSILON)
					return GSSurveyType.GlobalFrequencyTable;
				else
					return GSSurveyType.LocalFrequencyTable;
			case IType.STRING:
			case IType.NONE:
				return GSSurveyType.Sample;
			default:
				throw new IllegalArgumentException("Unexpected value: " + gsg.inferDataType().asPattern());
		}
	}

	/**
	 * From a Genstar value to a Gama value.
	 *
	 * @param scope
	 *            the scope
	 * @param val
	 *            the val
	 * @param checkEmpty
	 *            the check empty
	 * @return the object
	 */
	public static Object toGAMAValue(final IScope scope, final IValue val, final boolean checkEmpty) {
		GSEnumDataType type = val.getType();
		if (checkEmpty && val.equals(val.getValueSpace().getEmptyValue()))
			return toGAMAValue(scope, val.getValueSpace().getEmptyValue(), false);
		if (type == GSEnumDataType.Boolean) return ((BooleanValue) val).getActualValue();
		if (type == GSEnumDataType.Continue) {
			if (val instanceof RangeValue) return toGAMARange(val);
			return ((ContinuousValue) val).getActualValue();
		}
		if (type == GSEnumDataType.Integer) {
			if (val instanceof RangeValue) return toGAMARange(val);
			return ((IntegerValue) val).getActualValue();
		}
		if (type == GSEnumDataType.Range) return toGAMARange(val);
		return val.getStringValue();
	}

	/**
	 * ???.
	 *
	 * @param val
	 *            the val
	 * @return the gama range
	 */
	static GamaRange toGAMARange(final IValue val) {
		RangeValue rVal = (RangeValue) val;
		return new GamaRange(rVal.getBottomBound().doubleValue(), rVal.getTopBound().doubleValue());
	}

	/**
	 * To GAMA value.
	 *
	 * @param scope
	 *            the scope
	 * @param valueForAttribute
	 *            the value for attribute
	 * @param checkEmpty
	 *            the check empty
	 * @param type
	 *            the type
	 * @return the object
	 */
	@SuppressWarnings ("rawtypes")
	public static Object toGAMAValue(final IScope scope, final IValue valueForAttribute, final boolean checkEmpty,
			final IType type) {
		Object gamaValue = toGAMAValue(scope, valueForAttribute, checkEmpty);
		if (type != null && gamaValue instanceof GamaRange) return ((GamaRange) gamaValue).cast(scope, type);
		return gamaValue;
	}

	/**
	 * Gets the gama generator.
	 *
	 * @return the gama generator
	 */
	public static IGenstarGenerator[] getGamaGenerator() {

		return new IGenstarGenerator[] { FileBasedGenerator.getInstance(), MatrixBasedGenerator.getInstance(),
				OldGenstarGenerator.getInstance() };
	}

	/*
	 * public static GamaGraph<IAgent,IShape> toGAMAGraph(IScope scope, SpinNetwork net, GamaPopGenerator gen) {
	 * IType<?> nodeType ;
	 * 
	 * Optional<IAgent> first = gen.getAgents().stream().findFirst(); if (first.isPresent()) { nodeType =
	 * first.get().getGamlType(); } else { return null; }
	 * 
	 * GamaGraph<IAgent,IShape> gamaNetwork = new GamaGraph<>(scope, net.isDirected(),nodeType,Types.GEOMETRY);
	 * 
	 * for(IAgent agt : gen.getAgents()) { gamaNetwork.addVertex(agt); }
	 * 
	 * for(Edge e : net.getLinks()) { IAgent sourceAgt = gen.getAgent(net.getDemoEntityNode(e.getNode0())); IAgent
	 * targetAgt = gen.getAgent(net.getDemoEntityNode(e.getNode1()));
	 * 
	 * gamaNetwork.addEdge(sourceAgt, targetAgt); }
	 * 
	 * return gamaNetwork; }
	 */

}
