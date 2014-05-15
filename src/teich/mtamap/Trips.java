package teich.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Trips {

	private List<Trip> trips;

	public Trips() throws IOException {
		trips = new ArrayList<Trip>();
		CSVReader reader = new CSVReader(new FileReader("trips.txt"));
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			String rid = nextLine[0];
			String tid = nextLine[2];
			String sid = nextLine[6];
			trips.add(new Trip(tid, rid, sid));
		}
		reader.close();
	}

	public List<Trip> getTrips(String shapeID) {
		List<Trip> t = new ArrayList<Trip>();
		for (int i = 0; i < trips.size(); i++) {
			if (trips.get(i).getShapeID().equals(shapeID)) {
				t.add(trips.get(i));
			}
		}
		return t;
	}
}
