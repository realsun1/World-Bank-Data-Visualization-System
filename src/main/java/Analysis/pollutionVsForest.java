package Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class pollutionVsForest implements Analysis {
	private ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
	private String[] legend = new String[]{"PM2.5 air pollution", "Forest area (% of land area)"};
	private String[] labels = new String[]{"Pollution", "Area"};
	private String title = "PM2.5 air pollution vs Forest area";
	private String[] validGraphs = {"Line Chart","Bar Chart","Scatter Chart","Report"};

	
	public pollutionVsForest(ArrayList<Map<Integer, Double>> dataValues) {
		this.dataValues = dataValues;
		this.dataValues = cleanData();
	}
	
	
	
	@Override
	public void performComputation() {
		// TODO Auto-generated method stub
		
	}


	public ArrayList<Map<Integer, Double>> getResults() {
		// TODO Auto-generated method stub
		return dataValues;
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
