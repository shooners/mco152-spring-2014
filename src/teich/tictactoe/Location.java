package teich.tictactoe;


public class Location {

	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean equals(Location l) {
		return (l.getX() == this.x && l.getY() == this.y);
	}
}
