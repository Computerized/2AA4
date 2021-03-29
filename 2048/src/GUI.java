import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI extends JFrame{
	boolean a = true;
	int [][] nums = new int[4][4];
	
	public GUI (String name, int[][] nums) {
		this.nums = nums;
		this.setName(name);
		this.setSize(400,425);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void updateTiles(int[][] arr) {
		nums = arr;
		this.repaint();
	}
	
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
	
	public void changeBool(boolean bool) {
		a = bool;
	}

}
