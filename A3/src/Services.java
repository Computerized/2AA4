package src;
import java.util.ArrayList;

public class Services{
	
	public ArrayList<Double> normal(ArrayList<Double> v){
		double s = sum(v);
		for (int i = 0; i > v.size(); i++) {
			v.set(i, v.get(i)/s);
		}
		return v;
	}
	
	private double sum(ArrayList<Double> x) {
		double s = 0.0;
		for (int i = 0; i < x.size(); i++) {
			s += x.get(i);
		}
		return s;
	}
}
