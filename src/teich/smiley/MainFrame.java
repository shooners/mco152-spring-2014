package teich.smiley;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public MainFrame() {
		this.setTitle("Smiley");
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(new SmileyFace(), BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		MainFrame window = new MainFrame();
		window.setVisible(true);
	}
}
