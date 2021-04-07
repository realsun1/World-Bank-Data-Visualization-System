package Analysis;

import java.util.ArrayList;
import java.util.Map;

public class pollutionVsForest implements Analysis {
	private ArrayList<Map<Integer, Double>> results = new ArrayList<Map<Integer, Double>>();
	private String[] legend = new String[]{"PM2.5 air pollution", "Forest area (% of land area)"};
	private String[] labels = new String[]{"Pollution", "Area"};
	private String title = "PM2.5 air pollution vs Forest area";
	private String[] validGraphs = {"Line Chart","Bar Chart","Scatter Chart","Report"};

	
	public pollutionVsForest(ArrayList<Map<Integer, Double>> dataValues) {
		this.results = dataValues;
	}
	
	
	
	@Override
	public void performComputation() {
		// TODO Auto-generated method stub
		
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
