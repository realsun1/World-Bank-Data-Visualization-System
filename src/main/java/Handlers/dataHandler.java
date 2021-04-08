/**
* This class is the data handler, the data values and the country list
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/

package Handlers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import dataModels.countryObj;

public class dataHandler {

	/*
	 * this is the constructor of the class
	 */
	public dataHandler(){

	}
	
	/*
	 * this method
	 * @param json
	 */
	public Map<Integer, Double> parseJSON(String json) { 
		JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
		
		Map<Integer, Double> dataDict = new HashMap<Integer, Double>();
		
		int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
		int yearValue;
		Double dataValue = 0.0;
		for (int i = 0; i < sizeOfResults; i++) {
			yearValue = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
			if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
				dataValue = 0.0;
			else
				dataValue = Double.parseDouble((jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsString()));
		dataDict.put(yearValue, dataValue);
	}
		
		
		return dataDict;
	}
	
	/*
	 * This method creates and returns the country list read from a file
	 * @return countryList This has all the countries stored in a list
	 */
	public ArrayList<countryObj> fetchCountries() { 
		ArrayList<countryObj> countryList = new ArrayList<countryObj>();
		String[] invalidAnalysis;
		countryObj country = null;
		String line = "";  
		String splitBy = ",";  
		try   
		{  

		BufferedReader br = new BufferedReader(new FileReader("country_list.csv"));  
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		String[] fileLine = line.split(splitBy);    // use comma as separator  
		
		for(int i =0;i<fileLine.length;i++) {
			
			if (i == 4) { 
				invalidAnalysis = fileLine[4].split("/");
				
				if (fileLine[3].equals("Now")) {
					country = new countryObj(fileLine[0],fileLine[1],Integer.valueOf(fileLine[2]),2020, invalidAnalysis);
				} else {
					 country = new countryObj(fileLine[0],fileLine[1],Integer.valueOf(fileLine[2]),Integer.valueOf(fileLine[3]), invalidAnalysis);
				}
			}
			
  
		}
		
		countryList.add(country);
		
		}  
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();  
		}  
		
		return countryList;
}

}
	

	
	 
