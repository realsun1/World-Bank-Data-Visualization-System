
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class networkHandler {

	
	networkHandler() { 
		
	}
	
	

	
	
	public String fetchJSON(String countryName, String analysisType, String dateRange) {
		String urlString = String.format(
				"http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s&format=json", countryName,analysisType,dateRange);

		
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				return inline;
				}

		} catch (IOException e) {

		}

		
		return null; 
	}

}


