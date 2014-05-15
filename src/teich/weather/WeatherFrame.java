package teich.weather;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class WeatherFrame extends JFrame implements Runnable {

	private JTextArea text;

	public WeatherFrame() {

		setSize(800, 600);
		setLayout(new BorderLayout());
		setTitle("Weather");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		text = new JTextArea();

		Thread t = new Thread(this);
		t.start();

		this.setVisible(true);
	}

	public static void main(String[] args) {
		WeatherFrame frame = new WeatherFrame();
	}

	public void run() {
		try {
			London l = new London();
			String coord = l.getCf().getName();
			text.setText(coord);
			l.add(text);
			add(l);
			revalidate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
