package teich.clock;

import javax.swing.JFrame;

public class ClockFrame extends JFrame implements Runnable {

	private Thread t;
	private Clock c;

	public ClockFrame() {
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		c = new Clock();

		this.add(c);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		ClockFrame clock = new ClockFrame();

		new Thread(clock).start();

	}

	@Override
	public void run() {
		while (true) {

			try {
				c.increaseSeconds();
				t.sleep(1000);
			} catch (InterruptedException e) {
				e.getMessage();
			}
			repaint();
			System.out.println(c);
		}
	}
}
