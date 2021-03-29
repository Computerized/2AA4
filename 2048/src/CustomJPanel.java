import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomJPanel extends JPanel{
	
	public CustomJPanel() {
		super();
	}
	
	public void paintComponent(Graphics g, int [][] arr) {
		g.draw3DRect(0, 0, 100, 100, false);
	}
}
