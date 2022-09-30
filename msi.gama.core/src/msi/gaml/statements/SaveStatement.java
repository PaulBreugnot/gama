/*******************************************************************************************************
 *
 * SaveStatement.java, in msi.gama.core, is part of the source code of the GAMA modeling and simulation platform
 * (v.1.8.2).
 *
 * (c) 2007-2022 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package msi.gaml.statements;

import static msi.gama.common.util.FileUtils.constructAbsoluteFilePath;
import static msi.gama.util.graph.writer.GraphExporters.getAvailableWriters;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.media.jai.RasterFactory;

import org.apache.commons.lang3.ArrayUtils;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridCoverageFactory;
import org.geotools.data.DataUtilities;
import org.geotools.data.FeatureWriter;
import org.geotools.data.Transaction;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.feature.SchemaException;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.gce.geotiff.GeoTiffFormat;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.geojson.geom.GeometryJSON;
import org.geotools.geometry.Envelope2D;
import org.geotools.referencing.CRS;
import org.jgrapht.nio.GraphExporter;
import org.locationtech.jts.algorithm.Orientation;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateSequence;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryCollection;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.MultiLineString;
import org.locationtech.jts.geom.MultiPoint;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.impl.CoordinateArraySequenceFactory;
import org.opengis.coverage.grid.GridCoverageWriter;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.geometry.Envelope;
import org.opengis.parameter.GeneralParameterValue;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import msi.gama.common.geometry.GeometryUtils;
import msi.gama.common.interfaces.IGamlIssue;
import msi.gama.common.interfaces.IKeyword;
import msi.gama.common.interfaces.ITyped;
import msi.gama.common.preferences.GamaPreferences;
import msi.gama.metamodel.agent.IAgent;
import msi.gama.metamodel.population.IPopulation;
import msi.gama.metamodel.shape.IShape;
import msi.gama.metamodel.topology.grid.GamaSpatialMatrix.GridPopulation;
import msi.gama.metamodel.topology.projection.IProjection;
import msi.gama.metamodel.topology.projection.SimpleScalingProjection;
import msi.gama.precompiler.GamlAnnotations.doc;
import msi.gama.precompiler.GamlAnnotations.example;
import msi.gama.precompiler.GamlAnnotations.facet;
import msi.gama.precompiler.GamlAnnotations.facets;
import msi.gama.precompiler.GamlAnnotations.inside;
import msi.gama.precompiler.GamlAnnotations.symbol;
import msi.gama.precompiler.GamlAnnotations.usage;
import msi.gama.precompiler.IConcept;
import msi.gama.precompiler.ISymbolKind;
import msi.gama.runtime.GAMA;
import msi.gama.runtime.IScope;
import msi.gama.runtime.exceptions.GamaRuntimeException;
import msi.gama.util.GamaColor;
import msi.gama.util.GamaListFactory;
import msi.gama.util.GamaMapFactory;
import msi.gama.util.IList;
import msi.gama.util.IModifiableContainer;
import msi.gama.util.file.IGamaFile;
import msi.gama.util.graph.IGraph;
import msi.gama.util.graph.writer.GraphExporters;
import msi.gama.util.matrix.GamaField;
import msi.gaml.compilation.IDescriptionValidator;
import msi.gaml.compilation.annotations.validator;
import msi.gaml.descriptions.IDescription;
import msi.gaml.descriptions.SpeciesDescription;
import msi.gaml.descriptions.StatementDescription;
import msi.gaml.expressions.ConstantExpression;
import msi.gaml.expressions.IExpression;
import msi.gaml.expressions.IExpressionFactory;
import msi.gaml.expressions.data.MapExpression;
import msi.gaml.operators.Cast;
import msi.gaml.operators.Comparison;
import msi.gaml.operators.Maths;
import msi.gaml.operators.Strings;
import msi.gaml.skills.GridSkill.IGridAgent;
import msi.gaml.species.ISpecies;
import msi.gaml.statements.SaveStatement.SaveValidator;
import msi.gaml.types.GamaFileType;
import msi.gaml.types.GamaKmlExport;
import msi.gaml.types.IType;
import msi.gaml.types.Types;

/**
 * The Class SaveStatement.
 */
@symbol (
		name = IKeyword.SAVE,
		kind = ISymbolKind.SINGLE_STATEMENT,
		concept = { IConcept.FILE, IConcept.SAVE_FILE },
		with_sequence = true, // necessary to allow declaring the attributes facet as remote itself
		// with_args = true,
		remote_context = true)
@inside (
		kinds = { ISymbolKind.BEHAVIOR, ISymbolKind.ACTION })
@facets (
		value = { @facet (
				name = IKeyword.TYPE,
				type = IType.ID,
				optional = true,
				values = { "shp", "text", "csv", "asc", "geotiff", "image", "kml", "kmz", "json", "dimacs", "dot",
						"gexf", "graphml", "gml", "graph6" },
				doc = @doc ("an expression that evaluates to an string, the type of the output file (it can be only \"shp\", \"asc\", \"geotiff\", \"image\", \"text\" or \"csv\") ")),
				@facet (
						name = IKeyword.DATA,
						type = IType.NONE,
						optional = true,
						doc = @doc ("the data that will be saved to the file")),
				@facet (
						name = IKeyword.REWRITE,
						type = IType.BOOL,
						optional = true,
						doc = @doc ("a boolean expression specifying whether to erase the file if it exists or append data at the end of it. Only applicable to \"text\" or \"csv\" files. Default is true")),
				@facet (
						name = IKeyword.HEADER,
						type = IType.BOOL,
						optional = true,
						doc = @doc ("an expression that evaluates to a boolean, specifying whether the save will write a header if the file does not exist")),
				@facet (
						name = IKeyword.TO,
						type = IType.STRING,
						optional = true,
						doc = @doc ("an expression that evaluates to an string, the path to the file, or directly to a file")),
				@facet (
						name = "crs",
						type = IType.NONE,
						optional = true,
						doc = @doc ("the name of the projection, e.g. crs:\"EPSG:4326\" or its EPSG id, e.g. crs:4326. Here a list of the CRS codes (and EPSG id): http://spatialreference.org")),
				@facet (
						name = IKeyword.ATTRIBUTES,
						type = { IType.MAP, IType.LIST },
						remote_context = true,
						optional = true,
						doc = @doc (
								value = "Allows to specify the attributes of a shape file or GeoJson file where agents are saved. Can be expressed as a list of string or as a literal map. When expressed as a list, each value should represent the name of an attribute of the shape or agent. The keys of the map are the names of the attributes that will be present in the file, the values are whatever expressions neeeded to define their value. ")),
				@facet (
						name = IKeyword.WITH,
						type = { IType.MAP },
						optional = true,
						doc = @doc (
								deprecated = "Please use 'attributes:' instead",
								value = "Allows to define the attributes of a shape file. Keys of the map are the attributes of agents to save, values are the names of attributes in the shape file")) },
		omissible = IKeyword.DATA)
