/*
 * 
 */
package gama.ext.genstar.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

import core.metamodel.entity.AGeoEntity;
import core.metamodel.value.IValue;
import gama.ext.genstar.utils.GenStarConstant.SpatialConstraint;
import spll.localizer.constraint.ISpatialConstraint;
import spll.localizer.constraint.SpatialConstraintMaxDensity;
import spll.localizer.constraint.SpatialConstraintMaxDistance;
import spll.localizer.constraint.SpatialConstraintMaxNumber;

// TODO: Auto-generated Javadoc
/**
 * Helper in order to build constraint for localization process using a proxy (i.e. store all variable until actual
 * creation)
 * 
 * @author kevinchapuis
 *
 */
public class GenStarGamaConstraintBuilder {

	/** The constraints. */
	private final Collection<SpatialConstraint> constraints;

	/** The localizer. */
	boolean localizer = false;
	
	/** The Constant LOCALISAZATION_DEFAULT_STEP. */
	static final double LOCALISAZATION_DEFAULT_STEP = 10d;
	
	/** The localization feature. */
	String localizationFeature;
	
	/** The localization attribute. */
	String localizationAttribute;
	
	/** The localization limit. */
	double localizationLimit;
	
	/** The localization step. */
	double localizationStep;
	
	/** The localization priority. */
	int localizationPriority;

	/** The Constant DENSITY_DEFAULT_STEP. */
	static final double DENSITY_DEFAULT_STEP = 0.1;
	
	/** The density feature. */
	String densityFeature;
	
	/** The density constant. */
	double densityConstant;
	
	/** The density limit. */
	double densityLimit;
	
	/** The density step. */
	double densityStep;
	
	/** The density priority. */
	int densityPriority;

	/** The Constant CAPACITY_DEFAULT_STEP. */
	static final int CAPACITY_DEFAULT_STEP = 1;
	
	/** The capacity feature. */
	String capacityFeature;
	
	/** The capacity constant. */
	int capacityConstant;
	
	/** The capacity limit. */
	int capacityLimit;
	
	/** The capacity step. */
	int capacityStep;
	
	/** The capacity priority. */
	int capacityPriority;

	/** The Constant DISTANCE_DEFAULT_STEP. */
	static final double DISTANCE_DEFAULT_STEP = 1d;
	
	/** The distance constant. */
	private double distanceConstant;
	
	/** The distance limit. */
	private double distanceLimit;
	
	/** The distance step. */
	private double distanceStep;
	
	/** The distance priority. */
	private int distancePriority;

	/**
	 * Instantiates a new gen star gama constraint builder.
	 */
	public GenStarGamaConstraintBuilder() {
		this.constraints = new HashSet<>();
	}

	/**
	 * Get the constraints that have been setup to be created by this builder.
	 *
	 * @return the constraints
	 */
	public Collection<SpatialConstraint> getConstraints() {
		return Collections.unmodifiableCollection(this.constraints);
	}

	/**
	 * Test if any constraint have been setup to be created by the builder.
	 *
	 * @return true, if successful
	 */
	public boolean hasConstraints() {
		return !this.constraints.isEmpty();
	}

	/**
	 * Build all the specified constraints at once !.
	 *
	 * @param nests the nests
	 * @return The Collection (HashSet) of {@link ISpatialConstraint} built
	 * @throws IllegalStateException the illegal state exception
	 */
	public Collection<ISpatialConstraint> buildConstraints(
			final Collection<? extends AGeoEntity<? extends IValue>> nests) throws IllegalStateException {
		if (!hasConstraints())
			throw new IllegalStateException("You must have at least one constraint setup to use the builder");
		Collection<ISpatialConstraint> buildConstraints = new HashSet<>();
		for (SpatialConstraint sc : this.constraints) {
			switch (sc) {
				case DENSITY:
					buildConstraints.add(densityFeature == null || densityFeature.isEmpty()
							? this.getConstantDensityConstraint(nests) : this.getFeatureDensityConstraint(nests));
					break;
				case CAPACITY:
					buildConstraints.add(capacityFeature == null || capacityFeature.isEmpty()
							? this.getConstantCapacityConstraint(nests) : this.getFeatureCapacityConstraint(nests));
					break;
				case DISTANCE:
					buildConstraints.add(this.getDistanceConstraint(nests));
					break;
				default:
					throw new IllegalArgumentException("Trying to build an unkown spatial constraint " + sc);
			}
		}
		return buildConstraints;
	}

