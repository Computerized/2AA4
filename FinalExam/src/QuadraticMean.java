package src;

import java.util.ArrayList;

public class QuadraticMean implements MeanCalculator{

	@Override
	public Double meanCalc(ArrayList<Double> v) {
		Double qsum = 0.0;
		for (Double i : v)
			qsum += Math.pow(i,2);
		return Math.sqrt(qsum/v.size());
	}
	
}
