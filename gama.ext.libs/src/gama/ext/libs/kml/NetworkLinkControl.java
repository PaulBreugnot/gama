/*******************************************************************************************************
 *
 * NetworkLinkControl.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <NetworkLinkControl>
 * <p>
 * Controls the behavior of files fetched by a <NetworkLink>. 
 * </p>
 * 
 * Syntax: 
 * <pre><strong>&lt;NetworkLinkControl&gt;</strong>
 *   &lt;minRefreshPeriod&gt;0&lt;/minRefreshPeriod&gt;           &lt;!-- float --&gt;
 *   <span class="style2">&lt;maxSessionLength&gt;-1&lt;/maxSessionLength&gt;          &lt;!-- float --&gt; </span>
 *   &lt;cookie&gt;<em>...</em>&lt;/cookie&gt;                             &lt;!-- string --&gt;                             
 *   &lt;message&gt;<em>...</em>&lt;/message&gt;                           &lt;!-- string --&gt;
 *   &lt;linkName&gt;<em>...</em>&lt;/linkName&gt;                         &lt;!-- string --&gt;                          
 *   &lt;linkDescription&gt;<em>...</em>&lt;/linkDescription&gt;           &lt;!-- string --&gt;              
 *   &lt;linkSnippet maxLines="2"&gt;<em>...</em>&lt;/linkSnippet&gt;      &lt;!-- string --&gt;                      
 *   &lt;expires&gt;...&lt;/expires&gt;                           &lt;!-- kml:dateTime --&gt;
 *   &lt;Update&gt;...&lt;/Update&gt;                             &lt;!-- Change,Create,Delete --&gt;
 *   <span><em>&lt;AbstractView&gt;...&lt;/AbstractView&gt;</em>                 &lt;!-- LookAt <em>or</em> Camera --&gt;</span>
 * <strong>&lt;/NetworkLinkControl&gt;</strong></pre>
 * 
 * See Also: 
 * <NetworkLink>
 * <Update>
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkLinkControlType", propOrder = {
    "minRefreshPeriod",
    "maxSessionLength",
    "cookie",
    "message",
    "linkName",
    "linkDescription",
    "linkSnippet",
    "expires",
    "update",
    "abstractView",
    "networkLinkControlSimpleExtension",
    "networkLinkControlObjectExtension"
})
@XmlRootElement(name = "NetworkLinkControl", namespace = "http://www.opengis.net/kml/2.2")
public class NetworkLinkControl implements Cloneable
{

    /**
     * <minrefreshperiod>
     * <p>
     * Specified in seconds, <minRefreshPeriod> is the minimum allowed time between fetches 
     * of the file. This parameter allows servers to throttle fetches of a particular file 
     * and to tailor refresh rates to the expected rate of change to the data. For example, 
     * a user might set a link refresh to 5 seconds, but you could set your minimum refresh 
     * period to 3600 to limit refresh updates to once every hour. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double minRefreshPeriod;
    /**
     * <maxsessionlength>
     * <p>
     * Specified in seconds, <maxSessionLength> is the maximum amount of time for which 
     * the client NetworkLink can remain connected. The default value of -1 indicates not 
     * to terminate the session explicitly. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "-1.0")
    protected double maxSessionLength;
    /**
     * <cookie>
     * <p>
     * Use this element to append a string to the URL query on the next refresh of the 
     * network link. You can use this data in your script to provide more intelligent handling 
     * on the server side, including version querying and conditional file delivery. 
     * </p>
     * 
     * 
     * 
     */
    protected String cookie;
    /**
     * <message>
     * <p>
     * You can deliver a pop-up message, such as usage guidelines for your network link. 
     * The message appears when the network link is first loaded into Google Earth, or 
     * when it is changed in the network link control. 
     * </p>
     * 
     * 
     * 
     */
    protected String message;
    /**
     * <linkname>
     * <p>
     * You can control the name of the network link from the server, so that changes made 
     * to the name on the client side are overridden by the server. 
     * </p>
     * 
     * 
     * 
     */
    protected String linkName;
    /**
     * <linkdescription>
     * <p>
     * You can control the description of the network link from the server, so that changes 
     * made to the description on the client side are overridden by the server. 
     * </p>
     * 
     * 
     * 
     */
    protected String linkDescription;
    /**
     * <linksnippet maxlines="2" >
     * <p>
     * You can control the snippet for the network link from the server, so that changes 
     * made to the snippet on the client side are overridden by the server. <linkSnippet> 
     * has a maxLines attribute, an integer that specifies the maximum number of lines 
     * to display. 
     * </p>
     * 
     * 
     * 
     */
    protected Snippet linkSnippet;
    /**
     * <expires>
     * <p>
     * You can specify a date/time at which the link should be refreshed. This specification 
     * takes effect only if the <refreshMode> in <Link> has a value of onExpire. See <refreshMode> 
     * </p>
     * 
     * 
     * 
     */
    protected String expires;
    /**
     * <Update>
     * <p>
     * Specifies an addition, change, or deletion to KML data that has already been loaded 
     * using the specified URL. The <targetHref> specifies the .kml or .kmz file whose 
     * data (within Google Earth) is to be modified. <Update> is always contained in a 
     * NetworkLinkControl. Furthermore, the file containing the NetworkLinkControl must 
     * have been loaded by a NetworkLink. See the "Topics in KML" page on Updates for a 
     * detailed example of how Update works. 
     * </p>
     * <p>
     * With <Update>, you can specify any number of Change, Create, and Delete tags for 
     * a .kml file or .kmz archive that has previously been loaded with a network link. 
     * See <Update>. 
     * </p>
     * 
     * Syntax: 
     * <pre><strong>&lt;Update&gt;
     *   </strong>&lt;targetHref&gt;...&lt;targetHref&gt;    &lt;!-- URL --&gt;
     *   &lt;Change&gt;...&lt;/Change&gt;
     *   &lt;Create&gt;...&lt;/Create&gt;
     *   &lt;Delete&gt;...&lt;/Delete&gt;
     * <strong>&lt;/Update&gt;</strong></pre>
     * 
     * Contained By: 
     * @see: <NetworkLinkControl>
     * @see: Note: This element was deprecated in KML Release 2.1 and is replaced by <Link>, which provides the additional functionality of Regions. The <Url> tag will still work in Google Earth, but use of the newer <Link> tag is encouraged.
     * @see: Use this element to set the location of the link to the KML file, to define the refresh options for the server and viewer changes, and to populate a variable to return useful client information to the server.
     * 
     * 
     * 
     */
    @XmlElement(name = "Update")
    protected Update update;
    /**
     * <abstractview>
     * <p>
     * Defines a viewpoint associated with any element derived from Feature. See <Camera> 
     * and <LookAt>. 
     * </p>
     * <p>
     * This is an abstract element and cannot be used directly in a KML file. This element 
     * is extended by the <Camera> and <LookAt> elements. 
     * </p>
     * 
     * Syntax: 
     * <pre>&lt;!-- abstract element; do not create --&gt;
     * <strong>&lt;!--<em> AbstractView</em> --&gt;</strong>                   &lt;!-- Camera, LookAt --&gt;                
     *   &lt;!-- extends <span class="style1">Object</span> --&gt;
     *   <em>&lt;TimePrimitive&gt;...&lt;/TimePrimitive&gt;</em>                        &lt;!-- gx:TimeSpan or gx:TimeStamp --&gt;
     * <strong>&lt;-- /<em>AbstractView</em> --&gt;</strong></pre>
     * 
     * Extends: 
     * @see: <Object>
     * 
     * Extended By: 
     * @see: <Camera>
     * @see: <LookAt>
     * 
     * 
     * 
     */
    @XmlElementRef(name = "AbstractViewGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
    protected AbstractView abstractView;
    
    /** The network link control simple extension. */
    @XmlElement(name = "NetworkLinkControlSimpleExtensionGroup")
    @XmlSchemaType(name = "anySimpleType")
    protected List<Object> networkLinkControlSimpleExtension;
    /**
     * <Object>
     * <p>
     * This is an abstract base class and cannot be used directly in a KML file. It provides 
     * the id attribute, which allows unique identification of a KML element, and the targetId 
     * attribute, which is used to reference objects that have already been loaded into 
     * Google Earth. The id attribute must be assigned if the <Update> mechanism is to 
     * be used. 
     * </p>
     * 
     * Syntax: 
     * <pre>&lt;!-- abstract element; do not create --&gt;<strong>
     * &lt;!-- <em>Object</em> id="ID" targetId="NCName" --&gt;
     * &lt;!-- /<em>Object</em>&gt; --&gt;</strong></pre>
     * 
     * 
     * 
     */
    @XmlElement(name = "NetworkLinkControlObjectExtensionGroup")
    protected List<AbstractObject> networkLinkControlObjectExtension;

    /**
     * Instantiates a new network link control.
     */
    public NetworkLinkControl() {
        super();
    }

    /**
     * Gets the min refresh period.
     *
     * @return     possible object is
     *     {@link Double}
     * @see minRefreshPeriod
     */
    public double getMinRefreshPeriod() {
        return minRefreshPeriod;
    }

    /**
     * Sets the min refresh period.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see minRefreshPeriod
     */
    public void setMinRefreshPeriod(double value) {
        this.minRefreshPeriod = value;
    }

    /**
     * Gets the max session length.
     *
     * @return     possible object is
     *     {@link Double}
     * @see maxSessionLength
     */
    public double getMaxSessionLength() {
        return maxSessionLength;
    }

    /**
     * Sets the max session length.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see maxSessionLength
     */
    public void setMaxSessionLength(double value) {
        this.maxSessionLength = value;
    }

    /**
     * Gets the cookie.
     *
     * @return     possible object is
     *     {@link String}
     * @see cookie
     */
    public String getCookie() {
        return cookie;
    }

    /**
     * Sets the cookie.
     *
     * @param value     allowed object is
     *     {@link String}
     * @see cookie
     */
    public void setCookie(String value) {
        this.cookie = value;
    }

    /**
     * Gets the message.
     *
     * @return     possible object is
     *     {@link String}
     * @see message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param value     allowed object is
     *     {@link String}
     * @see message
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the link name.
     *
     * @return     possible object is
     *     {@link String}
     * @see linkName
     */
    public String getLinkName() {
        return linkName;
    }

    /**
     * Sets the link name.
     *
     * @param value     allowed object is
     *     {@link String}
     * @see linkName
     */
    public void setLinkName(String value) {
        this.linkName = value;
    }

    /**
     * Gets the link description.
     *
     * @return     possible object is
     *     {@link String}
     * @see linkDescription
     */
    public String getLinkDescription() {
        return linkDescription;
    }

    /**
     * Sets the link description.
     *
     * @param value     allowed object is
     *     {@link String}
     * @see linkDescription
     */
    public void setLinkDescription(String value) {
        this.linkDescription = value;
    }

    /**
     * Gets the link snippet.
     *
     * @return     possible object is
     *     {@link Snippet}
     * @see linkSnippet
     */
    public Snippet getLinkSnippet() {
        return linkSnippet;
    }

    /**
     * Sets the link snippet.
     *
     * @param value     allowed object is
     *     {@link Snippet}
     * @see linkSnippet
     */
    public void setLinkSnippet(Snippet value) {
        this.linkSnippet = value;
    }

    /**
     * Gets the expires.
     *
     * @return     possible object is
     *     {@link String}
     * @see expires
     */
    public String getExpires() {
        return expires;
    }

    /**
     * Sets the expires.
     *
     * @param value     allowed object is
     *     {@link String}
     * @see expires
     */
    public void setExpires(String value) {
        this.expires = value;
    }

    /**
     * Gets the update.
     *
     * @return     possible object is
     *     {@link Update}
     * @see update
     */
    public Update getUpdate() {
        return update;
    }

    /**
     * Sets the update.
     *
     * @param value     allowed object is
     *     {@link Update}
     * @see update
     */
    public void setUpdate(Update value) {
        this.update = value;
    }

    /**
     * Gets the abstract view.
     *
     * @return     possible object is
     *     {@code <}{@link AbstractView}{@code>}
     *     {@code <}{@link LookAt}{@code>}
     *     {@code <}{@link Camera}{@code>}
     * @see abstractView
     */
    public AbstractView getAbstractView() {
        return abstractView;
    }

    /**
     * Sets the abstract view.
     *
     * @param value     allowed object is
     *     {@code <}{@link AbstractView}{@code>}
     *     {@code <}{@link LookAt}{@code>}
     *     {@code <}{@link Camera}{@code>}
     * @see abstractView
     */
    public void setAbstractView(AbstractView value) {
        this.abstractView = (value);
    }

    /**
     * Gets the network link control simple extension.
     *
     * @return the network link control simple extension
     * @see networkLinkControlSimpleExtension
     */
    public List<Object> getNetworkLinkControlSimpleExtension() {
        if (networkLinkControlSimpleExtension == null) {
            networkLinkControlSimpleExtension = new ArrayList<Object>();
        }
        return this.networkLinkControlSimpleExtension;
    }

    /**
     * Gets the network link control object extension.
     *
     * @return the network link control object extension
     * @see networkLinkControlObjectExtension
     */
    public List<AbstractObject> getNetworkLinkControlObjectExtension() {
        if (networkLinkControlObjectExtension == null) {
            networkLinkControlObjectExtension = new ArrayList<AbstractObject>();
        }
        return this.networkLinkControlObjectExtension;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(minRefreshPeriod);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(maxSessionLength);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        result = ((prime*result)+((cookie == null)? 0 :cookie.hashCode()));
        result = ((prime*result)+((message == null)? 0 :message.hashCode()));
        result = ((prime*result)+((linkName == null)? 0 :linkName.hashCode()));
        result = ((prime*result)+((linkDescription == null)? 0 :linkDescription.hashCode()));
        result = ((prime*result)+((linkSnippet == null)? 0 :linkSnippet.hashCode()));
        result = ((prime*result)+((expires == null)? 0 :expires.hashCode()));
        result = ((prime*result)+((update == null)? 0 :update.hashCode()));
        result = ((prime*result)+((abstractView == null)? 0 :abstractView.hashCode()));
        result = ((prime*result)+((networkLinkControlSimpleExtension == null)? 0 :networkLinkControlSimpleExtension.hashCode()));
        result = ((prime*result)+((networkLinkControlObjectExtension == null)? 0 :networkLinkControlObjectExtension.hashCode()));
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
        if ((obj instanceof NetworkLinkControl) == false) {
            return false;
        }
        NetworkLinkControl other = ((NetworkLinkControl) obj);
        if (minRefreshPeriod!= other.minRefreshPeriod) {
            return false;
        }
        if (maxSessionLength!= other.maxSessionLength) {
            return false;
        }
        if (cookie == null) {
            if (other.cookie!= null) {
                return false;
            }
        } else {
            if (cookie.equals(other.cookie) == false) {
                return false;
            }
        }
        if (message == null) {
            if (other.message!= null) {
                return false;
            }
        } else {
            if (message.equals(other.message) == false) {
                return false;
            }
        }
        if (linkName == null) {
            if (other.linkName!= null) {
                return false;
            }
        } else {
            if (linkName.equals(other.linkName) == false) {
                return false;
            }
        }
        if (linkDescription == null) {
            if (other.linkDescription!= null) {
                return false;
            }
        } else {
            if (linkDescription.equals(other.linkDescription) == false) {
                return false;
            }
        }
        if (linkSnippet == null) {
            if (other.linkSnippet!= null) {
                return false;
            }
        } else {
            if (linkSnippet.equals(other.linkSnippet) == false) {
                return false;
            }
        }
        if (expires == null) {
            if (other.expires!= null) {
                return false;
            }
        } else {
            if (expires.equals(other.expires) == false) {
                return false;
            }
        }
        if (update == null) {
            if (other.update!= null) {
                return false;
            }
        } else {
            if (update.equals(other.update) == false) {
                return false;
            }
        }
        if (abstractView == null) {
            if (other.abstractView!= null) {
                return false;
            }
        } else {
            if (abstractView.equals(other.abstractView) == false) {
                return false;
            }
        }
        if (networkLinkControlSimpleExtension == null) {
            if (other.networkLinkControlSimpleExtension!= null) {
                return false;
            }
        } else {
            if (networkLinkControlSimpleExtension.equals(other.networkLinkControlSimpleExtension) == false) {
                return false;
            }
        }
        if (networkLinkControlObjectExtension == null) {
            if (other.networkLinkControlObjectExtension!= null) {
                return false;
            }
        } else {
            if (networkLinkControlObjectExtension.equals(other.networkLinkControlObjectExtension) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a new instance of {@link Snippet} and set it to linkSnippet.
     * 
     * This method is a short version for:
     * <code>
     * Snippet snippet = new Snippet();
     * this.setLinkSnippet(snippet); </code>
     *
     * @return the snippet
     */
    public Snippet createAndSetLinkSnippet() {
        Snippet newValue = new Snippet();
        this.setLinkSnippet(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link Update} and set it to update.
     * 
     * This method is a short version for:
     * <code>
     * Update update = new Update();
     * this.setUpdate(update); </code>
     *
     * @param targetHref     required parameter
     * @param createOrDeleteOrChange     required parameter
     * @return the update
     */
    public Update createAndSetUpdate(final String targetHref, final List<Object> createOrDeleteOrChange) {
        Update newValue = new Update(targetHref, createOrDeleteOrChange);
        this.setUpdate(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link LookAt} and set it to abstractView.
     * 
     * This method is a short version for:
     * <code>
     * LookAt lookAt = new LookAt();
     * this.setAbstractView(lookAt); </code>
     *
     * @return the look at
     */
    public LookAt createAndSetLookAt() {
        LookAt newValue = new LookAt();
        this.setAbstractView(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link Camera} and set it to abstractView.
     * 
     * This method is a short version for:
     * <code>
     * Camera camera = new Camera();
     * this.setAbstractView(camera); </code>
     *
     * @return the camera
     */
    public Camera createAndSetCamera() {
        Camera newValue = new Camera();
        this.setAbstractView(newValue);
        return newValue;
    }

    /**
     * Sets the network link control simple extension.
     *
     * @param networkLinkControlSimpleExtension the new network link control simple extension
     * @see networkLinkControlSimpleExtension
     */
    public void setNetworkLinkControlSimpleExtension(final List<Object> networkLinkControlSimpleExtension) {
        this.networkLinkControlSimpleExtension = networkLinkControlSimpleExtension;
    }

    /**
     * add a value to the networkLinkControlSimpleExtension property collection.
     *
     * @param networkLinkControlSimpleExtension     Objects of the following type are allowed in the list: {@link Object}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public NetworkLinkControl addToNetworkLinkControlSimpleExtension(final Object networkLinkControlSimpleExtension) {
        this.getNetworkLinkControlSimpleExtension().add(networkLinkControlSimpleExtension);
        return this;
    }

    /**
     * Sets the network link control object extension.
     *
     * @param networkLinkControlObjectExtension the new network link control object extension
     * @see networkLinkControlObjectExtension
     */
    public void setNetworkLinkControlObjectExtension(final List<AbstractObject> networkLinkControlObjectExtension) {
        this.networkLinkControlObjectExtension = networkLinkControlObjectExtension;
    }

    /**
     * add a value to the networkLinkControlObjectExtension property collection.
     *
     * @param networkLinkControlObjectExtension     Objects of the following type are allowed in the list: {@link AbstractObject}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public NetworkLinkControl addToNetworkLinkControlObjectExtension(final AbstractObject networkLinkControlObjectExtension) {
        this.getNetworkLinkControlObjectExtension().add(networkLinkControlObjectExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param minRefreshPeriod     required parameter
     * @return the network link control
     * @see #setMinRefreshPeriod(double)
     */
    public NetworkLinkControl withMinRefreshPeriod(final double minRefreshPeriod) {
        this.setMinRefreshPeriod(minRefreshPeriod);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param maxSessionLength     required parameter
     * @return the network link control
     * @see #setMaxSessionLength(double)
     */
    public NetworkLinkControl withMaxSessionLength(final double maxSessionLength) {
        this.setMaxSessionLength(maxSessionLength);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param cookie     required parameter
     * @return the network link control
     * @see #setCookie(String)
     */
    public NetworkLinkControl withCookie(final String cookie) {
        this.setCookie(cookie);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param message     required parameter
     * @return the network link control
     * @see #setMessage(String)
     */
    public NetworkLinkControl withMessage(final String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param linkName     required parameter
     * @return the network link control
     * @see #setLinkName(String)
     */
    public NetworkLinkControl withLinkName(final String linkName) {
        this.setLinkName(linkName);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param linkDescription     required parameter
     * @return the network link control
     * @see #setLinkDescription(String)
     */
    public NetworkLinkControl withLinkDescription(final String linkDescription) {
        this.setLinkDescription(linkDescription);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param linkSnippet     required parameter
     * @return the network link control
     * @see #setLinkSnippet(Snippet)
     */
    public NetworkLinkControl withLinkSnippet(final Snippet linkSnippet) {
        this.setLinkSnippet(linkSnippet);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param expires     required parameter
     * @return the network link control
     * @see #setExpires(String)
     */
    public NetworkLinkControl withExpires(final String expires) {
        this.setExpires(expires);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param update     required parameter
     * @return the network link control
     * @see #setUpdate(Update)
     */
    public NetworkLinkControl withUpdate(final Update update) {
        this.setUpdate(update);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param abstractView     required parameter
     * @return the network link control
     * @see #setAbstractView(AbstractView)
     */
    public NetworkLinkControl withAbstractView(final AbstractView abstractView) {
        this.setAbstractView(abstractView);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param networkLinkControlSimpleExtension     required parameter
     * @return the network link control
     * @see #setNetworkLinkControlSimpleExtension(List<Object>)
     */
    public NetworkLinkControl withNetworkLinkControlSimpleExtension(final List<Object> networkLinkControlSimpleExtension) {
        this.setNetworkLinkControlSimpleExtension(networkLinkControlSimpleExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param networkLinkControlObjectExtension     required parameter
     * @return the network link control
     * @see #setNetworkLinkControlObjectExtension(List<AbstractObject>)
     */
    public NetworkLinkControl withNetworkLinkControlObjectExtension(final List<AbstractObject> networkLinkControlObjectExtension) {
        this.setNetworkLinkControlObjectExtension(networkLinkControlObjectExtension);
        return this;
    }

    @Override
    public NetworkLinkControl clone() {
        NetworkLinkControl copy;
        try {
            copy = ((NetworkLinkControl) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        copy.linkSnippet = ((linkSnippet == null)?null:((Snippet) linkSnippet.clone()));
        copy.update = ((update == null)?null:((Update) update.clone()));
        copy.abstractView = ((abstractView == null)?null:((AbstractView ) abstractView.clone()));
        copy.networkLinkControlSimpleExtension = new ArrayList<Object>((getNetworkLinkControlSimpleExtension().size()));
        for (Object iter: networkLinkControlSimpleExtension) {
            copy.networkLinkControlSimpleExtension.add(iter);
        }
        copy.networkLinkControlObjectExtension = new ArrayList<AbstractObject>((getNetworkLinkControlObjectExtension().size()));
        for (AbstractObject iter: networkLinkControlObjectExtension) {
            copy.networkLinkControlObjectExtension.add(iter.clone());
        }
        return copy;
    }

}
