package teich.triangle;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void testToString() {
		Triangle triangle = new Triangle(3);
		String expected = " *\n* *\n*****\n";
		String actual = triangle.toString();
		Assert.assertEquals(expected, actual);

	}

}
