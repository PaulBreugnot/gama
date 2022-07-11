/**
* Name: NewModel
* MPI Controler of OLZ.gaml
* Author: Lucas GROSJEAN
* Tags: MPI, Controler
*/

model controler

import "OLZ.gaml" as pp

global
{
	
	string file_name;
	int final_step <- 50;
	int rank;
	
	init
	{	
		seed <- 12.0;
		do init_sub_simulation;
		create slave;
	}
    
    action init_sub_simulation
    {
    	create pp.movingExp;
    }
    
    reflex runModel when: cycle < final_step
    {
		ask (pp.movingExp collect each.simulation)
	    {
			do _step_;
	    }
    }
    
    reflex die when: cycle = final_step
    {
    	ask (pp.movingExp collect each.simulation)
	    {
			do die;
	    }
	    ask slave
	    {
	    	do die;
	    }
    	do die;
    }
}

species slave parent: SlaveMPI
{
	cell cellule;
	int neighbors;
	
	list<agent> agent_inside_me;
	list<agent> inside_main;
	list<agent> inside_outer_OLZ;
	list<agent> inside_inner_OLZ;
	list<agent> to_delete;
	
	init
	{
		rank <- myRank;
		file_name <- "log"+myRank+".txt";
		do clearLogFile();
		
		if(myRank = 0)
		{	
			ask pp.movingExp[0]
			{
				myself.cellule <- cell[0,myself.myRank];
				myself.outer_OLZ_area <-myself.cellule.OLZ_bottom_outer;
				myself.inner_OLZ_area <- myself.cellule.OLZ_bottom_inner;
				myself.shape <- myself.cellule.shape;
			}
			neighbors <- 1;
		}else
		{
			neighbors <- 0;
			ask pp.movingExp[0]
			{
				myself.cellule <- cell[0,myself.myRank];
				myself.outer_OLZ_area <- myself.cellule.OLZ_top_outer ;
				myself.inner_OLZ_area <- myself.cellule.OLZ_top_inner;
				myself.shape <- myself.cellule.shape;
			}
		}
		do writeLog("My rank is " + myRank);
		do writeLog("NetSize " + MPI_SIZE());
		do writeLog("Seed = " + seed);	
	}
	
	action deleteAgentsNotInMyArea
	{
		ask pp.movingExp[0]
	    {
			myself.agent_inside_me <- agents; 
	    }
	    
		inside_main <- agent_inside_me inside(shape); 
		inside_outer_OLZ <- agent_inside_me inside(outer_OLZ_area);
		inside_inner_OLZ <- agent_inside_me inside(inner_OLZ_area);
		
		agent_inside_me <- inside_main + inside_outer_OLZ; // inner is in main
		
		list<agent> agent_outside_me;
		list<movingAgent> li;

		string deleted <- "";
		ask pp.movingExp[0] 
	    {
	    	agent_outside_me <- agents - myself.agent_inside_me;
	    	ask movingAgent
	    	{
	    		if(agent_outside_me contains self)
	    		{
	    			deleted<- deleted + ", " + self.name;
	    			do die;
	    		}
	    	}
	    }

		ask pp.movingExp[0]
	    {
			myself.agent_inside_me <- agents; 
			li <- movingAgent;
	    }
		do writeLog("deleted = " + deleted);
		do writeLog("agent_inside_me" + agent_inside_me);
		do writeLog("inside_outer_OLZ" + inside_outer_OLZ);
		do writeLog("inside_inner_OLZ" + inside_inner_OLZ);
		do writeLog("NB AGENTS =  " +length(li));
	}
	
	reflex routineMPI
	{
		do writeLog("--------"+cycle+"----------");
		
		do deleteAgentsNotInMyArea;
		
		do start_listener;
		
		do MPI_BARRIER();
		
		list<agent> t <- getAgentInNeighborInnerOLZ(neighbors);		
		do writeLog("getAgentInNeighborInnerOLZ = "+t);
		
		do MPI_BARRIER();
		
		do stop_listener;
	}
	
    action writeLog(string log)
	{
		save log type: text to: file_name rewrite:false;
	}
	
	action clearLogFile
	{
		save "" type: text to: file_name rewrite:true;
	}
}


experiment main
{	
}