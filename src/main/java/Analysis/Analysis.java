/**
* This class is an interface
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/

package Analysis;

import java.util.ArrayList;
import java.util.Map;

public interface Analysis {

	/**
	 * this method perform any computation that needs to be done to calculate ratios, average and other information/calculations
	 */
	public void performComputation();
	
	/**
	 * this method cleans the data of not valid data values or empty data values
	 */
	public ArrayList<Map<Integer, Double>> cleanData();

	/**
	 * this is a getter method that gets the results after the data is cleaned
	 */
	public ArrayList<Map<Integer, Double>> getResults();

	/**
	 * this is a getter method to get the legend of graph
	 */ 
	public String[] getLegend();

	/**
	 * this is a getter method to get the title of analysis
	 */
	public String getTitle();

	/**
	 * this is a getter method to get the labels of graph
	 */
	public String[]getLabels();
	
	/**
	 * this is a getter method to get all the valid graph types 
	 */
	public String[] getGraphs();


}


