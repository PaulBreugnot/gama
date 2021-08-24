/*******************************************************************************************************
 *
 * Kml.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import gama.ext.libs.kml.gx.Tour;

/**
 * <kml>
 * <p>
 * <kml xmlns="http://www.opengis.net/kml/2.2"> <NetworkLinkControl> ... </NetworkLinkControl> <!-- 0 or 1 Feature
 * elements --> </kml>
 * </p>
 * <p>
 * A basic <kml> element contains 0 or 1 Feature and 0 or 1 NetworkLinkControl:
 * </p>
 * <p>
 * The <kml> element may also include the namespace for any external XML schemas that are referenced within the file.
 * </p>
 * <p>
 * The root element of a KML file. This element is required. It follows the xml declaration at the beginning of the
 * file. The hint attribute is used as a signal to Google Earth to display the file as celestial data.
 * </p>
 *
 * Syntax:
 *
 * <pre>
 * &lt;kml xmlns="http://www.opengis.net/kml/2.2" <span>hint="target=sky"</span>&gt; ... &lt;/kml&gt;
 * </pre>
 *
 *
 *
 */
@XmlAccessorType (XmlAccessType.FIELD)
@XmlType (
		name = "KmlType",
		propOrder = { "networkLinkControl", "feature", "kmlSimpleExtension", "kmlObjectExtension" })
@XmlRootElement (
		name = "kml",
		namespace = "http://www.opengis.net/kml/2.2")
public class Kml implements Cloneable {

	/**
	 * <NetworkLinkControl>
	 * <p>
	 * Controls the behavior of files fetched by a <NetworkLink>.
	 * </p>
	 *
	 * Syntax:
	 *
	 * <pre>
	 * <strong>&lt;NetworkLinkControl&gt;</strong>
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
	 * <strong>&lt;/NetworkLinkControl&gt;</strong>
	 * </pre>
	 *
	 * See Also: <NetworkLink> <Update>
	 *
	 *
	 *
	 */
	@XmlElement (
			name = "NetworkLinkControl") protected NetworkLinkControl networkLinkControl;
	/**
	 * <Feature>
	 * <p>
	 * This is an abstract element and cannot be used directly in a KML file. The following diagram shows how some of a
	 * Feature's elements appear in Google Earth.
	 * </p>
	 *
	 * Syntax:
	 *
	 * <pre>
	 * &lt;!-- abstract element; do not create --&gt;
	 * <strong>&lt;!--<em> Feature</em> id="ID" --&gt;</strong>                &lt;!-- Document,Folder,
	 *                                              NetworkLink,Placemark,
	 *                                              GroundOverlay,PhotoOverlay,ScreenOverlay --&gt;
	 *   &lt;name&gt;<em>...</em>&lt;/name&gt;                      &lt;!-- string --&gt;
	 *   &lt;visibility&gt;1&lt;/visibility&gt;            &lt;!-- boolean --&gt;
	 *   &lt;open&gt;0&lt;/open&gt;                        &lt;!-- boolean --&gt;
	 *   <span>&lt;atom:author&gt;...&lt;atom:author&gt;         &lt;!-- xmlns:atom --&gt;
	 *   &lt;atom:link&gt;...&lt;/atom:link&gt;</span><span>            &lt;!-- xmlns:atom --&gt;</span>
	 *   &lt;address&gt;<em>...</em>&lt;/address&gt;                &lt;!-- string --&gt;
	 *   &lt;xal:AddressDetails&gt;...&lt;/xal:AddressDetails&gt;  &lt;!-- xmlns:xal --&gt;<br>  &lt;phoneNumber&gt;...&lt;/phoneNumber&gt;        &lt;!-- string --&gt;<br>  &lt;Snippet maxLines="2"&gt;<em>...</em>&lt;/Snippet&gt;   &lt;!-- string --&gt;
	 *   &lt;description&gt;<em>...</em>&lt;/description&gt;        &lt;!-- string --&gt;
	 *   <span><em>&lt;AbstractView&gt;...&lt;/AbstractView&gt;</em>      &lt;!-- Camera <em>or</em> LookAt --&gt;</span>
	 *   &lt;<em>TimePrimitive</em>&gt;...&lt;/<em>TimePrimitive</em>&gt;    &lt;!-- TimeStamp or TimeSpan --&gt;
	 *   &lt;styleUrl&gt;<em>...</em>&lt;/styleUrl&gt;              &lt;!-- anyURI --&gt;
	 *   &lt;<em>StyleSelector&gt;...&lt;/StyleSelector&gt;</em>
	 *   &lt;Region&gt;...&lt;/Region&gt;
	 *   <span>&lt;Metadata&gt;...&lt;/Metadata&gt;              &lt;!-- deprecated in KML 2.2 --&gt;
	 *   &lt;ExtendedData&gt;...&lt;/ExtendedData&gt;      &lt;!-- new in KML 2.2 --&gt;<br></span>&lt;-- /<em>Feature</em> --&gt;
	 * </pre>
	 *
	 * Extends:
	 *
	 * @see: <Object>
	 *
	 *       Extended By:
	 * @see: <Container>
	 * @see: <NetworkLink>
	 * @see: <Overlay>
	 * @see: <Placemark>
	 * @see: <gx:Tour>
	 *
	 *
	 *
	 */
	@XmlElementRef (
			name = "AbstractFeatureGroup",
			namespace = "http://www.opengis.net/kml/2.2",
			required = false) protected Feature feature;
	
