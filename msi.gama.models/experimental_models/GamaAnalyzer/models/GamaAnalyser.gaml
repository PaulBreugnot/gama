model tutorial_gis_city_traffic



global {
	file shape_file_buildings <- file('../includes/building.shp');
	file shape_file_roads <- file('../includes/road.shp');
	file shape_file_bounds <- file('../includes/bounds.shp'); 
	geometry shape <- envelope(shape_file_bounds);
	int nb_people <- 100;
	int day_time update: time mod 144 ;
	int min_work_start <- 36;
	int max_work_start <- 60;
	int min_work_end <- 84; 
	int max_work_end <- 132; 
	float min_speed <- 50.0;
	float max_speed <- 100.0; 
	float destroy <- 0.02;
	graph the_graph;
	int repair_time <- 6 ;
	
	
	agent_group_follower peoplefollower;
	list<building> residential_buildings;
	list<building>  industrial_buildings;
	list<float> testlist3<-[2,3,4,5];
	list<float> testlist4<-[3,2];
	list<float> testlist5<-[3,2];
	list<list> testlist6<-[testlist3,testlist4,testlist4];
	list<list> testlist<-[testlist3,testlist3,testlist3];
	list<list> testlist2<-["A","B","C","D"];
	
	init {
		create building from: shape_file_buildings with: [type::string(read ('NATURE'))] {       
			if type='Industrial' {
				color <- rgb('blue') ;
			}  
	  	}
		create road from: shape_file_roads ;
		map<road,float> weights_map <- road as_map (each:: (each.destruction_coeff * each.shape.perimeter));
		the_graph <- as_edge_graph(road) with_weights weights_map;
		
		residential_buildings <- building where (each.type='Residential');
		industrial_buildings <- building where (each.type='Industrial') ;
		create people number: nb_people {
			 speed <- min_speed + rnd (max_speed - min_speed) ;
			 start_work <- min_work_start + rnd (max_work_start - min_work_start) ;
			 end_work <- min_work_end + rnd (max_work_end - min_work_end) ;
			 living_place <- one_of(residential_buildings) ;
			 working_place <- one_of(industrial_buildings) ;
			 location <- any_location_in (living_place);  
		}  
		create agentfollower 
		{
					  do analyse_cluster species_to_analyse:"people";
					  peoplefollower<-self;
		}
	}
	
	reflex update_graph{
				create people number: 1
				{
			 speed <- min_speed + rnd (max_speed - min_speed) ;
			 start_work <- min_work_start + rnd (max_work_start - min_work_start) ;
			 end_work <- min_work_end + rnd (max_work_end - min_work_end) ;
			 living_place <- one_of(residential_buildings) ;
			 working_place <- one_of(industrial_buildings) ;
			 location <- any_location_in (living_place);  					
				}
		map<road,float> weights_map <- road as_map (each:: (each.destruction_coeff * each.shape.perimeter));
		the_graph <- the_graph with_weights weights_map;
		if (cycle>0)
		{
			testlist<-peoplefollower at_cycle ("multi_distribhistory","speed");
			testlist3<-peoplefollower at_cycle ("multi_minhistory","speed");
			testlist4<-peoplefollower at_cycle ("multi_averagehistory","speed");
			testlist5<-peoplefollower at_cycle ("multi_maxhistory","speed");
			testlist2<-[testlist2,testlist3,testlist4];
			testlist2<-peoplefollower distrib_legend ("speed");
			testlist4<-((peoplefollower.averagehistory at {(reverse(peoplefollower.numvarmap)["speed"]) as int,cycle-1}) as list);
			testlist4<-((peoplefollower.averagehistory at {(reverse(peoplefollower.numvarmap)["heading"]) as int,cycle-1}) as list);
			testlist5<-((peoplefollower.distribhistory at {(reverse(peoplefollower.numvarmap)["speed"]) as int,cycle-1}) as list);			
		}
		if (cycle=0) 
		{
			testlist<-[0,0,0];
			
		}
		//write ""+reverse(peoplefollower.numvarmap)["speed"]; 
		write ""+((peoplefollower.distribhistory at {(reverse(peoplefollower.numvarmap)["cestmoi"]) as int,cycle-1}) );   
//		write ""+(((peoplefollower.distribhistory at {(reverse(peoplefollower.numvarmap)["cestmoi"]) as int,cycle-1}) as list) at 0);
	}

	reflex repair_road when: (time mod repair_time) = 0 {
		let the_road_to_repair type: road value: (road as list) with_max_of (each.destruction_coeff) ;
		ask the_road_to_repair {
			set destruction_coeff value: 1 ;
		}
	}
}
entities {
	species agentfollower parent:agent_group_follower
	{
		
	}
	species building {
		string type; 
		rgb color <- rgb('gray')  ; 
		aspect base {
			draw shape color: color ;
		}
	}
	species road  {
		float destruction_coeff <- 1.0 max:2.0;
		int colorValue <- int(255*(destruction_coeff - 1)) update: int(255*(destruction_coeff - 1));
		rgb color <- rgb(min([255, colorValue]),max ([0, 255 - colorValue]),0)  update: rgb(min([255, colorValue]),max ([0, 255 - colorValue]),0) ;
		aspect base {
			draw  shape color: color ;
		}
	}
	species people skills: [moving]{
		rgb color <- rgb('yellow') ;
		building living_place <- nil ;
		building working_place <- nil ; 
		int start_work ;
		int end_work  ;
		string objective ; 
		point the_target <- nil ;
		
		reflex time_to_work when: day_time = start_work {
			 objective <- 'working' ;
			 the_target <- any_location_in (working_place);
		}
		reflex time_to_go_home when: day_time = end_work {
			 objective <- 'go home' ;
			 the_target <- any_location_in (living_place); 
		}  
		reflex move when: the_target != nil {
			path path_followed <- self goto [target::the_target, on::the_graph, return_path:: true];
			list<geometry> segments <- path_followed.segments;
			loop line over: segments {
				float dist <- line.perimeter;
				road ag <- road(path_followed agent_from_geometry line); 
				ask ag {
					destruction_coeff <- destruction_coeff + (destroy * dist / shape.perimeter);
				}
			}
			switch the_target { 
				match location { the_target <- nil ;}
			}
		}
		aspect base {
			draw circle(10) color: color;
		}
	} 
}