	/**
	 * Allocate all density constraint variables to build one from using
	 * {@link #getDensityConstraint(Collection, String)} or {@link #getDensityConstraint(Collection)}.
	 *
	 * @param feature the feature
	 * @param constant            : double value to be the constant constraint for all spatial entities
	 * @param limit            : the limit not to overcome when release constraint
	 * @param step the step
	 * @param priority            : the priority of the constraint over other constraints (integer value)
	 */
	public void addDensityConstraint(final String feature, final double constant, final double limit, final double step,
			final int priority) {
		this.densityFeature = feature;
		this.densityConstant = constant;
		this.densityLimit = limit;
		this.densityStep = step > 0 ? step : DENSITY_DEFAULT_STEP;
		this.densityPriority = priority;
		this.constraints.add(SpatialConstraint.DENSITY);
	}

	/**
	 * Build and return a density constraint based on variables passed by mehtod
	 * {@link #addDensityConstraint(double, double, int)}.
	 *
	 * @param nests            : the list of spatial entities known as nest
	 * @return {@link ISpatialConstraint}
	 */
	public ISpatialConstraint
			getFeatureDensityConstraint(final Collection<? extends AGeoEntity<? extends IValue>> nests) {
		SpatialConstraintMaxDensity sc = new SpatialConstraintMaxDensity(nests, densityFeature);
		sc.setMaxIncrease(densityLimit);
		sc.setPriority(densityPriority);
		return sc;
	}

	/**
	 * Build and return a density constraint based on variables passed by mehtod
	 * {@link #addDensityConstraint(double, double, int)}.
	 *
	 * @param nests            : the list of spatial entities known as nest
	 * @return {@link ISpatialConstraint}
	 */
	public ISpatialConstraint
			getConstantDensityConstraint(final Collection<? extends AGeoEntity<? extends IValue>> nests) {
		SpatialConstraintMaxDensity sc = new SpatialConstraintMaxDensity(nests, densityConstant);
		sc.setMaxIncrease(densityLimit);
		sc.setIncreaseStep(densityStep);
		sc.setPriority(densityPriority);
		return sc;
	}

	/**
	 * Allocate all capacity constraint variables to build one from using
	 * {@link #getCapacityConstraint(Collection, String)} or {@link #getCapacityConstraint(Collection)}.
	 *
	 * @param feature the feature
	 * @param constant the constant
	 * @param limit the limit
	 * @param step the step
	 * @param priority the priority
	 */
	public void addCapacityConstraint(final String feature, final int constant, final int limit, final int step,
			final int priority) {
		this.capacityFeature = feature;
		this.capacityConstant = constant;
		this.capacityLimit = limit;
		this.capacityStep = step > 0 ? step : CAPACITY_DEFAULT_STEP;
		this.capacityPriority = priority;
		this.constraints.add(SpatialConstraint.CAPACITY);
	}

	/**
	 * Build and return a density constraint based on variables passed by mehtod
	 * {@link #addCapacityConstraint(double, double, int)}.
	 *
	 * @param nests            : the list of spatial entities known as nest
	 * @return {@link ISpatialConstraint}
	 */
	public ISpatialConstraint
			getFeatureCapacityConstraint(final Collection<? extends AGeoEntity<? extends IValue>> nests) {
		SpatialConstraintMaxNumber sc = new SpatialConstraintMaxNumber(nests, capacityFeature);
		sc.setMaxIncrease(capacityLimit);
		sc.setPriority(capacityPriority);
		return sc;
	}

