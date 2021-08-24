/*******************************************************************************************************
 *
 * CreateFromGeometriesDelegate.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.statements;

import java.util.List;
import java.util.Map;

import gama.common.interfaces.ICreateDelegate;
import gama.common.interfaces.IKeyword;
import gama.metamodel.shape.GamaShape;
import gama.runtime.IScope;
import gama.util.IAddressableContainer;
import gama.util.IList;
import gama.util.file.GamaGeometryFile;
import gaml.types.IType;
import gaml.types.Types;

/**
 * Class CreateFromDatabaseDelegate.
 *
 * @author drogoul
 * @since 27 mai 2015
 *
 */
@SuppressWarnings ({ "unchecked", "rawtypes" })
public class CreateFromGeometriesDelegate implements ICreateDelegate {

	/**
	 * Method acceptSource()
	 *
	 * @see gama.common.interfaces.ICreateDelegate#acceptSource(IScope, java.lang.Object)
	 */
	@Override
	public boolean acceptSource(final IScope scope, final Object source) {
		// THIS CONDITION MUST BE CHECKED : bypass a condition that belong to
		// the case createFromDatabase
		if (source instanceof IList && !((IList) source).isEmpty() && ((IList) source).get(0) instanceof IList) {
			return false;
		}
		return source instanceof IList
				&& ((IList) source).getGamlType().getContentType().isAssignableFrom(Types.GEOMETRY)

				|| source instanceof GamaGeometryFile;

	}

	/**
	 * Method createFrom() Method used to read initial values and attributes from a CSV values describing a synthetic
	 * population
	 *
	 * @author Alexis Drogoul
	 * @since 04-09-2012
	 * @see gama.common.interfaces.ICreateDelegate#createFrom(gama.runtime.IScope, java.util.List, int,
	 *      java.lang.Object)
	 */
	@Override
	public boolean createFrom(final IScope scope, final List<Map<String, Object>> inits, final Integer max,
			final Object input, final Arguments init, final CreateStatement statement) {
		final IAddressableContainer<Integer, GamaShape, Integer, GamaShape> container =
				(IAddressableContainer<Integer, GamaShape, Integer, GamaShape>) input;
		final int num = max == null ? container.length(scope) : Math.min(container.length(scope), max);
		for (int i = 0; i < num; i++) {
			final GamaShape g = container.get(scope, i);
			final Map map = g.getOrCreateAttributes();
			// The shape is added to the initial values
			g.setAttribute(IKeyword.SHAPE, g);
			// GIS attributes are mixed with the attributes of agents
			statement.fillWithUserInit(scope, map);
			inits.add(map);
		}
		return true;
	}

	/**
	 * Method fromFacetType()
	 *
	 * @see gama.common.interfaces.ICreateDelegate#fromFacetType()
	 */
	@Override
	public IType fromFacetType() {
		return Types.CONTAINER.of(Types.GEOMETRY);
	}

}
