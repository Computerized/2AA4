package src;

import java.util.ArrayList;

public class CourseT implements Measures{
	String name;
	MapInd2LOsT[] m;
	
	private class MapInd2LOsT{
		IndicatorT ind; ArrayList<LOsT> LOs;
		public MapInd2LOsT(IndicatorT ind, ArrayList<LOsT> LOs) {
			this.ind = ind; this.LOs = LOs;
		}
	}
	
	public CourseT(String courseName, IndicatorT[] indicators) {
		name = courseName;
		MapInd2LOsT[] arr = new MapInd2LOsT[indicators.length];
		for (int i = 0; i < indicators.length; i++) {
			arr[i] = new MapInd2LOsT(indicators[i], new ArrayList<LOsT>());
		}
	}
	
	public String getName() {
		return name;
	}
	
	public IndicatorT[] getIndicators() {
		IndicatorT[] indT = new IndicatorT[m.length];
		for (int i = 0; i < m.length; i++) {
			indT[i] = m[i].ind;
		}
		return indT;
	}
	
	public LOsT[] getLOs(IndicatorT indicator) {
		
		return null;
	}
	
	public void addLO(IndicatorT indicator, LOsT outcome) {
		for (int i = 0; i < m.length; i++) {
			if (m[i].ind == indicator) {
				m[i].LOs.add(outcome);
			}
		}
	}
	
	public void delLO(IndicatorT indicator, LOsT outcome) {
		for (int i = 0; i < m.length; i++) {
			if (m[i].ind == indicator) {
				if (m[i].LOs.contains(outcome)) {
					m[i].LOs.remove(outcome);
				}
			}
		}
	}
	
	public boolean member(IndicatorT indicator, LOsT[] outcomes) {
		for (int i = 0; i < m.length; i ++) {
			if (m[i].ind == indicator) {
				for (int j = 0; j < outcomes.length; i++) {
					if (!m[i].LOs.contains(outcomes[j])) {
						break;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	public double[] measures(IndicatorT indicator) {
		if (Norm.getNInd()) {
			
			
		}
	}
	
	private double[] sumMeas(double[] a, double[] b) {
		double[] set = new double[4];
		set[0] = a[0] + b[0]; set[1] = a[1] + b[1]; set[2] = a[2] + b[2]; set[3] = a[3] + b[3]; 
		return set;
	}
}









