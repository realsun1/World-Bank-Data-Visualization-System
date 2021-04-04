package Handlers;

import java.util.ArrayList;
import java.util.Map;

import Analysis.*;
import resultModel.resultModel;

public class analysisFacade {

	 public static void main(String[] args)
	    {
		 dataHandler handler = new dataHandler();
		 String[] analysis = {"AG.LND.FRST.ZS"};
		 analysisFacade facade = new analysisFacade();
	        facade.getForestAverage(handler.fetchCountries().get(0),analysis,"2000:2005");
	    }


	/*public resultModel getData(countryObj country,String[] analysisType,String dateRange) { 

		
		String analysisValues = String.join(",", analysisType);

		switch(analysisValues) { 
		
		case "EN.ATM.CO2E.PC,NY.GDP.PCAP.CD":
			
		
		
		
		}
		
		
		resultModel model = new resultModel();
		return model;
	}*/
	
	
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
	
	
	
	
	
	
	public Map<Integer, Double> getMap(countryObj country, String analysisType, String dateRange){
		dataHandler dataHandler = new dataHandler();
		networkHandler network = new networkHandler();
		String test = network.fetchJSON(country, analysisType, dateRange);
		Map<Integer, Double> integerDoubleMap = dataHandler.parseJSON(test);
		return integerDoubleMap;
	}








}