	/** The kml simple extension. */
	@XmlElement (
			name = "KmlSimpleExtensionGroup") @XmlSchemaType (
					name = "anySimpleType") protected List<Object> kmlSimpleExtension;
	/**
	 * <Object>
	 * <p>
	 * This is an abstract base class and cannot be used directly in a KML file. It provides the id attribute, which
	 * allows unique identification of a KML element, and the targetId attribute, which is used to reference objects
	 * that have already been loaded into Google Earth. The id attribute must be assigned if the <Update> mechanism is
	 * to be used.
	 * </p>
	 *
	 * Syntax:
	 *
	 * <pre>
	 * &lt;!-- abstract element; do not create --&gt;<strong>
	 * &lt;!-- <em>Object</em> id="ID" targetId="NCName" --&gt;
	 * &lt;!-- /<em>Object</em>&gt; --&gt;</strong>
	 * </pre>
	 *
	 *
	 *
	 */
	@XmlElement (
			name = "KmlObjectExtensionGroup") protected List<AbstractObject> kmlObjectExtension;
	
	/** The hint. */
	@XmlAttribute (
			name = "hint") protected String hint;
	
	/** The jc. */
	private transient JAXBContext jc = null;
	
	/** The m. */
	private transient Marshaller m = null;
	
	/** The missing name counter. */
	private transient int missingNameCounter = 1;
	
	/** The Constant SCHEMA_LOCATION. */
	private final static String SCHEMA_LOCATION = "src/main/resources/schema/ogckml/ogckml22.xsd";

	/**
	 * Instantiates a new kml.
	 */
	public Kml() {
		super();
	}

	/**
	 * Gets the network link control.
	 *
	 * @return possible object is {@link NetworkLinkControl}
	 * @see networkLinkControl
	 */
	public NetworkLinkControl getNetworkLinkControl() {
		return networkLinkControl;
	}

	/**
	 * Sets the network link control.
	 *
	 * @param value            allowed object is {@link NetworkLinkControl}
	 * @see networkLinkControl
	 */
	public void setNetworkLinkControl(final NetworkLinkControl value) {
		this.networkLinkControl = value;
	}

