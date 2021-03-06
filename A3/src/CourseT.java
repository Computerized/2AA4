package src;

import java.util.ArrayList;

/**
 * @file CourseT.java
 * @author Alan Scott, scotta30, 400263658
 * @brief Data type representing individual courses
 * @details This class represents a course with a given set of indicators, each with its own
 * 			set of learning objectives. This class contains getters and setters for the name of 
 * 			the course, LOs, and has a method for determining membership of a configuration of
 * 			indicators and LOs. It also has a method to determine the combined values of given
 * 			LOs. 
 * @param courseName String name of the course
 * @param indicators Set of IndicatorTs representing learning indicators of the course
 */

public class CourseT implements Measures{
	public String name;
	public ArrayList<MapInd2LOsT> m = new ArrayList<MapInd2LOsT>();
	
	/**
	 * @brief Data type representing a tuple of an indicator and a corresponding set of learning objectives
	 * @param ind IndicatorT represents the learning indicator
	 * @param LOs set of learning goals corresponding to the given indicator
	 */
	private class MapInd2LOsT{
		public IndicatorT ind; public ArrayList<LOsT> LOs;
		public MapInd2LOsT(IndicatorT ind, ArrayList<LOsT> LOs) {
			this.ind = ind; this.LOs = LOs;
		}
	}
	
	/**
	 * @brief Constructor for CourseT. Copies indicators into blank MapInd2LOsT
	 * @param courseName String name of the course
	 * @param indicators set of indicators
	 */
	public CourseT(String courseName, IndicatorT[] indicators) {
		name = courseName;
		for (IndicatorT ind : indicators) {
			m.add(new MapInd2LOsT(ind, new ArrayList<LOsT>()));
		}
	}
	
	/**
	 * @brief name return method
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @brief indicators get method
	 * @return set of indicators from MapInd2LOst
	 */
	public IndicatorT[] getIndicators() {
		IndicatorT[] indT = new IndicatorT[m.size()];
		for (int i = 0; i < m.size(); i++) {
			indT[i] = m.get(i).ind;
		}
		return indT;
	}
	
	/**
	 * @param indicator IndicatorT corresponding to a set of learning objectives
	 * @return set of all learning objectives
	 */
	public LOsT[] getLOs(IndicatorT indicator) {
		LOsT [] out = new LOsT[0];
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
	
	/**
	 * @brief Method to add a learning outcome to an indicator
	 * @param indicator IndicatorT corresponding with the outcome
	 * @param outcome corresponding outcome
	 */
	public void addLO(IndicatorT indicator, LOsT outcome) {
		for (int i = 0; i < m.size(); i++) {
			if (m.get(i).ind == indicator) {
				m.get(i).LOs.add(outcome);
			}
		}
	}
	
	/**
	 * @brief Method to delete a learning outcome to an indicator
	 * @param indicator IndicatorT corresponding with the outcome
	 * @param outcome corresponding outcome
	 */
	public void delLO(IndicatorT indicator, LOsT outcome) {
		for (int i = 0; i < m.size(); i++) {
			if (m.get(i).ind == indicator) {
				if (m.get(i).LOs.contains(outcome)) {
					m.get(i).LOs.remove(outcome);
				}
			}
		}
	}
	
	/**
	 * @brief Method for determining a corresponding indicator-LOsTs membership in the set
	 * @param indicator IndicatorT corresponding to a set of outcomes
	 * @param outcomes set of learning objects corresponding to the indicator
	 * @return true if combination exists within the course, false otherwise
	 */
	public boolean member(IndicatorT indicator, LOsT[] outcomes) {
		ArrayList<LOsT> temp = null;
		for (MapInd2LOsT mi : m) {
			if (mi.ind == indicator) {
				temp = mi.LOs;
				break;
			}
		}
		if (!(temp != null && outcomes.length == temp.size()))
			return false;
		
		for (LOsT out : outcomes)
			if (!temp.contains(out))
				return false;
		return true;
	}
	
	@Override
	/**
	 * @brief Method to determine the measure of a given indicator
	 * @param ind IndicatorT that corresponds to the measured learning objectives
	 * @return Tuple of 4 doubles corresponding to the sum of the 4 measures of the learning goals
	 */
	public double[] measures(IndicatorT ind) {
		LOsT[] los = getLOs(ind);
		if (los == null) {
			double [] out = {0,0,0,0};
			return out;
		}
		if (los.length == 1) {
			return (Norm.getNInd() ? Services.normal(los[0].measures()) : los[0].measures());
		} else if (los.length > 1) {
			double [] doubles = {0,0,0,0};
			for (LOsT l : los) {
				doubles = sumMeas(doubles,l.measures());
			}
			return (Norm.getNInd() ? Services.normal(doubles) : doubles);
		}
		double [] out = {0,0,0,0};
		return out;
	}
	
	@Override
	/**
	 * @brief Method to determine the measure of a given attribute
	 * @param att AttributeT that corresponds to a set of IndicatorTs
	 * @return Tuple of 4 doubles corresponding to the sum of the 4 measures of the learning goals
	 */
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
		double [] out = {0,0,0,0};
		return out;
	}
	
	/**
	 * @brief Method to sum corresponding elements over 2 arrays
	 * @param a first array
	 * @param b second array
	 * @return Sum of both arrays
	 */
	private double[] sumMeas(double[] a, double[] b) {
		double[] set = new double[4];
		set[0] = a[0] + b[0]; set[1] = a[1] + b[1]; set[2] = a[2] + b[2]; set[3] = a[3] + b[3]; 
		return set;
	}
}









