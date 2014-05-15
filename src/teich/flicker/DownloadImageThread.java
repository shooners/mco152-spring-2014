package teich.flicker;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Loads a single image from a url into a JLabel
 */
public class DownloadImageThread extends Thread {

	private String pic;
	private JLabel label;

	public DownloadImageThread(final JLabel label, final String url)
			throws IOException {
		StringTokenizer token = new StringTokenizer(url, "/");
		String pic = null;
		while (token.hasMoreTokens()) {
			pic = token.nextToken();
		}
		this.label = label;
	}

	public void run() {
		ImageIcon image = new ImageIcon(pic);
		label.setIcon(image);
	}
}
