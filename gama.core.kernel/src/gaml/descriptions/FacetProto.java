/*******************************************************************************************************
 *
 * FacetProto.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.descriptions;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import gama.common.interfaces.IGamlDescription;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.facet;
import gama.core.dev.annotations.GamlAnnotations.facets;
import gaml.types.IType;
import gaml.types.Types;

/**
 * The Class FacetProto.
 */
public class FacetProto implements IGamlDescription, Comparable<FacetProto> {

	/** The name. */
	public final String name;
	
	/** The deprecated. */
	public String deprecated = null;
	
	/** The types. */
	public final IType<?>[] types;
	
	/** The types describers. */
	public final int[] typesDescribers;
	
	/** The content type. */
	public final IType<?> contentType;
	
	/** The key type. */
	public final IType<?> keyType;
	
	/** The optional. */
	public final boolean optional;
	
	/** The internal. */
	public final boolean internal;
	
	/** The is label. */
	private final boolean isLabel;
	
	/** The is id. */
	private final boolean isId;
	
	/** The is remote. */
	final boolean isRemote;
	
	/** The is new temp. */
	final boolean isNewTemp;
	
	/** The is type. */
	public final boolean isType;
	
	/** The values. */
	public final Set<String> values;
	
	/** The doc. */
	public String doc = "No documentation yet";
	
	/** The owner. */
	public String owner;

	/**
	 * Instantiates a new facet proto.
	 *
	 * @param name the name
	 * @param types the types
	 * @param ct the ct
	 * @param kt the kt
	 * @param values the values
	 * @param optional the optional
	 * @param internal the internal
	 * @param isRemote the is remote
	 */
	public FacetProto(final String name, final int[] types, final int ct, final int kt, final String[] values,
			final boolean optional, final boolean internal, final boolean isRemote) {
		this.name = name;
		this.typesDescribers = types;
		isNewTemp = typesDescribers[0] == IType.NEW_TEMP_ID;
		this.types = new IType[types.length];
		for (int i = 0; i < types.length; i++) {
			this.types[i] = Types.get(types[i]);
		}
		this.contentType = Types.get(ct);
		this.keyType = Types.get(kt);
		this.optional = optional;
		this.internal = internal;
		this.isRemote = isRemote;
		isLabel = SymbolProto.ids.contains(types[0]);
		isId = isLabel && types[0] != IType.LABEL;
		isType = types[0] == IType.TYPE_ID;
		this.values = values.length == 0 ? null : ImmutableSet.copyOf(values);
		// if (doc != null) {
		// final String[] strings = doc.split(GamlProperties.SEPARATOR, -1);
		// this.doc = strings[0];
		// if (strings.length > 1) {
		// this.deprecated = strings[1];
		// if (deprecated.length() == 0) {
		// deprecated = null;
		// }
		// }
		// }
	}

	/**
	 * Checks if is label.
	 *
	 * @return true, if is label
	 */
	boolean isLabel() {
		return isLabel;
	}

	/**
	 * Sets the owner.
	 *
	 * @param s the new owner
	 */
	public void setOwner(final String s) {
		owner = s;
	}

	@Override
	public String getDefiningPlugin() {
		// returns null as facets cannot be defined alone (the symbol already
		// carries this information)
		return null;
	}

	/**
	 * Checks if is id.
	 *
	 * @return true, if is id
	 */
	public boolean isId() {
		return isId;
	}

	/**
	 * Method getTitle()
	 *
	 * @see gama.common.interfaces.IGamlDescription#getTitle()
	 */
	@Override
	public String getTitle() {
		final String p = owner == null ? "" : " of " + owner;
		return "Facet " + name + p;
	}

	/**
	 * Types to string.
	 *
	 * @return the string
	 */
	public String typesToString() {
		final StringBuilder s = new StringBuilder(30);
		s.append(types.length < 2 ? " " : " any type in [");
		for (int i = 0; i < types.length; i++) {
			switch (typesDescribers[i]) {
				case IType.ID:
					s.append("an identifier");
					break;
				case IType.LABEL:
					s.append("a label");
					break;
				case IType.NEW_TEMP_ID:
				case IType.NEW_VAR_ID:
					s.append("a new identifier");
					break;
				case IType.TYPE_ID:
					s.append("a datatype identifier");
					break;
				case IType.NONE:
					s.append("any type");
					break;
				default:
					// TODO AD 2/16 Document the types with the new possibility to
					// include of and index
					s.append(types[i].toString());
			}
			if (i != types.length - 1) {
				s.append(", ");
			}
		}
		if (types.length >= 2) {
			s.append("]");
		}
		return s.toString();
	}

	/**
	 * Method getDocumentation()
	 *
	 * @see gama.common.interfaces.IGamlDescription#getDocumentation()
	 */
	@Override
	public String getDocumentation() {
		final StringBuilder sb = new StringBuilder(100);
		sb.append("<b>").append(name).append("</b>, ")
				.append(deprecated != null ? "deprecated" : optional ? "optional" : "required").append("")
				.append(", expects ").append(typesToString());
		if (values != null && values.size() > 0) {
			sb.append(", takes values in ").append(values).append(". ");
		}
		if (doc != null && doc.length() > 0) {
			sb.append(" - ").append(doc);
		}
		if (deprecated != null) {
			sb.append(" <b>[");
			sb.append(deprecated);
			sb.append("]</b>");
		}
		return sb.toString();
	}

	/**
	 * Method getName()
	 *
	 * @see gama.common.interfaces.IGamlDescription#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		// Nothing
	}

	/**
	 * Method compareTo()
	 *
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final FacetProto o) {
		return getName().compareTo(o.getName());
	}

	/**
	 * Method serialize()
	 *
	 * @see gama.common.interfaces.IGamlable#serialize(boolean)
	 */
	@Override
	public String serialize(final boolean includingBuiltIn) {
		if (deprecated != null) { return ""; }
		if (SymbolSerializer.uselessFacets.contains(name)) { return ""; }
		return name + (optional ? ": optional" : ": required") + " ("
				+ (types.length < 2 ? typesToString().substring(1) : typesToString()) + ")";
	}

	/**
	 * Method collectPlugins().
	 *
	 * @param c the c
	 * @see gama.common.interfaces.IGamlDescription#collectPlugins(java.util.Set)
	 */
	// @Override
	// public void collectMetaInformation(final GamlProperties meta) {}

	public void buildDoc(final Class<?> c) {
		final facets facets = c.getAnnotation(facets.class);
		if (facets != null) {
			final facet[] array = facets.value();
			for (final facet f : array) {
				if (name.equals(f.name())) {
					final doc[] docs = f.doc();
					if (docs != null && docs.length > 0) {
						final doc d = docs[0];
						doc = d.value();
						deprecated = d.deprecated();
						if (deprecated.length() == 0) {
							deprecated = null;
						}
					}
				}
			}
		}

	}

	/**
	 * @return
	 */

}