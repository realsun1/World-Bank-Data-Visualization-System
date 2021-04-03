package resultModel;

import java.util.*;

public abstract class Subject {
	private List<resultObserver> observerList = new ArrayList<resultObserver>();
	
	
	public void attatch(resultObserver observer) { 
		observerList.add(observer);
	}
	
	public void detatch(resultObserver observer) { 
		observerList.remove(observer);
	}
	
	public void notifyObservers() {
		for (resultObserver observer: observerList) {
			observer.updateGraphs();
		}
	}
}
