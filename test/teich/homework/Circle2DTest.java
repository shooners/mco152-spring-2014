package teich.homework;

import org.junit.Assert;
import org.junit.Test;

public class Circle2DTest {

	@Test
	public void testArea() {

		Circle2D circle = new Circle2D(2, 3, 4);
		double expected = Math.PI * 16;
		double area = circle.getArea();

		Assert.assertEquals(expected, area, 0.1);
	}

	@Test
	public void testPerimeter() {

		Circle2D c = new Circle2D(2, 3, 4);
		double expected = 2 * Math.PI * 4;
		double perimeter = c.getPerimeter();

		Assert.assertEquals(expected, perimeter, 0.1);
	}

	@Test
	public void testContainsPoint() {

		Circle2D c1 = new Circle2D(2, 3, 4);
		boolean contains = c1.contains(1, 1);

		Assert.assertTrue(contains);
	}

	@Test
	public void testContainsCircle() {

		Circle2D c2 = new Circle2D(2, 3, 4);
		Circle2D circ = new Circle2D(3, 1, 1);
		boolean contains = c2.contains(circ);

		Assert.assertFalse(contains);
	}

	@Test
	public void testOverlapsCircle() {

		Circle2D c3 = new Circle2D(2, 3, 4);
		boolean overlaps = c3.overlaps(new Circle2D(1, 2, 3));

		Assert.assertFalse(overlaps);
	}

}
