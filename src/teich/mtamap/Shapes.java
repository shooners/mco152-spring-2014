package teich.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Shapes {

	private List<Shape> shapes;
	double minLat;
	double minLon;
	double maxLat;
	double maxLon;
	double latLength;
	double lonLength;

	public Shapes() throws IOException {
		shapes = new ArrayList<Shape>();
		minLat = 2147483647.0D;
		minLon = 2147483647.0D;
		maxLat = -2147483648.0D;
		maxLon = -2147483648.0D;
		latLength = Math.abs(this.maxLat - this.minLat);
		lonLength = Math.abs(this.maxLon - this.minLon);
		CSVReader reader = new CSVReader(new FileReader("shapes.txt"));
		reader.readNext();
		String[] line;
		while ((line = reader.readNext()) != null) {
			String id = line[0];
			double lat = Double.parseDouble(line[1]);
			double lon = Double.parseDouble(line[2]);
			Shape shape = new Shape(id, lat, lon);
			shapes.add(shape);
			maxLat = Math.max(maxLat, shape.getLatitude());
			maxLon = Math.max(maxLon, shape.getLongitude());
			minLat = Math.min(minLat, shape.getLatitude());
			minLon = Math.min(minLon, shape.getLongitude());
		}
		reader.close();
	}

	public List<Shape> getShapes(String shapeID) {
		List<Shape> s = new ArrayList<Shape>();
		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i).getShapeID().equals(shapeID)) {
				s.add(shapes.get(i));
			}
		}
		return s;
	}

	public double getMinLat() {
		return minLat;
	}

	public double getMinLon() {
		return minLon;
	}

	public double getLatLength() {
		return latLength;
	}

	public double getLonLength() {
		return lonLength;
	}
}
