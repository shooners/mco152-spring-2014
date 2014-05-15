package teich.dictionary;

import java.io.FileNotFoundException;

import junit.framework.Assert;

import org.junit.Test;

public class DictionaryTest {

	@Test
	public void testExists() throws FileNotFoundException {

		Dictionary dictionary;

		dictionary = new Dictionary();

		String word = "AA";
		boolean w = dictionary.exists(word);

		Assert.assertTrue(w);

	}

	@Test
	public void testFalse() throws FileNotFoundException {
		Dictionary d;

		d = new Dictionary();

		String ex = "0";
		boolean e = d.exists(ex);

		Assert.assertFalse(e);
	}
}
