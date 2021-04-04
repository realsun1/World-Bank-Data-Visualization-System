package resultModel;

public class resultModel extends Subject {
	private Analysis currentAnalysis;
	
	
	resultModel(Analysis analysis){
		this.currentAnalysis = analysis;
	}


	public Analysis getCurrentAnalysis() {
		return currentAnalysis;
	}


}
