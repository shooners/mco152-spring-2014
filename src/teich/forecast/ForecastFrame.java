package teich.forecast;

import java.io.IOException;

import javax.swing.JFrame;

public class ForecastFrame extends JFrame implements Runnable {

	public ForecastFrame() {
		Thread t = new Thread(this);
		t.start();
		this.setSize(800, 600);
		this.setTitle("Weather Graph");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		ForecastFrame frame = new ForecastFrame();
		frame.setVisible(true);
	}

	public void run() {
		try {
			Forecast f = new Forecast();
			add(f);
			revalidate();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
