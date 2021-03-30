/**
 * @author Alan Scott, scotta30, 400263658
 * @file Board.java
 * @brief 4x4 Board abstract object
 * @details Thos class represents a board comprised of a 4x4 grid, with numbers in each spot.
 * @param arr 4x4 array representing positions on the board.
 *
 */
public class Board {
	
	protected int[][] grid = new int[4][4];
	protected int score;
	
	public Board(int[][] arr) {
		grid = arr;
	}
	
	public int[][] getArray(){
		return grid;
	}
	
	public void setArray(int[][] arr) {
		grid = arr;
	}
	
	public int getScore() {
		return score;
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
