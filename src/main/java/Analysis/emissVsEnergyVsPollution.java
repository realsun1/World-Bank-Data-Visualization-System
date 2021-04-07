package Analysis;

import java.util.ArrayList;
import java.util.Map;

public class emissVsEnergyVsPollution implements Analysis {

	private ArrayList<Map<Integer, Double>> results = new ArrayList<Map<Integer, Double>>();
	private String[] legend = new String[]{"CO2 emissions", "Energy Use","Air Pollution"};
	private String[] labels = new String[]{"CO2", "Energy","Pollution"};
	private String title = "CO2 emissions vs Energy Use vs PM2.5 Air Pollution";
	private String[] validGraphs = {"Line Chart","Bar Chart","Scatter Chart","Report"};


	public emissVsEnergyVsPollution(ArrayList<Map<Integer, Double>> dataValues) { 
		results = dataValues;
	}

	@Override
	public String[] getLegend() {
		return legend;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void performComputation() {
		// TODO Auto-generated method stub
		
	}

	public String[] getLabels() {
		return labels;
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

}
