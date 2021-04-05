package Handlers;

import java.util.ArrayList;
import java.util.Map;

import Analysis.*;

public class analysisFacade {

    private String[] countryList = {"Botswana","Cambodia","Canada","Cyprus","United States Minor Outlying Islands"};

    public static void main(String[] args) {
        /*dataHandler handler = new dataHandler();
        String[] analysis = {"SH.MED.BEDS.ZS", "SH.XPD.CHEX.PC.CD"};
        analysisFacade facade = new analysisFacade();
        facade.getBedVsExpenditure(handler.fetchCountries().get(0), analysis, "2000:2020");*/
    }

    public Analysis analysisTest(String country, String dateRange, String analysisType){
        dataHandler handler = new dataHandler();
        analysisFacade facade = new analysisFacade();
        countryObj countryObj = null;
        for (int i = 0; i < countryList.length ; i++) {
            if (countryList[i].equals(country)) {
                 countryObj = handler.fetchCountries().get(i);
            }
        }
        Analysis analysis = null;
        //Ratio of CO2 emissions (metric tons per capita) and GDP per capita (current US$)
        if ("GEG".equals(analysisType)) {
            analysis = facade.getEmissionGDP(countryObj, dateRange);
        }
        //Average Forest area (% of land area) for the selected years
        else if ("GFA".equals(analysisType)) {
            analysis = facade.getForestAverage(countryObj, dateRange);
        }
        //PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) vs Forest area (% of land area)
        else if ("PVF".equals(analysisType)) {
            analysis = facade.getPollutionVsForest(countryObj, dateRange);
        }
        //CO2 emissions (metric tons per capita) vs Energy use (kg of oil equivalent per capita) vs PM2.5 air pollution, mean annual exposure (micrograms per cubic meter)
        else if ("EEP".equals(analysisType)) {
            analysis = facade.getEmissVsEnergyVsPollution(countryObj, dateRange);
        }
        //Current health expenditure per capita (current US$) vs Mortality rate, infant (per 1,000 live births)
        else if ("EVM".equals(analysisType)) {
            analysis = facade.getExpenditureVsMortality(countryObj, dateRange);
        }
        //Ratio of Hospital beds (per 1,000 people) and Current health expenditure (per 1,000 people)
        else if ("BVE".equals(analysisType)) {
            analysis = facade.getBedVsExpenditure(countryObj, dateRange);
        }
        //Ratio of Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP).
        else if ("EVH".equals(analysisType)) {
            analysis = facade.getEducationExpenditureVsHealthExpenditure(countryObj, dateRange);
        }
        //Average of Government expenditure on education, total (% of GDP) for the selected years
        else if ("EAV".equals(analysisType)) {
            analysis = facade.getEducationAverage(countryObj, dateRange);
        }

        return analysis;

    }


    /*public resultModel getData(countryObj country, String[] analysisType, String dateRange) {


        String analysisValues = String.join(",", analysisType);

        switch (analysisValues) {

            case "EN.ATM.CO2E.PC,NY.GDP.PCAP.CD":

                // From here call the certain method to get that analysis type.


        }


        resultModel model = new resultModel();
        return model;
    }*/


    private RatioEmissionsGDP getEmissionGDP(countryObj country, String dateRange) {
        String[] analysisType = {"EN.ATM.CO2E.PC","NY.GDP.PCAP.CD"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }

        Integer startYear = Integer.valueOf(dateRange.split(":")[0]);
        Integer endYear = Integer.valueOf(dateRange.split(":")[1]);

        RatioEmissionsGDP analysis = new RatioEmissionsGDP(dataValues, startYear, endYear);


        return analysis;
    }

    private forestAverage getForestAverage(countryObj country, String dateRange) {
        String[] analysisType = {"AG.LND.FRST.ZS"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }

        Integer startYear = Integer.valueOf(dateRange.split(":")[0]);
        Integer endYear = Integer.valueOf(dateRange.split(":")[1]);

        forestAverage analysis = new forestAverage(dataValues, startYear, endYear);


        return analysis;
    }

    private educationAverage getEducationAverage(countryObj country, String dateRange) {
        String[] analysisType = {"SE.XPD.TOTL.GD.ZS"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }

        Integer startYear = Integer.valueOf(dateRange.split(":")[0]);
        Integer endYear = Integer.valueOf(dateRange.split(":")[1]);

        educationAverage analysis = new educationAverage(dataValues, startYear, endYear);


        return analysis;
    }


    private bedVsExpenditure getBedVsExpenditure(countryObj country, String dateRange) {
        String[] analysisType = {"SH.MED.BEDS.ZS", "SH.XPD.CHEX.PC.CD"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }

        Integer startYear = Integer.valueOf(dateRange.split(":")[0]);
        Integer endYear = Integer.valueOf(dateRange.split(":")[1]);

        bedVsExpenditure analysis = new bedVsExpenditure(dataValues, startYear, endYear);


        return analysis;
    }

    private expenditureVsMortality getExpenditureVsMortality(countryObj country, String dateRange) {
        String[] analysisType = {"SH.XPD.CHEX.PC.CD","SP.DYN.IMRT.IN"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }


        expenditureVsMortality analysis = new expenditureVsMortality(dataValues);


        return analysis;
    }

    private educationExpenditureVsHealthExpenditure getEducationExpenditureVsHealthExpenditure(countryObj country, String dateRange) {
        String[] analysisType = {"SE.XPD.TOTL.GD.ZS","SH.XPD.CHEX.GD.ZS"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }
        Integer startYear = Integer.valueOf(dateRange.split(":")[0]);
        Integer endYear = Integer.valueOf(dateRange.split(":")[1]);

        educationExpenditureVsHealthExpenditure analysis = new educationExpenditureVsHealthExpenditure(dataValues, startYear, endYear);


        return analysis;
    }

    private emissVsEnergyVsPollution getEmissVsEnergyVsPollution(countryObj country, String dateRange) {
        String[] analysisType = {"EN.ATM.CO2E.PC","EN.ATM.PM25.MC.M3","EG.USE.PCAP.KG.OE"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }


        emissVsEnergyVsPollution analysis = new emissVsEnergyVsPollution(dataValues);


        return analysis;
    }

    private pollutionVsForest getPollutionVsForest(countryObj country, String dateRange) {
        String[] analysisType = {"EN.ATM.PM25.MC.M3","AG.LND.FRST.ZS"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }


        pollutionVsForest analysis = new pollutionVsForest(dataValues);


        return analysis;
    }


    public Map<Integer, Double> getMap(countryObj country, String analysisType, String dateRange) {
        dataHandler dataHandler = new dataHandler();
        networkHandler network = new networkHandler();
        String test = network.fetchJSON(country, analysisType, dateRange);
        Map<Integer, Double> integerDoubleMap = dataHandler.parseJSON(test);


        return integerDoubleMap;
    }


}
