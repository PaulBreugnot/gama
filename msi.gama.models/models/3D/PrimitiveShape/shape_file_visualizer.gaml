/**
 *  shape_visualization
 *  Author: Arnaud Grignard
 *  Description: Visualize a .Shp file in an opengl display
 */


model shape_visualization

global {
	
	file shape_file parameter: 'Shapefile' <- file('includes/building.shp');
	rgb shapeColor parameter: 'shape color' <- rgb([45,153,166]);
	
	init {
		create myShape from: shape_file; 
	}

}
entities {
	species myShape {
		string type; 
		aspect base {
			draw geometry: shape color: shapeColor;
		}
	}
}
environment bounds: shape_file ;

experiment display_shapefile type: gui {
	

	output {
		display city_display refresh_every: 1 type: opengl ambient_light:0.5{
			species myShape aspect: base refresh:false ;
		}
	}
}




