package teich.stocks;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AmexDataTest {

	@Test
	public void testContains() throws IOException {
		AmexData data = new AmexData();
		boolean contains = data.contains("AIP");
		Assert.assertTrue(contains);
		boolean found = data.contains("ZCS");
		Assert.assertFalse(found);
		boolean contain = data.contains("dsi");
		Assert.assertTrue(contain);
	}

	@Test
	public void testGetPrices() throws IOException {
		AmexData data = new AmexData();
		List<DailyPrice> list = data.getPrices("AIP");
		for (DailyPrice dp : list) {
			Assert.assertEquals("AIP", dp.getSymbol());
		}
	}

	@Test
	public void testGetPrices2() throws IOException {
		AmexData data = new AmexData();
		Date start = new Date();
		Date end = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
		try {
			start = f.parse("2/1/2010");
			end = f.parse("2/8/2010");
		} catch (ParseException e) {
			e.getMessage();
		}
		List<DailyPrice> list = data.getPrices("AIP", start, end);
		for (DailyPrice dp : list) {
			Assert.assertEquals("AIP", dp.getSymbol());
			Assert.assertTrue(dp.getDate().compareTo(start) >= 0
					|| dp.getDate().compareTo(end) <= 0);
		}
	}
}
