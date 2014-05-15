package teich.mtamap;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class MapFrame extends JFrame {

	public MapFrame() {
		this.setTitle("MTA Map");
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(new Map(), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		MapFrame frame = new MapFrame();
		frame.setVisible(true);
	}
}
