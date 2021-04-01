import java.awt.*;
import java.awt.event.*;	
import javax.swing.*;

/**
 * @author Alan Scott, scotta30, 400263658
 * @file GUI.java
 * @brief Class for implementing 2048 GUI grid
 * @details This class is a JFrame which handles graphics output, as well as user key input. It extends
 * 			the JFrame class, and implements the KeyListener interface.
 */
public class GUI extends JFrame implements KeyListener {
	private int [][] nums = new int[4][4]; //empty board
	private char lastDirection = ' '; //last key direction pressed
	private boolean flag = false; //flag = true when valid input is pressed
	private Board board; //game board
	
	public GUI (Board board) {
		this.board = board;
		this.nums = board.getArray();
		this.setName("2048");
		this.setSize(400,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //progam exits if window is forced closed
		this.setVisible(true);
		this.addKeyListener(this);
	}
	
	public void updateTiles(Board board) {
		nums = board.getArray();
		this.repaint();
	}
	
	@Override
	/**
	 * @brief Painting method
	 * @param g Graphics class and settings of the JFrame
	 * @brief Graphics display method
	 * @details This methods procedurally paints the graphics window with a 4x4 grid and fills in
	 * 			the values of the numbers according to the Board object.
	 */
	public void paint (Graphics g) {
		super.paint(g);
		// drawing outer bound
		g.drawRect(25, 50, 350, 350);
		//horizontals
		g.drawLine(25, 225, 375, 225);
		g.drawLine(25, 138, 375, 138);
		g.drawLine(25, 313, 375, 313);
		//verticals
		g.drawLine(200, 50, 200, 400);
		g.drawLine(113, 50, 113, 400);
		g.drawLine(288, 50, 288, 400);
		
		g.drawString("Current Score: " + board.getScore(), 30, 423);
		
		int x = 60;
		int y = 100;
		for (int[] row : nums) {
			x = 60;
			for (int number : row) {
				g.drawString((number == 0) ? "" : number + "", x, y); //if number is 0, leave blank, otherwise print number
				x += 90; //approximate horizontal spacing
			}
			y += 87; //approximate vertical spacing
		}
	}
	
	public char getDirection() {
		return lastDirection;
	}
	
	public void resetDirection() {
		lastDirection = ' ';
		flag = false;
	}
	
	private void setFlag(boolean tf) {
		flag = tf;
	}
	
	public boolean getFlag() {
		return flag;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		return; //required method; placeholder
	}

	@Override
	public void keyReleased(KeyEvent e) {
		return; //required method; placeholder
	}

	@Override
	/**
	 * @brief Key detection method
	 * @details This method detects when a key has been pressed. If the key is one of
	 * 			[up,down,left,right,escape], it sets the key pressed to the last pressed key and sets
	 * 			the flag.
	 */
	public void keyPressed(KeyEvent kp) {
		switch(kp.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			lastDirection = 'D';
			setFlag(true);
			break;
		case KeyEvent.VK_UP:
			lastDirection = 'U';
			setFlag(true);
			break;
		case KeyEvent.VK_LEFT:
			lastDirection = 'L';
			setFlag(true);
			break;
		case KeyEvent.VK_RIGHT:
			lastDirection = 'R';
			setFlag(true);
			break;
		case KeyEvent.VK_ESCAPE:
			lastDirection = 'E';
			setFlag(true);
			break;
		}
	}
	
}
