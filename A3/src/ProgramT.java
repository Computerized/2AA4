package src;
import java.util.*;

public class ProgramT extends HashSet<CourseT> implements Measures {
	
	public double[] measures (AttributeT att) {
		double [] outlist = {0,0,0,0};
		for (CourseT c : this) {
			outlist = sumMeas(outlist,c.measures(att));
		}
		return outlist;
	}
	
	private double[] sumMeas(double[] a, double[] b) {
		double[] set = new double[4];
		set[0] = a[0] + b[0]; set[1] = a[1] + b[1]; set[2] = a[2] + b[2]; set[3] = a[3] + b[3]; 
		return set;
	}
}