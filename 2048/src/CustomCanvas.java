import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomCanvas extends Canvas{
	
	public CustomCanvas () {
		this.setSize(400,400);
	}
	
	public void paint(Graphics G, int [][] arr) {
		G.setColor(Color.red);
		G.fillOval(100,100,200,200);
	}
}
