
public class Board {
	private int[][] grid = new int[4][4];
	
	public Board(int[][] arr) {
		grid = arr;
	}
	
	public int[][] getArray(){
		return grid;
	}
	
	public boolean hasLegalMoves() {
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 4; column ++) {
				if (grid[row][column] == 0)
					return true;
				else if (row >= 1 && grid[row][column] == grid[row-1][column])
					return true;
				else if (row <= 3 && grid[row][column] == grid[row+1][column])
					return true;
				else if (column >= 1 && grid[row][column] == grid[row][column-1])
					return true;
				else if (column <= 3 && grid[row][column] == grid[row][column+1])
					return true;
			}
		}
		return false;
	}
	
	public static void main(String [] args) {
		int [][] arr = {{0,2,0,0},{0,0,2,0},{0,0,0,0},{0,2,0,0}};
		Board b = new Board(arr);
		System.out.println(b.hasLegalMoves());
		GUI gui = new GUI(b);
	}

}
