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
	private String[] validGraphs = {"Pie Chart"};

	
	public forestAverage(ArrayList<Map<Integer, Double>> dataValues,Integer start, Integer end) { 
		this.dataValues = dataValues;
		this.start = start;
		this.end = end;
		performComputation();
	}
	
	@Override
	public void performComputation() {
			Double totalArea = 0.0;
			Map<Integer, Double> cleanData = cleanData().get(0);
	
				for(Integer year: cleanData.keySet()) {
					totalArea += (dataValues.get(0)).get(year);
				
			}
				
				
			

			Map<Integer, Double> map = new HashMap<Integer, Double>();
			Double avgArea=(totalArea / (cleanData.size()));
			map.put(0,totalArea);
			map.put(1,avgArea);
			results.add(map);
	}
	
	public ArrayList<Map<Integer, Double>> cleanData() {
		ArrayList<Map<Integer, Double>> cleanData = new ArrayList<Map<Integer, Double>>();
		
		for(Map<Integer, Double> list: dataValues) {
			Map<Integer, Double> cleanValues = new HashMap<Integer, Double>();

			for(Integer year: list.keySet()) {
				
				if (dataValues.get(0).get(year) != 0.0) {
					cleanValues.put(year, dataValues.get(0).get(year));
				}
				
				
			}
			cleanData.add(cleanValues);
			
		}
		
		
		return cleanData;
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

	@Override
	public String[] getGraphs() {
		// TODO Auto-generated method stub
		return validGraphs;
	}
}
