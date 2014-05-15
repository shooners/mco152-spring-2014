package teich.mtamap;

import java.awt.Color;

public class Route {

	private String routeID;
	private Color color;

	public Route(String routeID, Color color) {
		this.routeID = routeID;
		this.color = color;
	}

	public String getRouteID() {
		return routeID;
	}

	public Color getColor() {
		return color;
	}
}
