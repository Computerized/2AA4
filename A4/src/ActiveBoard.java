import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @file ActiveBoard.java
 * @author Alan Scott, scotta30, 400263658
 * @brief Board operations class
 * @details This class is a child class of Board. It specializes the Board class to
 * 			work for 2048, and contains operations specific to the game.
 * @param arr 2D array representing the 4x4 board
 *
 */
public class ActiveBoard extends Board{

	public ActiveBoard(int[][] arr) {
		super(arr);
		score = 0;
	}
	
	/**
	 * @brief Legal move detection method
	 * @details This method checks for legal moves. A legal move exists if there exists a zero
	 * 			within grid, or if grid contains two identical adjacent elements.
	 * @return True if at least one legal moves exists, false otherwise
	 */
	public boolean hasLegalMoves() {
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 4; column ++) {
				if (grid[row][column] == 0) //if zero exists, it can be shifted into
					return true;
				else if (row >= 1 && grid[row][column] == grid[row-1][column])
					return true;
				else if (row <= 2 && grid[row][column] == grid[row+1][column])
					return true;
				else if (column >= 1 && grid[row][column] == grid[row][column-1])
					return true;
				else if (column <= 2 && grid[row][column] == grid[row][column+1])
					return true;
			}
		}
		return false;
	}
	
	/**
	 * @brief Random two adding method
	 * @details This method adds a random two (or an occasional four) into a random blank
	 * 			spot on the grid. 
	 */
	public void addRandomTwo() {
		Random rand = new Random();
		ArrayList<int[]> coords = new ArrayList<int[]>();
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 4; j ++) {
				if (grid[i][j] == 0) {
					int[] a = {i,j};
					coords.add(a);
				}
			}
		}
		if (coords.size() == 0)
			return;
		int [] coord = coords.get(rand.nextInt(coords.size())); //pick random empty space
		grid[coord[0]][coord[1]] = (rand.nextDouble() < 0.9 || coords.size() > 14) ? 2 : 4; //10 % chance of getting a four
		//first 2 random values are guaranteed to be 2s.
	}
	
	/**
	 * @brief Left board shift method
	 * @details This method shift all elements in the grid to the left. If equal numbers shift into one
	 * 			another, the two are combined, with priority given to the left direction. This is done 
	 * 			by summing the two elements in the left elements place and making the right element to 0.
	 * 			Once all the combinations are calculated, all elements in the grid are shifted left, with
	 * 			no further merges being performed. 
	 */
	public void shiftLeft() {
		for (int[] row : grid) {
			int[] blankRow = {0,0,0,0};
			if (Arrays.equals(blankRow, row))
				continue;
			if (row[0] == row[1] && row[0] != 0) {
				row[0] = row[0] + row[1];
				score += row[0];
				row[1] = 0;
				if (row[2] == row[3] && row[2] != 0) {
					row[2] = row[2] + row[3];
					score += row[2];
					row[3] = 0;
				}
			} else if (row[1] == row[2] && row[1] != 0) {
				row[2] = row[1] + row[2];
				score += row[2];
				row[1] = 0;
			} else if (row[0] == row[2] && row[0]!=0 && row[1] == 0) {
				row[0] = row[0] + row[2];
				score += row[0];
				row[2] = 0;
			} else if (row[0] == row[3] && row[1] == row[2] && row[2] == 0 && row[0] != 0) {	
				row[0] = row[3] + row[0];
				score += row[0];
				row[3] = 0;
			} else if (row[1] == row[3] && row[1] != 0 && row[2] == 0) {
				row[1] = row[1] + row[3];
				score += row[1];
				row[3] = 0;
			} else if (row[2] == row[3] && row[2] != 0) {
				row[2] = row[2] + row[3];
				score += row[2];
				row[3] = 0;
			}
			
			for (int k = 0; k < 2; k ++) {
				for (int i = 0; i < 4; i ++) {
					if (row[i] == 0) {
						for (int j = i; j < 3; j ++) {
							row[j] = row[j+1];
						}
						row[3] = 0;
					}
				}
			}
		}
	}
	
	/**
	 * @brief Right board shift method
	 * @details This method shift all elements in the grid to the right. If equal numbers shift into one
	 * 			another, the two are combined, with priority given to the right direction. This is done 
	 * 			by summing the two elements in the right element's place and making the left element to 0.
	 * 			Once all the combinations are calculated, all elements in the grid are shifted right, with
	 * 			no further merges being performed. 
	 */
	public void shiftRight() {
		for (int[] row : grid) {
			int[] blankRow = {0,0,0,0};
			if (Arrays.equals(blankRow, row))
				continue;
			if (row[3] == row[2] && row[2] != 0) {
				row [3] = row[2] + row[3];
				score += row[3];
				row[2] = 0;
				if (row[1] == row[0] && row[1] != 0) {
					row[1] = row[0] + row[1];
					score += row[1];
					row[0] = 0;
				}
			} else if (row[1] == row[2] && row[1] != 0) {
					row[2] = row[1] + row[2];
					score += row[2];
					row[1] = 0;
			} else if (row[3] == row[1] && row[2] == 0 && row[3] != 0) {
				row[3] = row[3] + row[1];
				score += row[3];
				row[1] = 0;
			} else if (row[0] == row[3] && row[1] == row[2] && row[2] == 0 && row[0] != 0) {	
					row[3] = row[3] + row[0];
					score += row[3];
					row[0] = 0;
			} else if (row[2] == row[0] && row[1] == 0 && row[2] != 0) {
				row[2] = row[2] + row[0];
				score += row[2];
				row[0] = 0;
			} else if (row[1] == row[0] && row[0] != 0) {
				row[1] = row[0];
				score += row[1];
				row[0] = 0;
			} 
			
			for (int k = 0; k < 2; k++) {
				for (int i = 3; i > 0; i --) {
					if (row[i] == 0) {
						for (int j = i; j > 0; j --) {
							row[j] = row[j-1];
						}
						row[0] = 0;
					}
				}
			}
		}
	}
	
	/**
	 * @brief Upwards board shift method
	 * @details This method shift all elements in the grid upwards. If equal numbers shift into one
	 * 			another, the two are combined, with priority given to the upper element. This is done 
	 * 			by summing the two elements in the upper element's place and making the lower element 0.
	 * 			Once all the combinations are calculated, all elements in the grid are shifted upwards, 
	 * 			with no further merges being performed. 
	 */
	public void shiftUp() {
		for (int column = 0; column < 4; column ++) {
			if (grid[0][column] == 0 && grid[1][column] == 0 && grid[2][column] == 0 && grid[3][column] == 0)
				continue;
			if (grid[0][column] == grid[1][column] && grid[1][column] != 0) {
				grid[0][column] = grid[0][column] + grid[1][column];
				score += grid[0][column];
				grid[1][column] = 0;
				if (grid[3][column] == grid[2][column] && grid[2][column] != 0) {
					grid[2][column] = grid[2][column] + grid[3][column];
					score += grid[2][column];
					grid[3][column] = 0;
				}
			} else if (grid[2][column] == grid[1][column] && grid[2][column] != 0) {
				grid[1][column] = grid[1][column] + grid[2][column];
				score += grid[1][column];
				grid[2][column] = 0;
			} else if (grid[2][column] == grid[0][column] && grid[2][column] != 0) {
				grid[0][column] = grid[2][column] + grid[0][column];
				score += grid[0][column];
				grid[2][column] = 0;
			} else if (grid[3][column] == grid[0][column] && grid[1][column] == grid[2][column] && grid[1][column] == 0 && grid[0][column] != 0) {
				grid[0][column] = grid[3][column] + grid[0][column];
				score += grid[0][column];
				grid[3][column] = 0;
			} else if (grid[3][column] == grid[1][column] && grid[3][column] != 0) {
				grid[1][column] = grid[1][column] + grid[3][column];
				score += grid[1][column];
				grid[3][column] = 0;
			} else if (grid[2][column] == grid[3][column] && grid[2][column] != 0) {
				grid[2][column] = grid[3][column] + grid[2][column];
				score += grid[2][column];
				grid[3][column] = 0;
			} 

			for (int k = 0; k < 2; k ++) {
				for (int i = 0; i < 4; i ++) {
					if (grid[i][column] == 0) {
						for (int j = i; j < 3; j ++) {
							grid[j][column] = grid[j+1][column];
						}
						grid[3][column] = 0;
					}
				}
			}
		}
	}
	
	/**
	 * @brief Downwards board shift method
	 * @details This method shift all elements in the grid downwards. If equal numbers shift into one
	 * 			another, the two are combined, with priority given to the lower element. This is done 
	 * 			by summing the two elements in the lower element's place and making the upper element 0.
	 * 			Once all the combinations are calculated, all elements in the grid are shifted downwards, 
	 * 			with no further merges being performed. 
	 */
	public void shiftDown() {
		for (int column = 0; column < 4; column ++) {
			if (grid[0][column] == 0 && grid[1][column] == 0 && grid[2][column] == 0 && grid[3][column] == 0)
				continue;
			if (grid[3][column] == grid[2][column] && grid[3][column] != 0) {
				grid[3][column] = grid[2][column] + grid[3][column];
				score += grid[3][column];
				grid[2][column] = 0;
				if (grid[1][column] == grid[0][column] && grid[1][column] != 0) {
					grid[1][column] = grid[1][column] + grid[0][column];
					score += grid[1][column];
					grid[0][column] = 0;
				}
			} else if (grid[2][column] == grid[1][column] && grid[1][column] != 0) {
				grid[2][column] = grid[1][column] + grid[2][column];
				score += grid[2][column];
				grid[1][column] = 0;
			} else if (grid[3][column] == grid[1][column] && grid[3][column] != 0) {
				grid[3][column] = grid[1][column] + grid[3][column];
				score += grid[3][column];
				grid[1][column] = 0;
			} else if (grid[3][column] == grid[0][column] && grid[1][column] == grid[2][column] && grid[1][column] == 0 && grid[0][column] != 0) {
				grid[3][column] = grid[3][column] + grid[0][column];
				score += grid[3][column];
				grid[0][column] = 0;
			} else if (grid[2][column] == grid[0][column] && grid[2][column] != 0) {
				grid[2][column] = grid[2][column] + grid[0][column];
				score += grid[2][column];
				grid[0][column] = 0;
			} else if (grid[0][column] == grid[1][column] && grid[0][column] != 0) {
				grid[1][column] = grid[1][column] + grid[0][column];
				score += grid[1][column];
				grid[0][column] = 0;
			} 
			
			for (int k = 0; k < 2; k++) {
				for (int i = 3; i > 0; i --) {
					if (grid[i][column] == 0) {
						for (int j = i; j > 0; j --) {
							grid[j][column] = grid[j-1][column];
						}
						grid[0][column] = 0;
					}
				}
			}
		}
	}
	
	/**
	 * @brief Shift legality method
	 * @details This method determines if the 4x4 board can be shifted in a given direction. A shift can be
	 * 			performed if 2 tiles are adjacent in the given direction or if a zero/blank appears "below"
	 * 			a nonzero element.
	 * @param direction Character in ['D','U','L','R'] representing directional shift.
	 * @return True if board can be meaningfully shifted in a given direction, false otherwise.
	 */
	public boolean canMove(char direction) {
		switch(direction) {
		case 'D':
			for (int i = 0; i < 4; i++) {
				for (int j = 3; j > 0; j--) {
					if ((grid[j][i] == grid[j-1][i] && grid[j][i] != 0) || (grid[j][i] == 0 && grid[j-1][i] != 0))
						return true;
				}
			}
			break;
		case 'U':
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					if ((grid[j][i] == grid[j+1][i] && grid[j][i] != 0) || (grid[j][i] == 0 && grid[j+1][i] != 0))
						return true;
				}
			}
			break;
		case 'L':
			for (int[] row : grid) {
				for (int i = 0; i < 3; i++) {
					if ((row[i] == row[i+1] && row[i] != 0) || (row[i] == 0 && row[i+1] != 0))
						return true;
				}
			}
			break;
		case 'R':
			for (int[] row : grid) {
				for (int i = 3; i > 0; i--) {
					if ((row[i] == row[i-1] && row[i] != 0) || (row[i] == 0 && row[i-1] != 0))
						return true;
				}
			}
			break;
		}
		return false;
	}
	
}
