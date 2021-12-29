/*
 *
 */
package gama.ext.traffic.publictransport;

import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.example;
import gama.core.dev.annotations.GamlAnnotations.no_test;
import gama.core.dev.annotations.GamlAnnotations.operator;
import gama.core.dev.annotations.GamlAnnotations.usage;
import gama.core.dev.annotations.IOperatorCategory;
import gama.core.dev.annotations.ITypeProvider;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.runtime.IScope;
import gama.util.IContainer;

// TODO: Auto-generated Javadoc
/**
 * The Class Operators.
 */
public class Operators {
	// TODO: find out why this is necessary in ESCAPE
	/**
	 * Closest to.
	 *
	 * @param scope
	 *            the scope
	 * @param list
	 *            the list
	 * @param shape
	 *            the shape
	 * @return the i shape
	 */
	// If I use the built-in `closest_to`, ESCAPE would throw an error
	@operator (
			value = "closest_tob",
			content_type = ITypeProvider.CONTENT_TYPE_AT_INDEX + 1,
			category = { IOperatorCategory.SPATIAL },
			concept = {})
	@doc (
			value = "Return the closest agent from a point !!",
			usages = { @usage (
					value = "Return the closest agent from a point !!") },
			examples = { @example (
					value = "closest_tob(population, point) or list closest_tob geometry",
					equals = "Return the closest agent from a point !!",
					test = false) })
	@no_test
	public static IShape closest_to(final IScope scope, final IContainer<?, ? extends IShape> list,
			final IShape shape) {
		return closest(list.iterable(scope), shape);
	}

	/**
	 * Closest.
	 *
	 * @param collection
	 *            the collection
	 * @param shape
	 *            the shape
	 * @return the i shape
	 */
	public static IShape closest(final Iterable<? extends IShape> collection, final IShape shape) {
		IShape closest1 = null;
		double min = Double.MAX_VALUE; // 356 -> 373ms

		GamaPoint point = shape.getLocation();
		for (IShape s : collection) {
			double ax = s.getLocation().getX();
			double ay = s.getLocation().getY();
			double dist = (ax - point.getX()) * (ax - point.getX()) + (ay - point.getY()) * (ay - point.getY());
			if (min > dist) {
				closest1 = s;
				min = dist;
			}
		}

		return closest1;
	}
}