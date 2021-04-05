package resultModel;

import Analysis.Analysis;

public class resultModel extends Subject {
	private Analysis currentAnalysis;
	
	
	public resultModel(Analysis analysis){
		this.currentAnalysis = analysis;
	}


	public Analysis getCurrentAnalysis() {
		return currentAnalysis;
	}


}
