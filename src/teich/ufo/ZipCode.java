package teich.ufo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ZipCode {

	private String zipCode;
	private double latitude;
	private double longitude;
	private String city;
	private String state;

	public ZipCode(String zip, double lat, double lon, String city, String state) {
		zipCode = zip;
		latitude = lat;
		longitude = lon;
		this.city = city;
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public boolean equals(String zip) {
		return this.zipCode.compareTo(zip) == 0;
	}

	@Override
	public String toString() {
		return "ZipCode: " + zipCode + ", city: " + city + ", state: " + state;
	}

	public static void main(String[] args) {
		try {
			ZipCodes zips = new ZipCodes();
			System.out.println(zips.getZipCodes());

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
