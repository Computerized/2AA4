package src;

import java.util.ArrayList;

public class LOsT implements Measures{
	String name;
	int n_blw, n_mrg, n_mts, n_exc;
	
	public LOsT(String topic, int nblw, int nmrg, int nmts, int nexc) {
		if ((nblw < 0) || (nmrg < 0) || (nmts < 0) || (nexc < 0)) {
			throw new IllegalArgumentException("All values must be above 0");
		} else if (nmrg == 0 && nblw == 0 && nmts == 0 && nexc == 0) {
			throw new IllegalArgumentException("At least one value must be nonzero");
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
	public double [] measures(){
		double [] list = {n_blw,n_mrg,n_mts,n_exc};
		if (!Norm.getNLOs()) {
			return list;
		}
		return Services.normal(list);
	}
}