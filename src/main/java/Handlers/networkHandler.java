package Handlers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import dataModels.countryObj;

public class networkHandler {

	
	networkHandler() { 
		
	}
	
	

	
	
	public String fetchJSON(countryObj country, String analysisType, String dateRange) {
		String urlString = String.format(
				"http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s&format=json", country.getCountryCode(),analysisType,dateRange);

		System.out.println(urlString);
		
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


