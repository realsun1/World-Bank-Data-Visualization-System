package Analysis;

import java.util.ArrayList;
import java.util.Map;

public class expenditureVsMortality implements Analysis {
	
	private ArrayList<Map<Integer, Double>> results;
	
	
	public expenditureVsMortality(ArrayList<Map<Integer, Double>> dataValues) {
		this.results = dataValues;
	}

	@Override
	public void performComputation() {
		
	}
	
	
	public ArrayList<Map<Integer, Double>> getResults() {
		// TODO Auto-generated method stub
		return results;
	}
	
}
