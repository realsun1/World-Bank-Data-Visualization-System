package Handlers;

import java.util.ArrayList;
import java.util.Map;

import Analysis.*;
import resultModel.resultModel;

public class analysisFacade {


    public void getData(countryObj country, String analysisType, String dateRange, resultModel currentModel) {
    

    	 switch (analysisType) {

            case "EEP":
            	emissVsEnergyVsPollution emissVsEnergyVsPollutionAnalysis = this.getEmissVsEnergyVsPollution(country, dateRange);
            	currentModel.setCurrentAnalysis(emissVsEnergyVsPollutionAnalysis);
            	break;
            case "PVF":
            	pollutionVsForest pollutionVsForestAnalysis = this.getPollutionVsForest(country, dateRange);
            	currentModel.setCurrentAnalysis(pollutionVsForestAnalysis);
            	break;
            case "GEG":
            	RatioEmissionsGDP emissionGDPAnalysis = this.getEmissionGDP(country, dateRange);
            	currentModel.setCurrentAnalysis(emissionGDPAnalysis);
            	break;
            case "GFA":
            	forestAverage forestAnalysis = this.getForestAverage(country, dateRange);
            	currentModel.setCurrentAnalysis(forestAnalysis);
            	break;
            case "EAV":
            	educationAverage educationAnalysis = this.getEducationAverage(country, dateRange);
            	currentModel.setCurrentAnalysis(educationAnalysis);
            	break;
            case "BVE":
            	bedVsExpenditure bedVsExpenditureAnalysis = this.getBedVsExpenditure(country, dateRange);
            	currentModel.setCurrentAnalysis(bedVsExpenditureAnalysis);
            	break;
            case "EVM":
            	expenditureVsMortality expenditureVsMortalityAnalysis = this.getExpenditureVsMortality(country, dateRange);
            	currentModel.setCurrentAnalysis(expenditureVsMortalityAnalysis);
            	break;
            case "EVH":
            	educationExpenditureVsHealthExpenditure educationVsHealthAnalysis = this.getEducationExpenditureVsHealthExpenditure(country, dateRange);
            	currentModel.setCurrentAnalysis(educationVsHealthAnalysis);
            	break;

        }



        
       
    }


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


    private Map<Integer, Double> getMap(countryObj country, String analysisType, String dateRange) {
        dataHandler dataHandler = new dataHandler();
        networkHandler network = new networkHandler();
        String test = network.fetchJSON(country, analysisType, dateRange);
        Map<Integer, Double> integerDoubleMap = dataHandler.parseJSON(test);


        return integerDoubleMap;
    }


}
