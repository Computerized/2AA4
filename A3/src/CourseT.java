package src;

public class CourseT implements Measures{
	String name;
	MapInd2LOsT[] m;
	
	private class MapInd2LOsT{
		IndicatorT ind; LOsT[] LOs;
		public MapInd2LOsT(IndicatorT ind, LOsT[] LOs) {
			this.ind = ind; this.LOs = LOs;
		}
	}
	
	public CourseT(String courseName, IndicatorT[] indicators) {
		name = courseName;
		MapInd2LOsT[] arr = new MapInd2LOsT[indicators.length];
		for (int i = 0; i < indicators.length; i++) {
			arr[i] = new MapInd2LOsT(indicators[i], null);
		}
	}
	
	public String getName() {
		return name;
	}
}