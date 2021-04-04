package Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class forestAverage implements Analysis{
	private Double results;
	private ArrayList<Map<Integer, Double>> dataValues;
	private Integer start;
	private Integer end;
	
	
	public forestAverage(ArrayList<Map<Integer, Double>> dataValues,Integer start, Integer end) { 
		this.dataValues = dataValues;
		this.start = start;
		this.end = end;
		performComputation();
	}
	
	@Override
	public void performComputation() {
			Double totalArea = 0.0;
			
			for (int i = start; i < end ; i++) {
				totalArea += (dataValues.get(0)).get(i);
				
	
			}
			results = totalArea / (end - start);
		
	}

	public Double getResults() {
		// TODO Auto-generated method stub
		return results;
	}

}
