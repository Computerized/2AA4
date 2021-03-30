
public class Game {
	GUI gui;
	ActiveBoard AB;
	
	public Game () {
		int[][] nums = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		AB = new ActiveBoard(nums);
		gui = new GUI(AB);
		start();
	}
	
	public void start() {
		AB.addRandomTwo();
		while (true) {
			if (AB.hasLegalMoves()) {
				AB.addRandomTwo();
				gui.updateTiles(AB);
			} else {
				endGame();
			}
			char c = getUserInput();
			switch (c) {
			case 'U':
				AB.shiftUp();
				break;
			case 'D':
				AB.shiftDown();
				break;
			case 'L':
				AB.shiftLeft();
				break;
			case 'R':
				AB.shiftRight();
				break;
			case 'E':
				endGame();
			}
		}
	}
	
	public void endGame() {
		System.exit(0);
	}
	
	public char getUserInput() {
		char c = gui.getDirection();
		while (!gui.getFlag()) {
			delay(300);
		}
		c = gui.getDirection();
		gui.resetDirection();
		return c;
	}
	
	private void delay(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
