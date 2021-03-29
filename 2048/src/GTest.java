import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
public class GTest extends JFrame
{
// The paint method below determines what to
// draw on the screen and is invoked by Java
public void paint(Graphics g)
{
super.paint(g);
g.setColor(Color.red); // Sets color to red
// NOTE: Title Bar about 22 pixels down
// Border frame about 7 pixels across
// Draw rectangle at X=10, Y=50,
// width=100, height = 70 pixels
g.drawRect(10,50,100,70);
// Write text at X = 100, Y = 150
g.drawString("Moof.", 100, 150);
}
public GTest()
{
setSize(300, 200); // 300 pixels across, 200 down
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true); // Makes window visible

}
public static void main(String[] args)
{
GTest myWindow = new GTest(); // Title
}
}