@doc (
		value = "Allows to save data in a file. The type of file can be \"shp\", \"asc\", \"geotiff\", \"text\" or \"csv\".",
		usages = { @usage (
				value = "Its simple syntax is:",
				examples = { @example (
						value = "save data to: output_file type: a_type_file;",
						isExecutable = false) }),
				@usage (
						value = "To save data in a text file:",
						examples = { @example (
								value = "save (string(cycle) + \"->\"  + name + \":\" + location) to: \"save_data.txt\" type: \"text\";") }),
				@usage (
						value = "To save the values of some attributes of the current agent in csv file:",
						examples = { @example (
								value = "save [name, location, host] to: \"save_data.csv\" type: \"csv\";") }),
				@usage (
						value = "To save the values of all attributes of all the agents of a species into a csv (with optional attributes):",
						examples = { @example (
								value = "save species_of(self) to: \"save_csvfile.csv\" type: \"csv\" header: false;") }),
				@usage (
						value = "To save the geometries of all the agents of a species into a shapefile (with optional attributes):",
						examples = { @example (
								value = "save species_of(self) to: \"save_shapefile.shp\" type: \"shp\" attributes: ['nameAgent'::name, 'locationAgent'::location] crs: \"EPSG:4326\";") }),
				@usage (
						value = "To save the grid_value attributes of all the cells of a grid into an ESRI ASCII Raster file:",
						examples = { @example (
								value = "save grid to: \"save_grid.asc\" type: \"asc\";") }),
				@usage (
						value = "To save the grid_value attributes of all the cells of a grid into geotiff:",
						examples = { @example (
								value = "save grid to: \"save_grid.tif\" type: \"geotiff\";") }),
				@usage (
						value = "To save the grid_value attributes of all the cells of a grid into png (with a worldfile):",
						examples = { @example (
								value = "save grid to: \"save_grid.png\" type: \"image\";") }),
				@usage (
						value = "The save statement can be use in an init block, a reflex, an action or in a user command. Do not use it in experiments.") })
@validator (SaveValidator.class)
@SuppressWarnings ({ "rawtypes" })
public class SaveStatement extends AbstractStatementSequence implements IStatement.WithArgs {

	/**
	 * The Class SaveValidator.
	 */
	public static class SaveValidator implements IDescriptionValidator<StatementDescription> {

		/**
		 * Method validate()
		 *
		 * @see msi.gaml.compilation.IDescriptionValidator#validate(msi.gaml.descriptions.IDescription)
		 */
		@Override
		public void validate(final StatementDescription description) {

			final StatementDescription desc = description;
			final Facets with = desc.getPassedArgs();
			final IExpression att = desc.getFacetExpr(ATTRIBUTES);
			final boolean isMap = att instanceof MapExpression;
			if (att != null) {
				if (!isMap && !att.getGamlType().isTranslatableInto(Types.LIST.of(Types.STRING))) {
					desc.error("attributes must be expressed as a map<string, unknown> or as a list<string>",
							IGamlIssue.WRONG_TYPE, ATTRIBUTES);
					return;
				}
				if (isMap) {
					final MapExpression map = (MapExpression) att;
					if (map.getGamlType().getKeyType() != Types.STRING) {
						desc.error(
								"The type of the keys of the attributes map must be string. These will be used for naming the attributes in the file",
								IGamlIssue.WRONG_TYPE, ATTRIBUTES);
						return;
					}
				}

				if (with.exists()) {
					desc.warning(
							"'with' and 'attributes' are mutually exclusive. Only the first one will be considered",
							IGamlIssue.CONFLICTING_FACETS, ATTRIBUTES, WITH);
				}
				final IExpression type = desc.getFacetExpr(TYPE);
				if (type == null || !"shp".equals(type.literalValue()) && !"json".equals(type.literalValue())) {
					desc.warning("Attributes can only be defined for shape or json files", IGamlIssue.WRONG_TYPE,
							ATTRIBUTES);
				}

			}

			final IExpression data = desc.getFacetExpr(DATA);
			if (data == null) return;
			final IType<?> t = data.getGamlType().getContentType();
			final SpeciesDescription species = t.getSpecies();

			if (att == null && !with.exists()) return;

			if (species == null) {
				if (with.exists() || isMap) {
					desc.error("Attributes of geometries can only be specified with a list of attribute names",
							IGamlIssue.UNKNOWN_FACET, att == null ? WITH : ATTRIBUTES);
				}
				// Error deactivated for fixing #2982.
				// desc.error("Attributes can only be saved for agents", IGamlIssue.UNKNOWN_FACET,
				// att == null ? WITH : ATTRIBUTES);
			} else {
				with.forEachFacet((name, exp) -> {
					if (!species.hasAttribute(name)) {
						desc.error("Attribute " + name + " is not defined for the agents of " + data.serialize(false),
								IGamlIssue.UNKNOWN_VAR, WITH);
						return false;
					}
					return true;
				});
			}
		}

	}

	/** The with facet. */
	private Arguments withFacet;

	/** The attributes facet. */
	private final IExpression attributesFacet;

	/** The header. */
	private final IExpression crsCode, item, file, rewriteExpr, header;

	/**
	 * Instantiates a new save statement.
	 *
	 * @param desc
	 *            the desc
	 */
	public SaveStatement(final IDescription desc) {
		super(desc);
		crsCode = desc.getFacetExpr("crs");
		item = desc.getFacetExpr(IKeyword.DATA);
		file = getFacet(IKeyword.TO);
		rewriteExpr = getFacet(IKeyword.REWRITE);
		header = getFacet(IKeyword.HEADER);
		attributesFacet = getFacet(IKeyword.ATTRIBUTES);
	}

	/**
	 * Should overwrite.
	 *
	 * @param scope
	 *            the scope
	 * @return true, if successful
	 */
	private boolean shouldOverwrite(final IScope scope) {
		if (rewriteExpr == null) return true;
		return Cast.asBool(scope, rewriteExpr.value(scope));
	}

	// TODO rewrite this with the GamaFile framework

