package Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class educationExpenditureVsHealthExpenditure implements Analysis {


    private ArrayList<Map<Integer, Double>> results = new ArrayList<Map<Integer, Double>>();
    private ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();

    private String[] legend = new String[]{"Government expenditure on education", "Current health expenditure"};
    private String[] labels = new String[]{"Education", "Health"};
    private String title = "Ratio of Government expenditure on education vs Current health expenditure";
	private String[] validGraphs = {"Line Chart","Bar Chart","Scatter Chart","Report"};

    public educationExpenditureVsHealthExpenditure(ArrayList<Map<Integer, Double>> data) {
        this.dataValues = data;
        performComputation();
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
    public void performComputation() {
        Map<Integer, Double> computationResults = new HashMap<Integer, Double>();

		for(Map<Integer, Double> data: cleanData()) {
			
			for(Integer year: data.keySet()) {
			     Double g = (dataValues.get(0)).get(year);
		         Double e = (dataValues.get(1)).get(year);
		         if (e != 0.0 && g != 0.0) {
		      
		         computationResults.put(year, (e / g));
		         }
		  
			}
			
		}
        

        results.add(computationResults);

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
		// TODO Auto-generated method stub

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
