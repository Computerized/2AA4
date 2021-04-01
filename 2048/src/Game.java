import java.util.Scanner;

public class Game {
	GUI gui;
	ActiveBoard AB;
	
	public Game () {
		rules();
		int[][] nums = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		AB = new ActiveBoard(nums);
		gui = new GUI(AB);
		start();
	}
	
	public void rules() {
		System.out.println("2048");
		System.out.println("Use the arrow keys to shift tiles");
		System.out.println("Press ESC to end game");
	}
	
	public void start() {
		AB.addRandomTwo(true); //first two are guaranteed to be two
		AB.addRandomTwo(true);
		gui.updateTiles(AB);
		while (true) {
			char c = getUserInput();
			switch (c) {
			case 'U':
				if (AB.canMove(c)) {
					AB.shiftUp();
					AB.addRandomTwo(false);
				}
				break;
			case 'D':
				if (AB.canMove(c)) {
					AB.shiftDown();
					AB.addRandomTwo(false);
				}
				break;
			case 'L':
				if (AB.canMove(c)) {
					AB.shiftLeft();
					AB.addRandomTwo(false);
				}
				break;
			case 'R':
				if (AB.canMove(c)) {
					AB.shiftRight();
					AB.addRandomTwo(false);
				}
				break;
			case 'E':
				endGame("User Exit");
			}
			if (AB.hasLegalMoves())
				gui.updateTiles(AB);
			else
				endGame("No Valid Moves");
		}
	}
	
	public void endGame(String reason) {
		System.out.println("Game over by: " + reason);
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
