package src;

public class Services{
	
	public static double[] normal(double[] v){
		double s = sum(v);
		double [] out = new double[v.length];
		for (int i = 0; i < v.length; i++) {
			out[i] = v[i]/s;
		}
		return out;
	}
	
	private static double sum(double [] x) {
		double s = 0.0;
		for (double item : x) {
			s += item;
		}
		return s;
	}
}
