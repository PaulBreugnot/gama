/*******************************************************************************************************
 *
 * KmlFactory.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml;

import java.util.List;

import gama.ext.libs.kml.atom.Author;
import gama.ext.libs.kml.gx.AnimatedUpdate;
import gama.ext.libs.kml.gx.FlyTo;
import gama.ext.libs.kml.gx.LatLonQuad;
import gama.ext.libs.kml.gx.MultiTrack;
import gama.ext.libs.kml.gx.Option;
import gama.ext.libs.kml.gx.Playlist;
import gama.ext.libs.kml.gx.SimpleArrayData;
import gama.ext.libs.kml.gx.SimpleArrayField;
import gama.ext.libs.kml.gx.SoundCue;
import gama.ext.libs.kml.gx.Tour;
import gama.ext.libs.kml.gx.TourControl;
import gama.ext.libs.kml.gx.Track;
import gama.ext.libs.kml.gx.ViewerOptions;
import gama.ext.libs.kml.gx.Wait;
import gama.ext.libs.kml.xal.AddressDetails;
import gama.ext.libs.kml.xal.AddressLine;
import gama.ext.libs.kml.xal.AddressLines;
import gama.ext.libs.kml.xal.AdministrativeArea;
import gama.ext.libs.kml.xal.BuildingName;
import gama.ext.libs.kml.xal.CountryName;
import gama.ext.libs.kml.xal.Department;
import gama.ext.libs.kml.xal.DependentLocality;
import gama.ext.libs.kml.xal.Firm;
import gama.ext.libs.kml.xal.LargeMailUser;
import gama.ext.libs.kml.xal.Locality;
import gama.ext.libs.kml.xal.MailStop;
import gama.ext.libs.kml.xal.PostBox;
import gama.ext.libs.kml.xal.PostOffice;
import gama.ext.libs.kml.xal.PostalCode;
import gama.ext.libs.kml.xal.PostalRoute;
import gama.ext.libs.kml.xal.Premise;
import gama.ext.libs.kml.xal.PremiseNumber;
import gama.ext.libs.kml.xal.PremiseNumberPrefix;
import gama.ext.libs.kml.xal.PremiseNumberSuffix;
import gama.ext.libs.kml.xal.SubPremise;
import gama.ext.libs.kml.xal.Thoroughfare;
import gama.ext.libs.kml.xal.ThoroughfareLeadingType;
import gama.ext.libs.kml.xal.ThoroughfareName;
import gama.ext.libs.kml.xal.ThoroughfareNumber;
import gama.ext.libs.kml.xal.ThoroughfareNumberPrefix;
import gama.ext.libs.kml.xal.ThoroughfareNumberSuffix;
import gama.ext.libs.kml.xal.ThoroughfarePostDirection;
import gama.ext.libs.kml.xal.ThoroughfarePreDirection;
import gama.ext.libs.kml.xal.ThoroughfareTrailingType;
import gama.ext.libs.kml.xal.XAL;


/**
 * Factory functions to create all KML complex elements.
 * 
 */
public final class KmlFactory {


    /**
     * Create an instance of {@link Alias}.
     *
     * @return the alias
     */
    public static Alias createAlias() {
        return new Alias();
    }

    /**
     * Create an instance of {@link BalloonStyle}.
     *
     * @return the balloon style
     */
    public static BalloonStyle createBalloonStyle() {
        return new BalloonStyle();
    }

    /**
     * Create an instance of {@link BasicLink}.
     *
     * @return the basic link
     */
    public static BasicLink createBasicLink() {
        return new BasicLink();
    }

    /**
     * Create an instance of {@link Boundary}.
     *
     * @return the boundary
     */
    public static Boundary createBoundary() {
        return new Boundary();
    }

    /**
     * Create an instance of {@link Camera}.
     *
     * @return the camera
     */
    public static Camera createCamera() {
        return new Camera();
    }

    /**
     * Create an instance of {@link Change}.
     *
     * @return the change
     */
    public static Change createChange() {
        return new Change();
    }

    /**
     * Create an instance of {@link Coordinate}.
     *
     * @param longitude     required parameter
     * @param latitude     required parameter
     * @return the coordinate
     */
    public static Coordinate createCoordinate(final double longitude, final double latitude) {
        return new Coordinate(longitude, latitude);
    }

