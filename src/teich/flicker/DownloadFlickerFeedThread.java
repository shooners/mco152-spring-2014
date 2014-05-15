package teich.flicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

/**
 * Retrieves the Flicker feed and calls frame.loadImages()
 */
public class DownloadFlickerFeedThread extends Thread {

	private static final String FEED_URL = "https://api.flickr.com/services/feeds/photos_public.gne?id=20952345@N03&format=json";
	private FlickerFeedFrame frame;
	private FlickerFeed feed;

	public DownloadFlickerFeedThread(final FlickerFeedFrame frame) {

		this.frame = frame;

	}

	public void run() {

		try {
			URL url = new URL(FEED_URL);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			final JsonReader jsonReader = new JsonReader(reader);
			jsonReader.setLenient(true);
			jsonReader.nextString();

			Gson g = new Gson();
			// JSonFlickrFeed f = g.fromJson(jsonReader, JSonFlickrFeed.class);
			Media media = g.fromJson(jsonReader, Media.class);
			feed = new FlickerFeed();
			frame.loadImages(feed);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
