
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.util.*;

public class dataHandler {

	dataHandler(){
		
	}
	
	
	
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
	
	

}
	

	
	 
