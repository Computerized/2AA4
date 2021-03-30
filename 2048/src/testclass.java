public class testclass {
	
	public static void drawNums(int [][] nums) {
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		int [][] nums = {{1,0,1,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		ActiveBoard AB = new ActiveBoard(nums);
		GUI gui = new GUI(AB);
		Thread.sleep(2000);
		AB.shiftLeft();
		gui.updateTiles(AB);
	}
}
