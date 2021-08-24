/*******************************************************************************************************
 *
 * Signature.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.types;

import java.util.Arrays;

import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;

/**
 * The Class Signature.
 */
@SuppressWarnings ({ "unchecked", "rawtypes" })

public class Signature {

	/** The list. */
	final IType[] list;

	/**
	 * Var arg from.
	 *
	 * @param sig the sig
	 * @return the signature
	 */
	public static Signature varArgFrom(final Signature sig) {
		return new Signature(Types.LIST.of(GamaType.findCommonType(sig.list)));
	}

	/**
	 * Instantiates a new signature.
	 *
	 * @param types the types
	 */
	public Signature(final IType... types) {
		list = types;
	}

	/**
	 * Instantiates a new signature.
	 *
	 * @param types the types
	 */
	public Signature(final int[] types) {
		list = new IType[types.length];
		for (int i = 0; i < list.length; i++) {
			list[i] = Types.get(types[i]);
		}
	}

	/**
	 * Instantiates a new signature.
	 *
	 * @param objects the objects
	 */
	public Signature(final IExpression... objects) {
		list = new IType[objects.length];
		for (int i = 0; i < list.length; i++) {
			final IExpression o = objects[i];
			list[i] = o == null ? Types.NO_TYPE : o.getGamlType();
		}
	}

	/**
	 * Instantiates a new signature.
	 *
	 * @param objects the objects
	 */
	public Signature(final Class... objects) {
		list = new IType[objects.length];
		for (int i = 0; i < list.length; i++) {
			list[i] = Types.get(objects[i]);
		}
	}

	/**
	 * Simplified.
	 *
	 * @return the signature
	 */
	public Signature simplified() {
		// returns a signature that does not contain any parametric types
		final IType[] copy = Arrays.copyOf(list, list.length);
		for (int i = 0; i < copy.length; i++) {
			copy[i] = copy[i].getGamlType();
		}
		return new Signature(copy);
	}

	/**
	 * Matches desired signature.
	 *
	 * @param types the types
	 * @return true, if successful
	 */
	public boolean matchesDesiredSignature(final IType... types) {
		if (types.length != list.length) { return false; }
		for (int i = 0; i < list.length; i++) {
			final IType ownType = list[i];
			final IType desiredType = types[i];
			if (!Types.intFloatCase(ownType, desiredType) && !desiredType.isAssignableFrom(ownType)) { return false; }
		}
		return true;
	}

	// public boolean isCompatibleWith(final IType... types) {
	// if (types.length != list.length) {
	// return false;
	// }
	// for (int i = 0; i < list.length; i++) {
	// if (!list[i].isTranslatableInto(types[i])) {
	// return false;
	// }
	// }
	// return true;
	// }

	/**
	 * Matches desired signature.
	 *
	 * @param types the types
	 * @return true, if successful
	 */
	public boolean matchesDesiredSignature(final Signature types) {
		return matchesDesiredSignature(types.list);
	}

	/**
	 * Distance to.
	 *
	 * @param types the types
	 * @return the int
	 */
	public int distanceTo(final IType... types) {
		if (types.length != list.length) { return Integer.MAX_VALUE; }
		// int dist = 0;
		int max = 0;
		int min = Integer.MAX_VALUE;
		// for (int i = 0; i < list.length; i++) {
		// // 19/02/14 Now using the maximum distance between two types of the
		// // signature instead of addition.
		// final int d = types[i].distanceTo(list[i]);
		// if (d > dist) {
		// dist = d;
		// }
		// // dist += types[i].distanceTo(list[i]);
		// }
		// We now take into account the min and the max (see #2266 and the case where [unknown, geometry, geometry] was
		// preffered to [topology, geometry, geometry] for an input of [topology, a_species, a_species])
		for (int i = 0; i < list.length; i++) {
			final int d = types[i].distanceTo(list[i]);
			if (max < d) {
				max = d;
			}
			if (min > d) {
				min = d;
			}
		}
		return min + max;
	}

	/**
	 * Distance to.
	 *
	 * @param types the types
	 * @return the int
	 */
	public int distanceTo(final Signature types) {
		return distanceTo(types.list);
	}

	/**
	 * Equals.
	 *
	 * @param p the p
	 * @return true, if successful
	 */
	public boolean equals(final Signature p) {
		if (p.list.length != list.length) { return false; }
		for (int i = 0; i < list.length; i++) {
			if (p.list[i] != list[i]) { return false; }
		}
		return true;
	}

	@Override
	public boolean equals(final Object p) {
		if (!(p instanceof Signature)) { return false; }
		return equals((Signature) p);
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(list);
	}

	@Override
	public String toString() {
		String s = list.length < 2 ? "type " : "types [";
		for (int i = 0; i < list.length; i++) {
			s += list[i].toString();
			if (i != list.length - 1) {
				s += ", ";
			}
		}
		if (list.length >= 2) {
			s += "]";
		}
		return s;
	}

	/**
	 * Gets the.
	 *
	 * @param i the i
	 * @return the i type
	 */
	public IType get(final int i) {
		return list[i];
	}

	/**
	 * Coerce.
	 *
	 * @param originalSignature the original signature
	 * @param context the context
	 * @return the i type[]
	 */
	public IType[] coerce(final Signature originalSignature, final IDescription context) {
		final IType[] result = new IType[list.length];
		for (int i = 0; i < list.length; i++) {
			result[i] = list[i].coerce(originalSignature.get(i), context);
		}
		return result;
	}

	/**
	 * Checks if is unary.
	 *
	 * @return true, if is unary
	 */
	public boolean isUnary() {
		return list.length == 1;
	}

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return list.length;
	}

	/**
	 * As pattern.
	 *
	 * @param withVariables the with variables
	 * @return the string
	 */
	public String asPattern(final boolean withVariables) {
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.length; i++) {
			sb.append(withVariables ? list[i].asPattern() : list[i].serialize(true));
			if (i < list.length - 1) {
				sb.append(',');
			}
		}
		return sb.toString();
	}
}