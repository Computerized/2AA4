import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class Seq1D<T extends Comparable<T>>{
	private ArrayList<T> s = new ArrayList<T>();
	TieHandler tieHandler;
	
	Seq1D(ArrayList<T> S, TieHandler t){
		s = S; tieHandler = t;
	}
	
	void setTieHandler(TieHandler t) {
		tieHandler = t;
	}
	
	double rank (T p) {
		if (!s.contains(p))
			throw new IllegalArgumentException();
		Collections.sort(s);
		return tieHandler.rCalc(indexSet(p,s));
	}
	
	ArrayList<Integer> indexSet(T t, ArrayList<T> B){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int k = 0; k < B.size(); k++)
			if (t.equals(B.get(k)))
				temp.add(k);
		return temp;
	}
}