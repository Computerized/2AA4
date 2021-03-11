package src;
import java.util.ArrayList;

public class AttributeT{
	ArrayList<IndicatorT> s = new ArrayList<IndicatorT>();
	String name;
	
	public AttributeT(String attribName, ArrayList<IndicatorT> indicators) {
		this.name = attribName;
		this.s = indicators;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<IndicatorT> getIndicators(){
		return s;
	}
}