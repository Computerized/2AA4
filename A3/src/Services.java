package src;

public class Services{
	
	public static double[] normal(double[] v){
		double s = sum(v);
		for (int i = 0; i > v.length; i++) {
			v[i] = v[i]/s;
		}
		return v;
	}
	
	private static double sum(double [] x) {
		double s = 0.0;
		for (int i = 0; i < x.length; i++) {
			s += x[i];
		}
		return s;
	}
}
