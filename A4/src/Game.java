	/**
 * @file Game.java
 * @author Alan Scott, scotta30, 400263658
 * @brief Game controller class
 * @details This class handles both the GUI class and the ActiveBoard class to create a
 * 			game of 2048. The controller takes input from the user through the GUI JFrame.
 * 			Game processes it, and performs the necessary operations on ActiveBoard using methods
 * 			within ActiveBoard. The Game class then passes on the ActiveBoard to the GUI class
 * 			where it is displayed on the JFrame.
 */
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
	
	/**
	 * @brief Rules output method
	 * @details This method outputs the game name and instructions to the console before the game starts
	 */
	private void rules() {
		System.out.println("2048");
		System.out.println("Use the arrow keys to shift tiles");
		System.out.println("Press ESC to end game");
	}
	
	private void start() {
		AB.addRandomTwo(); //add the first 2 twos
		AB.addRandomTwo();
		gui.updateTiles(AB); //update the GUI
		while (true) {
			char c = getUserInput(); //get input from the GUI
			switch (c) { //move depending on inputs
			case 'U':
				if (AB.canMove(c)) {
					AB.shiftUp();
					AB.addRandomTwo();
				}
				break;
			case 'D':
				if (AB.canMove(c)) {
					AB.shiftDown();
					AB.addRandomTwo();
				}
				break;
			case 'L':
				if (AB.canMove(c)) {
					AB.shiftLeft();
					AB.addRandomTwo();
				}
				break;
			case 'R':
				if (AB.canMove(c)) {
					AB.shiftRight();
					AB.addRandomTwo();
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
	
	/**
	 * @brief Game over method
	 * @details This method runs when the game is over. It displays the reason for the game
	 * 			ending (either no moves left or user termination), displays the user score, and then 
	 * 			terminates the program normally.
	 * @param reason Reason for game over
	 */
	private void endGame(String reason) {
		System.out.println("Game over by: " + reason);
		System.out.println("Your score was: " + AB.getScore());
		System.exit(0); //exit program with normal termination
	}
	
	/**
	 * @brief User input method
	 * @details This method gets user input. It holds the program with a loop until the direction
	 * 			flag is set. Then, it gets the last direction from the GUI class, and resets the direction.
	 * 			The last direction is returned.
	 * @return Character c inputted to GUI class
	 */
	private char getUserInput() {
		char c = gui.getDirection();
		while (!gui.getFlag()) {
			delay(300);
		}
		c = gui.getDirection();
		gui.setFlag(false);
		gui.setDirection(' ');
		return c;
	}
	
	/**
	 * @brief Program delay method
	 * @details This program uses Thread.sleep in a try-catch block to pause the program for a given
	 * 			amount of time.
	 * @param millis Milliseconds to pause the program
	 */
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
