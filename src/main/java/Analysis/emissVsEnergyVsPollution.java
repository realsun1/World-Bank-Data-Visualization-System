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

public class emissVsEnergyVsPollution implements Analysis {

	/*
	 * these are the instance variables of the class
	 */
	private ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
	private String[] legend = new String[]{"CO2 emissions", "Energy Use","Air Pollution"};
	private String[] labels = new String[]{"CO2", "Energy","Pollution"};
	private String title = "CO2 emissions vs Energy Use vs PM2.5 Air Pollution";
	private String[] validGraphs = {"Line Chart","Bar Chart","Scatter Chart","Report"};

	/*
	 * this is the constructor of the class, it sets the data into dataValues and calls the cleanData method
	 * @param data this contains data of type ArrayList<Map<Integer, Double>>
	 */
	public emissVsEnergyVsPollution(ArrayList<Map<Integer, Double>> dataValues) { 
		this.dataValues = dataValues;
		cleanData();
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
	 * this is a getter method to get the title of analysis
	 * @return title This returns the title of the analysis
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/*
	 * {@inheritdoc}
	 * this method perform any computation but in this analysis no calculation is required
	 */
	@Override
	public void performComputation() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * {@inheritdoc}
	 * this is a getter method to get the labels of graph
	 * @return labels This returns the labels of the graph
	 */
	public String[] getLabels() {
		return labels;
	}

	/*
	 * {@inheritdoc}
	 * this is a getter method that gets the results after the data is cleaned
	 * @return dataValues This is the data after it is cleaned out
	 */
	public ArrayList<Map<Integer, Double>> getResults() {
		// TODO Auto-generated method stub
		return dataValues;
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
