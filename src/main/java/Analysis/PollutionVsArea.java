package Analysis;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class PollutionVsArea implements Analysis {

	public void performComputation() {
		// populate the result object with the computed values
	}
	
	private double getAirPollution() {	// PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) 
		
		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/EN.ATM.PM25.MC.M3?date&format=json", "all");
		System.out.println(urlString);
		double pollutionForYear = 0;
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
				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
				int size = jsonArray.size();
				int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
				int year;
				for (int i = 0; i < sizeOfResults; i++) {
					year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
					if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
						pollutionForYear = 0;
					else
						pollutionForYear = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsDouble();

					System.out.println("Air Pollution for : " + year + " is " + pollutionForYear);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
	}
		return pollutionForYear;
	}
	
	private double getForestArea() {	// Forest area (% of land area)
		
		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/AG.LND.FRST.ZS?date&format=json", "all");
		System.out.println(urlString);
		double areaForYear = 0;
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
				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
				int size = jsonArray.size();
				int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
				int year;
				for (int i = 0; i < sizeOfResults; i++) {
					year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
					if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
						areaForYear = 0;
					else
						areaForYear = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsDouble();

					System.out.println("Forest Area for : " + year + " is " + areaForYear);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
		return areaForYear;
	}
}
