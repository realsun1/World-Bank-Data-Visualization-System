package Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RatioEmissionsGDP implements Analysis {


	private ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
	private ArrayList<Map<Integer, Double>> results = new ArrayList<Map<Integer, Double>>();
	private String[] legend = new String[]{"CO2 emissions", "GDP per capita"};
	private String[] labels = new String[]{"Emissions", "GDP"};
	private String title = "Ratio of CO2 emissions (metric tons per capita) and GDP per capita";
	private String[] validGraphs = {"Bar Chart", "Line Chart", "Scatter Chart"};

	public RatioEmissionsGDP(ArrayList<Map<Integer, Double>> data){
		this.dataValues = data;
		performComputation();

	}

	public void performComputation() {
		Map<Integer, Double> computationResults = new HashMap<Integer, Double>();
	
		for(Map<Integer, Double> data: cleanData()) {
			
			for(Integer year: data.keySet()) {
				Double g = (dataValues.get(0)).get(year);
				Double e = (dataValues.get(1)).get(year);
		
				computationResults.put(year,(g/e));
			
			}
			
		}
		results.add(computationResults);
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

	public ArrayList<Map<Integer, Double>> getResults() {
		// TODO Auto-generated method stub
		return results;
	}

	@Override
	public String[] getGraphs() {
		// TODO Auto-generated method stub
		return validGraphs;
	}

	@Override
	public ArrayList<Map<Integer, Double>> cleanData() {
		ArrayList<Map<Integer, Double>> cleanData = new ArrayList<Map<Integer, Double>>();
		
		for(Map<Integer, Double> list: dataValues) {
			Map<Integer, Double> cleanValues = new HashMap<Integer, Double>();

			for(Integer year: list.keySet()) {
				
				if (list.get(year) != 0.0) {
					cleanValues.put(year, list.get(year));
				}
				
				
			}
			cleanData.add(cleanValues);
			
		}
		
		
		return cleanData;
	}


}
