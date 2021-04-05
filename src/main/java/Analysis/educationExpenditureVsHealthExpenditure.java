package Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class educationExpenditureVsHealthExpenditure implements Analysis {


    private ArrayList<Map<Integer, Double>> results = new ArrayList<Map<Integer, Double>>();
    private ArrayList<Map<Integer, Double>> dataValues = new ArrayList<Map<Integer, Double>>();
    private Integer start;
    private Integer end;
    private String[] legend = new String[]{"Government expenditure on education", "Current health expenditure"};
    private String[] labels = new String[]{"Education", "Health"};
    private String title = "Ratio of Government expenditure on education vs Current health expenditure";

    public educationExpenditureVsHealthExpenditure(ArrayList<Map<Integer, Double>> data, Integer start, Integer end) {
        this.dataValues = data;
        this.start = start;
        this.end = end;
        performComputation();
    }

    @Override
    public String[] getLegend() {
        return legend;
    }

    @Override
    public String[] getLabels() {
        return labels;
    }

    @Override
    public String getTitle() {
        return title;
    }


    @Override
    public void performComputation() {
        Map<Integer, Double> computationResults = new HashMap<Integer, Double>();

        for (int i = start; i < end; i++) {
            Double g = (dataValues.get(0)).get(i);
            Double e = (dataValues.get(1)).get(i);
            computationResults.put(i, (e / g));
        }

        results.add(computationResults);

    }


    public ArrayList<Map<Integer, Double>> getResults() {
        return results;
    }

}
