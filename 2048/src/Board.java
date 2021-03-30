public class Board {
	protected int[][] grid = new int[4][4];
	
	public Board(int[][] arr) {
		grid = arr;
	}
	
	public int[][] getArray(){
		return grid;
	}
	
	public void setArray(int[][] arr) {
		grid = arr;
	}
	
	public String toString() {
		String s = "";
		for (int[] i : grid) {
			for (int j : i) {
				String number = j + "";
				s += number;
				for (int k = 0; k < 5-number.length(); k++)
					s += " ";
			}
			s += "\n";
		}
		return s;
	}
	
	public boolean hasZero() {
		for (int[] i : grid) {
			for (int j : i) {
				if (j == 0)
					return true;
			}
		}
		return false;
	}
}