experiment road_traffic type: gui {
	parameter 'Shapefile for the buildings:' var: shape_file_buildings category: 'GIS' ;
	parameter 'Shapefile for the roads:' var: shape_file_roads category: 'GIS' ;
	parameter 'Shapefile for the bounds:' var: shape_file_bounds category: 'GIS' ;
	parameter 'Number of people agents' var: nb_people category: 'People' ;
	parameter 'Earliest hour to start work' var: min_work_start category: 'People' ;
	parameter 'Latest hour to start work' var: max_work_start category: 'People' ;
	parameter 'Earliest hour to end work' var: min_work_end category: 'People' ;
	parameter 'Latest hour to end work' var: max_work_end category: 'People' ;
	parameter 'minimal speed' var: min_speed category: 'People' ;
	parameter 'maximal speed' var: max_speed category: 'People' ;
	parameter 'Value of destruction when a people agent takes a road' var: destroy category: 'Road' ;
	parameter 'Number of steps between two road repairs' var: repair_time category: 'Road' ;
	
	output {
		display city_display refresh_every: 1 {
			species building aspect: base ;
			species road aspect: base ;
			species people aspect: base ;
		}
		display chart_display refresh_every: 10 { 
			chart name: 'Road Status' type: series background: rgb('lightGray') size: {0.9, 0.4} position: {0.05, 0.05} {
				data name:'Mean road destruction' value: mean (road collect each.destruction_coeff) style: line color: rgb('green') ;
				data name:'Max road destruction' value: road max_of each.destruction_coeff style: line color: rgb('red') ;
			}
			chart name: 'People follower' type: series background: rgb('lightGray') size: {0.9, 0.4} position: {0.05, 0.05} {
		//		data name:'people nb' value: ((peoplefollower.metadatahistory at {7,cycle}) as int) style: line color: rgb('green') ;
			}
		}
			display chart_displayHisto refresh_every: 1 { 
			chart name: 'Average tout st' type: histogram style: stack{
				datalist value: (testlist)  style:stack;
//				datalist value: (testlist) categoriesnames:(testlist2) style:stack;
//				datalist value: (testlist) categoriesnames:testlist6 style:stack;
			}


//			display chart_display4 refresh_every: 1 { 
//			chart name: 'Average tout st' type: histogram style: stack{
//				datalist value: (testlist) categoriesnames:(testlist2) style:stack;
////				datalist value: (testlist) categoriesnames:testlist6 style:stack;
//			}
			
		}
	}
}