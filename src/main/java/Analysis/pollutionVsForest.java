package Analysis;

import java.util.ArrayList;
import java.util.Map;

public class pollutionVsForest implements Analysis {
	private ArrayList<Map<Integer, Double>> results;

	
	public pollutionVsForest(ArrayList<Map<Integer, Double>> dataValues) {
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