
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
	
	public boolean canMove(char direction) {
		switch(direction) {
		case 'D':
			for (int row = 0; row < 3; row++) {
				for (int column = 0; column < 4; column ++) {
					if (grid[row][column] == grid[row+1][column])
						return true;
					else if (grid[row][column] != 0 && grid[row+1][column] == 0)
						return true;
				}
			}
			break;
		case 'U':
			for (int row = 3; row > 0; row --) {
				for (int column = 0; column < 4; column ++) {
					if (grid[row][column] == grid[row-1][column])
						return true;
					else if (grid[row][column] != 0 && grid[row-1][column] == 0) {
						return true;
					}
				}
			}
			break;
		case 'L':
			for (int row = 0; row < 3; row++) {
				
			}
			break;
			
		}
		
		return false;
	}

}
