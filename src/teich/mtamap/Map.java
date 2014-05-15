package teich.mtamap;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.List;

import javax.swing.JComponent;

public class Map extends JComponent {

	public void paintComponent(Graphics pen) {
		try {
			Routes routes = new Routes();
			Trips trips = new Trips();
			Shapes shapes = new Shapes();
			List<Trip> t = trips.getTrips("4..N06R");
			List<Shape> s = shapes.getShapes("4..N06R");
			Trip trip = t.get(0);
			double minLat = shapes.getMinLat();
			double minLon = shapes.getMinLon();
			double latLength = shapes.getLatLength();
			double lonLength = shapes.getLonLength();
			int dimension = Math.min(getWidth(), getHeight());
			Color color = routes.getColor(trip.getRouteID());
			pen.setColor(color);
			for (int i = 1; i < s.size(); i++) {
				Shape s1 = (Shape) s.get(i - 1);
				Shape s2 = (Shape) s.get(i);
				int x1 = (int) ((s1.getLatitude() - minLat) * dimension / latLength);
				int y1 = (int) ((s1.getLongitude() - minLon) * dimension / lonLength);
				int x2 = (int) ((s2.getLatitude() - minLat) * dimension / latLength);
				int y2 = (int) ((s2.getLongitude() - minLon) * dimension / lonLength);
				if ((x1 != x2) || (y1 != y2)) {
					pen.drawLine(x1, y1, x2, y2);
				}
			}
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}
}
