package teich.force2d;

import org.junit.Assert;
import org.junit.Test;

public class Force2DTest {

	@Test
	public void testGetAngle() {
		Force2D force1 = new Force2D(2, 3);
		double expected = 56.31;
		double angle = force1.getAngle();

		Assert.assertEquals(expected, angle, 0.1);
	}

	@Test
	public void testGetMagnitude() {
		Force2D force2 = new Force2D(3.5, 5);
		double ex = 6.1033;
		double magnitude = force2.getMagnitude();

		Assert.assertEquals(ex, magnitude, 0.1);
	}

	@Test
	public void testAdd() {
		Force2D force3 = new Force2D(5.1, 2.25);
		Force2D force4 = new Force2D(3.2, 4);
		Force2D force5 = force3.add(force4);

		double expectedX = 8.3;
		double expectedY = 6.25;

		Assert.assertEquals(expectedX, force5.getX(), 0.1);
		Assert.assertEquals(expectedY, force5.getY(), 0.1);
	}

}
