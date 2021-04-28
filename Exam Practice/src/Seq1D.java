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
	
	double rank (ArrayList<T> p) {
		
	}
}