	/**
	 * Gets the feature.
	 *
	 * @return possible object is
	 *         {@code <}{@link Container}{@code>} {@code <}{@link GroundOverlay}{@code>} {@code <}{@link NetworkLink}{@code>} {@code <}{@link Folder}{@code>} {@code <}{@link PhotoOverlay}{@code>} {@code <}{@link Document}{@code>} {@code <}{@link Tour}{@code>} {@code <}{@link ScreenOverlay}{@code>} {@code <}{@link Feature}{@code>} {@code <}{@link Placemark}{@code>} {@code <}{@link Overlay}{@code>}
	 * @see feature
	 */
	public Feature getFeature() {
		return feature;
	}

	/**
	 * Sets the feature.
	 *
	 * @param value            allowed object is
	 *            {@code <}{@link Container}{@code>} {@code <}{@link GroundOverlay}{@code>} {@code <}{@link NetworkLink}{@code>} {@code <}{@link Folder}{@code>} {@code <}{@link PhotoOverlay}{@code>} {@code <}{@link Document}{@code>} {@code <}{@link Tour}{@code>} {@code <}{@link ScreenOverlay}{@code>} {@code <}{@link Feature}{@code>} {@code <}{@link Placemark}{@code>} {@code <}{@link Overlay}{@code>}
	 * @see feature
	 */
	public void setFeature(final Feature value) {
		this.feature = value;
	}

	/**
	 * Gets the kml simple extension.
	 *
	 * @return the kml simple extension
	 * @see kmlSimpleExtension
	 */
	public List<Object> getKmlSimpleExtension() {
		if (kmlSimpleExtension == null) { kmlSimpleExtension = new ArrayList<>(); }
		return this.kmlSimpleExtension;
	}

	/**
	 * Gets the kml object extension.
	 *
	 * @return the kml object extension
	 * @see kmlObjectExtension
	 */
	public List<AbstractObject> getKmlObjectExtension() {
		if (kmlObjectExtension == null) { kmlObjectExtension = new ArrayList<>(); }
		return this.kmlObjectExtension;
	}

	/**
	 * Gets the hint.
	 *
	 * @return possible object is {@link String}
	 * @see hint
	 */
	public String getHint() {
		return hint;
	}

