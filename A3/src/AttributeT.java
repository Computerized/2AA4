package src;
import java.util.ArrayList;

public class AttributeT{
	IndicatorT[] s;
	String name;
	
	public AttributeT(String attribName, IndicatorT[] indicators) {
		this.name = attribName;
		this.s = indicators;
	}
	
	public String getName() {
		return name;
	}
	
	public IndicatorT[] getIndicators(){
		return s;
	}
}