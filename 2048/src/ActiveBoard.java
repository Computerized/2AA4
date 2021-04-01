import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ActiveBoard extends Board{

	public ActiveBoard(int[][] arr) {
		super(arr);
		score = 0;
	}
	
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
	
	public void addRandomTwo(boolean guarantwod) {
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
		int [] coord = coords.get(rand.nextInt(coords.size())); //pick random empty space
		grid[coord[0]][coord[1]] = (rand.nextDouble() < 0.9 || guarantwod) ? 2 : 4; //10 % chance of getting a four
	}
	
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
