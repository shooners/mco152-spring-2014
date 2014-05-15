package teich.forecast;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JPanel;

import com.google.gson.Gson;

public class Forecast extends JPanel {

	private Cast[] cast;
	private double[] days;
	private int[] d;
	private Color[] c;

	public Forecast() throws IOException {
		cast = new Cast[7];
		days = new double[7];
		d = new int[] { 100, 200, 300, 400, 500, 600, 700 };
		c = new Color[] { Color.RED, Color.ORANGE, Color.GREEN, Color.BLUE,
				Color.CYAN, Color.MAGENTA };
		URL url = new URL(
				"http://api.openweathermap.org/data/2.5/forecast/daily?q=Brooklyn&mode=json&units=imperial&cnt=7");
		URLConnection connect = url.openConnection();
		InputStream in = connect.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		CityForecast cf = gson.fromJson(reader, CityForecast.class);
		for (int i = 0; i < 7; i++) {
			cast[i] = cf.getList()[i];
			System.out.println(gson.toJson(cast[i]));
		}
		for (int i = 0; i < 7; i++) {
			days[i] = 500 - cast[i].getTemp().getDay();
		}
	}

	public Cast[] getCast() {
		return cast;
	}

	public void paint(Graphics pen) {

		Graphics2D g2d = (Graphics2D) pen;

		pen.drawLine(100, 100, 100, 500);
		pen.drawLine(100, 500, 700, 500);
		for (int k = 450; k > 100; k -= 50) {
			pen.drawLine(100, k, 105, k);
		}
		for (int l = 200; l < 700; l += 100) {
			pen.drawLine(l, 500, l, 495);
		}

		for (int j = 0; j < 6; j++) {
			Point2D.Double p = new Point2D.Double(d[j], days[j]);
			Point2D.Double p2 = new Point2D.Double(d[j + 1], days[j + 1]);
			g2d.setColor(c[j]);
			g2d.draw(new Line2D.Double(p, p2));
		}

	}

}
