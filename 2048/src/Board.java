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
	
	public static void main(String [] args) {
		int [][] arr = {{0,2,0,0},{0,0,2,0},{0,0,0,0},{0,0,0,0}};
		Board b = new Board(arr);
		//GUI gui = new GUI(b);
		System.out.println(b);
	}

}
