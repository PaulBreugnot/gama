/*******************************************************************************************************
 *
 * CSVModel.java, in gama.ui.viewers, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.viewers.csv.model;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;

import gama.core.dev.utils.DEBUG;
import gama.runtime.GAMA;
import gama.ui.base.interfaces.IRefreshHandler;
import gama.ui.base.utils.WorkbenchHelper;
import gama.util.file.IGamaFileMetaData;
import gama.util.file.GamaCSVFile.CSVInfo;
import gama.util.file.csv.CsvReader;
import gama.util.file.csv.CsvWriter;
import gama.util.file.csv.CsvWriter.Letters;

/**
 * The Class CSVModel.
 *
 * @author fhenri
 */
public class CSVModel implements IRowChangesListener {

	/** The display first line. */
	private final boolean displayFirstLine;
	
	/** The rows. */
	private final ArrayList<CSVRow> rows;
	
	/** The listeners. */
	private final ArrayList<ICsvFileModelListener> listeners;
	
	/** The file. */
	private final IFile file;
	
	/** The current info. */
	private CSVInfo currentInfo;

	/**
	 * Default constructor.
	 *
	 * @param file the file
	 */
	public CSVModel(final IFile file) {
		this.file = file;
		displayFirstLine = true;
		rows = new ArrayList<>();
		listeners = new ArrayList<>();
	}

	/**
	 * Check if first line in the file will be considered as the file header.
	 *
	 * @return true if the first line in the file represents the header
	 */
	public boolean isFirstLineHeader() {
		return getInfo().header;
	}

	/**
	 * Sets the first line header.
	 *
	 * @param header the new first line header
	 */
	public void setFirstLineHeader(final boolean header) {
		final CSVInfo info = getInfo();
		if (info.header != header) {
			info.header = header;
			saveMetaData();
		}
		// ResourceRefreshHandler.discardMetaData(file);
	}

	/**
	 * Get custom delimiter to use as a separator.
	 *
	 * @return the delimiter
	 */
	public char getCustomDelimiter() {
		return getInfo().delimiter;
	}

	/**
	 * Sets the custom delimiter.
	 *
	 * @param c the new custom delimiter
	 */
	public void setCustomDelimiter(final char c) {
		final CSVInfo info = getInfo();
		if (c == info.delimiter) { return; }
		info.delimiter = c;
		saveMetaData();
	}

	/**
	 * Get the character that defines comment lines.
	 *
	 * @return the comment line starting character. If no comments are allowed in this file, then Character.UNASSIGNED
	 *         constant must be returned;
	 */
	public char getCommentChar() {
		final char result = Character.UNASSIGNED;
		return result;
	}

	/**
	 * Get custom text qualifier to use as a text qualifier in the data.
	 *
	 * @return the text qualifier character to use as a text qualifier in the data
	 */
	public Character getTextQualifier() {
		final char result = Character.UNASSIGNED;
		return result;
	}

	/**
	 * check if the text qualifier has to be use for all fields or not.
	 *
	 * @return true if the text qualifier is to be used for all data fields
	 */
	public boolean useQualifier() {
		return getTextQualifier() != null;
	}

	/**
	 * Sets the input.
	 *
	 * @param text the new input
	 */
	public void setInput(final String text) {
		readLines(text);
	}

	/**
	 * Initialize reader.
	 *
	 * @param reader the reader
	 * @return the csv reader
	 */
	protected CsvReader initializeReader(final Reader reader) {
		final CsvReader csvReader = new CsvReader(reader);

		final char customDelimiter = getCustomDelimiter();
		csvReader.setDelimiter(customDelimiter);

		final char commentChar = getCommentChar();
		if (commentChar != Character.UNASSIGNED) {
			csvReader.setComment(commentChar);
			// prevent loss of comment in csv source file
			csvReader.setUseComments(false);
		}

		csvReader.setTextQualifier(Letters.QUOTE);
		csvReader.setUseTextQualifier(true);

		return csvReader;
	}

	/**
	 * Read lines.
	 *
	 * @param fileText the file text
	 */
	protected void readLines(final String fileText) {
		readLines(new StringReader(fileText));
	}

