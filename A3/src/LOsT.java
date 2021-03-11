package src;

import java.util.ArrayList;

public class LOsT extends Measures{
	String name;
	int n_blw, n_mrg, n_mts, n_exc;
	
	public LOsT(String topic, int nblw, int nmrg, int nmts, int nexc) {
		if ((nblw < 0) || (nmrg < 0) || (nmts < 0) || (nexc < 0)) {
			throw new IllegalArgumentException();
		}
		name = topic;
		n_blw = nblw;
		n_mrg = nmrg;
		n_mts = nmts;
		n_exc = nexc;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean equals (LOsT o) {
		return (name.equals(o.getName()));
	}
	
	@Override
	public ArrayList<Double> measures(){
		if (Norm.getNLOs()) {
			
		}
	}
}