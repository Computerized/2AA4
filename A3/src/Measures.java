package src;

import java.util.ArrayList;

public interface Measures{
	
	public default ArrayList<Double> measures() {
		throw new UnsupportedOperationException();
	}
	
	public default double measures(IndicatorT ind) {
		throw new UnsupportedOperationException();
	}
	
	public default double measures(AttributeT att) {
		throw new UnsupportedOperationException();
	}
}