package resultModel;

import Analysis.Analysis;

public class resultModel extends Subject {
	private Analysis currentAnalysis = null;
	private Analysis previousAnalysis;
	
	public resultModel(){
		
	}
	
	public Analysis getCurrentAnalysis() {
		return currentAnalysis;
	}
	
	public boolean checkSame() {
		if (previousAnalysis != null && currentAnalysis.getClass().equals(previousAnalysis.getClass())) {
			return true;
		}
		return false;
	}


	public void setCurrentAnalysis(Analysis currentAnalysis) {
		this.previousAnalysis = this.currentAnalysis;
		this.currentAnalysis = currentAnalysis;
		
		if (previousAnalysis != null && currentAnalysis.getClass().equals(previousAnalysis.getClass())) {
			this.notifyUpdateGraph();
		} else {
			this.notifyCreateGraph();
		}
	}



}
