package Handlers;

import java.util.ArrayList;
import java.util.Map;

import Analysis.*;
import resultModel.resultModel;

public class analysisFacade {

	 public static void main(String[] args)
	    {
		 dataHandler handler = new dataHandler();
		 String[] analysis = {"SH.MED.BEDS.ZS","SH.XPD.CHEX.PC.CD"};
		 analysisFacade facade = new analysisFacade();
	        facade.getBedVsExpenditure(handler.fetchCountries().get(0),analysis,"2000:2020");
	    }


	public resultModel getData(countryObj country,String[] analysisType,String dateRange) { 

		
		String analysisValues = String.join(",", analysisType);

		switch(analysisValues) { 
		
		case "EN.ATM.CO2E.PC,NY.GDP.PCAP.CD":
			
		// From here call the certain method to get that analysis type.
		
		
		}
		
		
		resultModel model = new resultModel();
		return model;
	}
	
	
	private RatioEmissionsGDP getEmissionGDP(countryObj country,String[] analysisType,String dateRange) { 
		ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
		for (String analysis: analysisType) { 
			dataValues.add(getMap(country,analysis,dateRange));
		}
		
		Integer startYear = Integer.valueOf(dateRange.split(":")[0]);
		Integer endYear = Integer.valueOf(dateRange.split(":")[1]);

		RatioEmissionsGDP analysis = new RatioEmissionsGDP(dataValues,startYear,endYear);
		
		
		return analysis;
	}

	private forestAverage getForestAverage(countryObj country,String[] analysisType,String dateRange) { 
		ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
		for (String analysis: analysisType) { 
			dataValues.add(getMap(country,analysis,dateRange));
		}
		
		Integer startYear = Integer.valueOf(dateRange.split(":")[0]);
		Integer endYear = Integer.valueOf(dateRange.split(":")[1]);

		forestAverage analysis = new forestAverage(dataValues,startYear,endYear);
		
		
		return analysis;
	}
	
	private educationAverage getEducationAverage(countryObj country,String[] analysisType,String dateRange) { 
		ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
		for (String analysis: analysisType) { 
			dataValues.add(getMap(country,analysis,dateRange));
		}
		
		Integer startYear = Integer.valueOf(dateRange.split(":")[0]);
		Integer endYear = Integer.valueOf(dateRange.split(":")[1]);

		educationAverage analysis = new educationAverage(dataValues,startYear,endYear);
		
		
		return analysis;
	}
	
	
	private bedVsExpenditure getBedVsExpenditure(countryObj country,String[] analysisType,String dateRange) { 
		ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
		for (String analysis: analysisType) { 
			dataValues.add(getMap(country,analysis,dateRange));
		}
	
		Integer startYear = Integer.valueOf(dateRange.split(":")[0]);
		Integer endYear = Integer.valueOf(dateRange.split(":")[1]);

		bedVsExpenditure analysis = new bedVsExpenditure(dataValues,startYear,endYear);
		
		
		return analysis;
	}
	
	private expenditureVsMortality getExpenditureVsMortality(countryObj country,String[] analysisType,String dateRange) { 
		ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
		for (String analysis: analysisType) { 
			dataValues.add(getMap(country,analysis,dateRange));
		}
	

		expenditureVsMortality analysis = new expenditureVsMortality(dataValues);
		
		
		return analysis;
	}
	
	private educationExpenditureVsHealthExpenditure getEducationExpenditureVsHealthExpenditure(countryObj country,String[] analysisType,String dateRange) { 
		ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
		for (String analysis: analysisType) { 
			dataValues.add(getMap(country,analysis,dateRange));
		}
		Integer startYear = Integer.valueOf(dateRange.split(":")[0]);
		Integer endYear = Integer.valueOf(dateRange.split(":")[1]);

		educationExpenditureVsHealthExpenditure analysis = new educationExpenditureVsHealthExpenditure(dataValues,startYear,endYear);
		
		
		return analysis;
	}
	
	private emissVsEnergyVsPollution getEmissVsEnergyVsPollution(countryObj country,String[] analysisType,String dateRange) { 
		ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
		for (String analysis: analysisType) { 
			dataValues.add(getMap(country,analysis,dateRange));
		}


		emissVsEnergyVsPollution analysis = new emissVsEnergyVsPollution(dataValues);
		
		
		return analysis;
	}
	
	private pollutionVsForest getPollutionVsForest(countryObj country,String[] analysisType,String dateRange) { 
		ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
		for (String analysis: analysisType) { 
			dataValues.add(getMap(country,analysis,dateRange));
		}


		pollutionVsForest analysis = new pollutionVsForest(dataValues);
		
		
		return analysis;
	}
	
	
	
	public Map<Integer, Double> getMap(countryObj country, String analysisType, String dateRange){
		dataHandler dataHandler = new dataHandler();
		networkHandler network = new networkHandler();
		String test = network.fetchJSON(country, analysisType, dateRange);
		Map<Integer, Double> integerDoubleMap = dataHandler.parseJSON(test);

	 
		return integerDoubleMap;
	}








}
