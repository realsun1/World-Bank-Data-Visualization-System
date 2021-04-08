/**
* This class is the analysis facade that includes all the different analysis types 
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/

package Handlers;

import java.util.ArrayList;
import java.util.Map;

import Analysis.*;
import dataModels.countryObj;
import dataModels.resultModel;

public class analysisFacade {

	/*
	 * this method gets the data for each analysis type
	 * @param country This is the first parameter in the method
	 * @param analysisType This is the second parameter in the method
	 * @param dataRangen This is the third parameter in the method
	 * @param currentModel This is the fourth parameter in the method
	 */
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

    /*
     * this method gets the analysis for EmissionGDP
     * @param country this is the country object 
     * @param dataRange this is the range of data
     * @return analysis
     */
    private RatioEmissionsGDP getEmissionGDP(countryObj country, String dateRange) {
        String[] analysisType = {"EN.ATM.CO2E.PC","NY.GDP.PCAP.CD"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }

  

        RatioEmissionsGDP analysis = new RatioEmissionsGDP(dataValues);


        return analysis;
    }

    /*
     * this method gets the analysis for ForestAverage
     * @param country this is the country object 
     * @param dataRange this is the range of data
     * @return analysis
     */
    private forestAverage getForestAverage(countryObj country, String dateRange) {
        String[] analysisType = {"AG.LND.FRST.ZS"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }



        forestAverage analysis = new forestAverage(dataValues);


        return analysis;
    }

    /*
     * this method gets the analysis for EducationAverage
     * @param country this is the country object 
     * @param dataRange this is the range of data
     * @return analysis
     */
    private educationAverage getEducationAverage(countryObj country, String dateRange) {
        String[] analysisType = {"SE.XPD.TOTL.GD.ZS"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }



        educationAverage analysis = new educationAverage(dataValues);


        return analysis;
    }

    /*
     * this method gets the analysis BedVsExpenditure
     * @param country this is the country object 
     * @param dataRange this is the range of data
     * @return analysis
     */
    private bedVsExpenditure getBedVsExpenditure(countryObj country, String dateRange) {
        String[] analysisType = {"SH.MED.BEDS.ZS", "SH.XPD.CHEX.PC.CD"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }



        bedVsExpenditure analysis = new bedVsExpenditure(dataValues);


        return analysis;
    }

    /*
     * this method gets the analysis ExpenditureVsMortality
     * @param country this is the country object 
     * @param dataRange this is the range of data
     * @return analysis
     */
    private expenditureVsMortality getExpenditureVsMortality(countryObj country, String dateRange) {
        String[] analysisType = {"SH.XPD.CHEX.PC.CD","SP.DYN.IMRT.IN"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }


        expenditureVsMortality analysis = new expenditureVsMortality(dataValues);


        return analysis;
    }

    /*
     * this method gets the analysis EducationExpenditureVsHealthExpenditure
     * @param country this is the country object 
     * @param dataRange this is the range of data
     * @return analysis
     */
    private educationExpenditureVsHealthExpenditure getEducationExpenditureVsHealthExpenditure(countryObj country, String dateRange) {
        String[] analysisType = {"SE.XPD.TOTL.GD.ZS","SH.XPD.CHEX.GD.ZS"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }


        educationExpenditureVsHealthExpenditure analysis = new educationExpenditureVsHealthExpenditure(dataValues);


        return analysis;
    }

    /*
     * this method gets the analysis EmissVsEnergyVsPollution
     * @param country this is the country object 
     * @param dataRange this is the range of data
     * @return analysis
     */
    private emissVsEnergyVsPollution getEmissVsEnergyVsPollution(countryObj country, String dateRange) {
        String[] analysisType = {"EN.ATM.CO2E.PC","EN.ATM.PM25.MC.M3","EG.USE.PCAP.KG.OE"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }


        emissVsEnergyVsPollution analysis = new emissVsEnergyVsPollution(dataValues);


        return analysis;
    }
    
    /*
     * this method gets the analysis PollutionVsForest
     * @param country this is the country object 
     * @param dataRange this is the range of data
     * @return analysis
     */
    private pollutionVsForest getPollutionVsForest(countryObj country, String dateRange) {
        String[] analysisType = {"EN.ATM.PM25.MC.M3","AG.LND.FRST.ZS"};
        ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
        for (String analysis : analysisType) {
            dataValues.add(getMap(country, analysis, dateRange));
        }


        pollutionVsForest analysis = new pollutionVsForest(dataValues);


        return analysis;
    }

    /*
     * this method gets the map
     * @param country this is the country object 
     * @param dataRange this is the range of data
     * @param analysisType this is the analysis type
     * @return integerDoubleMap the map
     */
    private Map<Integer, Double> getMap(countryObj country, String analysisType, String dateRange) {
        dataHandler dataHandler = new dataHandler();
        networkHandler network = new networkHandler();
        String test = network.fetchJSON(country, analysisType, dateRange);
        Map<Integer, Double> integerDoubleMap = dataHandler.parseJSON(test);


        return integerDoubleMap;
    }


}
