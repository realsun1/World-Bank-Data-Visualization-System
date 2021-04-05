package Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class educationAverage implements Analysis {


	private ArrayList<Map<Integer, Double>> results = new ArrayList<Map<Integer, Double>>();
	private ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
	private Integer start;
	private Integer end;
	private String[] legend = new String[]{"Shown as Total (% of GDP)"};
	private String[] labels = new String[]{"Percentage of GDP","Total GDP"};
	private String title="Average of Government expenditure on education";
	
	
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
				System.out.println(dataValues.get(0).get(i));
				totalSpending += (dataValues.get(0)).get(i);
			}
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		double avg = totalSpending / (end - start);
		map.put(0,avg);
		map.put(1,totalSpending);
		results.add(map);

	}

	public ArrayList<Map<Integer, Double>> getResults() {
		// TODO Auto-generated method stub
		return results;
	}

	@Override
	public String[] getLabels() {
		return labels;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String[] getLegend() {
		return legend;
	}
}