	/**
	 * Sets the hint.
	 *
	 * @param value            allowed object is {@link String}
	 * @see hint
	 */
	public void setHint(final String value) {
		this.hint = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (networkLinkControl == null ? 0 : networkLinkControl.hashCode());
		result = prime * result + (feature == null ? 0 : feature.hashCode());
		result = prime * result + (kmlSimpleExtension == null ? 0 : kmlSimpleExtension.hashCode());
		result = prime * result + (kmlObjectExtension == null ? 0 : kmlObjectExtension.hashCode());
		result = prime * result + (hint == null ? 0 : hint.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (obj instanceof Kml == false) return false;
		Kml other = (Kml) obj;
		if (networkLinkControl == null) {
			if (other.networkLinkControl != null) return false;
		} else {
			if (networkLinkControl.equals(other.networkLinkControl) == false) return false;
		}
		if (feature == null) {
			if (other.feature != null) return false;
		} else {
			if (feature.equals(other.feature) == false) return false;
		}
		if (kmlSimpleExtension == null) {
			if (other.kmlSimpleExtension != null) return false;
		} else {
			if (kmlSimpleExtension.equals(other.kmlSimpleExtension) == false) return false;
		}
		if (kmlObjectExtension == null) {
			if (other.kmlObjectExtension != null) return false;
		} else {
			if (kmlObjectExtension.equals(other.kmlObjectExtension) == false) return false;
		}
		if (hint == null) {
			if (other.hint != null) return false;
		} else {
			if (hint.equals(other.hint) == false) return false;
		}
		return true;
	}

	/**
	 * Creates a new instance of {@link NetworkLinkControl} and set it to networkLinkControl.
	 * 
	 * This method is a short version for: <code>
	 * NetworkLinkControl networkLinkControl = new NetworkLinkControl();
	 * this.setNetworkLinkControl(networkLinkControl); </code>
	 *
	 * @return the network link control
	 */
	public NetworkLinkControl createAndSetNetworkLinkControl() {
		NetworkLinkControl newValue = new NetworkLinkControl();
		this.setNetworkLinkControl(newValue);
		return newValue;
	}

	/**
	 * Creates a new instance of {@link Tour} and set it to feature.
	 * 
	 * This method is a short version for: <code>
	 * Tour tour = new Tour();
	 * this.setFeature(tour); </code>
	 *
	 * @return the tour
	 */
	public Tour createAndSetTour() {
		Tour newValue = new Tour();
		this.setFeature(newValue);
		return newValue;
	}

	/**
	 * Creates a new instance of {@link ScreenOverlay} and set it to feature.
	 * 
	 * This method is a short version for: <code>
	 * ScreenOverlay screenOverlay = new ScreenOverlay();
	 * this.setFeature(screenOverlay); </code>
	 *
	 * @return the screen overlay
	 */
	public ScreenOverlay createAndSetScreenOverlay() {
		ScreenOverlay newValue = new ScreenOverlay();
		this.setFeature(newValue);
		return newValue;
	}

	/**
	 * Creates a new instance of {@link PhotoOverlay} and set it to feature.
	 * 
	 * This method is a short version for: <code>
	 * PhotoOverlay photoOverlay = new PhotoOverlay();
	 * this.setFeature(photoOverlay); </code>
	 *
	 * @return the photo overlay
	 */
	public PhotoOverlay createAndSetPhotoOverlay() {
		PhotoOverlay newValue = new PhotoOverlay();
		this.setFeature(newValue);
		return newValue;
	}

	/**
	 * Creates a new instance of {@link GroundOverlay} and set it to feature.
	 * 
	 * This method is a short version for: <code>
	 * GroundOverlay groundOverlay = new GroundOverlay();
	 * this.setFeature(groundOverlay); </code>
	 *
	 * @return the ground overlay
	 */
	public GroundOverlay createAndSetGroundOverlay() {
		GroundOverlay newValue = new GroundOverlay();
		this.setFeature(newValue);
		return newValue;
	}

	/**
	 * Creates a new instance of {@link NetworkLink} and set it to feature.
	 * 
	 * This method is a short version for: <code>
	 * NetworkLink networkLink = new NetworkLink();
	 * this.setFeature(networkLink); </code>
	 *
	 * @return the network link
	 */
	public NetworkLink createAndSetNetworkLink() {
		NetworkLink newValue = new NetworkLink();
		this.setFeature(newValue);
		return newValue;
	}

	/**
	 * Creates a new instance of {@link Folder} and set it to feature.
	 * 
	 * This method is a short version for: <code>
	 * Folder folder = new Folder();
	 * this.setFeature(folder); </code>
	 *
	 * @return the folder
	 */
	public Folder createAndSetFolder() {
		Folder newValue = new Folder();
		this.setFeature(newValue);
		return newValue;
	}

	/**
	 * Creates a new instance of {@link Document} and set it to feature.
	 * 
	 * This method is a short version for: <code>
	 * Document document = new Document();
	 * this.setFeature(document); </code>
	 *
	 * @return the document
	 */
	public Document createAndSetDocument() {
		Document newValue = new Document();
		this.setFeature(newValue);
		return newValue;
	}

	/**
	 * Creates a new instance of {@link Placemark} and set it to feature.
	 * 
	 * This method is a short version for: <code>
	 * Placemark placemark = new Placemark();
	 * this.setFeature(placemark); </code>
	 *
	 * @return the placemark
	 */
	public Placemark createAndSetPlacemark() {
		Placemark newValue = new Placemark();
		this.setFeature(newValue);
		return newValue;
	}

	/**
	 * Sets the kml simple extension.
	 *
	 * @param kmlSimpleExtension the new kml simple extension
	 * @see kmlSimpleExtension
	 */
	public void setKmlSimpleExtension(final List<Object> kmlSimpleExtension) {
		this.kmlSimpleExtension = kmlSimpleExtension;
	}

	/**
	 * add a value to the kmlSimpleExtension property collection.
	 *
	 * @param kmlSimpleExtension            Objects of the following type are allowed in the list: {@link Object}
	 * @return <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
	 */
	public Kml addToKmlSimpleExtension(final Object kmlSimpleExtension) {
		this.getKmlSimpleExtension().add(kmlSimpleExtension);
		return this;
	}

	/**
	 * Sets the kml object extension.
	 *
	 * @param kmlObjectExtension the new kml object extension
	 * @see kmlObjectExtension
	 */
	public void setKmlObjectExtension(final List<AbstractObject> kmlObjectExtension) {
		this.kmlObjectExtension = kmlObjectExtension;
	}

	/**
	 * add a value to the kmlObjectExtension property collection.
	 *
	 * @param kmlObjectExtension            Objects of the following type are allowed in the list: {@link AbstractObject}
	 * @return <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
	 */
	public Kml addToKmlObjectExtension(final AbstractObject kmlObjectExtension) {
		this.getKmlObjectExtension().add(kmlObjectExtension);
		return this;
	}

	/**
	 * fluent setter.
	 *
	 * @param networkLinkControl            required parameter
	 * @return the kml
	 * @see #setNetworkLinkControl(NetworkLinkControl)
	 */
	public Kml withNetworkLinkControl(final NetworkLinkControl networkLinkControl) {
		this.setNetworkLinkControl(networkLinkControl);
		return this;
	}

	/**
	 * fluent setter.
	 *
	 * @param feature            required parameter
	 * @return the kml
	 * @see #setFeature(Feature)
	 */
	public Kml withFeature(final Feature feature) {
		this.setFeature(feature);
		return this;
	}

	/**
	 * fluent setter.
	 *
	 * @param kmlSimpleExtension            required parameter
	 * @return the kml
	 * @see #setKmlSimpleExtension(List<Object>)
	 */
	public Kml withKmlSimpleExtension(final List<Object> kmlSimpleExtension) {
		this.setKmlSimpleExtension(kmlSimpleExtension);
		return this;
	}

	/**
	 * fluent setter.
	 *
	 * @param kmlObjectExtension            required parameter
	 * @return the kml
	 * @see #setKmlObjectExtension(List<AbstractObject>)
	 */
	public Kml withKmlObjectExtension(final List<AbstractObject> kmlObjectExtension) {
		this.setKmlObjectExtension(kmlObjectExtension);
		return this;
	}

	/**
	 * fluent setter.
	 *
	 * @param hint            required parameter
	 * @return the kml
	 * @see #setHint(String)
	 */
	public Kml withHint(final String hint) {
		this.setHint(hint);
		return this;
	}

	/**
	 * Gets the jaxb context.
	 *
	 * @return the jaxb context
	 * @throws JAXBException the JAXB exception
	 * @see jaxbContext
	 */
	private JAXBContext getJaxbContext() throws JAXBException {
		if (jc == null) { jc = JAXBContext.newInstance(Kml.class); }
		return jc;
	}

	/**
	 * Creates the marshaller.
	 *
	 * @return the marshaller
	 * @throws JAXBException the JAXB exception
	 */
	private Marshaller createMarshaller() throws JAXBException {
		if (m == null) {
			m = this.getJaxbContext().createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new Kml.NameSpaceBeautyfier());
		}
		return m;
	}

