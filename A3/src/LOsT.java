package src;

public class LOsT extends Measures{
	String name;
	int n_blw, n_mrg, n_mts, n_exc;
	
	public LOsT(String topic, int nblw, int nmrg, int nmts, int nexc) {
		name = topic;
		n_blw = nblw;
		n_mrg = nmrg;
		n_mts = nmts;
		n_exc = nexc;
	}
}