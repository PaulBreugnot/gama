/*******************************************************************************************************
 *
 * depends_on.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.compilation.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention (RUNTIME)
@Target (METHOD)

/**
 * An annotation which purpose is to specify, for operators, if they implicitely rely on the previous initialization of
 * one or several attributes (like, for instance, the cone() operator implicitly relying on the shape of the world being
 * already initialized).
 *
 * @author drogoul
 */
public @interface depends_on {

	/**
	 * Value.
	 *
	 * @return the string[]
	 */
	String[] value() default {};
}
