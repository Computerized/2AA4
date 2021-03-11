package src;

public abstract class Norm{
	static boolean normLOs, normInd, normAtt;
	
	public void setNorms(boolean nLOs, boolean nInd, boolean nAtt) {
		normLOs = nLOs;
		normInd = nInd;
		normAtt = nAtt;
	}
	
	public static boolean getNLOs() {
		return normLOs;
	}
	
	public boolean getNInd() {
		return normInd;
	}
	
	public boolean getNAtt() {
		return normAtt;
	}
	
	public void setNLOs(boolean nLOs) {
		normLOs = nLOs;
	}
	
	public void NInd(boolean nInd) {
		normInd = nInd;
	}
	
	public void setNAtt(boolean nAtt) {
		normAtt = nAtt;
	}
}