	@SuppressWarnings ("unchecked")
	@Override
	public Object privateExecuteIn(final IScope scope) throws GamaRuntimeException {
		if (item == null) return null;
		// First case: we have a file as item;
		if (file == null) {
			if (!Types.FILE.isAssignableFrom(item.getGamlType())) return null;
			final IGamaFile file = (IGamaFile) item.value(scope);
			if (file != null) {
				// Passes directly the facets of the statement, like crs, etc.
				file.save(scope, description.getFacets());
			}
			return file;
		}
		final String typeExp = getLiteral(IKeyword.TYPE);
		// Second case: a filename is indicated but not the type. In that case,
		// we try to build a new GamaFile from it and save it
		if (file != null && typeExp == null) {
			final String name = Cast.asString(scope, file.value(scope));
			final Object contents = item.value(scope);
			if (contents instanceof IModifiableContainer) {
				final IGamaFile f = GamaFileType.createFile(scope, name, (IModifiableContainer) contents);
				f.save(scope, description.getFacets());
				return f;
			}

		}

		// These statements will need to be completely rethought because of the
		// possibility to now use the GamaFile infrastructure for this.
		// For instance, TYPE is not needed anymore (the name of the file / its
		// inner type will be enough), like in save json_file("ddd.json",
		// my_map); which we can probably allow to be written save my_map to:
		// json_file("ddd.json"); see #1362

		try {
			final String path = constructAbsoluteFilePath(scope, Cast.asString(scope, file.value(scope)), false);
			if (path == null || "".equals(path)) return null;
			final File fileToSave = new File(path);
			createParents(fileToSave);
			boolean exists = fileToSave.exists();
			final String type = (typeExp != null ? typeExp : "text").trim().toLowerCase();
			//
			switch (type) {
				case "shp":
				case "json":
					Object agents = item.value(scope);
					if (agents instanceof ISpecies) {
						agents = scope.getAgent().getPopulationFor((ISpecies) agents);
					} else if (agents instanceof IShape) {
						// see Issue #2857
						agents = GamaListFactory.wrap(Types.GEOMETRY, (IShape) agents);
					} else if (!(agents instanceof IList)) return null;
					saveShape((IList<? extends IShape>) agents, fileToSave, scope, "json".equals(type));
					break;
				case "text":
				case "csv":
					final boolean rewrite = shouldOverwrite(scope);
					if (rewrite && exists) {
						fileToSave.delete();
						exists = false;
					}
					fileToSave.createNewFile();
					final boolean addHeader = !exists && (header == null || Cast.asBool(scope, header.value(scope)));
					saveText(type, fileToSave, addHeader, scope);
					break;
				case "asc":
					Object v = item.value(scope);
					if (v instanceof GamaField) {
						saveAsc((GamaField) v, fileToSave, scope);
					} else {
						final ISpecies species1 = Cast.asSpecies(scope, v);
						if (species1 == null || !species1.isGrid()) return null;
						saveAsc(species1, fileToSave, scope);
					}
					break;
				case "geotiff":
				case "image":
					v = item.value(scope);
					if (v instanceof GamaField) {
						saveRasterImage((GamaField) v, path, scope, "geotiff".equals(type));
					} else {
						final ISpecies species2 = Cast.asSpecies(scope, v);
						if (species2 == null || !species2.isGrid()) return null;
						saveRasterImage(species2, path, scope, "geotiff".equals(type));
					}
					break;
				case "kml":
				case "kmz":
					final Object kml = item.value(scope);
					if (!(kml instanceof GamaKmlExport)) return null;
					if ("kml".equals(type)) {
						((GamaKmlExport) kml).saveAsKml(scope, path);
					} else {
						((GamaKmlExport) kml).saveAsKmz(scope, path);
					}
					break;
				default:
					if (!getAvailableWriters().contains(type))
						throw GamaRuntimeException.error("Format is not recognized ('" + type + "')", scope);
					final IGraph g = Cast.asGraph(scope, item);
					if (g == null) return null;
					this.saveGraph(g, fileToSave, type, scope);
			}
		} catch (final GamaRuntimeException e) {
			throw e;
		} catch (final IOException e) {
			throw GamaRuntimeException.create(e, scope);
		}

		return Cast.asString(scope, file.value(scope));
	}

	/**
	 * Creates the parents.
	 *
	 * @param outputFile
	 *            the output file
	 */
	private static void createParents(final File outputFile) {
		final File parent = outputFile.getParentFile();
		if (!parent.exists()) { parent.mkdirs(); }

	}

	/**
	 * Save asc.
	 *
	 * @param field
	 *            the field
	 * @param f
	 *            the f
	 * @param scope
	 *            the scope
	 */
	public void saveAsc(final GamaField field, final File f, final IScope scope) {
		if (field == null || field.isEmpty(scope)) return;
		if (f.exists()) { f.delete(); }
		try (FileWriter fw = new FileWriter(f)) {
			StringBuilder header = new StringBuilder();
			final int nbCols = field.numCols;
			final int nbRows = field.numRows;
			header.append("ncols         ").append(nbCols).append(Strings.LN);
			header.append("nrows         ").append(nbRows).append(Strings.LN);
			savePrj(scope, f.getAbsolutePath());
			final boolean nullProjection = scope.getSimulation().getProjectionFactory().getWorld() == null;
			header.append("xllcorner     ")
					.append(nullProjection ? "0"
							: scope.getSimulation().getProjectionFactory().getWorld().getProjectedEnvelope().getMinX())
					.append(Strings.LN);
			header.append("yllcorner     ")
					.append(nullProjection ? "0"
							: scope.getSimulation().getProjectionFactory().getWorld().getProjectedEnvelope().getMinY())
					.append(Strings.LN);
			final double dx = scope.getSimulation().getEnvelope().getWidth() / nbCols;
			final double dy = scope.getSimulation().getEnvelope().getHeight() / nbRows;
			if (Comparison.equal(dx, dy)) {
				header.append("cellsize      ").append(dx).append(Strings.LN);
			} else {
				header.append("dx            ").append(dx).append(Strings.LN);
				header.append("dy            ").append(dy).append(Strings.LN);
			}
			fw.write(header.toString());

			for (int i = 0; i < nbRows; i++) {
				StringBuilder val = new StringBuilder();
				for (int j = 0; j < nbCols; j++) { val.append(field.get(scope, j, i)).append(" "); }
				fw.write(val.append(Strings.LN).toString());
			}
			fw.close();
		} catch (final IOException e) {}
	}

	/**
	 * Save asc.
	 *
	 * @param species
	 *            the species
	 * @param f
	 *            the f
	 * @param scope
	 *            the scope
	 */
	public void saveAsc(final ISpecies species, final File f, final IScope scope) {
		if (f.exists()) { f.delete(); }

		try (FileWriter fw = new FileWriter(f)) {
			StringBuilder header = new StringBuilder();
			final GridPopulation gp = (GridPopulation) species.getPopulation(scope);
			final int nbCols = gp.getNbCols();
			final int nbRows = gp.getNbRows();
			header.append("ncols         ").append(nbCols).append(Strings.LN);
			header.append("nrows         ").append(nbRows).append(Strings.LN);
			savePrj(scope, f.getAbsolutePath());
			final boolean nullProjection = scope.getSimulation().getProjectionFactory().getWorld() == null;
			header.append("xllcorner     ")
					.append(nullProjection ? "0"
							: scope.getSimulation().getProjectionFactory().getWorld().getProjectedEnvelope().getMinX())
					.append(Strings.LN);
			header.append("yllcorner     ")
					.append(nullProjection ? "0"
							: scope.getSimulation().getProjectionFactory().getWorld().getProjectedEnvelope().getMinY())
					.append(Strings.LN);
			final double dx = scope.getSimulation().getEnvelope().getWidth() / nbCols;
			final double dy = scope.getSimulation().getEnvelope().getHeight() / nbRows;
			if (Comparison.equal(dx, dy)) {
				header.append("cellsize      ").append(dx).append(Strings.LN);
			} else {
				header.append("dx            ").append(dx).append(Strings.LN);
				header.append("dy            ").append(dy).append(Strings.LN);
			}
			fw.write(header.toString());

			for (int i = 0; i < nbRows; i++) {
				StringBuilder val = new StringBuilder();
				for (int j = 0; j < nbCols; j++) { val.append(gp.getGridValue(j, i)).append(" "); }
				fw.write(val.append(Strings.LN).toString());
			}
			fw.close();
		} catch (final IOException e) {}

	}

