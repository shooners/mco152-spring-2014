package teich.clock;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JPanel;

public class Clock extends JPanel {

	private int minutes;
	private int hours;
	private int seconds;

	public Clock() {
		GregorianCalendar time = new GregorianCalendar();
		hours = time.get(Calendar.HOUR);
		minutes = time.get(Calendar.MINUTE);
		seconds = time.get(Calendar.SECOND);
	}

	public void increaseSeconds() {
		seconds++;
		if (seconds == 60) {
			seconds = 00;
			minutes++;
			if (minutes == 60) {
				minutes = 00;
				hours++;
				if (hours == 13) {
					hours = 1;
				}
			}
		}
	}

	public double getMinuteAngle() {
		return (minutes * 6 - 90) * (Math.PI / 180);
	}

	public double getHourAngle() {
		return (30 * (hours + (getMinuteAngle() / 60)) - 90) * (Math.PI / 180);
	}

	public double getSecondsAngle() {
		return (seconds * 6 - 90) * (Math.PI / 180);
	}

	public String toString() {
		return hours + ":" + minutes + ":" + seconds + " " + getHourAngle()
				+ " :" + getMinuteAngle() + " :" + getSecondsAngle();
	}

	public int getMinutes() {
		return minutes;
	}

	public void paintComponent(Graphics pen) {
		int center1 = getWidth() / 2;
		int center2 = getHeight() / 2;
		int end1 = 50;
		int end2 = 50;

		pen.drawOval(center1 - 250, center2 - 250, 500, 500);

		Graphics2D g = (Graphics2D) pen;

		g.draw(new Line2D.Double(center1, center2, center1
				+ Math.cos(getHourAngle()) * 150, center2
				+ Math.sin(getHourAngle()) * 150));
		g.draw(new Line2D.Double(center1, center2, center1
				+ Math.cos(getMinuteAngle()) * 220, center2
				+ Math.sin(getMinuteAngle()) * 220));
		g.setColor(Color.RED);
		g.draw(new Line2D.Double(center1, center2, center1
				+ Math.cos(getSecondsAngle()) * 215, center2
				+ Math.sin(getSecondsAngle()) * 215));
	}
}
