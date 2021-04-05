package Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class forestAverage implements Analysis{
	private ArrayList<Map<Integer, Double>> results = new ArrayList<Map<Integer, Double>>();
	private ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
	private Integer start;
	private Integer end;
	private String[] legend = new String[]{"(Shown as a percentage of total land area)"};
	private String[] labels = new String[]{"Average Forest area", "Total land area"};
	private String title = "Average Forest area (% of land area)";
	
	
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
			Map<Integer, Double> map = new HashMap<Integer, Double>();
			Double avgArea=(totalArea / (end - start));
			System.out.println(totalArea+" , "+avgArea);
			map.put(0,totalArea-avgArea);
			map.put(1,avgArea);
			results.add(map);
	}

	public ArrayList<Map<Integer, Double>> getResults() {
		// TODO Auto-generated method stub
		return results;
	}

	@Override
	public String[] getLegend() {
		return legend;
	}

	@Override
	public String[] getLabels() {
		return labels;
	}

	@Override
	public String getTitle() {
		return title;
	}
}
