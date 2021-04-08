/**
* This class calls other methods from different classes to add, remove, update the lists
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/

package dataModels;

import java.util.*;

public abstract class Subject {
	
	/*
	 * creates a list
	 */
	private List<resultObserver> observerList = new ArrayList<resultObserver>();
	
	/*
	 * this method calls the add method on the list and adds the data in the parameter
	 * @param observer The only parameter for the attach method
	 */
	public void attatch(resultObserver observer) { 
		observerList.add(observer);
	}
	
	/*
	 * this method calls the remove method on the list and removes the data in the parameter
	 * @param observer The only parameter for the remove method
	 */
	public void detatch(resultObserver observer) { 
		observerList.remove(observer);
	}
	
	/*
	 * this method calls the remove method on the list and removes the data in the parameter
	 */
	public void notifyCreateGraph() {
		for (resultObserver observer: observerList) {
			observer.createGraphs();
		}
	}
	
	/*
	 * this method calls the remove method on the list and removes the data in the parameter
	 */
	public void notifyUpdateGraph() {
		for (resultObserver observer: observerList) {
			observer.updateGraphs();
		}
	}
}
