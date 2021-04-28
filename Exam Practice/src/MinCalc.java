import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class MinCalc implements TieHandler{

	@Override
	public double rCalc(int[] s) {
		if (s.length == 0)
			return 0;
		int min = s[0];
		for (int i = 1; i < s.length; i++)
			if (s[i] < min)
				min = s[i];
		return min;
	}
	
}

