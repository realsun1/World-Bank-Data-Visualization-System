package Analysis;

import java.util.ArrayList;
import java.util.Map;

public interface Analysis {

	
	public void performComputation();


	public ArrayList<Map<Integer, Double>> getResults();

	public String[] getLegend();

	public String getTitle();

	public String[]getLabels();


}


