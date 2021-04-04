package Analysis;

import java.util.ArrayList;
import java.util.Map;

public class bedVsExpenditure implements Analysis {
	
	private ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
	private Integer start;
	private Integer end;
	
	public bedVsExpenditure(ArrayList<Map<Integer, Double>> data, Integer start, Integer end) { 
		this.dataValues = data;
		this.start = start;
		this.end = end;
		performComputation();
	}
	

	@Override
	public void performComputation() {
		dataValues.forEach((x) -> x.forEach((k, v) -> {
            v = v/1000;
        }));
		
	}
	
	public ArrayList<Map<Integer, Double>> getResults() { 
		return dataValues;
	}

}
