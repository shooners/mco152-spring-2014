package teich.prime;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Prime extends JFrame implements ActionListener, Runnable {

	private JTextArea area;
	private JButton button;

	public Prime() {
		area = new JTextArea();
		button = new JButton("Start");

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(area, BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);

		button.addActionListener(this);

		this.setVisible(true);
	}

	@Override
	public void run() {
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 1; i < 10000000; i++) {
			if (isPrime(i)) {
				area.setText(String.valueOf(i));
			}
		}
	}

	public boolean isPrime(int num) {
		boolean prime = true;
		for (int i = 2; i < Math.sqrt(num); i++) {
			if (num % i == 0) {
				prime = false;
				return prime;
			}
		}
		return prime;
	}

	public static void main(String[] args) {
		Prime window = new Prime();
	}
}