	/**
	 * Save raster image.
	 *
	 * @param species
	 *            the species
	 * @param p
	 *            the p
	 * @param scope
	 *            the scope
	 * @param toGeotiff
	 *            the to geotiff
	 */
	public void saveRasterImage(final ISpecies species, final String p, final IScope scope, final boolean toGeotiff) {

		String path = p;
		if (!toGeotiff && !path.contains("png")) { path += ".png"; }
		final File f = new File(path);

		if (f.exists()) { f.delete(); }
		CoordinateReferenceSystem crs = savePrj(scope, path);
		final boolean nullProjection = scope.getSimulation().getProjectionFactory().getWorld() == null;

		final GridPopulation gp = (GridPopulation) species.getPopulation(scope);

		final int cols = gp.getNbCols();
		final int rows = gp.getNbRows();
		double x = nullProjection ? 0
				: scope.getSimulation().getProjectionFactory().getWorld().getProjectedEnvelope().getMinX();
		double y = nullProjection ? 0
				: scope.getSimulation().getProjectionFactory().getWorld().getProjectedEnvelope().getMinY();

		if (!toGeotiff) {
			final BufferedImage image = new BufferedImage(cols, rows, BufferedImage.TYPE_INT_RGB);

			for (final Object g : gp.getAgents(scope).iterable(scope)) {
				final IGridAgent ag = (IGridAgent) g;
				image.setRGB(ag.getX(), rows - 1 - ag.getY(), ag.getColor().getRGB());
			}
			try {
				ImageIO.write(image, "png", f);
				final double cw = gp.getAgent(0).getGeometry().getWidth();
				final double ch = gp.getAgent(0).getGeometry().getHeight();
				x += cw / 2;
				y += ch / 2;
				try (final FileWriter fw = new FileWriter(path.replace(".png", ".pgw"));) {
					fw.write(cw + "\n0.0\n0.0\n" + ch + "\n" + x + "\n" + y);
				}

			} catch (final IOException e) {
				e.printStackTrace();
			}

		} else {

			final float[][] imagePixelData = new float[rows][cols];
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					imagePixelData[row][col] = gp.getGridValue(col, row).floatValue();
				}

			}
			final double width = scope.getSimulation().getEnvelope().getWidth();
			final double height = scope.getSimulation().getEnvelope().getHeight();

			Envelope2D refEnvelope;
			refEnvelope = new Envelope2D(crs, x, y, width, height);

			// In order to fix issue #2793, it seems that (before the GAMA 1.8 release), GAMA is only able,
			// to read GeoTiff files with Byte format data.
			// The use of the following create from org.geotools.coverage.grid.GridCoverageFactory, will produce a
			// dataset of floats.
			// This is perfectly possible for the GeoTiff, but as GAMA can only read Byte format GeoTiff files, we limit
			// the save to this
			// specific format of data.
			final GridCoverage2D coverage = new GridCoverageFactory().create("data", imagePixelData, refEnvelope);
			// final GridCoverage2D coverage = createCoverageByteFromFloat("data", imagePixelData, refEnvelope);

			try {

				final GeoTiffFormat format = new GeoTiffFormat();
				final GridCoverageWriter writer = format.getWriter(f);
				writer.write(coverage, (GeneralParameterValue[]) null);
				/*
				 * final WorldImageWriter writer = new WorldImageWriter(f); writer.write(coverage, null);
				 */
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Save prj.
	 *
	 * @param scope
	 *            the scope
	 * @param path
	 *            the path
	 * @return the coordinate reference system
	 */
	CoordinateReferenceSystem savePrj(final IScope scope, final String path) {
		CoordinateReferenceSystem crs = null;
		final boolean nullProjection = scope.getSimulation().getProjectionFactory().getWorld() == null;
		try {
			crs = nullProjection ? CRS.decode("EPSG:3857")
					: scope.getSimulation().getProjectionFactory().getWorld().getTargetCRS(scope);
		} catch (final Exception e1) {
			GAMA.reportAndThrowIfNeeded(scope, GamaRuntimeException.create(e1, scope), false);
			return crs;
		}
		try (FileWriter fw =
				new FileWriter(path.replace(".png", ".prj").replace(".tif", ".prj").replace(".asc", ".prj"))) {
			fw.write(crs.toString());
			fw.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return crs;

	}

	/**
	 * Save raster image.
	 *
	 * @param field
	 *            the field
	 * @param p
	 *            the p
	 * @param scope
	 *            the scope
	 * @param toGeotiff
	 *            the to geotiff
	 */
	public void saveRasterImage(final GamaField field, final String p, final IScope scope, final boolean toGeotiff) {
		if (field == null || field.isEmpty(scope)) return;

		String path = p;
		if (!toGeotiff && !path.contains("png")) { path += ".png"; }
		final File f = new File(path);

		if (f.exists()) { f.delete(); }
		CoordinateReferenceSystem crs = savePrj(scope, path);
		final boolean nullProjection = scope.getSimulation().getProjectionFactory().getWorld() == null;

		final int cols = field.numCols;
		final int rows = field.numRows;
		double x = nullProjection ? 0
				: scope.getSimulation().getProjectionFactory().getWorld().getProjectedEnvelope().getMinX();
		double y = nullProjection ? 0
				: scope.getSimulation().getProjectionFactory().getWorld().getProjectedEnvelope().getMinY();

		if (!toGeotiff) {
			final BufferedImage image = new BufferedImage(cols, rows, BufferedImage.TYPE_INT_RGB);
			double[] minmaxVal = field.getMinMax(null);
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					double v = field.get(scope, col, row);

					int vRef = Maths.round((v - minmaxVal[0]) / (minmaxVal[1] - minmaxVal[0]) * 255);
					image.setRGB(col, rows - 1 - row, new GamaColor(vRef, vRef, vRef).getRGB());
				}
			}

			try {
				ImageIO.write(image, "png", f);
				final double cw =
						scope.getSimulation().getProjectionFactory().getWorld().getProjectedEnvelope().getWidth()
								/ cols;
				final double ch =
						scope.getSimulation().getProjectionFactory().getWorld().getProjectedEnvelope().getHeight()
								/ rows;
				x += cw / 2;
				y += ch / 2;
				try (final FileWriter fw = new FileWriter(path.replace(".png", ".pgw"));) {
					fw.write(cw + "\n0.0\n0.0\n" + ch + "\n" + x + "\n" + y);
				}

			} catch (final IOException e) {
				e.printStackTrace();
			}

		} else {

			final float[][] imagePixelData = new float[rows][cols];
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					imagePixelData[row][col] = field.get(scope, col, row).floatValue();
				}

			}
			final double width = scope.getSimulation().getEnvelope().getWidth();
			final double height = scope.getSimulation().getEnvelope().getHeight();

