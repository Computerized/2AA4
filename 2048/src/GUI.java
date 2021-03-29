import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI {
	
	public static void drawNums(int [][] arr) {
		
	}
	
	public static void drawLines(int num) {
		
	}
	
	public static void main(String[] args) {
		JFrame JF = new JFrame("2048");
		CustomCanvas canvas = new CustomCanvas();
		JF.add(canvas);
		int [][] nums = {{}};
		JF.pack();
		JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JF.setVisible(true);
		canvas.paint(canvas.getGraphics(), nums);
	}

}
