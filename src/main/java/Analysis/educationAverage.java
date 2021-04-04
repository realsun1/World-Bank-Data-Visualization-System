package Analysis;

import java.util.ArrayList;
import java.util.Map;

public class educationAverage implements Analysis {

	
	private Double results;
	private ArrayList<Map<Integer, Double>> dataValues;
	private Integer start;
	private Integer end;
	
	
	public educationAverage(ArrayList<Map<Integer, Double>> dataValues,Integer start, Integer end) { 
		this.dataValues = dataValues;
		this.start = start;
		this.end = end;
		performComputation();
	}
	
	@Override
	public void performComputation() {
			Double totalSpending = 0.0;
			
			for (int i = start; i < end ; i++) {
				totalSpending += (dataValues.get(0)).get(i);
				System.out.println(totalSpending);
	
			}
			results = totalSpending / (end - start);

		
	}

	public Double getResults() {
		// TODO Auto-generated method stub
		return results;
	}

	
	
	
	
	

}
