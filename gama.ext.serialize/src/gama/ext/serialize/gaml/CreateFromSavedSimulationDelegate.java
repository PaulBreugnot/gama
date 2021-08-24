/*******************************************************************************************************
 *
 * CreateFromSavedSimulationDelegate.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.serialize.gaml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.XStream;

import gama.common.interfaces.ICreateDelegate;
import gama.ext.serialize.factory.StreamConverter;
import gama.ext.serialize.gamaType.converters.ConverterScope;
import gama.metamodel.agent.SavedAgent;
import gama.runtime.IScope;
import gaml.statements.Arguments;
import gaml.statements.CreateStatement;
import gaml.types.IType;
import gaml.types.Types;

/**
 * Class CreateFromSavecSimulationDelegate.
 *
 * @author bgaudou
 * @since 18 July 2018
 *
 */

@SuppressWarnings({ "unchecked", "rawtypes" })
public class CreateFromSavedSimulationDelegate implements ICreateDelegate {

	/**
	 * Method acceptSource()
	 * 
	 * @see gama.common.interfaces.ICreateDelegate#acceptSource(IScope, java.lang.Object)
	 */
	@Override
	public boolean acceptSource(IScope scope, final Object source) {
		return source instanceof GamaSavedSimulationFile;
	}

	/**
	 * @see gama.common.interfaces.ICreateDelegate#createFrom(gama.runtime.IScope,
	 *      java.util.List, int, java.lang.Object)
	 */
	@Override
	public boolean createFrom(final IScope scope, final List<Map<String, Object>> inits, final Integer max,
			final Object source, final Arguments init, final CreateStatement statement) {
		final GamaSavedSimulationFile file = (GamaSavedSimulationFile) source;

		final ConverterScope cScope = new ConverterScope(scope);
		final XStream xstream = StreamConverter.loadAndBuild(cScope);

		String stringFile = file.getBuffer().get(0);
		final SavedAgent saveAgt = (SavedAgent) xstream.fromXML(stringFile);
		
		HashMap mapSavedAgt = new HashMap<String, Object>();
		mapSavedAgt.put("SavedAgent", saveAgt);
		
		inits.add(mapSavedAgt);
		
		return true;
	}


	/**
	 * Method fromFacetType()
	 * 
	 * @see gama.common.interfaces.ICreateDelegate#fromFacetType()
	 */
	@Override
	public IType fromFacetType() {
		return Types.FILE;
	}
}
