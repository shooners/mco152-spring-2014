package teich.mtamap;

public class Shape {

	String shapeID;
	double latitude;
	double longitude;

	public Shape(String shapeID, double lat, double lon) {
		this.shapeID = shapeID;
		latitude = lat;
		longitude = lon;

	}

	public String getShapeID() {
		return shapeID;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
}