	/**
	 * Build and return a density constraint based on variables passed by mehtod
	 * {@link #addDensityConstraint(double, double, int)}.
	 *
	 * @param nests            : the list of spatial entities known as nest
	 * @return {@link ISpatialConstraint}
	 */
	public ISpatialConstraint
			getConstantCapacityConstraint(final Collection<? extends AGeoEntity<? extends IValue>> nests) {
		SpatialConstraintMaxNumber sc = new SpatialConstraintMaxNumber(nests, capacityConstant * 1d);
		sc.setMaxIncrease(capacityLimit);
		sc.setIncreaseStep(capacityStep);
		sc.setPriority(capacityPriority);
		return sc;
	}

	/**
	 * Allocate all capacity constraint variables to build one from using
	 * {@link #getCapacityConstraint(Collection, String)} or {@link #getCapacityConstraint(Collection)}.
	 *
	 * @param constant the constant
	 * @param limit the limit
	 * @param step the step
	 * @param priority the priority
	 */
	public void addDistanceConstraint(final double constant, final double limit, final double step,
			final int priority) {
		this.distanceConstant = constant;
		this.distanceLimit = limit;
		this.distanceStep = step > 0 ? step : DISTANCE_DEFAULT_STEP;
		this.distancePriority = priority;
		this.constraints.add(SpatialConstraint.DISTANCE);
	}

	/**
	 * Build and return a density constraint based on variables passed by mehtod
	 * {@link #addCapacityConstraint(double, double, int)}.
	 *
	 * @param nests            : the list of spatial entities known as nest
	 * @return {@link ISpatialConstraint}
	 */
	public ISpatialConstraint getDistanceConstraint(final Collection<? extends AGeoEntity<? extends IValue>> nests) {
		SpatialConstraintMaxDistance sc =
				new SpatialConstraintMaxDistance(nests.stream().collect(Collectors.toList()), distanceConstant);
		sc.setMaxIncrease(distanceLimit);
		sc.setIncreaseStep(distanceStep);
		sc.setPriority(distancePriority);
		return sc;
	}

	/**
	 * Add setup for localization constraint, also referred as '<it>matcher</it>' !.
	 *
	 * @param feature the feature
	 * @param attribute the attribute
	 * @param limit the limit
	 * @param step the step
	 * @param priority the priority
	 */
	public void addLocalizationConstraint(final String feature, final String attribute, final double limit,
			final double step, final int priority) {
		localizer = true;
		this.localizationFeature = feature;
		this.localizationAttribute = attribute;
		this.localizationLimit = limit;
		this.localizationStep = step;
		this.localizationPriority = priority;
	}

	/**
	 * if the localizer has been setup return true, return false otherwise.
	 *
	 * @return true, if successful
	 */
	public boolean hasLocalizerReleaseOption() {
		return localizer;
	}

	/**
	 * The name of the localization feature in GIS files/geometries.
	 *
	 * @return the localization feature
	 */
	public String getLocalizationFeature() { return localizationFeature; }

	/**
	 * The name of the entity attribute in synthetic population.
	 *
	 * @return the localization attribute
	 */
	public String getLocalizationAttribute() { return localizationAttribute; }

	/**
	 * The limit to extends geometry of localization constraint.
	 *
	 * @return the localization limit
	 */
	public double getLocalizationLimit() { return localizationLimit; }

	/**
	 * The step to increase the size of the geometry of localization constraint.
	 *
	 * @return the localization step
	 */
	public double getLocalizationStep() { return localizationStep; }

	/**
	 * The priority of the localization constraint.
	 *
	 * @return the localization priority
	 */
	public int getLocalizationPriority() { return localizationPriority; }

}