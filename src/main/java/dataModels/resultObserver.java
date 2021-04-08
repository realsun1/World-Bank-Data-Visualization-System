/**
* This class is an interface
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/
package dataModels;

public interface resultObserver {
	
	/*
	 * this method updates a graph
	 */
	public void updateGraphs();
	
	/*
	 * this method creates a new graph from scratch
	 */
	public void createGraphs();
}
