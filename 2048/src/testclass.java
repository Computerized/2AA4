
public class testclass {
	
	public static void drawNums(int [][] nums) {
		for (int[] row: nums) {
			for (int number : row) {
				System.out.print(number);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int [][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		drawNums(grid);
	}
}
