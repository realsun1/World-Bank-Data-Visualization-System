package Analysis;

import java.util.HashMap;
import java.util.Map;

public class RatioEmissionsGDP implements Analysis {

	private Map<Integer, Double> emissions;
	private Map<Integer, Double> gdp;
	private int start;
	private int end;
	private Map<Integer, Double> results = new HashMap<Integer, Double>();

	public RatioEmissionsGDP(Map<Integer, Double> emissionMap, Map<Integer, Double> gdpMap, int year1, int year2){
		emissions=emissionMap;
		gdp=gdpMap;
		start=year1;
		end=year2;
		performComputation();
	}

	public void performComputation() {
		for (int i = start; i < end ; i++) {
			Double e = emissions.get(i);
			Double g = gdp.get(i);
			results.put(i,(e/g));
		}
	}

	public void getResults() {
		results.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " " + entry.getValue());
		});
	}
}
