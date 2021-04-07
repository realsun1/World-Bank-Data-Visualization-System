package Handlers;
import java.util.ArrayList;
import java.util.Map;

import Analysis.Analysis;
import dataModels.countryObj;

public class validChecker {


	
	public validChecker() {
		
	}
	
	public boolean checkYears(int startYear, int endYear, countryObj country) { 
		return ((endYear - startYear) <= 0 || (startYear < country.getValidStart() || endYear > country.getValidEnd()));
	}
	
	
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
