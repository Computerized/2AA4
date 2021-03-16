package src;

public interface Measures{
	
	public default double [] measures() {
		throw new UnsupportedOperationException("Method not supported in this module");
	}
	
	public default double[] measures(IndicatorT ind) {
		throw new UnsupportedOperationException("Method not supported in this module");
	}
	
	public default double[] measures(AttributeT att) {
		throw new UnsupportedOperationException("Method not supported in this module");
	}
}