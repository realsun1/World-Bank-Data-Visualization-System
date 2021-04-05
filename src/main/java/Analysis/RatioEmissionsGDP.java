package Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RatioEmissionsGDP implements Analysis {


	private ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
	private Integer start;
	private Integer end;
	private ArrayList<Map<Integer, Double>> results = new ArrayList<Map<Integer, Double>>();
	private String[] legend = new String[]{"CO2 emissions", "GDP per capita"};
	private String[] labels = new String[]{"Emissions", "GDP"};
	private String title = "Ratio of CO2 emissions (metric tons per capita) and GDP per capita";

	public RatioEmissionsGDP(ArrayList<Map<Integer, Double>> data, Integer start, Integer end){
		this.dataValues = data;
		this.start = start;
		this.end = end;
		
		performComputation();

	}

	public void performComputation() {
		Map<Integer, Double> computationResults = new HashMap<Integer, Double>();
		
		for (int i = start; i < end ; i++) {
			Double g = (dataValues.get(0)).get(i);
			Double e = (dataValues.get(1)).get(i);
			computationResults.put(i,(g/e));
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


}