	/**
	 * Internal method.
	 *
	 * @param kmzFile the kmz file
	 * @param out the out
	 * @param mainfile the mainfile
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void addKmzFile(final Kml kmzFile, final ZipOutputStream out, final boolean mainfile) throws IOException {
		String fileName = null;
		if (kmzFile.getFeature() == null || kmzFile.getFeature().getName() == null
				|| kmzFile.getFeature().getName().length() == 0) {
			fileName = "noFeatureNameSet" + missingNameCounter++ + ".kml";
		} else {
			fileName = kmzFile.getFeature().getName();
			if (!fileName.endsWith(".kml")) { fileName += ".kml"; }
		}
		if (mainfile) { fileName = "doc.kml"; }
		out.putNextEntry(new ZipEntry(URLEncoder.encode(fileName, "UTF-8")));
		kmzFile.marshal(out);
		out.closeEntry();
	}

	/**
	 * Java to KML The object graph is marshalled to an OutputStream object. The object is not saved as a zipped .kmz
	 * file.
	 *
	 * @param outputstream the outputstream
	 * @return true, if successful
	 * @throws FileNotFoundException the file not found exception
	 * @see marshalKmz(String, Kml...)
	 */
	public boolean marshal(final OutputStream outputstream) throws FileNotFoundException {
		try {
			m = this.createMarshaller();
			m.marshal(this, outputstream);
			return true;
		} catch (JAXBException _x) {
			_x.printStackTrace();
			return false;
		}
	}

