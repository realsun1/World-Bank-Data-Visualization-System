package Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class emissVsEnergyVsPollution implements Analysis {

	private ArrayList<Map<Integer, Double>> results = new ArrayList<Map<Integer, Double>>();


	public emissVsEnergyVsPollution(ArrayList<Map<Integer, Double>> dataValues) { 
		this.results = dataValues;
	}
	
	
	@Override
	public void performComputation() {
		// TODO Auto-generated method stub
		
	}



	public ArrayList<Map<Integer, Double>> getResults() {
		// TODO Auto-generated method stub
		return results;
	}

}