			Envelope2D refEnvelope;
			refEnvelope = new Envelope2D(crs, x, y, width, height);

			// In order to fix issue #2793, it seems that (before the GAMA 1.8 release), GAMA is only able,
			// to read GeoTiff files with Byte format data.
			// The use of the following create from org.geotools.coverage.grid.GridCoverageFactory, will produce a
			// dataset of floats.
			// This is perfectly possible for the GeoTiff, but as GAMA can only read Byte format GeoTiff files, we limit
			// the save to this
			// specific format of data.
			final GridCoverage2D coverage = new GridCoverageFactory().create("data", imagePixelData, refEnvelope);
			// final GridCoverage2D coverage = createCoverageByteFromFloat("data", imagePixelData, refEnvelope);

			try {

				final GeoTiffFormat format = new GeoTiffFormat();
				final GridCoverageWriter writer = format.getWriter(f);
				writer.write(coverage, (GeneralParameterValue[]) null);
				/*
				 * final WorldImageWriter writer = new WorldImageWriter(f); writer.write(coverage, null);
				 */
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Inspired by the code of public GridCoverage2D create(final CharSequence name, final float[][] matrix, final
	// Envelope envelope)
	/**
	 * Creates the coverage byte from float.
	 *
	 * @param name
	 *            the name
	 * @param matrix
	 *            the matrix
	 * @param envelope
	 *            the envelope
	 * @return the grid coverage 2 D
	 */
	// from org.geotools.coverage.grid.GridCoverageFactory
	public static GridCoverage2D createCoverageByteFromFloat(final CharSequence name, final float[][] matrix,
			final Envelope envelope) {

		int width = 0;
		final int height = matrix.length;
		for (int j = 0; j < height; j++) {
			final float[] row = matrix[j];
			if (row != null && row.length > width) { width = row.length; }
		}

		final WritableRaster raster;
		raster = RasterFactory.createBandedRaster(DataBuffer.TYPE_BYTE, width, height, 1, null);
		for (int j = 0; j < height; j++) {
			int i = 0;
			final float[] row = matrix[j];
			if (row != null) { for (; i < row.length; i++) { raster.setSample(i, j, 0, (byte) Math.round(row[i])); } }
			for (; i < width; i++) { raster.setSample(i, j, 0, (byte) 255); }
		}

		return new GridCoverageFactory().create(name, raster, envelope);
	}

	/**
	 * Gets the geometry type.
	 *
	 * @param agents
	 *            the agents
	 * @return the geometry type
	 */
	public static String getGeometryType(final List<? extends IShape> agents) {
		String geomType = "";
		boolean isLine = false;
		for (final IShape be : agents) {
			final IShape geom = be.getGeometry();
			if (geom != null && geom.getInnerGeometry() != null) {
				if (geom.getInnerGeometry().getNumGeometries() > 1) {
					Geometry g2 = geometryCollectionToSimpleManagement(geom.getInnerGeometry());
					if (!isLine && g2.getGeometryN(0).getClass() == Point.class) {
						geomType = Point.class.getSimpleName();
					} else if (g2.getGeometryN(0).getClass() == LineString.class) {
						geomType = LineString.class.getSimpleName();
					} else if (g2.getGeometryN(0).getClass() == Polygon.class) return Polygon.class.getSimpleName();

				} else {
					String geomType_tmp = geom.getInnerGeometry().getClass().getSimpleName();
					if (geom.getInnerGeometry() instanceof Polygon) return geomType_tmp;
					if (!isLine) {
						if (geom.getInnerGeometry() instanceof LineString) { isLine = true; }
						geomType = geomType_tmp;

					}

				}
			}
		}
		if ("DynamicLineString".equals(geomType)) { geomType = LineString.class.getSimpleName(); }
		return geomType;
	}

	/**
	 * Save graph.
	 *
	 * @param g
	 *            the g
	 * @param f
	 *            the f
	 * @param type
	 *            the type
	 * @param scope
	 *            the scope
	 */
	public void saveGraph(final IGraph g, final File f, final String type, final IScope scope) {
		GraphExporter<?, ?> exp = GraphExporters.getGraphWriter(type);
		if (exp != null) { exp.exportGraph(g, f.getAbsoluteFile()); }
	}

	/**
	 * Save shape.
	 *
	 * @param agents
	 *            the agents
	 * @param f
	 *            the f
	 * @param scope
	 *            the scope
	 * @param geoJson
	 *            the geo json
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	public void saveShape(final IList<? extends IShape> agents, final File f, final IScope scope, final boolean geoJson)
			throws GamaRuntimeException {
		final StringBuilder specs = new StringBuilder(agents.size() * 20);
		final String geomType = getGeometryType(agents);
		specs.append("geometry:" + geomType);
		try {
			final SpeciesDescription species =
					agents instanceof IPopulation ? ((IPopulation) agents).getSpecies().getDescription()
							: agents.getGamlType().getContentType().getSpecies();
			final Map<String, IExpression> attributes = GamaMapFactory.create();
			// if (species != null) {
			if (withFacet != null) {
				computeInitsFromWithFacet(scope, withFacet, attributes, species);
			} else if (attributesFacet != null) { computeInitsFromAttributesFacet(scope, attributes, species); }
			for (final String e : attributes.keySet()) {
				if (e == null) { continue; }
				final IExpression var = attributes.get(e);
				String name = e.replace("\"", "");
				name = name.replace("'", "");
				name = name.replace(":", "_");
				final String type = type(var);
				specs.append(',').append(name).append(':').append(type);
			}
			// }
			final IProjection proj = defineProjection(scope, f);
			if (!geoJson) {
				saveShapeFile(scope, f, agents, specs.toString(), geomType, attributes, proj);
			} else {
				saveGeoJSonFile(scope, f, agents, specs.toString(), geomType, attributes, proj);
			}
		} catch (final GamaRuntimeException e) {
			throw e;
		} catch (final Throwable e) {
			throw GamaRuntimeException.create(e, scope);
		}

	}

	/**
	 * Define projection.
	 *
	 * @param scope
	 *            the scope
	 * @param f
	 *            the f
	 * @return the i projection
	 */
	public IProjection defineProjection(final IScope scope, final File f) {
		String code = null;
		if (crsCode != null) {
			final IType type = crsCode.getGamlType();
			if (type.id() == IType.INT || type.id() == IType.FLOAT) {
				code = "EPSG:" + Cast.asInt(scope, crsCode.value(scope));
			} else if (type.id() == IType.STRING) { code = (String) crsCode.value(scope); }
		}
		IProjection gis;
		if (code == null) {
			final boolean useNoSpecific = GamaPreferences.External.LIB_USE_DEFAULT.getValue();
			if (!useNoSpecific) {
				code = "EPSG:" + GamaPreferences.External.LIB_OUTPUT_CRS.getValue();
				try {
					gis = scope.getSimulation().getProjectionFactory().forSavingWith(scope, code);
				} catch (final FactoryException e1) {
					throw GamaRuntimeException.error(
							"The code " + code + " does not correspond to a known EPSG code. GAMA is unable to save "
									+ f.getAbsolutePath(),
							scope);
				}
			} else {
				gis = scope.getSimulation().getProjectionFactory().getWorld();
				if (gis == null || gis.getInitialCRS(scope) == null) {
					final boolean alreadyprojected = GamaPreferences.External.LIB_PROJECTED.getValue();
					if (alreadyprojected) {
						code = "EPSG:" + GamaPreferences.External.LIB_TARGET_CRS.getValue();
					} else {
						code = "EPSG:" + GamaPreferences.External.LIB_INITIAL_CRS.getValue();
					}
					try {
						gis = scope.getSimulation().getProjectionFactory().forSavingWith(scope, code);
					} catch (final FactoryException e1) {
						throw GamaRuntimeException.error("The code " + code
								+ " does not correspond to a known EPSG code. GAMA is unable to save "
								+ f.getAbsolutePath(), scope);
					}
				}
			}

		} else {
			if (code.startsWith("GAMA")) {
				if ("GAMA".equals(code)) return null;
				final String[] cs = code.split("::");
				if (cs.length == 2) {
					final Double val = Double.parseDouble(cs[1]);
					return new SimpleScalingProjection(val);
				}
				return null;
			}

			try {
				gis = scope.getSimulation().getProjectionFactory().forSavingWith(scope, code);
			} catch (final FactoryException e1) {
				throw GamaRuntimeException.error("The code " + code
						+ " does not correspond to a known EPSG code. GAMA is unable to save " + f.getAbsolutePath(),
						scope);
			}
		}

		return gis;
	}

	/**
	 * Save text.
	 *
	 * @param type
	 *            the type
	 * @param fileTxt
	 *            the file txt
	 * @param header
	 *            the header
	 * @param scope
	 *            the scope
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	public void saveText(final String type, final File fileTxt, final boolean header, final IScope scope)
			throws GamaRuntimeException {
		try (FileWriter fw = new FileWriter(fileTxt, true)) {
			if ("text".equals(type)) {
				fw.write(Cast.asString(scope, item.value(scope)) + Strings.LN);
			} else if ("csv".equals(type)) {
				final IType itemType = item.getGamlType();
				final SpeciesDescription sd;
				if (itemType.isAgentType()) {
					sd = itemType.getSpecies();
				} else if (itemType.getContentType().isAgentType()) {
					sd = itemType.getContentType().getSpecies();
				} else {
					sd = null;
				}
				final Object value = item.value(scope);
				final IList values = itemType.isContainer() ? Cast.asList(scope, value)
						: GamaListFactory.create(scope, itemType, value);
				if (values.isEmpty()) return;
				if (sd != null) {
					final Collection<String> attributeNames = sd.getAttributeNames();
					attributeNames.removeAll(NON_SAVEABLE_ATTRIBUTE_NAMES);
					if (header) {
						fw.write("cycle;name;location.x;location.y;location.z");
						for (final String v : attributeNames) { fw.write(";" + v); }
						fw.write(Strings.LN);
					}
					for (final Object obj : values) {
						if (obj instanceof IAgent) {
							final IAgent ag = Cast.asAgent(scope, obj);
							fw.write(scope.getClock().getCycle() + ";" + ag.getName().replace(';', ',') + ";"
									+ ag.getLocation().getX() + ";" + ag.getLocation().getY() + ";"
									+ ag.getLocation().getZ());
							for (final String v : attributeNames) {
								String val = Cast.toGaml(ag.getDirectVarValue(scope, v)).replace(';', ',');
								if (val.startsWith("'") && val.endsWith("'")
										|| val.startsWith("\"") && val.endsWith("\"")) {
									val = val.substring(1, val.length() - 1);
								}
								fw.write(";" + val);
							}
							fw.write(Strings.LN);
						}

					}
				} else {
					if (header) {
						fw.write(item.serialize(true).replace("]", "").replace("[", ""));
						fw.write(Strings.LN);
					}
					if (itemType.id() == IType.MATRIX) {
						final String[] tmpValue = value.toString().replace("[", "").replace("]", "").split(",");
						for (int i = 0; i < tmpValue.length; i++) {
							if (i > 0) { fw.write(','); }
							fw.write(toCleanString(tmpValue[i]));
						}
					} else {
						final int size = values.size();
						for (int i = 0; i < size; i++) {
							if (i > 0) { fw.write(','); }
							fw.write(toCleanString(values.get(i)));
						}
					}
					fw.write(Strings.LN);
				}

			}

		} catch (final GamaRuntimeException e) {
			throw e;
		} catch (final Throwable e) {
			throw GamaRuntimeException.create(e, scope);
		}

	}

	/**
	 * To clean string.
	 *
	 * @param o
	 *            the o
	 * @return the string
	 */
	public String toCleanString(final Object o) {
		String val = Cast.toGaml(o).replace(';', ',');
		if (val.startsWith("'") && val.endsWith("'") || val.startsWith("\"") && val.endsWith("\"")) {
			val = val.substring(1, val.length() - 1);
		}

		if (o instanceof String) {
			val = val.replace("\\'", "'");
			val = val.replace("\\\"", "\"");

		}
		return val;
	}

	/**
	 * Type.
	 *
	 * @param var
	 *            the var
	 * @return the string
	 */
	public static String type(final ITyped var) {
		switch (var.getGamlType().id()) {
			case IType.BOOL:
				return "Boolean";
			case IType.INT:
				return "Integer";
			case IType.FLOAT:
				return "Double";
			default:
				return "String";
		}
	}

	/** The Constant NON_SAVEABLE_ATTRIBUTE_NAMES. */
	public static final Set<String> NON_SAVEABLE_ATTRIBUTE_NAMES = new HashSet<>(Arrays.asList(IKeyword.PEERS,
			IKeyword.LOCATION, IKeyword.HOST, IKeyword.AGENTS, IKeyword.MEMBERS, IKeyword.SHAPE));

	/**
	 * Compute inits from with facet.
	 *
	 * @param scope
	 *            the scope
	 * @param withFacet
	 *            the with facet
	 * @param values
	 *            the values
	 * @param species
	 *            the species
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	private void computeInitsFromWithFacet(final IScope scope, final Arguments withFacet,
			final Map<String, IExpression> values, final SpeciesDescription species) throws GamaRuntimeException {
		if (species == null) return;
		if (withFacet.isEmpty()) {
			for (final String var : species.getAttributeNames()) {
				if (!NON_SAVEABLE_ATTRIBUTE_NAMES.contains(var)) { values.put(var, species.getVarExpr(var, false)); }
			}
		} else {
			withFacet.forEachFacet((key, value) -> {
				values.put(value.getExpression().literalValue(), species.getVarExpr(key, false));
				return true;
			});
		}
	}

	/**
	 * Compute inits from attributes facet.
	 *
	 * @param scope
	 *            the scope
	 * @param values
	 *            the values
	 * @param species
	 *            the species
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	private void computeInitsFromAttributesFacet(final IScope scope, final Map<String, IExpression> values,
			final SpeciesDescription species) throws GamaRuntimeException {
		if (attributesFacet instanceof MapExpression) {
			final Map<IExpression, IExpression> map = ((MapExpression) attributesFacet).getElements();
			map.forEach((key, value) -> {
				final String name = Cast.asString(scope, key.value(scope));
				values.put(name, value);
			});
		} else {
			@SuppressWarnings ("unchecked") final List<String> names =
					GamaListFactory.create(scope, Types.STRING, Cast.asList(scope, attributesFacet.value(scope)));
			if (species != null) {
				names.forEach(n -> values.put(n,
						species.hasAttribute(n) ? species.getVarExpr(n, false) : IExpressionFactory.NIL_EXPR));
			} else {
				// see #2982
				names.forEach(n -> values.put(n, new ConstantExpression(n)));
			}
		}
	}

	/**
	 * Fixes polygon CWS.
	 *
	 * @param g
	 *            the g
	 * @return the geometry
	 */
	private static Geometry fixesPolygonCWS(final Geometry g) {
		if (g instanceof Polygon) {
			final Polygon p = (Polygon) g;
			final boolean clockwise = Orientation.isCCW(p.getExteriorRing().getCoordinates());
			if (p.getNumInteriorRing() == 0) return g;
			boolean change = false;
			final LinearRing[] holes = new LinearRing[p.getNumInteriorRing()];
			final GeometryFactory geomFact = new GeometryFactory();
			for (int i = 0; i < p.getNumInteriorRing(); i++) {
				final LinearRing hole = p.getInteriorRingN(i);
				if (!clockwise && !Orientation.isCCW(hole.getCoordinates())
						|| clockwise && Orientation.isCCW(hole.getCoordinates())) {
					change = true;
					final Coordinate[] coords = hole.getCoordinates();
					ArrayUtils.reverse(coords);
					final CoordinateSequence points = CoordinateArraySequenceFactory.instance().create(coords);
					holes[i] = new LinearRing(points, geomFact);
				} else {
					holes[i] = hole;
				}
			}
			if (change) return geomFact.createPolygon(p.getExteriorRing(), holes);
		} else if (g instanceof GeometryCollection) {
			final GeometryCollection gc = (GeometryCollection) g;
			boolean change = false;
			final GeometryFactory geomFact = new GeometryFactory();
			final Geometry[] geometries = new Geometry[gc.getNumGeometries()];
			for (int i = 0; i < gc.getNumGeometries(); i++) {
				final Geometry gg = gc.getGeometryN(i);
				if (gg instanceof Polygon) {
					geometries[i] = fixesPolygonCWS(gg);
					change = true;
				} else {
					geometries[i] = gg;
				}
			}
			if (change) return geomFact.createGeometryCollection(geometries);
		}
		return g;
	}

	/**
	 * Builds the feature.
	 *
	 * @param scope
	 *            the scope
	 * @param ff
	 *            the ff
	 * @param ag
	 *            the ag
	 * @param gis
	 *            the gis
	 * @param attributeValues
	 *            the attribute values
	 * @return true, if successful
	 */
	public static boolean buildFeature(final IScope scope, final SimpleFeature ff, final IShape ag,
			final IProjection gis, final Collection<IExpression> attributeValues) {
		final List<Object> values = new ArrayList<>();
		// geometry is by convention (in specs) at position 0
		if (ag.getInnerGeometry() == null) return false;
		Geometry g = gis == null ? ag.getInnerGeometry() : gis.inverseTransform(ag.getInnerGeometry());

		g = fixesPolygonCWS(g);
		g = geometryCollectionManagement(g);

		values.add(g);
		if (ag instanceof IAgent) {
			for (final IExpression variable : attributeValues) {
				Object val = scope.evaluate(variable, (IAgent) ag).getValue();
				if (variable.getGamlType().equals(Types.STRING)) {
					if (val == null) {
						val = "";
					} else {
						final String val2 = val.toString();
						if (val2.startsWith("'") && val2.endsWith("'")
								|| val2.startsWith("\"") && val2.endsWith("\"")) {
							val = val2.substring(1, val2.length() - 1);
						}
					}
				}
				values.add(val);
			}
		} else {
			// see #2982. Assume it is an attribute of the shape
			for (final IExpression variable : attributeValues) {
				final Object val = variable.value(scope);
				if (val instanceof String) {
					values.add(ag.getAttribute((String) val));
				} else {
					values.add("");
				}
			}
		}
		// AD Assumes that the type is ok.
		// AD TODO replace this list of variable names by expressions
		// (to be
		// evaluated by agents), so that dynamic values can be passed
		// AD WARNING Would require some sort of iterator operator that
		// would collect the values beforehand
		ff.setAttributes(values);
		return true;
	}

	/**
	 * Save geo J son file.
	 *
	 * @param scope
	 *            the scope
	 * @param f
	 *            the f
	 * @param agents
	 *            the agents
	 * @param specs
	 *            the specs
	 * @param geomType
	 *            the geom type
	 * @param attributes
	 *            the attributes
	 * @param gis
	 *            the gis
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws SchemaException
	 *             the schema exception
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	// AD 2/1/16 Replace IAgent by IShape so as to be able to save geometries
	public static void saveGeoJSonFile(final IScope scope, final File f, final List<? extends IShape> agents,
			/* final String featureTypeName, */final String specs, final String geomType,
			final Map<String, IExpression> attributes, final IProjection gis)
			throws IOException, SchemaException, GamaRuntimeException {
		// AD 11/02/15 Added to allow saving to new directories
		if (agents == null || agents.isEmpty()) return;

		// The name of the type and the name of the feature source shoud now be
		// the same.
		final SimpleFeatureType type = DataUtilities.createType("geojson", specs);
		final SimpleFeatureBuilder builder = new SimpleFeatureBuilder(type);
		final DefaultFeatureCollection featureCollection = new DefaultFeatureCollection();

		// AD Builds once the list of agent attributes to evaluate
		final Collection<IExpression> attributeValues =
				attributes == null ? Collections.EMPTY_LIST : attributes.values();
		int i = 0;
		for (final IShape ag : agents) {
			final SimpleFeature ff = builder.buildFeature(i + "");
			i++;
			final boolean ok = buildFeature(scope, ff, ag, gis, attributeValues);
			if (!ok) { continue; }
			featureCollection.add(ff);
		}

		final FeatureJSON io = new FeatureJSON(new GeometryJSON(20));
		io.writeFeatureCollection(featureCollection, f.getAbsolutePath());

	}

	/**
	 * Save shape file.
	 *
	 * @param scope
	 *            the scope
	 * @param f
	 *            the f
	 * @param agents
	 *            the agents
	 * @param specs
	 *            the specs
	 * @param geomType
	 *            the geom type
	 * @param attributes
	 *            the attributes
	 * @param gis
	 *            the gis
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws SchemaException
	 *             the schema exception
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	// AD 2/1/16 Replace IAgent by IShape so as to be able to save geometries
	public static void saveShapeFile(final IScope scope, final File f, final List<? extends IShape> agents,
			/* final String featureTypeName, */final String specs, final String geomType,
			final Map<String, IExpression> attributes, final IProjection gis)
			throws IOException, SchemaException, GamaRuntimeException {
		// AD 11/02/15 Added to allow saving to new directories
		if (agents == null || agents.isEmpty()) return;

		final ShapefileDataStore store = new ShapefileDataStore(f.toURI().toURL());
		store.setCharset(Charset.forName("UTF8"));
		// The name of the type and the name of the feature source shoud now be
		// the same.
		final SimpleFeatureType type =
				DataUtilities.createType(store.getFeatureSource().getEntry().getTypeName(), specs);
		store.createSchema(type);
		// AD: creation of a FeatureWriter on the store.
		boolean isPolygon =
				geomType.equals(MultiPolygon.class.getSimpleName()) || geomType.equals(Polygon.class.getSimpleName());
		boolean isLine = geomType.equals(MultiLineString.class.getSimpleName())
				|| geomType.equals(LineString.class.getSimpleName());
		boolean isPoint =
				geomType.equals(MultiPoint.class.getSimpleName()) || geomType.equals(Point.class.getSimpleName());
		try (FeatureWriter fw = store.getFeatureWriter(Transaction.AUTO_COMMIT)) {
			// AD Builds once the list of agent attributes to evaluate
			final Collection<IExpression> attributeValues =
					attributes == null ? Collections.EMPTY_LIST : attributes.values();

			for (final IShape ag : agents) {
				if (ag.getGeometries().size() > 1) {
					ag.setInnerGeometry(geometryCollectionToSimpleManagement(ag.getInnerGeometry()));
				}
				if (isPolygon
						&& (ag.getInnerGeometry() instanceof Polygon || ag.getInnerGeometry() instanceof MultiPolygon)
						|| isLine && ag.getGeometry().isLine() || isPoint && ag.getGeometry().isPoint()) {
					final SimpleFeature ff = (SimpleFeature) fw.next();
					final boolean ok = buildFeature(scope, ff, ag, gis, attributeValues);
					if (!ok) { break; }
				}

			}
			fw.close();
			// Writes the prj file
			if (gis != null) {
				final CoordinateReferenceSystem crs = gis.getInitialCRS(scope);
				if (crs != null) {
					try (FileWriter fw1 = new FileWriter(f.getAbsolutePath().replace(".shp", ".prj"))) {
						fw1.write(crs.toString());
						fw1.close();
					} catch (final IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (final ClassCastException e) {
			throw GamaRuntimeException.error(
					"Cannot save agents/geometries with different types of geometries (point, line, polygon) in a same shapefile",
					scope);
		} finally {
			store.dispose();

		}
	}

	/**
	 * Geometry collection to simple management.
	 *
	 * @param gg
	 *            the gg
	 * @return the geometry
	 */
	private static Geometry geometryCollectionToSimpleManagement(final Geometry gg) {
		if (gg instanceof GeometryCollection) {
			final int nb = ((GeometryCollection) gg).getNumGeometries();
			List<Polygon> polys = new ArrayList<>();
			List<LineString> lines = new ArrayList<>();
			List<Point> points = new ArrayList<>();

			for (int i = 0; i < nb; i++) {
				final Geometry g = ((GeometryCollection) gg).getGeometryN(i);
				if (g instanceof Polygon) {
					polys.add((Polygon) g);
				} else if (g instanceof LineString) {
					lines.add((LineString) g);
				} else if (g instanceof Point) { points.add((Point) g); }
			}
			if (!polys.isEmpty()) {
				if (polys.size() == 1) return polys.get(0);
				Polygon[] ps = new Polygon[polys.size()];
				for (int i = 0; i < ps.length; i++) { ps[i] = polys.get(i); }

				return GeometryUtils.GEOMETRY_FACTORY.createMultiPolygon(ps);
			}
			if (!lines.isEmpty()) {

				if (lines.size() == 1) return lines.get(0);
				LineString[] ps = new LineString[lines.size()];
				for (int i = 0; i < ps.length; i++) { ps[i] = lines.get(i); }
				return GeometryUtils.GEOMETRY_FACTORY.createMultiLineString(ps);
			}
			if (!points.isEmpty()) {
				if (points.size() == 1) return points.get(0);

				Point[] ps = new Point[points.size()];
				for (int i = 0; i < ps.length; i++) { ps[i] = points.get(i); }
				return GeometryUtils.GEOMETRY_FACTORY.createMultiPoint(ps);
			}
		}
		return gg;
	}

	/**
	 * Geometry collection management.
	 *
	 * @param gg
	 *            the gg
	 * @return the geometry
	 */
	private static Geometry geometryCollectionManagement(final Geometry gg) {
		if (gg instanceof GeometryCollection) {
			boolean isMultiPolygon = true;
			boolean isMultiPoint = true;
			boolean isMultiLine = true;
			final int nb = ((GeometryCollection) gg).getNumGeometries();

			for (int i = 0; i < nb; i++) {
				final Geometry g = ((GeometryCollection) gg).getGeometryN(i);
				if (!(g instanceof Polygon)) { isMultiPolygon = false; }
				if (!(g instanceof LineString)) { isMultiLine = false; }
				if (!(g instanceof Point)) { isMultiPoint = false; }
			}

			if (isMultiPolygon) {
				final Polygon[] polygons = new Polygon[nb];
				for (int i = 0; i < nb; i++) { polygons[i] = (Polygon) ((GeometryCollection) gg).getGeometryN(i); }
				return GeometryUtils.GEOMETRY_FACTORY.createMultiPolygon(polygons);
			}
			if (isMultiLine) {
				final LineString[] lines = new LineString[nb];
				for (int i = 0; i < nb; i++) { lines[i] = (LineString) ((GeometryCollection) gg).getGeometryN(i); }
				return GeometryUtils.GEOMETRY_FACTORY.createMultiLineString(lines);
			}
			if (isMultiPoint) {
				final Point[] points = new Point[nb];
				for (int i = 0; i < nb; i++) { points[i] = (Point) ((GeometryCollection) gg).getGeometryN(i); }
				return GeometryUtils.GEOMETRY_FACTORY.createMultiPoint(points);
			}
		}
		return gg;
	}

	@Override
	public void setFormalArgs(final Arguments args) { withFacet = args; }

	@Override
	public void setRuntimeArgs(final IScope scope, final Arguments args) {
		// TODO Auto-generated method stub
	}
}