	/**
	 * Java to KML The object graph is marshalled to a Writer object. The object is not saved as a zipped .kmz file.
	 *
	 * @param writer the writer
	 * @return true, if successful
	 * @see marshalKmz(String, Kml...)
	 */
	public boolean marshal(final Writer writer) {
		try {
			m = this.createMarshaller();
			m.marshal(this, writer);
			return true;
		} catch (JAXBException _x) {
			_x.printStackTrace();
			return false;
		}
	}

	/**
	 * Java to KML The object graph is marshalled to a Contenthandler object. Useful if marshaller cis needed to
	 * generate CDATA blocks. {@link https://jaxb.dev.java.net/faq/}
	 * {@link http://code.google.com/p/javaapiforkml/issues/detail?id=7} The object is not saved as a zipped .kmz file.
	 *
	 * @param contenthandler the contenthandler
	 * @return true, if successful
	 * @see marshalKmz(String, Kml...)
	 */
	public boolean marshal(final ContentHandler contenthandler) {
		try {
			m = this.createMarshaller();
			m.marshal(this, contenthandler);
			return true;
		} catch (JAXBException _x) {
			_x.printStackTrace();
			return false;
		}
	}

	/**
	 * Java to KML The object graph is printed to the console. (Nothing is saved, nor saved. Just printed.)
	 *
	 * @return true, if successful
	 */
	public boolean marshal() {
		try {
			m = this.createMarshaller();
			m.marshal(this, System.out);
			return true;
		} catch (JAXBException _x) {
			_x.printStackTrace();
			return false;
		}
	}

	/**
	 * Java to KML The object graph is marshalled to a File object. The object is not saved as a zipped .kmz file.
	 *
	 * @param filename the filename
	 * @return true, if successful
	 * @throws FileNotFoundException the file not found exception
	 * @see marshalKmz(String, Kml...)
	 */
	public boolean marshal(final File filename) throws FileNotFoundException {
		OutputStream out = new FileOutputStream(filename);
		return this.marshal(out);
	}

	/**
	 * Marshal as kmz.
	 *
	 * @param name the name
	 * @param additionalFiles the additional files
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public boolean marshalAsKmz(final String name, final Kml... additionalFiles) throws IOException {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(name));
		out.setComment("KMZ-file created with Java API for KML. Visit us: http://code.google.com/p/javaapiforkml/");
		this.addKmzFile(this, out, true);
		for (Kml kml : additionalFiles) {
			this.addKmzFile(kml, out, false);
		}
		out.close();
		missingNameCounter = 1;
		return false;
	}

	/**
	 * Validate.
	 *
	 * @param unmarshaller the unmarshaller
	 * @return true, if successful
	 */
	private static boolean validate(final Unmarshaller unmarshaller) {
		try {
			SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema" /*XMLConstants.W3C_XML_SCHEMA_NS_URI*/);
			File schemaFile = new File(SCHEMA_LOCATION);
			Schema schema = sf.newSchema(schemaFile);
			unmarshaller.setSchema(schema);
			return true;
		} catch (SAXException _x) {
			_x.printStackTrace();
		}
		return false;
	}

