/**
* This class implements the Analysis class
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/

package Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class forestAverage implements Analysis{
	
	/*
	 * these are the instance variables of the class
	 */
	private ArrayList<Map<Integer, Double>> results = new ArrayList<Map<Integer, Double>>();
	private ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
	private String[] legend = new String[]{"(Shown as a percentage of total land area)"};
	private String[] labels = new String[]{"Average Forest area", "Total land area"};
	private String title = "Average Forest area (% of land area)";
	private String[] validGraphs = {"Pie Chart"};

	
	/*
	 * this is the constructor of the class, it sets the data into dataValues and calls the performComputation method
	 * @param data this contains data of type ArrayList<Map<Integer, Double>>
	 */
	public forestAverage(ArrayList<Map<Integer, Double>> dataValues) { 
		this.dataValues = dataValues;

		performComputation();
	}
	
	/*
	 * {@inheritdoc}
	 * this method perform any computation that needs to be done to calculate average
	 */
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
	
	/*
	 * {@inheritdoc}
	 * this method cleans the data of not valid data values or empty data values
	 * @return cleanData This returns the cleaned out data
	 */
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

	/*
	 * {@inheritdoc}
	 * this is a getter method that gets the results after the data is cleaned
	 * @return results This is the data after it is cleaned out
	 */
	public ArrayList<Map<Integer, Double>> getResults() {
		// TODO Auto-generated method stub
		return results;
	}

	/*
	 * {@inheritdoc}
	 * this is a getter method to get the legend of graph
	 * @return legend This returns the legend of the graph
	 */
	@Override
	public String[] getLegend() {
		return legend;
	}

	/*
	 * {@inheritdoc}
	 * this is a getter method to get the labels of graph
	 * @return labels This returns the labels of the graph
	 */
	@Override
	public String[] getLabels() {
		return labels;
	}

	/*
	 * {@inheritdoc}
	 * this is a getter method to get the title of analysis
	 * @return title This returns the title of the analysis
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/*
	 * {@inheritdoc}
	 * this is a getter method to get all the valid graph types 
	 * @return validGraphs This returns all the valid graphs
	 */
	@Override
	public String[] getGraphs() {
		// TODO Auto-generated method stub
		return validGraphs;
	}
}
