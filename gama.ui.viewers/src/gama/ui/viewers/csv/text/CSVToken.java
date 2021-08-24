/*******************************************************************************************************
 *
 * CSVToken.java, in gama.ui.viewers, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.viewers.csv.text;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;

import gama.ui.base.resources.IGamaColors;

/**
 * The Class CSVToken.
 */
public class CSVToken extends Token {

	/**
	 * Different CSV tokens.
	 *
	 * @author japg
	 */
	public enum CSVTokenType {
		
		/** The odd column. */
		ODD_COLUMN(new TextAttribute(IGamaColors.GRAY_LABEL.color(), null, SWT.BOLD)), 
 /** The even column. */
 EVEN_COLUMN(new TextAttribute(
			IGamaColors.ERROR.darker(), null, SWT.BOLD)), 
 /** The separator. */
 SEPARATOR(new TextAttribute(IGamaColors.BLUE.darker(), null,
			SWT.BOLD));

		/**  Text decoration. */
		private final TextAttribute m_textDecoration;

		/**
		 * Constructor.
		 *
		 * @param attrs the attrs
		 */
		private CSVTokenType(final TextAttribute attrs) {
			m_textDecoration = attrs;
		}

		/**
		 * Get text attributes for this token type.
		 *
		 * @return the text attribute
		 */
		TextAttribute getTextAttribute() {
			return m_textDecoration;
		}
	}

	/**  Column index. */
	private final int m_columnIndex;

	/**
	 * Constructor.
	 *
	 * @param type the type
	 * @param column the column
	 */
	public CSVToken(final CSVTokenType type, final int column) {
		super(type.getTextAttribute());
		m_columnIndex = column;
	}

	/**
	 * Get column index where this token is located.
	 *
	 * @return the column index
	 */
	public int getColumnIndex() {
		return m_columnIndex;
	}
}