	/**
	 * KML to Java KML given as a file object is transformed into a graph of Java objects. The boolean value indicates,
	 * whether the File object should be validated automatically during unmarshalling and be checked if the object graph
	 * meets all constraints defined in OGC's KML schema specification.
	 *
	 * @param file the file
	 * @param validate the validate
	 * @return the kml
	 */
	public static Kml unmarshal(final File file, final boolean validate) {
		try {
			Unmarshaller unmarshaller = JAXBContext.newInstance(Kml.class).createUnmarshaller();
			if (validate == true) { Kml.validate(unmarshaller); }
			InputSource input = new InputSource(new FileReader(file));
			SAXSource saxSource = new SAXSource(new NamespaceFilterXMLReader(validate), input);
			Kml jaxbRootElement = (Kml) unmarshaller.unmarshal(saxSource);
			return jaxbRootElement;
		} catch (SAXException _x) {
			_x.printStackTrace();
		} catch (ParserConfigurationException _x) {
			_x.printStackTrace();
		} catch (JAXBException _x) {
			_x.printStackTrace();
		} catch (FileNotFoundException _x) {
			_x.printStackTrace();
		}
		return null;
	}

	/**
	 * KML to Java KML given as a file object is transformed into a graph of Java objects. Similar to the method:
	 * unmarshal(final File, final boolean) with the exception that the File object is not validated (boolean is false).
	 *
	 * @param file the file
	 * @return the kml
	 */
	public static Kml unmarshal(final File file) {
		return Kml.unmarshal(file, false);
	}

	/**
	 * KML to Java Similar to the other unmarshal methods
	 * 
	 * with the exception that it transforms a String into a graph of Java objects.
	 *
	 * @param content the content
	 * @return the kml
	 */
	public static Kml unmarshal(final String content) {
		try {
			Unmarshaller unmarshaller = JAXBContext.newInstance(Kml.class).createUnmarshaller();
			InputSource input = new InputSource(new StringReader(content));
			SAXSource saxSource = new SAXSource(new NamespaceFilterXMLReader(false), input);
			Kml jaxbRootElement = (Kml) unmarshaller.unmarshal(saxSource);
			return jaxbRootElement;
		} catch (SAXException _x) {
			_x.printStackTrace();
		} catch (ParserConfigurationException _x) {
			_x.printStackTrace();
		} catch (JAXBException _x) {
			_x.printStackTrace();
		}
		return null;
	}

	/**
	 * KML to Java Similar to the other unmarshal methods
	 * 
	 * with the exception that it transforms a InputStream into a graph of Java objects.
	 *
	 * @param content the content
	 * @return the kml
	 */
	public static Kml unmarshal(final InputStream content) {
		try {
			Unmarshaller unmarshaller = JAXBContext.newInstance(Kml.class).createUnmarshaller();
			InputSource input = new InputSource(content);
			SAXSource saxSource = new SAXSource(new NamespaceFilterXMLReader(false), input);
			Kml jaxbRootElement = (Kml) unmarshaller.unmarshal(saxSource);
			return jaxbRootElement;
		} catch (SAXException _x) {
			_x.printStackTrace();
		} catch (ParserConfigurationException _x) {
			_x.printStackTrace();
		} catch (JAXBException _x) {
			_x.printStackTrace();
		}
		return null;
	}

