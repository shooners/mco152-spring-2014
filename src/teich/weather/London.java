package teich.weather;

import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JPanel;

import com.google.gson.Gson;

public class London extends JPanel {

	private Coord c;
	private Sys s;
	private Conditions[] w;
	private Main m;
	private Wind wi;
	private Clouds cl;
	private CityForecast cf;

	public London() throws IOException {

		URL url = new URL(
				"http://api.openweathermap.org/data/2.5/weather?q=London,uk");

		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();

		InputStreamReader reader = new InputStreamReader(in);
		Gson g = new Gson();

		cf = g.fromJson(reader, CityForecast.class);
		c = cf.getCoord();
		System.out.println(c);
		s = cf.getSys();
		System.out.println(s);
		w = cf.getWeather();
		for (Conditions cond : w) {
			System.out.println(cond);
		}
		Main m = cf.getMain();
		System.out.println(m);
		wi = cf.getWind();
		System.out.println(wi);
		cl = cf.getClouds();
		System.out.println(cl);
		System.out.println("Base=" + cf.getBase() + " dt=" + cf.getDt()
				+ " id=" + cf.getId() + " name=" + cf.getName() + " cod="
				+ cf.getCod());
	}

	public CityForecast getCf() {
		return cf;
	}

	public Coord getC() {
		return c;
	}

	public void paintComponent(Graphics pen) {

	}
}
