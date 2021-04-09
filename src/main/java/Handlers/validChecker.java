/**
* This class implements the validChecker, it checks if the information chosen by the user is valid
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/
package Handlers;
import java.util.ArrayList;
import java.util.Map;

import Analysis.Analysis;
import dataModels.countryObj;

public class validChecker {


	/**
	 * constructor
	 */
	public validChecker() {
		
	}
	
	/**
	 * this method checks if the years entered and the country entered by the user is valid
	 * @param startYear This is the first parameter of the method
	 * @param endYear This is the second parameter of the method
	 * @param country This is the final parameter of the method
	 * @return a boolean value, true or false
	 */
	public boolean checkYears(int startYear, int endYear, countryObj country) { 
		return ((endYear - startYear) <= 0 || (startYear < country.getValidStart() || endYear > country.getValidEnd()));
	}
	
	/**
	 * this method checks if the country analysis chosen is valid
	 * @param chosenAnalysis This is the first parameter of the method
	 * @param country This is the second parameter of the method
	 * @return a boolean value, if the result is valid (true) or not valid (false)
	 */
	public boolean checkCountryAnalysis(String chosenAnalysis, countryObj country) { 
		boolean isValid = true;
		
		for (String analysis: country.getInvalidAnalysis()) {
			
			if (analysis.equals(chosenAnalysis)) { 
				isValid = false;
				break;
			}
			
		}
		return isValid;
	}
	
	/**
	 * this method checks if the graph chosen is valid
	 * @param currentAnalysis This is the first parameter of the method
	 * @param graph This is the second parameter of the method
	 * @return a boolean value, if the result is valid (true) or not valid (false)
	 */
	public boolean checkValidGraphs(Analysis currentAnalysis, String graph) { 
		boolean isValid = false;
		
		for (String validGraph: currentAnalysis.getGraphs()) {


			if (validGraph.equals(graph)) {
				isValid = true;
				break;
			}
			
			
		}
		
		return isValid;
	}
	
	/**
	 * this method checks if the data is valid
	 * @param toCheck This is the first parameter of the method, it is of type ArrayList
	 * @return a boolean value, if the result is valid (true) or not valid (false)
	 */
	public boolean checkData(ArrayList<Map<Integer, Double>> toCheck) { 
		boolean isValid = false;
		
		for(int i=0;i<toCheck.size() && !isValid;i++) {

			for(Double value: toCheck.get(i).values()) { 

				if (value != 0.0) {
					isValid = true;
					break;
				}
			}
			
			if (!isValid) {
				break;
			}

		}

		return isValid;
	}

}
