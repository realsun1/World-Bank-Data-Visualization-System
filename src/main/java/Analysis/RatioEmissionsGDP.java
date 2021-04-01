package Analysis;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class RatioEmissionsGDP implements Analysis {
	
	public void performComputation() {
		// populate the result object with the computed values
	}
	
	private double getCO2Emissions() {	// Ratio of CO2 emissions (metric tons per capita)

		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/EN.ATM.CO2E.PC?date&format=json", "all");
		System.out.println(urlString);
		double emissionForYear = 0;
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
						emissionForYear = 0;
					else
						emissionForYear = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsDouble();

					System.out.println("CO2 Emission for : " + year + " is " + emissionForYear);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}

		return emissionForYear;
	}
	
	private double getGDP() {	// GDP per capita (current US$)

		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/NY.GDP.PCAP.CD?date&format=json", "all");
		System.out.println(urlString);
		double GDPForYear = 0;
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
						GDPForYear = 0;
					else
						GDPForYear = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsDouble();

					System.out.println("GDP for : " + year + " is " + GDPForYear);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}

		return GDPForYear;
	}
	
	private double getRatio() {		// returns ratio between GDP and CO2 emissions
		return getGDP() / getCO2Emissions();
	}
	
}
