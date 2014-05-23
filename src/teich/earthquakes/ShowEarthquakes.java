package teich.earthquakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import com.google.gson.Gson;

public class ShowEarthquakes extends JFrame implements Runnable {

	public ArrayList<Earthquake> listEarthquakes;

	private JList showList;
	private DefaultListModel listModel;

	public ShowEarthquakes() {
		setSize(400, 600);
		setTitle("Earthquakes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		listEarthquakes = new ArrayList<Earthquake>();
		listModel = new DefaultListModel();
		showList = new JList(listModel);
		showList.setLayoutOrientation(JList.VERTICAL);
		this.add(showList);
		Thread t = new Thread(this);
		t.start();

	}

	@Override
	public void run() {

		try {
			URL url = new URL(
					"http://earthquake-report.com/feeds/recent-eq?json");
			URLConnection connect = url.openConnection();
			InputStream in = connect.getInputStream();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			Gson gson = new Gson();

			ListEarthquakes list = gson.fromJson(reader, ListEarthquakes.class);
			for (Earthquake e : list) {
				listEarthquakes.add(e);
				System.out.println(listEarthquakes);
			}

			for (Earthquake e : listEarthquakes) {
				listModel.addElement(e);
			}
			revalidate();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		ShowEarthquakes frame = new ShowEarthquakes();
		frame.setVisible(true);
	}
}
