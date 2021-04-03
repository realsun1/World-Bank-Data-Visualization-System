package Handlers;

import java.util.Map;

public class analysisFacade {
	countryObject currentCountry = new countryObject();


	public analysisFacade(String country,String dateRange){

		currentCountry.setTotalPop(getMap(country,"SP.POP.TOTL",dateRange));
		currentCountry.setCarbonDioxideEmissions(getMap(country,"EN.ATM.CO2E.PC",dateRange));
		currentCountry.setAirPollution(getMap(country,"EN.ATM.PM25.MC.M3",dateRange));
		currentCountry.setForestArea(getMap(country,"AG.LND.FRST.ZS",dateRange));
		currentCountry.setEnergyUse(getMap(country,"EG.USE.PCAP.KG.OE",dateRange));
		currentCountry.setGdpPerCapita(getMap(country,"NY.GDP.PCAP.CD",dateRange));
		currentCountry.setHospitalBeds(getMap(country,"SH.MED.BEDS.ZS",dateRange));
		currentCountry.setGovernmentExpenditure(getMap(country,"SE.XPD.TOTL.GD.ZS",dateRange));
		currentCountry.setMaternalRatio(getMap(country,"SH.STA.MMRT",dateRange));
		currentCountry.setHealthExpenditureCapita(getMap(country,"SH.XPD.CHEX.PC.CD",dateRange));
		currentCountry.setHealthExpenditurePercentage(getMap(country,"SH.XPD.CHEX.GD.ZS",dateRange));
		currentCountry.setInfantRatio(getMap(country,"SP.DYN.IMRT.IN",dateRange));
		printAll(currentCountry);
	}

	public Map<Integer, Double> getMap(String country, String analysis, String dateRange){
		dataHandler dataHandler = new dataHandler();
		networkHandler network = new networkHandler();
		String test = network.fetchJSON(country, analysis, dateRange);
		Map<Integer, Double> integerDoubleMap = dataHandler.parseJSON(test);
		return integerDoubleMap;
	}

	public void printAll(countryObject country){
		System.out.println("Carbon Dioxide Emmisions"+country.getCarbonDioxideEmissions());
		System.out.println("GDP per Capita"+country.getGdpPerCapita());
	}






}
