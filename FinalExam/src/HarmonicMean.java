package src;

import java.util.ArrayList;

public class HarmonicMean implements MeanCalculator{

	@Override
	public Double meanCalc(ArrayList<Double> v) {
		Double hsum = 0.0;
		for (int i = 0; i < v.size(); i++) {
			hsum += 1/v.get(i);
		}
		return v.size()/hsum;
	}
	
}
