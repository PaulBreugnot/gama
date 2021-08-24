/*******************************************************************************************************
 *
 * ISymbolKind.java, in gama.core.dev, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.dev.annotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Written by drogoul Modified on 1 ao�t 2010.
 *
 * @todo Description
 */
public interface ISymbolKind {

	/**
	 * The Interface Variable.
	 */
	public static interface Variable {

		/** The Constant NUMBER. */
		public static final int NUMBER = 101;

		/** The Constant CONTAINER. */
		public static final int CONTAINER = 102;

		/** The Constant SIGNAL. */
		public static final int SIGNAL = 103;

		/** The Constant REGULAR. */
		public static final int REGULAR = 104;

		/** The Constant KINDS. */
		public static final Set<Integer> KINDS = new HashSet<>(Arrays.asList(NUMBER, CONTAINER, REGULAR, SIGNAL));

		/** The Constant KINDS_AS_STRING. */
		public static final Map<Integer, String> KINDS_AS_STRING = new HashMap<Integer, String>() {
			{
				put(NUMBER, "number");
				put(CONTAINER, "container");
				put(REGULAR, "regular");
				put(SIGNAL, "signal");
			}
		};
	}

	/** The Constant SPECIES. */
	public static final int SPECIES = 0;

	/** The Constant MODEL. */
	public static final int MODEL = 1;

	/** The Constant SINGLE_STATEMENT. */
	public static final int SINGLE_STATEMENT = 2;

	/** The Constant BEHAVIOR. */
	public static final int BEHAVIOR = 3;

	/** The Constant PARAMETER. */
	public static final int PARAMETER = 4;

	/** The Constant OUTPUT. */
	public static final int OUTPUT = 5;

	/** The Constant LAYER. */
	public static final int LAYER = 6;

	/** The Constant SKILL. */
	public static final int SKILL = 7;

	/** The Constant BATCH_SECTION. */
	public static final int BATCH_SECTION = 8;

	/** The Constant BATCH_METHOD. */
	public static final int BATCH_METHOD = 9;

	/** The Constant ENVIRONMENT. */
	public static final int ENVIRONMENT = 10;

	/** The Constant SEQUENCE_STATEMENT. */
	public static final int SEQUENCE_STATEMENT = 11;

	/** The Constant ACTION. */
	// Equal to SEQUENCE_STATEMENT
	public static final int ACTION = 11;

	/** The Constant EXPERIMENT. */
	public static final int EXPERIMENT = 13;

	/** The Constant ABSTRACT_SECTION. */
	public static final int ABSTRACT_SECTION = 14;

	/** The Constant OPERATOR. */
	public static final int OPERATOR = 15;

	/** The Constant PLATFORM. */
	public static final int PLATFORM = 16;

	/** The Constant __NUMBER__. */
	// Update this variable when adding a kind of symbol
	public static final int __NUMBER__ = 17;

	/** The Constant TEMPLATE_MENU. */
	public static final String[] TEMPLATE_MENU = { "Species", "Model", "Statement", "Behavior", "Parameter", "Output",
			"Layer", "Skill", "Batch", "Batch", "", "Statement", "Statement", "Experiment", "", "Operator", "" };

}