	/**
	 * Read lines.
	 *
	 * @param reader the reader
	 */
	protected void readLines(final Reader reader) {
		rows.clear();
		final CSVInfo info = getInfo();
		info.cols = 0;

		try {
			final CsvReader csvReader = initializeReader(reader);
			// case when the first line is the encoding
			if (!displayFirstLine) {
				csvReader.skipLine();
			}

			boolean setHeader = false;
			while (csvReader.readRecord()) {
				final String[] rowValues = csvReader.getValues();
				if (rowValues.length > info.cols) {
					info.cols = rowValues.length;
				}
				final CSVRow csvRow = new CSVRow(rowValues, this);
				if (!rowValues[0].startsWith(String.valueOf(getCommentChar()))) {
					if (info.header && !setHeader) {
						setHeader = true;
						csvRow.setHeader(true);
						getInfo().headers = new String[getInfo().cols];
						for (int i = 0; i < getInfo().cols; i++) {
							getInfo().headers[i] = rowValues[i];
						}
					}
				} else {
					csvRow.setCommentLine(true);
				}
				rows.add(csvRow);
			}
			if (!info.header) {
				getInfo().headers = new String[getInfo().cols];
				for (int i = 0; i < getInfo().cols; i++) {
					getInfo().headers[i] = "Column" + (i + 1);
				}
			}

			csvReader.close();
		} catch (final Exception e) {
			DEBUG.ERR("exception in readLines " + e);
			e.printStackTrace();
		}
		saveMetaData();
	}

	/**
	 * Gets the header.
	 *
	 * @return the header
	 */
	public List<String> getHeader() {
		return Arrays.asList(getInfo().headers);
	}

	/**
	 * Gets the array header.
	 *
	 * @return the array header
	 */
	public String[] getArrayHeader() {
		return getInfo().headers;
	}

	// ----------------------------------
	// Helper method on rows management
	// ----------------------------------

	/**
	 * Adds the row.
	 */
	// public void duplicateRow(final CSVRow row) {
	// CSVRow newRow = new CSVRow(row, this);
	// CSVInfo info = getInfo();
	// int indexRow = findRow(row);
	// if ( indexRow != -1 ) {
	// rows.add(indexRow, newRow);
	// } else {
	// addRow(newRow);
	// }
	// info.rows++;
	// saveMetaData();
	// }

	/**
	 *
	 */
	public void addRow() {
		final CSVRow row = CSVRow.createEmptyLine(getInfo().cols, this);
		addRow(row);
	}

	/**
	 * Adds the row.
	 *
	 * @param row the row
	 */
	public void addRow(final CSVRow row) {
		rows.add(row);
		final CSVInfo info = getInfo();
		info.rows++;
		saveMetaData();

	}

	/**
	 * Adds the row after element.
	 *
	 * @param row the row
	 */
	public void addRowAfterElement(final CSVRow row) {
		final CSVInfo info = getInfo();
		final CSVRow newRow = CSVRow.createEmptyLine(info.cols, this);
		final int indexRow = findRow(row);

		if (indexRow != -1) {
			rows.add(indexRow, newRow);
			info.rows++;
		} else {
			addRow(newRow);
		}
		saveMetaData();
	}

	/**
	 * Find row.
	 *
	 * @param findRow the find row
	 * @return the int
	 */
	public int findRow(final CSVRow findRow) {
		for (int i = 0; i <= getArrayRows(true).length; i++) {
			final CSVRow row = getRowAt(i);
			if (row.equals(findRow)) { return i; }
		}
		return -1;
	}

	/**
	 * Gets the rows.
	 *
	 * @return the rows
	 */
	public List<CSVRow> getRows() {
		return rows;
	}

	/**
	 * Gets the array rows.
	 *
	 * @param includeCommentLine the include comment line
	 * @return the array rows
	 */
	public Object[] getArrayRows(final boolean includeCommentLine) {
		// filter header and comment rows
		final ArrayList<CSVRow> myrows = new ArrayList<>();
		for (final CSVRow row : rows) {
			// should we return the comment line
			if (row.isCommentLine()) {
				if (includeCommentLine) {
					myrows.add(row);
				}
			}
			// we do not add the header line
			else if (!row.isHeader()) {
				myrows.add(row);
			}
		}
		return myrows.toArray();
	}

	/**
	 * Gets the row at.
	 *
	 * @param index the index
	 * @return the row at
	 */
	public CSVRow getRowAt(final int index) {
		return rows.get(index);
	}

	/**
	 * @see org.fhsolution.eclipse.plugins.csvedit.model.IRowChangesListener#rowChanged(org.fhsolution.eclipse.plugins.csvedit.model.CSVRow,
	 *      int)
	 */
	@Override
	public void rowChanged(final CSVRow row, final int rowIndex) {
		for (final ICsvFileModelListener l : listeners) {
			l.entryChanged(row, rowIndex);
		}
	}

