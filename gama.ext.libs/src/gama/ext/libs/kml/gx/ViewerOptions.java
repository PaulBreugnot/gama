/*******************************************************************************************************
 *
 * ViewerOptions.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml.gx;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import gama.ext.libs.kml.AbstractObject;
import gama.ext.libs.kml.annotations.Obvious;


/**
 * The Class ViewerOptions.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewerOptionsType", propOrder = {
    "option"
})
@XmlRootElement(name = "ViewerOptions", namespace = "http://www.google.com/kml/ext/2.2")
public class ViewerOptions
    extends AbstractObject
    implements Cloneable
{

    /** The option. */
    @XmlElement(required = true)
    protected List<Option> option;

    /**
     * Value constructor with only mandatory fields.
     *
     * @param option     required parameter
     */
    public ViewerOptions(final List<Option> option) {
        super();
        this.option = option;
    }

    /**
     * Default no-arg constructor is private. Use overloaded constructor instead! (Temporary solution, till a better and more suitable ObjectFactory is created.) 
     * 
     */
    @Deprecated
    private ViewerOptions() {
        super();
    }

    /**
     * Gets the option.
     *
     * @return the option
     */
    public List<Option> getOption() {
        if (option == null) {
            option = new ArrayList<Option>();
        }
        return this.option;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = ((prime*result)+((option == null)? 0 :option.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (super.equals(obj) == false) {
            return false;
        }
        if ((obj instanceof ViewerOptions) == false) {
            return false;
        }
        ViewerOptions other = ((ViewerOptions) obj);
        if (option == null) {
            if (other.option!= null) {
                return false;
            }
        } else {
            if (option.equals(other.option) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a new instance of {@link Option} and adds it to option.
     * This method is a short version for:
     * <code>
     * Option option = new Option();
     * this.getOption().add(option); </code>
     *
     * @return the option
     */
    public Option createAndAddOption() {
        Option newValue = new Option();
        this.getOption().add(newValue);
        return newValue;
    }

    /**
     * Sets the value of the option property Objects of the following type(s) are allowed in the list List<Option>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withOption} instead.
     *
     * @param option the new option
     */
    public void setOption(final List<Option> option) {
        this.option = option;
    }

    /**
     * add a value to the option property collection.
     *
     * @param option     Objects of the following type are allowed in the list: {@link Option}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public ViewerOptions addToOption(final Option option) {
        this.getOption().add(option);
        return this;
    }

    @Obvious
    @Override
    public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.setObjectSimpleExtension(objectSimpleExtension);
    }

    @Obvious
    @Override
    public ViewerOptions addToObjectSimpleExtension(final Object objectSimpleExtension) {
        super.getObjectSimpleExtension().add(objectSimpleExtension);
        return this;
    }

    @Override
    public ViewerOptions clone() {
        ViewerOptions copy;
        copy = ((ViewerOptions) super.clone());
        copy.option = new ArrayList<Option>((getOption().size()));
        for (Option iter: option) {
            copy.option.add(iter.clone());
        }
        return copy;
    }

}
