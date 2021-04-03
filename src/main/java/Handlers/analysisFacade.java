package Handlers;

import java.util.Map;

public class analysisFacade {



	public analysisFacade(String country,String dateRange){

		
	}

	public Map<Integer, Double> getMap(String country, String analysis, String dateRange){
		dataHandler dataHandler = new dataHandler();
		networkHandler network = new networkHandler();
		String test = network.fetchJSON(country, analysis, dateRange);
		Map<Integer, Double> integerDoubleMap = dataHandler.parseJSON(test);
		return integerDoubleMap;
	}








}
