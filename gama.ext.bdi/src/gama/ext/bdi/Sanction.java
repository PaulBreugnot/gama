/*******************************************************************************************************
 *
 * Sanction.java, in gama.ext.bdi, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.bdi;

import gama.common.interfaces.IValue;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.getter;
import gama.core.dev.annotations.GamlAnnotations.variable;
import gama.core.dev.annotations.GamlAnnotations.vars;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.types.IType;
import gaml.types.Types;

/**
 * The Class Sanction.
 */
@vars ({ @variable (
		name = "name",
		type = IType.STRING,
		doc = @doc ("The name of this sanction")),

})
public class Sanction implements IValue{

	/** The sanction statement. */
	private SanctionStatement sanctionStatement;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@getter ("name")
	public String getName() {
		return this.sanctionStatement.getName();
	}
	
	/**
	 * Gets the sanction statement.
	 *
	 * @return the sanction statement
	 */
	public SanctionStatement getSanctionStatement() {
		return this.sanctionStatement;
	}
	
	/**
	 * Instantiates a new sanction.
	 */
	public Sanction(){
		super();
	}
	
	/**
	 * Instantiates a new sanction.
	 *
	 * @param statement the statement
	 */
	public Sanction(final SanctionStatement statement) {
		super();
		this.sanctionStatement = statement;
	}
	
	public boolean equals(final Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		final Sanction other = (Sanction) obj;
		if (sanctionStatement == null) {
			if (other.sanctionStatement != null) { return false; }
		} else if (!sanctionStatement.equals(other.sanctionStatement)) { return false; }
		return true;
	}
	
	@Override
	public String serialize(boolean includingBuiltIn) {
		return "Sanction( " + sanctionStatement + ")";
	}

	@Override
	public IType<?> getGamlType() {
		return Types.get(SanctionType.id);
//		return null;
	}

	@Override
	public String stringValue(IScope scope) throws GamaRuntimeException {
		return "Sanction( " + sanctionStatement + ")";
	}

	@Override
	public IValue copy(IScope scope) throws GamaRuntimeException {
		return new Sanction(sanctionStatement);
	}

}
