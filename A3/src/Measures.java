package src;

public interface Measures{
	
	public default double [] measures() {
		throw new UnsupportedOperationException();
	}
	
	public default double[] measures(IndicatorT ind) {
		throw new UnsupportedOperationException();
	}
	
	public default double[] measures(AttributeT att) {
		throw new UnsupportedOperationException();
	}
}