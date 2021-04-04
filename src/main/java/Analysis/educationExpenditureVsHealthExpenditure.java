package Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class educationExpenditureVsHealthExpenditure implements Analysis {

	
	private ArrayList<Map<Integer, Double>> results;
	private ArrayList<Map<Integer, Double>> dataValues;
	private Integer start;
	private Integer end;
	
	public educationExpenditureVsHealthExpenditure(ArrayList<Map<Integer, Double>> data, Integer start, Integer end) { 
		this.dataValues = data;
		this.start = start;
		this.end = end;
		performComputation();
	}

	
	
	
	
	
	@Override
	public void performComputation() {
	Map<Integer, Double> computationResults = new HashMap<Integer, Double>();
		
		for (int i = start; i < end ; i++) {
			Double g = (dataValues.get(0)).get(i);
			Double e = (dataValues.get(1)).get(i);
			computationResults.put(i,(e/g));
		}
		results.add(computationResults);
		
	}
	
	
	public ArrayList<Map<Integer, Double>> getResults(){
		return results;
	}

}
