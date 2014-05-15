package teich.smiley;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileyFace extends JComponent {

	public void paintComponent(Graphics pen) {

		pen.drawLine(0, 0, getWidth(), getHeight());
		pen.drawLine(0, getHeight(), getWidth(), 0);

		pen.setColor(Color.GREEN);
		pen.drawOval(getWidth() / 2 - 50, getHeight() / 2 - 50, 100, 100);
	}
}