    /**
     * Create an instance of {@link Coordinate}.
     *
     * @param longitude     required parameter
     * @param latitude     required parameter
     * @param altitude     required parameter
     * @return the coordinate
     */
    public static Coordinate createCoordinate(final double longitude, final double latitude, final double altitude) {
        return new Coordinate(longitude, latitude, altitude);
    }

    /**
     * Create an instance of {@link Coordinate}.
     *
     * @param coordinates     required parameter
     * @return the coordinate
     */
    public static Coordinate createCoordinate(final String coordinates) {
        return new Coordinate(coordinates);
    }

    /**
     * Create an instance of {@link Create}.
     *
     * @return the creates the
     */
    public static Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link Data}.
     *
     * @param value     required parameter
     * @return the data
     */
    public static Data createData(final String value) {
        return new Data(value);
    }

    /**
     * Create an instance of {@link Delete}.
     *
     * @return the delete
     */
    public static Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link Document}.
     *
     * @return the document
     */
    public static Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link ExtendedData}.
     *
     * @return the extended data
     */
    public static ExtendedData createExtendedData() {
        return new ExtendedData();
    }

    /**
     * Create an instance of {@link Folder}.
     *
     * @return the folder
     */
    public static Folder createFolder() {
        return new Folder();
    }

    /**
     * Create an instance of {@link GroundOverlay}.
     *
     * @return the ground overlay
     */
    public static GroundOverlay createGroundOverlay() {
        return new GroundOverlay();
    }

    /**
     * Create an instance of {@link Icon}.
     *
     * @return the icon
     */
    public static Icon createIcon() {
        return new Icon();
    }

    /**
     * Create an instance of {@link IconStyle}.
     *
     * @return the icon style
     */
    public static IconStyle createIconStyle() {
        return new IconStyle();
    }

    /**
     * Create an instance of {@link ImagePyramid}.
     *
     * @return the image pyramid
     */
    public static ImagePyramid createImagePyramid() {
        return new ImagePyramid();
    }

    /**
     * Create an instance of {@link ItemIcon}.
     *
     * @return the item icon
     */
    public static ItemIcon createItemIcon() {
        return new ItemIcon();
    }

    /**
     * Create an instance of {@link Kml}.
     *
     * @return the kml
     */
    public static Kml createKml() {
        return new Kml();
    }

    /**
     * Create an instance of {@link LabelStyle}.
     *
     * @return the label style
     */
    public static LabelStyle createLabelStyle() {
        return new LabelStyle();
    }

    /**
     * Create an instance of {@link LatLonAltBox}.
     *
     * @return the lat lon alt box
     */
    public static LatLonAltBox createLatLonAltBox() {
        return new LatLonAltBox();
    }

    /**
     * Create an instance of {@link LatLonBox}.
     *
     * @return the lat lon box
     */
    public static LatLonBox createLatLonBox() {
        return new LatLonBox();
    }

    /**
     * Create an instance of {@link LineString}.
     *
     * @return the line string
     */
    public static LineString createLineString() {
        return new LineString();
    }

    /**
     * Create an instance of {@link LineStyle}.
     *
     * @return the line style
     */
    public static LineStyle createLineStyle() {
        return new LineStyle();
    }

    /**
     * Create an instance of {@link LinearRing}.
     *
     * @return the linear ring
     */
    public static LinearRing createLinearRing() {
        return new LinearRing();
    }

    /**
     * Create an instance of {@link gama.ext.libs.kml.Link}
     *
     * @return the link
     */
    public static gama.ext.libs.kml.Link createLink() {
        return new gama.ext.libs.kml.Link();
    }

    /**
     * Create an instance of {@link ListStyle}.
     *
     * @return the list style
     */
    public static ListStyle createListStyle() {
        return new ListStyle();
    }

    /**
     * Create an instance of {@link Location}.
     *
     * @return the location
     */
    public static Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link Lod}.
     *
     * @return the lod
     */
    public static Lod createLod() {
        return new Lod();
    }

    /**
     * Create an instance of {@link LookAt}.
     *
     * @return the look at
     */
    public static LookAt createLookAt() {
        return new LookAt();
    }

    /**
     * Create an instance of {@link Metadata}.
     *
     * @return the metadata
     */
    public static Metadata createMetadata() {
        return new Metadata();
    }

    /**
     * Create an instance of {@link Model}.
     *
     * @return the model
     */
    public static Model createModel() {
        return new Model();
    }

    /**
     * Create an instance of {@link MultiGeometry}.
     *
     * @return the multi geometry
     */
    public static MultiGeometry createMultiGeometry() {
        return new MultiGeometry();
    }

    /**
     * Create an instance of {@link NetworkLink}.
     *
     * @return the network link
     */
    public static NetworkLink createNetworkLink() {
        return new NetworkLink();
    }

    /**
     * Create an instance of {@link NetworkLinkControl}.
     *
     * @return the network link control
     */
    public static NetworkLinkControl createNetworkLinkControl() {
        return new NetworkLinkControl();
    }

    /**
     * Create an instance of {@link Orientation}.
     *
     * @return the orientation
     */
    public static Orientation createOrientation() {
        return new Orientation();
    }

    /**
     * Create an instance of {@link Pair}.
     *
     * @return the pair
     */
    public static Pair createPair() {
        return new Pair();
    }

    /**
     * Create an instance of {@link PhotoOverlay}.
     *
     * @return the photo overlay
     */
    public static PhotoOverlay createPhotoOverlay() {
        return new PhotoOverlay();
    }

    /**
     * Create an instance of {@link Placemark}.
     *
     * @return the placemark
     */
    public static Placemark createPlacemark() {
        return new Placemark();
    }

    /**
     * Create an instance of {@link Point}.
     *
     * @return the point
     */
    public static Point createPoint() {
        return new Point();
    }

    /**
     * Create an instance of {@link PolyStyle}.
     *
     * @return the poly style
     */
    public static PolyStyle createPolyStyle() {
        return new PolyStyle();
    }

    /**
     * Create an instance of {@link Polygon}.
     *
     * @return the polygon
     */
    public static Polygon createPolygon() {
        return new Polygon();
    }

    /**
     * Create an instance of {@link Region}.
     *
     * @return the region
     */
    public static Region createRegion() {
        return new Region();
    }

    /**
     * Create an instance of {@link ResourceMap}.
     *
     * @return the resource map
     */
    public static ResourceMap createResourceMap() {
        return new ResourceMap();
    }

    /**
     * Create an instance of {@link Scale}.
     *
     * @return the scale
     */
    public static Scale createScale() {
        return new Scale();
    }

    /**
     * Create an instance of {@link Schema}.
     *
     * @return the schema
     */
    public static Schema createSchema() {
        return new Schema();
    }

    /**
     * Create an instance of {@link SchemaData}.
     *
     * @return the schema data
     */
    public static SchemaData createSchemaData() {
        return new SchemaData();
    }

    /**
     * Create an instance of {@link ScreenOverlay}.
     *
     * @return the screen overlay
     */
    public static ScreenOverlay createScreenOverlay() {
        return new ScreenOverlay();
    }

    /**
     * Create an instance of {@link SimpleData}.
     *
     * @param name     required parameter
     * @return the simple data
     */
    public static SimpleData createSimpleData(final String name) {
        return new SimpleData(name);
    }

    /**
     * Create an instance of {@link SimpleField}.
     *
     * @return the simple field
     */
    public static SimpleField createSimpleField() {
        return new SimpleField();
    }

    /**
     * Create an instance of {@link Snippet}.
     *
     * @return the snippet
     */
    public static Snippet createSnippet() {
        return new Snippet();
    }

    /**
     * Create an instance of {@link Style}.
     *
     * @return the style
     */
    public static Style createStyle() {
        return new Style();
    }

    /**
     * Create an instance of {@link StyleMap}.
     *
     * @return the style map
     */
    public static StyleMap createStyleMap() {
        return new StyleMap();
    }

    /**
     * Create an instance of {@link TimeSpan}.
     *
     * @return the time span
     */
    public static TimeSpan createTimeSpan() {
        return new TimeSpan();
    }

    /**
     * Create an instance of {@link TimeStamp}.
     *
     * @return the time stamp
     */
    public static TimeStamp createTimeStamp() {
        return new TimeStamp();
    }

    /**
     * Create an instance of {@link Update}.
     *
     * @param targetHref     required parameter
     * @param createOrDeleteOrChange     required parameter
     * @return the update
     */
    public static Update createUpdate(final String targetHref, final List<Object> createOrDeleteOrChange) {
        return new Update(targetHref, createOrDeleteOrChange);
    }

    /**
     * Create an instance of {@link Vec2}.
     *
     * @return the vec 2
     */
    public static Vec2 createVec2() {
        return new Vec2();
    }

    /**
     * Create an instance of {@link ViewVolume}.
     *
     * @return the view volume
     */
    public static ViewVolume createViewVolume() {
        return new ViewVolume();
    }

    /**
     * Create an instance of {@link Author}.
     *
     * @return the author
     */
    public static Author createAtomAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link gama.ext.libs.kml.atom.Link}
     *
     * @param href     required parameter
     * @return the link
     */
    public static gama.ext.libs.kml.atom.Link createAtomLink(final String href) {
        return new gama.ext.libs.kml.atom.Link(href);
    }

    /**
     * Create an instance of {@link AnimatedUpdate}.
     *
     * @return the animated update
     */
    public static AnimatedUpdate createGxAnimatedUpdate() {
        return new AnimatedUpdate();
    }

    /**
     * Create an instance of {@link FlyTo}.
     *
     * @return the fly to
     */
    public static FlyTo createGxFlyTo() {
        return new FlyTo();
    }

    /**
     * Create an instance of {@link LatLonQuad}.
     *
     * @return the lat lon quad
     */
    public static LatLonQuad createGxLatLonQuad() {
        return new LatLonQuad();
    }

    /**
     * Create an instance of {@link MultiTrack}.
     *
     * @return the multi track
     */
    public static MultiTrack createGxMultiTrack() {
        return new MultiTrack();
    }

    /**
     * Create an instance of {@link Option}.
     *
     * @return the option
     */
    public static Option createGxOption() {
        return new Option();
    }

    /**
     * Create an instance of {@link Playlist}.
     *
     * @return the playlist
     */
    public static Playlist createGxPlaylist() {
        return new Playlist();
    }

    /**
     * Create an instance of {@link SimpleArrayData}.
     *
     * @return the simple array data
     */
    public static SimpleArrayData createGxSimpleArrayData() {
        return new SimpleArrayData();
    }

    /**
     * Create an instance of {@link SimpleArrayField}.
     *
     * @return the simple array field
     */
    public static SimpleArrayField createGxSimpleArrayField() {
        return new SimpleArrayField();
    }

    /**
     * Create an instance of {@link SoundCue}.
     *
     * @return the sound cue
     */
    public static SoundCue createGxSoundCue() {
        return new SoundCue();
    }

    /**
     * Create an instance of {@link Tour}.
     *
     * @return the tour
     */
    public static Tour createGxTour() {
        return new Tour();
    }

    /**
     * Create an instance of {@link TourControl}.
     *
     * @return the tour control
     */
    public static TourControl createGxTourControl() {
        return new TourControl();
    }

    /**
     * Create an instance of {@link Track}.
     *
     * @return the track
     */
    public static Track createGxTrack() {
        return new Track();
    }

    /**
     * Create an instance of {@link ViewerOptions}.
     *
     * @param option     required parameter
     * @return the viewer options
     */
    public static ViewerOptions createGxViewerOptions(final List<Option> option) {
        return new ViewerOptions(option);
    }

    /**
     * Create an instance of {@link Wait}.
     *
     * @return the wait
     */
    public static Wait createGxWait() {
        return new Wait();
    }

    /**
     * Create an instance of {@link AddressDetails}.
     *
     * @param xalAddress     required parameter
     * @param addressLines     required parameter
     * @param country     required parameter
     * @param administrativeArea     required parameter
     * @param locality     required parameter
     * @param thoroughfare     required parameter
     * @return the address details
     */
    public static AddressDetails createXalAddressDetails(final AddressDetails.Address xalAddress, final AddressLines addressLines, final AddressDetails.Country country, final AdministrativeArea administrativeArea, final Locality locality, final Thoroughfare thoroughfare) {
        return new AddressDetails(xalAddress, addressLines, country, administrativeArea, locality, thoroughfare);
    }

    /**
     * Create an instance of {@link AddressLine}.
     *
     * @return the address line
     */
    public static AddressLine createXalAddressLine() {
        return new AddressLine();
    }

    /**
     * Create an instance of {@link AddressLines}.
     *
     * @param addressLine     required parameter
     * @return the address lines
     */
    public static AddressLines createXalAddressLines(final List<AddressLine> addressLine) {
        return new AddressLines(addressLine);
    }

    /**
     * Create an instance of {@link AdministrativeArea}.
     *
     * @param locality     required parameter
     * @param postOffice     required parameter
     * @param postalCode     required parameter
     * @return the administrative area
     */
    public static AdministrativeArea createXalAdministrativeArea(final Locality locality, final PostOffice postOffice, final PostalCode postalCode) {
        return new AdministrativeArea(locality, postOffice, postalCode);
    }

    /**
     * Create an instance of {@link BuildingName}.
     *
     * @return the building name
     */
    public static BuildingName createXalBuildingName() {
        return new BuildingName();
    }

    /**
     * Create an instance of {@link CountryName}.
     *
     * @return the country name
     */
    public static CountryName createXalCountryName() {
        return new CountryName();
    }

    /**
     * Create an instance of {@link Department}.
     *
     * @return the department
     */
    public static Department createXalDepartment() {
        return new Department();
    }

    /**
     * Create an instance of {@link DependentLocality}.
     *
     * @param postBox     required parameter
     * @param largeMailUser     required parameter
     * @param postOffice     required parameter
     * @param postalRoute     required parameter
     * @return the dependent locality
     */
    public static DependentLocality createXalDependentLocality(final PostBox postBox, final LargeMailUser largeMailUser, final PostOffice postOffice, final PostalRoute postalRoute) {
        return new DependentLocality(postBox, largeMailUser, postOffice, postalRoute);
    }

    /**
     * Create an instance of {@link Firm}.
     *
     * @return the firm
     */
    public static Firm createXalFirm() {
        return new Firm();
    }

    /**
     * Create an instance of {@link LargeMailUser}.
     *
     * @return the large mail user
     */
    public static LargeMailUser createXalLargeMailUser() {
        return new LargeMailUser();
    }

    /**
     * Create an instance of {@link Locality}.
     *
     * @param postBox     required parameter
     * @param largeMailUser     required parameter
     * @param postOffice     required parameter
     * @param postalRoute     required parameter
     * @return the locality
     */
    public static Locality createXalLocality(final PostBox postBox, final LargeMailUser largeMailUser, final PostOffice postOffice, final PostalRoute postalRoute) {
        return new Locality(postBox, largeMailUser, postOffice, postalRoute);
    }

    /**
     * Create an instance of {@link MailStop}.
     *
     * @return the mail stop
     */
    public static MailStop createXalMailStop() {
        return new MailStop();
    }

    /**
     * Create an instance of {@link PostBox}.
     *
     * @param postBoxNumber     required parameter
     * @return the post box
     */
    public static PostBox createXalPostBox(final PostBox.PostBoxNumber postBoxNumber) {
        return new PostBox(postBoxNumber);
    }

    /**
     * Create an instance of {@link PostOffice}.
     *
     * @return the post office
     */
    public static PostOffice createXalPostOffice() {
        return new PostOffice();
    }

    /**
     * Create an instance of {@link PostalCode}.
     *
     * @return the postal code
     */
    public static PostalCode createXalPostalCode() {
        return new PostalCode();
    }

    /**
     * Create an instance of {@link PostalRoute}.
     *
     * @param postalRouteName     required parameter
     * @param postalRouteNumber     required parameter
     * @return the postal route
     */
    public static PostalRoute createXalPostalRoute(final List<PostalRoute.PostalRouteName> postalRouteName, final PostalRoute.PostalRouteNumber postalRouteNumber) {
        return new PostalRoute(postalRouteName, postalRouteNumber);
    }

    /**
     * Create an instance of {@link Premise}.
     *
     * @param premiseLocation     required parameter
     * @param premiseNumber     required parameter
     * @param premiseNumberRange     required parameter
     * @return the premise
     */
    public static Premise createXalPremise(final Premise.PremiseLocation premiseLocation, final List<PremiseNumber> premiseNumber, final Premise.PremiseNumberRange premiseNumberRange) {
        return new Premise(premiseLocation, premiseNumber, premiseNumberRange);
    }

    /**
     * Create an instance of {@link PremiseNumber}.
     *
     * @return the premise number
     */
    public static PremiseNumber createXalPremiseNumber() {
        return new PremiseNumber();
    }

    /**
     * Create an instance of {@link PremiseNumberPrefix}.
     *
     * @return the premise number prefix
     */
    public static PremiseNumberPrefix createXalPremiseNumberPrefix() {
        return new PremiseNumberPrefix();
    }

    /**
     * Create an instance of {@link PremiseNumberSuffix}.
     *
     * @return the premise number suffix
     */
    public static PremiseNumberSuffix createXalPremiseNumberSuffix() {
        return new PremiseNumberSuffix();
    }

    /**
     * Create an instance of {@link SubPremise}.
     *
     * @param subPremiseLocation     required parameter
     * @return the sub premise
     */
    public static SubPremise createXalSubPremise(final SubPremise.SubPremiseLocation subPremiseLocation) {
        return new SubPremise(subPremiseLocation);
    }

    /**
     * Create an instance of {@link Thoroughfare}.
     *
     * @param dependentLocality     required parameter
     * @param premise     required parameter
     * @param firm     required parameter
     * @param postalCode     required parameter
     * @return the thoroughfare
     */
    public static Thoroughfare createXalThoroughfare(final DependentLocality dependentLocality, final Premise premise, final Firm firm, final PostalCode postalCode) {
        return new Thoroughfare(dependentLocality, premise, firm, postalCode);
    }

    /**
     * Create an instance of {@link ThoroughfareLeadingType}.
     *
     * @return the thoroughfare leading type
     */
    public static ThoroughfareLeadingType createXalThoroughfareLeadingType() {
        return new ThoroughfareLeadingType();
    }

    /**
     * Create an instance of {@link ThoroughfareName}.
     *
     * @return the thoroughfare name
     */
    public static ThoroughfareName createXalThoroughfareName() {
        return new ThoroughfareName();
    }

    /**
     * Create an instance of {@link ThoroughfareNumber}.
     *
     * @return the thoroughfare number
     */
    public static ThoroughfareNumber createXalThoroughfareNumber() {
        return new ThoroughfareNumber();
    }

    /**
     * Create an instance of {@link ThoroughfareNumberPrefix}.
     *
     * @return the thoroughfare number prefix
     */
    public static ThoroughfareNumberPrefix createXalThoroughfareNumberPrefix() {
        return new ThoroughfareNumberPrefix();
    }

    /**
     * Create an instance of {@link ThoroughfareNumberSuffix}.
     *
     * @return the thoroughfare number suffix
     */
    public static ThoroughfareNumberSuffix createXalThoroughfareNumberSuffix() {
        return new ThoroughfareNumberSuffix();
    }

    /**
     * Create an instance of {@link ThoroughfarePostDirection}.
     *
     * @return the thoroughfare post direction
     */
    public static ThoroughfarePostDirection createXalThoroughfarePostDirection() {
        return new ThoroughfarePostDirection();
    }

    /**
     * Create an instance of {@link ThoroughfarePreDirection}.
     *
     * @return the thoroughfare pre direction
     */
    public static ThoroughfarePreDirection createXalThoroughfarePreDirection() {
        return new ThoroughfarePreDirection();
    }

    /**
     * Create an instance of {@link ThoroughfareTrailingType}.
     *
     * @return the thoroughfare trailing type
     */
    public static ThoroughfareTrailingType createXalThoroughfareTrailingType() {
        return new ThoroughfareTrailingType();
    }

    /**
     * Create an instance of {@link XAL}.
     *
     * @param xalAddressDetails     required parameter
     * @return the xal
     */
    public static XAL createXalXAL(final List<AddressDetails> xalAddressDetails) {
        return new XAL(xalAddressDetails);
    }

}
