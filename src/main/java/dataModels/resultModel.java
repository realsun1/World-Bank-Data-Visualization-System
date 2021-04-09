/**
* This class has setter and getter methods, a boolean method compares analysis types
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/

package dataModels;

import Analysis.Analysis;

public class resultModel extends Subject {
	
	/**
	 * these are the instance variables of the class
	 */
	private Analysis currentAnalysis = null;
	private Analysis previousAnalysis;
	
	/**
	 * constructor
	 */
	public resultModel(){
		
	}
	
	/**
	 * getter method for the analysis
	 * @return currentAnalysis this returns the currentAnalysis of type Analysis
	 */
	public Analysis getCurrentAnalysis() {
		return currentAnalysis;
	}
	
	/**
	 * this method checks to see if the previous analysis type has changed from the current analysis type
	 * @return boolean, true (if it is the same) or false (if it is different)
	 */
	public boolean checkSame() {
		if (previousAnalysis != null && currentAnalysis.getClass().equals(previousAnalysis.getClass())) {
			return true;
		}
		return false;
	}

	/**
	 * this is a setter method that sets the current analysis to the previous analysis and the new current analysis is set
	 * if the analysis types are the same it calls on the notifyUpdateGraph and if they are different they call notifyCreateGraph
	 * @param currentAnalysis This is the analysis type
	 */
	public void setCurrentAnalysis(Analysis currentAnalysis) {
		this.previousAnalysis = this.currentAnalysis;
		this.currentAnalysis = currentAnalysis;
		
		if (previousAnalysis != null && currentAnalysis.getClass().equals(previousAnalysis.getClass())) {
			this.notifyUpdateGraph();
		} else {
			this.notifyCreateGraph();
		}
	}



}
