package teich.ufo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class ListSightings {

	public static void main(String[] args) throws JsonIOException,
			JsonSyntaxException, FileNotFoundException {

		Gson gson = new Gson();

		FileReader reader = new FileReader("ufo_awesome.json");
		SightingList list = gson.fromJson(reader, SightingList.class);
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

	}
}
