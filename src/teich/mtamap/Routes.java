package teich.mtamap;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Routes {

	private List<Route> routes;

	public Routes() throws IOException {
		routes = new ArrayList<Route>();
		CSVReader reader = new CSVReader(new FileReader("routes.txt"));
		reader.readNext();
		String[] line;
		while ((line = reader.readNext()) != null) {
			String id = line[0];
			Color color = null;
			if (!"".equals(line[7])) {
				color = Color.decode("#" + line[7]);
			}

			routes.add(new Route(id, color));
		}
		reader.close();
	}

	public Color getColor(String routeID) {
		Color c = null;
		for (int i = 0; i < routes.size(); i++) {
			if (routes.get(i).getRouteID().equals(routeID)) {
				c = routes.get(i).getColor();
			}
		}
		return c;
	}
}
