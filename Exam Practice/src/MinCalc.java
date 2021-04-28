import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class MinCalc implements TieHandler{

	@Override
	public double rCalc(ArrayList<Integer> s) {
		return Collections.min(s);
	}
	
}

