package teich.force2d;

public class Force2D {

	private double x;
	private double y;

	public Force2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getMagnitude() {
		return Math.sqrt(x * x + y * y);
	}

	public double getAngle() {
		double radians = Math.atan2(y, x);
		return radians * (180 / Math.PI);
	}

	public Force2D add(Force2D force) {
		double sumX = this.x + force.x;
		double sumY = this.y + force.y;
		Force2D force2D = new Force2D(sumX, sumY);
		return force2D;
	}
}
