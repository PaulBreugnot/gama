/*******************************************************************************************************
 *
 * LayoutStatement.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.outputs;

import static gama.common.interfaces.IKeyword.LAYOUT;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.example;
import gama.core.dev.annotations.GamlAnnotations.facet;
import gama.core.dev.annotations.GamlAnnotations.facets;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.core.dev.annotations.GamlAnnotations.usage;
import gaml.compilation.ISymbol;
import gaml.compilation.Symbol;
import gaml.descriptions.IDescription;
import gaml.types.IType;

/**
 * The Class LayoutStatement.
 *
 * @author Alexis Drogoul
 */
@symbol (
		name = LAYOUT,
		kind = ISymbolKind.OUTPUT,
		with_sequence = false,
		unique_in_context = true,
		concept = { IConcept.DISPLAY })

@facets (
		omissible = IKeyword.VALUE,
		value = { @facet (
				name = IKeyword.VALUE,
				type = IType.NONE,
				optional = true,
				doc = @doc ("Either #none, to indicate that no layout will be imposed, or one of the four possible predefined layouts: #stack, #split, #horizontal or #vertical. This layout will be applied to both experiment and simulation display views. In addition, it is possible to define a custom layout using the horizontal() and vertical() operators")),
				@facet (
						name = "editors",
						type = IType.BOOL,
						optional = true,
						doc = @doc ("Whether the editors should initially be visible or not")),
				@facet (
						name = "toolbars",
						type = IType.BOOL,
						optional = true,
						doc = @doc ("Whether the displays should show their toolbar or not")),
				@facet (
						name = "controls",
						type = IType.BOOL,
						optional = true,
						doc = @doc ("Whether the experiment should show its control toolbar on top or not")),
				@facet (
						name = "parameters",
						type = IType.BOOL,
						optional = true,
						doc = @doc ("Whether the parameters view is visible or not (true by default)")),
				@facet (
						name = "navigator",
						type = IType.BOOL,
						optional = true,
						doc = @doc ("Whether the navigator view is visible or not (true by default)")),
				@facet (
						name = "consoles",
						type = IType.BOOL,
						optional = true,
						doc = @doc ("Whether the consoles are visible or not (true by default)")),
				@facet (
						name = "tray",
						type = IType.BOOL,
						optional = true,
						doc = @doc ("Whether the bottom tray is visible or not (true by default)")),
				@facet (
						name = "tabs",
						type = IType.BOOL,
						optional = true,
						doc = @doc ("Whether the displays should show their tab or not")) })

@inside (
		symbols = IKeyword.OUTPUT)
@doc (
		value = "Represents the layout of the display views of simulations and experiments",
		usages = { @usage (
				value = "For instance, this layout statement will allow to split the screen occupied by displays in four equal parts, with no tabs. Pairs of display::weight represent the number of the display in their order of definition and their respective weight within a horizontal and vertical section",
				examples = { @example (
						value = "layout horizontal([vertical([0::5000,1::5000])::5000,vertical([2::5000,3::5000])::5000]) tabs: false;",
						isExecutable = false) }) })
public class LayoutStatement extends Symbol {

	/**
	 * Instantiates a new layout statement.
	 *
	 * @param desc the desc
	 */
	public LayoutStatement(final IDescription desc) {
		super(desc);
	}

	@Override
	public void setChildren(final Iterable<? extends ISymbol> children) {}

}