	/**
	 * Removes the row.
	 *
	 * @param row the row
	 */
	public void removeRow(final CSVRow row) {
		if (!rows.remove(row)) {
			return;
			// TODO return error message
		}
		final CSVInfo info = getInfo();
		info.rows--;
		saveMetaData();
	}

	// ----------------------------------
	// Helper method on column management
	// ----------------------------------

	/**
	 * Adds the column.
	 *
	 * @param colName the col name
	 */
	public void addColumn(final String colName) {
		final CSVInfo info = getInfo();
		info.cols++;
		info.headers = Arrays.copyOf(info.headers, info.headers.length + 1);
		info.headers[info.headers.length - 1] = colName;
		for (final CSVRow row : rows) {
			row.addElement("");
		}
		saveMetaData();

	}

	/**
	 * Gets the column count.
	 *
	 * @return the column count
	 */
	public int getColumnCount() {
		return getInfo().cols;
	}

	/**
	 * Remove the column represented by the index.
	 *
	 * @param colIndex the col index
	 */
	public void removeColumn(final int colIndex) {
		final CSVInfo info = getInfo();
		if (info.header) {
			final ArrayList<String> cols = new ArrayList<>(Arrays.asList(info.headers));
			cols.remove(colIndex);
			info.headers = cols.toArray(new String[cols.size()]);
		}
		info.cols--;
		for (final CSVRow row : rows) {
			if (!row.isCommentLine()) {
				// DEBUG.LOG("remove elmt:[" + colIndex + "] in row ["
				// + row + "]");
				row.removeElementAt(colIndex);
			}
		}
		saveMetaData();
	}

	/**
	 * Remove the column represented by its name.
	 *
	 * @param columnName the column name
	 */
	public void removeColumn(final String columnName) {
		if (columnName == null) { return; }
		final List<String> cols = Arrays.asList(getInfo().headers);
		final int colIndex = cols.indexOf(columnName);
		removeColumn(colIndex);
	}

	/**
	 * Removes the model listener.
	 *
	 * @param csvFileListener the csv file listener
	 */
	public void removeModelListener(final ICsvFileModelListener csvFileListener) {
		listeners.remove(csvFileListener);
	}

	/**
	 * Adds the model listener.
	 *
	 * @param csvFileListener the csv file listener
	 */
	public void addModelListener(final ICsvFileModelListener csvFileListener) {
		if (!listeners.contains(csvFileListener)) {
			listeners.add(csvFileListener);
		}
	}

	/**
	 * Initialize the CsvWriter.
	 *
	 * @param writer the writer
	 * @return the csv writer
	 */
	protected CsvWriter initializeWriter(final Writer writer) {
		final char delimiter = getCustomDelimiter();
		final CsvWriter csvWriter = new CsvWriter(writer, delimiter);
		csvWriter.setTextQualifier(getTextQualifier());
		csvWriter.setForceQualifier(useQualifier());
		csvWriter.setComment(getCommentChar());
		return csvWriter;
	}

	/**
	 * Gets the text representation.
	 *
	 * @return the text representation
	 */
	public String getTextRepresentation() {

		try (final StringWriter sw = new StringWriter(); final CsvWriter clw = initializeWriter(sw);) {

			for (final CSVRow row : rows) {
				if (row.isCommentLine()) {
					clw.writeComment(row.getComment());
				} else {
					clw.writeRecord(row.getEntriesAsArray());
				}
			}
			return sw.toString();
		} catch (final Exception e) {
			DEBUG.ERR("cannot write csv file");
			return "";
		}

	}

	/**
	 * Save meta data.
	 */
	public void saveMetaData() {
		final IRefreshHandler refresh = WorkbenchHelper.getService(IRefreshHandler.class);
		if (refresh != null) {
			refresh.refreshResource(file);
		}
	}

	/**
	 * Gets the info.
	 *
	 * @return the info
	 */
	public CSVInfo getInfo() {
		if (currentInfo == null) {
			final IGamaFileMetaData metaData = GAMA.getGui().getMetaDataProvider().getMetaData(file, false, true);
			if (metaData instanceof CSVInfo) {
				currentInfo = (CSVInfo) metaData;
			} else {
				GAMA.getGui().getMetaDataProvider().storeMetaData(file, null, true);
				currentInfo = (CSVInfo) GAMA.getGui().getMetaDataProvider().getMetaData(file, false, true);
			}
		}
		return currentInfo;
	}
}
