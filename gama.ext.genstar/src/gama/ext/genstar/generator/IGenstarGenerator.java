/*******************************************************************************************************
 *
 * IGenstarGenerator.java, in gama.ext.genstar, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.genstar.generator;

import java.util.List;
import java.util.Map;

import gama.ext.genstar.statement.GenerateStatement;
import gama.runtime.IScope;
import gaml.statements.Arguments;
import gaml.types.IType;

/**
 * Interface called by the GenerateStatement to build a synthetic population based on 
 * a given Source of information.
 *
 * @author kevinchapuis
 */
public interface IGenstarGenerator {
	
	/**
	 * Gives the type of the main source of data to inform generation process.
	 *
	 * @return the i type
	 */
	@SuppressWarnings("rawtypes")
	IType sourceType();
	
	/**
	 * Tests if the source type fit the required type for this generator .
	 *
	 * @param scope the scope
	 * @param source the source
	 * @return true, if successful
	 */
	boolean sourceMatch(IScope scope, Object source);
	
	/**
	 * The main method to generate agents' attributes.
	 *
	 * @param scope the scope
	 * @param inits the inits
	 * @param max the max
	 * @param source the source
	 * @param attributes the attributes
	 * @param algo the algo
	 * @param init the init
	 * @param generateStatement the generate statement
	 */
	public void generate(IScope scope, List<Map<String, Object>> inits, Integer max,
			Object source, Object attributes, Object algo, 
			Arguments init, GenerateStatement generateStatement); 
	
}
