package teich.mtamap;

public class Trip {

	private String tripID;
	private String routeID;
	private String shapeID;

	public Trip(String tripID, String routeID, String shapeID) {
		this.tripID = tripID;
		this.routeID = routeID;
		this.shapeID = shapeID;
	}

	public String getTripID() {
		return tripID;
	}

	public String getRouteID() {
		return routeID;
	}

	public String getShapeID() {
		return shapeID;
	}
}
