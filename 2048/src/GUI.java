import java.awt.*;
import java.awt.event.*;	
import javax.swing.*;


public class GUI extends JFrame implements KeyListener {
	private int [][] nums = new int[4][4];
	private char lastDirection = ' ';
	boolean flag = false;
	
	public GUI (Board board) {
		this.nums = board.getArray();
		this.setName("2048");
		this.setSize(400,425);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	 * @param g Graphics interface of the JFrame
	 */
	public void paint (Graphics g) {
		super.paint(g);
		// drawing grid	
		g.drawRect(25, 50, 350, 350);
		//horizontals
		g.drawLine(25, 225, 375, 225);
		g.drawLine(25, 138, 375, 138);
		g.drawLine(25, 313, 375, 313);
		//verticals
		g.drawLine(200, 50, 200, 400);
		g.drawLine(113, 50, 113, 400);
		g.drawLine(288, 50, 288, 400);
		
		int x = 60;
		int y = 100;
		for (int[] row : nums) {
			x = 60;
			for (int number : row) {
				g.drawString((number == 0) ? "" : number + "", x, y); //if number is 0, leave blank
				x += 90;
			}
			y += 87;
		}
	}
	
	public char getDirection() {
		char c = lastDirection;
		resetDirection();
		setFlag(false);
		return c;
	}
	
	public void resetDirection() {
		lastDirection = ' ';
	}
	
	private void setFlag(boolean tf) {
		flag = tf;
	}
	
	public boolean getFlag() {
		return flag;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		return;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		return;
	}

	@Override
	public void keyPressed(KeyEvent kp) {
		setFlag(true);
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
