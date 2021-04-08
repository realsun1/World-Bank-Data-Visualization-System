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

//Ratio of Hospital beds (per 1,000 people) and Current health expenditure (per 1,000 people) (2-series graphs).

public class bedVsExpenditure implements Analysis {

	/*
	 * these are the instance variables of the class
	 */
	private ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();

	private String[] legend = new String[]{"Ratio of Hospital beds","Current health expenditure"};
	private String[] labels = new String[]{"Hospital Beds","Health Expenditure"};
	private String title="Ratio of Hospital beds and Current health expenditure (per 1000 people)";
	private String[] validGraphs = {"Line Chart","Bar Chart","Scatter Chart","Report Chart"};
	private ArrayList<Map<Integer, Double>> results = new ArrayList<Map<Integer, Double>>();
	
	/*
	 * this is the constructor of the class, it sets the data into dataValues and calls the performComputation method
	 * @param data this contains data of type ArrayList<Map<Integer, Double>>
	 */
	public bedVsExpenditure(ArrayList<Map<Integer, Double>> data) { 
		this.dataValues = data;
		performComputation();
	}
	
	/*
	 * {@inheritdoc}
	 * this method perform any computation that needs to be done to calculate ratio
	 */
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
	
	/*
	 * {@inheritdoc}
	 * this is a getter method to get the legend of graph
	 * @return legend This returns the legend of the graph
	 */
	@Override
	public String[] getLegend(){
		return legend;
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
	 * this is a getter method to get the labels of graph
	 * @return labels This returns the labels of the graph
	 */
	@Override
	public String[] getLabels() {
		return labels;
	}

	/*
	 * {@inheritdoc}
	 * this is a getter method that gets the results after the data is cleaned
	 * @return results This is the data after it is cleaned out
	 */
	public ArrayList<Map<Integer, Double>> getResults() {
		return results;
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

	/*
	 * {@inheritdoc}
	 * this method cleans the data of not valid data values or empty data values
	 * @return cleanData This returns the cleaned out data
	 */
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
