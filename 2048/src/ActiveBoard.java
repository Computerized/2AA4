import java.util.Arrays;

public class ActiveBoard extends Board{

	public ActiveBoard(int[][] arr) {
		super(arr);
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
	
	public boolean canMove(char direction) {
		switch(direction) {
		case 'D':
			break;
		case 'U':
			break;
		case 'L':
			break;
		case 'R':
			break;
		}
		
		return false;
	}
	
	public void shiftLeft() {
		for (int[] row : grid) {
			int[] blankRow = {0,0,0,0};
			if (Arrays.equals(blankRow, row))
				continue;
			if (row[0] == row[1] && row[0] != 0) {
				row[0] = row[0] + row[1];
				row[1] = 0;
				if (row[2] == row[3] && row[2] != 0) {
					row[2] = row[2] + row[3];
					row[3] = 0;
				}
			} else if (row[0] == row[2] && row[0]!=0 && row[1] == 0) {
				row[0] = row[0] + row[2];
				row[2] = 0;
			} else if (row[1] == row[2] && row[1] != 0) {
				row[1] = row[1] + row[2];
				row[2] = 0;
			} else if (row[1] == row[3] && row[1] != 0 && row[2] == 0) {
				row[1] = row[1] + row[3];
				row[3] = 0;
			} else if (row[2] == row[3] && row[2] != 0) {
				row[2] = row[2] + row[3];
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
				row[2] = 0;
				if (row[1] == row[0] && row[1] != 0) {
					row[1] = row[0] + row[1];
					row[0] = 0;
				}
			} else if (row[1] == row[0] && row[0] != 0) {
				row[1] = row[0];
				row[0] = 0;
			} else if (row[3] == row[1] && row[2] == 0 && row[3] != 0) {
				row[3] = row[3] + row[1];
				row[1] = 0;
			} else if (row[2] == row[0] && row[1] == 0 && row[2] != 0) {
				row[2] = row[2] + row[0];
				row[0] = 0;
			} else if (row[1] == row[0] && row[0] != 0) {
				row[1] = row[1] + row[0];
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
		
	}
	
	public void shiftDown() {
		
	}
	
	public static void main(String[] args) {
		int[][] nums = {{2,2,2,2},{2,0,2,0},{2,0,2,2},{0,2,0,2}};
		int[][] nums2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		ActiveBoard AB = new ActiveBoard(nums);
		ActiveBoard AB2 = new ActiveBoard(nums2);
		System.out.println(AB);
		AB.shiftRight();
		System.out.println(AB);
	}

}