	/**
	 * KMZ to Java Similar to the other unmarshal methods
	 * 
	 * with the exception that it transforms a KMZ-file into a graph of Java objects.
	 *
	 * @param file the file
	 * @return the kml[]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Kml[] unmarshalFromKmz(final File file) throws IOException {
		Kml[] EMPTY_KML_ARRAY = new Kml[0];
		if (!file.getName().endsWith(".kmz")) return EMPTY_KML_ARRAY;
		ZipFile zip = new ZipFile(file);
		Enumeration<? extends ZipEntry> entries = zip.entries();
		if (!file.exists()) return EMPTY_KML_ARRAY;
		ArrayList<Kml> kmlfiles = new ArrayList<>();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			if (entry.getName().contains("__MACOSX") || entry.getName().contains(".DS_STORE")) { continue; }
			String entryName = URLDecoder.decode(entry.getName(), "UTF-8");
			if (!entryName.endsWith(".kml")) { continue; }
			InputStream in = zip.getInputStream(entry);
			Kml unmarshal = Kml.unmarshal(in);
			kmlfiles.add(unmarshal);
		}
		zip.close();
		return kmlfiles.toArray(EMPTY_KML_ARRAY);
	}

	@Override
	public Kml clone() {
		Kml copy;
		try {
			copy = (Kml) super.clone();
		} catch (CloneNotSupportedException _x) {
			throw new InternalError(_x.toString());
		}
		copy.networkLinkControl = networkLinkControl == null ? null : (NetworkLinkControl) networkLinkControl.clone();
		copy.feature = feature == null ? null : (Feature) feature.clone();
		copy.kmlSimpleExtension = new ArrayList<>(getKmlSimpleExtension().size());
		for (Object iter : kmlSimpleExtension) {
			copy.kmlSimpleExtension.add(iter);
		}
		copy.kmlObjectExtension = new ArrayList<>(getKmlObjectExtension().size());
		for (AbstractObject iter : kmlObjectExtension) {
			copy.kmlObjectExtension.add(iter.clone());
		}
		return copy;
	}

	/**
	 * The Class NameSpaceBeautyfier.
	 */
	@SuppressWarnings ("restriction")
	private final static class NameSpaceBeautyfier extends NamespacePrefixMapper {

		/**
		 * Internal method!
		 * <p>
		 * Customizing Namespace Prefixes During Marshalling to a more readable format.
		 * </p>
		 * <p>
		 * The default output is like:
		 * </p>
		 *
		 * <pre>
		 * {@code&lt;kml ... xmlns:ns2="http://www.w3.org/2005/Atom" xmlns:ns3="urn:oasis:names:tc:ciq:xsdschema:xAL:2.0" xmlns:ns4="http://www.google.com/kml/ext/2.2"&gt;}
		 * </pre>
		 * <p>
		 * is changed to:
		 * </p>
		 *
		 * <pre>
		 * {@code &lt;kml ... xmlns:atom="http://www.w3.org/2005/Atom" xmlns:xal="urn:oasis:names:tc:ciq:xsdschema:xAL:2.0" xmlns:gx="http://www.google.com/kml/ext/2.2"&gt;}
		 * </pre>
		 * <p>
		 * What it does:
		 * </p>
		 * <p>
		 * namespaceUri: http://www.w3.org/2005/Atom prefix: atom
		 * </p>
		 * <p>
		 * namespaceUri: urn:oasis:names:tc:ciq:xsdschema:xAL:2.0 prefix: xal
		 * </p>
		 * <p>
		 * namespaceUri: http://www.google.com/kml/ext/2.2 prefix: gx
		 * </p>
		 * <p>
		 * namespaceUri: anything else prefix: null
		 * </p>
		 *
		 */
		@Override
		public String getPreferredPrefix(final String namespaceUri, final String suggestion,
				final boolean requirePrefix) {
			if (namespaceUri.matches("http://www.w3.org/\\d{4}/Atom")) return "atom";
			if (namespaceUri.matches("urn:oasis:names:tc:ciq:xsdschema:xAL:.*?")) return "xal";
			if (namespaceUri.matches("http://www.google.com/kml/ext/.*?")) return "gx";
			return null;
		}

	}

}
