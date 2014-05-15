package teich.flicker;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class FlickerFeedFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;

	public FlickerFeedFrame() {
		this.setSize(500, 300);
		this.setTitle("Flicker");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label8 = new JLabel();

		JScrollPane scrollPane = new JScrollPane();

		Thread t1 = new DownloadFlickerFeedThread(this);
		t1.start();

		scrollPane.add(label1);
		/*
		 * scrollPane.add(label2); scrollPane.add(label3);
		 * scrollPane.add(label4); scrollPane.add(label5);
		 * scrollPane.add(label6); scrollPane.add(label7);
		 * scrollPane.add(label8);
		 */
		this.add(scrollPane.createHorizontalScrollBar(), BorderLayout.SOUTH);
		this.add(scrollPane.createVerticalScrollBar(), BorderLayout.EAST);
		this.add(scrollPane, BorderLayout.CENTER);
	}

	/**
	 * Runs a LoadImageThread for each image in the feed
	 */
	public void loadImages(final FlickerFeed feed) {
		try {
			Item[] items = feed.getF().getItems();
			for (int i = 0; i < 20; i++) {
				Media media = items[i].getMedia();
				String m = media.getM();
				Thread t = new DownloadImageThread(label1, m);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(final String args[]) {

		new FlickerFeedFrame().setVisible(true);
	}

}
