/*******************************************************************************************************
 *
 * ICsvFileModelListener.java, in gama.ui.viewers, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.viewers.csv.model;

/**
 * The listener interface for receiving ICsvFileModel events.
 * The class that is interested in processing a ICsvFileModel
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addICsvFileModelListener<code> method. When
 * the ICsvFileModel event occurs, that object's appropriate
 * method is invoked.
 *
 * @author fhenri
 */
public interface ICsvFileModelListener {

    /**
     * Entry changed.
     *
     * @param row the row
     * @param rowIndex the row index
     */
    void entryChanged(CSVRow row, int rowIndex);

}
