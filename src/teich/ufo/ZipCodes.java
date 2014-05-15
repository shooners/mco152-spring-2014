package teich.ufo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

import com.google.gson.Gson;

public class ZipCodes {

	private String zipCode;
	private double latitude;
	private double longitude;
	private String city;
	private String state;
	private List<ZipCode> zips = new ArrayList<ZipCode>();
	SightingList list;

	public ZipCodes() throws FileNotFoundException, IOException {
		CSVReader reader = new CSVReader(new FileReader("ZIP_CODES.txt"));
		String[] line;
		while ((line = reader.readNext()) != null) {
			zipCode = line[0];
			if (!"".equals(line[1])) {
				latitude = Double.parseDouble(line[1]);
			}
			if (!"".equals(line[2])) {
				longitude = Double.parseDouble(line[2]);
			}
			city = line[3];
			state = line[4];
			zips.add(new ZipCode(zipCode, latitude, longitude, city, state));
		}

		Gson gson = new Gson();

		FileReader fReader = new FileReader("ufo_awesome.json");
		list = gson.fromJson(fReader, SightingList.class);
		Map<String, List<Sighting>> map = new HashMap<>();

		for (Sighting s : list) {
			String location = s.getLocation();
			List<Sighting> sightings = map.get(location);

			if (sightings == null) {
				sightings = new ArrayList<Sighting>();
			}
			sightings.add(s);
			map.put(location, sightings);
		}
		reader.close();

	}

	public List<ZipCode> getZips() {
		return zips;
	}

	public List<String> getZipCodes() throws FileNotFoundException {
		List<String> codes = new ArrayList<String>();

		for (Sighting s : list) {
			for (ZipCode zc : zips) {
				String loc = zc.getCity() + ", " + zc.getState();
				String sLoc = s.getLocation().toUpperCase().trim();
				if (loc.equals(sLoc)) {
					codes.add(loc + ": " + zc.getZipCode());
				}
			}
		}
		return codes;
	}
}
