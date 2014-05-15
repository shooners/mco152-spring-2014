package teich.homework;

public class Circle2D {

	private double x;
	private double y;
	private double radius;

	public Circle2D() {
		x = 0;
		y = 0;
		radius = 1;
	}

	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	public boolean contains(double x, double y) {
		double difX = x - this.x;
		double difY = y - this.y;
		double squareRoot = Math.sqrt((difX * difX) + (difY * difY));
		return squareRoot < radius;
	}

	public boolean contains(Circle2D circle) {
		double distance = Math
				.sqrt((circle.getX() - this.x * circle.getX() - this.x)
						+ (circle.getY() - this.y * circle.getY() - this.y));
		return distance + circle.getRadius() < this.radius;
	}

	public boolean overlaps(Circle2D circle) {
		double distance = Math
				.sqrt((circle.getX() - this.x * circle.getX() - this.x)
						+ (circle.getY() - this.y * circle.getY() - this.y));
		double sum = this.radius + circle.getRadius();
		return distance < sum;

	}
}
