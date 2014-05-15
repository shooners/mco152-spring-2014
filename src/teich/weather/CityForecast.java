package teich.weather;


public class CityForecast {

	private Conditions[] weather;
	private Clouds clouds;
	private Coord coord;
	private Main main;
	private Rain rain;
	private Sys sys;
	private Wind wind;
	private String base;
	private long dt;
	private long id;
	private String name;
	private int cod;

	public Conditions[] getWeather() {
		return weather;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public Coord getCoord() {
		return coord;
	}

	public Main getMain() {
		return main;
	}

	public Rain getRain() {
		return rain;
	}

	public Sys getSys() {
		return sys;
	}

	public Wind getWind() {
		return wind;
	}

	public String getBase() {
		return base;
	}

	public long getDt() {
		return dt;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCod() {
		return cod;
	}
}
