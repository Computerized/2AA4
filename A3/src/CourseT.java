package src;

import java.util.ArrayList;

public class CourseT implements Measures{
	public String name;
	public ArrayList<MapInd2LOsT> m = new ArrayList<MapInd2LOsT>();
	
	private class MapInd2LOsT{
		IndicatorT ind; ArrayList<LOsT> LOs;
		public MapInd2LOsT(IndicatorT ind, ArrayList<LOsT> LOs) {
			this.ind = ind; this.LOs = LOs;
		}
	}
	
	public CourseT(String courseName, IndicatorT[] indicators) {
		name = courseName;
		for (IndicatorT ind : indicators) {
			m.add(new MapInd2LOsT(ind, new ArrayList<LOsT>()));
		}
	}
	
	public String getName() {
		return name;
	}
	
	public IndicatorT[] getIndicators() {
		IndicatorT[] indT = new IndicatorT[m.size()];
		for (int i = 0; i < m.size(); i++) {
			indT[i] = m.get(i).ind;
		}
		return indT;
	}
	
	public LOsT[] getLOs(IndicatorT indicator) {
		LOsT [] out = null;
		ArrayList<LOsT> temp = new ArrayList<LOsT>();
		for (MapInd2LOsT h: m) {
			if (h.ind == indicator) {
				temp = h.LOs;
				out = new LOsT[temp.size()];
				for (int i = 0; i < out.length; i++) {
					out[i] = temp.get(i);
				}
				return out;
			}
		}
		
		return out;
	}
	
	public void addLO(IndicatorT indicator, LOsT outcome) {
		for (int i = 0; i < m.size(); i++) {
			if (m.get(i).ind == indicator) {
				m.get(i).LOs.add(outcome);
			}
		}
	}
	
	public void delLO(IndicatorT indicator, LOsT outcome) {
		for (int i = 0; i < m.size(); i++) {
			if (m.get(i).ind == indicator) {
				if (m.get(i).LOs.contains(outcome)) {
					m.get(i).LOs.remove(outcome);
				}
			}
		}
	}
	
	public boolean member(IndicatorT indicator, LOsT[] outcomes) {
		for (int i = 0; i < m.size(); i++) {
			if (m.get(i).ind == indicator) {
				for (LOsT lost : outcomes) {
					if (!m.get(i).LOs.contains(lost)){
						break;
					}
					return true;
				}
			}
		}
		return false;
	}
	
	public double[] measures(IndicatorT ind) {
		LOsT[] los = getLOs(ind);
		if (los.length == 1) {
			return (Norm.getNInd() ? Services.normal(los[0].measures()) : los[0].measures());
		} else if (los.length > 1) {
			double [] doubles = {0,0,0,0};
			for (LOsT l : los) {
				doubles = sumMeas(doubles,l.measures());
			}
			return (Norm.getNInd() ? Services.normal(doubles) : doubles);
		}
		return null;
	}
	
	public double[] measures(AttributeT att) {
		IndicatorT[] i = att.getIndicators();
		if (i.length == 1) {
			return measures(i[0]);
		} else if (i.length > 1) {
			double[] doubles = {0,0,0,0};
			for (IndicatorT ind : i) {
				doubles = sumMeas(doubles,measures(ind));
			}
			return (Norm.getNAtt() ? Services.normal(doubles) : doubles);
		}
		
		return null;
	}
	
	private double[] sumMeas(double[] a, double[] b) {
		double[] set = new double[4];
		set[0] = a[0] + b[0]; set[1] = a[1] + b[1]; set[2] = a[2] + b[2]; set[3] = a[3] + b[3]; 
		return set;
	}
}








