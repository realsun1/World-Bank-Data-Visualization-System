package Analysis;

import java.util.ArrayList;
import java.util.Map;

public class expenditureVsMortality implements Analysis {

	private ArrayList<Map<Integer, Double>> results = new ArrayList<Map<Integer, Double>>();
	private String[] legend = new String[]{"Current health expenditure", "Mortality rate, infant"};
	private String[] labels = new String[]{"Expenditure", "Mortality"};
	private String title = "Current health expenditure per capita vs Mortality rate, infant";
	private String[] validGraphs = {"Line Chart","Bar Chart","Scatter Chart","Report"};

	
	public expenditureVsMortality(ArrayList<Map<Integer, Double>> dataValues) {
		this.results = dataValues;
	}

	@Override
	public void performComputation() {
		
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
	
}
