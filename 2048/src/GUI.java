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
	
	public void paint (Graphics g) {
		super.paint(g);
		// drawing grid
		g.drawRect(25, 50, 350, 350);
		g.drawLine(25, 225, 375, 225);
		g.drawString("" + nums[0][0], 100, 100);
	}
	
	public void changeBool(boolean bool) {
		a = bool;
	}

}
