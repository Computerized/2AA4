package src;

import java.util.ArrayList;

public class Seq1D{
	ArrayList<Double> s;
	MeanCalculator meanCalculator;
	
	public Seq1D(ArrayList<Double> x, MeanCalculator m) {
		if (x.size() == 0)
			throw new IllegalArgumentException();
		s = x; meanCalculator = m;
	}
	
	public void setMeanCalculator(MeanCalculator m) {
		meanCalculator = m;
	}
	
	public Double mean() {
		return meanCalculator.meanCalc(s);
	}
}
