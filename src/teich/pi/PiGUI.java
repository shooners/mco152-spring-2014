package teich.pi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PiGUI extends JFrame implements ActionListener, Runnable {

	private JTextArea text;
	private JButton start;

	public PiGUI() {
		text = new JTextArea();
		start = new JButton("Start");

		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(text, BorderLayout.CENTER);
		this.add(start, BorderLayout.SOUTH);

		start.addActionListener(this);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		PiGUI window = new PiGUI();
	}

	@Override
	public void run() {
		double pi = 0;
		for (int i = 1; i < 1000000000; i++) {
			pi += 4 * Math.pow((-1), i + 1) / ((2 * i) - 1);
			text.setText(String.valueOf(pi));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();
	}
}
