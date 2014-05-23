package teich.earthquakes;

public class Earthquake {

	String magnitude;
	String location;

	@Override
	public String toString() {
		return magnitude + " " + location;
	}

}
