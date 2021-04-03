package Handlers;

import java.util.Map;

public class countryObject {
    private int[] yearsvalid= new int[]{0,0};
    Map<Integer, Double> totalPop;
    Map<Integer, Double> carbonDioxideEmissions;
    Map<Integer, Double> airPollution;
    Map<Integer, Double> forestArea;
    Map<Integer, Double> energyUse;
    Map<Integer, Double> gdpPerCapita;
    Map<Integer, Double> hospitalBeds;
    Map<Integer, Double> governmentExpenditure;
    Map<Integer, Double> maternalRatio;
    Map<Integer, Double> healthExpenditurePercentage;
    Map<Integer, Double> healthExpenditureCapita;
    Map<Integer, Double> infantRatio;



    public countryObject(){

    }

    public void setTotalPop(Map<Integer, Double> totalPop) {
        this.totalPop = totalPop;
    }

    public void setCarbonDioxideEmissions(Map<Integer, Double> carbonDioxideEmissions) {
        this.carbonDioxideEmissions = carbonDioxideEmissions;
    }

    public void setAirPollution(Map<Integer, Double> airPollution) {
        this.airPollution = airPollution;
    }

    public void setForestArea(Map<Integer, Double> forestArea) {
        this.forestArea = forestArea;
    }

    public void setEnergyUse(Map<Integer, Double> energyUse) {
        this.energyUse = energyUse;
    }

    public void setGdpPerCapita(Map<Integer, Double> gdpPerCapita) {
        this.gdpPerCapita = gdpPerCapita;
    }

    public void setHospitalBeds(Map<Integer, Double> hospitalBeds) {
        this.hospitalBeds = hospitalBeds;
    }

    public void setGovernmentExpenditure(Map<Integer, Double> governmentExpenditure) {
        this.governmentExpenditure = governmentExpenditure;
    }

    public void setMaternalRatio(Map<Integer, Double> maternalRatio) {
        this.maternalRatio = maternalRatio;
    }

    public void setHealthExpenditurePercentage(Map<Integer, Double> healthExpenditurePercentage) {
        this.healthExpenditurePercentage = healthExpenditurePercentage;
    }

    public void setHealthExpenditureCapita(Map<Integer, Double> healthExpenditureCapita) {
        this.healthExpenditureCapita = healthExpenditureCapita;
    }

    public void setInfantRatio(Map<Integer, Double> infantRatio) {
        this.infantRatio = infantRatio;
    }

    public Map<Integer, Double> getTotalPop() {
        return totalPop;
    }

    public Map<Integer, Double> getCarbonDioxideEmissions() {
        return carbonDioxideEmissions;
    }

    public Map<Integer, Double> getAirPollution() {
        return airPollution;
    }

    public Map<Integer, Double> getForestArea() {
        return forestArea;
    }

    public Map<Integer, Double> getEnergyUse() {
        return energyUse;
    }

    public Map<Integer, Double> getGdpPerCapita() {
        return gdpPerCapita;
    }

    public Map<Integer, Double> getHospitalBeds() {
        return hospitalBeds;
    }

    public Map<Integer, Double> getGovernmentExpenditure() {
        return governmentExpenditure;
    }

    public Map<Integer, Double> getMaternalRatio() {
        return maternalRatio;
    }

    public Map<Integer, Double> getHealthExpenditurePercentage() {
        return healthExpenditurePercentage;
    }

    public Map<Integer, Double> getHealthExpenditureCapita() {
        return healthExpenditureCapita;
    }

    public Map<Integer, Double> getInfantRatio() {
        return infantRatio;
    }
}
