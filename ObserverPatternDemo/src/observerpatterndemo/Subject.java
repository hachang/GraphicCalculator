package observerpatterndemo;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private List<Observer> obs = new ArrayList<Observer>();
	private int state;
	
	public int getState() {
		return state;
	}
	
	public void setState(int state){
		this.state = state;
		notifyAllObservers();
	}
	
	public void attach(Observer observer){
		obs.add(observer);
	}
	
	public void notifyAllObservers() {
		for(Observer observer : obs){
			observer.update();
		}
	}
}
