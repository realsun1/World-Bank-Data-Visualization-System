package Analysis;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class averageEducationExpenditure implements Analysis {
	
	public void performComputation() {
		// populate the result object with the computed values
	}
	
	private double getGovernmentExpenditure() { // Government expenditure on education, total (% of GDP)

		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/SE.XPD.TOTL.GD.ZS?date&format=json", "all");
		System.out.println(urlString);
		double expenditureForYear = 0;
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
						expenditureForYear = 0;
					else
						expenditureForYear = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsDouble();

					System.out.println("Government Expenditure for : " + year + " is " + expenditureForYear);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}

		return expenditureForYear;
	}
	
	private double getAverageSelectYears() { // Average of Government expenditure on education, total (% of GDP)
		
		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/SE.XPD.TOTL.GD.ZS?date&format=json", "all");
		System.out.println(urlString);
		double expenditureForYear = 0;
		double cummulativeExpenditure = 0;
		double average = 0;
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
						expenditureForYear = 0;
					else
						expenditureForYear = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsDouble();

					cummulativeExpenditure += expenditureForYear;
				}
				System.out.println("The average Government Expenditure over the selected years is " + cummulativeExpenditure / sizeOfResults);
				average = cummulativeExpenditure / sizeOfResults;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}

		return average;
	}

}
