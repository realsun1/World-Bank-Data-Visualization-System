package Handlers;

import Analysis.RatioEmissionsGDP;

public class mainclass {

    public static void main(String[] args) {
        analysisFacade test = new analysisFacade("cn","1980:1999");
        RatioEmissionsGDP ratio = new RatioEmissionsGDP(test.currentCountry.getCarbonDioxideEmissions(),test.currentCountry.getGdpPerCapita(),1980,1999);
        ratio.getResults();
    }
}
