package Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Ratio of Hospital beds (per 1,000 people) and Current health expenditure (per 1,000 people) (2-series graphs).

public class bedVsExpenditure implements Analysis {

	private ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();

	private String[] legend = new String[]{"Ratio of Hospital beds","Current health expenditure"};
	private String[] labels = new String[]{"Hospital Beds","Health Expenditure"};
	private String title="Ratio of Hospital beds and Current health expenditure (per 1000 people)";
	private String[] validGraphs = {"Line Chart","Bar Chart","Scatter Chart","Report Chart"};
	private ArrayList<Map<Integer, Double>> results = new ArrayList<Map<Integer, Double>>();
	
	public bedVsExpenditure(ArrayList<Map<Integer, Double>> data) { 
		this.dataValues = data;
		performComputation();
	}
	

	@Override
	public void performComputation() {
		Map<Integer, Double> map = new HashMap<Integer, Double>();
	
		for(Map<Integer, Double> data: dataValues) {
			
			for(Integer year: data.keySet()) {
				map.put(year,((dataValues.get(0).get(year))/(dataValues.get(0).get(year))));
			}
			
		}
		results.add(map);
	}
	@Override
	public String[] getLegend(){
		return legend;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String[] getLabels() {
		return labels;
	}

	public ArrayList<Map<Integer, Double>> getResults() {
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
