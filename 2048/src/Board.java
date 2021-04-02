/**
 * @author Alan Scott, scotta30, 400263658
 * @file Board.java
 * @brief 4x4 Board abstract object
 * @details This class represents a board comprised of a 4x4 grid, with numbers in each spot.
 * @param arr 4x4 array representing positions on the board.
 *
 */
public class Board {
	
	protected int[][] grid = new int[4][4];
	protected int score;
	
	public Board(int[][] arr) {
		grid = arr;
	}
	
	/**
	 * @brief grid return method
	 * @return 2D array grid
	 */
	public int[][] getArray(){
		return grid;
	}
	
	/**
	 * @brief grid mutator method
	 * @param arr array to be changed to
	 */
	public void setArray(int[][] arr) {
		grid = arr;
	}
	
	/**
	 * @brief score return method
	 * @return int score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * this method is for quick visual display, not necessary for operation. It is not listed in
	 * the specification for this reason, as it is just for testing and marking.
	 */
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
	
	/**
	 * @brief Zero existence method
	 * @details This method finds if a zero exists within the 2D array
	 * @return True if grid contains a zero element, false otherwise
	 */
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
