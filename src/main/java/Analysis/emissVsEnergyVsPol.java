package Analysis;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class emissVsEnergyVsPol implements Analysis {

	public void performComputation() {
		// populate the result object with the computed values
		// resultModel(currentAnalysis);
	}
	
	private double getCO2Emissions() { // CO2 emissions (metric tons per capita)
		
	//	String country;
	//	int startYear;
	//	int endYear;
	
	// fetchData for country, startYear and endYear from network handler
		
	//	String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/EN.ATM.CO2E.PC?date=%d:%d&format=json", country, startYear, endYear);
		
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
	
	private double getEnergyUse() {	// Energy use (kg of oil equivalent per capita)
		
		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/EG.USE.PCAP.KG.OE?date&format=json", "all");
		System.out.println(urlString);
		double energyForYear = 0;
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
						energyForYear = 0;
					else
						energyForYear = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsDouble();

					System.out.println("Energy Use for : " + year + " is " + energyForYear);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}

		return energyForYear;
		
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
		
	
//	public static void main (String args[]) {	// test
//		System.out.println(getCO2Emissions());
//	}

}
