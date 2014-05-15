package teich.flicker;

import java.io.IOException;

/**
 * The class that represents the json feed from Flicker
 */
public class FlickerFeed {

	// TODO: add code here

	private Media media;
	private JSonFlickrFeed f;

	public FlickerFeed() throws IOException {

	}

	public Media getMedia() {
		return media;
	}

	public JSonFlickrFeed getF() {
		return f;
	}

}
