
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
		AB.addRandomTwo(true); //first two are guaranteed to be two
		AB.addRandomTwo(true);
		while (true) {
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
			if (AB.hasLegalMoves()) {
				if (AB.hasZero())
					AB.addRandomTwo(false);
				gui.updateTiles(AB);
			} else {
				endGame();
			}
		}
	}
	
	public void endGame() {
		System.out.println("Game Over");
		System.out.println("Your score was: " + AB.getScore());
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
